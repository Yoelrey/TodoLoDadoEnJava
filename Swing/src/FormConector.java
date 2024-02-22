// Importar las clases necesarias para la interfaz gráfica y la conexión a la base de datos
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// Definir la clase FormConector que extiende JFrame
public class FormConector extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFieldServidor;
    private JTextField txtFieldPuerto;
    private JTextField txtFieldUser;
    private JPasswordField passwordField;
    private JComboBox comboBox;

    /**
     * Método principal que lanza la aplicación.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormConector frame = new FormConector();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor de la clase que crea la interfaz gráfica.
     */
    public FormConector() {
        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Componentes de la interfaz gráfica
        JLabel lblNewLabel = new JLabel("Servidor y puerto");
        lblNewLabel.setBounds(42, 53, 116, 16);
        contentPane.add(lblNewLabel);

        txtFieldServidor = new JTextField();
        txtFieldServidor.setText("localhost");
        txtFieldServidor.setBounds(170, 48, 136, 26);
        contentPane.add(txtFieldServidor);
        txtFieldServidor.setColumns(10);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(42, 90, 61, 16);
        contentPane.add(lblUsuario);

        txtFieldPuerto = new JTextField();
        txtFieldPuerto.setText("3306");
        txtFieldPuerto.setColumns(10);
        txtFieldPuerto.setBounds(318, 48, 61, 26);
        contentPane.add(txtFieldPuerto);

        txtFieldUser = new JTextField();
        txtFieldUser.setText("root");
        txtFieldUser.setBounds(170, 86, 130, 26);
        contentPane.add(txtFieldUser);
        txtFieldUser.setColumns(10);

        JLabel lblContrasea = new JLabel("Contraseña");
        lblContrasea.setBounds(42, 130, 94, 16);
        contentPane.add(lblContrasea);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 124, 130, 26);
        contentPane.add(passwordField);

        comboBox = new JComboBox();
        comboBox.setEnabled(false);
        comboBox.setBounds(170, 170, 130, 27);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Conectar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados por el usuario
                String host = txtFieldServidor.getText();
                String user = txtFieldUser.getText();
                String puerto = txtFieldPuerto.getText();
                
                // Obtener la contraseña como un array de caracteres y convertirlo a String
                char[] password = passwordField.getPassword();
                String pass = new String(password);
                
                // Crear una instancia de ConexionBD para establecer la conexión
                ConexionBD miConexion = new ConexionBD(host, puerto, user, pass);
                Connection con = miConexion.getCon();
                
                try {
                    // Crear una declaración SQL y ejecutarla para obtener las bases de datos disponibles
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SHOW DATABASES");
                    
                    // Iterar sobre los resultados y agregarlos al JComboBox
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                        comboBox.addItem(rs.getString(1));
                    }
                    
                    // Habilitar el JComboBox después de obtener las bases de datos
                    comboBox.setEnabled(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(305, 219, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblBD = new JLabel("Base de datos");
        lblBD.setEnabled(false);
        lblBD.setBounds(42, 174, 94, 16);
        contentPane.add(lblBD);
    }
}

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.TextArea;
import javax.swing.JScrollPane;

public class Conexion extends JFrame {

    private JPanel contentPane;
    private JTextField fieldUser;
    private JPasswordField passwordField;
    private JTextField fieldPuerto;
    private JLabel lblNewLabel_3;
    private JTextField fieldServer;
    private JComboBox<String> comboBox;
    private Connection con;
    private TextArea textArea;
    private String nombreBBDD;
    private JButton btnConsulta;
    private JComboBox<String> comboTablas;
    private JLabel lblNewLabel_6;
    private JTable table;
    private JTable ta;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Conexion frame = new Conexion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Conexion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 469);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiquetas y campos de texto para la conexión
        JLabel lblNewLabel = new JLabel("User:");
        lblNewLabel.setBounds(37, 37, 95, 30);
        contentPane.add(lblNewLabel);

        fieldUser = new JTextField();
        fieldUser.setText("root");
        fieldUser.setBounds(125, 42, 86, 20);
        contentPane.add(fieldUser);
        fieldUser.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Contraseña:");
        lblNewLabel_1.setBounds(39, 71, 75, 13);
        contentPane.add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(124, 70, 86, 20);
        contentPane.add(passwordField);

        fieldPuerto = new JTextField();
        fieldPuerto.setText("3306");
        fieldPuerto.setBounds(320, 67, 86, 20);
        contentPane.add(fieldPuerto);
        fieldPuerto.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Puerto:");
        lblNewLabel_2.setBounds(261, 70, 46, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Servidor: ");
        lblNewLabel_3.setBounds(261, 45, 69, 14);
        contentPane.add(lblNewLabel_3);

        fieldServer = new JTextField();
        fieldServer.setText("localhost");
        fieldServer.setBounds(320, 42, 86, 20);
        contentPane.add(fieldServer);
        fieldServer.setColumns(10);

        // Botón de conexión
        JButton btnConectar = new JButton("Conectar");
        btnConectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
                conectarBBDD();
            }
        });
        
        // Configuración de la tabla y el scrollPane para mostrar los resultados
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 245, 280, 160);
        contentPane.add(scrollPane);
        ta = new JTable();
        scrollPane.setViewportView(ta);
        btnConectar.setBounds(446, 45, 89, 23);
        contentPane.add(btnConectar);

        // ComboBox para seleccionar la base de datos
        comboBox = new JComboBox<String>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nombreBBDD = (String) comboBox.getSelectedItem();
            }
        });
        comboBox.setBounds(215, 120, 75, 23);
        contentPane.add(comboBox);

        // TextArea para mostrar consultas y resultados
        textArea = new TextArea();
        textArea.setBounds(298, 245, 275, 160);
        contentPane.add(textArea);

        // Botón para ejecutar consultas
        btnConsulta = new JButton("Ejecturar consulta");
        btnConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (con != null) {
                    textArea.setText("");
                    ejecutarConsultaSelectAll(nombreBBDD);
                    ta.getColumn(nombreBBDD);
                } else
                    JOptionPane.showMessageDialog(null, "La conexión todavía no se ha realizado.");
            }
        });
        btnConsulta.setBounds(175, 184, 155, 57);
        contentPane.add(btnConsulta);

        JLabel lblNewLabel_5 = new JLabel("Tablas");
        lblNewLabel_5.setBounds(165, 160, 46, 14);
        contentPane.add(lblNewLabel_5);

        // ComboBox para seleccionar tablas
        comboTablas = new JComboBox<String>();
        comboTablas.setBounds(215, 158, 112, 18);
    }}
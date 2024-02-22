package ConexionJdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;

public class FormConector extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFieldServidor;
    private JTextField txtFieldPuerto;
    private JTextField txtFieldUser;
    private JPasswordField passwordField;
    private JComboBox comboBox;
    private JPanel panel;

    // Main method to launch the application
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

    // Constructor for the JFrame
    public FormConector() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Servidor y puerto");
        lblNewLabel.setBounds(42, 53, 116, 16);
        contentPane.add(lblNewLabel);

        // Text field for entering the server address
        txtFieldServidor = new JTextField();
        txtFieldServidor.setText("localhost");
        txtFieldServidor.setBounds(170, 48, 136, 26);
        contentPane.add(txtFieldServidor);
        txtFieldServidor.setColumns(10);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(42, 90, 61, 16);
        contentPane.add(lblUsuario);

        // Panel for entering the port number
        panel = new JPanel();
        panel.setBounds(318, 48, 61, 26);
        contentPane.add(panel);
        panel.setLayout(null);

        // Text field for entering the port number
        txtFieldPuerto = new JTextField();
        txtFieldPuerto.setBounds(0, 0, 61, 26);
        panel.add(txtFieldPuerto);
        txtFieldPuerto.setText("3306");
        txtFieldPuerto.setColumns(10);

        // Text field for entering the database user
        txtFieldUser = new JTextField();
        txtFieldUser.setText("root");
        txtFieldUser.setBounds(170, 86, 130, 26);
        contentPane.add(txtFieldUser);
        txtFieldUser.setColumns(10);

        JLabel lblContrasea = new JLabel("Contraseña");
        lblContrasea.setBounds(42, 130, 94, 16);
        contentPane.add(lblContrasea);

        // Password field for entering the database password
        passwordField = new JPasswordField();
        passwordField.setBounds(170, 124, 130, 26);
        contentPane.add(passwordField);

        // Combo box for selecting the database
        comboBox = new JComboBox();
        comboBox.setEnabled(false);
        comboBox.setBounds(170, 170, 130, 27);
        contentPane.add(comboBox);

        // Button for connecting to the database
        JButton btnNewButton = new JButton("Conectar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields and password field
                String host = txtFieldServidor.getText();
                String user = txtFieldUser.getText();
                String puerto = txtFieldPuerto.getText();
                char[] password = passwordField.getPassword();
                String pass = new String(password);

                // Print the SELECT query with the host (which is incorrect)
                System.out.println("SELECT * FROM" + host);

                // Create a database connection object
                ConexionBD miConexion = new ConexionBD(host, puerto, user, pass);
                Connection con = miConexion.getCon();

                // Validate the port number
                validatePort();

                try {
                    // Create a statement and execute a query to get database names
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SHOW DATABASES");

                    // Print and add database names to the combo box
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                        comboBox.addItem(rs.getString(1));
                    }

                    // Enable the combo box after fetching the database names
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

    // Method to validate the port number
    private boolean validatePort() {
        try {
            int port = Integer.parseInt(txtFieldPuerto.getText());
            if (port < 0 || port > 65535) {
                JOptionPane.showMessageDialog(this, "Port must be between 0 and 65535", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Port must be a numeric value", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

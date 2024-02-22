package ConsultasPreparadas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ConsultaCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textFieldFechaDesde;
    private JTextField textFieldFechaHasta;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConsultaCliente frame = new ConsultaCliente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConsultaCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre cliente");
        lblNewLabel.setBounds(43, 40, 96, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(154, 35, 170, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("CONSULTAR");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Establece la conexión a la base de datos
                ConexionBD con = new ConexionBD("localhost", "3306", "root", "");
                try {
                    Statement st = con.getCon().createStatement();
                    st.execute("USE northwind;");

                    // Define la consulta preparada con parámetros
                    String consulta = "SELECT * FROM orders WHERE customerID=? AND orderDate BETWEEN ? AND ?";
                    PreparedStatement ps = con.getCon().prepareStatement(consulta);

                    // Establece el primer parámetro (nombre del cliente)
                    ps.setString(1, textField.getText());

                    // Procesa y establece la primera fecha
                    String fechaEnTextoDesde = textFieldFechaDesde.getText();
                    fechaEnTextoDesde += " 00:00:00";
                    SimpleDateFormat formatoDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.util.Date fechaParsedDesde = formatoDesde.parse(fechaEnTextoDesde);
                    java.sql.Timestamp fechaSqlDesde = new java.sql.Timestamp(fechaParsedDesde.getTime());
                    ps.setTimestamp(2, fechaSqlDesde);

                    // Procesa y establece la segunda fecha
                    String fechaEnTextoHasta = textFieldFechaHasta.getText();
                    fechaEnTextoHasta += " 23:59:59";
                    SimpleDateFormat formatoHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.util.Date fechaParsedHasta = formatoHasta.parse(fechaEnTextoHasta);
                    java.sql.Timestamp fechaSqlHasta = new java.sql.Timestamp(fechaParsedHasta.getTime());
                    ps.setTimestamp(3, fechaSqlHasta);

                    // Ejecuta la consulta preparada
                    ResultSet rs = ps.executeQuery();

                    // Obtiene los metadatos del resultado
                    ResultSetMetaData rsmd = rs.getMetaData();

                    // Muestra los resultados en la consola
                    while (rs.next()) {
                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                            System.out.print(rs.getObject(i) + " ");
                        }
                        System.out.println();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(285, 104, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblFechaDesde = new JLabel("Fecha desde");
        lblFechaDesde.setBounds(43, 76, 96, 16);
        contentPane.add(lblFechaDesde);

        JLabel lblFechaHasta = new JLabel("Fecha hasta");
        lblFechaHasta.setBounds(43, 109, 96, 16);
        contentPane.add(lblFechaHasta);

        textFieldFechaDesde = new JTextField();
        textFieldFechaDesde.setBounds(154, 73, 96, 26);
        contentPane.add(textFieldFechaDesde);
        textFieldFechaDesde.setColumns(10);

        textFieldFechaHasta = new JTextField();
        textFieldFechaHasta.setColumns(10);
        textFieldFechaHasta.setBounds(154, 104, 96, 26);
        contentPane.add(textFieldFechaHasta);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(43, 158, 385, 97);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }
}

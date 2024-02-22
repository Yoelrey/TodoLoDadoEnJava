
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

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(37, 37, 95, 30);
		contentPane.add(lblNewLabel);

		fieldUser = new JTextField();
		fieldUser.setText("root");
		fieldUser.setBounds(125, 42, 86, 20);
		contentPane.add(fieldUser);
		fieldUser.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
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

		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBox.removeAllItems();
				conectarBBDD();

			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 280, 160);
		contentPane.add(scrollPane);
		ta = new JTable();
		scrollPane.setViewportView(ta);
		btnConectar.setBounds(446, 45, 89, 23);
		contentPane.add(btnConectar);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nombreBBDD = (String) comboBox.getSelectedItem();

			}
		});
		comboBox.setBounds(215, 120, 75, 23);
		contentPane.add(comboBox);

		textArea = new TextArea();
		textArea.setBounds(298, 245, 275, 160);
		contentPane.add(textArea);

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

		comboTablas = new JComboBox<String>();

		comboTablas.setBounds(215, 158, 112, 18);
		contentPane.add(comboTablas);

		lblNewLabel_6 = new JLabel("BBDD:");
		lblNewLabel_6.setBounds(165, 124, 46, 14);
		contentPane.add(lblNewLabel_6);

		JButton btnObtener = new JButton("Obtener tablas");
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (con != null) {

					comboTablas.removeAllItems();
					obtenerTablas(nombreBBDD);

				} else
					JOptionPane.showMessageDialog(null, "La conexión todavía no se ha realizado.");

			}
		});
		btnObtener.setBounds(330, 120, 131, 23);
		contentPane.add(btnObtener);
		
		
	}

	public void obtenerTablas(String nombreBBDD) {

		try {
			Statement s = con.createStatement();

			s.execute("USE " + nombreBBDD);
			ResultSet rs = s.executeQuery("SHOW TABLES");

			while (rs.next()) {
				comboTablas.addItem(rs.getString(1));
			}
			comboTablas.setVisible(true);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void ejecutarConsultaSelectAll(String nombre) {

// System.out.println(nombre);
		String query = "SELECT * FROM " + (String) comboTablas.getSelectedItem();
		String resultado = "";

		try {

			Statement s = con.createStatement();

			s.execute("USE " + nombre);
			ResultSet rs = s.executeQuery(query);
			ResultSetMetaData rsm = rs.getMetaData();
			int max = rsm.getColumnCount();
			while (rs.next()) {

				for (int i = 1; i <= max; i++) {

					resultado += "\n" + rs.getString(i) + " -----";

				}
			}

			textArea.append(resultado);
// con.close();

		} catch (SQLException e) {
// TODO Auto-generated catch block

			JOptionPane.showInternalMessageDialog(null, "Error al ejecutar la consulta.");
		}

	}

	public void conectarBBDD() {
		try {
			String host = fieldServer.getText();
			String puerto = fieldPuerto.getText();
			String user = fieldUser.getText();
			char[] passwordChars = passwordField.getPassword();
			String passwd = new String(passwordChars);

// Verifica que los campos obligatorios no estén vacíos
			if (host.isEmpty() || puerto.isEmpty() || user.isEmpty() || passwd.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
				return;
			}

			Arrays.fill(passwordChars, ' ');

			con = new ConexionBD(host, puerto, user, passwd).getCon();
			if (con != null) {

				Statement s = con.createStatement();
				passwd = "";

				ResultSet rs = s.executeQuery("SHOW DATABASES");

				while (rs.next()) {
					comboBox.addItem(rs.getString(1));
				}
				comboBox.setVisible(true);
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error al realizar la consulta.");

		}

	}
}
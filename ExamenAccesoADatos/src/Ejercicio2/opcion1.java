package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class opcion1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcion1 frame = new opcion1();
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
	public opcion1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(154, 189, 85, 21);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton llamar = new JButton("ejecutar");
		llamar.setBounds(0, 0, 85, 21);
		panel.add(llamar);
		
		JScrollPane consulta = new JScrollPane();
		consulta.setBounds(108, 28, 190, 140);
		contentPane.add(consulta);
		
		table_1 = new JTable();
		consulta.setViewportView(table_1);
		llamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionBD con = new ConexionBD("localhost", "3306", "root", "");
            try {
                Statement st = con.getCon().createStatement();
                st.execute("USE northwind;");

                // Define la consulta preparada con parámetros
                String consulta = "SELECT ProductName FROM Products";
                PreparedStatement ps = con.getCon().prepareStatement(consulta);

                // Establece el primer parámetro (nombre del cliente)
               

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
            }
        }
		});
		
	}
}

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lado1;
	private JTextField lado2;
	private JTextField lado3;
	public Double lados1;
	public Double lados2;	
	public Double lados3;
	public Double resultado1;
	public Double resultadoF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
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
	public Ejercicio3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa el lado 1");
		lblNewLabel.setBounds(10, 33, 108, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngresaElLado_2 = new JLabel("Ingresa el lado 2");
		lblIngresaElLado_2.setBounds(10, 63, 108, 13);
		contentPane.add(lblIngresaElLado_2);
		
		JLabel lblIngresaElLado_3 = new JLabel("Ingresa el lado 3");
		lblIngresaElLado_3.setBounds(10, 93, 108, 13);
		contentPane.add(lblIngresaElLado_3);
		
		lado1 = new JTextField();
		lado1.setBounds(104, 30, 96, 19);
		contentPane.add(lado1);
		lado1.setColumns(10);
		
		lado2 = new JTextField();
		lado2.setBounds(104, 60, 96, 19);
		contentPane.add(lado2);
		lado2.setColumns(10);
		
		JLabel resultado = new JLabel("El area del triangulo:");
		resultado.setBounds(10, 179, 169, 13);
		contentPane.add(resultado);
		
		lado3 = new JTextField();
		lado3.setBounds(104, 86, 96, 19);
		contentPane.add(lado3);
		lado3.setColumns(10);
		
		JButton Calcular = new JButton("Calcular");
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text1= lado1.getText();
					lados1=Double.parseDouble(text1);
					String text2= lado2.getText();
					lados2=Double.parseDouble(text2);
					String text3= lado3.getText();
					lados3=Double.parseDouble(text3);
				}catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null,"Deben ser todos numeros");
				}
				resultado1=(lados1+lados2+lados3)/2;
				resultadoF=Math.sqrt(resultado1*(resultado1-lados1)*(resultado1-lados2)*(resultado1-lados3));
				
				resultado.setText(Double.toString(Math.round(resultadoF)));
			}
			
		});
		Calcular.setBounds(266, 29, 85, 21);
		contentPane.add(Calcular);
		
		JButton btnNewButton = new JButton("reiniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lado1.setText("");
				lado2.setText("");
				lado3.setText("");
				resultado.setText("");
			}
		});
		btnNewButton.setBounds(266, 89, 85, 21);
		contentPane.add(btnNewButton);
		
		String[] Color= {"Rojo","Azul"};
		String[] gente= {"Pepe","yowas"};
		
		JList list = new JList(Color);
		list.setListData(Color);
		list.setBounds(239, 160, 135, 82);
		contentPane.add(list);
		
	
	}
}

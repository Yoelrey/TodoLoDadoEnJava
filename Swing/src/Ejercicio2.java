import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public Double[]digitos= {1.,2.,3.,4.,5.,6.,7.,8.,9.,0.};
	public int []digito= {1,2,3,4,5,6,7,8,9,0};
	public Double radio;
	 public Double altura;
	 public Double area;
	 public Double volumen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
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
	public Ejercicio2() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(109, 29, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ingresar el radio");
		lblNewLabel.setBounds(10, 30, 93, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ingresar la altura");
		lblNewLabel_1.setBounds(10, 100, 93, 13);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(109, 97, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Volumen");
		lblNewLabel_2.setBounds(58, 164, 45, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Area");
		lblNewLabel_3.setBounds(58, 206, 45, 13);
		contentPane.add(lblNewLabel_3);

		JLabel ResultadoVolumen = new JLabel("");
		ResultadoVolumen.setBounds(128, 164, 161, 13);
		contentPane.add(ResultadoVolumen);

		JLabel ResultadoArea = new JLabel("");
		ResultadoArea.setBounds(140, 206, 149, 13);
		contentPane.add(ResultadoArea);

		

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Volumen = ∗ adio^2*altura
				String text1 = textField.getText();
				try {
					radio = Double.parseDouble(text1);
					String text2 = textField_1.getText();
					altura = Double.parseDouble(text2);
					volumen =  Math.PI* (radio *radio)* altura;
					area = radio * 2 * altura;
				} catch (NumberFormatException e1) {
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
					
				}
				
				ResultadoVolumen.setText("Resultado: " + Double.toString(Math.round(volumen)));
				// Área= 2 ∗ ∗ adio*altura
				
				ResultadoArea.setText("Resultado: " + Double.toString(Math.round(area)));
			}
		});
		btnNewButton.setBounds(291, 28, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				ResultadoArea.setText("");
				ResultadoVolumen.setText("");
			}
		});
		btnNewButton_1.setBounds(291, 96, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}

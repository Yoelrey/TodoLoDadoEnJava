import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ejercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField punto1X;
	private JTextField punto1Y;
	private JTextField punto2X;
	private JTextField punto2Y;
	private JTextField punto3X;
	private JTextField punto3Y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar el punto 1:");
		lblNewLabel.setBounds(0, 38, 127, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar el punto 2:");
		lblNewLabel_1.setBounds(0, 89, 127, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingresar el punto 3:");
		lblNewLabel_2.setBounds(0, 136, 127, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Coordenada X");
		lblNewLabel_3.setBounds(117, 10, 114, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Coordenada Y");
		lblNewLabel_4.setBounds(269, 10, 114, 13);
		contentPane.add(lblNewLabel_4);
		
		punto1X = new JTextField();
		punto1X.setBounds(105, 35, 96, 19);
		contentPane.add(punto1X);
		punto1X.setColumns(10);
		
		punto1Y = new JTextField();
		punto1Y.setBounds(255, 35, 96, 19);
		contentPane.add(punto1Y);
		punto1Y.setColumns(10);
		
		punto2X = new JTextField();
		punto2X.setBounds(105, 86, 96, 19);
		contentPane.add(punto2X);
		punto2X.setColumns(10);
		
		punto2Y = new JTextField();
		punto2Y.setBounds(255, 86, 96, 19);
		contentPane.add(punto2Y);
		punto2Y.setColumns(10);
		
		punto3X = new JTextField();
		punto3X.setBounds(105, 133, 96, 19);
		contentPane.add(punto3X);
		punto3X.setColumns(10);
		
		punto3Y = new JTextField();
		punto3Y.setBounds(255, 133, 96, 19);
		contentPane.add(punto3Y);
		punto3Y.setColumns(10);
		
		JButton calcular = new JButton("Calcular");
		calcular.setBounds(10, 180, 85, 21);
		contentPane.add(calcular);
		
		JButton reset = new JButton("Reiniciar");
		reset.setBounds(156, 180, 85, 21);
		contentPane.add(reset);
		
		JLabel Resultado = new JLabel("El valor del perimetro:");
		Resultado.setBounds(27, 223, 266, 19);
		contentPane.add(Resultado);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej03Swing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLado1;
	private JTextField textFieldLado2;
	private JTextField textFieldLado3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej03Swing frame = new Ej03Swing("EJERCICIO 3");
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
	public Ej03Swing(String titulo) {
		super(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 384);
		contentPane = new JPanel();
		contentPane.setName("calcular");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar el lado 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(58, 104, 172, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngresarElLado = new JLabel("Ingresar el lado 2");
		lblIngresarElLado.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblIngresarElLado.setBounds(58, 152, 172, 26);
		contentPane.add(lblIngresarElLado);
		
		JLabel lblIngresarElLado_1 = new JLabel("Ingresar el lado 3");
		lblIngresarElLado_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblIngresarElLado_1.setBounds(58, 202, 172, 26);
		contentPane.add(lblIngresarElLado_1);
		
		JLabel lblResultado = new JLabel("El áreal del triángulo");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblResultado.setBounds(58, 287, 535, 26);
		contentPane.add(lblResultado);
		
		textFieldLado1 = new JTextField();
		textFieldLado1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if (c == '.' && textFieldLado1.getText().contains(".")) {
                    e.consume(); // Ignora el evento si ya hay un punto en el texto
                } else if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignora el evento si no es un dígito, un punto o una tecla de retroceso
                }
			}
		});
		textFieldLado1.setBounds(238, 111, 143, 19);
		contentPane.add(textFieldLado1);
		textFieldLado1.setColumns(10);
		
		textFieldLado2 = new JTextField();
		textFieldLado2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if (c == '.' && textFieldLado2.getText().contains(".")) {
                    e.consume(); // Ignora el evento si ya hay un punto en el texto
                } else if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignora el evento si no es un dígito, un punto o una tecla de retroceso
                }
			}
		});
		textFieldLado2.setColumns(10);
		textFieldLado2.setBounds(240, 159, 143, 19);
		contentPane.add(textFieldLado2);
		
		textFieldLado3 = new JTextField();
		textFieldLado3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if (c == '.' && textFieldLado3.getText().contains(".")) {
                    e.consume(); // Ignora el evento si ya hay un punto en el texto
                } else if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignora el evento si no es un dígito, un punto o una tecla de retroceso
                }
			}
		});
		
		textFieldLado3.setColumns(10);
		textFieldLado3.setBounds(238, 209, 143, 19);
		contentPane.add(textFieldLado3);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textFieldLado1.getText()!="")&&(textFieldLado2.getText()!="")&&(textFieldLado3.getText()!="")){
					if(esTriangulo(Double.parseDouble(textFieldLado1.getText()),Double.parseDouble(textFieldLado2.getText()),Double.parseDouble(textFieldLado3.getText()))){
						lblResultado.setText("El área del triángulo es: "+(Double.parseDouble(textFieldLado1.getText())*Double.parseDouble(textFieldLado2.getText())/2));
					}else{
						lblResultado.setText("No es un triángulo");
					}
				}
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setBounds(473, 110, 120, 20);
		contentPane.add(btnCalcular);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setName("reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLado1.setText("");
				textFieldLado2.setText("");
				textFieldLado3.setText("");
				lblResultado.setText("El área del triángulo ");
			}
		});
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReiniciar.setBounds(473, 208, 120, 20);
		contentPane.add(btnReiniciar);
	}
	private boolean esTriangulo(double a,double b, double c){
		return((a + b > c && a + c > b && b + c > a));
		
	}
}
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoAorcado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField palabra;
	private JTextField letraIntroducida;
	protected String Palabra;
	protected char letra;

	/**
	 * Launch the application.
	 * @return 
	 */
	 public static  String ocultarPalabra(String palabra, int index, char letra) {
	        StringBuilder resultado = new StringBuilder();

	        for (int i = 0; i < palabra.length(); i++) {
	            if (i == index) {
	                resultado.append(letra);
	            } else {
	                resultado.append("_");
	            }
	        }
	        return resultado.toString();

	 }

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoAorcado frame = new JuegoAorcado();
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
	public JuegoAorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		palabra = new JTextField();
		palabra.setBounds(140, 24, 96, 19);
		contentPane.add(palabra);
		palabra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduce palabra:");
		lblNewLabel.setBounds(10, 27, 120, 13);
		contentPane.add(lblNewLabel);
		
		letraIntroducida = new JTextField();
		letraIntroducida.setBounds(10, 71, 96, 19);
		contentPane.add(letraIntroducida);
		letraIntroducida.setColumns(10);
		
		
		
		JButton guardarPalabra = new JButton("Guarga la palabra");
		guardarPalabra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Palabra = palabra.getText();
				palabra.setText("");
			}
		});
		JButton probarLetra = new JButton("Probar Letra");
		probarLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     for (int i = 0; i < Palabra.length(); i++) {
			            char letra = Palabra.charAt(i);
			            char adivinanza = '_'; // Inicialmente, muestra un guion bajo.

			            while (adivinanza != letra) {
			                System.out.println("Palabra actual: " + ocultarPalabra(Palabra, i, adivinanza));
			                System.out.print("Adivina la letra: ");
			                adivinanza = letra.charAt(0);
			}
			     }
			}
		});
		probarLetra.setBounds(112, 70, 124, 21);
		contentPane.add(probarLetra);
		guardarPalabra.setBounds(257, 23, 158, 21);
		contentPane.add(guardarPalabra);
		
		JLabel letrasCorrectas = new JLabel("Letras correctas: ");
		letrasCorrectas.setBounds(10, 117, 191, 26);
		contentPane.add(letrasCorrectas);
		
		JLabel letrasIncorrectas = new JLabel("Letras incorrectas");
		letrasIncorrectas.setBounds(10, 186, 226, 13);
		contentPane.add(letrasIncorrectas);
	}
}

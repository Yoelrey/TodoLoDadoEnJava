import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ej08Swing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSalario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/*
	 * JLabel lblSalarioAnterior; JLabel lblSalarioTotal; JLabel lblPorcAumento;
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej08Swing frame = new Ej08Swing();
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
	public Ej08Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar el importe salarial");
		lblNewLabel.setBounds(33, 42, 179, 16);
		contentPane.add(lblNewLabel);
		
		textFieldSalario = new JTextField();
		textFieldSalario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if ((!Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    e.consume(); // Ignora el evento de teclado si no es un dígito, retroceso o punto
                }
                if (c == '.' && textFieldSalario.getText().contains(".")) {
                    e.consume(); // Ignora el evento de teclado si ya hay un punto en el texto
                }
			}
		});
		textFieldSalario.setBounds(224, 37, 130, 26);
		contentPane.add(textFieldSalario);
		textFieldSalario.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Nivel acad\u00E9mico", TitledBorder.CENTER, TitledBorder.TOP, null, UIManager.getColor("Button.light")));
		panel.setBounds(43, 77, 328, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnLicenciatura = new JRadioButton("Licenciatura");
		buttonGroup.add(rdbtnLicenciatura);
		rdbtnLicenciatura.setBounds(6, 18, 141, 23);
		panel.add(rdbtnLicenciatura);
		
		JRadioButton rdbtnMaestria = new JRadioButton("Maestria");
		buttonGroup.add(rdbtnMaestria);
		rdbtnMaestria.setBounds(6, 55, 141, 23);
		panel.add(rdbtnMaestria);
		
		JRadioButton rdbtnMaestria_1 = new JRadioButton("Maestria");
		buttonGroup.add(rdbtnMaestria_1);
		rdbtnMaestria_1.setBounds(170, 55, 141, 23);
		panel.add(rdbtnMaestria_1);
		
		JRadioButton rdbtnEspecialidad = new JRadioButton("Especialidad");
		buttonGroup.add(rdbtnEspecialidad);
		rdbtnEspecialidad.setBounds(170, 18, 141, 23);
		panel.add(rdbtnEspecialidad);
		
		JLabel lblSalarioAnterior = new JLabel("Salario anterior");
		lblSalarioAnterior.setBounds(44, 196, 185, 16);
		contentPane.add(lblSalarioAnterior);
		
		JLabel lblSalarioTotal = new JLabel("Salario total");
		lblSalarioTotal.setBounds(44, 224, 185, 16);
		contentPane.add(lblSalarioTotal);
		
		JLabel lblPorcAumento = new JLabel("% aumento");
		lblPorcAumento.setBounds(293, 196, 130, 16);
		contentPane.add(lblPorcAumento);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalcular.setBounds(177, 255, 117, 29);
		contentPane.add(btnCalcular);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSalario.setText("");
				textFieldSalario.requestFocus();
				buttonGroup.clearSelection();
				lblSalarioAnterior.setText("Salario Anterior");
				lblPorcAumento.setText("% Aumento");
				lblSalarioTotal.setText("Salario actual");
				
			}
		});
		btnReiniciar.setBounds(306, 255, 117, 29);
		contentPane.add(btnReiniciar);
	}
}
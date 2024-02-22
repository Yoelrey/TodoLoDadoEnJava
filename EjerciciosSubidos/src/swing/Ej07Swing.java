import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej07Swing extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JButton btnContinuar;
	JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej07Swing frame = new Ej07Swing();
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
	public Ej07Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos Alumno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 38, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(130, 31, 182, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(46, 107, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
		lblNewLabel_1_1.setBounds(46, 135, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sexo");
		lblNewLabel_1_1_1.setBounds(46, 163, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(119, 102, 284, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(119, 130, 284, 26);
		contentPane.add(textFieldApellidos);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(119, 159, 50, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnH = new JRadioButton("H");
		buttonGroup.add(rdbtnH);
		rdbtnH.setBounds(181, 159, 50, 23);
		contentPane.add(rdbtnH);
		
		JRadioButton rdbtnWtf = new JRadioButton("WTF");
		buttonGroup.add(rdbtnWtf);
		rdbtnWtf.setBounds(231, 159, 69, 23);
		contentPane.add(rdbtnWtf);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(this);
		btnContinuar.setForeground(new Color(0, 249, 0));
		btnContinuar.setBounds(81, 214, 117, 29);
		contentPane.add(btnContinuar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setForeground(new Color(255, 38, 0));
		btnSalir.setBounds(221, 214, 117, 29);
		contentPane.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if((JButton)e.getSource()==btnContinuar){
			Ej07SwingForm2 formulario2=new Ej07SwingForm2(this);
			formulario2.setVisible(true);
			setVisible(false);
		}else
			if((JButton)e.getSource()==btnSalir) {
				System.exit(0);
		}
		
	}
}
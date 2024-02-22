import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej07SwingForm2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ej07Swing formPadre;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ej07SwingForm2(Ej07Swing formPadre) {
		this.formPadre = formPadre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos enviados!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(0, 249, 0));
		lblNewLabel.setBounds(60, 68, 319, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				formPadre.setVisible(true);
			}
		});
		btnNewButton.setBounds(80, 175, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setBounds(222, 175, 117, 29);
		contentPane.add(btnCerrar);
	}

}
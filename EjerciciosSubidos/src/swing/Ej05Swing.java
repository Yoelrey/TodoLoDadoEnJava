import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Ej05Swing extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String textoJTextField;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private boolean oculto=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej05Swing frame = new Ej05Swing();
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
	public Ej05Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(60, 31, 512, 199);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("OCULTAR");
		btnNewButton.addActionListener(this);
				
		btnNewButton.setBounds(134, 274, 141, 41);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("MOSTRAR");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(325, 278, 134, 32);
		btnNewButton_1.setEnabled(false);
		contentPane.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(oculto);	

		if(e.getSource()==btnNewButton) {
			if(oculto==false) {
				
				textoJTextField=textArea.getText();
				if(textoJTextField.equals("")) {
					JOptionPane.showMessageDialog(null, "No hay nada que ocultar");
				}else {
					oculto=true;
					btnNewButton_1.setEnabled(true);
					textArea.setText("");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Texto ya oculto");

			}
		}else if(e.getSource()==btnNewButton_1) {
			if(oculto==true) {
				if((textoJTextField==null)||(textoJTextField.equals(""))) {
					JOptionPane.showMessageDialog(null, "No hay nada que mostrar");

				}else
				{
					textArea.setText(textoJTextField);
					btnNewButton_1.setEnabled(false);
					oculto=false;
				}
			}else {
				oculto=false;
				JOptionPane.showMessageDialog(null, "El texto ya está mostrado");

			}
			
		}
		
		
	

		
	}
}
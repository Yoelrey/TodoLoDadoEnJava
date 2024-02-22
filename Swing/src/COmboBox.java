import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class COmboBox extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					COmboBox frame = new COmboBox();
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
	public COmboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		File files[]= {};
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String coches[]= {"Golf","audi R8","audi TT","Mclaren P1"};
		JComboBox comboBox = new JComboBox(coches);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for( int i =0; i <coches.length;i++) {
					File image= files[i];
				}
				
			}
		});
		comboBox.setBounds(24, 10, 107, 27);
		comboBox.setSelectedItem(-1);
		contentPane.add(comboBox);
		
		
	
		
		
	}
}

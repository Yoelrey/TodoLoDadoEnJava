import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class ManejadorBOtones implements ActionListener{

	ManejadorBOtones(JButton buton){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton= (JButton) e.getSource();
		System.out.println(boton.getName());
		
	}

}

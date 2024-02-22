import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ej04Swing extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField p1X;
	private JTextField p1Y;
	private JTextField p2X;
	private JTextField p2Y;
	private JTextField p3X;
	private JTextField p3Y;
	private JButton btnCalcular;
	private JButton btnReiniciar;
	private JLabel lblPerimetro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej04Swing frame = new Ej04Swing();
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
	public Ej04Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 447);
		contentPane = new JPanel();
		contentPane.setName("reiniciar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresarElPunto = new JLabel("Ingresar el punto 1");
		lblIngresarElPunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngresarElPunto.setBounds(73, 89, 130, 31);
		contentPane.add(lblIngresarElPunto);
		
		JLabel lblIngresarElPunto_2 = new JLabel("Ingresar el punto 2");
		lblIngresarElPunto_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngresarElPunto_2.setBounds(73, 148, 130, 31);
		contentPane.add(lblIngresarElPunto_2);
		
		JLabel lblIngresarElPunto_2_1 = new JLabel("Ingresar el punto 3\r\n");
		lblIngresarElPunto_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngresarElPunto_2_1.setBounds(73, 209, 130, 31);
		contentPane.add(lblIngresarElPunto_2_1);
		
		lblPerimetro = new JLabel("Valor del perímetro");
		lblPerimetro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerimetro.setBounds(73, 326, 390, 31);
		contentPane.add(lblPerimetro);
		
		JLabel lblCoordenada = new JLabel("Coordenada X");
		lblCoordenada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenada.setBounds(259, 27, 130, 31);
		contentPane.add(lblCoordenada);
		
		JLabel lblCoordenadaY = new JLabel("Coordenada Y");
		lblCoordenadaY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenadaY.setBounds(459, 27, 130, 31);
		contentPane.add(lblCoordenadaY);
		
		p1X = new JTextField();
		p1X.addKeyListener(this);
		p1X.setBounds(263, 96, 96, 20);
		contentPane.add(p1X);
		p1X.setColumns(10);
		
		p1Y = new JTextField();
		p1Y.addKeyListener(this);
		p1Y.setColumns(10);
		p1Y.setBounds(459, 96, 96, 20);
		contentPane.add(p1Y);
		
		p2X = new JTextField();
		p2X.addKeyListener(this);
		p2X.setColumns(10);
		p2X.setBounds(263, 155, 96, 20);
		contentPane.add(p2X);
		
		p2Y = new JTextField();
		p2Y.setColumns(10);
		p2Y.setBounds(459, 155, 96, 20);
		p2Y.addKeyListener(this);
		contentPane.add(p2Y);
		
		p3X = new JTextField();
		p3X.addKeyListener(this);
		p3X.setColumns(10);
		p3X.setBounds(263, 216, 96, 20);
		contentPane.add(p3X);
		
		p3Y = new JTextField();
		p3Y.setColumns(10);
		p3Y.addKeyListener(this);
		p3Y.setBounds(459, 216, 96, 20);
		contentPane.add(p3Y);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setName("calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(73, 292, 89, 23);
		contentPane.add(btnCalcular);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setName("reiniciar");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setBounds(216, 292, 89, 23);
		contentPane.add(btnReiniciar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//PODEMOS IDENTIFICAR LOS BOTONES A PARTIR DE SU PROPIEDAD "NAME"
		/*
		 * if(((JButton)e.getSource()).getName().equals("reiniciar")){
		 * System.out.println("BOTÓN REINICIAR"); }else
		 * if(((JButton)e.getSource()).getName().equals("calcular")){
		 * System.out.println("BOTON DE CALCULAR"); }
		 */
		
		//SI TENEMOS ACCESO A LA VARIABLE JBUTTON PODEMOS EVALUAR CUÁL ES
		//A PARTIR DEL GETSOURCE
		if ((e.getSource())==btnCalcular)
		{
			if(comprobarJTextFieldsNain()) {
				Punto punto1=new Punto(Double.parseDouble(p1X.getText()),Double.parseDouble(p1Y.getText()));
				Punto punto2=new Punto(Double.parseDouble(p2X.getText()),Double.parseDouble(p2Y.getText()));
				Punto punto3=new Punto(Double.parseDouble(p3X.getText()),Double.parseDouble(p3Y.getText()));
				double perimetro=Punto.distancia2Puntos(punto1, punto2)+Punto.distancia2Puntos(punto2,punto3)+Punto.distancia2Puntos(punto3,punto1);
				lblPerimetro.setText("El perímetro es "+perimetro);
			}else {
				lblPerimetro.setForeground(Color.RED);
				lblPerimetro.setText("FALTAN DATOS");
			}
			
		}else if ((e.getSource())==btnReiniciar)
		{
			
			p1X.setText("");
			p1Y.setText("");
			p2X.setText("");
			p2Y.setText("");
			p3X.setText("");
			p3Y.setText("");
			lblPerimetro.setText("Valor del perímetro "); 
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		try {
		char c = e.getKeyChar();
		if (c=='-' && ((JTextField)e.getSource()).getText().contains("-") && ((JTextField)e.getSource()).getText().charAt(0)=='-')
			e.consume();
        if (c == '.' && ((JTextField)e.getSource()).getText().contains(".") && ((JTextField)e.getSource()).getText().charAt(0)=='-') {
            e.consume(); 
        } else if (!Character.isDigit(c) && c != '.' && c != '-'&& c != KeyEvent.VK_BACK_SPACE) {
            e.consume(); // Ignora el evento si no es un dígito, un punto o una tecla de retroceso
        }
		}catch(StringIndexOutOfBoundsException e1) {
			e.consume();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private boolean comprobarJTextFieldsNain() {
		for(Component n:contentPane.getComponents()) {
			if(n instanceof JTextField) {
				if(((JTextField)n).getText().equals(""))
					return false;
			}
		}
		return true;
	}
	
	
}
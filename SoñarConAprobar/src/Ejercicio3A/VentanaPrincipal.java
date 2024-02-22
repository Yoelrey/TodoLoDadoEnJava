package Ejercicio3A;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {

	// Un contenedor de elementos gráficos
	private Container contenedor;
	// Etiquetas estáticas de cada nota
	private JLabel total;
	// Campos de ingreso de cada nota
	private JTextField cantidad;
	// Botones para realizar cálculos y para borrar las notas
	private JButton euros, dolares;

	/**
	 * Constructor de la clase VentanaPrincipal
	 */
	public VentanaPrincipal() {
		inicio();
		setTitle("Conversor"); // Establece el título de la ventana
		setSize(280, 380); // Establece el tamaño de la ventana
		setLocationRelativeTo(null); /*
										 * La ventana se posiciona en el centro de la pantalla
										 */
		// Establece que el botón de cerrar permitirá salir de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); /*
								 * Establece que el tamaño de la ventana no se puede cambiar
								 */
	}

	/**
	 * Método que crea la ventana con sus diferentes componentes gráficos
	 */
	private void inicio() {
		contenedor = getContentPane(); /*
										 * Obtiene el panel de contenidos de la ventana
										 */
		contenedor.setLayout(null); /*
									 * Establece que el contenedor no tiene un layout
									 */

		cantidad = new JTextField();
		// Establece la posición del campo de texto de la nota 1
		cantidad.setBounds(60, 120, 135, 23);

		// Establece el botón Calcular
		euros = new JButton();
		euros.setText("Euros");
		euros.setBounds(20, 170, 100, 23); /*
											 * Establece la posición del botón Calcular
											 */
		/*
		 * Agrega al botón un ActionListener para que gestione eventos del botón
		 */
		euros.addActionListener(this);
		// Establece el botón Limpiar
		dolares = new JButton();
		dolares.setText("Dolares");
		dolares.setBounds(125, 170, 80, 23); /*
												 * Establece la posición del botón Limpiar
												 */
		/*
		 * Agrega al botón un ActionListener para que gestione eventos del botón
		 */
		dolares.addActionListener(this);
		// Establece la etiqueta del promedio con su valor numérico
		total = new JLabel();
		total.setText("Total = ");
		total.setBounds(20, 210, 135, 23); /*
											 * Establece la posición de la etiqueta promedio
											 */

		// Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(cantidad);
		contenedor.add(euros);
		contenedor.add(dolares);
		contenedor.add(total);

	}

	/**
	 * Método que gestiona los eventos generados en la ventana principal
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == euros) {
			Cambio a = new Cambio();
			double pasta = Double.parseDouble(cantidad.getText());

			total.setText("Total = " + String.valueOf(a.DolarAEuro(pasta)));
		}

		if (evento.getSource() == dolares) {
			Cambio b = new Cambio();
			double pasta = Double.parseDouble(cantidad.getText());

			total.setText("Total = " + String.valueOf(b.EuroADolar(pasta)));
		}
	}
}
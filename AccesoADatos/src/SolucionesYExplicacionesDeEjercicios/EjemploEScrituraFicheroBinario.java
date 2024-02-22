package SolucionesYExplicacionesDeEjercicios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class EjemploEScrituraFicheroBinario {

	public static void main(String[] args) {
		FileOutputStream fos = null; // Declaración de un objeto FileOutputStream para escribir datos en un archivo.
		DataOutputStream dos = null; // Declaración de un objeto DataOutputStream para escribir tipos de datos
										// primitivos en un archivo.
		File fichero = new File("fichero.dat"); // Creación de un objeto File para el archivo de destino.
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // Definición de un arreglo de números.

		try {
			fos = new FileOutputStream(fichero, false); // Creación de un FileOutputStream para el archivo (se
														// sobrescribe si ya existe).
			dos = new DataOutputStream(fos); // Creación de un DataOutputStream para escribir datos en el archivo.

			for (int numero : numeros) {
				dos.writeInt(numero); // Escribe cada número en el archivo como un entero de 4 bytes.
			}
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el fichero"); // Manejo de excepciones en caso de error al
																		// escribir en el archivo.
		} catch (Exception e1) {
			e1.printStackTrace(); // Manejo de otras excepciones generales.
		} finally {
			try {
				dos.close(); // Cierra el flujo de salida de datos.
			} catch (IOException e) {
				e.printStackTrace(); // Manejo de excepciones en caso de error al cerrar el flujo de salida.
			}
		}
	}

}

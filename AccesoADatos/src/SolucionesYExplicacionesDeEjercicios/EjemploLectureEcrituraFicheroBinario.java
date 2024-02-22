package SolucionesYExplicacionesDeEjercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploLectureEcrituraFicheroBinario {

	public static void main(String[] args) {
		// ESCRITURA DEL FICHERO

		FileOutputStream fe = null; // Declaración de un objeto FileOutputStream para escribir datos en un archivo.
		DataOutputStream ds = null; // Declaración de un objeto DataOutputStream para escribir tipos de datos
									// primitivos en un archivo.

		int[] arrayEnteros = { 5, 18, 23, 12, 10, 1, 47 }; // Definición de un arreglo de enteros.
		String[] arrayNombres = { "Beatriz", "Ana", "Maria", "Juan", "Pedro", "Teresa", "Marta" }; // Definición de un
																									// arreglo de
																									// nombres.

		try {
			fe = new FileOutputStream("Fichero.dat", false); // Creación de un FileOutputStream para el archivo
																// (sobrescribe si ya existe).
			ds = new DataOutputStream(fe); // Creación de un DataOutputStream para escribir datos en el archivo.

			for (int i = 0; i < arrayEnteros.length; i++) {
				ds.writeInt(arrayEnteros[i]); // Escribe enteros en el archivo.
				ds.writeUTF(arrayNombres[i]); // Escribe cadenas en formato UTF-8 en el archivo.
			}
		} catch (IOException e) {
			System.out.println(e.getMessage()); // Manejo de excepciones en caso de error al escribir en el archivo.
		} finally {
			try {
				ds.close(); // Cierra el flujo de salida de datos.
				fe.close();
			} catch (IOException e) {
				System.out.println(e.getMessage()); // Manejo de excepciones en caso de error al cerrar el flujo de
													// salida.
			}
		}

		// EMPEZAMOS LA LECTURA

		FileInputStream fis = null; // Declaración de un objeto FileInputStream para leer datos desde un archivo.
		DataInputStream dis = null; // Declaración de un objeto DataInputStream para leer tipos de datos primitivos
									// desde un archivo.

		try {
			fis = new FileInputStream("Fichero.dat"); // Creación de un FileInputStream para el archivo.
			dis = new DataInputStream(fis); // Creación de un DataInputStream para leer datos desde el archivo.

			// Mientras haya datos disponibles en el archivo.
			while (dis.available() != 0) {
				System.out.println(dis.readInt()); // Lee y muestra un entero.
				System.out.println(dis.readUTF()); // Lee y muestra una cadena en formato UTF-8.
			}

		} catch (IOException e) {
			System.out.println("No se pudo abrir el fichero"); // Manejo de excepciones en caso de error al abrir el
																// archivo.
		} catch (Exception e) {
			e.printStackTrace(); // Manejo de otras excepciones generales.
			System.out.println("No se pudo escribir en el fichero");
		} finally {
			try {
				dis.close(); // Cierra el flujo de entrada de datos.
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

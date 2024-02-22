package FicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) {
		// declaramos los objetos FileOutputStream y DataOutputStream

		FileOutputStream fe = null;
		DataOutputStream ds = null;
		try {
			// array de enteros
			int[] array = { 5, 18, 23, 12, 10, 1, 47 };
			String[] nombres = { "Beatriz", "Ana", "Maria",

					"Juan", "Pedro", "Teresa",

					"Marta" };

			fe = new FileOutputStream("EnterosNombres.txt", true);
			ds = new DataOutputStream(fe);
			// mientras el array tenga elementos los escribimos en el fichero

			for (int i = 0; i < array.length; i++) {
				ds.writeInt(array[i]);
				ds.writeUTF(nombres[i]);
			}
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el fichero Enteros.txt");
		} finally {
			try {
				ds.close();
				fe.close();
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el fichero Enteros.txt");
			}
		}
		System.out.println("Fin del programa");
	}
}

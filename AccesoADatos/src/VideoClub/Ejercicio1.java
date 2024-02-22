package VideoClub;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
	/*
	 * 1o) Realizar un programa Java que utiliza la clase File. Deberá crear un
	 * directorio, dentro de dicho directorio creará dos ficheros, hay que comprobar
	 * si existe; a uno de los ficheros le cambiará de nombre y el otro se
	 * eliminará. Además mostrará los ficheros de un directorio. El nombre del
	 * directorio se pasará al programa desde el teclado al ejecutarlo. El programa
	 * deberá mostrar también información de un fichero cuyo nombre también se
	 * introducirá por teclado.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedir al usuario el nombre del directorio
		System.out.print("Introduce el nombre del directorio: ");
		String directorioNombre = scanner.nextLine();

		// Crear el directorio
		File directorio = new File(directorioNombre);
		if (!directorio.exists()) {
			if (directorio.mkdir()) {
				System.out.println("Directorio creado con éxito.");
			} else {
				System.out.println("No se pudo crear el directorio.");
				return;
			}
		}

		// Crear dos ficheros dentro del directorio
		File fichero1 = new File(directorio, "archivo1.txt");
		File fichero2 = new File(directorio, "archivo2.txt");

		try {
			if (fichero1.createNewFile()) {
				System.out.println("Archivo 1 creado con éxito.");
			} else {
				System.out.println("Archivo 1 ya existe.");
			}

			if (fichero2.createNewFile()) {
				System.out.println("Archivo 2 creado con éxito.");
			} else {
				System.out.println("Archivo 2 ya existe.");
			}
		} catch (IOException e) {
			System.out.println("Error al crear los archivos.");
			e.printStackTrace();
		}

		// Cambiar el nombre de uno de los ficheros
		System.out.print("Introduce el nuevo nombre para el archivo 1: ");
		String nuevoNombre = scanner.nextLine();
		File nuevoFichero1 = new File(directorio, nuevoNombre + ".txt");

		if (fichero1.renameTo(nuevoFichero1)) {
			System.out.println("Nombre del archivo 1 cambiado con éxito.");
		} else {
			System.out.println("No se pudo cambiar el nombre del archivo 1.");
		}

		// Eliminar el otro fichero
		if (fichero2.delete()) {
			System.out.println("Archivo 2 eliminado con éxito.");
		} else {
			System.out.println("No se pudo eliminar el archivo 2.");
		}

		// Mostrar los ficheros en el directorio
		File[] archivosEnDirectorio = directorio.listFiles();
		System.out.println("Archivos en el directorio:");
		if (archivosEnDirectorio != null) {
			for (File archivo : archivosEnDirectorio) {
				System.out.println(archivo.getName());
			}
		}

		// Pedir al usuario el nombre de un archivo para mostrar información
		System.out.print("Introduce el nombre de un archivo para mostrar información: ");
		String nombreArchivo = scanner.nextLine();
		File archivoSeleccionado = new File(directorio, nombreArchivo);

		if (archivoSeleccionado.exists()) {
			System.out.println("Información del archivo seleccionado:");
			System.out.println("Nombre: " + archivoSeleccionado.getName());
			System.out.println("Ruta absoluta: " + archivoSeleccionado.getAbsolutePath());
			System.out.println("Tamaño en bytes: " + archivoSeleccionado.length() + " bytes");
		} else {
			System.out.println("El archivo seleccionado no existe.");
		}

		scanner.close();

	}

}

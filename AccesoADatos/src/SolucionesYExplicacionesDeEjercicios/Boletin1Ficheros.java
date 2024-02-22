package SolucionesYExplicacionesDeEjercicios;
/*Este programa crea un directorio llamado "directorio" y dos archivos dentro de él.
 *  Luego, permite al usuario realizar diversas operaciones, 
 *  como cambiar el nombre de un archivo, eliminar un archivo y 
 *  obtener información sobre un archivo específico en el directorio. 
 *  El código utiliza la clase File para interactuar con archivos y directorios. 
 * Además, utiliza cuadros de diálogo de JOptionPane para la interacción con el usuario.*/
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Boletin1Ficheros {

	public static void main(String[] args) {
		// Creación de un directorio llamado "directorio"
		File directorio = new File("directorio");
		directorio.mkdir();

		// Creación de dos archivos en el directorio
		File file1 = new File("directorio\\archivo1.txt");
		File file2 = new File("directorio\\archivo2.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();

			// Comprobación de la existencia de file1 y file2
			if (file1.exists() && file1.isFile()) {
				System.out.println("El primer fichero existe");
			} else {
				System.out.println("El primer fichero no existe");
			}
			if (file2.exists() && file2.isFile()) {
				System.out.println("El segundo fichero existe");
			} else {
				System.out.println("El segundo fichero no existe");
			}

			/* Cambio de nombre de file1 utilizando un cuadro de diálogo JOptionPane */

			String nuevoNombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre para el fichero 1");
			if (file1.exists() && file1.isFile()) {
				file1.renameTo(new File("directorio\\" + nuevoNombre));
			}

			/* Eliminación de file2 */
			if (file2.exists() && file2.isFile()) {
				file2.delete();
			}

			/* Mostrar información de los archivos en el directorio */
			File[] ficheros = directorio.listFiles();
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println(ficheros[i].getName());
			}
			System.out.println("DE OTRA FORMA");
			String[] nombres = directorio.list();
			for (int i = 0; i < nombres.length; i++) {
				System.out.println(nombres[i]);
			}

			/* Mostrar información del archivo solicitado por el usuario */
			String nombreAbuscar = JOptionPane.showInputDialog(null, "Introduzca el nombre del fichero");
			File ficheroBuscado = new File(directorio, nombreAbuscar);
			if (ficheroBuscado.exists()) {
				System.out.println("Nombre: " + ficheroBuscado.getName());
				System.out.println("Se puede modificar: " + ficheroBuscado.canWrite());
				System.out.println("Oculto: " + ficheroBuscado.isHidden());
				System.out.println("Tamaño: " + ficheroBuscado.length());
				System.out.println("Ultima modificación: " + ficheroBuscado.lastModified());
				System.out.println("Ubicación: " + ficheroBuscado.getAbsolutePath());
				System.out.println("Tamaño en bytes: " + ficheroBuscado.length());
			}
		} catch (IOException e) {
			// Manejo de excepciones en caso de errores al trabajar con archivos
			e.printStackTrace();
		}
	}
}

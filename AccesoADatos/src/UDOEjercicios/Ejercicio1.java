package UDOEjercicios;
import java.io.*;

public class Ejercicio1 {
/*1o) Crea un fichero de texto con el nombre y contenido que tú quieras. Crea otro método para
leer el fichero anterior carácter a carácter mostrando su contenido en pantalla sin espacios y
escribiendo dicho contenido en otro fichero en el disco. Por ejemplo el fichero tiene el
siguiente texto: “Crea un fichero de texto con el nombre y contenido que tú quieras” deberá
mostrar por pantalla Creaunficherodetextoconelnombreycontenidoquetúquieras.*/
	


	    public static void main(String[] args) {
	        // Crear un archivo con contenido
	        crearArchivo("archivo_original.txt", "Crea un fichero de texto con el nombre y contenido que tú quieras");

	        // Leer el archivo original, quitar espacios y escribir en otro archivo
	        procesarArchivo("archivo_original.txt", "archivo_procesado.txt");
	    }

	    public static void crearArchivo(String nombreArchivo, String contenido) {
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
	            writer.write(contenido);
	            writer.close();
	            System.out.println("Archivo creado: " + nombreArchivo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void procesarArchivo(String archivoEntrada, String archivoSalida) {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));
	            int character;

	            while ((character = reader.read()) != -1) {
	                if (!Character.isWhitespace(character)) {
	                    System.out.print((char) character); // Mostrar en pantalla sin espacios
	                    writer.write(character); // Escribir en el archivo de salida
	                }
	            }

	            reader.close();
	            writer.close();
	            System.out.println("\nContenido procesado y guardado en " + archivoSalida);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

	
	
	
	
}

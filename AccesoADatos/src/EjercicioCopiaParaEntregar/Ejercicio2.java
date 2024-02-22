package EjercicioCopiaParaEntregar;

import java.io.*;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            // Solicita al usuario la ruta del archivo.
            String rutaArchivo = JOptionPane.showInputDialog("Introduce la ruta del archivo:");

            
            // Solicita al usuario el texto a escribir en el archivo.
            String texto = JOptionPane.showInputDialog("Introduce el texto a escribir en el archivo:");

            // Abre el archivo en modo de escritura.
            FileWriter escritor = new FileWriter(rutaArchivo);

            // Escribe el texto en el archivo.
            escritor.write(texto);

            // Cierra el archivo.
            escritor.close();

            JOptionPane.showMessageDialog(null, "El texto se ha escrito en el archivo correctamente.");

            // Lee y muestra el contenido del archivo.
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(lector);

            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            bufferedReader.close();

            JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + contenido.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}

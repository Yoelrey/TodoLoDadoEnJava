package EjerciciosAEntregar;

import java.io.*;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
          
            String rutaArchivo = JOptionPane.showInputDialog("Introduce la ruta del archivo:");

            
          
            String texto = JOptionPane.showInputDialog("Introduce el texto a escribir en el archivo:");

          
            FileWriter escritor = new FileWriter(rutaArchivo);

           
            escritor.write(texto);

            
            escritor.close();

            JOptionPane.showMessageDialog(null, "El texto se ha escrito en el archivo correctamente.");

            
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

package EjerciciosAEntregar;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ejercicio2B {
    public static void main(String[] args) {
        try {
            
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();

                
                String texto = JOptionPane.showInputDialog("Introduce el texto a escribir en el archivo:");

                
                FileWriter escritor = new FileWriter(archivo);

                
                escritor.write(texto);

              
                escritor.close();

                JOptionPane.showMessageDialog(null, "El texto se ha escrito en el archivo correctamente.");

            
                FileReader lector = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(lector);

                StringBuilder contenido = new StringBuilder();
                String linea;

                while ((linea = bufferedReader.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }

                bufferedReader.close();

                JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + contenido.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada. No se seleccionó ningún archivo.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}


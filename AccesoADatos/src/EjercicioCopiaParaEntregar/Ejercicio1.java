package EjercicioCopiaParaEntregar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            // Utiliza JFileChooser para seleccionar los archivos de entrada y el archivo de salida.
            JFileChooser fileChooser = new JFileChooser();
            
            File ruta= new File(".");
            fileChooser.setMultiSelectionEnabled(true);

            
            
            fileChooser.setCurrentDirectory(ruta);
            fileChooser.setCurrentDirectory(ruta);

            int result1= fileChooser.showOpenDialog(null);
            int result2= fileChooser.showOpenDialog(null);
            if (result1 == JFileChooser.APPROVE_OPTION && result2 == JFileChooser.APPROVE_OPTION) {
                File archivo1 = fileChooser.getSelectedFiles()[0];
                File archivo2 = fileChooser.getSelectedFiles()[1];

                // Selecciona un archivo de salida para almacenar la mezcla.
                System.out.println("Selecciona el archivo de salida.");
                fileChooser.setCurrentDirectory(ruta);
                int result3 = fileChooser.showSaveDialog(null);

                if (result3 == JFileChooser.APPROVE_OPTION) {
                    File archivoSalida = fileChooser.getSelectedFile();

                    // Abre los archivos de entrada y el archivo de salida.
                    BufferedReader lector1 = new BufferedReader(new FileReader(archivo1));
                    BufferedReader lector2 = new BufferedReader(new FileReader(archivo2));
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

                    String linea1="";
                    
                    String  linea2= "";
                    
                    

                    // Lee y escribe alternativamente desde los dos archivos de entrada hasta que ambos se hayan agotado.
                    while ((linea1 = lector1.readLine()) != null || (linea2 = lector2.readLine()) != null) {
                        if (linea1 != null) {
                            escritor.write(linea1);
                            escritor.newLine();
                        }
                        if (linea2 != null) {
                            escritor.write(linea2);
                            escritor.newLine();
                        }
                    }

                    // Cierra los archivos.
                    lector1.close();
                    lector2.close();
                    escritor.close();

                    System.out.println("La mezcla de archivos se ha completado con éxito.");
                } else {
                    System.out.println("Operación cancelada. No se seleccionó un archivo de salida.");
                }
            } else {
                System.out.println("Operación cancelada. No se seleccionaron archivos de entrada.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


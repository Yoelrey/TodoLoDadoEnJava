package EjerciciosAEntregar;

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
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);

            System.out.println("Selecciona el primer archivo de entrada.");
            int result1 = fileChooser.showOpenDialog(fileChooser);

            System.out.println("Selecciona el segundo archivo de entrada.");
            int result2 = fileChooser.showOpenDialog(fileChooser);

            if (result1 == JFileChooser.APPROVE_OPTION && result2 == JFileChooser.APPROVE_OPTION) {
                File archivo1 = fileChooser.getSelectedFiles()[0];
                File archivo2 = fileChooser.getSelectedFiles()[1];

                System.out.println("Selecciona el archivo de salida.");
                int result3 = fileChooser.showSaveDialog(fileChooser);

                if (result3 == JFileChooser.APPROVE_OPTION) {
                    File archivoSalida = fileChooser.getSelectedFile();

                    BufferedReader lector1 = new BufferedReader(new FileReader(archivo1));
                    BufferedReader lector2 = new BufferedReader(new FileReader(archivo2));
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

                    String linea1="";
                    
                    String  linea2= "";
                    
                    

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


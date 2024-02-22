package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ejercicio1 {

    public static void main(String[] args) {
        // Mostrar mensaje para seleccionar el primer archivo a combinar
        JOptionPane.showMessageDialog(null, "Seleccione el primer archivo a combinar");
        
        // Crear un objeto JFileChooser para que el usuario seleccione archivos
        JFileChooser fc = new JFileChooser();

        File archivo1 = null;
        File archivo2 = null;
        File resultado = null;

        // Mostrar el cuadro de diálogo para seleccionar el primer archivo
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado por el usuario
            archivo1 = fc.getSelectedFile();
        }

        // Mostrar mensaje para seleccionar el segundo archivo a combinar
        JOptionPane.showMessageDialog(null, "Seleccione el segundo archivo a combinar");

        // Mostrar el cuadro de diálogo para seleccionar el segundo archivo
        result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el segundo archivo seleccionado por el usuario
            archivo2 = fc.getSelectedFile();
        }

        // Mostrar mensaje para seleccionar el archivo destino
        JOptionPane.showMessageDialog(null, "Seleccione el archivo destino");

        // Mostrar el cuadro de diálogo para seleccionar el archivo destino
        result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo destino seleccionado por el usuario
            resultado = fc.getSelectedFile();
        }

        try {
            // Crear lectores y escritor para los archivos
            BufferedReader lector = new BufferedReader(new FileReader(archivo1));
            BufferedReader lector2 = new BufferedReader(new FileReader(archivo2));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(resultado, true));
            String linea1, linea2;

            // Leer la primera línea de cada archivo
            linea1 = lector.readLine();
            linea2 = lector2.readLine();

            // Mientras haya líneas en al menos uno de los archivos
            while ((linea1 != null) || (linea2 != null)) {

                // Escribir la línea del primer archivo si existe
                if (linea1 != null) {
                    escritor.write(linea1 + "\n");
                    linea1 = lector.readLine();
                }
                
                // Escribir la línea del segundo archivo si existe
                if (linea2 != null) {
                    escritor.write(linea2 + "\n");
                    linea2 = lector2.readLine();
                }
            }

            // Cerrar los recursos
            lector.close();
            lector2.close();
            escritor.close();

        } catch (FileNotFoundException e) {
            // Manejar la excepción de archivo no encontrado
            e.printStackTrace();
        } catch (IOException e) {
            // Manejar la excepción de entrada/salida
            e.printStackTrace();
        }
    }
}

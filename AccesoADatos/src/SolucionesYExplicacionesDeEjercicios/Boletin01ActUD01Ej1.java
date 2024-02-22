package SolucionesYExplicacionesDeEjercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Boletin01ActUD01Ej1{

    public static void main(String[] args) {
        File archivo1 = new File("fichOrigen.txt");  // Crear un objeto File para el archivo de origen.
        File archivo2 = new File("FicherFinal.txt");  // Crear un objeto File para el archivo de destino.

        try {
            FileReader fr = new FileReader(archivo1);  // Crear un FileReader para leer el archivo de origen.
            BufferedReader br = new BufferedReader(fr);  // Crear un BufferedReader para mejorar la eficiencia de lectura.
            FileWriter fw = new FileWriter(archivo2);  // Crear un FileWriter para escribir en el archivo de destino.
            BufferedWriter bw = new BufferedWriter(fw);  // Crear un BufferedWriter para mejorar la eficiencia de escritura.

            String cadenaOriginal = br.readLine();  // Leer la primera línea del archivo de origen.
            String[] cadena = cadenaOriginal.split(" ");  // Dividir la cadena en palabras utilizando espacios como delimitador.
            String resultado = "";
            for (String a : cadena) {
                resultado += a;  // Concatenar las palabras sin espacios en la variable resultado.
            }
            bw.write(resultado);  // Escribir el resultado en el archivo de destino.

            // Cerrar todos los recursos abiertos (archivos y buffers).
            br.close();
            bw.close();
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  // Manejo de errores en caso de que no se encuentre el archivo de origen.
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores de E/S.
        }
    }
}


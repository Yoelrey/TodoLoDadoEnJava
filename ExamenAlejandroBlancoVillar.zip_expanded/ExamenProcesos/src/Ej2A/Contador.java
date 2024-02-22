package Ej2A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Contador {

    // Método para obtener un BufferedReader dado un nombre de fichero
    public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
        FileReader lector = new FileReader(nombreFichero);
        BufferedReader bufferedReader = new BufferedReader(lector);
        return bufferedReader;
    }

    // Método para obtener un PrintWriter dado un nombre de fichero
    public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
        FileWriter fileWriter = new FileWriter(nombreFichero);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        return printWriter;
    }

    // Método para obtener una lista dinámica de las líneas de un fichero
    public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
        ArrayList<String> lineas = new ArrayList<String>();
        BufferedReader bfr = getBufferedReader(nombreFichero);

        // Leemos líneas del fichero...
        String linea = bfr.readLine();

        while (linea != null) {
            // Y las añadimos al array
            lineas.add(linea);
            linea = bfr.readLine();
        }
        // Fin del bucle que lee líneas
        return lineas;
    }

    // Dado un fichero de entrada y una letra,
    // contamos cuántas veces aparece dicha letra
    // y dejamos el recuento en un fichero de salida
    public static void hacerRecuento(String fichEntrada, String letra, String fichSalida)
            throws FileNotFoundException, IOException {

        BufferedReader br = getBufferedReader(fichEntrada);
        PrintWriter pw = getPrintWriter(fichSalida);
        String lineaLeida = br.readLine();
        int total = 0;

        // Mientras no queden líneas...
        while (lineaLeida != null) {
            // ...recorremos la línea...
            for (int i = 0; i < lineaLeida.length(); i++) {
                char letraLeida = lineaLeida.charAt(i);
                char letraPasada = letra.charAt(0);

                // Incrementamos el contador si la letra coincide
                if (letraLeida == letraPasada) {
                    total++;
                }
                // Fin del if
            }
            // Fin del for

            // Pasamos a la siguiente línea
            lineaLeida = br.readLine();
        }

        // Escribimos el total de ocurrencias de la letra en el fichero de salida
        pw.println(total);
        pw.flush();

        // Cerramos los ficheros
        pw.close();
        br.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del fichero de entrada: ");
        String fileIn = args[0];  //sc.nextLine();
        System.out.println("Introduzca el caracter a buscar en dicho fichero: ");
        String letter = args[1];  //sc.nextLine();
        System.out.println("Introduzca el nombre del fichero de salida: ");
        String fileOut = args[2];  //sc.nextLine();
        hacerRecuento(fileIn, letter, fileOut);
    }
}

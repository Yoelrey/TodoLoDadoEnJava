package Ej2A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class Launcher {

    // Método para obtener el resultado de un fichero
    public static int getResultadoFichero(String nombreFichero) {
        int suma = 0;

        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);

            // Solo lee una línea
            String linea = br.readLine();
            suma = Integer.parseInt(linea);
            return suma;

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return suma;
    }

    /*
     * 1. Recoger el primer parámetro (args[0]), que contendrá el fichero a procesar.
     * 2. Recoger el segundo parámetro, que contendrá el directorio de “CLASSPATH”
     *    donde habrá que buscar la clase “UtilidadesFicheros”.
     * 3. Recoger el tercer parámetro, que contendrá el directorio donde habrá
     *    que buscar la clase “ProcesadorFicheros”.
     * 4. Una vez recogidos los parámetros, se lanzarán los procesos utilizando
     *    la clase “ProcessBuilder”.
     * 5. Los procesos se ejecutarán y después recogeremos los resultados de los ficheros.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Fichero HimnoCentenario.txt
        String entrada = "HimnoCentenario.txt"; // args[0];
        // C:\\ruta hasta contador.java
        String ruta = "\\src\\Ej2A\\Contador.java";

        // OJO MAYÚSCULAS Y MINÚSCULAS
        String[] vocales = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String[] letras = { "a", "b", "c" };
        for (int i = 0; i < 3; i++) {
            int randomNum = (int) (Math.random() * 27);
            String c = vocales[randomNum].toUpperCase();
            letras[i] = c;
        }
        String classPath = System.getProperty("user.dir");

        System.out.println("Usando ruta:" + ruta);
        System.out.println("Usando classpath: " + classPath);
        System.out.println("Usando classpath + ruta: " + classPath + ruta);

        // Se lanzan los procesos
        for (int i = 0; i < letras.length; i++) {
            String fichErrores = "Errores_" + letras[i] + ".txt";
            ProcessBuilder pb = new ProcessBuilder("java", classPath + ruta, entrada, letras[i], letras[i] + ".txt");
            // Si hay algún error, almacenarlo en un fichero
            pb.redirectError(new File(fichErrores));
            pb.start();
            // fin del for
        }

        Thread.sleep(4000);
        String res = "RES.txt";
        File f = new File("RES.txt");
        PrintWriter pw = Contador.getPrintWriter(res);
        System.out.println("Procediendo a la lectura..");
        for (int i = 0; i < letras.length; i++) {
            String cad = "El número de " + letras[i] + " es: " + String.valueOf(getResultadoFichero(letras[i] + ".txt"));
            System.out.println(cad);
            pw.append(cad + "\n");
        }
        pw.close();
    }
}


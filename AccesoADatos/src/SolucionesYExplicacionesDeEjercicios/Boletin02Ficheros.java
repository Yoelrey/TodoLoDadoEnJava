package SolucionesYExplicacionesDeEjercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Boletin02Ficheros {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Crear un objeto Scanner para la entrada de usuario.
        int opcion = 0;  // Variable para almacenar la opción seleccionada por el usuario.
        File fichUsuario = null;  // Variable para almacenar el archivo de usuario.

        do {
            System.out.println("Introduce una de las opciones");
            System.out.println("1. Crear archivo con datos personales");
            System.out.println("2. Mostrar archivo creado");
            System.out.println("3. Crear fichero y mostrar may/min invertidas");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();  // Leer la opción seleccionada por el usuario.

            switch (opcion) {
                case 1:
                    fichUsuario = crearFicheroDatosUsuario();  // Llama a la función para crear un archivo con datos de usuario.
                    break;

                case 2:
                    fichUsuario = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");  // Establece el archivo a mostrar.
                    if (fichUsuario != null && fichUsuario.exists()) {
                        mostrarFichero(fichUsuario);  // Llama a la función para mostrar el contenido del archivo.
                    } else {
                        System.out.println("El fichero no existe");
                    }
                    break;

                case 3:
                    fichUsuario = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");  // Establece el archivo a mostrar con may/min invertidas.
                    if (fichUsuario != null && fichUsuario.exists()) {
                        mostrarFicheroAlternando(fichUsuario);  // Llama a la función para mostrar el contenido con may/min invertidas.
                    } else {
                        System.out.println("El fichero no existe");
                    }
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcion != 4);  // Repetir hasta que el usuario seleccione la opción 4 (Salir).
    }

    public static File crearFicheroDatosUsuario() {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");  // Define el archivo de salida.

        try {
            System.out.println("Introduce tu nombre");
            String nombre = sc.nextLine();
            FileWriter fw = new FileWriter(fichero, true);  // Abre el archivo para escritura (con el modo "true" para agregar al final).
            fw.write(nombre + "\n");  // Escribe el nombre en el archivo.

            System.out.println("Introduce tu apellido");
            String apellido = sc.nextLine();
            fw.write(apellido + "\n");  // Escribe el apellido en el archivo.

            System.out.println("Introduce la población de nacimiento");
            String poblacion = sc.nextLine();
            fw.write(poblacion + "\n");  // Escribe la población en el archivo.
            fw.close();  // Cierra el archivo.
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores de E/S.
        }
        return fichero;  // Devuelve el archivo creado.
    }

    public static void mostrarFichero(File fichero) {
        try {
            FileReader fr = new FileReader(fichero);  // Abre el archivo para lectura.
            BufferedReader br = new BufferedReader(fr);  // Crea un lector de búfer para mejorar la eficiencia de lectura.
            String linea;
            try {
                while ((linea = br.readLine()) != null) {  // Lee y muestra cada línea del archivo.
                    System.out.println(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();  // Manejo de errores de E/S.
            }
            br.close();
            fr.close();  // Cierra los recursos.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  // Manejo de errores de archivo no encontrado.
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores de E/S.
        }
    }

    public static void mostrarFicheroAlternando(File fichero) {
        try {
            FileReader fr = new FileReader(fichero);  // Abre el archivo para lectura.
            BufferedReader br = new BufferedReader(fr);  // Crea un lector de búfer para mejorar la eficiencia de lectura.
            String linea;
            try {
                while ((linea = br.readLine()) != null) {
                    for (int i = 0; i < linea.length(); i++) {
                        if (Character.isLowerCase(linea.charAt(i))) {
                            System.out.print(Character.toUpperCase(linea.charAt(i)));  // Convierte minúsculas a mayúsculas.
                        } else {
                            System.out.print(Character.toLowerCase(linea.charAt(i)));  // Convierte mayúsculas a minúsculas.
                        }
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();  // Manejo de errores de E/S.
            }
            br.close();
            fr.close();  // Cierra los recursos.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  // Manejo de errores de archivo no encontrado.
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores de E/S.
        }
    }
}
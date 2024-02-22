package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Boletin02Ficheros {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        File fichUsuario = null;

        do {
            // Mostrar menú de opciones al usuario
            System.out.println("Introduce una de las opciones");
            System.out.println("1. Crear archivo con datos personales");
            System.out.println("2. Mostrar archivo creado");
            System.out.println("3. Crear fichero y mostrar may/min invertidas");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear un archivo con datos de usuario
                    fichUsuario = crearFicheroDatosUsuario();
                    break;

                case 2:
                    // Mostrar el contenido del archivo creado
                    fichUsuario = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");

                    if (fichUsuario != null && fichUsuario.exists()) {
                        mostrarFichero(fichUsuario);
                    } else {
                        System.out.println("El fichero no existe");
                    }

                    break;
                case 3:
                    // Mostrar el contenido del archivo con mayúsculas y minúsculas alternadas
                    fichUsuario = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");
                    if (fichUsuario != null && fichUsuario.exists()) {
                        mostrarFicheroAlternando(fichUsuario);
                    } else {
                        System.out.println("El fichero no existe");
                    }
                    break;
                case 4:
                    // Salir del programa
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 4);

        // Cerrar el scanner
        scanner.close();
    }

    public static File crearFicheroDatosUsuario() {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("C:\\Users\\usuario\\Desktop\\DatosUsuario.txt");

        try {
            // Solicitar datos al usuario y escribir en el archivo
            System.out.println("Introduce tu nombre");
            String nombre = sc.nextLine();
            FileWriter fw = new FileWriter(fichero, true);
            
			fw.write(nombre + "\n");

            System.out.println("Introduce tu apellido");
            String apellido = sc.nextLine();
            fw.write(apellido + "\n");

            System.out.println("Introduce la población de nacimiento");
            String poblacion = sc.nextLine();
            fw.write(poblacion + "\n");
            fw.close();
        } catch (IOException e) {
            // Manejar la excepción de entrada/salida
            e.printStackTrace();
        }
        return fichero;
    }

    public static void mostrarFichero(File fichero) {
        try {
            // Leer y mostrar el contenido del archivo línea por línea
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            // Cerrar los recursos
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // Manejar la excepción de archivo no encontrado
            e.printStackTrace();
        } catch (IOException e) {
            // Manejar la excepción de entrada/salida
            e.printStackTrace();
        }
    }

    public static void mostrarFicheroAlternando(File fichero) {
        try {
            // Leer y mostrar el contenido del archivo con mayúsculas y minúsculas alternadas
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (Character.isLowerCase(linea.charAt(i))) {
                        System.out.print(Character.toUpperCase((linea.charAt(i))));
                    } else {
                        System.out.print(Character.toLowerCase(linea.charAt(i)));
                    }
                }
                System.out.println();
            }

            // Cerrar los recursos
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // Manejar la excepción de archivo no encontrado
            e.printStackTrace();
        } catch (IOException e) {
            // Manejar la excepción de entrada/salida
            e.printStackTrace();
        }
    }
}

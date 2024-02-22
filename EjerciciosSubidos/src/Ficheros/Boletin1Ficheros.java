package Ficheros;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Boletin1Ficheros {

    public static void main(String[] args) {
        // Crear un directorio llamado "directorio"
        File directorio = new File("directorio");
        directorio.mkdir();

        // Crear dos archivos dentro del directorio
        File file1 = new File("directorio\\archivo1.txt");
        File file2 = new File("directorio\\archivo2.txt");

        try {
            // Crear los archivos
            file1.createNewFile();
            file2.createNewFile();

            // Verificar la existencia y tipo de los archivos
            if (file1.exists() && file1.isFile()) {
                System.out.println("El primer fichero existe");
            } else {
                System.out.println("El primer fichero no existe");
            }

            if (file2.exists() && file2.isFile()) {
                System.out.println("El segundo fichero existe");
            } else {
                System.out.println("El segundo fichero no existe");
            }

            // Cambiar el nombre del primer fichero usando JOptionPane
            String nuevoNombre = JOptionPane.showInputDialog(null, "Introduzca el nuevo nombre para el fichero 1");
            if (file1.exists() && file1.isFile()) {
                file1.renameTo(new File("directorio\\" + nuevoNombre));
            }

            // Eliminar el segundo fichero
            if (file2.exists() && file2.isFile()) {
                file2.delete();
            }

            // Mostrar información de los archivos en el directorio
            File[] ficheros = directorio.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println(ficheros[i].getName());
            }

            System.out.println("DE OTRA FORMA");
            
            // Mostrar información de los archivos en el directorio de otra manera
            String[] nombres = directorio.list();
            for (int i = 0; i < nombres.length; i++) {
                System.out.println(nombres[i]);
            }

        }catch (Exception e) {
			// TODO: handle exception
		}
    }}//

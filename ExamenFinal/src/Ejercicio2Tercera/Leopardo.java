package Ejercicio2Tercera;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Leopardo extends Felino{
	static FileWriter archivo = null;
    static PrintWriter impresor = null;
private boolean pelajeManchado;
private String habitat;
public Leopardo(String esp, int ed, String color, boolean pelajeManchado, String habitat) {
	super(esp, ed, color);
	this.pelajeManchado = pelajeManchado;
	this.habitat = habitat;
}
Leopardo(){
	super();
	pelajeManchado=true;
	habitat="calido";
	
}
@Override
public String toString() {
	return "Leopardo [pelajeManchado=" + pelajeManchado + ", habitat=" + habitat + "]";
}



public void guardar(String fichero) {
    try {
        FileOutputStream archivo = new FileOutputStream(fichero);
        ObjectOutputStream salida = new ObjectOutputStream(archivo);
        salida.writeObject(this);
        
        System.out.println("El objeto Leopardo se ha guardado exitosamente en el archivo " + fichero);
    } catch (IOException e) {
        System.out.println("Se produjo un error al guardar el objeto Leopardo en el archivo:");
        e.printStackTrace();
    }
    
}
    public static Leopardo leer(String fichero) {
        Leopardo leopardo = null;
        try {
            FileInputStream archivo = new FileInputStream(fichero);
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            try {
				leopardo = (Leopardo) entrada.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            System.out.println("Se ha leído exitosamente el objeto Leopardo desde el archivo " + fichero);
        
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo " + fichero + ":");
            e.printStackTrace();
        }
        return leopardo;
   
}
}



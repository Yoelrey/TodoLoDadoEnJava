package Ej1A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;





public class Calculadora {
	public static int limite=0;
	
	public static int getLimite() {
		return limite;
	}


	public static  void setLimite(int limite) {
		Calculadora.limite = limite;
	}


	public static void hacerCalculos(String fichEntrada,String fichSalida) throws IOException {
		
		int suma=0;
		
		//1 Abrir el fichero informática.txt
			ArrayList<String> cantidades= getLineasFichero(fichEntrada);
		
			// TODO Auto-generated catch block
			
		
			//2 Sumar las cantidades de dicho fichero
		for(String s : cantidades) {
			if(Integer.parseInt(s)>=limite) {
				suma+= Integer.parseInt(s);
			}
			
		}
		//provisionalmente
		System.out.println("el total de gastos de: "+fichEntrada+" es: "+suma+" €");
		
		//3 Guardar el resultado numérico en un fichero llamado 
		//totalInformatica.txt
		PrintWriter pw=  getPrintWriter(fichSalida);
		pw.println(suma);
		pw.close();
		
	}
	
	
public static void main(String[] args) {
	String ent, sal;
	Scanner jaime= new Scanner(System.in);
	
	System.out.println("fichero de entrada: ");
	ent=args[0];//jaime.nextLine()
	
	System.out.println("fichero de salida: ");
	sal=args[1];//jaime.nextLine()
	
	try {
		hacerCalculos(ent,sal);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public static BufferedReader getBufferedReader(
		String nombreFichero) 
				throws FileNotFoundException {

		FileReader lector;
		lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader = new BufferedReader(lector);
		return bufferedReader;
		}

//Para escribir en un fichero
public static PrintWriter getPrintWriter(String nombreFichero) throws
IOException {
FileWriter fileWriter = new FileWriter(nombreFichero);
PrintWriter printWriter = new PrintWriter(fileWriter);
return printWriter;
}

//para obtener una lista dinámica de las líneas de un fichero
public static ArrayList<String> getLineasFichero(String nombreFichero)
		throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		
		BufferedReader bfr = getBufferedReader(nombreFichero);
		
		//Leemos líneas del fichero...
		
		String linea = bfr.readLine();
		
		while (linea != null) {
			
		//Y las añadimos al array
		lineas.add(linea);
		linea = bfr.readLine();
		}
		//Fin del bucle que lee líneas
		return lineas;
		}
}
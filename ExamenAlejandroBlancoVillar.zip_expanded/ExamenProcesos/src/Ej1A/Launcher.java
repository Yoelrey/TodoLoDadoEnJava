package Ej1A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



//Hay que lanzar calculadoras para cada fichero
public class Launcher {

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Escribe el valor mínimo para sumar");
		int limite=sc.nextInt();
		Calculadora.setLimite(limite); 
		String[] fichiEnt = {"informatica.txt","gerencia.txt","rrhh.txt","contabilidad.txt","comercio.txt"};
		String[] fichiSal = {"Tinformatica.txt","Tgerencia.txt","Trrhh.txt","Tcontabilidad.txt","Tcomercio.txt"};
		String[] fichiErr = {"Einformatica.txt","Egerencia.txt","Errhh.txt","Econtabilidad.txt","Ecomercio.txt"};
		String path=System.getProperty("user.dir");
		String ruta="\\src\\Ej1A\\";
		
		
		
		
		
		for(int i=0;i<fichiEnt.length;i++) {
			ProcessBuilder pb;
			pb= new ProcessBuilder("java",path+ruta+"Calculadora.java",fichiEnt[i],fichiSal[i]);
			pb.redirectError(new File("Error"+fichiErr[i]));
			try {
				
				pb.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int total=0;;
		int parcial=0;
		
		//QUIERO RECUPERAR LOS TOTALES DE CADA FICHERO MOSTRANDOLOS POR PANTALLA
		// Y GUARDAR LOS GASTOS EN TOTALGASTOS.TXT
		for(int i=0;i<fichiEnt.length;i++) {
		try {
			BufferedReader br = Calculadora.getBufferedReader(fichiSal[i]);
			parcial=Integer.parseInt(br.readLine());
			System.out.println("gastos "+fichiEnt[i]+": "+parcial);
			total+=parcial;
			} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		System.out.println("gastos totales: "+total);
		System.out.println("guardando en gastosTotales.txt..........");
		
		try {
			PrintWriter pw= Calculadora.getPrintWriter("gastosTotales.txt");
			pw.println(String.valueOf(total));
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

package Ejercicio1TipoExamen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteExamen {
	public static void main(String[] args) throws Exception {
		String host = "localhost";

		//InetAddress i = InetAddress.getByName("10.101.19.19");

		int puerto = 6000;// puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto);

		// creo Flujo de salida del cliente
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);

		// Creo flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean seguir=true;
		String cadena, eco = "";
		
		do {
		System.out.println("Introduce una fecha(ej:12-12-1212):");

		cadena = sc.nextLine();
		
			fsalida.print(cadena);
			
			if (cadena.equals("quit"))seguir=false;
			else {
			eco = fentrada.readLine();
			System.out.println("=>Recibo: " + eco);
			}
		}while (seguir);

		System.out.println("Recibiendo del SERVIDOR: \n\t" + fentrada.read());
		// CERRAR STREAMS Y SOCKETS
		fsalida.close();
		fentrada.close();
		cliente.close();
	}// fin de main
	
	
}
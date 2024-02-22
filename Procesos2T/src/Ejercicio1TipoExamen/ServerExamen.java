package Ejercicio1TipoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class ServerExamen {
public static void main(String[] arg) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		
		int numPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();
		
				
		//creo Flujo de salida del cliente
		PrintWriter fsalida= new PrintWriter(clienteConectado.getOutputStream(),true);
		
		//Creo flujo de entrada del cliente 
		BufferedReader fentrada= new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
		
		
		
		
		boolean seguir=true;
		
		while(seguir) {
			//Logica de servidor
			String cad=fentrada.readLine();
		fsalida.println(diaSemana(cad));
		if (cad.equals("quit"))seguir= false;
		else {fsalida.println(diaSemana(cad));		}
		}
		
		System.out.println("Cerrando conexion ...");
		fentrada.close();
		fsalida.close();
		clienteConectado.close();
		servidor.close();
	}// main
public static String diaSemana(String cad) {
	
	//Scanner sc = new Scanner( System.in );
	
	System.out.println("Recibiendo fecha:"+cad);

	
	String[]digitos = cad.split("/");
	

	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/YYYY");	@SuppressWarnings("deprecation")
	//Date date= new Date(Integer.parseInt(digitos[2])-1900,Integer.parseInt(digitos[1])-1,Integer.parseInt(digitos[0]));

		Date fecha= null;
	try {
		 fecha = sdf.parse(cad);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(fecha.toString());
	Calendar calendar= Calendar.getInstance();
	calendar.setTime(fecha);
	int dia= calendar.get(Calendar.DAY_OF_WEEK);
	String []nombreDia= {"Domingo ","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
	
	return cad= nombreDia[dia];
	
}



}


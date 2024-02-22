package Prueba;

import java.util.Scanner;

public class CapturaDatos {
	private Scanner sc;
	public CapturaDatos(){
		sc=new Scanner(System.in);
	}
	
	public int capturaEntero() {
		System.out.println("Introduzca un entero");
		int entero = sc.nextInt();
		return entero;
	}
	
	
}

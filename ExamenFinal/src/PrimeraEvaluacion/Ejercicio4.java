package PrimeraEvaluacion;

import java.util.Scanner;

public class Ejercicio4 {
	public static double pasarAPulgadas(double altura) {
		double pulgadas=0;
		return pulgadas=altura/2.54;
		
	}
	public static double pasarAPies(double altura) {
		double pies=0;
		return pies=altura/30.48;
	}
	
/*
Método que introduzca la estatura en cm de una persona y la convierta a pies y pulgadas.
1 pie (ft) = 12 in = 30,48 cm
1 pulgada (in) = 2,54 cm
*/
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Dime tu altura en centimetros,por favor:");
		double altura= sc.nextDouble();
		System.out.println("Esta es tu altura en pulgadas: "+pasarAPulgadas(altura)); 
		System.out.println("Esta es tu altura en pies: "+pasarAPies(altura)); 

		
		
	}
	
	
}

package PrimeraEvaluacion;

import java.util.Scanner;

/*Calcular el coste del estacionamiento en un
 *  parking de modo que las 4 primeras horas se cobran a 3,50 euros y
 *   las siguientes a 1,50 hasta llegar a un tope de 35 euros para
 *    24 horas. Si permanece aparcado más de un día se cobrarán 30
 *     euros los días completos y 1,80 las horas sueltas.
*/
import java.util.Scanner;

public class Ejercicio2 {
	
	public static double calcularCoste(int horas) {
		double coste=0.0;
        for (int i =0;i<horas;i++) {
        	if(horas==1) {
        		coste=+1.80;
        	}
        	while(horas<=4) {
        		coste=+3.50;
        	}
        	while(coste<35) {
        		while (horas>4 && horas<24) {
            	coste=+1.50;	
            	}
        	}
        	if (horas%24==0) {
        		coste+=30;
        	}
        	
        	
        }
        return coste;
	}
    public static void main(String[] args) {
    	 double coste =0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de horas que ha estado estacionado: ");
        int horas = scanner.nextInt();
       
        
        System.out.println("El coste de su estacionamiento es de: "+calcularCoste(horas));

    }
}


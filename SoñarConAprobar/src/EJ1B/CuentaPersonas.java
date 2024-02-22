package EJ1B;

import java.util.Scanner;


public class CuentaPersonas {

	public static Cine uno, dos, tres;

		static boolean corte=true;
	
	public static void control() {

		int opcion = 0;
		Scanner esc = new Scanner(System.in);
		System.out.println("\n Apliacion de cuenta personas, seleccione una opcion\n "
				+ "Pulsa 1 si quieres METER una persona.\n"
				+ "Pulsa 2 si quieres SACAR una persona.\n"
				+ "Puelsa 3 si quieres SALIR DE LA APLICACION.");
		opcion = esc.nextInt();

		switch (opcion) {

		case 1: // meter

			if (uno.getnpersonas() > 0)
				uno.meter();
			else if (dos.getnpersonas() > 0)
				dos.meter();
			else
				tres.meter();

			break;

		case 2: // sacar

			if (uno.getnpersonas() < uno.getCapacidad())
				uno.sacar();
			else if (dos.getnpersonas() < dos.getCapacidad())
				dos.sacar();
			else
				tres.sacar();
			break;

		case 3: // salir
			corte=false;
			System.out.println("Fin simulacion.");
			break;

		default: System.out.println("opcion no valida");

		}

	}

	public static void menu() {

		
		
		// crear tres almacenes
		uno = new Cine(4);

		dos = new Cine(3);

		tres = new Cine(2);

		while (corte)
			control();

	}

}


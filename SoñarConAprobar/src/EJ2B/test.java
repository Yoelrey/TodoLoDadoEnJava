package EJ2B;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class test {
public static void main(String[] args) {
	FileWriter archivo = null;
	PrintWriter impresor = null;
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	Portero portero1 = new Portero("Casillas", "Portero", 5, 1, 0, 0, 3, 10);
	Portero portero2 = new Portero("Manuel", "Portero", 1, 0, 0, 0, 0, 2);
	Portero portero3 = new Portero("Josue", "Portero", 3, 0, 1, 0, 5, 4);
	
	Jugador jugador1 = new Jugador("Ramiro", "Delantero", 3, 1, 0, 1);
	Jugador jugador2 = new Jugador("Pedro", "Defensa", 1, 1, 1, 4);
	
	jugadores.add(portero1);
	jugadores.add(portero2);
	jugadores.add(portero3);
	jugadores.add(jugador1);
	jugadores.add(jugador2);
	

	try {
		archivo = new FileWriter("porteros.dat");
		impresor = new PrintWriter(archivo);
		for (Jugador jugador : jugadores) {
			if (jugador instanceof Portero) {
				jugador.imprimir();
				impresor.println(jugador.toString());
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			if(archivo != null) {
				archivo.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
}
}


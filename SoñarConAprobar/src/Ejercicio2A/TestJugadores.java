package Ejercicio2A;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestJugadores {
    public static void main(String[] args) {
        FileWriter archivo = null;
        PrintWriter impresor = null;
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        Jugador uno = new Jugador("Fran Beltrán", "Medio", 30, 2, 5, 1);
        Jugador dos = new Jugador("Javi Galán", "Lateral", 28, 1, 8, 1);
        Delantero tres = new Delantero("Iago Aspas", "Delantero", 29, 12, 4, 1, 12, 5);
        Delantero cuatro = new Delantero("Haris Seferovic", "Delantero", 12, 3, 1, 0, 3, 0);
        Delantero cinco = new Delantero("Carles Pérez", "Extremo", 27, 4, 3, 0, 4, 0);

        jugadores.add(uno);
        jugadores.add(dos);
        jugadores.add(tres);
        jugadores.add(cuatro);
        jugadores.add(cinco);
        

        try {
            archivo = new FileWriter("delanteros.dat");
            impresor = new PrintWriter(archivo);
            for (Jugador jugador : jugadores) {
                if (jugador instanceof Delantero)
                    jugador.imprimir();
                impresor.println(jugador.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

}

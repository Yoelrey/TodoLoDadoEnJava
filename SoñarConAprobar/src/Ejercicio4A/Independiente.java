package Ejercicio4A;

public class Independiente extends Urbana {

    // protected static double valorArea=3000000;

    public Independiente(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos) {
        super(idTipo, area, direccion, numHabitaciones, numBaños, numPisos);
        setValorArea(3150);
    }

    @Override
    public String toString() {
        return super.toString() + "Independiente [valorArea=" + valorArea + "]";
    }

}

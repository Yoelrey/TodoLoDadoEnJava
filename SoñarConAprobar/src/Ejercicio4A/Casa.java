package Ejercicio4A;

public class Casa extends Vivienda implements Comision {
    protected int numPisos;

    public Casa(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos) {
        super(idTipo, area, direccion, numHabitaciones, numBaños);
        this.numPisos = numPisos;
    }

    public void calcularComision() {

    }

    @Override
    public String toString() {
        return super.toString() + "Casa [numPisos=" + numPisos + "]";
    }

}

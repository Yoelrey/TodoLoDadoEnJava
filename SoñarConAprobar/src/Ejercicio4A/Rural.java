package Ejercicio4A;

public class Rural extends Casa {
    // protected static double valorArea=1500000;
    protected int distanciaCarrera;
    protected int altitud;

    public Rural(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos,
            int distanciaCarrera, int altitud) {
        super(idTipo, area, direccion, numHabitaciones, numBaños, numPisos);
        this.distanciaCarrera = distanciaCarrera;
        this.altitud = altitud;
        setValorArea(1750);
    }

    @Override
    public String toString() {
        return super.toString() + "Rural [valorArea=" + valorArea + ", distanciaCarrera=" + distanciaCarrera
                + ", altitud=" + altitud
                + "]";
    }

}

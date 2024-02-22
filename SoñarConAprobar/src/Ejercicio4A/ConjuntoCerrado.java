package Ejercicio4A;

public class ConjuntoCerrado extends Urbana {
    // protected static double valorArea=2500000;
    protected double valorAdministracion;
    protected double tienePiscina;
    protected boolean tieneCamposDeportivos;

    public ConjuntoCerrado(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos,
            double valorAdministracion, double tienePiscina, boolean tieneCamposDeportivos) {
        super(idTipo, area, direccion, numHabitaciones, numBaños, numPisos);
        this.valorAdministracion = valorAdministracion;
        this.tienePiscina = tienePiscina;
        this.tieneCamposDeportivos = tieneCamposDeportivos;
        setValorArea(2250);
    }

    @Override
    public String toString() {
        return super.toString() + "ConjuntoCerrado [valorArea=" + valorArea + ", valorAdministracion="
                + valorAdministracion
                + ", tienePiscina=" + tienePiscina + ", tieneCamposDeportivos=" + tieneCamposDeportivos + "]";
    }

}

package EJ4B;


public class Rural extends Casa{
    //protected static double valorArea=1500000;
    protected int distanciaCarrera;
    protected int altitud;

    public Rural(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos,
             int distanciaCarrera, int altitud) {
        super(idTipo, area, direccion, numHabitaciones, numBaños, numPisos);
        this.distanciaCarrera = distanciaCarrera;
        this.altitud = altitud;
        setValorArea(1500);
    }

    @Override
    public String toString() {
        return super.toString()+ "Rural [valorArea=" + valorArea + ", distanciaCarrera=" + distanciaCarrera + ", altitud=" + altitud
                + "]";
    }

    @Override
    public double calcularImpuesto() {
        // TODO Auto-generated method stub
        double parcial = super.calcularImpuesto();
        parcial+=this.altitud;
        return parcial;
    }

}


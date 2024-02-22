package EJ4B;



public class ConjuntoCerrado extends Urbana{
   // protected static double valorArea=2500000;
    protected double valorAdministracion;
    protected boolean tienePiscina;
    protected boolean tieneCamposDeportivos;


    public ConjuntoCerrado(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos,
            double valorAdministracion, boolean tienePiscina, boolean tieneCamposDeportivos) {
        super(idTipo, area, direccion, numHabitaciones, numBaños, numPisos);
        this.valorAdministracion = valorAdministracion;
        this.tienePiscina = tienePiscina;
        this.tieneCamposDeportivos = tieneCamposDeportivos;
        setValorArea(10000);
    }


    @Override
    public String toString() {
        return super.toString()+ "ConjuntoCerrado [valorArea=" + valorArea + ", valorAdministracion=" + valorAdministracion
                + ", tienePiscina=" + tienePiscina + ", tieneCamposDeportivos=" + tieneCamposDeportivos + "]";
    }

@Override
public double calcularImpuesto() {
    // TODO Auto-generated method stub
    double parcial = super.calcularImpuesto();
    if(tienePiscina)
    parcial+=5000;
    if(tieneCamposDeportivos)
    parcial+=6000;
    return parcial;
}    

    
}

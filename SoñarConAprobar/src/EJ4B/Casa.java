package EJ4B;

public class Casa extends Vivienda {
    protected int numPisos;

    public Casa(int idTipo, int area, String direccion, int numHabitaciones, int numBaños, int numPisos) {
        super(idTipo, area, direccion, numHabitaciones, numBaños);
        this.numPisos = numPisos;
    }

    @Override
    public String toString() {
        return super.toString()+"Casa [numPisos=" + numPisos + "]";
    }

@Override
public double calcularImpuesto() {
    // TODO Auto-generated method stub
    double parcial = super.calcularImpuesto();
    parcial+=0.05*this.calculaPrecio()+300*this.numHabitaciones+200*numBaños;

    return parcial;
}

}


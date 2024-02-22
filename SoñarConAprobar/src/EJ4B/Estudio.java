package EJ4B;



public class Estudio extends Apartamento{
    //protected static double valorArea=1500000;

    public Estudio(int idTipo, int area, String direccion, int numHabitaciones, int numBaños) {
        super(idTipo, area, direccion, 1,2);
        setValorArea(1500);
    }

    @Override
    public String toString() {
        return super.toString()+ "Estudio []";
    }

    
}


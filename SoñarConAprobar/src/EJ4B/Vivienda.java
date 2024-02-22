package EJ4B;



public class Vivienda extends Inmueble{

    protected int numHabitaciones;
    protected int numBaños;
    
    public Vivienda(int idTipo, int area, String direccion, int numHabitaciones, int numBaños) {
        super(idTipo, area, direccion);
        this.numHabitaciones = numHabitaciones;
        this.numBaños = numBaños;
    }

    @Override
    public String toString() {
        return super.toString()+ "Vivienda [numHabitaciones=" + numHabitaciones + ", numBaños=" + numBaños + "]";
    }

    

    
    
}


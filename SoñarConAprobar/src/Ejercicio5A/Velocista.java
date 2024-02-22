package Ejercicio5A;

public class Velocista extends Ciclista {

    protected double potenciaPromedio;
    protected double velocidadPromedio;

    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedio) {
        super(identificador, nombre);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;

    }

    public double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    public void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public void calcularTiempoParcial() {
        super.calcularTiempoParcial();
        double total = super.getTiempoAcumulado();
        total += (velocidadPromedio * 4);
        super.setTiempoAcumulado(total);
    }

    @Override
    public String toString() {
        return super.toString() + "Velocista [potenciaPromedio=" + potenciaPromedio + ", velocidadPromedio="
                + velocidadPromedio + "]";
    }

    protected String imprimirTipo() {
        return "Es un velocista";
    }

}

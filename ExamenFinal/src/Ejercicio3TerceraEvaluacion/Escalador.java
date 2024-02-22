package Ejercicio3TerceraEvaluacion;

public class Escalador extends Ciclista {
    protected double aceleracionPromedio;
    protected double gradoRampa;

    public Escalador(int identificador, String nombre, double aceleracionPromedio, double gradoRampa) {
        super(identificador, nombre);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampa = gradoRampa;
    }

    public double getAceleracionPromedio() {
        return aceleracionPromedio;
    }

    public void setAceleracionPromedio(double aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }

    public double getGradoRampa() {
        return gradoRampa;
    }

    public void setGradoRampa(double gradoRampa) {
        this.gradoRampa = gradoRampa;
    }

    public void calcularTiempoParcial() {
        super.calcularTiempoParcial();
        double total = super.getTiempoAcumulado();
        total += (aceleracionPromedio * 3);
        super.setTiempoAcumulado(total);
    }

    @Override
    public String toString() {
        return super.toString() + "Escalador [aceleracionPromedio=" + aceleracionPromedio + ", gradoRampa=" + gradoRampa
                + "]";
    }

    protected String imprimirTipo() {
        return "Es un escalador";
    }
}

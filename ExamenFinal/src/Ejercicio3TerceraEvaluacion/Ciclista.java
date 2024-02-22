package Ejercicio3TerceraEvaluacion;

public abstract class Ciclista {
    private int identificador;
    private String nombre;
    private double tiempoAcumulado = 0;
    private int posicionGeneral = 0;

    public Ciclista(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(Double tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    protected int getPosicionGeneral() {
        return posicionGeneral;
    }

    protected void setPosicionGeneral(int posicionGeneral) {
        posicionGeneral = posicionGeneral;
    }

    protected void calcularTiempoParcial() {
        tiempoAcumulado += Math.random() * (20 - 5) + 5;
    }

    @Override
    public String toString() {
        return super.toString() + "Ciclista [identificador=" + identificador + ", nombre=" + nombre
                + ", tiempoAcumulado="
                + tiempoAcumulado + ", posicionGeneral=" + posicionGeneral + "]";
    }

    protected String imprimirTipo() {
        return "Es un ciclista";
    }
}

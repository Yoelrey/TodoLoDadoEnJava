package EJ5B;

public abstract class Ciclista {
    private int identificador;
    private String nombre;
    private int tiempoAcumulado = 0;
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

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    protected int getPosicionGeneral() {
        return posicionGeneral;
    }

    protected void setPosicionGeneral(int posicionGeneral) {
        posicionGeneral = posicionGeneral;
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


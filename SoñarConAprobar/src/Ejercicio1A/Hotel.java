package Ejercicio1A;

public class Hotel {
    private String Nombre;
    private int Capacidad;
    private int NumeroDePersonas;

    public Hotel(String nombre, int i, int j) {
        Nombre = nombre;
        Capacidad = i;
        NumeroDePersonas = j;
    }

    public int getNumeroDePersonas() {
        return (NumeroDePersonas);
    }

    public int getCapacidad() {
        return (Capacidad);
    }

    public boolean HayHueco() {
        return (NumeroDePersonas != Capacidad);
    }

    public boolean Haypersonas() {
        return (NumeroDePersonas != 0);
    }

    public void MetePersona() {
        System.out.println(this.toString());
        NumeroDePersonas++;
    }

    public void SacaPersonas() {
        System.out.println(this.toString());
        NumeroDePersonas--;
    }

    @Override
    public String toString() {
        return "Hotel [Nombre=" + Nombre + ", Capacidad=" + Capacidad + ", NumeroDePersonas=" + NumeroDePersonas + "]";
    }

}

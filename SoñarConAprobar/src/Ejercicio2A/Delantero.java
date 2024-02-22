package Ejercicio2A;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Delantero extends Jugador {
    private int golesMetidos;
    private int penaltisFallados;

    public Delantero() {
        super("sin nombre", "sin demarcacion", 0, 0, 0, 0);
        this.golesMetidos = 0;
        this.penaltisFallados = 0;
    }

    public Delantero(String n, String d, int p, int g, int a, int r, int golesMetidos, int penaltisFallados) {
        super(n, d, p, g, a, r);
        this.golesMetidos = golesMetidos;
        this.penaltisFallados = penaltisFallados;
    }

    public int getGolesMetidos() {
        return golesMetidos;
    }

    public void setGolesMetidos(int golesMetidos) {
        this.golesMetidos = golesMetidos;
    }

    public int getPenaltisFallados() {
        return penaltisFallados;
    }

    public void setPenaltisFallados(int penaltisFallados) {
        this.penaltisFallados = penaltisFallados;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Goles: " + golesMetidos);
        System.out.println("Penaltis Fallados: " + penaltisFallados);
    }
    

}

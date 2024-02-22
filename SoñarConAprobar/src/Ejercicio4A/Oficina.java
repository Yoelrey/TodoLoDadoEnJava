package Ejercicio4A;

public class Oficina extends Local {
    // protected static double valorArea=3500000;
    protected boolean esGobierno;

    public Oficina(int idTipo, int area, String direccion, tipo tipoLocal, boolean esGobierno) {
        super(idTipo, area, direccion, tipoLocal);
        this.esGobierno = esGobierno;
        setValorArea(3750);
    }

    @Override
    public String toString() {
        return super.toString() + "Oficina [valorArea=" + valorArea + ", esGobierno=" + esGobierno + "]";
    }

}

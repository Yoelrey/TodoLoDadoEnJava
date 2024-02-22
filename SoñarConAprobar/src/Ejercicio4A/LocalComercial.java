package Ejercicio4A;

public class LocalComercial extends Local {
    // protected static double valorArea=3000000;
    protected String centroComercial;

    public LocalComercial(int idTipo, int area, String direccion, tipo tipoLocal, String centroComercial) {
        super(idTipo, area, direccion, tipoLocal);
        this.centroComercial = centroComercial;
        setValorArea(3350);
    }

    @Override
    public String toString() {
        return super.toString() + "LocalComercial [valorArea=" + valorArea + ", centroComercial=" + centroComercial
                + "]";
    }

}

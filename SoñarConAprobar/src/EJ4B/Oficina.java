package EJ4B;



public class Oficina extends Local{
    //protected static double valorArea=3500000;
    protected boolean esGobierno;


   


    public Oficina(int idTipo, int area, String direccion, tipo tipoLocal, boolean esGobierno) {
        super(idTipo, area, direccion, tipoLocal);
        this.esGobierno = esGobierno;
        setValorArea(3500);
    }





    @Override
    public String toString() {
        return super.toString()+ "Oficina [valorArea=" + valorArea + ", esGobierno=" + esGobierno + "]";
    }

    @Override
    public double calcularImpuesto() {
        // TODO Auto-generated method stub
        double parcial = super.calcularImpuesto();
        if(esGobierno)
        parcial += 2000;
        return parcial; 
    }

}


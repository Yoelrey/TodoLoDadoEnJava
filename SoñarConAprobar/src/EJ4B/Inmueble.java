package EJ4B;



public class Inmueble implements Impuesto{

    protected static double valorArea=0;

    protected int idTipo;
    protected int area;
    protected String direccion;
    protected double precioVdenta;
    
    


   

    public Inmueble(int idTipo, int area, String direccion) {
        this.idTipo = idTipo;
        this.area = area;
        this.direccion = direccion;
    }




    public double calculaPrecio(){
        return  area*valorArea;
        
    }




    public static double getValorArea() {
        return valorArea;
    }




    public static void setValorArea(double valorArea) {
        Inmueble.valorArea = valorArea;
    }




    @Override
    public String toString() {
        return "Inmueble [idTipo=" + idTipo + ", area=" + area + ", direccion=" + direccion + ",valor=" +valorArea +"]";
    }




    @Override
    public double calcularImpuesto() {
        return 0d;
    }




    // public double calculaPrecio() {
    //     return 0;
    // }




   



    
    
    
}


package EJ4B;


import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
    ArrayList<Inmueble> terrenos= new ArrayList<Inmueble>();

        Inmueble Inmueble= new Inmueble(2, 200, "Camino de la oca coca 76");
        Vivienda Banco= new Vivienda(1, 2, "el parque de castrelos", 0, 500);
        Casa CasaPaco = new Casa(3, 120, "a esmorga vai barata 64", 3, 2, 2);
        // ConjuntoCerrado Pitas= new ConjuntoCerrado(4, 1, "trasera", 1, 1, 1, 1000000, 1, true);
        Estudio Enterprise = new Estudio(5, 100, "Avd Mario Kart", 12, 70);
        Familiar Pizza= new Familiar(6, 1, "soledad", 1000000000, 100000000, 0);
        Independiente Autonomo= new Independiente(7, 30, "Yupiii", 12, 9, 4);

        terrenos.add(Inmueble);
        terrenos.add(Banco);
        terrenos.add(CasaPaco);
        // terrenos.add(0, Pitas);
        terrenos.add(Enterprise);
        terrenos.add(Pizza);
        terrenos.add(Autonomo);
        double area=0;
        double total=0;
        double totalImpuesto=0;

        for(Inmueble i: terrenos ){
            System.out.println(i.toString());
            System.out.println(i.calculaPrecio());     
            System.out.println(i.calcularImpuesto());          
            totalImpuesto+=i.calcularImpuesto();
            total+=i.calculaPrecio();
            area+=i.getValorArea();
        }

        System.out.println("total ventas: "+total);
        System.out.println("area total: "+area);
        System.out.println("promedio por metro cuadrado: " + total / area);
        System.out.println("total de comisiones "+total);
    }

    
    
    
}


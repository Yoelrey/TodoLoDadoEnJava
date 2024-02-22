package Ejercicio1TerceraEvaluacion;

import java.util.ArrayList;

public class TestConcesionario {

	public static void main(String[] args) {
		Sedan se =new Sedan(100, 10000, "azul",4);
		Ford focus= new Ford(1000, 1233234, "rojo", 2, 3000);
		Car teto = new Car(200, 20000, "negro");
		
		ArrayList<Car>Concesionario=new ArrayList<>();
		Concesionario.add(se);
		Concesionario.add(focus);
		Concesionario.add(teto);

		double total=0;
		for(Car i: Concesionario) {
			System.out.println("Precio de venta final:"+i.getPrecioVenta() );
			total=+i.getPrecioVenta();
		}
		System.out.println(total);
	}
}

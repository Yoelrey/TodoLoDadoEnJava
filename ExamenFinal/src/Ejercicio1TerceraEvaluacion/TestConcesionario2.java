package Ejercicio1TerceraEvaluacion;

import java.util.ArrayList;

public class TestConcesionario2 {

	public static void main(String[] args) {
		Sedan se =new Sedan(100, 10000, "azul",4);
		Ford focus= new Ford(1000, 1233234, "rojo", 2, 3000);
		Car teto = new Car(200, 20000, "negro");
		Van va =new Van(234, 23000, "amarillo", 5000, 300);
		Suv su = new Suv(150, 12000, "negro", 200);
		ArrayList<Car>Concesionario=new ArrayList<>();
		Concesionario.add(se);
		Concesionario.add(focus);
		Concesionario.add(teto);
		Concesionario.add(va);
		Concesionario.add(su);

		double total=0;
		for(Car i: Concesionario) {
			System.out.println("Precio de venta final:"+i.getPrecioVenta() );
			total=total+i.getPrecioVenta();
		}
		System.out.println(total);
		
		
		se.Multa(34);
		focus.Multa(50);
		va.Multa(2);
		teto.Multa(80);
		su.Multa(40);
		for(Car i: Concesionario) {
			System.out.println("Precio de venta final:"+i.getPrecioVenta() );
			total=total+i.getPrecioVenta();
			System.out.println();
		}
	}
}

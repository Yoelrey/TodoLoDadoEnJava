package Ejercicio1TerceraEvaluacion;

public class Truck extends Car{

	int peso;
	@Override
	double getPrecioVenta() {
		// TODO Auto-generated method stub
		if(peso>2000) {
			return PrecioNormal*0.1;
		}else {
			return PrecioNormal*0.2;
		}
	}
	public Truck(int velocidad, double precioNormal, String color, int peso) {
		super(velocidad, precioNormal, color);
		this.peso = peso;
	}
	
}

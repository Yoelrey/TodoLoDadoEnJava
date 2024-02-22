package Ejercicio1TerceraEvaluacion;

public class Sedan extends Car{

	int longitud;
	@Override
	double getPrecioVenta() {
		if(longitud>5) {
			return PrecioNormal*0.05;
		}else {
			return PrecioNormal*0.1;
		}
	}
	public Sedan(int velocidad, double precioNormal, String color, int longitud) {
		super(velocidad, precioNormal, color);
		this.longitud = longitud;
	}
	
}

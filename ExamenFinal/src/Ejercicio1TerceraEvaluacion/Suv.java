package Ejercicio1TerceraEvaluacion;

public class Suv extends Car{
double potencia;

@Override
	double getPrecioVenta() {
	if(potencia>200) {
		return PrecioNormal*5;
	}else {
		return PrecioNormal*3;
	}
	
	}

public Suv(int velocidad, double precioNormal, String color, double potencia) {
	super(velocidad, precioNormal, color);
	this.potencia = potencia;
}


}

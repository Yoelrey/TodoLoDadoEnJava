package Ejercicio1TerceraEvaluacion;

public class Van extends Truck{

	double cilindrada;
	
	@Override
	double getPrecioVenta() {
		if(cilindrada>3000) {
			return PrecioNormal*3;
		}else {
			return PrecioNormal*4;
		}
	}

	public Van(int velocidad, double precioNormal, String color, int peso, double cilindrada) {
		super(velocidad, precioNormal, color, peso);
		this.cilindrada = cilindrada;
	}
}

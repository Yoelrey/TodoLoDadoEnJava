package Ejercicio1TerceraEvaluacion;

public class Ford extends Car{

	int anio;
	int DescuentoFabricante;
	@Override
	double getPrecioVenta() {
		// TODO Auto-generated method stub
		return PrecioNormal-DescuentoFabricante;
	}
	public Ford(int velocidad, double precioNormal, String color, int anio, int descuentoFabricante) {
		super(velocidad, precioNormal, color);
		this.anio = anio;
		DescuentoFabricante = descuentoFabricante;
	}
	
}

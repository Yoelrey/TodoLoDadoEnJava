package Ejercicio1TerceraEvaluacion;

public class Car implements Multable{
int velocidad;
double PrecioNormal;
String Color;

double getPrecioVenta() {
	return PrecioNormal;
}

public Car(int velocidad, double precioNormal, String color) {
	this.velocidad = velocidad;
	PrecioNormal = precioNormal;
	Color = color;
}

@Override
public String Multa(int cantidad) {
	// TODO Auto-generated method stub
	while (cantidad>0 && cantidad<100)	
	return "Su multa es de: "+cantidad;
	return "No tiene multas";
	
}

@Override
public String disminuirMulta(int cantidad) {
	// TODO Auto-generated method stub
	return "Se ha disminuido su multa en: "+cantidad;
}

@Override
public String aumentarMulta(int cantidad) {
	// TODO Auto-generated method stub
	return "Se ha aumentado su multa: "+cantidad;
}

}

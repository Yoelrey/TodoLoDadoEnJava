package Prueba;

public class Prueba2 {

	public static void main(String[] args) {
		int total =0;
	
		for (String a : args) {
			System.out.println(a);
			try {
				total +=Integer.parseInt(a);
			} catch (NumberFormatException e) {
				System.out.println(a+"no es un valor numerico");
			}
		}
			//Paso por variable (envia una copia de la variable para pasarlo por un metodo)
			//Paso por referencia (Envia direcctamente la direccion de memoria ; son los arrays y metodos)
			
			System.out.println("El total de la suma es "+total);
			
		
		
	}
		
}


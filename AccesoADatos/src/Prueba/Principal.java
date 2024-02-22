package Prueba;

public class Principal {

	Principal() {
		
	}
	public static void main(String[] args) {
		
//		while (args.length<6) {
//		System.out.println(args.length);
//		
//		for (int i =0; i < args.length ; i++) {
//			System.err.println(args[i]);
//		}
//		for (String j : args) {
//			System.out.println(j);
//		}
//	}
		
		try {
			int  k =0;
					
			do {
				System.out.println(args[k]);
				k++;
			}while(k>args.length);
			
		} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("no se muestra nada puto inutil");		}
		catch (ArithmeticException e1) {
			System.out.println("Hay q ser inutil pa dividir por cero");
		}
		
//		k=0;
//		
//		while(k<args.length) {
//			System.err.println(args[k]);
//			k++;
//		}
//Recoger un array de numeros en args 
		
		
		
		}
}


public class Excepciones {

	public static void main(final String[] args) {
		int numerador = 10, denominador = 0, cociente;
		try {
			cociente = numerador / denominador;
			System.out.println("Resultado = " + cociente);
		} catch (ArithmeticException ae) {
			System.out.println("Error de ejecución");
			ae.printStackTrace();
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Sos re puto amigo");
		}
	}
}

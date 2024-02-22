package PrimeraEvaluacion;
/*Se desea llevar un control del estado de una cuenta  corriente; 
la cuenta corriente est� caracterizada por su saldo y  el nombre de su titular y 
sobre ella se pueden realizar tres  tipos de operaciones: 
� Saldo: devuelve el saldo de la cuenta (puede ser negativo).  
� Dep�sito (cantidad): ingresa en la cuenta una cantidad de  dinero.  
� Retiro (cantidad): saca de la cuenta una determinada cantidad  de dinero.  
Suponga que la cuenta inicialmente tiene un saldo igual a cero.  
Tambi�n, necesitamos un contador de todas las cuentas bancarias  existentes. 
Adem�s, contendr�: Constructor por defecto.  Constructor con par�metros.
 M�todos setters/getters. M�todo  toString.  
Escriba una clase Cuenta Corriente que implemente las  funcionalidades descritas
*/
public class Cuenta {
	private String titular;
	private int saldo;
	public static int nCuentas;

	// Constructores
	// Constructor por defecto
	Cuenta() {
		titular = "";
		saldo = 0;
		nCuentas++;
	}

	// Constructores con par�metros
	Cuenta(int n) {
		titular = "";
		saldo = n;
		nCuentas++;
	}

	Cuenta(String nombre) {
		titular = nombre;
		saldo = 0;
		nCuentas++;
	}

	Cuenta(String nombre, int n) {
		titular = nombre;
		saldo = n;
		nCuentas++;
	}

	// M�todos
	public int saldo() {
		return saldo;
	}

	public void deposito(int cantidad) {
		saldo += cantidad;
	}

	public void retiro(int cantidad) {
		saldo -= cantidad;
	}

	// M�todos set/get
	public String getTitular() {
		return titular;
	}

	public int getNCuentas() {
		return nCuentas;
	}
	
	public int getSaldo() {
		return saldo;
	}

	public void setTitular(String nombre) {
		titular = nombre;
	}
	
	public void setSaldo(int n) {
		saldo = n;
	}
	
	@Override
	public String toString() {
		return "nCuentas = " + nCuentas + ", titular = " + titular + ", saldo = " + saldo;
	}

}


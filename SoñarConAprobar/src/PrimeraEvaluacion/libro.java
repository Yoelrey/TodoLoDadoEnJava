package PrimeraEvaluacion;
/* Crea una clase llamada Libro que guarde la informaci�n de cada uno de los libros
 * de una biblioteca. La clase debe guardar el t�tulo del libro, autor, 
 * n�mero de ejemplares del libro y n�mero de ejemplares prestados.
 * Adem�s, contendr�: Constructor por defecto. Constructor con par�metros. 
 * M�todos setters/getters. M�todo toString.
 * M�todo pr�stamo que incremente el atributo correspondiente cada vez que se realice
 * un pr�stamo del libro. No se podr�n prestar libros de los que no queden ejemplares
 * disponibles para prestar. Devuelve true si se ha podido realizar la operaci�n
 * y false en caso contrario.
 * M�todo devoluci�n que decremente el atributo correspondiente cuando se produzca
 * la devoluci�n de un libro. No se podr�n devolver libros que no se hayan prestado.
 * Devuelve true si se ha podido realizar la operaci�n y false en caso contrario.
 *
 * Util�cela creando al menos tres libros que prueben los m�todos.*/

public class libro {
	// Variables
		String titulo, autor;
		int numEjemplares, numPrestados;

		// Constructor por defecto
		libro() {
			titulo = "";
			autor = "";
			numEjemplares = 0;
			numPrestados = 0;
		}

		// Constructor con par�metros
		public libro(String titulo, String autor, int numEjemplares) {
			this.titulo = titulo;
			this.autor = autor;
			this.numEjemplares = numEjemplares;
			this.numPrestados = 0;
		}

		// Getters & Setters
		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public int getNumEjemplares() {
			return numEjemplares;
		}

		public void setNumEjemplares(int numEjemplares) {
			this.numEjemplares = numEjemplares;
		}

		public int getNumPrestados() {
			return numPrestados;
		}

		public void setNumPrestados(int numPrestados) {
			this.numPrestados = numPrestados;
		}

		// ToString
		@Override
		public String toString() {
			return "Libro [titulo=" + titulo + ", autor=" + autor + ", numEjemplares=" + numEjemplares + ", numPrestados="
					+ numPrestados + "]";
		}

		// M�todo Prestamo
		public boolean Prestamo() {
			if (numEjemplares < 1) {
				return false;
			} else {
				numPrestados++;
				numEjemplares--;
				return true;
			}
		}

		// M�todo Devoluci�n
		public boolean Devolucion() {
			if (numPrestados < 1) {
				return false;
			} else {
				numPrestados--;
				numEjemplares++;
				return true;
			}
		}
}

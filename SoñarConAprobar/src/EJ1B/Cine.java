package EJ1B;

public class Cine {

	int capacidad;
	int npersonas;

	
	Cine(int capacidad) {
		this.capacidad = capacidad;
		this.npersonas = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getnpersonas() {
		return npersonas;
	}

	@Override
	public String toString() {
		return "Cine [capacidad=" + capacidad + ", huecos=" + npersonas + "]";
	}

	// metodo meter
	public void meter() {
		if (npersonas > 0) {
			npersonas--;
			System.out.println(this.toString());
		} else
			System.out.println("No hay huecos en el cine, saca a alguien \n");
	}

	// metodo sacar

	public void sacar() {
		if (npersonas < capacidad) {
			npersonas++;
			System.out.println(this.toString());
		} else
			System.out.println("No hay gente en el cine, mete a alguien");
	}

}


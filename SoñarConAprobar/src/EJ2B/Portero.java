package EJ2B;

public class Portero extends Jugador{

	private int golesRecibidos;
	private int penaltisParados;
	
	public Portero(String nombre, String demarcacion, int partJugados, int golesMarc,
			int amarillas,int rojas, int golesReciv,int penaltisParados) {
		super(nombre,demarcacion,partJugados,golesMarc,amarillas,rojas);
		this.golesRecibidos=golesReciv;
		this.penaltisParados=penaltisParados;
	}
	
	
	
	public Portero() {
		super("sin nombre", "sin demarcacion", 0, 0, 0, 0);
		this.golesRecibidos=0;
		this.penaltisParados=0;
	}

	
	public int getGolesRecibidos() {
		return golesRecibidos;
	}


	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}


	public int getPenaltisParados() {
		return penaltisParados;
	}


	public void setPenaltisParados(int penaltisParados) {
		this.penaltisParados = penaltisParados;
	}

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Goles recividos: " + golesRecibidos);
		System.out.println("Penaltis parados: " + penaltisParados);
	}
	
	
	
	 
}


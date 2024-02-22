package EJ5B;

public class Contrarrelojista extends Ciclista {
    protected double velocidadMaxima;

    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "Contrarrelojista [velocidadMaxima=" + velocidadMaxima + "]";
    }

    protected String imprimirTipo() {
        return "Es un contrarrelojista";
    }

	public void setTiempoAcumulado(int tiempoAcumulado) {
		// TODO Auto-generated method stub
		
	}

}


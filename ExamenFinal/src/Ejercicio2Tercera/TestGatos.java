package Ejercicio2Tercera;

import java.util.ArrayList;

public class TestGatos {

	public static void main(String[] args) {
		ArrayList<Felino>Felinos=new ArrayList<>();
		
		Leopardo a= new Leopardo("perso",10,"negro", false, "calido");
		Leopardo b= new Leopardo("Miau",15,"blanco", false, "humedo");
		Leopardo c= new Leopardo("Libre",5,"marron", false, "seco");

		Felinos.add(a);
		Felinos.add(b);
		Felinos.add(c);
	
	}
}

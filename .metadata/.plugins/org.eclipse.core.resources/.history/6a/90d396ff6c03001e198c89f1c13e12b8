package Equipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Equipo {

	protected String nombre;
	protected double totalTiempo;
	protected String pais;
	protected static ArrayList <Ciclista>ListaEquipos=new ArrayList<>();

	
	public Equipo(String nombre, double totalTiempo, String pais) {
		super();
		this.nombre = nombre;
		this.totalTiempo = totalTiempo;
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTotalTiempo() {
		return totalTiempo;
	}
	public void setTotalTiempo(double totalTiempo) {
		this.totalTiempo = totalTiempo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", totalTiempo=" + totalTiempo + ", pais=" + pais + "]";
	}
	public static void algo() {
		for(Ciclista c: ListaEquipos) {
			System.out.println(c);
		}
		
		
		
 java.util.ListIterator<Ciclista>iter=ListaEquipos.listIterator();
 	while(iter.hasNext()) {
 		
	 iter.next().setPosiciónGeneral(iter.nextIndex());;
 }
	}
	
	

	
}


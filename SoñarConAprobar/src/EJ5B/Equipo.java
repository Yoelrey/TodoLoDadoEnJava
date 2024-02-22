package EJ5B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Equipo {
    private String nombre;
    private double totalTiempo = 0;
    private int posicion=0;
    private String pais;
    private ArrayList<Ciclista> listaCiclistas;
    public Object getlistaCiclistas;

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        listaCiclistas = new ArrayList<>();
    }

    

    public ArrayList<Ciclista> getListaCiclistas() {
        return listaCiclistas;
    }



    public void setListaCiclistas(ArrayList<Ciclista> listaCiclistas) {
        this.listaCiclistas = listaCiclistas;
    }



    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    private void setPais(String pais) {
        this.pais = pais;
    }

    public int getTotalTiempo() {
        return (int) totalTiempo;
    }

    private void setTotalTiempo(int totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

    public void añadirCiclista(Ciclista ciclista) {
        listaCiclistas.add(ciclista);
    }

    public void listarEquipo() {
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.get(i);

            System.out.println(c.toString());
        }
    }

    public void buscarCiclista() {
        boolean estar = false;
        Scanner sc = new Scanner(System.in);
        String nombreCiclista = sc.nextLine();
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.get(i);
            if (c.getNombre().equals(nombreCiclista)) {
                estar = true;
                System.out.println(c.getNombre());
            }

        }
        if (!estar)
            System.out.println("Nadie con ese nombre en el equipo");
    }

    public void calcularTotalTiempo() {
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.get(i);
            totalTiempo += c.getTiempoAcumulado();
        }
    }

    //ordenaPosiciones
    public void ordenaTiempo(){
        Collections.sort(listaCiclistas, new Comparator<Ciclista>(){
            public int compare(Ciclista c1, Ciclista c2 ){
                return c1.getTiempoAcumulado()- c2.getTiempoAcumulado();
            }

        }
        );
        
    ListIterator<Ciclista> iter= listaCiclistas.listIterator();
    while(iter.hasNext()){
       iter.next().setPosicionGeneral(iter.nextIndex());
        iter.next();
    
    }
    
    }





    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + ", totalTiempo=" + totalTiempo + ", pais=" + pais + "]";
    }

    public void setPosicionGeneral(int nextIndex) {
    }

}




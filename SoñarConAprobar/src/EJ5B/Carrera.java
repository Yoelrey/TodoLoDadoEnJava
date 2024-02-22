package EJ5B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class Carrera {

    // 
    private String nombre;
    private String pais;
    private ArrayList<Equipo> listaEquipos;
    ArrayList<Ciclista> clasificacion;

    public Carrera(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.listaEquipos = new ArrayList<>();
        //Se crea la lista de equipos que forman la carrera
        this.clasificacion = new ArrayList<>();
    }

    

    //BUSCARequipo
    public void buscarEquipo() {
        boolean estar = false;
        Scanner sc = new Scanner(System.in);
        String nombreEquipo = sc.nextLine();

        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo e = (Equipo) listaEquipos.get(i);
            if (e.getNombre().equals(nombreEquipo)) {
                estar = true;
                System.out.println(e.getNombre());
            }

        }//fin for
        if (!estar)
            System.out.println("Nadie con ese nombre en el equipo");

            //usando contains
            /*if(listaEquipos.contains(nombre));
              tal vez un equals
            */
            
    }

    public void añadirEquipo(Equipo equipo) {
        equipo.calcularTotalTiempo();
        listaEquipos.add(equipo);
        //Se agrega el equipo a la lista de equipos
    }

    public void listarEquipo() {
        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo e = (Equipo) listaEquipos.get(i);

            System.out.println(e.toString());
        }
    }


    //clasificacion equipos 
    public void clasificacionEquipos() {

        Collections.sort(listaEquipos, new Comparator<Equipo>(){
            public int compare(Equipo e1, Equipo  e2 ){
                return e1.getTotalTiempo()- e2.getTotalTiempo();
            }

        }
        );
        
    ListIterator<Equipo> iter= listaEquipos.listIterator();
    while(iter.hasNext()){
       iter.next().setPosicionGeneral(iter.nextIndex());
    
        }   
    }

        //clasificacion ciclista

        public void clasificacionCiclistas() {

            /*1/recorrer el arrayEquipos*/
            for(int i=0; i<listaEquipos.size(); i++) {
                Equipo e = listaEquipos.get(i);
            
            // 2/en cada elemento lista equipo añadir los ciclistas a atributo clasificacion
                for(int j=0; j  < ((ArrayList<Equipo>) e.getlistaCiclistas).size(); j++) {
                    Ciclista c = (Ciclista) ((ArrayList<Equipo>) e.getlistaCiclistas).get(j); 
                    clasificacion.add(c);
                }
            }
            Collections.sort(clasificacion, new Comparator<Ciclista>(){
                public int compare(Ciclista c1, Ciclista c2 ){
                    return c1.getTiempoAcumulado()- c2.getTiempoAcumulado();
                }
    
            }
            );
        }

        @Override
        public String toString() {
            return "Carrera [nombre=" + nombre + ", pais=" + pais + ", listaEquipos=" + listaEquipos
                    + ", clasificacion=" + clasificacion + "]";
        }

        

}

        



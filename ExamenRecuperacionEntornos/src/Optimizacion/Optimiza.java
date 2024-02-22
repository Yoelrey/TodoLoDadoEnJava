package Optimizacion;

import java.util.ArrayList;
import java.util.Arrays;


public class Optimiza {
   
    String nombres[] = {"Pera", "Manzana", "Limón", "Fresa"};
   
 
    /* Este cuenta cuantos nombres de X caracteres hay. Donde X se pasa como parámetro */
    /*Se elimina la variable num que era innecsaria,ahorando asi memoria*/
    int cuantosDeXCaracteres(int numCaracteres) {
        int total = 0;
                for(String nombre: nombres) {
            if(nombre.length()==numCaracteres) {
                
                total++;
            }
        }
        return total=total/nombres.length;
        
    }
   
       
    /* Este método devuelve un array con la primera letra de cada nombre */
    /*cambiando return letras.toArray(new String[letras.size()]); estamos ahorrando en memoria*/
    String[] arrayConPrimeraLetra() {
    	
        ArrayList<String> letras = new ArrayList<String>();
        
        for(int i=0;i<nombres.length;i++) {
        	
            letras.add(nombres[i].substring(0,1));
        }
        return (String[]) letras.toArray();
    }
   
    /*Este método devuelve el nombre con mayor longitud. Si hay varios de la misma longitud, devuelve el primero que encuentra*/
    String elMasLargo() {
        String mayor = "";
        for(String nombre: nombres) {
            if(nombre.length() > mayor.length()) {
                mayor = nombre;
            }	
            
        }
        return mayor;
       
    }
   
    /* Este método calcula cual es el nombre mas largo y se lo concatena al final de cada uno de los nombres*/
    /*Eliminando la variable letras estamos ahorrando memoria  */
    String[] concatenarNombreMasLargo() {
       
        for(int i=0;i<nombres.length;i++) {
            nombres[i] = nombres[i]+"-"+elMasLargo();
        }
        return nombres;
    }

    /* Este método mira si ya está el nombre de la fruta en la lista*/
    /*Se pone en true el boolean evitando cambiar la variable cuando se encuentre y ahorrando ciclos del procesador*/
    boolean repetido(String buscar){
        boolean encontrado = true;
        for(String nombre: nombres){
            if(buscar.equals(nombre)){
           }
        }
        return encontrado;
    }
   
   
   
    public static void main(String[] args) {
        new Optimiza();
    }
   
    public Optimiza() {
        System.out.println("Lista de nombres: "+ Arrays.toString(nombres));
        System.out.println("Ya está en la lista el nombre Angel:"+ repetido("Angel"));
        System.out.println("Ya está en la lista el nombre Fresa:"+ repetido("Fresa"));
        System.out.println("Cuantos nombres de 5 caracteres hay:"+ cuantosDeXCaracteres(5));
        System.out.println("Obtener la primera letra de cada nombre:"+ Arrays.toString(arrayConPrimeraLetra()));
        System.out.println("El nombre mas largo es:"+ elMasLargo());
        System.out.println("La lista de nombres concatenandole el mas largo:"+ Arrays.toString(concatenarNombreMasLargo()));
    }
}

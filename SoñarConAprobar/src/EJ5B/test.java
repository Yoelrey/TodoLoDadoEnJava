package EJ5B;

public class test {
    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("Sky", "Estados Unidos");
        Velocista velocista1 = new Velocista(123979, "Geraint Thomas", 320, 25);
        Escalador escalador1 = new Escalador(123980, "Egan Bernal", 25, 10);
        Contrarrelojista contrarrelojista1 = new Contrarrelojista(123981, "Jonathan Castroviejo", 120);

        Equipo equipo2 = new Equipo("Movistar", "España");
        Velocista velocista2 = new Velocista(123979, "Pepe luis", 320, 25);
        Escalador escalador2 = new Escalador(123980, "Alba Cete", 25, 10);
        Contrarrelojista contrarrelojista2 = new Contrarrelojista(123981, "Elver Galarga", 120);


        equipo1.añadirCiclista(velocista1);
        equipo1.añadirCiclista(escalador1);
        equipo1.añadirCiclista(contrarrelojista1);
        System.out.println("Antes de la prueba");
        equipo1.toString();

        equipo2.añadirCiclista(velocista2);
        equipo2.añadirCiclista(escalador2);
        equipo2.añadirCiclista(contrarrelojista2);
        System.out.println("Antes de la prueba");
        equipo2.toString();

        Carrera giro = new Carrera("giro", "italia");
        giro.añadirEquipo(equipo1);
        giro.añadirEquipo(equipo2);


        velocista1.setTiempoAcumulado(365);
        escalador1.setTiempoAcumulado(385);
        contrarrelojista1.setTiempoAcumulado(370);

        velocista2.setTiempoAcumulado(330);
        escalador2.setTiempoAcumulado(380);
        contrarrelojista2.setTiempoAcumulado(350);


        equipo1.calcularTotalTiempo();
        System.out.println("Despues de la prueba");
        System.out.println();
        equipo1.toString();
        equipo1.listarEquipo();

      
        equipo2.calcularTotalTiempo();
        System.out.println("Despues de la prueba");
        System.out.println();
        equipo2.toString();
        equipo2.listarEquipo();

        equipo1.ordenaTiempo();
        equipo2.ordenaTiempo();
        
        giro.clasificacionCiclistas();
        System.out.println("clasificacion general ordenada");
        
        System.out.println(giro.clasificacion.toString());

    }

}

package Ejercicio5A;

public class Test {
    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("Sky", "Estados Unidos");
        Velocista velocista1 = new Velocista(123979, "Geraint Thomas", 320, 25);
        Escalador escalador1 = new Escalador(123980, "Egan Bernal", 25, 10);
        Contrarrelojista contrarrelojista1 = new Contrarrelojista(123981, "Jonathan Castroviejo", 120);

        Equipo equipo2 = new Equipo("Movistar", "España");
        Velocista velocista2 = new Velocista(123979, "Pepe luis", 320, 25);
        Escalador escalador2 = new Escalador(123980, "Alba Cete", 25, 10);
        Contrarrelojista contrarrelojista2 = new Contrarrelojista(123981, "Elver Galarga", 120);

        Equipo equipo3 = new Equipo("Skyp", "Estados Unidos");
        Velocista velocista3 = new Velocista(123979, "Ghiooeraint Thomas", 320, 25);
        Escalador escalador3 = new Escalador(123980, "Egan Bernjujtal", 25, 10);
        Contrarrelojista contrarrelojista3 = new Contrarrelojista(123981, "Jonaiiiithan Castroviejo", 120);

        Equipo equipo4 = new Equipo("Skypper", "Estados Unidos");
        Velocista velocista4 = new Velocista(123979, "Geraasdadint Thomas", 320, 25);
        Escalador escalador4 = new Escalador(123980, "Efergfgan Bernal", 25, 10);
        Contrarrelojista contrarrelojista4 = new Contrarrelojista(123981, "Jonathan Cgrfgastroviejo", 120);

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

        equipo3.añadirCiclista(velocista3);
        equipo3.añadirCiclista(escalador3);
        equipo3.añadirCiclista(contrarrelojista3);
        System.out.println("Antes de la prueba");
        equipo3.toString();

        equipo4.añadirCiclista(velocista4);
        equipo4.añadirCiclista(escalador4);
        equipo4.añadirCiclista(contrarrelojista4);
        System.out.println("Antes de la prueba");
        equipo4.toString();

        Carrera giro = new Carrera("giro", "italia");
        giro.añadirEquipo(equipo1);
        giro.añadirEquipo(equipo2);
        giro.añadirEquipo(equipo3);
        giro.añadirEquipo(equipo4);

        for (int i = 0; i < 4; i++) {
            velocista1.calcularTiempoParcial();
            escalador1.calcularTiempoParcial();
            contrarrelojista1.calcularTiempoParcial();

            velocista2.calcularTiempoParcial();
            escalador2.calcularTiempoParcial();
            contrarrelojista2.calcularTiempoParcial();

            velocista3.calcularTiempoParcial();
            escalador3.calcularTiempoParcial();
            contrarrelojista3.calcularTiempoParcial();

            velocista4.calcularTiempoParcial();
            escalador4.calcularTiempoParcial();
            contrarrelojista4.calcularTiempoParcial();

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

            equipo3.calcularTotalTiempo();
            System.out.println("Despues de la prueba");
            System.out.println();
            equipo3.toString();
            equipo3.listarEquipo();

            equipo4.calcularTotalTiempo();
            System.out.println("Despues de la prueba");
            System.out.println();
            equipo4.toString();
            equipo4.listarEquipo();

            equipo1.ordenaTiempo();
            equipo2.ordenaTiempo();
            equipo3.ordenaTiempo();
            equipo4.ordenaTiempo();

            giro.clasificacionCiclistas();
            System.out.println("clasificacion general ordenada");

            System.out.println(giro.clasificacion.toString());
        }

    }

}

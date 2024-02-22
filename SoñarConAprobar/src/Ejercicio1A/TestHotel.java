package Ejercicio1A;

import java.util.Scanner;

public class TestHotel {
    public static void main(String[] args) {

        Hotel uno = new Hotel("java1", 4, 0);
        Hotel dos = new Hotel("java2", 6, 0);
        Hotel tres = new Hotel("java3", 8, 0);

        String Accion;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("e Entra un Huesped // f sale un Huesped // Salir");
            Accion = sc.nextLine();

            if (Accion.equals("e")) {
                if (uno.HayHueco()) {
                    uno.MetePersona();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else if (dos.HayHueco()) {
                    dos.MetePersona();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else if (tres.HayHueco()) {
                    tres.MetePersona();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else
                    System.out.println("Todo completo, hay que esperar a que un huesped finalice su estancia");
                uno.toString();
                dos.toString();
                tres.toString();
            }

            else {
                if (uno.Haypersonas()) {
                    uno.SacaPersonas();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else if (dos.Haypersonas()) {
                    dos.SacaPersonas();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else if (tres.Haypersonas()) {
                    tres.SacaPersonas();
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

                else {
                    System.out.println("Todo vacío, no hay personas en ningún hotel");
                    uno.toString();
                    dos.toString();
                    tres.toString();
                }

            }

        } while (!Accion.equals("Salir"));
    }
}

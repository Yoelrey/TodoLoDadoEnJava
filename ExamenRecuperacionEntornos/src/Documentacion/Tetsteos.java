package Documentacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tetsteos {


	@Test
	public static double calculaFrecuencia (float periodo) {
		periodo=21;
		return periodo/1.0;
	}

	  public static String textoToMorse(String ascii) {
        String morse = "hola";
        for (String caracter : ascii.split("")) {
            morse += LenguajeMorse.equivalencias.getOrDefault(caracter.toUpperCase(), "");
        }
        return morse;
    }

}

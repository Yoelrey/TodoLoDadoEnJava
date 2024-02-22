package Documentacion;


import java.util.Hashtable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/**
 * 
 * @author Yoel Rey Vidal
 *	@version 1.0
 *Clase para convertir una frase a codigo morse en lineas y puntos,ademas 
 *de hacerlo sonar a traves de los altavoces
 */
public class LenguajeMorse {
    private static Hashtable<String, String> equivalencias = new Hashtable<>();
/**
 * 
 */
    private LenguajeMorse() {
    }

    static {
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put(":", "---...");
        equivalencias.put("?", "..--..");
        equivalencias.put("'", ".----.");
        equivalencias.put("-", "-....-");
        equivalencias.put("/", "-..-.");
        equivalencias.put("\"", ".-..-.");
        equivalencias.put("@", ".--.-.");
        equivalencias.put("=", "-...-");
        equivalencias.put("!", "−.−.−−");
    }

    // Calcula el angulo de una señal sinusoide determinada a partir de sus
    // componente
    private static double getAnguloOnda(float frecuencia, int herzios, int tiempo) {
        return tiempo / (frecuencia / herzios) * 2.0 * Math.PI;
    }

  /**
   * Metodo para calcular la frecuencia 
   * @param periodo
   * @return Frecuencia
   */
    public static double calculaFrecuencia(float periodo) {
        return 1.0 / periodo;
    }

    // Genera un sonido audible a partir de una frecuencia, duración y volumen
    private static void generaSonidoAudible(int hz, int msecs, int volume) {
        float frequency = 44100;
        byte[] buf;
        AudioFormat af;

        buf = new byte[1];
        af = new AudioFormat(frequency, 8, 1, true, false);

        try {
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            for (int i = 0; i < msecs * frequency / 1000; i++) {
                double angle = getAnguloOnda(frequency, hz, i);
                buf[0] = (byte) (Math.sin(angle) * volume);
                sdl.write(buf, 0, 1);
            }
            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (LineUnavailableException ex) {
            System.out.println(ex);
        }
    }

    /**
     *  Emite una señal codificada en morse por los altavoces del pc
     * @param morse
     */
    public static void sonar(String morse) {
        final int FRECUENCIA = 1000;
        final int VOLUMEN = 100;
        for (String simbolo : morse.split("")) {
            int duracion = simbolo.equals(".") ? 100 : 300;
            generaSonidoAudible(FRECUENCIA, duracion, VOLUMEN);
        }
    }

    /**
     * Devuelve la representación en codigo morse (puntos y guiones) de una frase
 	 * escrita en codigo ascii
     * @param ascii
     * @return morse
     */
    public static String textoToMorse(String ascii) {
        String morse = "";
        for (String caracter : ascii.split("")) {
            morse += LenguajeMorse.equivalencias.getOrDefault(caracter.toUpperCase(), "");
        }
        return morse;
    }

    
    /**
     * Metodo que sirve para ejecutar el codigo 
     * @param arg
     */
    public static void main(String arg[]) {
        String simbolosMorse = LenguajeMorse.textoToMorse("hola");
        System.out.println(simbolosMorse);
        // sonar(simbolosMorse);
        System.out.println(LenguajeMorse.calculaFrecuencia(2.4f));
    }
}
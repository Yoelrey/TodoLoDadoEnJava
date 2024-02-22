package uptChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerChat {

	public static void main(String[] args) throws Exception {

		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] enviados = new byte[1024];
		byte[] recibidos = new byte[1024];
		String cad;

		while (true) {
			System.out.println("Esperando datagrama...");
			recibidos = new byte[1024];
			DatagramPacket recibido = new DatagramPacket(recibidos, recibidos.length);
			serverSocket.receive(recibido);
			cad = new String(recibido.getData());

			InetAddress IPorigen = recibido.getAddress();
			int puerto = recibido.getPort();
			System.out.println("Origen " + IPorigen + " i " + puerto);

			String mayus = cad.trim().toUpperCase();
			enviados = mayus.getBytes();

			DatagramPacket enviado = new DatagramPacket(enviados, enviados.length, IPorigen, puerto);
			serverSocket.send(enviado);

			if (cad.trim().equals("*"))
				break;

		}

		serverSocket.close();
		System.out.println("Socket cerrado");
	}

	public static String respuestaAlCliente(String cad) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Mensaje recibido: " + cad.trim());
		System.out.println("mensaje a enviar: ");
		String respuesta = sc.nextLine();
		return respuesta;
	}
}

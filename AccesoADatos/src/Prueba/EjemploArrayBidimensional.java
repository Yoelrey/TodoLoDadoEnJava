package Prueba;
import javax.swing.JOptionPane;

public class EjemploArrayBidimensional {

	public static void main(String [] args) {
		//boolean [][] combinaciones=new boolean[3][3];
		boolean [][] combinaciones= {{true,true,true},{false,true,false},{false,true,true}};
		
		
		for(int i=0;i<combinaciones.length;i++) {
			for(int j=0;j<combinaciones.length;j++) {
				System.out.print(combinaciones[i][j]+" ");
				
			}
			System.out.println();
		}
		
		String color="";
		String modelo="";
		int indiceColor=0;
		int indiceModelo=0;
		do {
			
		
		
		JOptionPane.showMessageDialog(null, "Introduzca el modelo");
		modelo=JOptionPane.showInputDialog("Modelo").toLowerCase();
		
		JOptionPane.showMessageDialog(null, "Introduzca el color");
		color=JOptionPane.showInputDialog("Color").toLowerCase();
		
		switch(modelo) {
		case "ibiza":
			indiceModelo=0;
			break;
		case "cordoba":
			indiceModelo=1;

			break;
		case "toledo":
			indiceModelo=2;
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Modelo incorrecto");
		}
		
		
		switch(color) {
		case "amarillo":
			indiceColor=0;
			break;
		case "blanco":
			indiceColor=1;
			break;
		case "rojo":
			indiceColor=2;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Color incorrecto");
		}
		
		if (colorDisponible(indiceModelo,indiceColor,combinaciones)) {
			JOptionPane.showMessageDialog(null, "Combinacion válida");
		}else {
			JOptionPane.showMessageDialog(null, "Combinacion no válida");

		}
		}while(color=="true"&& modelo== "");
		}
	
	private static boolean colorDisponible(int modelo,int color,boolean [][] valores) {
		return valores[modelo][color];
	}
	
}
package Ejercicio1;

import javax.swing.filechooser.*;
import javax.swing.JFileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		
		JFileChooser fi = new JFileChooser();
		fi.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File archivo = null;
		String extension = "";
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt", "doc", "docx");
		fi.setFileFilter(filter);
		do {
			int seleccion = fi.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				archivo = fi.getSelectedFile();
				String fileName = archivo.getName();
				extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			}
		} while (!extension.equals("txt"));
		
		
		Scanner sc= new Scanner(System.in);
		FileWriter fil= new FileWriter(archivo);
		System.out.println("Dame un numero para generar numeros aleatorios");
		int aletorios= sc.nextInt();
	
		for (int i=0; i<aletorios;i++) {
			int n = (int) Math.random();
			fil.write(n);
			
		}
		
		
		
		
			
		
	}

}
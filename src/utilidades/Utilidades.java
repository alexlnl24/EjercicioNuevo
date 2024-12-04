package utilidades;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {
	public static String introducirCadena(String mensaje) {
		
		Scanner teclado= new Scanner(System.in);
		String cadena=null;
		
		System.out.println(mensaje);
		try {
			cadena= teclado.next();
		} catch (NoSuchElementException e) {
			System.out.println("Error al introducir cadena");
		}
		return cadena;
		
	}
	
	public static int introducirNota(String mensaje) {
		
		int nota=0;
		String cadena;
		boolean correcto= true;
		
		do {
			cadena= introducirCadena(mensaje);
		try {
			nota= Integer.parseInt(cadena);
		} catch (NumberFormatException e) {
			System.out.println("Error esto no es un nuero entero");
			correcto= false;
		}
		}while(!correcto);
		
		return nota;
	}
	
	public static char introducirCaracter(String mensaje) {
		
		boolean error=false;
		String letra;
		
		do{
			error=false;
			letra=introducirCadena(mensaje);
			if(letra.length()!=1){
				System.out.println("Error, introduce un car ccter: ");
				error=true;
			}
			
		}while(error);
		return letra.charAt(0);	
	}
	
	public static boolean esBoolean(String mensaje){
		String respu;
		do{
			respu=introducirCadena(mensaje).toLowerCase();
		}while(!respu.equals("0") &&!respu.equals("1") && !respu.equals("si") && !respu.equals("no") && !respu.equals("s") && !respu.equals("n") && !respu.equals("true") && !respu.equals("false") );
		if(respu.equals("1")||respu.equals("si")||respu.equals("s")||respu.equals("true")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static float leerFloat(String mensaje) {
		float fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el n mero");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}


}

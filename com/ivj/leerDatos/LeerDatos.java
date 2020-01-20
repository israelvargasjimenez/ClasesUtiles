package com.ivj.leerDatos;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author SSDIsrael
 *
 */
public class LeerDatos {

	/**
	 * @return 
	 * 
	 */
	public LeerDatos() {

	}


	//Metodo que lee un número por teclado como Integer. El número al ser un Integer y pasarse
	// por referencia, se verá modificado por el valor tecleado, si es correcto.
	public static Integer setNumero() {	
		Integer numero = null;
		boolean correcto = false;
		do {
			try {
				numero =  new Scanner(System.in).nextInt();	
				correcto = true;

			}catch (InputMismatchException e) {
				System.out.println("********************************************");
				System.out.println("Error al tratar el número, tecleelo de nuevo.");
				correcto = false;
			}
		}while (correcto == false);	
		return numero;
	}
	
	
	//Metodo que lee una frase introducida desde teclado
	public static String setFrase() {
		boolean correcta = false;
		String frase ="";		
		do {
			try {
				frase = new Scanner(System.in).nextLine();
				correcta = true;
				
			}catch (NoSuchElementException e) {
				System.out.println("Se ha producido un error al teclear la frase, intentelo de nuevo.");
			}
			}while ( correcta == false);
		return frase;
	}
	
	//Metodo que lee un número del tipo float
		public static float setFloat() {
			boolean correcto = true;
			float numero = 0;		
			do {
				try {
					numero = new Scanner(System.in).nextFloat();
				}catch (InputMismatchException e) {
					System.out.println("El formato del número teclado no es correcto, intentelo de nuevo.");
					correcto = false;
				}
				}while ( correcto == false);
			return numero;
		}
		
		//Metodo que lee un número del tipo Double
				public static Double setDouble() {
					boolean correcto = true;
					Double numero = 0.0;		
					do {
						try {
							numero = new Scanner(System.in).nextDouble();
							correcto = true;
						}catch (InputMismatchException e) {
							System.out.println("El formato del número teclado no es correcto, intentelo de nuevo.");
							correcto = false;
						}
						}while ( correcto == false);
					return numero;
				}
}
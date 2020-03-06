package com.ivj.utiles;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 */

/**
 * Clase que sirve para leer datos del teclado
 * Los tipos de datos que lee son: Integer; String; Float; Double; Character.
 * No se podrá continuar hasta que el tipo de dato tecleado sea el correcto sengún el metodo ejecutado.
 * @author Israel Vargas Jiménez
 * @version 1.0
 * @Fecha 4-3-2020
 *
 */
public class LeerDatos {

	/**
	 * @return 
	 * 
	 */
	public LeerDatos() {

	}


	/**
	 * Metodo estatico que devuelve un objeto del tipo Integer
	 * @param 
	 * @return numero Integer 
	 */
	public static Integer leerInteger() {	
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
	
	/**
	 * Metodo estatico que devuelve un objeto del tipo Integer
	 * @param 
	 * @return numero Integer 
	 */
	public static Long leerLong() {	
		Long numero = null;
		boolean correcto = false;
		do {
			try {
				numero =  new Scanner(System.in).nextLong();	
				correcto = true;

			}catch (InputMismatchException e) {
				System.out.println("********************************************");
				System.out.println("Error al tratar el número, tecleelo de nuevo.");
				correcto = false;
			}
		}while (correcto == false);	
		return numero;
	}
	
	/**
	 * Metodo estatico que devuelve un objeto del tipo String
	 * @param 
	 * @return frase String 
	 */
	public static String leerString() {
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
	
	
	/**
	 * Metodo estatico que devuelve un objeto del tipo Float
	 * @param 
	 * @return numero Float 
	 */
		public static Float leerFloat() {
			boolean correcto = true;
			Float numero = (float) 0;	
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
		
		/**
		 * Metodo estatico que devuelve un objeto del tipo Double
		 * @param 
		 * @return numero Double 
		 */
				public static Double leerDouble() {
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
				
				
				/**
				 * Metodo estatico que devuelve un objeto del tipo Character
				 * @param 
				 * @return numero Character 
				 */
				public static Character leerCharacter() {
					boolean correcto = true;
					Character caracter = ' ';		
					do {
						try {
							caracter = leerString().charAt(0);
							correcto = true;
						}catch (IndexOutOfBoundsException e) {
							System.out.println("El caracter tecleado no es válido, intentelo de nuevo.");
							correcto = false;
						}
						}while ( correcto == false);
					return caracter;
				}
}
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
	 * Metodo estatico que devuelve un objeto del tipo Long
	 * @param 
	 * @return numero Long 
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
	 * Metodo estatico que devuelve el String con las iniciales de cada palabra
	 * de la frase en mayuscula	 	 * 
	 * @param
	 * @return frase con iniciales en mayuscula String
	 */
	public static String leerStringInicialesMayusculas() {
		boolean correcta = false;
		// Variable que almacena la frase inicial tecleada por el usuario
		String frase = "";
		// Variable que almacena la frase inicial del usuario, dividida por palabras y
		// sin espacios
		String[] palabrasString;
		// Variable que almacena la palabra String que toque (según i) dividida por
		// caracteres
		char[] palabraArray;
		// Variables que almacena cada palabra en formato String con la incial en
		// mayuscula
		String[] palabrasTratadas;
		// Variable String que almacena la frase completamente tratada, ya lista para
		// ser devuelta.
		String fraseFinal = "";

		do {
			try {
				//Variable que indica si se ha detectado un número como parte del
				// nombre del contacto
				boolean numeroDetectado = false;
				//Variable que indica que no se ha introducido el nombre del contacto
				boolean enBlanco = false;
				do {
					//Se imprime el menú de introducir usuario si se ha creado un error
					//al meter el usuario en el intento anterior
					if ( numeroDetectado || enBlanco) {
						System.out.print("Teclee una frase: ");
						numeroDetectado = false;
						enBlanco = false;
					}
					frase = new Scanner(System.in).nextLine().toLowerCase();
					correcta = true;
					palabrasString = frase.split(" ");
					palabrasTratadas = new String[palabrasString.length];
					numeroDetectado = isNumber(frase);
					if (frase.length() <= 0) {
						enBlanco= true;
					}
					enBlanco = frase.length() <= 0;
				} while (enBlanco || isNumber(frase));

				for (int i = 0; i < palabrasString.length; i++) {
					// Se divide la palabra String de turno ( segun i) en un char []
					palabraArray = palabrasString[i].toCharArray();
					// Se coge la primera letra de la palabraArray y se convierte a mayuscula
					Character mayuscula = Character.toUpperCase(palabraArray[0]);
					// Se guarda en palabraArray la primera letra en mayuscula.
					palabraArray[0] = mayuscula;
					// Se guarda la palabra ya con la incial en mayuscula en formato String
					// en ek String [] palabras tratadas
					palabrasTratadas[i] = new String(palabraArray);
				}
				fraseFinal = concatenaStringContenidosEnArray(palabrasTratadas);
			} catch (NoSuchElementException e) {
				System.out.println("Error en el formato de la frase tecleada");
			}
		} while (correcta == false);
		return fraseFinal;
	}

	
	
	/**
	 * Metodo que convierte a un único String un array que contiene diferentes String
	 * @param palabras String []
	 * @return fraseFinal String
	 */
	public static String concatenaStringContenidosEnArray(String[] palabras) {
		// Variable que almacena el String terminado a devolver
		String fraseFinal = null;
		// Almacena el String en construccion
		String fraseAux;

		// Se escribe en fraseAux la primera palabra seguida de un espacio
		fraseAux = palabras[0];
		fraseAux = fraseAux.concat(" ");

		// Se van concatenando las siguientes palabras con las palabras ya guardadas
		// en fraseAux, poniendo después un espacio si la palabra a concatenar no es
		// la última. Si la palabra fuera la última solo se concatenaría dicha palabra
		for (int i = 1; i < palabras.length; i++) {
			if (i < palabras.length - 1) {
				fraseAux = fraseAux.concat(palabras[i]);
				fraseAux = fraseAux.concat(" ");
			} else {
				fraseAux = fraseAux.concat(palabras[i]);
			}
			fraseFinal = fraseAux;
		}
		return fraseFinal;
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
				
				/**
				 * Metodo que comprueba si la frase del tipo String pasada como argumento
				 * contiene números
				 * 
				 * @param digitos String
				 * @return false si la frase no contiene números.
				 */
				public static boolean isNumber(String digitos) {
					// se separa la frase en digitos individuales
					char[] digitosseparados = digitos.toCharArray();

					//Se comprueba uno por uno los caracteres por si son números
					for (int i = 0; i < digitosseparados.length; i++) {
						if (Character.isDigit(digitosseparados[i])) {
							return true;
						}
					}
					return false;
				}
}
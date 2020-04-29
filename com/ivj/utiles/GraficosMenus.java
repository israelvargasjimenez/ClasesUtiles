package com.ivj.utiles;

/**
 * Clase que realiza una  maquetación  sencilla de la salida de textos por pantalla
 * @author Israel Vargas
 */

import java.util.ArrayList;

public class GraficosMenus {

	public GraficosMenus() {

	}

	/**
	 * Metodo que imprime un texto de varias lineas dentro de un marco realizado con
	 * el caracter pasado como argumento
	 * 
	 * @param textos:ArrayList
	 * @param caracter: char
	 * @param cantidadCaracteresLaterales: int
	 * @param espaciosLaterales: int
	 * @param tabulacion:int
	 */
	public static void imprimeMarcoConTexto(ArrayList<String> textos, char caracter, int cantidadCaracteresLaterales,
			int cantidadCaracteresVerticales, int espaciosLaterales, int tabulacion) {
		// Caracteres máximos de la frase mayor en textos
		int caracteresTotales = 0;

		// variable que almacena el contador de caracteres utilizados en la frase actual
		int contador = 0;

		/// Se averigua los caracteres máximos a utilizar
		for (String frase : textos) {
			if (caracteresTotales < frase.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2)) {
				caracteresTotales = frase.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2);
			}
		}

		// Se imprimen las lineas superiores del marco
		for (int b = 0; b < cantidadCaracteresVerticales; b++) {
			// Se aplica la tabulación indicada
			tabular(tabulacion);
			for (int i = 0; i < caracteresTotales; i++) {
				System.out.print(caracter);
			}
			System.out.println();
		}

		// Se recorre el ArrayList pasado como argumento
		for (int i = 0; i < textos.size(); i++) {
			contador = caracteresTotales;

			// Se aplica la tabulación indicada
			tabular(tabulacion);

			// Se imprimen los caracteres laterales
			for (int j = 0; j < cantidadCaracteresLaterales; j++) {
				System.out.print(caracter);
				contador--;
			}

			// Se imprimen los espacios laterales izquierdos
			for (int j = 0; j < espaciosLaterales; j++) {
				System.out.print(" ");
				contador--;
			}

			// Se imprime la frase de turno
			System.out.print(textos.get(i));
			contador = contador - (textos.get(i).length());

			// Se imprimen los espacios laterales derechos
			for (int j = 0; j < (contador - cantidadCaracteresLaterales); j++) {
				System.out.print(" ");
			}

			// Se imprimen los caracteres finales
			for (int j = 0; j < cantidadCaracteresLaterales; j++) {
				System.out.print(caracter);
			}
			System.out.println();
			// Se recarga el contador de caracteres consumidos, para la siguientes línea
			contador = caracteresTotales;
		}
		for (int c = 0; c < cantidadCaracteresVerticales; c++) {
			// Se aplica la tabulación indicada
			tabular(tabulacion);
			// Se imprime la linea inferior del marco
			for (int i = 0; i < caracteresTotales; i++) {
				System.out.print(caracter);
			}
			System.out.println();
		}
	}

	/**
	 * Metodo que imprime la linea de texto pasada como argumento, dentro de un
	 * marco realizado con el caracter pasado como argumento.
	 * 
	 * @param lineaTexto: String
	 * @param caracter: char
	 * @param cantidadCaracteresLaterales: int
	 * @param espaciosLaterales: int
	 * @param tabulacion: int
	 */

	public static void imprimeMarcoConLineaTexto(String lineaTexto, char caracter, int cantidadCaracteresLaterales,
			int espaciosLaterales, int tabulacion) {
		// Caracteres máximos de la frase mayor en textos
		int caracteresTotales = lineaTexto.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2);

		// variable que almacena el contador de caracteres utilizados en la frase actual
		int contador = 0;

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime la linea superior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se inicializa el contador de caracteres consumidos
		contador = caracteresTotales;

		// Se imprimen los caracteres laterales
		for (int j = 0; j < cantidadCaracteresLaterales; j++) {
			System.out.print(caracter);
			contador--;
		}

		// Se imprimen los espacios laterales izquierdos
		for (int j = 0; j < espaciosLaterales; j++) {
			System.out.print(" ");
			contador--;
		}

		// Se imprime la frase de turno
		System.out.print(lineaTexto);
		contador = contador - (lineaTexto.length());

		// Se imprimen los espacios laterales derechos
		for (int j = 0; j < (contador - cantidadCaracteresLaterales); j++) {
			System.out.print(" ");
		}

		// Se imprimen los caracteres finales
		for (int j = 0; j < cantidadCaracteresLaterales; j++) {
			System.out.print(caracter);
		}
		System.out.println();
		// Se recarga el contador de caracteres consumidos, para la siguientes línea
		contador = caracteresTotales;

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime la linea inferior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();
	}

	/**
	 * Metodo que imprime y subraya el texto pasado como argumento, utilizando el
	 * caracter indicado
	 * 
	 * @param texto: String
	 * @param caracter: char
	 * @param tabulacion: int
	 */
	public static void subRayaFrase(String texto, char caracter, int tabulacion) {
		// Almacena el tamaño de la frase pasada como argumento
		int lengthFrase = texto.length();

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime frase de turno y se subraya con el caracter pasado como argumento
		System.out.println(texto);

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se subraya frase
		for (int i = 0; i < lengthFrase; i++) {
			System.out.print(caracter);
		}
		System.out.println();
	}

	/**
	 * Metodo que acota verticalmente la frase pasada como argumento
	 * 
	 * @param lineaTexto :String
	 * @param            caracter: char
	 * @param            tabulacion: int
	 */
	public static void acotaLineaTextoVerticalmente(String lineaTexto, char caracter, int tabulacion) {
		// Almacena el tamaño de la frase pasada como argumento
		int lengthFrase = lineaTexto.length();

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime la cota superior del texto
		for (int i = 0; i < lengthFrase; i++) {
			System.out.print(caracter);
		}
		System.out.println();

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime frase de turno y se subraya con el caracter pasado como argumento
		System.out.println(lineaTexto);

		// Se aplica la tabulación indicada
		tabular(tabulacion);

		// Se imprime la cota inferior del texto
		for (int i = 0; i < lengthFrase; i++) {
			System.out.print(caracter);
		}
		System.out.println();
	}

	public static String devuelveLineaLongitudDeterminada(String texto, String caracter) {

		// Variable que almacena la línea a devolver con una longitud según el texto
		// pasado como argumento
		String lineaLongitudDeterminada = "";

		// Variable que almacena la longitud de la linea a devolver
		int longitud = texto.length();

		// Se forma la linea
		for (int i = 0; i < longitud; i++) {
			lineaLongitudDeterminada = lineaLongitudDeterminada.concat(caracter);
		}
		return lineaLongitudDeterminada;
	}

	/**
	 * Metodo que aplica la tabulación correspondiente a los espacios pasados como
	 * argumento
	 * 
	 * @param espacios: int
	 */
	private static void tabular(int espacios) {
		// Se tabula con el valor pasado como argumento
		for (int i = 0; i < espacios; i++) {
			System.out.print(" ");
		}
	}
}
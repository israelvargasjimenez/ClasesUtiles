package com.ivj.utiles;

import java.util.ArrayList;

public class ImprimeGraficosMenus {

	public ImprimeGraficosMenus() {

	}

	/**
	 * Metodo que imprime un texto de varias lineas dentro de un marco realizado con el caracter
	 * pasado como argumento
	 * @param textos
	 * @param caracter
	 * @param cantidadCaracteresLaterales
	 * @param espaciosLaterales
	 */
	public static void imprimeMarcoConTexto(ArrayList<String> textos, char caracter,int cantidadCaracteresLaterales , int espaciosLaterales) {
		// Caracteres máximos de la frase mayor en textos
		int caracteresTotales = 0;

		// variable que almacena el contador de caracteres utilizados en la frase actual
		int contador = 0;

		/// Se averigua los caracteres máximos a utilizar
		for (String frase : textos) {
			if (caracteresTotales < frase.length()) {
				caracteresTotales = frase.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2);
			}
		}

		// Se imprime la linea superior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();

		// Se recorre el ArrayList pasado como argumento
		for (int i = 0; i < textos.size(); i++) {
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
		// Se imprime la linea inferior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();
	}
	/**
	 * Metodo que imprime la linea de texto pasada como argumento,
	 * dentro de un marco realizado con el caracter pasado como argumento.
	 * @param lineaTexto: String
	 * @param caracter: char
	 * @param cantidadCaracteresLaterales: int
	 * @param espaciosLaterales: int
	 */
	
	public static void imprimeMarcoConLineaTexto(String lineaTexto, char caracter,int cantidadCaracteresLaterales , int espaciosLaterales) {
		// Caracteres máximos de la frase mayor en textos
		int caracteresTotales = lineaTexto.length()+ (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2);

		// variable que almacena el contador de caracteres utilizados en la frase actual
		int contador = 0;		

		// Se imprime la linea superior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();
		
		//Se inicializa el contador de caracteres consumidos
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
		
		// Se imprime la linea inferior del marco
		for (int i = 0; i < caracteresTotales; i++) {
			System.out.print(caracter);
		}
		System.out.println();
	}
	
	/**
	 * Metodo que imprime y subraya el texto pasado como argumento,
	 * utilizando el caracter indicado
	 * @param texto: String
	 * @param caracter: char
	 * @param espaciosLaterales: int
	 */
	public static void subRayaFrase (String texto, char caracter, int espaciosLaterales) {
		//Almacena el tamaño de la frase pasada como argumento
		int lengthFrase = texto.length();
		
		//Se imprime frase de turno y se subraya con el caracter pasado como argumento
		System.out.println(texto);
		
		//Se subraya frase
		for ( int i = 0; i <lengthFrase; i++ ) {
			System.out.print(caracter);
		}
		System.out.println();		
	}
}

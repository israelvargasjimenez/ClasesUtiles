package com.ivj.utiles;

import java.util.ArrayList;

public class ImprimeGraficosMenus {

	public ImprimeGraficosMenus() {

	}

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
}

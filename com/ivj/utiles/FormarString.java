package com.ivj.utiles;

public class FormarString {

	public FormarString() {
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * Metodo que limita cada frase del array pasado como argumento por referencia
	 * @param frases
	 * @param delimitador
	 */	
	public static void delimitaFrases (String [] frases, String delimitador) {
		for ( int i = 0; i < frases.length; i++) {
			frases[i] = delimitarString(frases[i], delimitador);
		}
	}
	
	/**
	 * Metodo que devuelve  la frase pasada como argumento,  marcando  el inicio y el final de la misma
	 * con un caracter pasado como argumento.
	 * 
	 * @param frase String
	 * @param delimitador String
	 * @return frase String
	 *
	 */
	public static String  delimitarString ( String frase, String delimitador) {
		return frase= delimitador.concat(frase).concat(delimitador);		
	}
}

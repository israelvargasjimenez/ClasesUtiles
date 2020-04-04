package com.ivj.creaTablaMYSQL;

public class FormarString {

	public FormarString() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que limita cada frase del array pasado como argumento por referencia
	 * 
	 * @param frases
	 * @param delimitador
	 */
	public static void delimitaFrases(String[] frases, String delimitador) {
		for (int i = 0; i < frases.length; i++) {
		}
	}

	/**
	 * Metodo que devuelve la frase pasada como argumento, marcando el inicio y el
	 * final de la misma con un caracter pasado como argumento.
	 * 
	 * @param frase       String
	 * @param delimitador String
	 * @return frase String
	 *
	 */
	public static String delimitarString(String frase, boolean ultima) {
		frase = "".concat(frase.strip());
		if (ultima) {
			return frase = "'".concat(frase).concat("'");
		}
		return frase = "'".concat(frase).concat("'").concat(",");
	}
	
	
	/**
	 * Metodo que sustituye el caracter oldCaracter por el caracter newCaracter
	 * en la frase pasada como argumento
	 * @param frase String
	 * @return frase String
	 */
	public static String sustituyeCaracteres(String frase, char oldCaracter, char newCaracter) {		
		return frase.replace(oldCaracter,newCaracter);		
	}
}

package com.ivj.creaTablaMYSQL;

public class FormarString {

	public FormarString() {
		// TODO Auto-generated constructor stub
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
	public static String delimitarString(String frase, boolean ultima, boolean numero) {
		if (numero && !ultima) {
			return frase = frase.concat(",");
		} else if (numero && ultima) {
			return frase;
		} else if (!numero && ultima) {
			return "'".concat(frase).concat("'");
		}
		return frase = "'".concat(frase).concat("'").concat(",");
	}

	/**
	 * Metodo que sustituye el caracter oldCaracter por el caracter newCaracter en
	 * la frase pasada como argumento
	 * 
	 * @param frase String
	 * @return frase String
	 */
	public static String sustituyeCaracteres(String frase, char oldCaracter, char newCaracter) {
		return frase.replace(oldCaracter, newCaracter);
	}
}
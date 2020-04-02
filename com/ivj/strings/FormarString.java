package com.ivj.strings;

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
	public static String  delimitarString ( String frase,  boolean empiezaPorComa, boolean terminaPorComa) {
		if (empiezaPorComa && !(terminaPorComa)) {
			return frase= ",".concat("'").concat(frase).concat("'")+"\n";	
		} else if (!(empiezaPorComa) && terminaPorComa) {
			return frase= "'".concat(frase).concat("'").concat(",")+"\n";	
		}else if(empiezaPorComa && terminaPorComa){
			return frase= "'".concat(frase).concat("'")+"\n";	
		}
		return frase= ",".concat("'").concat(frase).concat("'")+"\n";		
	}
}

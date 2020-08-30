package com.ivj.numeros;

public class Numeros {

	/*
	 * Comprueba si el n�mero pasado como argumento es primo Vale para numeros
	 * positivos y negativos. El cero no es un par�metro admisible
	 * 
	 * @param numero:int
	 * 
	 * @return true: Si el n�mero es primo
	 */
	public static boolean isPrimo(int numero) throws Exception {
		if (Math.abs(numero) == 0) {
			throw new Exception();
		}		

		for (int i = 2; i < Math.abs(numero); i++) {
			if (Math.abs(numero) % i == 0) {
				return false;
			}
		}
		return true;
	}
}

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

		int numeroAnsoluto = Math.abs(numero);

		if (numeroAnsoluto == 0) {
			throw new Exception();
		}

		// Si el n�mero es 2 o -2, se devuelve false
		if (numeroAnsoluto == 2) {
			return false;
		}

		for (int i = 2; i < numeroAnsoluto; i++) {
			if (numeroAnsoluto % i == 0) {
				return false;
			}
		}
		return true;
	}
}

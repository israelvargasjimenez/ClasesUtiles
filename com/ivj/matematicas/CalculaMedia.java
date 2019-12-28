package com.ivj.matematicas;

import java.util.ArrayList;

public class CalculaMedia {

	//Constructor
	public CalculaMedia(ArrayList<Number> numeros) {		
		mediaAritmetica(numeros);
	}

	/**
	 * Metodo que devuelve la media aritmetica de todos los numeros presentes
	 * en el ArrayList<Numer> numeros
	 * @param numeros
	 * @return
	 */
	public static Number mediaAritmetica(ArrayList<Number> numeros) {
		//Almacena la suma total de los números
		Double resultado = 0.0;

		//Contador de numeros distintos de 0
		int contador = 0;

		//Se itera por toda la colección sumando los numeros que estén almacenados en el ArrayList<Number>
		for (Number num : numeros) {	
			Double numeroDouble = (double) num;	
			if ( numeroDouble != 0) {
				resultado += numeroDouble;
				contador++;
			} else {
				continue;
			}			
		}
		resultado = resultado/contador;
		return resultado;
	}
}

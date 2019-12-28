package com.ivj.matematicas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilizaMediaAritmetica {

	public static void main(String[] args) {
		//Almacena los n�meros introducidos para realizar la media aritmetica
		ArrayList<Number> numeros = new ArrayList<Number>();
		//Almacena la suma total de los n�meros introducidos
		Double sumaTotal = 0.0;
		//Almacena el n�mero actual
		Double numeroActual = 0.0;
		//Variable de control de fin de programa
		boolean salir = false;

		//Se van guardando los numero instroducidos en el ArrayList<Double> numeros
		//hasta que se introduzca un n�mero negativo.
		do {			
			try {
				System.out.println("Introduzca numero real");
				numeroActual = setNumero();
				if ( numeroActual > 0) {
					numeros.add(numeroActual);
				} else {
					//Cuando se introduce un n�mero negativo, se sale del bucle do..while
					salir = true;
				}
			}catch (InputMismatchException e ) {
				System.out.println("****************************************");
				System.out.println("numero incorrecto, introduzcalo de nuevo");
				System.out.println("****************************************");				
			}
		}while (salir == false);

		System.out.println("La media aritmetica es: "+ CalculaMedia.calculaMediaAritmetica(numeros));
	}
	/**Devuelve el n�mero introducido por el usuario
	 * @return Double
	 */
	private static Double setNumero() throws InputMismatchException {
		return new Scanner(System.in).nextDouble();
	}
}

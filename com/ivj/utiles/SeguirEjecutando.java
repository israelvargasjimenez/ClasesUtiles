package com.ivj.utiles;


/**
 * Clase que devuelve true si la opción de seguir ejecutando el programa es selecionada
 * @author SSDIsrael
 * @version 1.0
 * 
 */



public class SeguirEjecutando {

	public SeguirEjecutando() {
		// TODO Auto-generated constructor stub
	}

	public static boolean seguir() {
		boolean seguir = false;
		boolean correcto = true;

		do {
			System.out.println("Desea seguir ejecutando el programa:");
			System.out.println("---------------------------------------------");
			System.out.println("1- Si");
			System.out.println("2- No");

			switch (LeerDatos.leerInteger()) {
			case 1:
				seguir = true;
				correcto = true;
				break;
			case 2:
				seguir = false;
				correcto = true;
				break;
			default:
				System.out.println("--------------------------------------");
				System.out.println("## Elija una opción correcta ##");
				System.out.println("--------------------------------------");				
				correcto = false;				
			}
		} while (correcto == false);
		return seguir;
	}
}

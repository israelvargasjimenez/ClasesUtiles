package com.ivj.utiles;

import com.ivj.leerDatos.LeerDatos;

public class SeguirEjecutando {

	public SeguirEjecutando() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static boolean seguir() {
		boolean seguir = false;
		
		System.out.println("Desea seguir ejecutando el programa:");
		System.out.println("1- si");
		System.out.println("2- no");
		
		
		switch (LeerDatos.leerInteger()) {
		case 1: seguir =  true;
		break;
		case 2: seguir = false;
		break;
		default: System.out.println("No ha elegido una opción correcta, se para la ejecución del programa");
		}
		return seguir;	
	}
}

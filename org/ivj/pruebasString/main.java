package org.ivj.pruebasString;

import java.util.ArrayList;



public class main {
	
	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Almacena el número de columnas que tendra la tabla
		 int COLUMNAS_TABLA = 0;

		// Almacena el path del fichero a leer
		 String pathALeer = "";

		// Almacena el path del fichero escrito
		 ArrayList<String> paths = new ArrayList<String>();
				
		// Se guarda el path del archivo a leer
		System.out.print("Teclee el patl del fichero a leer:");
		pathALeer = LeerDatos.leerString();

		// Se solicita el número de columnas de la tabla
		System.out.print("Indique el número de columnas que tiene la tabla:");
		COLUMNAS_TABLA = LeerDatos.leerInteger();

		System.out.println("Introduzca el path del directorio donde se guardaran las columnas preparadas:");
		String pathAuxiliar=LeerDatos.leerString();
		
		// Se crean todos los paths necesarios para la conversión
		for (int i = 1; i <= COLUMNAS_TABLA; i++) {
			paths.add(pathAuxiliar.concat("\\").concat("Columna").concat(String.valueOf(i)).concat(".txt"));
		}
System.out.println();
	}

}

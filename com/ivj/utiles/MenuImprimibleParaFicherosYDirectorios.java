package com.ivj.utiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuImprimibleParaFicherosYDirectorios {

	public MenuImprimibleParaFicherosYDirectorios() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Variable que si está a true saca los mensajes de error por pantalla
		final boolean DEBBUG = false;
		boolean seguir = true;
		int opcion = -1;

		do {
			opcion = -1;
			System.out.println("Seleccione la opción deseada");
			System.out.println("1- Crear fichero");
			System.out.println("2- Crear directorio");
			System.out.println("3- Escribir en archivo");
			System.out.println("4- Leer archivo");
			System.out.println("5- Borrar archivo de directorio");
			
			opcion = LeerDatos.leerInteger();

			switch (opcion) {
			case 1:
				if (LecturaEscrituraFicheros.crearFichero(DEBBUG) == 1) {
					System.out.println("Fichero creado correctamente");
				} else if (LecturaEscrituraFicheros.crearFichero(DEBBUG) == 0) {
					System.out.println("El fichero ya existe");
				} else {
					System.out.println("Error al crear el fichero");
				}
				break;

			case 2:
				if (LecturaEscrituraFicheros.crearDirectorio(DEBBUG) == 1) {
					System.out.println("Directorio creado correctamente");
				} else if (LecturaEscrituraFicheros.crearDirectorio(DEBBUG) == 0) {
					System.out.println("No se ha creado el directorio");
				} else {
					System.out.println("Se ha producido una excepción del tipo SecurityException");
				}
				break;

			case 3: LecturaEscrituraFicheros.escribirEnFichero(DEBBUG);
				break;
			case 4:
				break;
			case 5: LecturaEscrituraFicheros.borraFicheroODirectorio(DEBBUG);
				break;
			
			default:
				System.out.println("Seleccione una opción válida");
				seguir = true;
			}
			seguir = SeguirEjecutando.seguir();
		} while (seguir);
	}

}

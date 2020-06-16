package com.ivj.ordenar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.util.Arrays;

import com.ivj.utiles.LeerDatos;

/**
 * Clase que ordena en carpetas todos los archivos con el mismo nombre pero
 * diferente extensi�n, dentro de una misma carpeta
 * 
 * @author Israel
 *
 */

public class OrdenaArchivosEnCarpeta_Main {

	public static void main(String[] args) {
		// Pide y almacena el path del directorio a ordenar
		String pathCarpetaDesordenada = "A:\\CURSOS ISRAEL PARA REALIZAR\\Curso java pildoras"; // devuelvePath();

		// Path del fichero antes de ordenarse
		String pathDeFichero;

		// Listado de los path de todos los archivos dentro del directorio a ordenar
		File archivo = new File(pathCarpetaDesordenada);
		File[] todosArchivos = archivo.listFiles();

		for (int i = 0; i < todosArchivos.length; i++) {
			String pathString = todosArchivos[i].getName();
			System.out.println(pathString);
			if(pathString.contains("P�ginas")) {
				File file = new File(pathString);
				boolean eliminado = file.delete();
				System.out.println(eliminado);
			}
		}
	}
	

	/**
	 * Metodo que pide y devuelve el path del directorio a ordenar en carpetas
	 * 
	 * @return
	 */

	public static String devuelvePath() {
		String path = null;
		System.out.println();
		System.out.print("Introduzca el path:");
		path = LeerDatos.leerString();
		System.out.println();
		return path;
	}

}
package com.ivj.ordenar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.Arrays;

import com.ivj.utiles.LeerDatos;

/**
 * Clase que ordena en carpetas todos los archivos con el mismo nombre pero
 * diferente extensión, dentro de una misma carpeta
 * 
 * @author Israel
 *
 */

public class OrdenaArchivosEnCarpeta_Main {

	public static void main(String[] args) {
		File fileAux;
		boolean existe;
		String pathCarpetaDesordenada;

		do {
			existe = false;
			// jjjPide y almacena el path del directorio a ordenar
			pathCarpetaDesordenada = "C:\\Users\\cuarto\\Desktop\\Curso java pildoras"; // devuelvePath();
			fileAux = new File(pathCarpetaDesordenada);
			existe = fileAux.exists();
		} while (!existe);

		// Listado de los path de todos los archivos dentro del directorio a ordenar
		File[] todosArchivos = fileAux.listFiles();
		// System.out.println(todosArchivos.toString());

//		// ArrayList que almacena los archivos .txt
//		ArrayList<File> archivosTXT = new ArrayList<File>();
//
//		// ArrayList que almacena los archivos .m4a
//		ArrayList<File> archivosM4A = new ArrayList<File>();
//
//		// ArrayList que almacena los archivos .m4a
//		ArrayList<File> archivosSRT = new ArrayList<File>();
//
//		// ArrayList que almacena los archivos .m4a
//		ArrayList<File> archivosJPG = new ArrayList<File>();
//
//		// ArrayList que almacena los archivos .m4a
//		ArrayList<File> archivosMP4 = new ArrayList<File>();
//
//		//Se guardan los path según la extensión del archivo
//		for (int i = 0; i < todosArchivos.length; i++) {
//			switch (getExtension(todosArchivos[i])) {
//			case TXT: archivosTXT.add(todosArchivos[i]);
//				break; 
//			case JPG: archivosJPG.add(todosArchivos[i]);
//				break;
//			case SRT: archivosSRT.add(todosArchivos[i]);
//				break;
//			case MP4: archivosMP4.add(todosArchivos[i]);
//				break;
//			case M4A: archivosM4A.add(todosArchivos[i]);
//				break;
//			default:
//				;
//			}
//		}

		// Crear directorio que aloja todos los capitulos
		crearDirectorio("C:\\Users\\Israel\\Desktop\\nuevo");
	

		// Se crean los directorios necesarios según se encuentren en el bucle

	
	}

	/**
	 * Metodo que devuelve 1 si ha creado el directorio correctamente devuelve 0 si
	 * no se ha creado el directorio devuelve -1 si se ha producido una excepción de
	 * seguiridad.
	 * 
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por
	 *               consola.
	 * @return Devuelve 1 si se ha creado correctamente.Devuelve 0 si no se ha
	 *         creado correctamente. devuelve -1 si se ha producido una excepción
	 *         del tipo SecurityException.
	 */
	private static int crearDirectorio(String path) {
		int creado;

		File ficheroAux = new File(path);
		try {
			if (ficheroAux.mkdir() == true) {
				creado = 1;
			} else {
				return 0;
			}
		} catch (SecurityException ex) {
			return -1;
		}
		return creado;
	}

	/**
	 * Metodo que devuelve true si el path pasado como argumento se encuentra ya
	 * guardado en el ArrayList pasado como argumento
	 * 
	 * @param path
	 * @param listaPath
	 * @return
	 */
	private static boolean yaCreado(String path, ArrayList<String> listaPath) {
		for (String pathAux : listaPath) {
			if (pathAux.equals(path)) {
				return true;
			}
		}
		return false;
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

	/**
	 * Metodo que devuelve el path pasado como argumento sin extensión,
	 *
	 */
	private static String pathSinExtension(File file) {

		// Variable que almacena el tamaño del string pasado como argumento
		int contador = file.getPath().length();

		// Almacena el caracter de turno
		Character caracter = file.getPath().charAt(contador - 1);

		// Se busca el valor de contador que hará de tamaño maximo del string
		// a devolver
		while (contador > 0 && caracter != '.') {
			contador--;
			caracter = file.getPath().charAt(contador);
		}
		System.out.println(file.toString().substring(0, contador));
		return file.toString().substring(0, contador);
	}

	/**
	 * Metodo que devuelve la extensión del fichero correspondiente al path pasado
	 * como argumento
	 *
	 */
	public static EXTENSIONES getExtension(File file) {
		// Variable que almacena el tamaño del string pasado como argumento
		int contador = file.getName().length();

		// Almacena el caracter de turno
		Character caracter = file.getName().charAt(contador - 1);

		// Se busca el valor de contador que hará de tamaño maximo del string
		// a devolver
		while (contador > 0 && caracter != '.') {
			contador--;
			caracter = file.getName().charAt(contador);
		}

		if (file.getName().substring(contador).equals(".srt")) {
			return EXTENSIONES.SRT;
		} else if (file.getName().substring(contador).equals(".jpg")) {
			return EXTENSIONES.JPG;
		} else if (file.getName().substring(contador).equals(".txt")) {
			return EXTENSIONES.TXT;
		} else if (file.getName().substring(contador).equals(".mp4")) {
			return EXTENSIONES.MP4;
		}
		return EXTENSIONES.M4A;
	}

}
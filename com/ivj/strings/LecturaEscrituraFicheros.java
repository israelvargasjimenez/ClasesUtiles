package com.ivj.strings;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import com.ivj.utiles.LeerDatos;;


public class LecturaEscrituraFicheros {
	//Almacena el path pasado como argumento al constructor para las operaciones finales de salida
	String path;
	
	//Almacena el fichero con la información a tratar
	File fichero;
	

	public LecturaEscrituraFicheros(String path, File fichero) {
		this.path = path;
		this.fichero = fichero;
	}
	
	public LecturaEscrituraFicheros(String path) {
		this.path = path;
		this.fichero = fichero;
	}


	/**
	 * Metodo que crea un fichero utilizando el path tecleado por el usuario
	 */
	public  void crearFichero()  {		
		File ficheroAux = new File(path);
		
		try {
			ficheroAux.createNewFile();				
		} catch (IOException ex) {
			System.out.println("Se ha producido un error");
		}catch (SecurityException ex ) {
			System.out.println("Se ha producido una excepción de seguridad");
		}		
	}

	
	
	/**
	 * Metodo que devuelve 1 si ha creado el directorio correctamente devuelve 0 si
	 * no se ha creado el directorio devuelve -1 si se ha producido una excepción de
	 * seguiridad. 
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return Devuelve 1 si se ha creado correctamente.Devuelve 0 si no se ha creado correctamente. 
	 * devuelve -1 si se ha producido una excepción del tipo SecurityException.
	 */
	public  void crearDirectorio() {					
		File ficheroAux = new File(path);
		try {
			ficheroAux.mkdir();
				
		} catch (SecurityException ex) {
			System.out.println("Se ha producido un error de seguridad");
		}		
	}

	
	/**
	 * Metodo que escribe en el fichero final, las lienas 
	 * absoluta tecleada en consola Devuelve 1 si se ha podido escribir la
	 * información en el fichero Devuelve 0 si no se ha encontrado el fichero
	 * Devuelve -1 si se ha producido una excepcion del tipo IOException
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return 1 si se ha podido escribir la información en el fichero	. 
	 *  -1 si se ha producido una excepcion del tipo IOException
	 */
	public  void  escribirEnFichero() {			
		try {						
				FileWriter writer = new FileWriter(fichero, true);
				writer.write(path);
				writer.flush();
				writer.close();
		}catch (IOException e) {			
			System.out.println("Error, el fichero debe ser un directorio");
			System.out.println("o no se ha podido crear el fichero");
			System.out.println("o no se ha podido abrir el fichero");
		}	
	}
	

	/**
	 * Metodo que leer el fichero pasado como argumento
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @param string File
	 */
	public static void leerFichero(String string, boolean debbug) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(string));
			String lineaLeida;
			while ((lineaLeida = br.readLine()) != null) {
				System.out.println(lineaLeida);
			}
			br.close();
		} catch (FileNotFoundException e) {
			if (debbug) {
				mensajeNoEncontrado ();
			}
		} catch (IOException e) {
			if (debbug) {
			System.out.println("---------------------------------------");
			System.out.println("Error tratando de leer el fichero");
			System.out.println("---------------------------------------");
			}
		}
	}

	/**
	 * Metodo que borra el fichero o directorio pasado como argumento Utilizando la
	 * ubicación del mismo pasada como argumento
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @param fichero File
	 */

	public static void borraFichero( boolean debbug) {
		String path = devuelvePath();		
		File fileAux = new File(path);
		
		if (fileAux.exists() ) {
			fileAux.delete();
		} else {
			if ( debbug) {
				mensajeNoEncontrado ();
			}
		}
	}

	/**
	 * Metodo que borra el fichero o directorio pasado como argumento Utilizando el
	 * path tecleado por el usuario
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 */
	public static void borraFicheroODirectorio(boolean debbug) {
		String path = devuelvePath();		

		File ficheroAux = new File(path);

		if (ficheroAux.exists() == true) {
			ficheroAux.delete();
		} else {
			if ( debbug) {
				mensajeNoEncontrado ();
			}
		}
	}
	
	public static String devuelvePath () {
		String path= null;
		System.out.println();
		System.out.print("Introduzca el path:");
		path = LeerDatos.leerString();
		System.out.println();
		return path;
	}
	
	private static void mensajeNoEncontrado () {
		System.out.println("------------------------------------------------");
		System.out.println("El fichero o directorio no encontrado");
		System.out.println("------------------------------------------------");
	}
}
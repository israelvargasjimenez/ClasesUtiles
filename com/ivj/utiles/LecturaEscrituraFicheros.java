package com.ivj.utiles;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import com.ivj.utiles.LeerDatos;

public class LecturaEscrituraFicheros {

	public LecturaEscrituraFicheros() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que devuelve true si ha creado el fichero utilizando el String pasado
	 * como argumento o devuelve false si ya existía el fichero	 * 
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return creado
	 */
	public static int crearFichero(boolean debbug) {
		String path;
		int creado;

		System.out.print("Introduzca path de creación del fichero o directorio:");
		path = LeerDatos.leerString();

		File ficheroAux = new File(path);
		try {
			if (ficheroAux.createNewFile() == true) {
				creado = 1;
			} else {
				return 0;
			}
		} catch (IOException ex) {
			return -1;
		}
		return creado;
	}

	/**
	 * Metodo que devuelve 1 si ha creado el directorio correctamente devuelve 0 si
	 * no se ha creado el directorio devuelve -1 si se ha producido una excepción de
	 * seguiridad. 
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return creado
	 */
	public static int crearDirectorio(boolean debbug) {
		String path;
		int creado;

		System.out.print("Introduzca path de creación del fichero o directorio:");
		path = LeerDatos.leerString();

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
	 * Metodo que escribe un texto en el fichero que se encuentra en la ruta
	 * absoluta tecleada en consola Devuelve 1 si se ha podido escribir la
	 * información en el fichero Devuelve 0 si no se ha encontrado el fichero
	 * Devuelve -1 si se ha producido una excepcion del tipo IOException
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return 1 si se ha podido escribir la información en el fichero	. 
	 *  -1 si se ha producido una excepcion del tipo IOException
	 */
	public static int escribirEnFichero(boolean debbug) {		
		int creado = 0;
		String path;
		System.out.print("Introduzca path del fichero:");
		path = LeerDatos.leerString();

		File fichero = new File(path);

		try {
			System.out.print("Teclee la información a escribir:");
			String linea = new String(LeerDatos.leerString() + System.lineSeparator());
			if (fichero.exists() == true) {
				FileWriter writer = new FileWriter(fichero, true);
				writer.write(linea);
				writer.flush();
				writer.close();
				creado = 1;
			} else {			
				if (debbug) {
				System.out.println ("----------------------El fichero no existe-----------------------");
				}
				throw new FileNotFoundException();
			}
		}catch (IOException e) {			
			return -1;
		}
		return creado;
	}

	/** Metodo que escribe un texto en el fichero que se 
	 * pasa como argumento
     * @param fichero File
     * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
     * @return 1 si se escribe correctamente en el fichero
     * @return -1 si no se puede escribir en el fichero
     */    
    public static int  escribirEnFichero (File fichero, boolean debbug)   {  	  
    	int creado = 0;
        try { 
          System.out.print("Teclee la información a escribir:");
           String linea = new String (LeerDatos.leerString()+ System.lineSeparator());      
           if ( fichero.exists()== true) {
        	  FileWriter writer = new FileWriter (fichero, true);
               writer.write (linea);
               writer.flush();
               writer.close(); 
               creado = 1;
           }
           else {  
        	   if (debbug) {
        	   throw new FileNotFoundException ("----------------------El fichero no existe-----------------------");
        	   }
           }
        }  
      catch ( IOException e) {            
            return -1;
        }
        return creado;
    }

	/**
	 * Metodo que leer el fichero pasado como argumento
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @param fichero File
	 */
	public static void leerFichero(File fichero, boolean debbug) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String lineaLeida;
			while ((lineaLeida = br.readLine()) != null) {
				System.out.println(lineaLeida);
			}
			br.close();
		} catch (FileNotFoundException e) {
			if (debbug) {
			System.out.println("No se ha encontrado el fichero para leer el mensaje");
			}
		} catch (IOException e) {
			if (debbug) {
			System.out.println("Error tratando de leer el fichero");
			}
		}
	}

	/**
	 * Metodo que borra el fichero o directorio pasado como argumento Utilizando la
	 * ubicación del mismo pasada como argumento
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @param fichero File
	 */

	public static void borraFichero(File fichero, boolean debbug) {
		if (fichero.exists() == true) {
			fichero.delete();
		} else {
			if ( debbug) {
			System.out.println("El fichero o directorio a borrar no existe");
			}
		}
	}

	/**
	 * Metodo que borra el fichero o directorio pasado como argumento Utilizando el
	 * path tecleado por el usuario
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 */
	public static void borraFicheroODirectorio(boolean debbug) {
		String path;

		System.out.print("Introduzca path de creación del fichero o directorio:");
		path = LeerDatos.leerString();

		File ficheroAux = new File(path);

		if (ficheroAux.exists() == true) {
			ficheroAux.delete();
		} else {
			if ( debbug) {
			System.out.println("El fichero o directorio a borrar no existe");
			}
		}
	}
}

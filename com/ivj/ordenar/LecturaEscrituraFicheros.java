package com.ivj.ordenar;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import com.ivj.utiles.LeerDatos;;


public class LecturaEscrituraFicheros {
	boolean debbug;

	public LecturaEscrituraFicheros(boolean debbug) {
		this.debbug = debbug;
	}

	/**
	 * Metodo que intenta crear un fichero.
	 * Devuelve 1 si se ha creado correctamente.
	 * Devuelve 0 si no se ha podido crear.
	 * Devuelve -1 si se ha producido una excepción del tipo IOException.
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por consola.
	 * @return Devuelve 1 si se ha creado correctamente.Devuelve 0 si no se ha creado correctamente. 
	 * devuelve -1 si se ha producido una excepción del tipo IOException.
	 */
	public static int crearFichero(boolean debbug) {
		String path = devuelvePath();
		int creado;	

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
	 * @return Devuelve 1 si se ha creado correctamente.Devuelve 0 si no se ha creado correctamente. 
	 * devuelve -1 si se ha producido una excepción del tipo SecurityException.
	 */
	public static int crearDirectorio(boolean debbug) {
		String path = devuelvePath();
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
		String path = devuelvePath();

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
					mensajeNoEncontrado();
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
        		   mensajeNoEncontrado () ;
        	   throw new FileNotFoundException (null);
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
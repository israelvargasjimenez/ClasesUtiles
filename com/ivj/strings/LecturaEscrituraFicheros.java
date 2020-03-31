package com.ivj.strings;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import com.ivj.utiles.LeerDatos;;

public class LecturaEscrituraFicheros {
	// Almacena el path pasado como argumento al constructor para las operaciones
	// finales de salida
	String pathArchivoOriginal;
	
	//Almacena el path del archivo con las frases tratadas
	String pathParaSalida;

	// Almacena el fichero con las frases tratadas listas
	File fichero;
	

	/**
	 * @return the path
	 */
	public String getPath() {
		return pathArchivoOriginal;
	}

	/**
	 * @return the fichero
	 */
	public File getFichero() {
		return fichero;
	}

	public LecturaEscrituraFicheros(String pathFicheroOriginal, String pathParaSalida ) {
		this.pathArchivoOriginal = pathFicheroOriginal ;	
		this.pathParaSalida = pathParaSalida;	
		
		crearFichero(pathParaSalida);
	}

	/**
	 * Metodo que crea un fichero utilizando el path tecleado por el usuario
	 */
	private void crearFichero(String pathParaSalida) {
		
		fichero = new File(pathParaSalida);
		try {
			fichero.createNewFile();
			
		} catch (IOException ex) {
			System.out.println("Se ha producido un error");
		} catch (SecurityException ex) {
			System.out.println("Se ha producido una excepción de seguridad");
		}
	}



	/**
	 * Metodo que escribe en el fichero final, las lienas absoluta tecleada en
	 * consola Devuelve 1 si se ha podido escribir la información en el fichero
	 * Devuelve 0 si no se ha encontrado el fichero Devuelve -1 si se ha producido
	 * una excepcion del tipo IOException
	 * 
	 * @param debbug Boolean. Si es true se imprimirán los mensajes de error por
	 *               consola.
	 * @return 1 si se ha podido escribir la información en el fichero . -1 si se ha
	 *         producido una excepcion del tipo IOException
	 */
	public void escribirEnFichero(String lineaFormada) {
		try {
			FileWriter writer = new FileWriter(fichero, true);
			writer.write(lineaFormada);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error, el fichero debe ser un directorio");
			System.out.println("o no se ha podido crear el fichero");
			System.out.println("o no se ha podido abrir el fichero");
		}
	}

	/**
	 * Metodo que se encarga de leer cada linea del fichero y 
	 * llama a los metodos 
	 *  
	 * @param pathFicheroATratar String
	 */
	public void tratarFichero() {
		Charset set = Charset.defaultCharset();
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathArchivoOriginal));
			String lineaLeida;
			while ((lineaLeida = br.readLine()) != null) {
				//String lineaFormateada = FormarString.delimitarString(lineaLeida, ",",false, true);		
				//String lineaFormateada = FormarString.delimitarString(lineaLeida, ",",true, true);	
				//String lineaFormateada = FormarString.delimitarString(lineaLeida, ",",true, false);	
				String lineaFormateada = FormarString.delimitarString(lineaLeida, ",",false, false);	
						
				escribirEnFichero(lineaFormateada);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error al tratar de leer el fichero");
		}
	}
	
			
	
	private static void mensajeNoEncontrado() {
		System.out.println("------------------------------------------------");
		System.out.println("El fichero o directorio no encontrado");
		System.out.println("------------------------------------------------");
	}
}
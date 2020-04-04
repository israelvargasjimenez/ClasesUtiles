package com.ivj.creaTablaMYSQL;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import com.ivj.utiles.LeerDatos;;

public class LecturaEscrituraFicheros {
	// Almacena el path pasado como argumento al constructor para las operaciones
	// finales de salida
	String pathArchivoOriginal;

	// Almacena el path del archivo con las frases tratadas
	String pathParaSalida;

	// Almacena el fichero con las frases tratadas listas
	File fichero;

	// Almacena el Charset por defecto
	Charset charSet = Charset.defaultCharset();

	public LecturaEscrituraFicheros(String pathFicheroOriginal, String pathParaSalida) {
		this.pathArchivoOriginal = pathFicheroOriginal;
		this.pathParaSalida = pathParaSalida;

		crearFichero(pathParaSalida);
	}

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
			System.out.println("Se ha producido una excepci�n de seguridad");
		}
	}

	/**
	 * Metodo que escribe en el fichero final, las lienas absoluta tecleada en
	 * consola Devuelve 1 si se ha podido escribir la informaci�n en el fichero
	 * Devuelve 0 si no se ha encontrado el fichero Devuelve -1 si se ha producido
	 * una excepcion del tipo IOException
	 * 
	 * @param debbug Boolean. Si es true se imprimir�n los mensajes de error por
	 *               consola.
	 * @return 1 si se ha podido escribir la informaci�n en el fichero . -1 si se ha
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
	 * Metodo que se encarga de leer cada linea del fichero y llama a los metodos
	 *  OJO el archivo con los datos a leer, debe contener una linea en blanco.
	 * @param pathFicheroATratar String
	 */
	public void tratarFichero(String nombreTabla) {
		String lineaFinal = "";

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(pathArchivoOriginal), "UTF-8"));
			String lineaLeida;

			int contador = 0;
			while ((lineaLeida = br.readLine()) != null) {
				if (contador == 0) {
					contador++;
					continue;
				} else {
					//Separar la linea en frases utilizando los marcadores
					String [] fraseSeparadaEnFrasesPeques = lineaLeida.split(":");					
					//Se quitan los espacios entre frases por delante y por detras
					for ( int i = 0; i < fraseSeparadaEnFrasesPeques.length-1; i++) {
						//Se quitan el signos de interrogaci�n que aparec�a en la primera linea de forma no deseada
						fraseSeparadaEnFrasesPeques[i] = "".concat(FormarString.sustituyeCaracteres(fraseSeparadaEnFrasesPeques[i], '?',' '));
						//Se sustituyen las comas intercaladas en las frases peque�as por puntos
						fraseSeparadaEnFrasesPeques[i] = "".concat(FormarString.sustituyeCaracteres(fraseSeparadaEnFrasesPeques[i], ',','.'));
						//Se acotan las frase peque�as por comas seg�n corresponda en cada caso
						fraseSeparadaEnFrasesPeques[i] =  "".concat(FormarString.delimitarString(fraseSeparadaEnFrasesPeques[i],false));
					}	
					//Se escribe la �ltima mini frase
					fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length-1] =  "".concat(FormarString.delimitarString(fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length-1], true));
					
					//Guarda la frase completa
					String fraseFinal = "";
					for (int i = 0; i< fraseSeparadaEnFrasesPeques.length; i++) {
						fraseFinal = fraseFinal.concat(fraseSeparadaEnFrasesPeques[i]);
					}					
					
					fraseFinal = "INSERT INTO ".concat(nombreTabla).concat(" VALUES (").concat(fraseFinal).concat(");\n");
					// escribir la linea completa con una concat de todas las l�neas peque�as
					escribirEnFichero(fraseFinal);
				}
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
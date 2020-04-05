package com.ivj.creaTablaSQLSERVER;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.ivj.utiles.LeerDatos;

import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
//import com.ivj.utiles.LeerDatos;

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
	 * Metodo que se encarga de leer cada linea del fichero y llama a los metodos
	 * OJO es necesario que haya una fila en blanco antes de la primera fila de
	 * datos en el archivo a leer
	 * 
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
					// Separar la linea en frases utilizando los marcadores
					String[] fraseSeparadaEnFrasesPeques = lineaLeida.split(":");
					
					// Se quitan los espacios entre frases por delante y por detras y se detecta si se trata
					// de un numero o no
					for (int i = 0; i < fraseSeparadaEnFrasesPeques.length - 1; i++) {
						//Se quitan los espacios anteriores y posteriores a la frase
						fraseSeparadaEnFrasesPeques[i] = "".concat(fraseSeparadaEnFrasesPeques[i].strip());
						//Se sustituyen las comas por puntos
						fraseSeparadaEnFrasesPeques[i] = "".concat(FormarString.sustituyeCaracteres(fraseSeparadaEnFrasesPeques[i], ',', '.'));
						//Se da formato a la frase según sea String o números
						if (LeerDatos.isSoloNumbers(fraseSeparadaEnFrasesPeques[i])) {
							fraseSeparadaEnFrasesPeques[i] = ""
									.concat(FormarString.delimitarString(fraseSeparadaEnFrasesPeques[i], false, true));
						} else {
							fraseSeparadaEnFrasesPeques[i] = ""
									.concat(FormarString.delimitarString(fraseSeparadaEnFrasesPeques[i], false, false));
						}
					}
					// Se escribe la última mini frase
					if (LeerDatos.isSoloNumbers(fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length-1])) {
						fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length - 1] = "".concat(FormarString
								.delimitarString(fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length - 1],
										true, true));
					} else {
						fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length - 1] = "".concat(FormarString
								.delimitarString(fraseSeparadaEnFrasesPeques[fraseSeparadaEnFrasesPeques.length - 1],
										true, false));
					}

					// Guarda la frase completa
					String fraseFinal = "";
					for (int i = 0; i < fraseSeparadaEnFrasesPeques.length; i++) {
						fraseFinal = fraseFinal.concat(fraseSeparadaEnFrasesPeques[i]);
					}

					fraseFinal = "INSERT INTO ".concat(nombreTabla).concat(" VALUES (").concat(fraseFinal)
							.concat(")\n");
					// escribir la linea completa con una concat de todas las líneas pequeñas
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
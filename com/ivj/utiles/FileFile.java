package com.ivj.utiles;

import java.io.File;
import java.net.URI;



/**
 * Clase que decora la clase File, utilizando el patron Decoration
 * @author Israel Vargas
 *
 */

public class FileFile extends File {

	public FileFile(File parent, String child) {
		super(parent, child);		
	}
	
	public FileFile(String patname) {
		super(patname);		
	}
	
	public FileFile(String parent, String child) {
		super(parent, child);		
	}
	
	public FileFile(URI uri) {
		super(uri);		
	}
		
	

	/**
	 * Metodo que devuelve el path pasado como argumento sin extensión, 
	 *
	 */
	public String getPathWithOutExtention(String path) {		
			//Variable que almacena el tamaño del string pasado como argumento		
			int contador = path.length();
			
			//Almacena el caracter de turno
			Character caracter = path.charAt(contador-1);
			
			//Se busca el valor de contador que hará de tamaño maximo del string
			// a devolver
			while(contador > 0 && caracter!= '.' ) {
				contador--;
				caracter =  path.charAt(contador);
			}			
			return path.substring(0,contador);
	}
	
	
	
	/**
	 * Metodo que devuelve la extensión del fichero correspondiente al path pasado como argumento
	 *
	 */
	public static String getExtension(String path) {
		// Variable que almacena el tamaño del string pasado como argumento
		int contador = path.length();

		// Almacena el caracter de turno
		Character caracter = path.charAt(contador - 1);

		// Se busca el valor de contador que hará de tamaño maximo del string
		// a devolver
		while (contador > 0 && caracter != '.') {
			contador--;
			caracter = path.charAt(contador);
		}
		return path.substring(contador);
	}
}

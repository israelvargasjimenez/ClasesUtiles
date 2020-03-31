package com.ivj.strings;

import java.util.ArrayList;
import com.ivj.utiles.LeerDatos;

public class main {
	// Almacena todas las líneas con las instrucciones insert
	static ArrayList<String> todasLineasCompletas = new ArrayList<String>();

	// Variable que almacena la linea de turno ya formada completamente
	static ArrayList<String> lineaCompleta = new ArrayList<String>();
	
	

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		System.out.println("Teclee el path del fichero a tratar:");
		String pathFicheroATratar = LeerDatos.leerString();
		System.out.println("Teclee el path del fichero tratado:");
		String pathFicheroTratado = LeerDatos.leerString();
		
		LecturaEscrituraFicheros tra = new LecturaEscrituraFicheros(pathFicheroATratar,pathFicheroTratado );		
		tra.tratarFichero();
	}
	
	
	/**
	 * Metodo que escribe una linea tratada completa en ArrayList "todasLineasCompletas"
	 * @param linea
	 */
	public static void guardarLineaCompleta(String linea, String nombre) {
		//Almacena el nombre de la tabla
		String nombreTabla=nombre;		
		String lineaFinal = "INSERT INTO " + nombreTabla+ " values (" + linea+")";
		todasLineasCompletas.add(lineaFinal);
	}

}

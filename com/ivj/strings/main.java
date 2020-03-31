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
		
		String completo1 = "C:\\Users\\SSDIsrael\\Desktop\\ficheros\\columna.txt";
		String completo2 = "C:\\Users\\SSDIsrael\\Desktop\\ficheros\\clientes\\";
		
		System.out.println("Teclee el path del fichero tratado:");
		String pathFicheroTratado = LeerDatos.leerString();
		completo2 = completo2.concat(pathFicheroTratado);
		
		LecturaEscrituraFicheros tra = new LecturaEscrituraFicheros(completo1,completo2 );		
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

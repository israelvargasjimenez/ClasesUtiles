package com.ivj.strings;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.ivj.utiles.LeerDatos;

public class main {
	/// Almacena todas las líneas con las instrucciones insert
	static ArrayList<String> todasLineasCompletas = new ArrayList<String>();

	// Variable que almacena la linea de turno ya formada completamente
	static ArrayList<String> lineaCompleta = new ArrayList<String>();
	
	

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		boolean inicial = false;
		boolean ultima = false;
		
		System.out.print("Teclee el nombre que tendrá la tabla:");
		String nombreTabla = LeerDatos.leerStringUTF8();
		
		//System.out.print("Teclee el path del archivo a leer:");
		String completo1 = "C:\\Users\\SSDIsrael\\Desktop\\ficheros\\ficheroAux.txt"; //     LeerDatos.leerStringUTF8();
		
		//System.out.print("Teclee el path del archivo de salida:");
		String completo2 = "C:\\Users\\SSDIsrael\\Desktop\\ficheros\\TABLAS\\"  +nombreTabla+".txt";   //LeerDatos.leerStringUTF8();			
		
		//Se pregunta el tipo de columna
		System.out.println("Elija el tipo de columna?");
		System.out.println("\t1- Primera");
		System.out.println("\t2- Intermedia");
		System.out.println("\t3- Ultima");	
		int aux = LeerDatos.leerInteger();		
		if (aux== 1) {
			ultima = true;			
		} else if (aux == 3) {
			inicial = true;
		}else {
			inicial = false;
			ultima = false;
		}
					
		
		LecturaEscrituraFicheros tra = new LecturaEscrituraFicheros(completo1,completo2 );		
		tra.tratarFichero(inicial, ultima);
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

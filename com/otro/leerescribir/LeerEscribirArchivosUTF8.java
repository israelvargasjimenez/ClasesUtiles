package com.otro.leerescribir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author SoftMolina
 */
public class LeerEscribirArchivosUTF8 {

	private String file = "D:\\fichero.txt";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		LeerEscribirArchivosUTF8 escribirArchivosUTF8 = new LeerEscribirArchivosUTF8();
		escribirArchivosUTF8.escribirArchivo();
		escribirArchivosUTF8.leerArchivo();
		
	}

	public static void escribirArchivo() throws IOException {

		Writer escribe = null;

		try {
			escribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\cuarto\\Desktop\\ficheros\\clientes\\FABRICA"), "utf-8"));
			escribe.write(LeerDatos.leerString());				

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			escribe.close();
		}
	}

	public static void leerArchivo() throws IOException {

		String cadena = "";
		//new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\cuarto\\Desktop\\ficheros\\clientes\\FABRICA", true), "UTF8"));

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\cuarto\\Desktop\\ficheros\\clientes\\FABRICA"), "utf-8"));
		try {
			while ((cadena = in.readLine()) != null) {
				System.out.println(cadena);

			}
		} catch (Exception e) {

		} finally {
			in.close();
		}

	}

}

package com.ivj.utilidades;

import com.ivj.utiles.CalculaMedia;


import java.util.ArrayList;

import com.ivj.fechas.*; 
import com.ivj.utiles.CalculaMedia;

public class ClaseEjecutora {
	public static void main(String[] args) {
     //Crear aqui instancia de la clase a utilizar
		
		ArrayList<Number> numm = new ArrayList<Number>();
		numm.add(100);
		numm.add(75.3);
		numm.add(40.5);		
		
		new ClaseFecha().imprimirFechaDiaria();
		System.out.println("La media es: "+ String.format("%.2f",CalculaMedia.mediaAritmetica(numm)));		
	}
}

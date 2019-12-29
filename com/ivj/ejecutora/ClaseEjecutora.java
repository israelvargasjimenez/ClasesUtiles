package com.ivj.ejecutora;

import com.ivj.matematicas.CalculaMedia;

import java.util.ArrayList;

import com.ivj.fechas.*; 

public class ClaseEjecutora {
	public static void main(String[] args) {
     //Crear aqui instancia de la clase a utilizar
		
		ArrayList<Number> numm = new ArrayList<Number>();
		numm.add(100);
		numm.add(75.3);
		numm.add(40.5);		
		
		System.out.println("La media es: "+ String.format("%.2f",CalculaMedia.mediaAritmetica(numm)));		
	}
}

package com.ivj.utiles;

//Se importa el paquete java.time
import java.time.*;

public class Fecha {
	LocalDate dia;

	/**
	 * Constructor que utliza la fecha actual para crear la instancia de LocalDate
	 */
	public Fecha() {
		dia = LocalDate.now();
	}

	/**
	 * Constructor que utiliza los datos pasados como argumento para crear la
	 * instancia de LocalDate *
	 * 
	 * @param agno      int
	 * @param mes       int
	 * @param diaDelMes int
	 */
	public Fecha(int agno, int mes, int diaDelMes) {
		try {		
			dia = LocalDate.of(agno, mes, diaDelMes);
		} catch (DateTimeException ex) {
			System.out.println("La fecha no es correcta");
			}
		}
	

	/**
	 * Metodo que devuelve el dia
	 */
	public String toString() {
		return dia.toString();
	}

	/**
	 * Metodo que devuelve el dia sumandole 1
	 * @return dia mas 1día
	 */
	public LocalDate unDiaMas() {
		return dia.plusDays(1);
	}
	
	/**
	 * Metodo que comprueba si el dia existe
	 * @param agno int
	 * @param mes int 
	 * @param diaDelMes int
	 * @return correcto
	 */
	public boolean isCorrecta() {	
		boolean correcto = true;
		try {			
			LocalDate fecha = LocalDate.of(dia.getYear(), dia.getMonthValue(), dia.getDayOfMonth());				
		} catch (DateTimeException ex) {			
			return false;
		}catch (NullPointerException ex) {
			return false;
		}
		return correcto;
	}
}

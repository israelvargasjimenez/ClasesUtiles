package com.ivj.utiles;

import java.io.IOException;
import java.time.*;
import java.util.HashMap;


/**
 * Clase que representa un día válido
 * 
 * @author SSDIsrael
 * @see Fecha
 * @version 1.0
 */



/*----------------------CONSTRUCTORES------------------------------------*/


/**
 * Constructor que genera una instancia de la clase Fecha con los datos actuales de dia y hora.
 * @author SSDIsrael
 *
 */
public class Fecha {
	enum Meses {ENERO,FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE,DICIEMBRE };
	HashMap<Integer,Meses> mesesEnLetra = new HashMap<Integer, Meses>();	
	int agno;
	Integer mesEnNumero;		
	int dia;
	int hora;
	int minutos;
	int segundos;
	

	/**
	 * Constructor que crea una instancia con los datos de fecha actuales La fecha
	 * consta de año, mes, dia, horas , minutos y segundos
	 */
	public Fecha() {
		//Se inicializa el HashMap mesesEnLetra		
		incializaHashMap ();
		
		agno = LocalDateTime.now().getYear();			
		mesEnNumero = LocalDateTime.now().getMonthValue();		
		dia = LocalDateTime.now().getDayOfMonth();
		hora = LocalDateTime.now().getHour();
		minutos = LocalDateTime.now().getMinute();
		segundos = LocalDateTime.now().getSecond();
	}

	/**
	 * Constructor parametrizado que crea una instalacia con los datos pasados como
	 * argumento.
	 * La fecha consta de los siguientes parámetros
	 * 
	 * @param agno    int
	 * @param mes     int
	 * @param dia     int
	 * @param hora    int
	 * @param minutos int
	 * @param segunos int
	 * @throws DateTimeException si la fecha introducida  no existe.
	 */
	public Fecha(int agno, int mes, int dia, int hora, int minutos, int segundos) throws DateTimeException  {	
		//Se inicializa el HashMap mesesEnLetra		
			incializaHashMap ();
			
		this.agno = agno;		
		this.mesEnNumero = mes;
		this.dia = dia;
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		if (!(isFechaCorrecta(this))) {
			throw new DateTimeException(null);
		}
}
		
	/*----------------------METODO INTERNO PARA LA INICIALIZACIÓN------------------------------------*/

	/**
	 * Metodo que inicializa el HashMap mesesEnLetra al 
	 * momento de realizar la instancia de la clase
	 */
	private void incializaHashMap () {
		int aux = 1;		
		for (Meses mesAux: Meses.values() ) {
			Integer contador = new Integer(aux);
			mesesEnLetra.put(contador, mesAux);
			aux++;
		}		
	}
	
	/*----------------------METODOS PUBLICOS------------------------------------*/
	
	/**
	 * @return the agno
	 */
	public int getAgno() {
		return agno;
	}

	/**
	 * @param agno the agno to set
	 */
	public void setAgno(int agno) {
		this.agno = agno;
	}

	/**
	 * @return the mesEnNumero
	 */
	public Integer getMesEnNumero() {
		return mesEnNumero;
	}

	/**
	 * @param mesEnNumero the mesEnNumero to set
	 */
	public void setMesEnNumero(int mesEnNumero) {
		this.mesEnNumero = mesEnNumero;
	}

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @return the hora
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @param minutos the minutos to set
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * @return the segundos
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 * @param segundos the segundos to set
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	/**
	 * Metodo que aumenta la fecha actual en un día.
	 * Si se ha llegado al final del mes, aumenta en 1 el mes, y pone el dia a 1.
	 * Si se ha llegado al final del año, aumenta en 1 el año, y pone a 1 el mes y el día.
	 *  
	 */
	public void aumentaUnDia()  {
		
		Fecha aux = new Fecha (this.agno, this.mesEnNumero, this.dia, this.hora, this.minutos, this.segundos);
		aux.dia += 1;
		
		if (isFechaCorrecta(aux)) {
			this.dia += 1;
		}else {
			aux.dia = 1;
			aux.mesEnNumero += 1;
			if ( isFechaCorrecta(aux)) {
				this.dia = 1;
				this.mesEnNumero += 1;
			}else {
				this.agno += 1;
				this.mesEnNumero = 1;
				this.dia = 1;
			}
		}		
	}
	
	/**
	 * Metodo que trata el string que representa al mes actual
	 * Para que la primera letra sea mayuscula y las demas minúsculas
	 * @param mes Meses
	 * @return mesTratado con la primera letra en mayuscula String
	 */
	private String trataMes(Meses mes) {	
		String tratado= null;
		char [] letras = mes.name().toCharArray();
		for (int i = 1; i <letras.length;i++) {
			Character letraAux = letras [i];
			letras[i] = letraAux.toLowerCase(letraAux);
		}	
		tratado = 	String.valueOf(letras);		
		return tratado;
	}
		

	/**
	 * Metodo que imprime los valores de la instancia de la clase Fecha
	 */
	@Override
	public String toString() {		
		return "Fecha [Año=" + agno + ", NumeroDeMes=" + mesEnNumero + ", Mes=" + trataMes(mesesEnLetra.get(mesEnNumero)) + ", Dia=" + dia + ", Hora="
				+ hora + ", Minutos=" + minutos + ", Segundos=" + segundos + "]";
	}
	
	
	/**
	 * Metodo que compara la fecha actual con la fecha pasada como argumento
	 * Devuelve -1 si la fecha pasada como argumento es mas actual 
	 * Devuelve 0 si son iguales 
	 * Devuelve 1 si la fecha pasada como argumento es menos actual
	 * 
	 * @param otraFecha ClaseFecha
	 * @return indiceComparativo
	 */
	public int compareTo(Fecha otraFecha) {
		int auxAgno = getAgno() - otraFecha.getAgno();
		int auxMes = getMesEnNumero() - otraFecha.getMesEnNumero();
		int auxDia = getDia() - otraFecha.getDia();
		int auxHora = getHora() - otraFecha.getHora();
		int auxMinuto = getMinutos() - otraFecha.getMinutos();
		int auxSegundo = getSegundos() - otraFecha.getSegundos();
		int indiceComparativo = -1;

		if (auxAgno > 0) {
			indiceComparativo = 1;
		} else if (auxAgno == 0 && auxMes > 0) {
			indiceComparativo = 1;
		} else if (auxAgno == 0 && auxMes == 0 && auxDia > 0) {
			indiceComparativo = 1;
		} else if (auxAgno == 0 && auxMes == 0 && auxDia == 0) {
			indiceComparativo = 0;
		}
		return indiceComparativo;
	}
	
	
	/*----------------------METODOS INTERNOS PARA LA COMPROBACIÓN------------------------------------*/
	
	
	/**
	 * Metodo que comprueba si la fecha pasada como argumento es válida
	 * 
	 * @param fecha Fecha
	 * @return true si la fecha es correcta
	 */
	private boolean isFechaCorrecta(Fecha fecha) {	
		if ((fecha.getMesEnNumero() > 0) && (fecha.getMesEnNumero() < 13)) {
			if ((fecha.getDia() > 0) && (fecha.getDia() <= (DiasDelMes(fecha)))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que devuelve la cantidad de dias que tiene el mes pasado como
	 * argumento
	 * 
	 * @author SSDIsrael
	 * @param int mes, boolean bisiesto
	 * @return int dias
	 */

	private int DiasDelMes(Fecha fecha) {
		boolean bisiesto = isBisiesto(fecha.getAgno());
		int mes = fecha.getMesEnNumero();
		if (mes == 2) {
			if (bisiesto == true) {
				mes = 29;
			} else {
				mes = 28;
			}
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			mes = 30;
		} else {
			mes = 31;
		}
		return mes;
	}

	/**
	 * Metodo que comprueba si el año es bisiesto. Este codigo esta reutilizado de
	 * mi practica numeros 3 de la asignatura de c+- del 2019 de la UNED. La autoría
	 * es mia ( Israel Vargas).
	 * 
	 * @param int año
	 * @return boolean
	 */
	private boolean isBisiesto(int anno) {
		if (anno % 400 == 0 || ((anno % 4 == 0) && (anno % 100 != 0))) {
			return true;
		}
		return false;
	}
}
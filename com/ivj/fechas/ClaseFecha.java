package com.ivj.fechas;

/**
 * Clase creada por Israel Vargas.
 * Se trata de una modificaci�n de la clase Gregorian calendar
 * Se mejora el m�todo
 * @author Israel Vargas
 * @version 2.0
 * @fecha 28-12-2019
 */

import java.util.GregorianCalendar;

public class ClaseFecha extends GregorianCalendar {
	//Campo que almacena el dia de la semana de la compra de la entrada
    private final String diaSemana;
	
	/**
     * Constructor de la clase ClaseFecha sobrecargado. 
     * Genera instancias de la clase ClaseFecha con las variables de entrada aportadas.      
     * @param a�o elegido int
     * @param mes elegido int
     * @param dia elegido int
     * @param hora elegido int
     * @param minuto elegido int 
     */
    public ClaseFecha (int anno, int mes, int dia) throws IllegalArgumentException {    	
        //Crea una instancia de la clase GregorianCalendar con la fecha y hora en el momento de la instanciaciaci�n.
        super(anno,mes-1,dia);
        setLenient(false);        
        //Fija que d�a es considerado como el primer d�a de la semana en Espa�a.
        setFirstDayOfWeek(MONDAY);        
        //Establece cuales son los d�as m�nimos requeridos para considerarse primera semana del a�o;
        setMinimalDaysInFirstWeek(1);        
        //Inicializaci�n de las variables de ClaseFecha        
        diaSemana = devuelveDiaSemana (); 
    }
	
    /**
     * Constructor de la clase ClaseFecha sobrecargado. 
     * Genera instancias de la clase ClaseFecha con los datos actuales en el momento de instanciar.      
     */
    public ClaseFecha () throws IllegalArgumentException {    	       
        super();
        setLenient(false);        
        //Fija que d�a es considerado como el primer d�a de la semana en Espa�a.
        setFirstDayOfWeek(MONDAY);        
        //Establece cuales son los d�as m�nimos requeridos para considerarse primera semana del a�o;
        setMinimalDaysInFirstWeek(1);        
        //Inicializaci�n de las variables de ClaseFecha         
        diaSemana = devuelveDiaSemana (); 
    }
	
    /**
     * Metodo que devuelve el dia de la semana que corresponda en formato String.      
     * @return String diaAux   
     */
    public String devuelveDiaSemana() throws IllegalArgumentException {
       String diaAux;
       switch (get(DAY_OF_WEEK)) {
             case 1:  diaAux = "Domingo";
                      break;
             case 2:  diaAux = "Lunes";        
                      break;
             case 3:  diaAux = "Martes";
                      break;
             case 4:  diaAux = "Miercoles";
                      break;
             case 5:  diaAux = "Jueves";          
                      break;
             case 6:  diaAux = "Viernes";         
                      break;
             case 7:  diaAux = "Sabado";  
                      break;
             default: ; diaAux = "Error";       
       }    
       return diaAux;
    }
            
    /**
     * Metodo que devuelve el dia del mes en el que se creo la instancia de ClaseFecha.        
     * @return dia int  
     */
    public int devuelveNumeroDiaEnMes() {
         //devuelve dia;
         return get (DATE);
    }
           
    /**
     * Metodo que devuelve el mes en el que se creo la instancia de ClaseFecha        
     * @return  mes int  
     */
    public int devuelveMes() {
         return get(MONTH)+1;
    }
       
    /**
     * Metodo que devuelve la semana del año a la que pertenece la instancia de la ClaseFecha      
     * @return     numero de semana del año int  
     */
    public int devuelveSemanaDelAnno() {
        /**Se corrige el hecho de que un a�o tiene 52,14 semanas. 
         * GregorianCalendar cuenta semanas desde 1 hasta 52, con lo que hay n�mero de semanas no es exacto         
         * En lugar de esto se indica al programa que cuando la semana = 1 y mes sea Diciembre se corrija la semana  53. 
         */                  
        int semana = get(WEEK_OF_YEAR);
        if ( (semana == 1) && devuelveMes() > 1 )  {
            semana = 53;            
        }
        // Devuelve el n�mero de semana correspondiente al d�a elegido       
        return semana;
    }
    
    /**
     * Metodo que devuelve el a�o en el que se creo la instancia de ClaseFecha       
     * @return a�o int  
     */
    public int devuelveAnno() {
        // Variable que almacena el a�o del d�a elegido.        
        return get(YEAR);
    }        
        
   /**
     * Metodo que imprime la fecha almacenada en cada instancia de �sta clase.
     */
    public void imprimirFechaDiaria() {
        System.out.print (devuelveDiaSemana()+" ");                
        System.out.print (devuelveNumeroDiaEnMes()+"-");
        System.out.print ( devuelveMes()+ "-");
        System.out.println (devuelveAnno ()+" "); 
    } 
       
    
    /**
     * Metodo que compara dos fechas pasadas como argumento. 
     * Devuelve un valor menor que 0 si la fecha pasada como argumento es mas actual que la de la instancia abstracta
     * Devuelve  0 si son iguales
     * Devuelve un valor mayor que 0 si la fecha de la instancia abstracta es mas actual que la pasada como argumento     * 
     * @param  otraFecha ClaseFecha 
     * @return indice int  
     */ 
    public int compareTo (ClaseFecha otraFecha) {
          int auxAgno = this.devuelveAnno() - otraFecha.devuelveAnno();
          int auxMes = this.devuelveMes() - otraFecha.devuelveMes();
          int auxDia = this.devuelveNumeroDiaEnMes() - otraFecha.devuelveNumeroDiaEnMes();
          int auxDevolver = -1;
       
	      if (auxAgno>0) {
	          auxDevolver=1;
	      }
	      else if (auxAgno==0 && auxMes>0) {             
	          auxDevolver=1;
	      }
	      else if (auxAgno==0 && auxMes==0 && auxDia>0) {
	          auxDevolver=1;
	      }
	      else if(auxAgno==0 && auxMes==0 && auxDia==0) {
	          auxDevolver=0;
	      }
	      return auxDevolver;     
     }
}
	
	
	
	




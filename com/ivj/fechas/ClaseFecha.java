package com.ivj.fechas;

/**
 * Clase creada por Israel Vargas.
 * Se trata de una modificación de la clase Gregorian calendar
 * Se mejora el método
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
     * @param año elegido int
     * @param mes elegido int
     * @param dia elegido int
     * @param hora elegido int
     * @param minuto elegido int 
     */
    public ClaseFecha (int anno, int mes, int dia) throws IllegalArgumentException {    	
        //Crea una instancia de la clase GregorianCalendar con la fecha y hora en el momento de la instanciaciación.
        super(anno,mes-1,dia);
        setLenient(false);        
        //Fija que día es considerado como el primer día de la semana en España.
        setFirstDayOfWeek(MONDAY);        
        //Establece cuales son los días mínimos requeridos para considerarse primera semana del año;
        setMinimalDaysInFirstWeek(1);        
        //Inicialización de las variables de ClaseFecha        
        diaSemana = devuelveDiaSemana (); 
    }
	
    /**
     * Constructor de la clase ClaseFecha sobrecargado. 
     * Genera instancias de la clase ClaseFecha con los datos actuales en el momento de instanciar.      
     */
    public ClaseFecha () throws IllegalArgumentException {    	       
        super();
        setLenient(false);        
        //Fija que día es considerado como el primer día de la semana en España.
        setFirstDayOfWeek(MONDAY);        
        //Establece cuales son los días mínimos requeridos para considerarse primera semana del año;
        setMinimalDaysInFirstWeek(1);        
        //Inicialización de las variables de ClaseFecha         
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
     * Metodo que devuelve la semana del aÃ±o a la que pertenece la instancia de la ClaseFecha      
     * @return     numero de semana del aÃ±o int  
     */
    public int devuelveSemanaDelAnno() {
        /**Se corrige el hecho de que un año tiene 52,14 semanas. 
         * GregorianCalendar cuenta semanas desde 1 hasta 52, con lo que hay número de semanas no es exacto         
         * En lugar de esto se indica al programa que cuando la semana = 1 y mes sea Diciembre se corrija la semana  53. 
         */                  
        int semana = get(WEEK_OF_YEAR);
        if ( (semana == 1) && devuelveMes() > 1 )  {
            semana = 53;            
        }
        // Devuelve el número de semana correspondiente al día elegido       
        return semana;
    }
    
    /**
     * Metodo que devuelve el año en el que se creo la instancia de ClaseFecha       
     * @return año int  
     */
    public int devuelveAnno() {
        // Variable que almacena el año del día elegido.        
        return get(YEAR);
    }        
        
   /**
     * Metodo que imprime la fecha almacenada en cada instancia de ésta clase.
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
	
	
	
	




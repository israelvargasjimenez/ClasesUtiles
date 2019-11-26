import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Esta clase se utiliza para crear una instancia con los datos de dia de la semana, dia del mes , mes y año
 * que corresponde, en el momento de realizar la instancia.
 * Esta clase no almacena como campo los segundos.
 * 
 * @author (Israel Vargas)
 * @version (1 a 16-8-2019)
 */


public class Dia extends GregorianCalendar{
   // Campo que almacena el dia del mes    
   private int dia; 
    
   // Campo que almacena el  mes    
   private int mes;
    
   // Campo que almacena el año   
   private int anno;
    
   /**
    * Constructor
    * @param
    * @return 
    */  
   public  Dia () {
        // Crea una instancia de la clase GregorianCalendar con la fecha y hora en el momento de la instanciación.
        super();
        setLenient (false);
        
        // Fija que día es considerado como el primer día de la semana en España.
        setFirstDayOfWeek(MONDAY);
        
        // Establece cuáles son los días mínimos requeridos en la primera semana del año;
        setMinimalDaysInFirstWeek(1); 
        
        //Variable que almacena una instancia de la clase LocalDate. Esta clase 
        LocalDate a = LocalDate.of(get(YEAR), get(MONTH)+1, get(DATE)); 
        
        this.dia = a.getDayOfMonth();
        this.mes = a.getMonthValue();
        this.anno = a.getYear();
        
    }
   
   /**
    * Metodo que devuelve nombre del día de la semana
    * @param
    * @return dia de la semana String
    */  
   public String  getDiaSemana()  {  
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
    * Metodo que devuelve el numero del dia del mes
    * @param
    * @return dia del mes int
    */    
   
   public int  getDiaDelMes () {
       return get(DATE); 
   }
    
   /**
    * Metodo que devuelve el  mes
    * @param
    * @return  mes int
    */    
   
   public int  getMes () {
       return get(MONTH)+1; 
   }
   
   /**
    * Metodo que devuelve el año
    * @param
    * @return  año int
    */    
   
   public int  getAnno () {
       return get(YEAR); 
   }
   
   /**
    * Metodo que imprime el día completo
    * @param
    * @return  
    */    
   
   public void  imprimeDia () {
       System.out.print(getDiaSemana()+" ");
       System.out.print(dia+ "\\");
       System.out.print(mes+ "\\");
       System.out.println(anno);
   }   
}

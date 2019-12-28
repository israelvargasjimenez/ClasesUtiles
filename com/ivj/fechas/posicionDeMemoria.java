package com.ivj.fechas;
/**
 * Clase que devuelve en formato string, la posición de memoria en Hexadecimal ocupada por el objeto pasado como dato.
 * No se puede utilizar para Objectos del tipo String
 * @author (Israel Vargas)
 * @version (version 1 28-7-2019)
 */
public class posicionDeMemoria {   
    /**
     * Constructor for objects of class posicionDeMemoria
     */
    public posicionDeMemoria(Object objeto)
    {
        posicionMemoria(objeto);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private String posicionMemoria(Object objeto)
    {               
        String objetoString = objeto.toString();
        String [] posicionMemoria = objetoString.split("@");        
        Class clase = objeto.getClass();
        if ( objeto instanceof String)  {
            System.out.println ("Error, no se puede obtener la direcciÃ³n de memoria de un objeto tipo String, con esta clase\n"); 
            return null;
        }
        else {
             String nombreClase = clase.getCanonicalName();
             for ( int i = 0; i < posicionMemoria.length; i++)  {            
                 if ( posicionMemoria [i].equals(nombreClase)) {
                    continue;
                 }
                 else {
                    String memoria = posicionMemoria[i];
                    System.out.println ("Posicion de memoria: "+ memoria);
                    return memoria;                
                }
             } 
        }
        System.out.println ("Posicion de memoria: null");
        return null;
    }
}




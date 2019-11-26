import java.io.FileReader;
import java.io.IOException; 
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.Reader;
import java.io.FileWriter;
import java.io.File;


public class FileManagement { 
    
    public FileManagement ()   {
        
         
        
    }
    
    /**
     * Metodo que lee los datos en el fichero "Almacen_de_datos" en formato String
     * @param
     * @return
     */
    public void readCommonFile ()   {
        BufferedReader objReader = null; 
        
        try {  
            String strCurrentLine;              
            objReader = new BufferedReader (new FileReader("Almacen_de_datos"));   
            while ((strCurrentLine = objReader.readLine()) != null) {    
                System.out.println(strCurrentLine);  
            } 
        } catch (IOException e) {   
            System.out.println ("El fichero a leer no existe");
        }
        finally {   
            try {   
                if (objReader != null) {
                    objReader.close();  
                }
            } catch (IOException ex) {   
                ex.printStackTrace();  
            } 
        }
    }
    
    /**
     * Metodo que guarda los datos tecleados en el teclado en el fichero "Almacen_de_datos" en formato String
     * @param
     * @return
     */
    public void writeCommonFile ()   {
        try {
            System.out.println ( "¿Nombre del archivo a crear?");
            String nombreDelArchivo = new Scanner ( System.in).nextLine();            
            
            System.out.println ("teclee un texto: ");
            String texto = new Scanner ( System.in).nextLine();            
            
            String linea = new String (texto + System.lineSeparator());
            FileWriter archivo = new FileWriter (nombreDelArchivo , true);
            archivo.write(linea);
            archivo.flush();            
            archivo.close();
            
        } catch ( IOException e)  {
            System.out.println ( "error guardando el texto");            
        }        
    }
      
    
    /**
     * Metodo que lee los datos del fichero pasado como argumento en formato String
     * @param String titulo_del_Fichero
     * @return
     */
    public void readSpecificFile (String titulo_del_Fichero)   {
        BufferedReader objReader = null; 
        
        try {  
            String strCurrentLine;              
            objReader = new BufferedReader (new FileReader(titulo_del_Fichero));   
            while ((strCurrentLine = objReader.readLine()) != null) {    
                System.out.println(strCurrentLine);  
            } 
        } catch (IOException e) {   
            System.out.println ("El fichero a leer no existe");
        }
        finally {   
            try {   
                if (objReader != null) {
                    objReader.close();  
                }
            } catch (IOException ex) {   
                ex.printStackTrace();  
            } 
        }
    } 
   
    
   /**
     * Metodo que escribe los datos pasados como argumento en el fichero pasado como argumento en formato String
     * @param String archivo, String texto
     * @return
     */ 
   public void writeSpecificFile (String archivo, String texto)   {
        try {
            String linea = new String (texto + System.lineSeparator());
            File archivoDado = new File (archivo);
            FileWriter escritor = new FileWriter (archivoDado , true);
            escritor.write(linea);
            escritor.flush();            
            escritor.close();            
        } catch ( IOException e)  {
            System.out.println ( "error guardando el texto");            
        }  
    }
}
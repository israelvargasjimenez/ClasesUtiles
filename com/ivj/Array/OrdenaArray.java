package com.ivj.Array;



public class OrdenaArray {
	
	
	
	
	
	

	/**
	 * Metodo que ordena el Array pasado como argumento.
	 * Pone los objetos en las primeras posiciones y los  null después.
	 * @param obj
	 */
	
	public static void primeroObjectosLuegoNull(Object [] obj) {
		//Variable auxiliar
		Object objAux= null;
		
		//Se ordena el Array de coches fabricados conjuntoCochesFabricados
		for ( int i= 0; i < (obj.length)-1; i++) {
			for ( int j = i+1; j < obj.length; j++) {
				if ( (obj[i]==null) && (obj[j]!=null)) {
					objAux = obj[j];
					obj[j] = obj [i];
					obj[i] = objAux;
				}
			}
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

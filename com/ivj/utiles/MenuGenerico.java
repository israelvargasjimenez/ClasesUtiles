package com.ivj.utiles;

/**
 * Men� generico 
 * Se puede utilizar con metodos estaticos o creando una instancia de la clase que se desee y almacenandola en 
 * la variable ob
 * @author Israel Vargas Jim�nez
 * @version 1.0
 * @Fecha 4-3-2020
 *
 */
public class MenuGenerico {

	public MenuGenerico() {
	}
	
	
		public static void main(String[] args) {
			//Variable que almacenar�a el objeto que se desee utilizar para acceder a sus m�todos atraves de las opciones elegidas
			// Si se utilizan metodos estaticos con el men� generico, no es necesario inicializar �sta variable.
			Object ob;
			//Variable que almacena si el usuario ha elegido seguir la ejecucu�n del programa o no.
			boolean seguir = true;
			//Variable que almacena la opci�n elegida por el usuario.
			int opcion = -1;

			do {
				opcion = -1;
				System.out.println("Seleccione opci�n");				
				System.out.println("1- Opci�n");
				System.out.println("2- Opci�n");
				System.out.println("3- Opci�n");
				System.out.println("4- Opci�n");
				System.out.println("5- Opci�n");				
				System.out.println("6- Opci�n");
				System.out.println("7- Opci�n");
				System.out.println("8- Opci�n");
				System.out.println("");
				System.out.print("Opci�n tecleada: ");
				
				opcion = LeerDatos.leerInteger();
				System.out.println("-------------------------");

				switch (opcion) {
				case 1:System.out.println("Se ejecutar�a el metodo estatico correspondiente al case 1");	
				System.out.println("O se ejecutar�a el metodo que elijamos de la variable creada con anterioridad escrito en el case 1");
				System.out.println("");
					break;
				case 2: System.out.println("Se ejecutar�a el metodo estatico correspondiente al case 2");	
				System.out.println("O se ejecutar�a el metodo que elijamos de la variable creada con anterioridad escrito en el case 2");
				System.out.println("");
					break;
				case 3: System.out.println("Se ejecutar�a el metodo estatico correspondiente al case 3");
				System.out.println("O se ejecutar�a el metodo que elijamos de la variable creada con anterioridad escrito en el case 3");
				System.out.println("");
					break;
				case 4: System.out.println("Se ejecutar�a el metodo estatico correspondiente al case 4");
				System.out.println("O se ejecutar�a el metodo que elijamos de la variable creada con anterioridad escrito en el case 4");
				System.out.println("");
					break;
				case 5: System.out.println("Se ejecutar�a el metodo estatico correspondiente al case 5");
				System.out.println("O se ejecutar�a el metodo que elijamos de la variable creada con anterioridad escrito en el case 5");
				System.out.println("");
					break;				
				default:
					System.out.println("Seleccione una opci�n v�lida");
					System.out.println("");
					seguir = true;
				}
				seguir = SeguirEjecutando.seguir();
			} while (seguir);
		}
/**
 * Metodo estatico que indica si se desea seguir ejecutando el programa o no.
 * Si se teclea una opci�n incorrecta, lo indica con un mensaje y no deja continuar hasta
 * que se teclee una opci�n correcta
 * @return boolean
 */
		public static boolean seguir() {
			boolean seguir = false;
			boolean correcto = true;

			do {
				System.out.println("�Desea continuar?:");
				System.out.println("");
				System.out.println("1- Si");
				System.out.println("2- No");

				switch (LeerDatos.leerInteger()) {
				case 1:
					seguir = true;
					correcto = true;
					break;
				case 2:
					seguir = false;
					correcto = true;
					break;
				default:
					System.out.println("--------------------------------------");
					System.out.println("## Elija una opci�n correcta ##");
					System.out.println("--------------------------------------");				
					correcto = false;				
				}
			} while (correcto == false);
			return seguir;
		}
	}


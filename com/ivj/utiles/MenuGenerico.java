package com.ivj.utiles;

/**
 * Menú generico 
 * Se puede utilizar con metodos estaticos o creando una instancia de la clase que se desee y almacenandola en 
 * la variable ob
 * @author Israel Vargas Jiménez
 * @version 1.0
 * @Fecha 4-3-2020
 *
 */
public class MenuGenerico {

	public MenuGenerico() {
	}
	
	
		public static void main(String[] args) {
			//Variable que almacenaría el objeto que se desee utilizar para acceder a sus métodos atraves de las opciones elegidas
			// Si se utilizan metodos estaticos con el menú generico, no es necesario inicializar ésta variable.
			Object ob;
			//Variable que almacena si el usuario ha elegido seguir la ejecucuón del programa o no.
			boolean seguir = true;
			//Variable que almacena la opción elegida por el usuario.
			int opcion = -1;

			do {
				opcion = -1;
				System.out.println("Seleccione opción");				
				System.out.println("1- Opción");
				System.out.println("2- Opción");
				System.out.println("3- Opción");
				System.out.println("4- Opción");
				System.out.println("5- Opción");				
				System.out.println("6- Opción");
				System.out.println("7- Opción");
				System.out.println("8- Opción");
				System.out.println("");
				System.out.print("Opción tecleada: ");
				
				opcion = LeerDatos.leerInteger();
				System.out.println("-------------------------");

				switch (opcion) {
				case 1:System.out.println("Se ejecutaría el metodo estatico correspondiente al case 1");	
				System.out.println("O se ejecutaría el metodo que elijamos de la variable creada con anterioridad escrito en el case 1");
				System.out.println("");
					break;
				case 2: System.out.println("Se ejecutaría el metodo estatico correspondiente al case 2");	
				System.out.println("O se ejecutaría el metodo que elijamos de la variable creada con anterioridad escrito en el case 2");
				System.out.println("");
					break;
				case 3: System.out.println("Se ejecutaría el metodo estatico correspondiente al case 3");
				System.out.println("O se ejecutaría el metodo que elijamos de la variable creada con anterioridad escrito en el case 3");
				System.out.println("");
					break;
				case 4: System.out.println("Se ejecutaría el metodo estatico correspondiente al case 4");
				System.out.println("O se ejecutaría el metodo que elijamos de la variable creada con anterioridad escrito en el case 4");
				System.out.println("");
					break;
				case 5: System.out.println("Se ejecutaría el metodo estatico correspondiente al case 5");
				System.out.println("O se ejecutaría el metodo que elijamos de la variable creada con anterioridad escrito en el case 5");
				System.out.println("");
					break;				
				default:
					System.out.println("Seleccione una opción válida");
					System.out.println("");
					seguir = true;
				}
				seguir = SeguirEjecutando.seguir();
			} while (seguir);
		}
/**
 * Metodo estatico que indica si se desea seguir ejecutando el programa o no.
 * Si se teclea una opción incorrecta, lo indica con un mensaje y no deja continuar hasta
 * que se teclee una opción correcta
 * @return boolean
 */
		public static boolean seguir() {
			boolean seguir = false;
			boolean correcto = true;

			do {
				System.out.println("¿Desea continuar?:");
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
					System.out.println("## Elija una opción correcta ##");
					System.out.println("--------------------------------------");				
					correcto = false;				
				}
			} while (correcto == false);
			return seguir;
		}
	}


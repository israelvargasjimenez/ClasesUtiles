package pri.ivj.menuGenerico;



import java.util.ArrayList;
import java.util.Scanner;


/**
 * Menú generico Se puede utilizar con metodos estaticos o creando una instancia
 * de la clase que se desee y almacenandola en la variable ob
 * 
 * @author Israel Vargas Jiménez
 * @version 1.0
 * @Fecha 4-3-2020
 *
 */
public class MainMenuSinDependencias {

	public static void main(String[] args) {
		ArrayList<String> _menuAImprimirArrayList = null;
		
		boolean seguir = true;
		int opcion = -1;

		try {
			

			do {
				opcion = -1;

				_menuAImprimirArrayList = new ArrayList<String>();

				System.out.println("");
				_menuAImprimirArrayList.add("Seleccione opción");
				_menuAImprimirArrayList.add("1- Opción");
				_menuAImprimirArrayList.add("2- Opción");
				_menuAImprimirArrayList.add("3- Opción");
				_menuAImprimirArrayList.add("4- Opción");
				_menuAImprimirArrayList.add("5- Salir");
				System.out.println("");

				imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 3, 1, 3, 40);

				try {
					opcion = Integer.valueOf(new Scanner(System.in).next());

				} catch (NumberFormatException e) {
					opcion = -1;
				}

				switch (opcion) {
				case 1:
					System.out.println("Presionado 1");
					break;
				case 2:
					System.out.println("Presionado 2");
					break;
				case 3:
					System.out.println("Presionado 3");
					break;
				case 4:
					System.out.println("Presionado 4");
					break;
				case 5:
					seguir = false;
					break;
				default:
					_menuAImprimirArrayList = new ArrayList<String>();
					_menuAImprimirArrayList.add("Seleccione una opción válida");
					_menuAImprimirArrayList.add("");
					imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 1, 1, 3, 40);
					seguir = true;
				}
			} while (seguir);
			_menuAImprimirArrayList = new ArrayList<String>();
			_menuAImprimirArrayList.add("Programa terminado");
			imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 1, 1, 3, 40);

		} catch (Exception e) {
			_menuAImprimirArrayList = new ArrayList<String>();
			_menuAImprimirArrayList.add("Se ha producido una excepción " + e.getMessage());
			imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 1, 1, 3, 40);
		} finally {
			//////////////// CERRAR LAS POSIBLES CONEXIONES AQUI
		}

	}
	
	
	public static void imprimeMarcoTabIzqConTextoInsertado(ArrayList<String> textos, char caracter,
			int cantidadCaracteresLaterales, int cantidadCaracteresVerticales, int espaciosLaterales, int tabulacion) {
		// Caracteres máximos de la frase mayor en textos
		int caracteresTotales = 0;

		// variable que almacena el contador de caracteres utilizados en la frase actual
		int contador = 0;

		/// Se averigua los caracteres máximos a utilizar
		for (String frase : textos) {
			if (caracteresTotales < frase.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2)) {

				caracteresTotales = frase.length() + (espaciosLaterales * 2) + (cantidadCaracteresLaterales * 2);
			}
		}

		// Se imprimen las lineas superiores del marco
		for (int b = 0; b < cantidadCaracteresVerticales; b++) {
			// Se aplica la tabulación indicada
			tabular(tabulacion);
			for (int i = 0; i < caracteresTotales; i++) {
				System.out.print(caracter);
			}
			System.out.println();
		}

		// Se recorre el ArrayList pasado como argumento
		for (int i = 0; i < textos.size(); i++) {
			contador = caracteresTotales;

			// Se aplica la tabulación indicada
			tabular(tabulacion);

			// Se imprimen los caracteres laterales
			for (int j = 0; j < cantidadCaracteresLaterales; j++) {
				System.out.print(caracter);
				contador--;
			}

			// Se imprimen los espacios laterales izquierdos
			for (int j = 0; j < espaciosLaterales; j++) {
				System.out.print(" ");
				contador--;
			}

			// Se imprime la frase de turno
			System.out.print(textos.get(i));
			contador = contador - (textos.get(i).length());

			// Se imprimen los espacios laterales derechos
			for (int j = 0; j < (contador - cantidadCaracteresLaterales); j++) {
				System.out.print(" ");
			}

			// Se imprimen los caracteres finales
			for (int j = 0; j < cantidadCaracteresLaterales; j++) {
				System.out.print(caracter);
			}
			System.out.println();
			// Se recarga el contador de caracteres consumidos, para la siguientes línea
			contador = caracteresTotales;
		}
		for (int c = 0; c < cantidadCaracteresVerticales; c++) {
			// Se aplica la tabulación indicada
			tabular(tabulacion);
			// Se imprime la linea inferior del marco
			for (int i = 0; i < caracteresTotales; i++) {
				System.out.print(caracter);
			}
			System.out.println();
		}
	}
	
	/**
	 * Metodo que aplica la tabulación correspondiente a los espacios pasados como
	 * argumento
	 * 
	 * @param espacios: int
	 */
	private static void tabular(int espacios) {
		// Se tabula con el valor pasado como argumento
		for (int i = 0; i < espacios; i++) {
			System.out.print(" ");
		}
	}
}
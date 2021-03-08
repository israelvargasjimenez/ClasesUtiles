package pri.ivj.menuGenerico;


import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.Scanner;
import pri.ivj.xml.CrearXML;
import pri.ivj.xml.LeerXML;

/**
 * Menú generico Se puede utilizar con metodos estaticos o creando una instancia
 * de la clase que se desee y almacenandola en la variable ob
 * 
 * @author Israel Vargas Jiménez
 * @version 1.0
 * @Fecha 4-3-2020
 *
 */
public class MainMenu {

	public static void main(String[] args) {
		ArrayList<String> _menuAImprimirArrayList = null;

		boolean seguir = true;

		int opcion = -1;

		do {
			opcion = -1;

			_menuAImprimirArrayList = new ArrayList<String>();

			System.out.println("");
			_menuAImprimirArrayList.add("Seleccione opción");
			_menuAImprimirArrayList.add("1- Opción");
			_menuAImprimirArrayList.add("2- Opción");
			_menuAImprimirArrayList.add("3- Opción");
			_menuAImprimirArrayList.add("4- Opción");
			_menuAImprimirArrayList.add("5- Opción");
			System.out.println("");

			GraficosMenus.imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 3, 1, 3, 40);

			try {
				opcion = Integer.valueOf(new Scanner(System.in).next());

			} catch (NumberFormatException e) {
				opcion = -1;
			}

			switch (opcion) {
			case 1:
                ////////////////////////////////////////////////////////////////////////////////////////////
				
				/////////////////////////////////////////////////////////////////////////////////////////

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
				System.out.println("Presionado 5");
				break;
			default:
				_menuAImprimirArrayList = new ArrayList<String>();
				_menuAImprimirArrayList.add("Seleccione una opción válida");
				_menuAImprimirArrayList.add("");
				GraficosMenus.imprimeMarcoTabIzqConTextoInsertado(_menuAImprimirArrayList, '*', 1, 1, 3, 40);

				seguir = true;
			}
			seguir = MenuSeguirEjecutando.seguir();
		} while (seguir);
	}
}
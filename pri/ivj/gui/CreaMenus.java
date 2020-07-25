package pri.ivj.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class CreaMenus {
		
		
		

		/**
		 * Metodo que crea un JFrame con su barra de JMenuBar incluida
		 * @return jFrame:JFrame
		 */
		public static JFrame makeFrameConJMenuBar() {
			
			// Variable para almacenar el marco a utilizar
			JFrame jFrame;
			
			// Se crea nuevo marco
			jFrame = new JFrame("ImageViewer");

			// Se fija el titulo del marco
			jFrame.setTitle("Titulo");

			// Se fija el getContentPane con un Layout FlowLayout
			jFrame.getContentPane().setLayout(new FlowLayout());

			// Se crea la etiqueta
			JLabel label = new JLabel("I am a label");

			// Se fija la etiqueta al ContentPane
			jFrame.getContentPane().add(label);
			
		
			// Se crea la barra de menu en la que iran alojados los menus que creemos
			JMenuBar menuBar = new JMenuBar();

			// Se añade la barra de menu al JFrame, no al ContentPane
			jFrame.setJMenuBar(menuBar);
			
			
			// Se le da la propiedad al marco para que se adecue a los componentes que
			// contenga
			jFrame.pack();

			return jFrame;
		}

		/**
		 * Metodo que devuelve un JMenu utilizando los elementos del ArrayList<Object> pasado como argumento
		 * @param nombreMenu:String
		 * @param elementos:JMenu
		 * @return
		 */
		public static JMenu creaJMenu(String nombreMenu, ArrayList<Object> elementos) {
			// Se crea el menu
			JMenu menuCreado = new JMenu(nombreMenu);

			// Se añaden los items
			for (Object elemento : elementos) {
				menuCreado.add(new JMenuItem(elemento.toString()));
			} 
			// Se devuelbe el menú creado completo
			return menuCreado;
		}
		
		/**
		 * Metodo que borra los elementos en el ArrayList<String> pasado como argumento
		 * @param elementos
		 */
		public static void borraElementos (ArrayList<Object> elementos) {
			// Se borran todos los elementos creados anteriormente en el ArrayList elementos
			elementos.removeAll(elementos);
		}
	}




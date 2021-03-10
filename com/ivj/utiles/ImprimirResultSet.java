package pri.ivj.mySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import pri.ivj.mySQL.GraficosMenus;

public class ImprimirResultSet {

	private ResultSet _resultSet;
	private boolean _verboseVersion = false;
	private GetMetaDeResultSet _metaDeResultSet;
	private ArrayList<String> _nombreColumnas;
	private int _numeroColumnas = 0;
	private int _maxRegistroLenght = 0;	
	private HashMap<String, Integer> _maxLenghtsHashMap = new HashMap<String, Integer>();

	public ImprimirResultSet(ResultSet result, boolean verboseVersion) {
		_resultSet = result;
		_verboseVersion = verboseVersion;
		_metaDeResultSet = new GetMetaDeResultSet(_resultSet, _verboseVersion);
		_nombreColumnas = _metaDeResultSet.get_nombreColumnas();
		_numeroColumnas = _metaDeResultSet.getCantidadDeColumnas();	
		getTamanosMaximosPorColumna();
	}

	public void imprimirResultadoPorFilas() {
		ArrayList<String> filasAImprimir = new ArrayList<String>();
		
		filasAImprimir.add("-----------------------");
		filasAImprimir.add("Resultado de la consuta");
		filasAImprimir.add("-----------------------");
		filasAImprimir.add("");
		
		try {
			posicionarCursorPrimeraLinea();
			while (_resultSet.next()) {
				String lineaRegistroString = "";
				for (String columnaString : _nombreColumnas) {					
					String auxString = formateaStringEntrada(_resultSet.getString(columnaString),_maxLenghtsHashMap.get(columnaString)); 
					
					lineaRegistroString = lineaRegistroString
							.concat(columnaString + ": " + auxString + "  ");
				}
				filasAImprimir.add(lineaRegistroString);
			}
		} catch (SQLException e) {
			System.out.println(
					"Excepción en el metodo imprimirResultadoPorFilas() de la clase ImprimirResultSet");
		}
		filasAImprimir.add("");
		GraficosMenus.imprimeMarcoTabIzqConTextoInsertado(filasAImprimir, '*', 5, 5, 5, 20);
		posicionarCursorPrimeraLinea();
	}

	public void imprimirResultadoPorColumnas() {
		ArrayList<String> ColumnasAImprimir = new ArrayList<String>();
		String lineaRegistroString = "";

		ColumnasAImprimir.add("-----------------------");
		ColumnasAImprimir.add("Resultado de la consuta");
		ColumnasAImprimir.add("-----------------------");
		ColumnasAImprimir.add("");	
		
		
		for(String columna: _nombreColumnas){
			String columnaFormateada = formateaStringEntrada(columna,_maxLenghtsHashMap.get(columna));	
			
			lineaRegistroString = lineaRegistroString
					.concat(columnaFormateada+" |");
		}	
		
		ColumnasAImprimir.add(lineaRegistroString);	
		ColumnasAImprimir.add(GraficosMenus.devuelveLineaLongitudDeterminada(lineaRegistroString, "-"));
		ColumnasAImprimir.add("");
		
		
		try {
			posicionarCursorPrimeraLinea();
			while (_resultSet.next()) {
				lineaRegistroString = "";
				for (String columnaString : _nombreColumnas) {
                      String auxString = formateaStringEntrada(_resultSet.getString(columnaString),_maxLenghtsHashMap.get(columnaString)); 
					
					lineaRegistroString = lineaRegistroString
							.concat(auxString + "  ");
				}
				ColumnasAImprimir.add(lineaRegistroString);
			}
		} catch (SQLException e) {
			System.out.println(
					"Excepción en el metodo imprimirResultadoPorColumnas() de la clase ImprimirResultSet");
		}
		ColumnasAImprimir.add("");
		GraficosMenus.imprimeMarcoTabIzqConTextoInsertado(ColumnasAImprimir, '*', 5, 5, 5, 20);
		posicionarCursorPrimeraLinea();
	}	
	
	
	private void getTamanosMaximosPorColumna() {
		for(String nombreColumna : _nombreColumnas){	
			_maxLenghtsHashMap.put(nombreColumna, getRegistroColumnaMasLargo(nombreColumna));
		}
		posicionarCursorPrimeraLinea();		
	}		

	private int getRegistroColumnaMasLargo(String columna) {
        int maxLength = 0;
        
        for(String nombreColumnaString : _nombreColumnas) {
        	if(nombreColumnaString.length() > maxLength) {
        		maxLength = nombreColumnaString.length();
        	}
        }        
        
		try {
			while (_resultSet.next()) {	
				if (maxLength < _resultSet.getString(columna).length()) {
					maxLength = _resultSet.getString(columna).length();
				}
			}
			posicionarCursorPrimeraLinea();
		} catch (SQLException e) {
			System.out.println(
					"Excepción en el metodo getMaxRegistroLenght(ResultSet resultSet) de la clase ImprimirResultSet");
		}
		return maxLength;
	}

	private String formateaStringEntrada(String registroEntrada, int length) {
		String entradaString = registroEntrada;

		if (registroEntrada.length() < length) {
			for (int i = 0; i < (length - registroEntrada.length()); i++) {
				entradaString = entradaString.concat(" ");
			}
		}
		return entradaString;
	}

	private void posicionarCursorPrimeraLinea() {
		try {			
			_resultSet.beforeFirst();
		} catch (SQLException e) {
			System.out.println(
					"Excepción en el metodo getMaxRegistroLenght(ResultSet resultSet) de la clase ImprimirResultSet");
		}
	}

}

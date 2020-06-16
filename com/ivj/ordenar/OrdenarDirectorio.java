package com.ivj.ordenar;

public class OrdenarDirectorio {
	//Path a ordenar
	String pathDirectorioAOrdenar;
	
	//Path de salida de cada categoria a crear dentro del path a ordenar
	String pathSalidaDirectorioOrdenado;

	public OrdenarDirectorio(String pathDirectorioAOrdenar, String pathSalidaDirectorioOrdenado) {
		super();
		this.pathDirectorioAOrdenar = pathDirectorioAOrdenar;
		this.pathSalidaDirectorioOrdenado = pathSalidaDirectorioOrdenado;
	}

	public String getPathDirectorioAOrdenar() {
		return pathDirectorioAOrdenar;
	}

	public void setPathDirectorioAOrdenar(String pathDirectorioAOrdenar) {
		this.pathDirectorioAOrdenar = pathDirectorioAOrdenar;
	}

	public String getPathSalidaDirectorioOrdenado() {
		return pathSalidaDirectorioOrdenado;
	}

	public void setPathSalidaDirectorioOrdenado(String pathSalidaDirectorioOrdenado) {
		this.pathSalidaDirectorioOrdenado = pathSalidaDirectorioOrdenado;
	}
	
	

}

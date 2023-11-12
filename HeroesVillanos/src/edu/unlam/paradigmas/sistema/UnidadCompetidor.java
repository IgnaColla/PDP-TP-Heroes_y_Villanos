package edu.unlam.paradigmas.sistema;

import java.util.*;

public abstract class UnidadCompetidor {
	protected Bandos bando;
	protected Caracteristica caracteristicas;

	public UnidadCompetidor(Bandos bando, Caracteristica caracteristicas) { 
		//this.bando = validarBando(bando); // hay que validarlo con el enum
		this.bando = bando;
		this.caracteristicas = caracteristicas;
	}

	//revisar por cambio de tipo de BANDO
	/*private Bandos validarBando(Bandos bando) {
	    for (Bandos valorBando : Bandos.values()) {
	        if (valorBando.equals(bando)) {
	            return bando;
	        }
	    }
	    throw new IllegalArgumentException("El bando " + bando + "no es valido");
	}*/

	public Bandos getBando() {
		return this.bando;
	}
	
	protected abstract List<Integer> getCaracteristicas();
	
	public String getCaracteristicaArch() {
		return this.caracteristicas.toStringArch();
	}

	public boolean esMismoBando(UnidadCompetidor unidad) {
		return this.bando.equals(unidad.getBando());
	}
}

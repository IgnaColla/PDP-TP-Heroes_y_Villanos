package edu.unlam.paradigmas.sistema;

import java.util.*;

public abstract class UnidadCompetidor {
	protected Bandos bando;
	protected Caracteristica caracteristicas;

	public UnidadCompetidor(Bandos bando, Caracteristica caracteristicas) {
		this.bando = bando;
		this.caracteristicas = caracteristicas;
	}

	public Bandos getBando() {
		return this.bando;
	}
	
	protected abstract List<Integer> getCaracteristicas();
	
	public String getCaracteristica() {
		return this.caracteristicas.toString();
	}
}

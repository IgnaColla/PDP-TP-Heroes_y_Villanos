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
    protected abstract boolean mismoUnidadCompetidor(UnidadCompetidor unidad);
    protected abstract int contarIntegrantes();
    
    protected void setBando(Bandos bando) {
    	this.bando = bando;
    }

    public String getCaracteristicaToString() {
        return this.caracteristicas.toString();
    }

    public Caracteristica getCaracteristica() {
        return this.caracteristicas;
    }

	public abstract String getNombrePersonaje();
}
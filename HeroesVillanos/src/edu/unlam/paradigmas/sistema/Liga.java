package edu.unlam.paradigmas.sistema;

import java.util.Set;

public class Liga extends UnidadCompetidor {

	private Set<UnidadCompetidor> competidores;
	private int poderVelocidad;
	private int poderFuerza;
	private int poderResistencia;
	private int poderDestreza;

	public Liga(String bando, Caracteristica caracteristicas) {
		super(bando, caracteristicas);
	}

}

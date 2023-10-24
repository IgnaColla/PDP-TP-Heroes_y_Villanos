package edu.unlam.paradigmas.sistema;

import java.util.HashSet;
import java.util.Set;

public class SistemaHeroesVillanos {

	private Set<Competidor> competidores = new HashSet<>();
	private Set<Liga> ligas = new HashSet<>();

	public SistemaHeroesVillanos(Set<Competidor> competidores, Set<Liga> ligas) {
		this.competidores = competidores;
		this.ligas = ligas;
	}

}

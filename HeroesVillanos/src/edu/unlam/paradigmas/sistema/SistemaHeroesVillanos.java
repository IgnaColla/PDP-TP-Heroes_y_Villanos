package edu.unlam.paradigmas.sistema;

import java.util.HashSet;
import java.util.Set;

public class SistemaHeroesVillanos {

	private Set<Competidor> competidores = new HashSet<>();
	private Set<Liga> ligas = new HashSet<>();

	public SistemaHeroesVillanos() {}
	
	//metodos
	public void setCompetidor(Competidor competidor) {
		this.competidores.add(competidor);
	}
	
	public Set<Competidor> getCompetidoresSet(){
		return competidores;
	}
	
	public void listarCompetidores() {
		System.out.println("Listado de Personajes");
		System.out.println("Bando, Nombre Real, Nombre de Personaje, Velocidad, Fuerza, Resistencia, Destreza");
		System.out.println("---------------------------------------------------------------------------------");
		for(Competidor competidor: competidores) {
			System.out.println(competidor.toStringArch());
		}
		System.out.println();
	}

}

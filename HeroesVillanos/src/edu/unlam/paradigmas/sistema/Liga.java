package edu.unlam.paradigmas.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

// import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Liga extends UnidadCompetidor {

	private Set<UnidadCompetidor> competidores = new HashSet<>();

	// Constructores
	public Liga() {
		super(null, null);
	}

	public Liga(Bandos bando, UnidadCompetidor competidores) throws CaracteristicaExcepcion {
		super(bando, new Caracteristica(0,0,0,0));
		this.competidores.add(competidores);
	}

	public Liga(Bandos bando, Caracteristica caracteristicas, List<Competidor> miembros) {
		super(bando, caracteristicas);
		this.competidores.addAll(miembros);
	}

	public void agregarALiga(UnidadCompetidor unidad) {
		this.competidores.add(unidad);
	}

//	public void agregarLigaALiga(Liga liga) throws CaracteristicaExcepcion {
//		List<Integer> lc = liga.getCaracteristicas();
//		int velocidad = lc.get(0);
//		int fuerza = lc.get(1);
//		int resistencia = lc.get(2);
//		int destreza = lc.get(3);
//		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
//		this.competidores.add(new Liga(liga.bando, caracteristica, liga));
//	}

	@Override
	protected List<Integer> getCaracteristicas() {
		List<Integer> caracteristicas = new ArrayList<Integer>();
		int velocidad = 0, fuerza = 0, resistencia = 0, destreza = 0;

		for (UnidadCompetidor unidad : this.competidores) {
			velocidad += unidad.caracteristicas.getVelocidad();
			fuerza += unidad.caracteristicas.getFuerza();
			resistencia += unidad.caracteristicas.getResistencia();
			destreza += unidad.caracteristicas.getDestreza();
		}

		caracteristicas.add(velocidad);
		caracteristicas.add(fuerza);
		caracteristicas.add(resistencia);
		caracteristicas.add(destreza);

		return caracteristicas;
	}

	public Set<UnidadCompetidor> getCompetidores() {
		return this.competidores;
	}

	public boolean ligaContieneDatos() {
		return !this.competidores.isEmpty();
	}

	@Override
	public String toString() {
		return this.bando + ", " + this.getCaracteristicaToString();
	}
	
	public String toStringFile(String linea) {
		return this.bando + " - " + linea;
	}

	@Override
	public String getNombrePersonaje() {
		String linea = "";
		for(UnidadCompetidor unidad: this.competidores) {
			linea += unidad.getNombrePersonaje() + ", ";
		}
		linea = linea.substring(0, linea.length() - 2);
		return linea;
	}
	
}
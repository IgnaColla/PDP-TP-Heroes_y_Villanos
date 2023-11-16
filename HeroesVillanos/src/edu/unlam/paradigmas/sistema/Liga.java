package edu.unlam.paradigmas.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Liga extends UnidadCompetidor {

	private Set<UnidadCompetidor> competidores = new HashSet<>();

	// Constructores
	public Liga() throws CaracteristicaExcepcion {
		super(null, new Caracteristica(0, 0, 0, 0));
	}

	public Liga(Bandos bando, UnidadCompetidor competidores) throws CaracteristicaExcepcion {
		super(bando, new Caracteristica(0, 0, 0, 0));
		this.competidores.add(competidores);
	}

	public Liga(Bandos bando, Caracteristica caracteristicas, List<Competidor> miembros) {
		super(bando, caracteristicas);
		this.competidores.addAll(miembros);
	}

	public void agregarALiga(UnidadCompetidor unidad) {
		this.competidores.add(unidad);
		this.recalcularCaracteristicas();
	}

	@Override
	protected boolean mismoUnidadCompetidor(UnidadCompetidor unidad) {
		for (UnidadCompetidor unidadInterna : competidores) {
			if (unidadInterna.mismoUnidadCompetidor(unidad))
				return true;
		}
		return false;
	}

	@Override
	public List<Integer> getCaracteristicas() {
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

	private void recalcularCaracteristicas() {
		List<Integer> caracteristicas = this.getCaracteristicas();
		this.caracteristicas.setVelocidad(caracteristicas.get(0));
		this.caracteristicas.setFuerza(caracteristicas.get(1));
		this.caracteristicas.setResistencia(caracteristicas.get(2));
		this.caracteristicas.setDestreza(caracteristicas.get(3));
	}

	public int contarIntegrantes() {
		int total = 0;
		for (UnidadCompetidor unidad : competidores) {
			total += unidad.contarIntegrantes();
		}

		return total;
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
		return linea;
	}

	@Override
	public String getNombrePersonaje() {
		String linea = "";
		for (UnidadCompetidor unidad : this.competidores) {
			linea += unidad.getNombrePersonaje() + ", ";
		}
		linea = linea.substring(0, linea.length() - 2);
		return linea;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Liga) {
			Liga otro = (Liga) obj;
			return this.getNombrePersonaje().hashCode() == otro.getNombrePersonaje().hashCode();
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.getNombrePersonaje().hashCode();
	}

}
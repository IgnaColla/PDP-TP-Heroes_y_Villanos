package edu.unlam.paradigmas.sistema;

import java.util.HashSet;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Liga extends UnidadCompetidor {

	private Set<UnidadCompetidor> competidores = new HashSet<>();

	public Liga(String bando, Caracteristica caracteristicas, Set<UnidadCompetidor> competidores) {
		super(bando, caracteristicas);
		competidores.addAll(competidores);
	}

	public void agregar(UnidadCompetidor unidad) {
		if (!existePersonaje(unidad)) {
			competidores.add(unidad); // Agregar la nueva unidad a la liga
			this.caracteristicas.aumentarPoder(unidad.getCaracteristicas());
		} //si no existe, no hay que agregarlo, ya que está en la liga.
	}

	private boolean existePersonaje(UnidadCompetidor unidad) {
		return competidores.contains(unidad);
	}
	
	@Override
	public int enfrentarse(UnidadCompetidor unidad, Caracteristica c) {
		// TODO Auto-generated method stub
		return 0;
	}

//	public Caracteristica calcularPoderGrupo() { por cada personaje que haya, hacer la sumatoria de cada caracteristica

//}

}

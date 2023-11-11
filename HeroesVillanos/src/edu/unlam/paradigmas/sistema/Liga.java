package edu.unlam.paradigmas.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Liga extends UnidadCompetidor {

	private Set<UnidadCompetidor> competidores = new HashSet<>();

	public Liga(Bandos bando, Caracteristica caracteristicas, UnidadCompetidor competidores) {
		super(bando, caracteristicas);
		this.competidores.add(competidores);
	}
	
	public Liga(Bandos bando, Caracteristica caracteristicas, Set<UnidadCompetidor> competidores) {
		super(bando, caracteristicas);
		this.competidores.addAll(competidores);
	}
	
	public void agregarCompetidor(Competidor competidor) {
		this.competidores.add(new Liga(competidor.bando, competidor.caracteristicas, competidor));
	}
	
	public void agregarCompetidor(Liga liga) {
		this.competidores.add(new Liga(liga.bando, liga.calcularCaracteristica, liga));
	}

	
	
	protected List<Integer> getCaracteristica() {
		List<Integer> caracteristicas = new ArrayList<Integer>();
		
		for (UnidadCompetidor unidad : this.competidores) {
			caracteristicas.in
			+= unidad.caracteristicas.getVelocidad();
			caracteristicas[1] += unidad.caracteristicas.getFuerza();
			caracteristicas[2] += unidad.caracteristicas.getVelocidad();
			caracteristicas[3] += unidad.caracteristicas.getVelocidad();
		}
		
		return new Caracteristica(velocidad, fuerza, resistencia, destreza);
	}
	
	/*public void agregar(Set<UnidadCompetidor> liga) {
		if(!this.competidores.equals(liga)) {
			this.competidores.addAll(liga);
		}
	}*/
	
	@Override
	public int enfrentarse(UnidadCompetidor unidad, Caracteristica c) {
		// TODO Auto-generated method stub
		return 0;
	}

//	public Caracteristica calcularPoderGrupo() { por cada personaje que haya, hacer la sumatoria de cada caracteristica

//}
}



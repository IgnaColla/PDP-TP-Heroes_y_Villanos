package edu.unlam.paradigmas.sistema;

public class Competidor extends UnidadCompetidor {
	private String nombreReal;
	private String nombrePersonaje;

	public Competidor(String nombreReal, String nombrePersonaje, Bandos bando, Caracteristica caracteristicas) {
		super(bando, caracteristicas);
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
	}

	@Override
	public int enfrentarse(UnidadCompetidor unidad, Caracteristica c) {
		// TODO Enfrentar competidores
		return 0;
	}

	public String getNombrePersonaje() {
		return this.nombrePersonaje;
	}

	@Override
	public String toString() {
		return "Competidor [nombreReal=" + nombreReal + ", nombrePersonaje=" + nombrePersonaje + ", Bando="
				+ getBando() + ", Caracteristicas=" + getCaracteristicas() + "]";
	}

	
}

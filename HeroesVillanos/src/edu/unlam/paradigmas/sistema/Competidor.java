package edu.unlam.paradigmas.sistema;

public class Competidor extends UnidadCompetidor {
	private String nombreReal;
	private String nombrePersonaje;

	public Competidor(String nombreReal, String nombrePersonaje, String bando, Caracteristica caracteristicas) {
		super(bando, caracteristicas);
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
	}
}

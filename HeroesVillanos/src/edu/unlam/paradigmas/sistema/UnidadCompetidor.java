package edu.unlam.paradigmas.sistema;

public abstract class UnidadCompetidor {
	protected String bando;
	protected Caracteristica caracteristicas;
	enum Bandos {
		Villano,
		Héroe;
	}
	

	public UnidadCompetidor(String bando,Caracteristica caracteristicas) {
		this.bando = validarBando(bando); //hay que validarlo con el enum
		this.caracteristicas = caracteristicas;
	}

	private String validarBando(String bando2) {
		// TODO Auto-generated method stub
		return null;
	}

}

package edu.unlam.paradigmas.sistema;

public abstract class UnidadCompetidor {
	protected String bando;
	protected Caracteristica caracteristicas;

	enum Bandos {
		Villano, Héroe;
	}

	public UnidadCompetidor(String bando, Caracteristica caracteristicas) {
		this.bando = validarBando(bando); // hay que validarlo con el enum
		this.caracteristicas = caracteristicas;
	}

	private String validarBando(String bando) {
	    for (Bandos valorBando : Bandos.values()) {
	        if (valorBando.name().equalsIgnoreCase(bando)) {
	            return bando;
	        }
	    }
	    throw new IllegalArgumentException("El bando " + bando + "no es valido");
	}

	public String getBando() {
		return this.bando;
	}
	
	public Caracteristica getCaracteristicas() {
		return this.caracteristicas;
	}

	public boolean esMismoBando(UnidadCompetidor unidad) {
		return this.bando.equals(unidad.getBando());
	}

	public abstract int enfrentarse(UnidadCompetidor unidad, Caracteristica c);
}

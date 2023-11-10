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
	
	public String getNombreReal() {
		return this.nombreReal;
	}

	public String getNombrePersonaje() {
		return this.nombrePersonaje;
	}

	@Override
	public String toString() {
		return "Competidor [nombreReal=" + nombreReal + ", nombrePersonaje=" + nombrePersonaje + ", Bando="
				+ getBando() + ", Caracteristicas=" + getCaracteristicas() + "]";
	}

	public String toStringArch() {
		return this.bando + ", " + this.nombreReal + ", " + this.nombrePersonaje + ", " 
				+ this.getCaracteristicaArch();
	}
	
	//Sobreescribo equals y hashCode para que los Set los puedan filtrar
	 @Override
	    public boolean equals(Object obj) {
	        if (obj != null && obj instanceof Competidor) {
	        	Competidor otro = (Competidor) obj;
	            return this.nombreReal.hashCode() == otro.nombreReal.hashCode();
	        } else {
	            return false;
	        }
	    }
	 
	    public int hashCode() {
	        return this.nombreReal.hashCode();
	    }
	
}

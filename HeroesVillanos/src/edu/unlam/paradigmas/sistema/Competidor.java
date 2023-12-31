package edu.unlam.paradigmas.sistema;

import java.util.ArrayList;
import java.util.List;

import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class Competidor extends UnidadCompetidor {
	private String nombrePersonaje;
	private String nombreReal;

	public Competidor() {
		super(null, null);
	}

	public Competidor(String nombreReal, String nombrePersonaje, Bandos bando, Caracteristica caracteristicas) {
		super(bando, caracteristicas);
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
	}

	public String getNombreReal() {
		return this.nombreReal;
	}

	public String getNombrePersonaje() {
		return this.nombrePersonaje;
	}

	@Override
	protected List<Integer> getCaracteristicas() {
		List<Integer> caracteristicas = new ArrayList<Integer>();
		caracteristicas.add(this.caracteristicas.getVelocidad());
		caracteristicas.add(this.caracteristicas.getFuerza());
		caracteristicas.add(this.caracteristicas.getResistencia());
		caracteristicas.add(this.caracteristicas.getDestreza());
		return caracteristicas;
	}

	protected boolean mismoUnidadCompetidor(UnidadCompetidor unidad) {
		return this.equals(unidad);
	}

	public int contarIntegrantes() {
		return 1;
	}

	public boolean personajePierdeContraUnidad(UnidadCompetidor u2, TipoCaracteristica caracteristica) {

		int resultado = this.getValorCaracteristica(caracteristica) / this.contarIntegrantes()
				- u2.getValorCaracteristica(caracteristica) / u2.contarIntegrantes();

		if (resultado < 0) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-23s %s", 
				getBando(), 
				getNombreReal(), 
				getNombrePersonaje(), 
				this.caracteristicas);
	}

	// Sobreescribo equals y hashCode para que los Set los puedan filtrar
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

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
	
	public int getValorCaracteristica(TipoCaracteristica opcion) {
		switch (opcion) {
		case 1:
			caracteristica = TipoCaracteristica.VELOCIDAD;
			continuar = false;
			break;
		case 2:
			caracteristica = TipoCaracteristica.FUERZA;
			continuar = false;
			break;
		case 3:
			caracteristica = TipoCaracteristica.RESISTENCIA;
			continuar = false;
			break;
		case 4:
			caracteristica = TipoCaracteristica.DESTREZA;
			continuar = false;
			break;
		default:
			System.out.println("Opcion no valida. Por favor, seleccione una característica valida.");
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
	
	protected int contarIntegrantes() {
		return 1;
	}
	
	@Override
	public String toString() {
		return this.bando + ", " + this.nombreReal + ", " + this.nombrePersonaje + ", " + this.getCaracteristicaToString();
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

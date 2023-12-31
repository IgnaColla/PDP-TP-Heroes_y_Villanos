package edu.unlam.paradigmas.sistema;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Caracteristica {

	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

	public enum TipoCaracteristica {
		VELOCIDAD, FUERZA, RESISTENCIA, DESTREZA;

		private static final TipoCaracteristica[] vals = values();

		public TipoCaracteristica getNext() {
			return vals[(this.ordinal() + 1) % vals.length];
		}
	}

	public Caracteristica(int velocidad, int fuerza, int resistencia, int destreza) throws CaracteristicaExcepcion {
		this.velocidad = validarCaractesticas(velocidad, "La velocidad del personaje es menor a 0, por favor reviselo");
		this.fuerza = validarCaractesticas(fuerza, "La fuerza del personaje es menor a 0, por favor reviselo");
		this.resistencia = validarCaractesticas(resistencia,
				"La resistencia del personaje es menor a 0, por favor reviselo");
		this.destreza = validarCaractesticas(destreza, "La destreza del personaje es menor a 0, por favor reviselo");
	}

	private int validarCaractesticas(int valor, String mensaje) throws CaracteristicaExcepcion {
		if (valor < 0) {
			throw new CaracteristicaExcepcion(mensaje);
		}
		return valor;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public int getFuerza() {
		return this.fuerza;
	}

	public int getResistencia() {
		return this.resistencia;
	}

	public int getDestreza() {
		return this.destreza;
	}

	public void setVelocidad(int valor) {
		this.velocidad = valor;
	}

	public void setFuerza(int valor) {
		this.fuerza = valor;
	}

	public void setResistencia(int valor) {
		this.resistencia = valor;
	}

	public void setDestreza(int valor) {
		this.destreza = valor;
	}

	@Override
	public String toString() {
		return String.format("%-14s %-13s %-18s %-14s",
			   getVelocidad(),
			   getFuerza(),
			   getResistencia(),
			   getDestreza());
	}
}

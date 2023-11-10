package edu.unlam.paradigmas.sistema;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Caracteristica {

	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

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

	public void aumentarPoder(Caracteristica caracteristicas) {
		this.velocidad += caracteristicas.getVelocidad();
		this.fuerza += caracteristicas.getFuerza();
		this.resistencia += caracteristicas.getResistencia();
		this.destreza += caracteristicas.getDestreza();
	}
	
	@Override
	public String toString() {
		return "Caracteristica [velocidad=" + velocidad + ", fuerza=" + fuerza + ", resistencia=" + resistencia
				+ ", destreza=" + destreza + "]";
	}
	
	public String toStringArch() {
		return velocidad+", "+fuerza+", "+resistencia+", "+destreza;
	}
}

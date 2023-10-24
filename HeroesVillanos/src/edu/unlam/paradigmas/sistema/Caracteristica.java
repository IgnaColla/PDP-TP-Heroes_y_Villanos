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

}
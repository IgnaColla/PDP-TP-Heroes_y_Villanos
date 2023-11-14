package edu.unlam.paradigmas.comparadores;

import java.util.Comparator;

import edu.unlam.paradigmas.sistema.Competidor;

public class ComparadorPorBando implements Comparator<Competidor> {
	// Clase que me servirá para ordenar la lista de personajes
	@Override
	public int compare(Competidor c1, Competidor c2) {
		// Comparar por tipo de bando
		int comparacionBando = c1.getBando().compareTo(c2.getBando());

		// Si tienen el mismo bando, comparar por nombre de personaje
		if (comparacionBando == 0) {
			return c1.getNombrePersonaje().compareTo(c2.getNombrePersonaje());
		}

		return comparacionBando;
	}
}

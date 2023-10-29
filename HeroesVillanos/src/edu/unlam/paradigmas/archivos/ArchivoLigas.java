package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CompetidorExcepcion;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}

	public Set<Liga> leer() throws FileNotFoundException {
		File archivoEntradaLigas = new File(this.nombre + ".in");
		//File archivoEntradaLigas = new File(this.nombre + ".in");

		try (Scanner lector = new Scanner(archivoEntradaLigas, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<Liga> ligas = new HashSet<>();
			Set<Competidor> competidoresDisponibles = new HashSet<>();

			String linea;
			String[] nombresPersonajes;

			while (lector.hasNextLine()) {
				linea = lector.next();
				nombresPersonajes = linea.split(", ");

				for (String nombre : nombresPersonajes) {

					// buscar en el set de ArchivoCompetidor -> esto tiene que ser por personaje
					// si existe tengo que crear la liga, sino tengo que arrojar una exception
					// Liga liga = new Liga(bando, caracteristicaLiga, null);
					// ligas.agregar(liga); //armo los paquetes
				}
			}

			return ligas;
		}
	}

//	public Competidor obtenerCompetidor(String nombrePersonaje) {
//		// Buscar en el conjunto de competidores disponibles
//		for (Competidor competidor : competidoresDisponibles) {
//			if (competidor.getNombrePersonaje().equals(nombrePersonaje)) {
//				return competidor; // Devuelve la instancia de Competidor
//			}
//
//			throw new CompetidorExcepcion("El competidor buscado, no existe: " + nombrePersonaje);
//		}
//	}
}

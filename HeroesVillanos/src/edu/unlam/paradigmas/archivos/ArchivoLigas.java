package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}

	public Set<Liga> leer() throws FileNotFoundException {
		File archivo = new File(this.nombre + ".in");

		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<Liga> ligas = new HashSet<>();
			Set<Competidor> competidoresDisponibles = new HashSet<>();

			String linea;
			String[] nombres;

			while (lector.hasNextLine()) {
				linea = lector.next();
				nombres = linea.split(", ");

				for (String nombre : nombres) {

					// buscar en el set de ArchivoCompetidor -> esto tiene que ser por personaje
					// si existe tengo que crear la liga, sino tengo que arrojar una exception
					// Liga liga = new Liga(bando, caracteristicaLiga, null);
					// ligas.agregar(liga); //armo los paquetes
				}
			}

			return ligas;
		}
	}

//	public UnidadCompetidor obtenerUnidad(String nombreUnidad) {
//		// Buscar en el conjunto de competidores disponibles
//		for (Competidor competidor : competidoresDisponibles) {
//			if (competidor.getNombrePersonaje().equals(nombreUnidad)) {
//				return competidor; // Devuelve la instancia de Competidor
//			}
//		}
//		// Si no se encuentra, puedes lanzar una excepción o manejarlo según tus
//		// necesidades
//		//throw new UnidadNoEncontradaException("La unidad competidora no existe: " + nombreUnidad);
//	}

}

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

	private static Competidor buscarCompetidorPorNombre(Set<Competidor> competidores, String nombre) {
		for (Competidor competidor : competidores) {
			if (competidor.getNombrePersonaje().equals(nombre)) {
				return competidor;
			}
		}
		return null; // No se encontró el competidor con el nombre especificado
	}

	public Liga leer(Set<Competidor> competidores) throws FileNotFoundException {
		String path = "./archivos/in/" + this.nombre + ".in";
		File archivoEntradaLigas = new File(path);

		try (Scanner lector = new Scanner(archivoEntradaLigas, "utf-8").useDelimiter("\0").useLocale(Locale.US)) {
			Liga ligas;
			Liga competidoresCargados = new Liga();
			String[] linea;

			while (lector.hasNextLine()) {
				linea = lector.next().split("[,\n]");
				for (String nombrePersonaje : linea) {
					competidoresCargados.agregarCompetidor(buscarCompetidorPorNombre(competidores, nombrePersonaje));
				}
				//calcularcaracteristicas
				ligas.add(competidoresCargados);
			}
			return ligas;
		}
	}

	public boolean escribir(String nombreArchivoSalida) {
		return true;
	}
}

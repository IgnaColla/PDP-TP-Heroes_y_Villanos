package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;

public class ArchivoPersonajes {

	private String nombre;

	public ArchivoPersonajes(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPathIn() {
		return "./archivos/in/" + this.nombre + ".in";
	}
	
	public String getPathOut() {
		return "./archivos/out/" + this.nombre + ".out";
	}

	public Map<Competidor, Integer> leer() throws FileNotFoundException {
		String path = this.getPathIn();
		File archivoEntrada = new File(path);

		try (Scanner lector = new Scanner(archivoEntrada, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Map<Competidor, Integer> personajes = new HashMap<>();
			String[] linea;
			String tipoPersonaje;
			String nombreReal;
			String nombrePersonaje;
			int velocidad;
			int fuerza;
			int resistencia;
			int destreza;
			int nroPersonajeAsignado = 1;

			while (lector.hasNextLine()) {
				linea = lector.nextLine().split("[,\n]");
				tipoPersonaje = linea[0].trim();
				nombreReal = linea[1].trim();
				nombrePersonaje = linea[2].trim();
				velocidad = Integer.parseInt(linea[3].trim());
				fuerza = Integer.parseInt(linea[4].trim());
				resistencia = Integer.parseInt(linea[5].trim());
				destreza = Integer.parseInt(linea[6].trim());
				try {
					Caracteristica c = new Caracteristica(velocidad, fuerza, resistencia, destreza);
					personajes.put(new Competidor(nombreReal, nombrePersonaje, Bandos.valueOf(tipoPersonaje), c),
							nroPersonajeAsignado);
					++nroPersonajeAsignado;
				} catch (CaracteristicaExcepcion e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}

			return personajes;
		}
	}

	public boolean escribir(Map<Competidor, Integer> competidores) throws IOException {
		String path = this.getPathOut();
		try (FileWriter file = new FileWriter(path); PrintWriter printerWriter = new PrintWriter(file)) {
			Map<Competidor, Integer> mapaOrdenado = competidores.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			for (Map.Entry<Competidor, Integer> entry : mapaOrdenado.entrySet()) {
				Competidor competidor = entry.getKey();
				printerWriter.println(competidor.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false; // Devuelve false si hay una excepción al escribir
		}
		return true;
	}
}
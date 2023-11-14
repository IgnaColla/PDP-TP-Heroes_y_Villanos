package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, String> leer() throws FileNotFoundException {
		String path = "./archivos/in/" + this.nombre + ".in";
		File archivoEntradaLigas = new File(path);
		Map<Integer, String> ligasNumeradas = new HashMap<>();

		try (Scanner lector = new Scanner(archivoEntradaLigas, "utf-8")) {
			int numeroLiga = 1;

			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				ligasNumeradas.put(numeroLiga, linea);
				numeroLiga++;
			}
		}

		return ligasNumeradas;
	}

	public boolean escribir(Map<Integer, Liga> ligas) throws IOException {
		String path = "./archivos/out/" + this.nombre + ".out";
		try (FileWriter file = new FileWriter(path); PrintWriter printerWriter = new PrintWriter(file)) {
			String linea = "";
			for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
				Liga liga = entry.getValue();

				for (UnidadCompetidor competidor : liga.getCompetidores()) {
					linea += competidor.getNombrePersonaje() + ", ";
				}

				linea = linea.substring(0, linea.length() - 2);
				printerWriter.println(liga.toStringFile(linea));
				linea = "";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false; // Devuelve false si hay una excepción al escribir
		}
		return true;
	}
}

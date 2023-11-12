package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

	public boolean escribir(String nombreArchivoSalida) {
		return true;
	}
}

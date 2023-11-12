package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<String> leer() throws FileNotFoundException {
        String path = "./archivos/in/" + this.nombre + ".in";
        File archivoEntradaLigas = new File(path);
        Set<String> personajesDeLiga = new HashSet<String>();

        try (Scanner lector = new Scanner(archivoEntradaLigas, "utf-8").useDelimiter("\0").useLocale(Locale.US)) {
            String linea;

            while (lector.hasNextLine()) {
                linea = lector.next();
                personajesDeLiga.add(linea);

            }
        }
        return personajesDeLiga;
    }

	public boolean escribir(String nombreArchivoSalida) {
		return true;
	}
}

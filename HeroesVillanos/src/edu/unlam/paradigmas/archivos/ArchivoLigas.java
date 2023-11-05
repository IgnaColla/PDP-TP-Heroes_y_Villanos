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
	
	public Set<String> leer() throws FileNotFoundException { //a mi nada más me va a interesar los nombres de los personajes, no tengo que crear las instancias de ligas ahora. En el combate se verá el agrupamiento y búsqueda Características.
		File archivoEntradaLigas = new File(this.nombre + ".in");

		try (Scanner lector = new Scanner(archivoEntradaLigas, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<String> ligas = new HashSet<>();
			String linea;
			
			while (lector.hasNextLine()) {
				linea = lector.next();
				ligas.add(linea);
			}

			return ligas;
		}
	}
	
	public boolean escribir(String nombreArchivoSalida) {
		return true;
	}
}

package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import edu.unlam.paradigmas.sistema.Liga;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}

	public Set<Liga> leer() throws FileNotFoundException {
		File archivo = new File(this.nombre + ".in");

		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<Liga> ligas = new HashSet<>();
			String nombrePersonaje;

			while (lector.hasNextLine()) {
				nombrePersonaje = lector.next();
				ligas.add(new Liga(null,null)); //hay que pensar bien esto porque se pasan nombres de personajes. Se tendrá que validar acá si existe en el archivo personajes.in antes de generar la liga?
			}

			return ligas;
		}
	}
}

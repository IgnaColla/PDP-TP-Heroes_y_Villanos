package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;


public class ArchivoPersonajes {

	private String nombre;

	public ArchivoPersonajes(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Competidor> leer() throws FileNotFoundException {
		String path = "./archivos/in/" + this.nombre + ".in";
		File archivoEntrada = new File(path);

		try (Scanner lector = new Scanner(archivoEntrada, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<Competidor> personajes = new HashSet<>();
			String[] linea;
			String tipoPersonaje;
			String nombreReal;
			String nombrePersonaje;
			int velocidad;
			int fuerza;
			int resistencia;
			int destreza;

			while (lector.hasNextLine()) {
				linea = lector.next().split("[,\n]");
				tipoPersonaje = linea[0].trim();
				nombreReal = linea[1].trim();
				nombrePersonaje = linea[2].trim();
				velocidad = Integer.parseInt(linea[3].trim());
				fuerza = Integer.parseInt(linea[4].trim());
				resistencia = Integer.parseInt(linea[5].trim());
				destreza = Integer.parseInt(linea[6].trim());
				try {
					Caracteristica c = new Caracteristica(velocidad, fuerza, resistencia, destreza);
					personajes.add(new Competidor(nombreReal, nombrePersonaje, Bandos.valueOf(tipoPersonaje), c));
				} catch (CaracteristicaExcepcion e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}

			return personajes;
		}
	}

	public boolean escribir(Set<Competidor> competidores)throws IOException {
		String path = "./archivos/out/" + this.nombre + ".out";
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
				file = new FileWriter(path);
				printerWriter = new PrintWriter(file);
				
				for(Competidor clooper : competidores) {
					printerWriter.println(clooper.toStringArch());
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}

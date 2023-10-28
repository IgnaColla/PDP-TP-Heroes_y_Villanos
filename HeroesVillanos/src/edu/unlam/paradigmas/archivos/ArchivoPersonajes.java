package edu.unlam.paradigmas.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;

public class ArchivoPersonajes {

	private String nombreArchivoEntrada;
	private String nombreArchivoSalida;

	public ArchivoPersonajes(String nombreArchivoEntrada,String nombreArchivoSalida) {
		this.nombreArchivoEntrada = nombreArchivoEntrada;
		this.nombreArchivoSalida = nombreArchivoSalida;
	}

	public Set<Competidor> leer() throws FileNotFoundException {
		File archivo = new File(this.nombreArchivoEntrada + ".in");

		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Set<Competidor> personajes = new HashSet<>();
			String tipoPersonaje;
			String nombreReal;
			String nombrePersonaje;
			int velocidad;
			int fuerza;
			int resistencia;
			int destreza;

			while (lector.hasNextLine()) {
				tipoPersonaje = lector.next();
				nombreReal = lector.next();
				nombrePersonaje = lector.next();
				velocidad = lector.nextInt();
				fuerza = lector.nextInt();
				resistencia = lector.nextInt();
				destreza = lector.nextInt();
				try {
					Caracteristica c = new Caracteristica(velocidad, fuerza, resistencia, destreza);
					personajes.add(new Competidor(nombreReal, nombrePersonaje,tipoPersonaje, c));
				} catch (CaracteristicaExcepcion e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}

			return personajes;
		}
	}
	
	
	public boolean escribir(String nombreArchivoSalida) {
		
		
		
		
		return true;
	}

}

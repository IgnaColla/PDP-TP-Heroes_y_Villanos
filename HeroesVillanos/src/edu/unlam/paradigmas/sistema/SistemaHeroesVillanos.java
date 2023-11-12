package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//
import edu.unlam.paradigmas.archivos.*;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class SistemaHeroesVillanos {

	private Set<Competidor> competidores = new HashSet<>();
	private Liga liga = new Liga();
	private boolean archivoPersonajeExiste = false;

	public SistemaHeroesVillanos() {
	}

	// metodos
	public void setCompetidor(Competidor competidor) {
		this.competidores.add(competidor);
	}

	public Set<Competidor> getCompetidoresSet() {
		return competidores;
	}
	
	private static Competidor buscarCompetidorPorNombre(Set<Competidor> competidores, String nombre) {
		for (Competidor competidor : competidores) {
			if (competidor.getNombrePersonaje().equals(nombre)) {
				return competidor;
			}
		}
		return null; // No se encontró el competidor con el nombre especificado
	}

	// 1. Administracion de Personajes
	public void cargarArchivoPersonaje() throws FileNotFoundException {
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");
		Set<Competidor> personajes = personajesFile.leer();

		for (Competidor competidor : personajes) {
			this.setCompetidor(competidor);
		}

		this.archivoPersonajeExiste = true;
		System.out.println("\n¡Los personajes se han cargado correctamente!\n");
	}

	private Bandos seleccionarBando(Scanner scanner) {
		//Scanner scannerBando = new Scanner(System.in);
		Bandos bando = null;
		boolean continuar = true;
		while (continuar) {
//			System.out.println("Bandos:");
//			System.out.println("1. Heroe");
//			System.out.println("2. Villano");
//			System.out.print("Seleccione una opcion: ");

			//int opcion = Integer.parseInt(scanner.nextLine());
			// int opcion = scannerBando.nextInt();
			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				bando = Bandos.Heroe;
				continuar = false;
				break;
			case 2:
				bando = Bandos.Villano;
				continuar = false;
				break;
			default:
				System.out.println("Opcion no valida. Por favor, seleccione una opción valida.");
			}
		}
		
		//scannerBando.close();
		return bando;
	}

	public void crearPersonaje(Scanner scanner) throws CaracteristicaExcepcion {
		
		System.out.println("\n[Crear personaje]");
		System.out.println("+ Seleccione bando:\n1. Heroe\n2. Villano");
		Bandos bando = seleccionarBando(scanner);
		System.out.println("+ Ingrese el nombre real del personaje: ");
		String nombreReal = scanner.nextLine();
		System.out.println("+ Ingrese el nombre del personaje: ");
		String nombrePersonaje = scanner.nextLine();
		System.out.println("+ Ingrese Velocidad: ");
		int velocidad = scanner.nextInt();
		System.out.println("+ Ingrese Fuerza: ");
		int fuerza = scanner.nextInt();
		System.out.println("+ Ingrese Destreza: ");
		int destreza = scanner.nextInt();
		System.out.println("+ Ingrese Resistencia: ");
		int resistencia = scanner.nextInt();

		System.out.println("\nEsta a punto de crear un nuevo personaje. ¿Desea continuar?\n1.Si\n2.No");
		int respuesta = scanner.nextInt();

		if (respuesta == 1) {
			this.setCompetidor(new Competidor(nombreReal, nombrePersonaje, bando,
					new Caracteristica(velocidad, fuerza, resistencia, destreza)));
			System.out.println("\n¡Personaje creado correctamente!\n");
		} else {
			System.out.println("\nSe cancela la creación de personaje.\n");
		}
	}

	public void listarCompetidores1() {
		System.out.println("\n+----- Listado de personajes -----+\n"
				+ "Bando, Nombre Real, Nombre Personaje, Velocidad, Fuerza, Resistencia, Destreza\n"
				+ "--------------------------------------------------------------------------------------------");

		for (Competidor competidor : competidores) {
			System.out.println(competidor.toStringArch());
		}
		System.out.println();
	}

	public void guardarArchivoPersonaje() throws IOException {
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("Personajes");
		if (!personajesFile.escribir(this.competidores)) {
			throw new RuntimeException("\nError al intentar guardar los personajes");
		}
		System.out.println("\nLos personajes se han guardado correctamente!\n");
	}

	// 2. Administracion de Ligas

	public void cargarArchivoLigas() throws FileNotFoundException, CaracteristicaExcepcion {
		if (this.archivoPersonajeExiste == false) {
			System.out.println("\nSe cargara primero el archivo correspondiente a los personajes.");
			this.cargarArchivoPersonaje();
		}

		ArchivoLigas ligasFile = new ArchivoLigas("ligas");
		Set<String> lineasLigas = ligasFile.leer();
		Liga competidoresCargados = new Liga();

		String[] linea;

		for (String liga : lineasLigas) {

			linea = liga.split("[,\n]");

			for (String personaje : linea) {
				competidoresCargados.agregarCompetidor(buscarCompetidorPorNombre(competidores, personaje.trim()));
			}
			this.liga.agregarLiga(competidoresCargados);
		}
//
//        for(Competidor competidor : personajes) {
//            this.setCompetidor(competidor);
//        }

		System.out.println("\nLos personajes se han cargado correctamente!\n");

	}
	
	public void listarCompetidores2() {
		System.out.println("\nListado de Ligas");
		System.out.println("\n---------------------------------------------------------------------------------");
		for (Competidor competidor : competidores) {
			System.out.println(competidor.toStringArch());
		}
		System.out.println();
	}

	// 3. Realizar combate
	public void personajeVsLiga() {

	}
	// 4. Reportes

}

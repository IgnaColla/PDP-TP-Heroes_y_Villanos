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
	private Set<Liga> ligas = new HashSet<>();

	public SistemaHeroesVillanos() {}
	
	//metodos
	public void setCompetidor(Competidor competidor) {
		this.competidores.add(competidor);
	}
	
	public Set<Competidor> getCompetidoresSet(){
		return competidores;
	}
	
	public void cargarArchivoPersonaje() throws FileNotFoundException {
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");
		Set<Competidor> personajes = personajesFile.leer();
		
		for(Competidor competidor : personajes) {
			this.setCompetidor(competidor);
		}
		
		System.out.println("\nLos personajes se han cargado correctamente!\n");
	}
	
	private Bandos seleccionarBando() {
		Scanner scannerBando = new Scanner(System.in);
		Bandos bando = null;
		boolean continuar = true;
		while (continuar) {
			System.out.println("Bandos:");
			System.out.println("1. Heroe");
			System.out.println("2. Villano");
			System.out.print("Seleccione una opcion: ");

			int opcion = scannerBando.nextInt();

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
	
	public void crearPersonaje()throws CaracteristicaExcepcion {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione bando: ");
		Bandos bando = seleccionarBando();
		System.out.println("Ingrese el nombre real del personaje: ");
		String nombreReal = scanner.nextLine();
		System.out.println("Ingrese el nombre del personaje: ");
		String nombrePersonaje = scanner.nextLine();
		System.out.println("Ingrese Velocidad: ");
		int velocidad = scanner.nextInt();
		System.out.println("Ingrese Fuerza: ");
		int fuerza = scanner.nextInt();
		System.out.println("Ingrese Destreza: ");
		int destreza = scanner.nextInt();
		System.out.println("Ingrese Resistencia: ");
		int resistencia = scanner.nextInt();
		
		System.out.println("Esta a punto de crear un nuevo personaje. ¿Desea continuar?\n1.Si\n2.No");
		int respuesta = scanner.nextInt();
		
		if(respuesta == 1) {
			this.setCompetidor(new Competidor(nombreReal, nombrePersonaje, bando, new Caracteristica(velocidad, fuerza, resistencia, destreza)));
			System.out.println("\nPersonaje creado correctamente!");
		}else {
			System.out.println("\nSe cancela la creación de personaje!");
		}
		//scanner.close();
	}
	
	public void listarCompetidores() {
		System.out.println("Listado de Personajes");
		System.out.println("Bando, Nombre Real, Nombre de Personaje, Velocidad, Fuerza, Resistencia, Destreza");
		System.out.println("---------------------------------------------------------------------------------");
		for(Competidor competidor: competidores) {
			System.out.println(competidor.toStringArch());
		}
		System.out.println();
	}
	
	public void guardarArchivoPersonaje() throws IOException{
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("Personajes");
		if(!personajesFile.escribir(this.competidores)) {
			throw new RuntimeException("Error al intentar guardar los personajes");
		}
		System.out.println("\nLos personajes se han guardado correctamente!\n");
	}

}

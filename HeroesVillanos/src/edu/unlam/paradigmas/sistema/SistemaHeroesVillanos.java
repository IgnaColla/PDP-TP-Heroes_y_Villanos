package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.unlam.paradigmas.archivos.ArchivoLigas;
import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
import edu.unlam.paradigmas.compadores.ComparadorCompetidores;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class SistemaHeroesVillanos {

	// private Set<Competidor> competidores = new HashSet<>();
	private Map<Competidor, Integer> competidores = new HashMap<Competidor, Integer>();
	private Liga ligas = new Liga();
	private boolean archivoPersonajeExiste = false;

	public SistemaHeroesVillanos() {
	}

	public void setCompetidor(Competidor competidor, int valor) {
		this.competidores.put(competidor, valor);
	}

	public Map<Competidor, Integer> getCompetidoresSet() {
		return competidores;
	}

	private Competidor buscarCompetidorPorNombre(Map<Competidor, Integer> competidores, String nombre) {
		for (Competidor competidor : competidores.keySet()) {
			if (competidor.getNombrePersonaje().equals(nombre)) {
				return competidor;
			}
		}
		return null; // No se encontró el competidor con el nombre especificado
	}

//	private Liga buscarLigaPorCompetidor(Liga liga, Competidor competidor) {
//
//		for (Competidor ligas : liga) {
//			// Verificar si la liga actual contiene un competidor con el nombre
//			Competidor competidor = buscarCompetidorPorNombre(liga.getCompetidores(), nombre);
//
//			if (competidor != null) {
//				return liga;
//			}
//
//			// Verificar si la liga actual contiene otra liga con el competidor
//			Liga subLiga = buscarLigaPorCompetidor(liga.getCompetidores(), nombre);
//			if (subLiga != null) {
//				return subLiga;
//			}
//		}
//		return null; // No se encontró la liga con el nombre especificado
//	}

	/*
	 * private static Liga buscarCompetidorPorNombreEnLiga(Set<Liga> competidores,
	 * String nombre) { for (Liga liga : competidores) {
	 * 
	 * if (liga.getCompetidores().contains(nombre)) { return liga; }
	 * 
	 * } return null; // No se encontró la liga con el nombre especificado }
	 */

	// 1. Administracion de Personajes

	public void cargarArchivoPersonaje() throws FileNotFoundException {
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");

		if (this.competidores.isEmpty()) {
			this.competidores = personajesFile.leer();
		} else {
			Map<Competidor, Integer> nuevosPersonajes = personajesFile.leer();

			// Obtener el último valor asignado a los competidores existentes
			int ultimoValor = this.competidores.values().stream().max(Integer::compare).orElse(0);

			// Agregar los nuevos personajes al mapa, generando nuevos valores
			for (Map.Entry<Competidor, Integer> entry : nuevosPersonajes.entrySet()) {
				Competidor nuevoCompetidor = entry.getKey();

				// Verificar si el competidor ya existe
				if (this.competidores.containsKey(nuevoCompetidor)) {
					// Generar un nuevo valor para el número de personaje
					ultimoValor++;
					this.competidores.put(nuevoCompetidor, ultimoValor);
				} else {
					// Agregar el competidor con su valor existente
					this.competidores.put(nuevoCompetidor, entry.getValue());
				}
			}
		}

		this.archivoPersonajeExiste = true;
		System.out.println("\n¡Los personajes se han cargado correctamente!\n");
	}

	private Bandos seleccionarBando(Scanner scanner) {
		// Scanner scannerBando = new Scanner(System.in);
		Bandos bando = null;
		boolean continuar = true;
		while (continuar) {
//			System.out.println("Bandos:");
//			System.out.println("1. Heroe");
//			System.out.println("2. Villano");
//			System.out.print("Seleccione una opcion: ");

			// int opcion = Integer.parseInt(scanner.nextLine());
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

		scanner.nextLine(); // Para leer el \n que sobra luego de un nextInt, y se pueda leer el nombre
		return bando;
	}

	public void crearPersonaje(Scanner scanner) throws CaracteristicaExcepcion {
		try {
			System.out.println("\n[Crear personaje]");
			System.out.println("+ Seleccione bando:\n1. Heroe\n2. Villano");
			Bandos bando = seleccionarBando(scanner);

			System.out.println("+ Ingrese el nombre real del personaje: ");
			String nombreReal = scanner.nextLine();

			System.out.println("+ Ingrese el nombre del personaje: ");
			String nombrePersonaje = scanner.nextLine();

			int velocidad = validarObtencionNumero(scanner, "+ Ingrese Velocidad: ");
			int fuerza = validarObtencionNumero(scanner, "+ Ingrese Fuerza: ");
			int destreza = validarObtencionNumero(scanner, "+ Ingrese Destreza: ");
			int resistencia = validarObtencionNumero(scanner, "+ Ingrese Resistencia: ");

			System.out.println("\nEsta a punto de crear un nuevo personaje. ¿Desea continuar?\n1.Si\n2.No");
			int respuesta = validarObtencionNumero(scanner, "Respuesta: ");

			if (respuesta == 1) {
				Competidor nuevoCompetidor = new Competidor(nombreReal, nombrePersonaje, bando,
						new Caracteristica(velocidad, fuerza, resistencia, destreza));

				int nuevoValor = competidores.size() + 1;
				competidores.put(nuevoCompetidor, nuevoValor);

				System.out.println("\n¡Personaje creado correctamente!\n");
			} else {
				System.out.println("\nSe cancela la creación de personaje.\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Ingrese un número válido.");
			scanner.nextLine(); // Limpiar el buffer del scanner
		}
	}

	private int validarObtencionNumero(Scanner scanner, String mensaje) {
		while (true) {
			try {
				System.out.println(mensaje);
				int numero = scanner.nextInt();
				scanner.nextLine(); // Consumir el carácter de nueva línea
				return numero;
			} catch (InputMismatchException e) {
				System.out.println("Error: Ingrese un número válido.");
				scanner.nextLine(); // Limpiar el buffer del scanner
			}
		}
	}

	public void listarPersonajes() {
		List<Competidor> competidoresOrdenados = new ArrayList<>(competidores.keySet());
		Collections.sort(competidoresOrdenados, new ComparadorCompetidores());

		System.out.println("\n+----- Listado de personajes -----+\n"
				+ "   Bando, Nombre Real, Nombre Personaje, Velocidad, Fuerza, Resistencia, Destreza\n"
				+ "--------------------------------------------------------------------------------------------");

		int nroPersonaje = 1;
		for (Competidor competidor : competidoresOrdenados) {
			System.out.println(nroPersonaje + ". " + competidor.toStringArch());
			nroPersonaje++;
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
		Map<Integer, String> lineasLigas = ligasFile.leer();
		Liga competidoresCargados = new Liga();
		Competidor competidorAux;
		Liga ligaAux;

		String[] linea;

		for (String liga : lineasLigas.values()) {

			linea = liga.split("[,\n]");

			for (String personaje : linea) {
				// encontrar ese personaje -> filtrar: bando
				competidorAux = buscarCompetidorPorNombre(this.competidores, personaje.trim());
				// buscar si ese personaje esta en otra liga

				if (competidoresCargados.ligaContieneDatos()) {
					// ligaAux =
					// buscarCompetidorPorNombreEnLiga(competidoresCargados.getCompetidores(),competidorAux);
					// Si está-> hay que agrupar las ligas existentes -> respetando el bando
					// competidoresCargados.agregarLigaALiga(ligaAux);

				} else {
					// no está -> hay que agregar la liga a otro bloque (liga separada)
					// competidoresCargados.agregarCompetidorALiga());

				}
				this.ligas.agregarLigaALiga(competidoresCargados);
			}

		}

		System.out.println("\nLas Ligas se han cargado correctamente!\n");
	}

	public void crearLiga(Scanner scanner) throws CaracteristicaExcepcion {

		System.out.println("\n[Crear Liga]");
		System.out.println("+ Seleccione bando:\n1. Heroe\n2. Villano");
		Bandos bando = seleccionarBando(scanner);
		System.out.println("+ [Selección y administración de liga] +");
		System.out.println("+ ¿Quiere agregar a la liga otra liga o un personaje?:\n1. Liga\n2. Personaje");
		int opcionLigaPersonaje = scanner.nextInt();

		if (opcionLigaPersonaje == 1) {
			listarLigas();
			Liga ligaSeleccionada = new Liga();
			System.out.println("¿Qué liga quiere agregar?");
			int seleccionLiga = scanner.nextInt();
			System.out.println("\nEsta a punto de incluir a ... a la liga...  ¿Desea continuar?\n1.Si\n2.No"); // continuar
			// ligaNueva = liga.obtenerLiga();

		} else {
			listarPersonajes();
			Competidor personajeSeleccionado = new Competidor();
			System.out.println("+ ¿Qué personaje quiere agregar?");
			// seleccion personaje
			int seleccionPersonaje = scanner.nextInt();
			// competidorNuevo = competidores.getOrDefault(seleccionPersonaje,null);
			System.out.println("\nEsta a punto de incluir a ... al personaje...  ¿Desea continuar?\n1.Si\n2.No"); // continuar

			int respuesta = scanner.nextInt();
			if (respuesta == 1) {
				competidores.put(personajeSeleccionado, null);
				System.out.println("\n¡Liga creada y asignada correctamente!\n");
			}
		}
	}

	public void listarLigas() {
//		System.out.println("\nListado de Ligas");
//		System.out.println("\n---------------------------------------------------------------------------------");
//		for (UnidadCompetidor competidor : this.ligas) {
//			System.out.println(competidor.toStringArch());
//		}
		System.out.println();
	}

	public void guardarArchivoLigas() throws IOException {
//		ArchivoPersonajes personajesFile = new ArchivoPersonajes("Personajes");
//		if (!personajesFile.escribir(this.competidores)) {
//			throw new RuntimeException("\nError al intentar guardar los personajes");
//		}
//		System.out.println("\nLos personajes se han guardado correctamente!\n");
	}

	// 3. Realizar combate
	public void personajeVsLiga() {

	}
	// 4. Reportes

}

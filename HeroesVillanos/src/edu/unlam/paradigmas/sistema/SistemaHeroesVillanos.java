package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.unlam.paradigmas.archivos.ArchivoLigas;
import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
import edu.unlam.paradigmas.comparadores.ComparadorPorCaracteristica;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class SistemaHeroesVillanos {

	private Map<Competidor, Integer> competidores = new HashMap<Competidor, Integer>();
	private Map<Integer, Liga> ligas = new HashMap<>();
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


//------------------------------ 1. Administracion de Personajes ------------------------------

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
		Bandos bando = null;
		boolean continuar = true;
		while (continuar) {

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
				System.out.println("Opcion no valida. Por favor, seleccione un bando valido.");
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
		mensajeListadoPersonajes();

		int nroPersonaje = 1;
		for (Competidor competidor : competidoresOrdenados) {
			System.out.println(nroPersonaje + ". " + competidor.toString());
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



//------------------------------ 2. Administracion de Ligas ------------------------------

	public void cargarArchivoLigas() throws FileNotFoundException, CaracteristicaExcepcion {
		if (this.archivoPersonajeExiste == false) {
			System.out.println("\nSe cargara primero el archivo correspondiente a los personajes.");
			this.cargarArchivoPersonaje();
		}

		ArchivoLigas ligasFile = new ArchivoLigas("ligas");
		Map<Integer, String> lineasLigas = ligasFile.leer();
		String[] linea;
		List<UnidadCompetidor> miembros = new ArrayList<>();
		Competidor competidor = new Competidor();
		
		int velocidadLiga, fuerzaLiga, resistenciaLiga, destrezaLiga, cantMiembros, numeroLiga = 1;

		for (String ligas : lineasLigas.values()) {
			linea = ligas.split(",\\s*");
			cantMiembros = 0;
			velocidadLiga = 0;
			fuerzaLiga = 0;
			resistenciaLiga = 0;
			destrezaLiga = 0;

			for (String personaje : linea) {
				competidor = buscarCompetidorPorNombre(competidores, personaje);
				if(competidor == null) {
					continue;
				}
				
				miembros.add(competidor);
				velocidadLiga += competidor.getCaracteristica().getVelocidad();
				fuerzaLiga += competidor.getCaracteristica().getFuerza();
				resistenciaLiga += competidor.getCaracteristica().getResistencia();
				destrezaLiga += competidor.getCaracteristica().getDestreza();
				cantMiembros++;
			}

			Bandos bandoLiga = miembros.get(0).bando;
			velocidadLiga /= cantMiembros;
			fuerzaLiga /= cantMiembros;
			resistenciaLiga /= cantMiembros;
			destrezaLiga /= cantMiembros;

			Caracteristica caracteristicas = new Caracteristica(velocidadLiga, fuerzaLiga, resistenciaLiga, destrezaLiga);
			Liga liga = new Liga("Liga " + numeroLiga, bandoLiga, caracteristicas, miembros);
			this.ligas.put(numeroLiga, liga);

			numeroLiga++;
		}

		System.out.println("\n¡Las Ligas se han cargado correctamente!\n");
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
		System.out.println("\nListado de Ligas"
				+ "\"Nombre de Liga, Bando, Velocidad, Fuerza, Resistencia, Destreza\n"
				+ "---------------------------------------------------------------------------------");
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			int numeroLiga = entry.getKey();
			Liga liga = entry.getValue();
			System.out.println(numeroLiga + ". " + liga.toString());
		}
		System.out.println();
	}

	public void guardarArchivoLigas() throws IOException {
		ArchivoLigas ligasFile = new ArchivoLigas("Ligas");
		if (!ligasFile.escribir(this.ligas)) {
			throw new RuntimeException("\nError al intentar guardar las ligas.");
		}
		System.out.println("\n¡Las ligas se han guardado correctamente!\n");
	}

	

// ------------------------------ 3. Realizar combate ------------------------------
	
	public void enfrentar(UnidadCompetidor u1, UnidadCompetidor u2) {
		
	}
	
//	public boolean esMismoBando(UnidadCompetidor, UnidadCompetidor unidad) {
//	return .equals(unidad.getBando());
//}
	

	
	
//------------------------------ 4. Reportes ------------------------------
	
	
	//○ Todos los personajes o ligas que venzan a un personaje dado para cierta
	// característica
	

	public void ordenarPersonajesPorCaracteristica(Scanner scanner) throws FileNotFoundException {
		System.out.println("\n[Ordenar personajes por caracteristicas]");
		System.out.println(
				"+ Seleccione las caracteristicas para ordenar:\n1. Velocidad\n2. Fuerza\n3. Resistencia\n4. Destreza");
		TipoCaracteristica caracteristicaSeleccionada = seleccionarCaracteristica(scanner);

		listarPersonajes(caracteristicaSeleccionada);
	}
	
	private TipoCaracteristica seleccionarCaracteristica(Scanner scanner) {
		TipoCaracteristica caracteristica = null;
		boolean continuar = true;
		while (continuar) {

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				caracteristica = TipoCaracteristica.VELOCIDAD;
				continuar = false;
				break;
			case 2:
				caracteristica = TipoCaracteristica.FUERZA;
				continuar = false;
				break;
			case 3:
				caracteristica = TipoCaracteristica.RESISTENCIA;
				continuar = false;
				break;
			case 4:
				caracteristica = TipoCaracteristica.DESTREZA;
				continuar = false;
				break;
			default:
				System.out.println("Opcion no valida. Por favor, seleccione una característica valida.");
			}
		}

		scanner.nextLine(); // Para leer el \n que sobra luego de un nextInt, y se pueda leer el nombre
		return caracteristica;
	}

	public void listarPersonajes(TipoCaracteristica caracteristicaOrden) throws FileNotFoundException {

		if (this.competidores.isEmpty()) {
			ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");
			this.competidores = personajesFile.leer();
		}

		List<Competidor> competidoresOrdenados = new ArrayList<>(this.competidores.keySet());

		// Crear una instancia de PersonajeComparator con la característica seleccionada
		ComparadorPorCaracteristica comparator = new ComparadorPorCaracteristica(caracteristicaOrden);

		// Ordenar la lista de personajes utilizando el comparador
		competidoresOrdenados.sort(comparator);

		int nroPersonaje = 1;
		mensajeListadoPersonajes();
		for (Competidor competidor : competidoresOrdenados) {
			System.out.println(nroPersonaje + ". " + competidor.toString());
			nroPersonaje++;
		}

		System.out.println();

	}

	private void mensajeListadoPersonajes() {
		System.out.println("\n+----- Listado de personajes -----+\n"
				+ "   Bando, Nombre Real, Nombre Personaje, Velocidad, Fuerza, Resistencia, Destreza\n"
				+ "--------------------------------------------------------------------------------------------");
	}

}
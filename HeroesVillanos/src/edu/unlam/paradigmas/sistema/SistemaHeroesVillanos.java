package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import edu.unlam.paradigmas.archivos.ArchivoLigas;
import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
import edu.unlam.paradigmas.comparadores.ComparadorPorCaracteristica;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.excepciones.SistemaExcepcion;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class SistemaHeroesVillanos {

	private Map<Competidor, Integer> competidores = new TreeMap<>();
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

				if (numero >= 0) {
					scanner.nextLine(); // Consumir el carácter de nueva línea
					return numero;
				} else {
					System.out.println("Error: Ingrese un número mayor o igual a 0.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Ingrese un número válido.");
				scanner.nextLine(); // Limpiar el buffer del scanner
			}
		}
	}

	public void listarPersonajes() {
		mensajeListadoPersonajes();
		Map<Competidor, Integer> mapaOrdenado = competidores.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		for (Map.Entry<Competidor, Integer> entry : mapaOrdenado.entrySet()) {
			System.out.println(entry.getValue() + ". " + entry.getKey());
		}

		System.out.println();
	}

	public void listarPersonajes(Bandos bando, List<Integer> listaPersonajes) {
		mensajeListadoPersonajes();
		Map<Competidor, Integer> mapaOrdenado = competidores.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		Competidor competidor = new Competidor();
		int valorEntrada;
		for (Map.Entry<Competidor, Integer> entry : mapaOrdenado.entrySet()) {
			competidor = entry.getKey();
			valorEntrada = entry.getValue();
			if (competidor.getBando() == bando && !listaPersonajes.contains(valorEntrada)) {
				System.out.println(valorEntrada + ". " + competidor);
			}
		}
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
		List<Competidor> miembros = new ArrayList<>();
		Competidor competidor = new Competidor();

		int velocidadLiga, fuerzaLiga, resistenciaLiga, destrezaLiga, numeroLiga = 1;

		for (String ligas : lineasLigas.values()) {
			linea = ligas.split(",\\s*");
			velocidadLiga = 0;
			fuerzaLiga = 0;
			resistenciaLiga = 0;
			destrezaLiga = 0;

			for (String personaje : linea) {
				competidor = buscarCompetidorPorNombre(competidores, personaje);
				if (competidor == null) {
					continue;
				}

				miembros.add(competidor);
				velocidadLiga += competidor.getCaracteristica().getVelocidad();
				fuerzaLiga += competidor.getCaracteristica().getFuerza();
				resistenciaLiga += competidor.getCaracteristica().getResistencia();
				destrezaLiga += competidor.getCaracteristica().getDestreza();
			}

			Bandos bando = miembros.get(0).bando;
			Caracteristica caracteristicas = new Caracteristica(velocidadLiga, fuerzaLiga, resistenciaLiga,
					destrezaLiga);
			Liga liga = new Liga(bando, caracteristicas, miembros);
			this.ligas.put(numeroLiga, liga);
			miembros.clear();
			numeroLiga++;
		}

		System.out.println("\n¡Las Ligas se han cargado correctamente!\n");
	}

	public void crearLiga(Scanner scanner) throws CaracteristicaExcepcion, SistemaExcepcion {

		System.out.println("\n[Crear Liga]\n");
		System.out.println("+ Seleccione bando:\n1. Heroe\n2. Villano");
		Bandos bando = seleccionarBando(scanner);
		if (puedeCrearLiga(bando)) {
			List<Integer> listaPersonajes = new ArrayList<>();
			List<Integer> listaLigas = new ArrayList<>();
			int opcionLigaPersonaje = validarObtencionNumero(scanner,
					"+ ¿Quiere agregar a la liga otra liga o un personaje?:\n1. Liga\n2. Personaje");

			while (opcionLigaPersonaje != 0) {
				if (opcionLigaPersonaje == 1) {
					System.out.println("[Selección de liga]\n");
					int seleccionLiga;

					do {
						listarLigas(bando, listaLigas);
						System.out.println("\n0. Volver menu anterior");
						seleccionLiga = validarObtencionNumero(scanner, "¿Qué liga quiere agregar?\n");
						if(seleccionLiga != 0) {
							listaLigas.add(seleccionLiga);
							System.out.println("La liga ha sido agregada correctamente.");
						}
					} while (seleccionLiga != 0 && validarSeleccionLigas(bando, listaLigas));
				} else {
					System.out.println("[Selección de personajes]\n");
					int seleccionPersonaje;

					do {
						listarPersonajes(bando, listaPersonajes);
						System.out.println("\n0. Volver menu anterior");
						seleccionPersonaje = validarObtencionNumero(scanner, "¿Qué liga quiere agregar?\n");
						if (seleccionPersonaje != 0) {
							listaPersonajes.add(seleccionPersonaje);
							System.out.println("La liga ha sido agregada correctamente.");
						}
					} while (seleccionPersonaje != 0 && validarSeleccionPersonaje(bando, listaPersonajes));
				}
				opcionLigaPersonaje = validarObtencionNumero(scanner,
						"+ ¿Quiere agregar a la liga otra liga o un personaje?:\n1. Liga\n2. Personaje\n\n0. Finalizar");
			}
			
			int sizePersonajes = listaPersonajes.size();
			int sizeLigas = listaLigas.size();
			if( sizePersonajes != 0 || sizeLigas != 0) {
				System.out.println("\nEsta a punto de crear una nueva Liga. ¿Desea continuar?\n1.Si\n2.No");
				int respuesta = validarObtencionNumero(scanner, "Respuesta: ");

				if (respuesta == 1) {
					int nroLiga = ligas.size() + 1;
					
					Liga liga = new Liga();
					if(sizeLigas != 0) {
						for(Integer valor : ligas.keySet()) {
							if(listaLigas.contains(valor)) {
								if(!liga.mismoUnidadCompetidor(ligas.get(valor)))
									liga.agregarALiga(ligas.get(valor));
							}
						}
					}
					if(sizePersonajes != 0) {
						for(Competidor comp : competidores.keySet()) {
							if(listaPersonajes.contains(competidores.get(comp))) {
								if(!liga.mismoUnidadCompetidor(comp))
									liga.agregarALiga(comp);
							}
						}
					}
					
					this.ligas.put(nroLiga, liga);
					System.out.println("\n¡Liga creada correctamente!\n");
				} else {
					System.out.println("\nSe cancela la creación de Liga.\n");
				}
			}
		}else {
			System.out.println("\nNo posee personajes del tipo seleccionado para el armado de ligas.\n");
		}

		
	}

	private boolean puedeCrearLiga(Bandos bando) {
		for (Map.Entry<Competidor, Integer> competidor : competidores.entrySet()) {
			if (competidor.getKey().getBando() == bando) {
				return true;
			}
		}
		return false;
	}

	private boolean validarSeleccionLigas(Bandos bando, List<Integer> listaLigas) {
		Liga liga = new Liga();
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			liga = entry.getValue();
			if (liga.getBando() == bando && !listaLigas.contains(entry.getKey())) {
				return true;
			}
		}
		return false;
	}

	private boolean validarSeleccionPersonaje(Bandos bando, List<Integer> listaPersonaje) {
		Competidor competidor = new Competidor();
		for (Map.Entry<Competidor, Integer> entry : competidores.entrySet()) {
			competidor = entry.getKey();
			if (competidor.getBando() == bando && !listaPersonaje.contains(entry.getValue())) {
				return true;
			}
		}
		return false;
	}

	public void listarLigas() {
		mensajeParaListarLigas();
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			int numeroLiga = entry.getKey();
			Liga liga = entry.getValue();
			System.out.println(numeroLiga + ". " + liga.getNombrePersonaje());
		}
		System.out.println();
	}

	public void listarLigas(Bandos bando, List<Integer> listaLigas) {
		mensajeParaListarLigas();
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			Liga liga = entry.getValue();
			if (liga.getBando() == bando && !listaLigas.contains(entry.getKey())) {
				int numeroLiga = entry.getKey();
				System.out.println(numeroLiga + ". " + liga.getNombrePersonaje());
			}
		}
	}

	private void mensajeParaListarLigas() {
		System.out.println("\nListado de Ligas\n" + "Nombre de Liga, Bando, Velocidad, Fuerza, Resistencia, Destreza\n"
				+ "---------------------------------------------------------------------------------");
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

	// ○ Todos los personajes o ligas que venzan a un personaje dado para cierta
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
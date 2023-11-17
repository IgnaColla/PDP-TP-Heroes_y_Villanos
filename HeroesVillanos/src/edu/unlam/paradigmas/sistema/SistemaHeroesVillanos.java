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
import java.util.stream.Collectors;

import edu.unlam.paradigmas.archivos.ArchivoLigas;
import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
import edu.unlam.paradigmas.comparadores.ComparadorPorCaracteristica;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.excepciones.SistemaExcepcion;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class SistemaHeroesVillanos {

	private Map<Competidor, Integer> competidores = new HashMap<>();
	private Map<Integer, Liga> ligas = new HashMap<>();
	private boolean archivoPersonajeExiste = false;
	
	public SistemaHeroesVillanos() {}

	public void setCompetidor(Competidor competidor, int valor) {
		this.competidores.put(competidor, valor);
	}

	public Map<Competidor, Integer> getCompetidoresSet() {
		return competidores;
	}

	private Competidor buscarCompetidorPorNombrePersonaje(Map<Competidor, Integer> competidores, String nombre) {
		for (Competidor competidor : competidores.keySet()) {
			if (competidor.getNombrePersonaje().equals(nombre)) {
				return competidor;
			}
		}
		return null; // No se encontró el competidor con el nombre especificado
	}

	private Competidor buscarCompetidorPorNumero(Map<Competidor, Integer> competidores, int numero) {
		for (Competidor competidor : competidores.keySet()) {
			if (competidores.get(competidor) == numero) {
				return competidor;
			}
		}
		return null; // No se encontró el competidor con el nombre especificado
	}

	private boolean existenPersonajes() {
		return this.archivoPersonajeExiste || !this.competidores.isEmpty();
	}

//*********************** 1. Administracion de Personajes ***********************

	public void cargarArchivoPersonaje() throws FileNotFoundException {
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");

		if (!this.archivoPersonajeExiste) {
			if (!this.competidores.isEmpty()) {
				Map<Competidor, Integer> nuevosPersonajes = personajesFile.leer().entrySet().stream()
						.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

				// Obtener el último valor asignado a los competidores existentes
				int ultimoValor = this.competidores.values().stream().max(Integer::compare).orElse(0);

				// Agregar los nuevos personajes al mapa, generando nuevos valores
				for (Map.Entry<Competidor, Integer> entry : nuevosPersonajes.entrySet()) {
					Competidor nuevoCompetidor = entry.getKey();

					// Verificar si el competidor no existe
					if (!this.competidores.containsKey(nuevoCompetidor)) {
						// Generar un nuevo valor para el número de personaje
						ultimoValor++;
						this.competidores.put(nuevoCompetidor, ultimoValor);
					}
				}
			} else {
				this.competidores = personajesFile.leer();
			}
			this.archivoPersonajeExiste = true;
			System.out.println("¡Los personajes se han cargado correctamente!");
		} else {
			System.out.println("\n¡Archivo cargado anteriormente, se aborta la acción!\n");
		}
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
			int resistencia = validarObtencionNumero(scanner, "+ Ingrese Resistencia: ");
			int destreza = validarObtencionNumero(scanner, "+ Ingrese Destreza: ");

			System.out.println("\nEsta a punto de crear un nuevo personaje. ¿Desea continuar?\n1.Si\n2.No");
			int respuesta = validarObtencionNumero(scanner, "Respuesta: ");

			if (respuesta == 1) {
				Competidor nuevoCompetidor = new Competidor(nombreReal, nombrePersonaje, bando,
						new Caracteristica(velocidad, fuerza, resistencia, destreza));

				if (!this.competidores.containsKey(nuevoCompetidor)) {

					int nuevoValor = competidores.size() + 1;

					competidores.put(nuevoCompetidor, nuevoValor);

					System.out.println("\n¡Personaje creado correctamente!\n");
				} else {
					System.out.println("\n¡Personaje ya creado previamente, se aborta la acción!\n");
				}

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

	private void mensajeListadoPersonajes() {
		System.out.println("\n+----- Listado de personajes -----+\n"
				+ "  Bando\t\tNombre Real\t   Nombre Personaje\tVelocidad\tFuerza\t    Resistencia\t\tDestreza\n"
				+ "----------------------------------------------------------------------------------------------------------------");
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

	public void listarPersonajes(Bandos bando) {
		mensajeListadoPersonajes();
		Map<Competidor, Integer> mapaOrdenado = competidores.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		Competidor competidor = new Competidor();
		int valorEntrada;
		for (Map.Entry<Competidor, Integer> entry : mapaOrdenado.entrySet()) {
			competidor = entry.getKey();
			valorEntrada = entry.getValue();
			if (competidor.getBando() == bando) {
				System.out.println(valorEntrada + ". " + competidor);
			}
		}
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
		ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");
		if (!personajesFile.escribir(this.competidores)) {
			throw new RuntimeException("\nError al intentar guardar los personajes");
		}
		System.out.println("\nLos personajes se han guardado correctamente!\n");
	}

//*********************** 2. Administracion de Ligas ***********************

	public void cargarArchivoLigas() throws FileNotFoundException, CaracteristicaExcepcion {
		if (this.archivoPersonajeExiste == false) {
			System.out.println("\nPara cargar las ligas, primero se debe cargar el archivo de personajes.\n");
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
				competidor = buscarCompetidorPorNombrePersonaje(competidores, personaje);
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

		System.out.println("¡Las Ligas se han formado correctamente!\n");
	}

	public Liga crearLiga(List<Integer> listaPersonajes, List<Integer> listaLigas, Bandos bando)
			throws CaracteristicaExcepcion {
		int sizePersonajes = listaPersonajes.size();
		int sizeLigas = listaLigas.size();

		Liga liga = new Liga();
		if (sizeLigas != 0) {
			for (Integer valor : ligas.keySet()) {
				if (listaLigas.contains(valor)) {
					if (!liga.mismoUnidadCompetidor(ligas.get(valor)))
						liga.agregarALiga(ligas.get(valor));
				}
			}
		}
		if (sizePersonajes != 0) {
			for (Competidor comp : competidores.keySet()) {
				if (listaPersonajes.contains(competidores.get(comp))) {
					if (!liga.mismoUnidadCompetidor(comp))
						liga.agregarALiga(comp);
				}
			}
		}

		liga.setBando(bando);

		return liga;
	}

	public void menuCrearLiga(Scanner scanner) throws CaracteristicaExcepcion, SistemaExcepcion {

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

						if (seleccionLiga != 0) {

							if (ligas.get(seleccionLiga).getBando() == bando && !listaLigas.contains(seleccionLiga)) {
								listaLigas.add(seleccionLiga);
								System.out.println(
										"La liga seleccionada ha sido agregada correctamente a la nueva liga.");
							} else {
								System.out.println("Seleccione una liga válida.");
							}
						}
					} while (seleccionLiga != 0 && validarSeleccionLigas(bando, listaLigas));
				} else {
					System.out.println("[Selección de personajes]\n");
					int seleccionPersonaje;
					boolean agregoPersonaje;

					do {
						listarPersonajes(bando, listaPersonajes);
						System.out.println("\n0. Volver menu anterior");
						seleccionPersonaje = validarObtencionNumero(scanner, "¿Qué personaje quiere agregar?\n");
						agregoPersonaje = false;

						if (seleccionPersonaje != 0) {
							for (Competidor comp : competidores.keySet()) {
								if (competidores.get(comp) == seleccionPersonaje) {
									if (comp.getBando() == bando && !listaPersonajes.contains(seleccionPersonaje)) {
										agregoPersonaje = true;
										break;
									}
								}
							}

							if (agregoPersonaje) {
								listaPersonajes.add(seleccionPersonaje);
								System.out.println("El personaje ha sido agregado correctamente a la liga.");
							} else {
								System.out.println("Seleccione un personaje válido.");
							}
						}
					} while (seleccionPersonaje != 0 && validarSeleccionPersonaje(bando, listaPersonajes));
				}
				opcionLigaPersonaje = validarObtencionNumero(scanner,
						"+ ¿Quiere agregar a la liga otra liga o un personaje?:\n1. Liga\n2. Personaje\n\n0. Finalizar");
			}

			int sizePersonajes = listaPersonajes.size();
			int sizeLigas = listaLigas.size();
			if (sizePersonajes != 0 || sizeLigas != 0) {
				System.out.println("\nEsta a punto de crear una nueva Liga. ¿Desea continuar?\n1.Si\n2.No");
				int respuesta = validarObtencionNumero(scanner, "Respuesta: ");

				if (respuesta == 1) {
					int nroLiga = ligas.size() + 1;

					Liga liga = crearLiga(listaPersonajes, listaLigas, bando);

					// valido que no exista la liga que quiero agregar
					boolean existeLigas = false;
					for (Integer keyLigas : ligas.keySet()) {
						if (ligas.get(keyLigas).equals(liga)) {
							existeLigas = true;
						}
					}

					if (!existeLigas) {
						this.ligas.put(nroLiga, liga);
						System.out.println("\n¡Liga creada correctamente!\n");
					} else {
						System.out.println("La liga que intenta crear ya existe. Intente nuevamente.");
					}
				} else {
					System.out.println("\nSe cancela la creación de Liga.\n");
				}
			} else {
				System.out.println("No ha seleccionado personajes o ligas para la creacion de la nueva liga.");
			}
		} else {
			System.out.println("\nNo posee personajes del tipo seleccionado para el armado de ligas.\n");
			System.out.println("\nPor favor cargue el archivo correspondiente.\n");
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

	private boolean validarSeleccionLigas(Bandos bando, List<Integer> listaLigas) throws CaracteristicaExcepcion {
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
			System.out.println(numeroLiga + ". " + liga.bando + "\t" + liga.getNombrePersonaje());
		}
		System.out.println();
	}

	public void listarLigas(Bandos bando) {
		mensajeParaListarLigas();
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			Liga liga = entry.getValue();
			if (liga.getBando() == bando) {
				int numeroLiga = entry.getKey();
				System.out.println(numeroLiga + ". " + liga.bando + "\t" + liga.getNombrePersonaje());
			}
		}
	}

	public void listarLigas(Bandos bando, List<Integer> listaLigas) {
		mensajeParaListarLigas();
		for (Map.Entry<Integer, Liga> entry : ligas.entrySet()) {
			Liga liga = entry.getValue();
			if (liga.getBando() == bando && !listaLigas.contains(entry.getKey())) {
				int numeroLiga = entry.getKey();
				System.out.println(numeroLiga + ". " + liga.bando + "\t" + liga.getNombrePersonaje());
			}
		}
	}

	private void mensajeParaListarLigas() {
		System.out.println("\n+----- Listado de ligas -----+\n" + "   Bando\tIntegrantes\t\n"
				+ "---------------------------------------------------------------------------------");
	}

	public void guardarArchivoLigas() throws IOException {
		ArchivoLigas ligasFile = new ArchivoLigas("ligas");
		if (!ligasFile.escribir(this.ligas)) {
			throw new RuntimeException("\nError al intentar guardar las ligas.");
		}
		System.out.println("\n¡Las ligas se han guardado correctamente!\n");
	}

//*********************** 3. Realizar combate ***********************

	private void mostrarResultadoEnfrentamiento(UnidadCompetidor u1, UnidadCompetidor u2, int resultado,
			TipoCaracteristica caracteristica) {
		if (resultado > 0) {
			System.out.println("\nGanador: " + u1.getNombrePersonaje() + " - Caracteristica: " + caracteristica
					+ " Diferencia: " + Math.abs(resultado) + " puntos.");
		} else if (resultado < 0) {
			System.out.println("\nGanador: " + u2.getNombrePersonaje() + " - Caracteristica: " + caracteristica
					+ " Diferencia: " + Math.abs(resultado) + " puntos.");
		} else {
			System.out.println("\nSe produjo un empate entre los 2 competidores");
		}
	}

	public int enfrentar(UnidadCompetidor u1, UnidadCompetidor u2, TipoCaracteristica caracteristica) {
		int resultadoFinal = 0;
		TipoCaracteristica nuevaCaracteristica = caracteristica;
		int resultado = u1.getValorCaracteristica(nuevaCaracteristica) / u1.contarIntegrantes()
				- u2.getValorCaracteristica(nuevaCaracteristica) / u2.contarIntegrantes();

		System.out.println("\n+----- COMBATE -----+\n");
		System.out.println("[" + u1.getNombrePersonaje() + "]\t\tVS \t[" + u2.getNombrePersonaje() + "]");

		imprimirCaracteristicas(u1, u2);

		System.out.println("\n+ Caracterisitica: " + nuevaCaracteristica);
		System.out.println();
		if (resultado == 0) {
			do {
				System.out.println("¡Han empatado en " + nuevaCaracteristica + "!");
				nuevaCaracteristica = nuevaCaracteristica.getNext();
				if (nuevaCaracteristica != caracteristica) {
					System.out.println("Ahora combatiran por: " + nuevaCaracteristica);
					resultado = u1.getValorCaracteristica(nuevaCaracteristica) / u1.contarIntegrantes()
							- u2.getValorCaracteristica(nuevaCaracteristica) / u2.contarIntegrantes();
				}
			} while (resultado == 0 && nuevaCaracteristica != caracteristica);
		}

		mostrarResultadoEnfrentamiento(u1, u2, resultado, nuevaCaracteristica);

		if (resultado > 0) {
			resultadoFinal = 1;
		} else if (resultado < 0) {
			resultadoFinal = -1;
		}

		return resultadoFinal;

	}

	public void personajeVsPersonaje(Scanner scanner) {
		if (existenPersonajes()) {
			int seleccionPersonaje;
			Competidor competidor1 = new Competidor();
			Competidor competidor2 = new Competidor();
			System.out.println("\n[Seleccione Personaje:]\n");
			listarPersonajes();
			System.out.println("\n0. Volver menu anterior");
			seleccionPersonaje = validarObtencionNumero(scanner, "¿Qué personaje quiere agregar?\n");
			if (seleccionPersonaje != 0) {
				competidor1 = buscarCompetidorPorNumero(competidores, seleccionPersonaje);
				System.out.println("El personaje ha sido seleccionado correctamente.");

				Bandos bando = Bandos.Heroe;

				if (competidor1.getBando() == Bandos.Heroe) {
					bando = Bandos.Villano;
				}

				System.out.println("\n[Seleccione Oponente:]\n");
				do {
					listarPersonajes(bando);
					System.out.println("\n0. Volver menu anterior");
					seleccionPersonaje = validarObtencionNumero(scanner, "¿Qué personaje quiere agregar?\n");
					competidor2 = buscarCompetidorPorNumero(competidores, seleccionPersonaje);
					if (seleccionPersonaje != 0 && competidor1.getBando() == competidor2.getBando()) {
						System.out.println("Seleccione un personaje válido.");
					}
				} while (seleccionPersonaje != 0 && competidor1.getBando() == competidor2.getBando());

				if (seleccionPersonaje != 0) {
					System.out.println("El personaje ha sido seleccionado correctamente.");
					System.out.println(
							"+ Seleccione las caracteristicas para enfrentarse:\n1. Velocidad\n2. Fuerza\n3. Resistencia\n4. Destreza");
					TipoCaracteristica caracteristicaSeleccionada = seleccionarCaracteristica(scanner);

					enfrentar(competidor1, competidor2, caracteristicaSeleccionada);
				} else {
					System.out.println("¡Volviendo al menu anterior...!");
				}
			} else {
				System.out.println("¡Volviendo al menu anterior...!");
			}
		} else {
			System.out.println("No existen personajes para realizar los enfrentamientos.");
			System.out.println("Debe cargar previamente los archivos.");
		}

	}

	public void personajeVsLiga(Scanner scanner) throws CaracteristicaExcepcion {
		if (existenPersonajes()) {
			int seleccion;
			Competidor competidor = new Competidor();
			Liga liga = new Liga();
			System.out.println("\n[Seleccione Personaje:]\n");
			listarPersonajes();
			System.out.println("\n0. Volver menu anterior");
			seleccion = validarObtencionNumero(scanner, "¿Qué personaje quiere agregar?\n");
			if (seleccion != 0) {
				competidor = buscarCompetidorPorNumero(competidores, seleccion);
				System.out.println("El personaje ha sido seleccionado correctamente.");
				
				Bandos bando = Bandos.Heroe;

				if (competidor.getBando() == Bandos.Heroe) {
					bando = Bandos.Villano;
				}

				System.out.println("\n[Seleccione Liga Oponente:]\n");
				do {
					listarLigas(bando);
					System.out.println("\n0. Volver menu anterior");
					seleccion = validarObtencionNumero(scanner, "¿Qué liga quiere agregar?\n");
					liga = ligas.get(seleccion);
					if (seleccion != 0 && competidor.getBando() == liga.getBando()) {
						System.out.println("Seleccione un personaje válido.");
					}
				}while(seleccion != 0 && competidor.getBando() == liga.getBando());
				
				if(seleccion != 0) {
					System.out.println("La liga ha sido seleccionado correctamente.");
					System.out.println(
							"+ Seleccione las caracteristicas para enfrentarse:\n1. Velocidad\n2. Fuerza\n3. Resistencia\n4. Destreza");
					TipoCaracteristica caracteristicaSeleccionada = seleccionarCaracteristica(scanner);

					enfrentar(competidor, liga, caracteristicaSeleccionada);
				}else {
					System.out.println("¡Volviendo al menu anterior...!");
				}
			}else {
				System.out.println("¡Volviendo al menu anterior...!");
			}
		} else {
			System.out.println("No existen personajes para realizar los enfrentamientos.");
			System.out.println("Debe cargar previamente los archivos.");
		}

	}

	public void ligaVsLiga(Scanner scanner) throws CaracteristicaExcepcion {
		if (existenPersonajes()) {
			int seleccionLiga;
			Liga liga1 = new Liga();
			Liga liga2 = new Liga();
			System.out.println("\n[Seleccione Liga:]\n");
			listarLigas();
			System.out.println("\n0. Volver menu anterior");
			seleccionLiga = validarObtencionNumero(scanner, "¿Qué liga quiere agregar?\n");
			if (seleccionLiga != 0) {
				liga1 = ligas.get(seleccionLiga);
				System.out.println("La liga ha sido seleccionada correctamente.");
			}

			Bandos bando = Bandos.Heroe;

			if (liga1.getBando() == Bandos.Heroe) {
				bando = Bandos.Villano;
			}

			System.out.println("\n[Seleccione Liga Oponente:]\n");
			listarLigas(bando);
			System.out.println("\n0. Volver menu anterior");
			seleccionLiga = validarObtencionNumero(scanner, "¿Qué personaje quiere agregar?\n");
			if (seleccionLiga != 0) {
				liga2 = ligas.get(seleccionLiga);
				System.out.println("La liga ha sido seleccionada correctamente.");
			}

			System.out.println(
					"+ Seleccione las caracteristicas para enfrentarse:\n1. Velocidad\n2. Fuerza\n3. Resistencia\n4. Destreza");
			TipoCaracteristica caracteristicaSeleccionada = seleccionarCaracteristica(scanner);

			enfrentar(liga1, liga2, caracteristicaSeleccionada);
		} else {
			System.out.println("No existen ligas para realizar los enfrentamientos.");
			System.out.println("Debe cargar previamente los archivos.");
		}
	}

	public static void imprimirCaracteristicas(UnidadCompetidor u1, UnidadCompetidor u2) {
		int cantMiembros1 = u1.contarIntegrantes();
		int cantMiembros2 = u2.contarIntegrantes();

		String velocidadStr = String.format("Velocidad:\t%-4s\t\tVelocidad:\t%-4s",
				u1.getCaracteristica().getVelocidad() / cantMiembros1,
				u2.getCaracteristica().getVelocidad() / cantMiembros2);
		System.out.println(velocidadStr);

		String fuerzaStr = String.format("Fuerza:\t\t%-4s\t\tFuerza:\t\t%-4s",
				u1.getCaracteristica().getFuerza() / cantMiembros1, u2.getCaracteristica().getFuerza() / cantMiembros2);
		System.out.println(fuerzaStr);

		String resistenciaStr = String.format("Resistencia:\t%-4s\t\tResistencia:\t%-4s",
				u1.getCaracteristica().getResistencia() / cantMiembros1,
				u2.getCaracteristica().getResistencia() / cantMiembros2);
		System.out.println(resistenciaStr);

		String destrezaStr = String.format("Destreza:\t%-4s\t\tDestreza:\t%-4s",
				u1.getCaracteristica().getDestreza() / cantMiembros1,
				u2.getCaracteristica().getDestreza() / cantMiembros2);
		System.out.println(destrezaStr);
	}

//*********************** 4. Reportes ***********************

	public void reportarVencedores(Scanner scanner) throws FileNotFoundException {

		if (this.competidores.size() != 0) {

			int seleccionPersonaje;
			Competidor competidor = new Competidor();
			System.out.println("\n[Seleccione Personaje:]\n");
			listarPersonajes();
			System.out.println("\n0. Volver menu anterior");
			seleccionPersonaje = validarObtencionNumero(scanner,
					"¿En base a qué personaje quiere realizar el reporte?\n");
			if (seleccionPersonaje != 0) {
				competidor = buscarCompetidorPorNumero(competidores, seleccionPersonaje);
				System.out.println("El personaje ha sido seleccionado correctamente.");
				System.out.println(
						"+Seleccione las caracteristicas para enfrentarse:\n1. Velocidad\n2. Fuerza\n3. Resistencia\n4. Destreza");
				TipoCaracteristica caracteristicaSeleccionada = seleccionarCaracteristica(scanner);

				System.out.println("\nPersonajes que vencen a: " + competidor.getNombrePersonaje());

				for (Competidor comp : competidores.keySet()) {
					if (competidor.personajePierdeContraUnidad(comp, caracteristicaSeleccionada)
							&& competidor.getBando() != comp.getBando()) {
						System.out.println(comp);
					}
				}

				System.out.println("\nLigas que vencen a: " + competidor.getNombrePersonaje());

				for (Integer liga : ligas.keySet()) {
					if (competidor.personajePierdeContraUnidad(ligas.get(liga), caracteristicaSeleccionada)
							&& competidor.getBando() != ligas.get(liga).getBando()) {
						System.out.println(ligas.get(liga).getNombrePersonaje());
					}
				}
			}
		} else {
			System.out.println("\n[Por favor cargue personajes y listas para poder utilizar esta funcionalidad]\n");
		}
	}

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

	private void listarPersonajes(TipoCaracteristica caracteristicaOrden) throws FileNotFoundException {

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

}

//***********************************************************
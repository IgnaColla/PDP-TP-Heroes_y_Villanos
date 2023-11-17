package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Menu {

	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();

	public void menuPrincipal() throws FileNotFoundException, CaracteristicaExcepcion, IOException {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {

			int opcion = validarEntrada(scanner, "\n[Menu Principal]\n" + "1. Administrar Personajes\n" + "2. Administrar Ligas\n"
					+ "3. Realizar combates\n" + "4. Reportes\n" + "\n0. Salir\n"
					+ "+----- Seleccione una opcion -----+\n");

			switch (opcion) {
			case 1:
				// Lógica para la administración de personajes (carga, creación, listado,
				// guardar en archivo).
				opcionAdministrarPersonajes(scanner);
				break;
			case 2:
				// Lógica para la administración de ligas (carga, creación, listado, guardar en
				// archivo).
				opcionAdministrarLigas(scanner);
				break;
			case 3:
				// Logica para la realización de combates (personaje contra liga, liga contra
				// liga).
				opcionRealizarCombate(scanner);
				break;
			case 4:
				// Lógica para generar reportes.
				opcionGenerarReporte(scanner);
				break;
			case 0:
				continuar = false;
				scanner.close();
				System.out.println("¡Gracias por jugar!");
				break;
			default:
				System.out.println("Opcion no valida. Por favor, seleccione una opción valida.");
			}
		}
	}


	
//*********************** Administrar Personajes ***********************

	private void opcionAdministrarPersonajes(Scanner scanner) throws CaracteristicaExcepcion, IOException {
		boolean continuar = true;
		while (continuar) {

			int opcion = validarEntrada(scanner,"\n[Administrar Personajes]\n" + "1. Cargar desde archivo\n" + "2. Crear personaje\n"
					+ "3. Listar personajes\n" + "4. Guardar personajes en archivo\n" + "\n0. Volver al menu principal\n"
					+ "+----- Seleccione una opcion -----+\n");

			switch (opcion) {
			case 1:
				subOpcionCargarArchivoPersonaje();
				break;
			case 2:
				subOpcionCrearPersonaje(scanner);
				break;
			case 3:
				subOpcionListarPersonajes();
				break;
			case 4:
				subOpcionGuardarArchivoPersonajes();
				break;
			case 0:
				continuar = false;
				System.out.println("\n¡Volviendo al menu principal...!");
				break;
			default:
				System.out.println("\nOpcion no valida. Por favor, seleccione una opción valida.");
			}
		}
	}

	private void subOpcionCargarArchivoPersonaje() throws FileNotFoundException {
		sistema.cargarArchivoPersonaje();
	}

	private void subOpcionCrearPersonaje(Scanner scanner) throws CaracteristicaExcepcion {
		sistema.crearPersonaje(scanner);
	}

	private void subOpcionListarPersonajes() {
		sistema.listarPersonajes();
	}

	private void subOpcionGuardarArchivoPersonajes() throws IOException {
		sistema.guardarArchivoPersonaje();
	}



//*********************** Administrar Ligas ***********************

	private void opcionAdministrarLigas(Scanner scanner) throws CaracteristicaExcepcion, IOException {
		boolean continuar = true;
		while (continuar) {

			int opcion = validarEntrada(scanner,"\n[Administracion de Ligas]\n" + "1. Cargar desde archivo\n" + "2. Crear liga\n"
					+ "3. Listar ligas\n" + "4. Guardar en archivo ligas\n" + "\n0. Volver al menu anterior\n"
					+ "Seleccione una opción: ");

			switch (opcion) {
			case 1:
				subOpcionCargarLigaDesdeArchivo();
				break;
			case 2:
				subOpcionCrearLiga(scanner);
				break;
			case 3:
				subOpcionListarLigas();
				break;
			case 4:
				subOpcionGuardarEnArchivoLigas();
				break;
			case 0:
				continuar = false;
				System.out.println("¡Volviendo al menu anterior...!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	private void subOpcionCargarLigaDesdeArchivo() throws FileNotFoundException, CaracteristicaExcepcion {
		sistema.cargarArchivoLigas();
	}

	private void subOpcionCrearLiga(Scanner scanner) throws CaracteristicaExcepcion {
		sistema.menuCrearLiga(scanner);
	}

	private void subOpcionListarLigas() {
		sistema.listarLigas();
	}

	private void subOpcionGuardarEnArchivoLigas() throws IOException {
		sistema.guardarArchivoLigas();
	}



//*********************** Realizar Combate ***********************
	
	private void opcionRealizarCombate(Scanner scanner) throws CaracteristicaExcepcion {
		boolean continuar = true;
		while (continuar) {

			int opcion = validarEntrada(scanner,"\n[Realizar Combate]\n" + "1. Personaje vs Personaje\n" + "2. Personaje vs Liga\n"
					+ "3. Liga vs Liga\n" + "\n0. Volver al menu anterior\n" + "Seleccione una opción: ");

			switch (opcion) {
			case 1:
				subOpcionPersonajeVsPersonaje(scanner);
				break;
			case 2:
				// Logica de Personaje vs Personaje
				subOpcionPersonajeVsLiga(scanner);
				break;
			case 3:
				// logica de Liga vs Liga
				subOpcionLigaVsLiga(scanner);
				break;
			case 0:
				continuar = false;
				System.out.println("¡Volviendo al menu anterior...!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	private void subOpcionPersonajeVsPersonaje(Scanner scanner) {
		sistema.personajeVsPersonaje(scanner);
	}

	private void subOpcionPersonajeVsLiga(Scanner scanner) throws CaracteristicaExcepcion {
		sistema.personajeVsLiga(scanner);
	}

	private void subOpcionLigaVsLiga(Scanner scanner) throws CaracteristicaExcepcion {
		sistema.ligaVsLiga(scanner);
	}



//*********************** Generar Reporte ***********************

	private void opcionGenerarReporte(Scanner scanner) throws FileNotFoundException {
		boolean continuar = true;
		while (continuar) {

			int opcion = validarEntrada(scanner,"\n[Generar reporte]\n"
					+ "1. Personaje o Liga que vence a un Personaje seleccionado por caracteristica\n"
					+ "2. Listar Personajes por caracteristica\n" + "\n0. Volver al menu anterior\n"
					+ "Seleccione una opción: ");

			switch (opcion) {
			case 1:
				subOpcionReportarVencedorAPersonaje(scanner);
				break;
			case 2:
				subOpcionOrdenarPersonajes(scanner);
				break;
			case 0:
				continuar = false;
				System.out.println("¡Volviendo al menu anterior...!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	private void subOpcionReportarVencedorAPersonaje(Scanner scanner) throws FileNotFoundException {
		sistema.reportarVencedores(scanner);
	}

	private void subOpcionOrdenarPersonajes(Scanner scanner) throws FileNotFoundException {
		sistema.ordenarPersonajesPorCaracteristica(scanner);
	}
	
	//*************************METODOS_UTILES************************
	private int validarEntrada(Scanner scanner, String mensaje) {
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
}

//***************************************************************

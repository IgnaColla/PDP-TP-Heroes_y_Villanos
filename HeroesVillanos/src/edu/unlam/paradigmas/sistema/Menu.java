package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.excepciones.SistemaExcepcion;

public class Menu {

	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();

	public void menuPrincipal() throws FileNotFoundException, CaracteristicaExcepcion, IOException, SistemaExcepcion {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {

			System.out.println("\n[Menu Principal]\n" + "1. Administrar Personajes\n" + "2. Administrar Ligas\n"
					+ "3. Realizar combates\n" + "4. Reportes\n" + "5. Salir\n"
					+ "+----- Seleccione una opcion -----+\n");

			int opcion = scanner.nextInt();

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
			case 5:
				continuar = false;
				scanner.close();
				System.out.println("¡Gracias por jugar!");
				break;
			default:
				System.out.println("Opcion no valida. Por favor, seleccione una opción valida.");
			}
		}
	}

//****************************************************************************Administrar Personajes***********************************************************************/

	private void opcionAdministrarPersonajes(Scanner scanner) throws CaracteristicaExcepcion, IOException {
		boolean continuar = true;
		while (continuar) {
			System.out.println("[Administrar Personajes]\n"
					+ "1. Cargar desde archivo\n"
					+ "2. Crear personaje\n"
					+ "3. Listar personajes\n"
					+ "4. Guardar personajes en archivo\n"
					+ "5. Volver al menu principal\n"
					+ "+----- Seleccione una opcion -----+\n");

			int opcion = scanner.nextInt();

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
			case 5:
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

//****************************************************************************Administrar Ligas***************************************************************************/

	private void opcionAdministrarLigas(Scanner scanner) throws CaracteristicaExcepcion, IOException, SistemaExcepcion {
		boolean continuar = true;
		while (continuar) {
			System.out.println("Administracion de ligas:\n"
					+ "1. Cargar desde archivo\n"
					+ "2. Crear liga\n"
					+ "3. Listar ligas\n"
					+ "4. Guardar en archivo ligas\n"
					+ "5. Volver al menu anterior\n"
					+ "Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				subOpcionCargarLigaDesdeArchivo();
				break;
			case 2:
				subOpcionCrearLiga(scanner);
				break;
			case 3:
				subOcionListarLigas();
				break;
			case 4:
				subOpcionGuardarEnArchivoLigas();
				break;
			case 5:
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

	private void subOpcionCrearLiga(Scanner scanner) throws CaracteristicaExcepcion, SistemaExcepcion {
		sistema.crearLiga(scanner);
	}

	private void subOcionListarLigas() {
		sistema.listarLigas();
	}

	private void subOpcionGuardarEnArchivoLigas() throws IOException {
		sistema.guardarArchivoLigas();
	}

//*************************************************************************************************************************************************************************

//****************************************************************************Realizar Combate*****************************************************************************/
	private void opcionRealizarCombate(Scanner scanner) {
		boolean continuar = true;
		while (continuar) {
			System.out.println("Realizar Combate:\n"
					+ "1. Personaje vs Personaje\n"
					+ "2. Personaje vs Liga\n"
					+ "3. Liga vs Liga\n"
					+ "4. Volver al menu anterior\n"
					+ "Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				subOpcionPersonajeVsPersonaje();
				break;
			case 2:
				// Logica de Personaje vs Personaje
				subOpcionPersonajeVsLiga();
				break;
			case 3:
				// logica de Liga vs Liga
				subOpcionLigaVsLiga();
				break;
			case 4:
				continuar = false;
				System.out.println("¡Volviendo al menu anterior...!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	private static void subOpcionPersonajeVsPersonaje() {
		
	}
	
	private static void subOpcionPersonajeVsLiga() { // llamar método que invoca a la lucha en el sistema
		/*
		 * Seleccionar personaje Seleccionar bando Seleccionar Liga bandoRestando
		 * !Bandos.elegido Seleccionar Caracteristica a enfrentar llamarmetodo(Unidad
		 * Competidor Unidad1, Unidad Competidor Unidad2, Caracteristica)
		 */
	}

	private static void subOpcionLigaVsLiga() {

	}

//*************************************************************************************************************************************************************************

//****************************************************************************Generar Reporte****************************************************************************/

	private void opcionGenerarReporte(Scanner scanner) throws FileNotFoundException {
		boolean continuar = true;
		while (continuar) {
			System.out.println("Generar reporte:"
					+ "1. Personaje o Liga que vence a un Personaje seleccionado por caracteristica\n"
					+ "2. Listar Personajes por caracteristica\n"
					+ "3. Volver al menu anterior\n"
					+ "Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				subOpcionReportarVencedorAPersonaje();
				break;
			case 2:
				subOpcionOrdenarPersonajes(scanner);
				break;
			case 3:
				continuar = false;
				System.out.println("¡Volviendo al menu anterior...!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	private static void subOpcionReportarVencedorAPersonaje() {

	}

	private void subOpcionOrdenarPersonajes(Scanner scanner) throws FileNotFoundException {
		sistema.ordenarPersonajesPorCaracteristica(scanner);
	}
}

//*************************************************************************************************************************************************************************

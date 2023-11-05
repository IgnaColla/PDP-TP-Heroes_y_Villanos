package edu.unlam.paradigmas.sistema.Acciones;

import java.util.Scanner;
import edu.unlam.paradigmas.sistema.Acciones.AdministrarPersonajes.AdministrarPersonajes;
import edu.unlam.paradigmas.sistema.Acciones.RealizarCombate.RealizarCombate;
import hyv.Personaje;
import edu.unlam.paradigmas.sistema.Acciones.AdministrarLigas.AdministrarLigas;
import edu.unlam.paradigmas.sistema.Acciones.GenerarReporte.*;;

public class Acciones {
	public static void administrarPersonajes(){
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Administracion de personajes:");
			System.out.println("1. Cargar desde archivo");
			System.out.println("2. Crear personaje");
			System.out.println("3. Listar");
			System.out.println("4. Guardar en archivo personajes");
			System.out.println("5. Volver al menu principal");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					AdministrarPersonajes.cargarDesdeArchivo();
					break;
				case 2:
					AdministrarPersonajes.crearPersonaje();
					break;
				case 3:
					AdministrarPersonajes.ListarPersonajes();
					break;
				case 4:
					AdministrarPersonajes.guardarEnArchivoPersonajes();
					break;
				case 5:
					continuar = false;
					System.out.println("¡Volviendo al menu principal...!");
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}
	
	public static void administrarLigas(){
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Administracion de ligas:");
			System.out.println("1. Cargar desde archivo");
			System.out.println("2. Crear liga");
			System.out.println("3. Listar ligas");
			System.out.println("4. Guardar en archivo ligas");
			System.out.println("5. Volver al menu anterior");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					AdministrarLigas.cargarDesdeArchivo();
					break;
				case 2:
					AdministrarLigas.crearPersonaje();
					break;
				case 3:
					AdministrarLigas.ListarPersonajes();
					break;
				case 4:
					AdministrarLigas.guardarEnArchivoPersonajes();
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
	
	public static void realizarCombate(){
        Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Realizar Combate:");
			System.out.println("1. Personaje vs Liga");
			System.out.println("2. Liga vs Liga");
			System.out.println("3. Volver al menu anterior");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
                //Logica de Personaje vs Personaje
					RealizarCombate.PersonajeVsLiga();
					break;
				case 2:
                //logica de Liga vs Liga
					RealizarCombate.LigaVsLiga();
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

	public static void generarReporte(){
        Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Generar reporte:");
			System.out.println("1. Personaje vs Liga");
			System.out.println("2. Liga vs Liga");
			System.out.println("3. Volver al menu anterior");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
                    GenerarReporte.VencedorAPersonaje();
					break;
				case 2:
					GenerarReporte.PersonajesOrdenados();
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


}

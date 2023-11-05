package edu.unlam.paradigmas.sistema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.unlam.paradigmas.sistema.Acciones.Acciones;;

public class Menu {

	public  void menuPrincipal(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		List<UnidadCompetidor> listaUnidades = new ArrayList<UnidadCompetidor>();
		
		while (continuar) {
			System.out.println("Menú Principal:");
			System.out.println("1. Administrar de Personajes");
			System.out.println("2. Administrar de Ligas");
			System.out.println("3. Realizar Combates");
			System.out.println("4. Descargar reportes");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					//Lógica para la administración de personajes (carga, creación, listado, guardar en archivo).
					Acciones.administrarPersonajes(); //Esto hay que cambiar enfoque para no violar encapsulamiento.
					break;
				case 2:
					//Lógica para la administración de ligas (carga, creación, listado, guardar en archivo).
					Acciones.administrarLigas();
					break;
				case 3:
					//Logica para la realización de combates (personaje contra liga, liga contra liga).
					Acciones.realizarCombate();
					break;
				case 4:
					//Lógica para generar reportes.
					Acciones.generarReporte();
					break;
				case 5:
					continuar = false;
					System.out.println("¡Gracias por jugar!");
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

	public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menuPrincipal(args);
    }
}


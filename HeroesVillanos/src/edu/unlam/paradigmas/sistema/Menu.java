package edu.unlam.paradigmas.sistema;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Menu {
	
	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();
	

	public void menuPrincipal() throws FileNotFoundException, CaracteristicaExcepcion, IOException{
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		
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
					administrarPersonajes();
					break;
				case 2:
					//Lógica para la administración de ligas (carga, creación, listado, guardar en archivo).
					administrarLigas();
					break;
				case 3:
					//Logica para la realización de combates (personaje contra liga, liga contra liga).
					realizarCombate();
					break;
				case 4:
					//Lógica para generar reportes.
					generarReporte();
					break;
				case 5:
					continuar = false;
					System.out.println("¡Gracias por jugar!");
					break;
				default:
					System.out.println("Opcion no valida. Por favor, seleccione una opción valida.");
			}
		}
	}

//****************************************************************************Administrar Personajes***********************************************************************/


	
private void administrarPersonajes() throws CaracteristicaExcepcion, IOException{
	Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Administracion de personajes:");
			System.out.println("1. Cargar desde archivo");
			System.out.println("2. Crear personaje");
			System.out.println("3. Listar");
			System.out.println("4. Guardar en archivo personajes");
			System.out.println("5. Volver al menu principal");
			System.out.print("Seleccione una opcion: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					opcionCargarArchivoPersonaje();
					break;
				case 2:
					opcionCrearPersonaje();
					break;
				case 3:
					opcionListarPersonajes();
					break;
				case 4:
					opcionGuardarArchivoPersonajes();
					break;
				case 5:
					continuar = false;
					System.out.println("¡Volviendo al menu principal...!");
					break;
				default:
					System.out.println("Opcion no valida. Por favor, seleccione una opción valida.");
			}
		}
}

public void opcionCargarArchivoPersonaje()throws FileNotFoundException{
	sistema.cargarArchivoPersonaje();
}

public void opcionCrearPersonaje() throws CaracteristicaExcepcion{
	sistema.crearPersonaje();
}

public void opcionListarPersonajes(){
	sistema.listarCompetidores();
}

public void opcionGuardarArchivoPersonajes()throws IOException{
	sistema.guardarArchivoPersonaje();
}



//****************************************************************************Administrar Ligas***************************************************************************/


private void administrarLigas() throws FileNotFoundException{
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
					cargarLigaDesdeArchivo();
					break;
				case 2:
					crearLiga();
					break;
				case 3:
					ListarLigas();
					break;
				case 4:
					guardarEnArchivoLigas();
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

public static void cargarLigaDesdeArchivo() throws FileNotFoundException{
	/*ArchivoLigas ligasFile = new ArchivoLigas("ligas");
	Set<String> ligas = ligasFile.leer();
	
	//separar liga de heroes y de villanos
	
	System.out.println("\nLas ligas se han cargado correctamente!\n");*/
}

public static void crearLiga(){

}

public static void ListarLigas(){
}

public static void guardarEnArchivoLigas(){

}
//*************************************************************************************************************************************************************************




//****************************************************************************Realizar Combate*****************************************************************************/
private void realizarCombate(){
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
					personajeVsLiga();
					break;
				case 2:
                //logica de Liga vs Liga
					LigaVsLiga();
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

public static void personajeVsLiga(){
	/*
	 * Seleccionar personaje
	 * Seleccionar bando
	 * Seleccionar Liga
	 * bandoRestando !Bandos.elegido
	 * Seleccionar Caracteristica a enfrentar
	 * llamarmetodo(Unidad Competidor Unidad1, Unidad Competidor Unidad2, Caracteristica)
	 * */
}

public static void LigaVsLiga(){

}

//*************************************************************************************************************************************************************************




//****************************************************************************Generar Reporte****************************************************************************/

private void generarReporte(){
	Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Generar reporte:");
			System.out.println("1. Personaje o Liga que vence a un Personaje seleccionado por caracteristica");
			System.out.println("2. Listar Personajes por caracteristica");
			System.out.println("3. Volver al menu anterior");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
                    VencedorAPersonaje();
					break;
				case 2:
					PersonajesOrdenados();
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

public static void VencedorAPersonaje(){
        
}

public static void PersonajesOrdenados(){

}
}

//*************************************************************************************************************************************************************************


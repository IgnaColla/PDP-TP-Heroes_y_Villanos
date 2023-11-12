package edu.unlam.paradigmas.sistema;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Menu {
	
	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();
	

	public void menuPrincipal() throws FileNotFoundException, CaracteristicaExcepcion, IOException{
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		
		while (continuar) {
			
			System.out.println("\n[Menu Principal]\n"
					+ "1. Administrar Personajes\n"
					+ "2. Administrar Ligas\n"
					+ "3. Realizar combates\n"
					+ "4. Descargar reportes\n"
					+ "5. Salir\n"
					+ "+----- Seleccione una opcion -----+\n");

			int opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					//Lógica para la administración de personajes (carga, creación, listado, guardar en archivo).
					opcionAdministrarPersonajes(scanner);
					break;
				case 2:
					//Lógica para la administración de ligas (carga, creación, listado, guardar en archivo).
					opcionAdministrarLigas();
					break;
				case 3:
					//Logica para la realización de combates (personaje contra liga, liga contra liga).
					opcionRealizarCombate();
					break;
				case 4:
					//Lógica para generar reportes.
					opcionGenerarReporte();
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


	
private void opcionAdministrarPersonajes(Scanner scanner) throws CaracteristicaExcepcion, IOException{
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

private void subOpcionCargarArchivoPersonaje()throws FileNotFoundException{
	sistema.cargarArchivoPersonaje();
}

private void subOpcionCrearPersonaje(Scanner scanner) throws CaracteristicaExcepcion{
	sistema.crearPersonaje(scanner);
}

private void subOpcionListarPersonajes(){
	sistema.listarPersonajes();
}

private void subOpcionGuardarArchivoPersonajes()throws IOException{
	sistema.guardarArchivoPersonaje();
}



//****************************************************************************Administrar Ligas***************************************************************************/


private void opcionAdministrarLigas() throws CaracteristicaExcepcion, IOException{
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
			
//			switch (opcion) {
//				case 1:
//					subOpcionCargarLigaDesdeArchivo();
//					break;
//				case 2:
//					subOpcionCrearLiga(scanner);
//					break;
//				case 3:
//					subOcionListarLigas();
//					break;
//				case 4:
//					subOpcionGuardarEnArchivoLigas();
//					break;
//				case 5:
//					continuar = false;
//					System.out.println("¡Volviendo al menu anterior...!");
//					break;
//				default:
//					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
//			}
		}
		
		scanner.close();
}

//private void subOpcionCargarLigaDesdeArchivo() throws FileNotFoundException, CaracteristicaExcepcion{
//	
//	sistema.cargarArchivoLigas();
//	
//	/*ArchivoLigas ligasFile = new ArchivoLigas("ligas");
//	Set<String> ligas = ligasFile.leer();
//	
//	//separar liga de heroes y de villanos
//	
//	System.out.println("\nLas ligas se han cargado correctamente!\n");*/
//}

//private void subOpcionCrearLiga(Scanner scanner) throws CaracteristicaExcepcion{
//	sistema.crearLiga(scanner);
//}
//
//private void subOcionListarLigas(){
//	sistema.listarLigas();
//}

private void subOpcionGuardarEnArchivoLigas() throws IOException{
	sistema.guardarArchivoLigas();
}
//*************************************************************************************************************************************************************************


//****************************************************************************Realizar Combate*****************************************************************************/
private void opcionRealizarCombate(){
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
					subOpcionPersonajeVsLiga();
					break;
				case 2:
                //logica de Liga vs Liga
					subOpcionLigaVsLiga();
					break;
				case 3:
					continuar = false;
					System.out.println("¡Volviendo al menu anterior...!");
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
		
		scanner.close();
}

private static void subOpcionPersonajeVsLiga(){ //llamar método que invoca a la lucha en el sistema 
	/*
	 * Seleccionar personaje
	 * Seleccionar bando
	 * Seleccionar Liga
	 * bandoRestando !Bandos.elegido
	 * Seleccionar Caracteristica a enfrentar
	 * llamarmetodo(Unidad Competidor Unidad1, Unidad Competidor Unidad2, Caracteristica)
	 * */
}

private static void subOpcionLigaVsLiga(){

}

//*************************************************************************************************************************************************************************




//****************************************************************************Generar Reporte****************************************************************************/

private void opcionGenerarReporte(){
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
		
		scanner.close();
}

private static void VencedorAPersonaje(){
        
}

private static void PersonajesOrdenados(){

}
}

//*************************************************************************************************************************************************************************


package edu.unlam.paradigmas.sistema;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//
import edu.unlam.paradigmas.archivos.*;
import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class Menu {
	
	private Set<Competidor> competidoresHeroes = new HashSet<>();
	private Set<Liga> ligasHeroes = new HashSet<>();
	private Set<Competidor> competidoresVillanos = new HashSet<>();
	private Set<Liga> ligasVillanos = new HashSet<>();

	public void menuPrincipal(String[] args) throws FileNotFoundException, CaracteristicaExcepcion{
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
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		}
	}

//****************************************************************************Administrar Personajes***********************************************************************/

private Bandos seleccionarBando() {
	Scanner scannerBando = new Scanner(System.in);
	Bandos bando = null;
	boolean continuar = true;
	while (continuar) {
		System.out.println("Bandos:");
		System.out.println("1. Heroe");
		System.out.println("2. Villano");
		System.out.print("Seleccione una opción: ");

		int opcion = scannerBando.nextInt();

		switch (opcion) {
			case 1:
				bando = Bandos.Héroe;
				continuar = false;
				break;
			case 2:
				bando = Bandos.Villano;
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
		}
	}
	//scannerBando.close();
	return bando;
}
	
private void administrarPersonajes() throws FileNotFoundException, CaracteristicaExcepcion{
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
					cargarDesdeArchivo();
					break;
				case 2:
					crearPersonaje();
					break;
				case 3:
					ListarPersonajes();
					break;
				case 4:
					guardarEnArchivoPersonajes();
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

public void cargarDesdeArchivo()throws FileNotFoundException{
	ArchivoPersonajes personajesFile = new ArchivoPersonajes("personajes");
	Set<Competidor> personajes = personajesFile.leer();
	
	for(Competidor c : personajes) {
		if (c.getBando().equals("Villano")) {
			competidoresVillanos.add(c);
		}else {
			competidoresHeroes.add(c);
		}
	}
	
	System.out.println("\nLos personajes se han cargado correctamente!\n");
}

public void crearPersonaje() throws CaracteristicaExcepcion{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Seleccione bando: ");
	Bandos bando = seleccionarBando();
	System.out.println("Ingrese el nombre real del personaje: ");
	String nombreReal = scanner.nextLine();
	System.out.println("Ingrese el nombre del personaje: ");
	String nombrePersonaje = scanner.nextLine();
	System.out.println("Ingrese Velocidad: ");
	int velocidad = scanner.nextInt();
	System.out.println("Ingrese Fuerza: ");
	int fuerza = scanner.nextInt();
	System.out.println("Ingrese Destreza: ");
	int destreza = scanner.nextInt();
	System.out.println("Ingrese Resistencia: ");
	int resistencia = scanner.nextInt();
	
	System.out.println("Esta a punto de crear un nuevo personaje. ¿Desea continuar?\n1.Si\n2.No");
	int respuesta = scanner.nextInt();
	
	if(respuesta == 1) {
		if(bando == Bandos.Héroe) {
			competidoresHeroes.add(new Competidor(nombreReal, nombrePersonaje, bando, new Caracteristica(velocidad, fuerza, resistencia, destreza)));
		}else {
			competidoresVillanos.add(new Competidor(nombreReal, nombrePersonaje, bando, new Caracteristica(velocidad, fuerza, resistencia, destreza)));
		}
		System.out.println("\nPersonaje creado correctamente!");
	}else {
		System.out.println("\nSe cancela la creación de personaje!");
	}
	
	//scanner.close();
}

public void ListarPersonajes(){
	System.out.println("Listado de Heroes");
	System.out.println(competidoresHeroes);
	System.out.println("*****************************");
	System.out.println("Listado de Villanos");
	System.out.println(competidoresVillanos);
	}

public static void guardarEnArchivoPersonajes(){

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
	ArchivoLigas ligasFile = new ArchivoLigas("ligas");
	Set<String> ligas = ligasFile.leer();
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
					PersonajeVsLiga();
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

public static void PersonajeVsLiga(){
        
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
			System.out.println("1. Personaje vs Liga");
			System.out.println("2. Liga vs Liga");
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


//*************************************************************************************************************************************************************************






//*****************************************************************************MAIN*****************************************************************************************
public static void main(String[] args) throws FileNotFoundException, CaracteristicaExcepcion{
	Menu menu = new Menu();
	menu.menuPrincipal(args);
	
}
	
}
//*************************************************************************************************************************************************************************


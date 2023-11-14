package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.excepciones.SistemaExcepcion;

public class App {
	public static void main(String[] args)
			throws FileNotFoundException, CaracteristicaExcepcion, IOException, SistemaExcepcion {
		Menu menu = new Menu();
		menu.menuPrincipal();
	}
}

package edu.unlam.paradigmas.sistema;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;

public class App {
	public static void main(String[] args) throws FileNotFoundException, CaracteristicaExcepcion, IOException{
		Menu menu = new Menu();
		menu.menuPrincipal();
		
	}
}

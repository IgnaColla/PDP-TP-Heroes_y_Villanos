package edu.unlam.paradigmas.excepciones;

public class SistemaExcepcion extends Exception {

	private static final long serialVersionUID = 246664365169487603L;
	
	public SistemaExcepcion(String mensaje) {
		super(mensaje);
	}
}

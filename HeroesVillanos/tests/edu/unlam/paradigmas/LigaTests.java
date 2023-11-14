package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class LigaTests {

	private Liga ligaUno;
	private Caracteristica caracteristicasLigaUno;
	private Liga LigaDos;
	private Caracteristica caracteristicasLigaDos;
	private Liga LigaTres;
	private Caracteristica caracteristicasLigaTres;
	private Liga LigaCuatro;
	private Caracteristica caracteristicasLigaCuatro;
	private Liga LigaCinco;
	private Caracteristica caracteristicasLigaCinco;
	private Liga LigaSeis;
	private Caracteristica caracteristicasLigaSeis;

	/*
	@Before
	public void setUp() throws Exception {

		Caracteristica caracteristicasPersonajeUno = new Caracteristica(10, 20, 30, 40);
		Competidor personajeUno = new Competidor("Nombre real test p1", "Nombre personaje test p1", Bandos.Heroe,
				caracteristicasPersonajeUno);

		Caracteristica caracteristicasPersonajeDos = new Caracteristica(20, 30, 40, 50);
		Competidor personajeDos = new Competidor("Nombre real test p2", "Nombre personaje test p2", Bandos.Villano,
				caracteristicasPersonajeDos);

		List<UnidadCompetidor> unidadesCompetidoras = new ArrayList<UnidadCompetidor>();
		unidadesCompetidoras.add(personajeUno);
		unidadesCompetidoras.add(personajeDos);
		unidadesCompetidoras.add(LigaDos);
		
		//hay que agregar el método que te hace la suma de las caracteristicas

		ligaUno = new Liga("Nombre liga uno", Bandos.Heroe, caracteristicasLigaUno, unidadesCompetidoras);
		//ligaDos = new Liga("Nombre liga dos", Bandos.Villano, caracteristicasLigaUno, unidadesCompetidoras);


	}
	
	@Test
	public void quePermitaAgregarPersonajeALiga() {
		
	}
	
	@Test
	public void quePermitaAgregarLigaALiga() {
		
	}
	
	@Test
	public void quePermitaAgregarUnidadesCompetidoresALiga() {
		
	}
	
	@Test
	public void quePermitaAumentarPoderLiga() {
		
	}
	
	@Test
	public void queRecalculePoderLiga() { //esto no está como una funcionalidad en el sistema, pero si se saca uno de la lista, qué pasa?
		
	}
	
	@Test
	public void queFormatoLigaToStringSeRespete() {
		
		LigaTres.setBando(Bandos.Heroe);  // Reemplaza con el bando que desees probar
		//LigaTres.agregarCompetidor(personajeUno);
        String primerResultadoEsperado = "Liga 1: Heroe, 10, 20, 30, 40";  // Reemplaza con el resultado esperado
        assertEquals(primerResultadoEsperado, LigaTres.toString());
        //LigaTres.agregarCompetidor(personajeUno);
        String segundoResultadoEsperado = "Liga 2: Villano, 20, 30, 40, 50";  // Reemplaza con el resultado esperado
        assertEquals(segundoResultadoEsperado, LigaTres.toString());
	}
	
	@Test
	public void queCuenteLaCantidadDeUnidadesCompetidorasIncluidas() {
		
	}
	
	@Test
	public void queCalculePoderUnidadesCompetidoras() {
		
	}
*/
}

package edu.unlam.paradigmas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.SistemaHeroesVillanos;

public class SistemaHeroesVillanosTests {

	private Map<Competidor, Integer> competidores = new HashMap<Competidor, Integer>();
	private Map<Integer, Liga> ligas = new HashMap<>();
	private boolean archivoPersonajeExiste = false;
	private SistemaHeroesVillanos sistema;
	
	@Before
	public void setUp() throws Exception {		
		sistema.cargarArchivoLigas();
	}
	
	@Test
	public void queCargueElArchivoPersonajeCuandoSeQuiereTrabajarConPersonajes() throws FileNotFoundException {
		sistema.cargarArchivoPersonaje();
	}
	
	@Test
	public void queCreePersonajes() {
		
	}
	
	@Test
	public void queListePersonajesCorrectamente() {

	}
	
	@Test
	public void queGuardeArchivoPersonajesCorrectamente() {

	}
	
	
	@Test
	public void queCargueElArchivoLigasCuandoSeQuiereTrabajarConUnidadesCompetidoras() {

	}
	
	@Test
	public void queCreeLigas() {

	}
	
	@Test
	public void queListeLigasCorrectamente() {

	}
	
	@Test
	public void queGuardeArchivoLigasCorrectamente() {

	}
	
	@Test
	public void queEnfrenteLigasVsLigasPorCaracteristica() {

	}
	
	@Test
	public void queEnfrenteLigasVsPersonajesPorCaracteristica() {

	}
	
	@Test
	public void queDetermineQuienEsElGanadorPorCaracteristica() {

	}
	
	@Test
	public void queDetermineQuienEsElPerdedorPorCaracteristica() {

	}
	
	@Test
	public void queDetermineQuienEmpataPorCaracteristica() {

	}
	
	@Test
	public void queOrdenePersonajesPorCaracteristicas() {

	}
	
	@Test
	public void queDetermineSiEsDeMismoBando() {

	}
	
	@Test
	public void queDetermineSiNoEsDeMismoBando() {

	}
	
	
}

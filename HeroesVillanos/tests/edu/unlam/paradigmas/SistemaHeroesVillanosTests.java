/*
 * Para ejecutar los tests se debe cambiar la visibilidad del metodo enfrentar y calcularCaracteristicas
 * Aun asi seguramente el codigo pedira otros cambios de visiblidad 
 * */

package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.archivos.ArchivoLigas;
import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.SistemaHeroesVillanos;

public class SistemaHeroesVillanosTests {

	Competidor v1, v2, v3, v4, v5, v6, h1, h2, h3, h4, h5, h6;
	Liga ligaHeroes, ligaHeroes2, ligaHeroes3, ligaVillanos, ligaVillanos2, ligaVillanos3;
	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();
	ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
	ArchivoPersonajes archivoPersonajesNoExiste = new ArchivoPersonajes("personajess");
	ArchivoLigas archivoLigas = new ArchivoLigas("ligas");
	ArchivoLigas archivoLigasNoExiste = new ArchivoLigas("ligass");
	Map<Competidor, Integer> competidores = new HashMap<>();
	Map<Integer, Liga> ligas = new HashMap<>();

	@Before
	public void setUp() throws Exception {

		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe, new Caracteristica(200, 150, 180, 250));
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe, new Caracteristica(200, 200, 200, 200));
		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h4 = new Competidor("Batman", "Batman", Bandos.Heroe, new Caracteristica(150, 200, 250, 200));
		h5 = new Competidor("Superman", "Superman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h6 = new Competidor("Federico", "Federico", Bandos.Heroe, new Caracteristica(250, 250, 250, 250));

		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano, new Caracteristica(150, 250, 180, 330));
		v2 = new Competidor("Loki", "Loki", Bandos.Villano, new Caracteristica(150, 150, 150, 200));
		v3 = new Competidor("Joker", "Joker", Bandos.Villano, new Caracteristica(100, 200, 250, 200));
		v4 = new Competidor("Watchmen", "Watchmen", Bandos.Villano, new Caracteristica(100, 150, 130, 200));
		v5 = new Competidor("Magneto", "Magneto", Bandos.Villano, new Caracteristica(200, 175, 190, 225));
		v6 = new Competidor("Lucas", "Lucas", Bandos.Villano, new Caracteristica(250, 250, 250, 250));

		ligaHeroes = new Liga();
		ligaHeroes2 = new Liga();
		ligaVillanos = new Liga();
		ligaVillanos2 = new Liga();

		// agregarALiga
		ligaHeroes.agregarALiga(h1);
		ligaHeroes.agregarALiga(h2);

		ligaVillanos.agregarALiga(v1);
		ligaVillanos.agregarALiga(v2);

		ligaHeroes2.agregarALiga(h5);
		ligaHeroes2.agregarALiga(h6);

		ligaVillanos2.agregarALiga(v3);
		ligaVillanos2.agregarALiga(v6);

		competidores.put(h1, 1);
		competidores.put(h2, 2);
		competidores.put(h3, 3);
		competidores.put(h4, 4);
		competidores.put(h5, 5);
		competidores.put(h6, 6);
		competidores.put(v1, 7);
		competidores.put(v2, 8);
		competidores.put(v3, 9);
		competidores.put(v4, 10);
		competidores.put(v5, 11);
		competidores.put(v6, 12);
		
		ligas.put(1, ligaHeroes);
		ligas.put(2, ligaHeroes2);
		ligas.put(3, ligaVillanos);
		ligas.put(4, ligaVillanos2);

	}

	@Test
	public void heroeGanaVillanoPorVelocidad() {
		assertEquals(sistema.enfrentar(h1, v1, TipoCaracteristica.VELOCIDAD), 1);
	}

	@Test
	public void heroeGanaVillanoPorFuerza() {
		assertEquals(sistema.enfrentar(h2, v2, TipoCaracteristica.FUERZA), 1);
	}

	@Test
	public void heroeGanaVillanoPorResistencia() {
		assertEquals(sistema.enfrentar(h3, v1, TipoCaracteristica.RESISTENCIA), 1);
	}

	@Test
	public void heroeGanaVillanoPorDestreza() {
		assertEquals(sistema.enfrentar(h1, v2, TipoCaracteristica.DESTREZA), 1);
	}

	@Test
	public void heroeEmpataConVillano() {
		assertEquals(sistema.enfrentar(h5, v3, TipoCaracteristica.VELOCIDAD), 0);
	}

	@Test
	public void heroeGanaVillanoYVuelvaAVelocidadRec() {
		assertEquals(sistema.enfrentar(h4, v3, TipoCaracteristica.DESTREZA), 1);
	}

	@Test
	public void ligaHeroeGanaVillanoPorVelocidad() {
		assertEquals(sistema.enfrentar(ligaHeroes, v4, TipoCaracteristica.VELOCIDAD), 1);
	}

	@Test
	public void ligaHeroeGanaVillanoPorFuerza() {
		assertEquals(sistema.enfrentar(ligaHeroes, v4, TipoCaracteristica.FUERZA), 1);
	}

	@Test
	public void ligaHeroeGanaVillanoPorResistencia() {
		assertEquals(sistema.enfrentar(ligaHeroes, v4, TipoCaracteristica.RESISTENCIA), 1);
	}

	@Test
	public void ligaHeroeGanaVillanoPorDestreza() {
		assertEquals(sistema.enfrentar(ligaHeroes, v4, TipoCaracteristica.DESTREZA), 1);
	}

	@Test
	public void ligaHeroeEmpataVillano() {
		assertEquals(sistema.enfrentar(ligaHeroes, v5, TipoCaracteristica.VELOCIDAD), 0);
	}

	@Test
	public void ligaHeroeGanaLigaVillanoPorVelocidad() {
		assertEquals(sistema.enfrentar(ligaHeroes, ligaVillanos, TipoCaracteristica.VELOCIDAD), 1);
	}

	@Test
	public void ligaVillanoGanaLigaHeroePorFuerza() {
		assertEquals(sistema.enfrentar(ligaHeroes, ligaVillanos, TipoCaracteristica.FUERZA), -1);
	}

	@Test
	public void ligaHeroeGanaLigaVillanoPorResistencia() {
		assertEquals(sistema.enfrentar(ligaHeroes, ligaVillanos, TipoCaracteristica.RESISTENCIA), 1);
	}

	@Test
	public void ligaVillanoGanaLigaHeroePorDestreza() {
		assertEquals(sistema.enfrentar(ligaHeroes, ligaVillanos, TipoCaracteristica.DESTREZA), -1);
	}

	@Test
	public void ligaHeroeEmpataLigaVillano() {
		assertEquals(sistema.enfrentar(ligaHeroes2, ligaVillanos2, TipoCaracteristica.DESTREZA), 0);
	}

	@Test
	public void queExisteArchivoIn() {
		File file = new File(archivoPersonajes.getPathIn());

		assertTrue(file.exists());
	}

	@Test
	public void queNoExisteArchivoOutPersonajes() {
		File file = new File(archivoPersonajesNoExiste.getPathOut());

		assertTrue(!file.exists());
	}

	@Test
	public void queGuardaCorrectamenteArchivoOutPersonajes() throws IOException {
		archivoPersonajes.escribir(competidores);
		File file = new File(archivoPersonajes.getPathOut());

		assertTrue(file.exists());
	}
	
	@Test
	public void queNoExisteArchivoOutLigas() {
		File file = new File(archivoLigasNoExiste.getPathOut());

		assertTrue(!file.exists());
	}
	
	@Test 
	public void queGuardaCorrectamenteArchivoOutLigas() throws IOException{
		archivoLigas.escribir(ligas);
		File file = new File(archivoLigas.getPathOut());

		assertTrue(file.exists());
	}

}

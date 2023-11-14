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

public class LigaTests {

	Competidor h1;
	Competidor h2;
	Competidor v1;
	Competidor v2;
	Competidor h3;
	Competidor h4;
	Competidor h5;
	Liga ligaHeroes;
	Liga ligaHeroes2;
	Liga ligaVillanos;

	@Before
	public void setUp() throws Exception {
		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano, new Caracteristica(150, 250, 180, 330));
		// Héroe, Natasha Romanoff, Black Widow, 200, 150, 180, 200
		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe, new Caracteristica(200, 150, 180, 200));
		// Héroe, T'Challa, Black Panther, 200, 200, 200, 200
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe, new Caracteristica(200, 200, 200, 200));
		// Villano, Loki, 150, 150, 150, 200
		v2 = new Competidor("Loki", "Loki", Bandos.Villano, new Caracteristica(150, 150, 150, 200));
		// Héroe, Steve Rogers, Captain America, 100, 200, 250, 200
		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h4 = new Competidor("Batman", "Batman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h5 = new Competidor("Superman", "Superman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));

		ligaHeroes = new Liga();
		ligaHeroes2 = new Liga();
		ligaVillanos = new Liga();

		ligaHeroes.agregarALiga(h1);
		ligaHeroes2.agregarALiga(h2);
		ligaVillanos.agregarALiga(v1);
		ligaVillanos.agregarALiga(v2);
		ligaHeroes.recalcularCaracteristicas();
		ligaVillanos.recalcularCaracteristicas();
	}

	@Test
	public void quePermitaAgregarLigaALiga() {
		ligaHeroes2.agregarALiga(ligaHeroes);

		String personajes = ligaHeroes2.getNombrePersonaje();
		assertEquals(personajes.contains("Black Widow, Black Panther"), true);
	}

	@Test
	public void quePermitaAgregarUnidadesCompetidoresALiga() {

	}

	@Test
	public void quePermitaAumentarPoderLiga() {

	}

	@Test
	public void queRecalculeCaracteristicasDeLiga() { 
		List<Integer> caracteristicas = new ArrayList<>();
		List<Integer> carEsperadas = new ArrayList<>();
		carEsperadas.add(400);
		carEsperadas.add(350);
		carEsperadas.add(380);
		carEsperadas.add(400);

		ligaHeroes.recalcularCaracteristicas();
		/*
		 * }
		 * 
		 * 1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe, new
		 * Caracteristica(200,150,180,200)); //Héroe, T'Challa, Black Panther, 200, 200,
		 * 200, 200 h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe, new
		 * Caracteristica(200,200,200,200));
		 */
		caracteristicas = ligaHeroes.getCaracteristicas();
		assertEquals(carEsperadas, caracteristicas);
	}

	@Test
	public void quePermitaContar() {
		assertEquals(ligaVillanos.contarIntegrantes(), 2);
	}

	@Test
	public void queCalculePoderUnidadesCompetidoras() {

	}

}

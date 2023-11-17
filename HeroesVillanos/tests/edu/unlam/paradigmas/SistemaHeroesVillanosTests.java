/*
 * Para ejecutar los tests se debe cambiar la visibilidad del metodo enfrentar y calcularCaracteristicas
 * Aun asi seguramente el codigo pedira otros cambios de visiblidad 
 * */

package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.SistemaHeroesVillanos;

public class SistemaHeroesVillanosTests {
	private Competidor v1, v2, v3, v4, v5, h1, h2, h3, h4, h5;
	private Liga ligaHeroes, ligaHeroes2, ligaHeroes3, ligaVillanos, ligaVillanos2, ligaVillanos3;
	private SistemaHeroesVillanos sistema;

	@Before
	public void setUp() throws Exception {
		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano, new Caracteristica(150, 250, 180, 330));
		// Héroe, Natasha Romanoff, Black Widow, 200, 150, 180, 200
		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe, new Caracteristica(200, 150, 180, 250));
		// Héroe, T'Challa, Black Panther, 200, 200, 200, 200
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe, new Caracteristica(200, 200, 200, 200));
		// Villano, Loki, 150, 150, 150, 200
		v2 = new Competidor("Loki", "Loki", Bandos.Villano, new Caracteristica(150, 150, 150, 200));
		v3 = new Competidor("Joker", "Joker", Bandos.Villano, new Caracteristica(100, 200, 250, 200));
		v4 = new Competidor("Watchmen", "Watchmen", Bandos.Villano, new Caracteristica(100, 150, 130, 200));
		v5 = new Competidor("Magneto", "Magneto", Bandos.Villano, new Caracteristica(200, 175, 190, 225));
		// Héroe, Steve Rogers, Captain America, 100, 200, 250, 200
		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h4 = new Competidor("Batman", "Batman", Bandos.Heroe, new Caracteristica(150, 200, 250, 200));
		h5 = new Competidor("Superman", "Superman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));

		ligaHeroes = new Liga();
		ligaHeroes2 = new Liga();
		ligaVillanos = new Liga();

		// agregarALiga
		ligaHeroes.agregarALiga(h1);
		ligaHeroes.agregarALiga(h2);

		ligaVillanos.agregarALiga(v1);
		ligaVillanos.agregarALiga(v2);

	}

	/*
	 * @Test public void HeroeGanaVillanoPorVelocidad() { //String esperado =
	 * "Ganador: Black Widow - Caracteristica: VELOCIDAD Diferencia: 50 puntos.";
	 * //System.out.println(esperado);
	 * //System.out.println(SistemaHeroesVillanos.enfrentar(h1, v1,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")));
	 * 
	 * System.out.println(sistema.enfrentar(v1, h1,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD"))); assertEquals(1,
	 * sistema.enfrentar(h1, v1,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD"))); }
	 * 
	 * @Test public void heroeGanaVillanoPorFuerza() { String esperado =
	 * "Ganador: Black Panther - Caracteristica: FUERZA Diferencia: 50 puntos.";
	 * //System.out.println(esperado);
	 * //System.out.println(SistemaHeroesVillanos.enfrentar(h2, v2,
	 * Caracteristica.TipoCaracteristica.valueOf("FUERZA"))); assertEquals(esperado,
	 * SistemaHeroesVillanos.enfrentar(h2, v2,
	 * Caracteristica.TipoCaracteristica.valueOf("FUERZA"))); }
	 * 
	 * 
	 * @Test public void heroeGanaVillanoPorResistencia() { String esperado =
	 * "Ganador: Captain America - Caracteristica: RESISTENCIA Diferencia: 70 puntos."
	 * ; //System.out.println(esperado);
	 * //System.out.println(SistemaHeroesVillanos.enfrentar(h3, v1,
	 * Caracteristica.TipoCaracteristica.valueOf("RESISTENCIA")));
	 * assertEquals(esperado, SistemaHeroesVillanos.enfrentar(h3, v1,
	 * Caracteristica.TipoCaracteristica.valueOf("RESISTENCIA"))); }
	 * 
	 * 
	 * 
	 * @Test public void heroeGanaVillanoPorDestreza() { String esperado =
	 * "Ganador: Black Widow - Caracteristica: DESTREZA Diferencia: 50 puntos.";
	 * //System.out.println(esperado);
	 * //System.out.println(SistemaHeroesVillanos.enfrentar(h1, v2,
	 * Caracteristica.TipoCaracteristica.valueOf("DESTREZA")));
	 * assertEquals(esperado, SistemaHeroesVillanos.enfrentar(h1, v2,
	 * Caracteristica.TipoCaracteristica.valueOf("DESTREZA"))); }
	 * 
	 * 
	 * @Test public void heroeEmpataConVillano() { String esperado =
	 * "Se produjo un empate entre los 2 competidores";
	 * assertEquals(SistemaHeroesVillanos.enfrentar(h5, v3,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")), esperado); }
	 * 
	 * @Test public void heroeGanaVillanoYVuelvaAVelocidadRec() { String esperado =
	 * "Ganador: Batman - Caracteristica: VELOCIDAD Diferencia: 50 puntos.";
	 * assertEquals(SistemaHeroesVillanos.enfrentar(h4, v3,
	 * Caracteristica.TipoCaracteristica.valueOf("DESTREZA")), esperado); }
	 * 
	 * @Test public void ligaHeroeGanaVillanoPorVelocidad() { String esperado =
	 * "Ganador: Black Widow, Black Panther - Caracteristica: VELOCIDAD Diferencia: 100 puntos."
	 * ; //System.out.println(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")));
	 * assertEquals(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")), esperado); }
	 * 
	 * @Test public void ligaHeroeGanaVillanoPorFuerza() { String esperado =
	 * "Ganador: Black Widow, Black Panther - Caracteristica: FUERZA Diferencia: 25 puntos."
	 * ; //System.out.println(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("FUERZA")));
	 * assertEquals(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("FUERZA")), esperado); }
	 * 
	 * @Test public void ligaHeroeGanaVillanoPorResistencia() { String esperado =
	 * "Ganador: Black Widow, Black Panther - Caracteristica: RESISTENCIA Diferencia: 60 puntos."
	 * ; //System.out.println(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("RESISTENCIA")));
	 * assertEquals(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("RESISTENCIA")), esperado); }
	 * 
	 * @Test public void ligaHeroeGanaVillanoPorDestreza() { String esperado =
	 * "Ganador: Black Widow, Black Panther - Caracteristica: DESTREZA Diferencia: 25 puntos."
	 * ; //System.out.println(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("DESTREZA")));
	 * assertEquals(SistemaHeroesVillanos.enfrentar(ligaHeroes, v4,
	 * Caracteristica.TipoCaracteristica.valueOf("DESTREZA")), esperado); }
	 * 
	 * @Test public void ligaHeroeEmpataVillano() { String esperado =
	 * "Se produjo un empate entre los 2 competidores";
	 * System.out.println(SistemaHeroesVillanos.enfrentar(ligaHeroes, v5,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")));
	 * assertEquals(SistemaHeroesVillanos.enfrentar(ligaHeroes, v5,
	 * Caracteristica.TipoCaracteristica.valueOf("VELOCIDAD")), esperado); }
	 * 
	 * @Test public void ligaHeroeGanaLigaVillano() {
	 * 
	 * }
	 * 
	 * @Test public void ligaHeroeEmpataLigaVillano() {
	 * 
	 * }
	 * 
	 * @Test public void ligaHeroeLigaVillano() {
	 * 
	 * } /*
	 * 
	 * @Test public void queEnfrentePersonajeVsPersonajePorCaracteristica() { String
	 * esperado = "Ganador: Loki - Caracteristica: Velocidad Diferencia 30 puntos.";
	 * assertEquals(SistemaHeroesVillanos.enfrentar(h1, v1,
	 * Caracteristica.TipoCaracteristica.valueOf("fuerza")), esperado); }
	 * 
	 * @Test public void queEnfrenteLigasVsPersonajesPorCaracteristica() {
	 * 
	 * }
	 * 
	 * @Test public void
	 * queCargueElArchivoPersonajeCuandoSeQuiereTrabajarConPersonajes() throws
	 * FileNotFoundException { }
	 * 
	 * @Test public void queListePersonajesCorrectamente() {
	 * 
	 * }
	 * 
	 * @Test public void queGuardeArchivoPersonajesCorrectamente() {
	 * 
	 * }
	 * 
	 * @Test public void
	 * queCargueElArchivoLigasCuandoSeQuiereTrabajarConUnidadesCompetidoras() {
	 * 
	 * }
	 * 
	 * @Test public void queCreeLigas() {
	 * 
	 * }
	 * 
	 * @Test public void queListeLigasCorrectamente() {
	 * 
	 * }
	 * 
	 * @Test public void queGuardeArchivoLigasCorrectamente() {
	 * 
	 * }
	 * 
	 * 
	 * @Test public void queDetermineQuienEsElGanadorPorCaracteristica() {
	 * 
	 * }
	 * 
	 * @Test public void queDetermineQuienEsElPerdedorPorCaracteristica() {
	 * 
	 * }
	 * 
	 * @Test public void queDetermineQuienEmpataPorCaracteristica() {
	 * 
	 * }
	 * 
	 * @Test public void queOrdenePersonajesPorCaracteristicas() {
	 * 
	 * }
	 * 
	 * @Test public void queDetermineSiEsDeMismoBando() {
	 * 
	 * }
	 * 
	 * @Test public void queDetermineSiNoEsDeMismoBando() {
	 * 
	 * }
	 */

}

package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class LigaTests {
/*
Competidor v1;
//	Competidor h1;
//	Competidor h2;
//	Competidor v2;
//	Competidor h3;
//	Liga ligaVillanos;
//	Liga ligaHeroes;
//	Liga ligaConPersonaje;
//	Liga ligaDeLigas;
//	/*
//	@Before
//	public void setUp() throws CaracteristicaExcepcion {
//		Set<UnidadCompetidor> Heroes = new HashSet<UnidadCompetidor>();
//		Set<UnidadCompetidor> Villanos = new HashSet<UnidadCompetidor>();
//		// String nombreReal, String nombrePersonaje, Bandos bando, Caracteristica caracteristicas
//		//Villano,Ronan the Accuser,Ronan, 150, 250, 180, 330
//		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano,
//				new Caracteristica(150,250,180,330));
//		//Héroe, Natasha Romanoff, Black Widow, 200, 150, 180, 200
//		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe,
//				new Caracteristica(200,150,180,200));
//		//Héroe, T'Challa, Black Panther, 200, 200, 200, 200
//		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe,
//				new Caracteristica(200,200,200,200));
//		//Villano, Loki, 150, 150, 150, 200
//		v2 = new Competidor("Loki", "Loki", Bandos.Villano,
//				new Caracteristica(150,150,150,200));
//		//Héroe, Steve Rogers, Captain America, 100, 200, 250, 200
//		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe,
//				new Caracteristica(100,200,250,200));
//		
//		
//		
//		
//		ligaVillanos = new Liga(Bandos.Villano, new Caracteristica(0,0,0,0), v1, v2);
//		ligaHeroes = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), h1, h2);
//		
//		ligaConPersonaje = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), ligaHeroes, h3);
//		//suponiendo que se puede
//		ligaDeLigas = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), ligaVillanos, ligaHeroes);
//	}
//	@Test
//	public void TestAgregarCompetidorALiga() throws CaracteristicaExcepcion {
//		ligaVillanos.agregarCompetidorALiga(v2);
//		//contains o assert?
//		Assert.assertEquals(ligaVillanos.buscarUnidadCompetidor(v2), true);
//		
//	}
 */
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
		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano,
				new Caracteristica(150,250,180,330));
		//Héroe, Natasha Romanoff, Black Widow, 200, 150, 180, 200
		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe,
				new Caracteristica(200,150,180,200));
		//Héroe, T'Challa, Black Panther, 200, 200, 200, 200
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe,
				new Caracteristica(200,200,200,200));
		//Villano, Loki, 150, 150, 150, 200
		v2 = new Competidor("Loki", "Loki", Bandos.Villano,
				new Caracteristica(150,150,150,200));
		//Héroe, Steve Rogers, Captain America, 100, 200, 250, 200
		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe,
				new Caracteristica(100,200,250,200));
		h4 = new Competidor("Batman", "Batman", Bandos.Heroe,
				new Caracteristica(100,200,250,200));
		h5 = new Competidor("Superman", "Superman", Bandos.Heroe,
				new Caracteristica(100,200,250,200));

		ligaHeroes.agregarALiga(h1);
		ligaHeroes.agregarALiga(h2);
		ligaVillanos.agregarALiga(v1);
		ligaVillanos.agregarALiga(v2);
		ligaHeroes.recalcularCaracteristicas();
		ligaVillanos.recalcularCaracteristicas();
	}
	
	@Test
	public void quePermitaMostrarPersonajes() {
		String personajes = ligaHeroes.getNombrePersonaje();
		assertEquals(personajes.contains("Black Widow, Black Panther"), true);
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
	public void queRecalculeCaracteristicasDeLiga() { //esto no está como una funcionalidad en el sistema, pero si se saca uno de la lista, qué pasa?
		//recalcularCaracteristicas() protected List<Integer> getCaracteristicas() 
		List<Integer> caracteristicas = new ArrayList<>();
		List<Integer> carEsperadas = new ArrayList<>();
		carEsperadas.add(400);
		carEsperadas.add(350);
		carEsperadas.add(380);
		carEsperadas.add(400);
		
		ligaHeroes.recalcularCaracteristicas();
		/*}
		 * 
		 * 1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe,
				new Caracteristica(200,150,180,200));
		//Héroe, T'Challa, Black Panther, 200, 200, 200, 200
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe,
				new Caracteristica(200,200,200,200));
		 * */
		caracteristicas = ligaHeroes.getCaracteristicas();
		assertEquals(carEsperadas, caracteristicas);
	}
	/*
	@Test
	public void queFormatoLigaToStringSeRespete() {
		
		LigaTres.setBando(Bandos.Heroe);  // Reemplaza con el bando que desees probar
		//LigaTres.agregarCompetidor(personajeUno);
        String primerResultadoEsperado = "Liga 1: Heroe, 10, 20, 30, 40";  // Reemplaza con el resultado esperado
        assertEquals(primerResultadoEsperado, LigaTres.toString());
        //LigaTres.agregarCompetidor(personajeUno);
        String segundoResultadoEsperado = "Liga 2: Villano, 20, 30, 40, 50";  // Reemplaza con el resultado esperado
        assertEquals(segundoResultadoEsperado, LigaTres.toString());
	}*/
	
	@Test
	public void quePermitaContar() {
		assertEquals(ligaVillanos.contarIntegrantes(), 2);
	}
	
	
	@Test
	public void queCalculePoderUnidadesCompetidoras() {
		
	}

}

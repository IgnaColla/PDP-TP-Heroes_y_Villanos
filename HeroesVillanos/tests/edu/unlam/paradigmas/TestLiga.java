//package edu.unlam.paradigmas;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Set;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
//import edu.unlam.paradigmas.archivos.ArchivoPersonajes;
//import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
//import edu.unlam.paradigmas.sistema.*;
//
//public class TestLiga {
//	Competidor v1;
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
//	
//	@Test
//	public void TestAgregarLigaALiga() {
//		
//	}
//	@Test
//	public void TestGetCaracteristicasDeCompetidor() {
//		
//	}
//	@Test
//	public void TestGetCaracteristicasDeLiga() {
//		
//	}
//	@Test
//	public void TestContarPersonajes() {
//		
//	}
//	*/
//}
//
///*
// * Set<UnidadCompetidor> Heroes = new HashSet<UnidadCompetidor>();
//		Set<UnidadCompetidor> Villanos = new HashSet<UnidadCompetidor>();
//		// String nombreReal, String nombrePersonaje, Bandos bando, Caracteristica caracteristicas
//		//Villano,Ronan the Accuser,Ronan, 150, 250, 180, 330
//		UnidadCompetidor v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano,
//				new Caracteristica(150,250,180,330));
//		//Héroe, Natasha Romanoff, Black Widow, 200, 150, 180, 200
//		UnidadCompetidor h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe,
//				new Caracteristica(200,150,180,200));
//		//Héroe, T'Challa, Black Panther, 200, 200, 200, 200
//		UnidadCompetidor h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe,
//				new Caracteristica(200,200,200,200));
//		//Villano, Loki, 150, 150, 150, 200
//		UnidadCompetidor v2 = new Competidor("Loki", "Loki", Bandos.Villano,
//				new Caracteristica(150,150,150,200));
//		//Héroe, Steve Rogers, Captain America, 100, 200, 250, 200
//		UnidadCompetidor h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe,
//				new Caracteristica(100,200,250,200));
//		
//		
//		Heroes.add(h1);
//		Heroes.add(h2);
//		Heroes.add(h3);
//		
//		Villanos.add(v1);
//		Villanos.add(v2);
//		
//		Liga ligaVillanos = new Liga(Bandos.Villano, new Caracteristica(0,0,0,0), Villanos);
//		Liga ligaHeroes = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), Heroes);
//		*/

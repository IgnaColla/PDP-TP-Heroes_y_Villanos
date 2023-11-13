package edu.unlam.paradigmas;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;

public class TestSistemaHV {
	Competidor v1;
	Competidor h1;
	Competidor h2;
	Competidor v2;
	Competidor h3;
	Liga ligaVillanos;
	Liga ligaHeroes;
	Liga ligaConPersonaje;
	Liga ligaDeLigas;
	
	@Before
	public void setUp() throws CaracteristicaExcepcion {
		Set<UnidadCompetidor> Heroes = new HashSet<UnidadCompetidor>();
		Set<UnidadCompetidor> Villanos = new HashSet<UnidadCompetidor>();
		// String nombreReal, String nombrePersonaje, Bandos bando, Caracteristica caracteristicas
		//Villano,Ronan the Accuser,Ronan, 150, 250, 180, 330
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
		
		
		
		
		ligaVillanos = new Liga(Bandos.Villano, new Caracteristica(0,0,0,0), v1, v2);
		ligaHeroes = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), h1, h2);
		
		ligaConPersonaje = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), ligaHeroes, h3);
		//suponiendo que se puede
		ligaDeLigas = new Liga(Bandos.Heroe, new Caracteristica(0,0,0,0), ligaVillanos, ligaHeroes);
	}
	@Test
	public void TestBuscarPorCompetidor() throws CaracteristicaExcepcion {
		
		
	}
	
	@Test
	public void TestAListarPersonajes() {
		
	}
	@Test
	public void TestEnfrentarse() {
		
	}
}

package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	Liga ligaHeroes1;
	Liga ligaHeroes2;
	Liga ligaHeroes3;
	Liga ligaHeroes4;
	Liga ligaVillanos1;
	Liga ligaVillanos2;
	Liga ligaVillanos3;
	Liga ligaVillanos4;
	
	private Map<Competidor, Integer> competidores = new HashMap<>();
	private Map<Integer, Liga> ligas = new HashMap<>();

	@Before
	public void setUp() throws Exception {
		v1 = new Competidor("Ronan", "Ronan the Accuser", Bandos.Villano, new Caracteristica(150, 250, 180, 330));
		v2 = new Competidor("Loki", "Loki", Bandos.Villano, new Caracteristica(150, 150, 150, 200));
	
		h1 = new Competidor("Natasha Romanoff", "Black Widow", Bandos.Heroe, new Caracteristica(200, 150, 180, 200));
		h2 = new Competidor("T'Challa", "Black Panther", Bandos.Heroe, new Caracteristica(200, 200, 200, 200));
		h3 = new Competidor("Steve Rogers", "Captain America", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h4 = new Competidor("Batman", "Batman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));
		h5 = new Competidor("Superman", "Superman", Bandos.Heroe, new Caracteristica(100, 200, 250, 200));

		ligaHeroes1 = new Liga();
		ligaHeroes1.agregarALiga(h1);

		ligaHeroes2 = new Liga();
		ligaHeroes2.agregarALiga(h2);
		
		ligaHeroes3 = new Liga();
		ligaHeroes3.agregarALiga(ligaHeroes1);
		ligaHeroes3.agregarALiga(ligaHeroes2);
		
		ligaHeroes4 = new Liga();

		ligaVillanos1 = new Liga();
		ligaVillanos1.agregarALiga(v1);
		
		ligaVillanos2 = new Liga();
		ligaVillanos1.agregarALiga(v2);

		ligaVillanos3 = new Liga();
		ligaVillanos3.agregarALiga(ligaVillanos1);
		ligaVillanos3.agregarALiga(ligaVillanos2);
		
		ligaVillanos4 = new Liga();
	}
	
	
	/*ligaHeroes4.agregarALiga(ligaVillanos4); no contemplamos esta parte,
	
		* ya que en el menú no permitimos al usuario, agregar
		* villanos a ligas de heroes y viceversa
	
	*/
	
	@Test
	public void quePermitaAgregarLigaALiga() {
		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();
		
		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaHeroes4.agregarALiga(ligaHeroes2); 

		assertEquals(tamañoAnteriorVillanos+ligaVillanos2.contarIntegrantes(),ligaVillanos4.contarIntegrantes());
		assertEquals(tamañoAnteriorHeroe+ligaHeroes2.contarIntegrantes(),ligaHeroes4.contarIntegrantes());
	}
	

	
	@Test
	public void quePermitaAgregarVariasLigasALiga() {
		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();
		
		ligaVillanos4.agregarALiga(ligaVillanos3);
		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaHeroes4.agregarALiga(ligaHeroes3); 
		ligaHeroes4.agregarALiga(ligaHeroes2); 
		
		int resLigaVillano = ligaVillanos2.contarIntegrantes() + ligaVillanos3.contarIntegrantes();
		int resLigaHeroe = ligaHeroes2.contarIntegrantes() + ligaHeroes3.contarIntegrantes();

		assertEquals(tamañoAnteriorVillanos+resLigaVillano,ligaVillanos4.contarIntegrantes());
		assertEquals(tamañoAnteriorHeroe+resLigaHeroe,ligaHeroes4.contarIntegrantes());
	}
	
	@Test
	public void quePermitaAgregarPersonajeALiga() {
		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();

		ligaVillanos4.agregarALiga(v1);
		ligaHeroes4.agregarALiga(h1);
		
		assertEquals(tamañoAnteriorVillanos+1,ligaVillanos4.contarIntegrantes());
		assertEquals(tamañoAnteriorHeroe+1,ligaHeroes4.contarIntegrantes());
	}
	
	@Test
	public void quePermitaAgregarVariosPersonajesALiga() {
		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();

		ligaVillanos4.agregarALiga(v1);
		ligaVillanos4.agregarALiga(v2);
		ligaHeroes4.agregarALiga(h1);
		ligaHeroes4.agregarALiga(h2);
		ligaHeroes4.agregarALiga(h3);
		ligaHeroes4.agregarALiga(h4);
		ligaHeroes4.agregarALiga(h5);
		
		assertEquals(tamañoAnteriorVillanos+2,ligaVillanos4.contarIntegrantes());
		assertEquals(tamañoAnteriorHeroe+5,ligaHeroes4.contarIntegrantes());
	}
	
	public void queSePuedaCrearLigaConUnSoloPersonaje() {
		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();

		ligaVillanos4.agregarALiga(v1);
		ligaHeroes4.agregarALiga(h1);
		
		assertEquals(1,ligaVillanos4.contarIntegrantes());
		assertEquals(1,ligaHeroes4.contarIntegrantes());
	}
	
	public void queSePuedaCrearLigaConUnaSolaLiga() {
		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaHeroes4.agregarALiga(ligaHeroes2); 

		assertEquals(1,ligaVillanos4.contarIntegrantes());
		assertEquals(1,ligaHeroes4.contarIntegrantes());
	}
	
	
	
//	
//	public void queSePuedaCrearLigaConVariasLigas() {
//		Bandos bando = ;
//		sistema.crearLiga(ligas,competidores,bando);
//	}
//	
//	public void queSePuedaCrearLigaConVariosPersonajes() {
//		Bandos bando = ;
//		sistema.crearLiga(ligas,competidores,bando);
//	}
//	
//	public void queSePuedaCrearLigaConDistintasUnidadesCompetidoras() {
//		Bandos bando = ;
//		sistema.crearLiga(ligas,competidores,bando);
//	}

	@Test
	public void queCambiePoderLigaCuandoSeIngresaUnaNuevaUnidadCompetidora() {
	
	}
	
	@Test
	public void queCambiePoderLigaCuandoSeIngresaUnaNuevaLiga() {

	}
	
	@Test
	public void queCambiePoderLigaCuandoSeIngresaUnNuevoPersonaje() {

	}
	
	@Test
	public void mantienePoderPromedioLiga() {

	}
	
	@Test
	public void queCalculePoderUnidadesCompetidoras() {

	}
	
	@Test
	public void queSepaDevolverLaCantidadDePersonajesQueContiene() {

	}
	
	@Test
	public void queSepaDevolverLaCantidadDeLigasQueContiene() {

	}
	
	@Test
	public void queSepaDevolverLaCantidadDeUnidadesCompetidorasQueContiene() {

	}
}

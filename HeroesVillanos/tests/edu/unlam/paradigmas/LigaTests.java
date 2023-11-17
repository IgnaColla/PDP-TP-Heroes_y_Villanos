package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	Competidor v3;
	Competidor h3;
	Competidor h4;
	Competidor h5;
	Competidor h6;
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
		ligaVillanos2.agregarALiga(v2);

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
	
	
	@Test
	public void queSePuedaAgregarLigaConDistintasUnidadesCompetidoras() {

		int tamañoAnteriorHeroe = ligaHeroes4.contarIntegrantes();
		int tamañoAnteriorVillanos = ligaVillanos4.contarIntegrantes();

		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaVillanos4.agregarALiga(ligaVillanos1);
		ligaVillanos4.agregarALiga(v1);
		ligaHeroes4.agregarALiga(ligaHeroes3);
		ligaHeroes4.agregarALiga(ligaHeroes2);
		ligaHeroes4.agregarALiga(h3);
		ligaHeroes4.agregarALiga(h4);
		ligaHeroes4.agregarALiga(h5);
		
		assertEquals(tamañoAnteriorVillanos+3,ligaVillanos4.contarIntegrantes());
		assertEquals(tamañoAnteriorHeroe+6,ligaHeroes4.contarIntegrantes());
	}

	@Test
	public void queAumentePoderLigaCuandoSeIngresaUnaNuevaUnidadCompetidoraConDiferentesAtributos() {
		
		ligaVillanos4.agregarALiga(ligaVillanos1);

		int velocidadAnteriorVillano = ligaVillanos2.getCaracteristica().getVelocidad();
		int fuerzaAnteriorVillano = ligaVillanos2.getCaracteristica().getFuerza();
		int resistenciaAnteriorVillano = ligaVillanos2.getCaracteristica().getResistencia();
		int destrezaAnteriorVillano = ligaVillanos2.getCaracteristica().getDestreza();
	
		ligaVillanos4.agregarALiga(v1);
		
		List<Integer> poderActualizadoVillano = ligaVillanos4.getCaracteristicas();
		
		int velocidadActualizadoVillano = poderActualizadoVillano.get(0);
		int fuerzaActualizadoVillano = poderActualizadoVillano.get(1);
		int resistenciaActualizadoVillano = poderActualizadoVillano.get(2);
		int destrezaActualizadoVillano = poderActualizadoVillano.get(3);
		
		ligaHeroes4.agregarALiga(h1);

		int velocidadAnteriorHeroe = h1.getCaracteristica().getVelocidad();
		int fuerzaAnteriorHeroe = h1.getCaracteristica().getFuerza();
		int resistenciaAnteriorHeroe = h1.getCaracteristica().getResistencia();
		int destrezaAnteriorHeroe = h1.getCaracteristica().getDestreza();

		ligaHeroes4.agregarALiga(ligaHeroes1);		
		
		List<Integer> poderActualizadoHeroe = ligaHeroes4.getCaracteristicas();

		int velocidadActualizadoHeroe = poderActualizadoHeroe.get(0);
		int fuerzaActualizadoHeroe = poderActualizadoHeroe.get(1);
		int resistenciaActualizadoHeroe = poderActualizadoHeroe.get(2);
		int destrezaActualizadoHeroe = poderActualizadoHeroe.get(3);
		
		assertTrue(velocidadAnteriorVillano < velocidadActualizadoVillano);
		assertTrue(fuerzaAnteriorVillano < fuerzaActualizadoVillano);
		assertTrue(resistenciaAnteriorVillano < resistenciaActualizadoVillano);
		assertTrue(destrezaAnteriorVillano < destrezaActualizadoVillano);
		
		assertTrue(velocidadAnteriorHeroe < velocidadActualizadoHeroe);
		assertTrue(fuerzaAnteriorHeroe < fuerzaActualizadoHeroe);
		assertTrue(resistenciaAnteriorHeroe < resistenciaActualizadoHeroe);
		assertTrue(destrezaAnteriorHeroe < destrezaActualizadoHeroe);
	}
	
	@Test 
	public void queAumentePoderLigaCuandoSeIngresaUnaNuevaLiga() {
		
		ligaVillanos4.agregarALiga(ligaVillanos2);

		int velocidadAnteriorVillano = ligaVillanos4.getCaracteristica().getVelocidad();
		int fuerzaAnteriorVillano = ligaVillanos4.getCaracteristica().getFuerza();
		int resistenciaAnteriorVillano = ligaVillanos4.getCaracteristica().getResistencia();
		int destrezaAnteriorVillano = ligaVillanos4.getCaracteristica().getDestreza();
	
		ligaVillanos4.agregarALiga(ligaVillanos1);
		
		
		List<Integer> poderActualizadoVillano = ligaVillanos4.getCaracteristicas();
		
		int velocidadActualizadoVillano = poderActualizadoVillano.get(0);
		int fuerzaActualizadoVillano = poderActualizadoVillano.get(1);
		int resistenciaActualizadoVillano = poderActualizadoVillano.get(2);
		int destrezaActualizadoVillano = poderActualizadoVillano.get(3);
		
		ligaHeroes4.agregarALiga(ligaHeroes2);

		int velocidadAnteriorHeroe = ligaHeroes4.getCaracteristica().getVelocidad();
		int fuerzaAnteriorHeroe = ligaHeroes4.getCaracteristica().getFuerza();
		int resistenciaAnteriorHeroe = ligaHeroes4.getCaracteristica().getResistencia();
		int destrezaAnteriorHeroe = ligaHeroes4.getCaracteristica().getDestreza();

		ligaHeroes4.agregarALiga(ligaHeroes1);		
		
		List<Integer> poderActualizadoHeroe = ligaHeroes4.getCaracteristicas();
		
		int velocidadActualizadoHeroe = poderActualizadoHeroe.get(0);
		int fuerzaActualizadoHeroe = poderActualizadoHeroe.get(1);
		int resistenciaActualizadoHeroe = poderActualizadoHeroe.get(2);
		int destrezaActualizadoHeroe = poderActualizadoHeroe.get(3);
		
		assertTrue(velocidadAnteriorVillano < velocidadActualizadoVillano);
		assertTrue(fuerzaAnteriorVillano < fuerzaActualizadoVillano);
		assertTrue(resistenciaAnteriorVillano < resistenciaActualizadoVillano);
		assertTrue(destrezaAnteriorVillano < destrezaActualizadoVillano);
		
		assertTrue(velocidadAnteriorHeroe < velocidadActualizadoHeroe);
		assertTrue(fuerzaAnteriorHeroe < fuerzaActualizadoHeroe);
		assertTrue(resistenciaAnteriorHeroe < resistenciaActualizadoHeroe);
		assertTrue(destrezaAnteriorHeroe < destrezaActualizadoHeroe);
	}
	
	@Test
	public void queAumentePoderLigaCuandoSeIngresaUnNuevoPersonaje() {
		
		ligaVillanos4.agregarALiga(v1);

		int velocidadAnteriorVillano = ligaVillanos4.getCaracteristica().getVelocidad();
		int fuerzaAnteriorVillano = ligaVillanos4.getCaracteristica().getFuerza();
		int resistenciaAnteriorVillano = ligaVillanos4.getCaracteristica().getResistencia();
		int destrezaAnteriorVillano = ligaVillanos4.getCaracteristica().getDestreza();
	
		ligaVillanos4.agregarALiga(v2);
		
		List<Integer> poderActualizadoVillano = ligaVillanos4.getCaracteristicas();
		
		int velocidadActualizadoVillano = poderActualizadoVillano.get(0);
		int fuerzaActualizadoVillano = poderActualizadoVillano.get(1);
		int resistenciaActualizadoVillano = poderActualizadoVillano.get(2);
		int destrezaActualizadoVillano = poderActualizadoVillano.get(3);
		
		ligaHeroes4.agregarALiga(h1);

		int velocidadAnteriorHeroe = ligaHeroes4.getCaracteristica().getVelocidad();
		int fuerzaAnteriorHeroe = ligaHeroes4.getCaracteristica().getFuerza();
		int resistenciaAnteriorHeroe = ligaHeroes4.getCaracteristica().getResistencia();
		int destrezaAnteriorHeroe = ligaHeroes4.getCaracteristica().getDestreza();

		ligaHeroes4.agregarALiga(h2);		
		
		List<Integer> poderActualizadoHeroe = ligaHeroes4.getCaracteristicas();

		int velocidadActualizadoHeroe = poderActualizadoHeroe.get(0);
		int fuerzaActualizadoHeroe = poderActualizadoHeroe.get(1);
		int resistenciaActualizadoHeroe = poderActualizadoHeroe.get(2);
		int destrezaActualizadoHeroe = poderActualizadoHeroe.get(3);
		
		assertTrue(velocidadAnteriorVillano < velocidadActualizadoVillano);
		assertTrue(fuerzaAnteriorVillano < fuerzaActualizadoVillano);
		assertTrue(resistenciaAnteriorVillano < resistenciaActualizadoVillano);
		assertTrue(destrezaAnteriorVillano < destrezaActualizadoVillano);
		
		assertTrue(velocidadAnteriorHeroe < velocidadActualizadoHeroe);
		assertTrue(fuerzaAnteriorHeroe < fuerzaActualizadoHeroe);
		assertTrue(resistenciaAnteriorHeroe < resistenciaActualizadoHeroe);
		assertTrue(destrezaAnteriorHeroe < destrezaActualizadoHeroe);
	}
	
	
	@Test
	public void queSepaDevolverLaCantidadDePersonajesQueContiene() {
		ligaVillanos4.agregarALiga(v1);
		ligaVillanos4.agregarALiga(v2);
		
		ligaHeroes4.agregarALiga(h1);
		ligaHeroes4.agregarALiga(h2);
		ligaHeroes4.agregarALiga(h3);

		assertEquals(2, ligaVillanos4.contarIntegrantes());
		assertEquals(3, ligaHeroes4.contarIntegrantes());
	}
	
	@Test
	public void queSepaDevolverLaCantidadDeLigasQueContiene() {
		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaVillanos4.agregarALiga(ligaVillanos3);
		
		ligaHeroes4.agregarALiga(ligaHeroes1);
		ligaHeroes4.agregarALiga(ligaHeroes2);
		ligaHeroes4.agregarALiga(ligaHeroes3);

		assertEquals(3, ligaVillanos4.contarIntegrantes());
		assertEquals(4, ligaHeroes4.contarIntegrantes());
	}
	
	@Test
	public void queSepaDevolverLaCantidadDeUnidadesCompetidorasQueContiene() {
		ligaVillanos4.agregarALiga(ligaVillanos3);
		ligaVillanos4.agregarALiga(ligaVillanos2);
		ligaVillanos4.agregarALiga(v1);
		ligaVillanos4.agregarALiga(v2);
		
		ligaHeroes4.agregarALiga(ligaHeroes3);
		ligaHeroes4.agregarALiga(ligaHeroes2);
		ligaHeroes4.agregarALiga(ligaHeroes1);

		ligaHeroes4.agregarALiga(h1);
		ligaHeroes4.agregarALiga(h2);
		ligaHeroes4.agregarALiga(h3);
		
		assertEquals(5, ligaVillanos4.contarIntegrantes());
		assertEquals(7, ligaHeroes4.contarIntegrantes());
	}
}

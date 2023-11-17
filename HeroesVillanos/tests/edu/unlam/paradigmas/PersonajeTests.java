package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.SistemaHeroesVillanos;
import edu.unlam.paradigmas.sistema.UnidadCompetidor;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class PersonajeTests {
	SistemaHeroesVillanos sistema = new SistemaHeroesVillanos();
	Caracteristica.TipoCaracteristica car;
	
	
	Competidor personajeUno;
	Caracteristica caracteristicasPersonajeUno;
	Competidor personajeDos;
	Caracteristica caracteristicasPersonajeDos;
	Competidor personajeTres;
	Caracteristica caracteristicasPersonajeTres;
	@SuppressWarnings("unused")
	Competidor personajeCuatro;
	Caracteristica caracteristicasPersonajeCuatro;
	@SuppressWarnings("unused")
	Competidor personajeCinco;
	Caracteristica caracteristicasPersonajeCinco;
	@SuppressWarnings("unused")
	Competidor personajeSeis;
	Caracteristica caracteristicasPersonajeSeis;
	Competidor v1, v2, v3, v4, v5, h1, h2, h3, h4, h5;
	Liga ligaHeroes, ligaHeroes2, ligaHeroes3, ligaVillanos, ligaVillanos2, ligaVillanos3;
	

	@Before
	public void setUp() throws Exception {
		caracteristicasPersonajeUno = new Caracteristica(10, 20, 30, 40);
		personajeUno = new Competidor("Nombre real test p1", "Nombre personaje test p1", Bandos.Heroe,
				caracteristicasPersonajeUno);
		caracteristicasPersonajeDos = new Caracteristica(20, 30, 40, 50);
		personajeDos = new Competidor("Nombre real test p2", "Nombre personaje test p2", Bandos.Villano,
				caracteristicasPersonajeDos);
		
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
		
		//agregarALiga
		ligaHeroes.agregarALiga(h1);
		ligaHeroes.agregarALiga(h2);
		//ligaHeroes.setBando(Bandos.Heroe);
		//ligaHeroes2.setBando(Bandos.Heroe);
		
		//System.out.println(ligaHeroes);
		ligaVillanos.agregarALiga(v1);
		ligaVillanos.agregarALiga(v2);
		
		//ligaDeLigas.agregarALiga(ligaHeroes);
		//ligaDeLigas.agregarALiga(ligaHeroes2);
		
		//ligaDeLigas.add()
	}

	// esto no se tendría que probar acá, se tendría que probar en sistema?
	@Test(expected = CaracteristicaExcepcion.class)
	public void quePersonajeNoSeGenereConCaracteristicasNegativas() throws CaracteristicaExcepcion {
		caracteristicasPersonajeTres = new Caracteristica(-60, 70, 80, 90);
		caracteristicasPersonajeCuatro = new Caracteristica(60, -70, 80, 90);
		caracteristicasPersonajeCinco = new Caracteristica(60, 70, -80, 90);
		caracteristicasPersonajeSeis = new Caracteristica(60, 70, 80, -90);

		personajeTres = new Competidor("Nombre real test p3", "Nombre personaje test p3", Bandos.Heroe,
				caracteristicasPersonajeTres);
		
		personajeTres.getCaracteristica().getVelocidad();

		personajeCuatro = new Competidor("Nombre real test p4", "Nombre personaje test p4", Bandos.Villano,
				caracteristicasPersonajeCuatro);

		personajeCinco = new Competidor("Nombre real test p5", "Nombre personaje test p5", Bandos.Heroe,
				caracteristicasPersonajeCinco);

		personajeSeis = new Competidor("Nombre real test p6", "Nombre personaje test p6", Bandos.Villano,
				caracteristicasPersonajeSeis);
	}

	@Test(expected = IllegalArgumentException.class)
	public void quePersonajeNoSeGenereConLigasNoConocidas() throws CaracteristicaExcepcion {
		caracteristicasPersonajeTres = new Caracteristica(60, 70, 80, 90);
		caracteristicasPersonajeCuatro = new Caracteristica(60, 70, 80, 90);
		caracteristicasPersonajeCinco = new Caracteristica(60, 70, 80, 90);
		caracteristicasPersonajeSeis = new Caracteristica(60, 70, 80, 90);

		personajeTres = new Competidor("Nombre real test p3", "Nombre personaje test p3", Bandos.valueOf("Pepito"),
				caracteristicasPersonajeTres);

		personajeCuatro = new Competidor("Nombre real test p4", "Nombre personaje test p4", Bandos.valueOf("PEPITO2"),
				caracteristicasPersonajeCuatro);

		personajeCinco = new Competidor("Nombre real test p5", "Nombre personaje test p5", Bandos.valueOf("PEPITO3"),
				caracteristicasPersonajeCinco);

		personajeSeis = new Competidor("Nombre real test p6", "Nombre personaje test p6", Bandos.valueOf("PEPITO4"),
				caracteristicasPersonajeSeis);
	}

	
	/*
	@Test
	public void queFormatoLigaToStringSeRespete() {
        String primerResultadoEsperado = "Heroe, Nombre real test p1, Nombre personaje test p1, 10, 20, 30, 40";
        assertEquals(primerResultadoEsperado, personajeUno.toString());
        String segundoResultadoEsperado = "Villano, Nombre real test p2, Nombre personaje test p2, 20, 30, 40, 50";
        assertEquals(segundoResultadoEsperado, personajeDos.toString());
	}*/
	
	
	/*
	 * public boolean personajePierdeContraUnidad(UnidadCompetidor u2, TipoCaracteristica caracteristica) {

		int resultado = this.getValorCaracteristica(caracteristica) / this.contarIntegrantes()
				- u2.getValorCaracteristica(caracteristica) / u2.contarIntegrantes();

		if (resultado < 0) {
			return true;
		}

		return false;
	}
	 * */
	
	
	/*
	 * personajeUno = new Competidor("Nombre real test p1", "Nombre personaje test p1", Bandos.Heroe,
				caracteristicasPersonajeUno);
		caracteristicasPersonajeDos = new Caracteristica(20, 30, 40, 50);
		personajeDos = new Competidor("Nombre real test p2", "Nombre personaje test p2", Bandos.Villano,
				caracteristicasPersonajeDos);
	 * */
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAVelocidad() { 
		assertEquals(personajeUno.personajePierdeContraUnidad(personajeDos, car.valueOf("VELOCIDAD")), true);
	}
	
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAFuerza() { 
		assertEquals(personajeUno.personajePierdeContraUnidad(personajeDos, car.valueOf("FUERZA")), true);
	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAResistencia() { 
		assertEquals(personajeUno.personajePierdeContraUnidad(personajeDos, car.valueOf("RESISTENCIA")), true);
		
	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseADestreza() {
		assertEquals(personajeUno.personajePierdeContraUnidad(personajeDos, car.valueOf("RESISTENCIA")), true);
	}
	
	
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAVelocidad() {
		assertEquals(personajeUno.personajePierdeContraUnidad(ligaVillanos, car.valueOf("VELOCIDAD")), true);
	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAFuerza() {
		assertEquals(personajeUno.personajePierdeContraUnidad(ligaVillanos, car.valueOf("FUERZA")), true);
	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAResistencia() {
		assertEquals(personajeUno.personajePierdeContraUnidad(ligaVillanos, car.valueOf("RESISTENCIA")), true);
	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseADestreza() {
		assertEquals(personajeUno.personajePierdeContraUnidad(ligaVillanos, car.valueOf("DESTREZA")), true);
	}
	
	@Test
	public void quePersonajeSeDistingaEnBaseAOtraUnidad() {
		assertEquals(personajeUno.equals(personajeDos), false);
	}
	/*
	@Test
	public void quePersonajeSeaIgualEnBaseAOtraUnidad() {
		
	}*/
	
	@Test
	public void quePersonajeSepaContarse() {
		assertEquals(personajeUno.contarIntegrantes(), 1);
	}
}

package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.comparadores.ComparadorPorCaracteristica;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;
import edu.unlam.paradigmas.sistema.Competidor;

public class ComparadorCaracteristicasTests {

	TipoCaracteristica caracteristicaUno;
	TipoCaracteristica caracteristicaDos;
	TipoCaracteristica caracteristicaTres;
	TipoCaracteristica caracteristicaCuatro;
	Competidor competidorUno;
	Caracteristica caracteristicasCompetidorUno;
	Competidor competidorDos;
	Caracteristica caracteristicasCompetidorDos;

	@Before
	public void setUp() throws Exception {
		caracteristicasCompetidorUno = new Caracteristica(10, 20, 30, 40);
		competidorUno = new Competidor("Nombre real test p1", "Nombre personaje test p1", Bandos.Heroe,
				caracteristicasCompetidorUno);
		
		caracteristicasCompetidorDos = new Caracteristica(20, 30, 40, 50);
		competidorDos = new Competidor("Nombre real test p2", "Nombre personaje test p2", Bandos.Villano,
				caracteristicasCompetidorDos);
	}

	@Test
	public void queResultadoSeaMayorPorVelocidadCompetidor1() {
		  ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.VELOCIDAD);
	        int resultado = comparador.compare(competidorUno, competidorDos);
	        assertEquals(-1, resultado);
	}
	
	@Test
    public void queResultadoSeaMayorPorVelocidadCompetidor2() {
        ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.VELOCIDAD);
        int resultado = comparador.compare(competidorDos, competidorUno);
        assertEquals(1, resultado);
    }

    @Test
    public void queResultadosSeanIgualesPorVelocidadCompetidores() {
        ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.VELOCIDAD);
        int resultado = comparador.compare(competidorUno, competidorUno);
        assertEquals(0, resultado);
    }
	
    @Test
	public void queResultadoSeaMayorPorFuerzaCompetidor1() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.FUERZA);
		int resultado = comparador.compare(competidorUno, competidorDos);
		assertEquals(-1, resultado);
	}

	@Test
	public void queResultadoSeaMayorPorFuerzaCompetidor2() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.FUERZA);
		int resultado = comparador.compare(competidorDos, competidorUno);
		assertEquals(1, resultado);
	}

	@Test
	public void queResultadosSeanIgualesPorFuerzaCompetidores() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.FUERZA);
		int resultado = comparador.compare(competidorUno, competidorUno);
		assertEquals(0, resultado);
	}

	@Test
	public void queResultadoSeaMayorPorResistenciaCompetidor1() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.RESISTENCIA);
		int resultado = comparador.compare(competidorUno, competidorDos);
		assertEquals(-1, resultado);
	}

	@Test
	public void queResultadoSeaMayorPorResistenciaCompetidor2() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.RESISTENCIA);
		int resultado = comparador.compare(competidorDos, competidorUno);
		assertEquals(1, resultado);
	}

	@Test
	public void queResultadosSeanIgualesPorResistenciaCompetidores() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.RESISTENCIA);
		int resultado = comparador.compare(competidorUno, competidorUno);
		assertEquals(0, resultado);
	}

	@Test
	public void queResultadoSeaMayorPorDestrezaCompetidor1() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.DESTREZA);
		int resultado = comparador.compare(competidorUno, competidorDos);
		assertEquals(-1, resultado);
	}

	@Test
	public void queResultadoSeaMayorPorDestrezaCompetidor2() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.DESTREZA);
		int resultado = comparador.compare(competidorDos, competidorUno);
		assertEquals(1, resultado);
	}

	@Test
	public void queResultadosSeanIgualesPorDestrezaCompetidores() {
		ComparadorPorCaracteristica comparador = new ComparadorPorCaracteristica(TipoCaracteristica.DESTREZA);
		int resultado = comparador.compare(competidorUno, competidorUno);
		assertEquals(0, resultado);
	}
}
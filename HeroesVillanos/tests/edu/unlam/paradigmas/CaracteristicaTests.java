package edu.unlam.paradigmas;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;

public class CaracteristicaTests {

	@Test
	public void queCreaCaracteristicaCorrectamente() throws CaracteristicaExcepcion {
		int velocidad = 20;
		int fuerza = 30;
		int resistencia = 35;
		int destreza = 50;
		
		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
		
		assertEquals(caracteristica.getVelocidad(), velocidad);
		assertEquals(caracteristica.getFuerza(), fuerza);
		assertEquals(caracteristica.getResistencia(), resistencia);
		assertEquals(caracteristica.getDestreza(), destreza);
	}
	
	@Test(expected = CaracteristicaExcepcion.class)
	public void queNoCreaCaracteristicaCorrectamenteVelocidad() throws CaracteristicaExcepcion {
		int velocidad = -20;
		int fuerza = 30;
		int resistencia = 35;
		int destreza = 50;
		
		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
		
		assertEquals(caracteristica.getVelocidad(), velocidad);
		assertEquals(caracteristica.getFuerza(), fuerza);
		assertEquals(caracteristica.getResistencia(), resistencia);
		assertEquals(caracteristica.getDestreza(), destreza);
	}
	
	@Test(expected = CaracteristicaExcepcion.class)
	public void queNoCreaCaracteristicaCorrectamenteFuerza() throws CaracteristicaExcepcion {
		int velocidad = 20;
		int fuerza = -30;
		int resistencia = 35;
		int destreza = 50;
		
		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
		
		assertEquals(caracteristica.getVelocidad(), velocidad);
		assertEquals(caracteristica.getFuerza(), fuerza);
		assertEquals(caracteristica.getResistencia(), resistencia);
		assertEquals(caracteristica.getDestreza(), destreza);
	}
	
	@Test(expected = CaracteristicaExcepcion.class)
	public void queNoCreaCaracteristicaCorrectamenteResistencia() throws CaracteristicaExcepcion {
		int velocidad = 20;
		int fuerza = 30;
		int resistencia = -35;
		int destreza = 50;
		
		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
		
		assertEquals(caracteristica.getVelocidad(), velocidad);
		assertEquals(caracteristica.getFuerza(), fuerza);
		assertEquals(caracteristica.getResistencia(), resistencia);
		assertEquals(caracteristica.getDestreza(), destreza);
	}
	
	@Test(expected = CaracteristicaExcepcion.class)
	public void queNoCreaCaracteristicaCorrectamenteDestreza() throws CaracteristicaExcepcion {
		int velocidad = 20;
		int fuerza = 30;
		int resistencia = 35;
		int destreza = -50;
		
		Caracteristica caracteristica = new Caracteristica(velocidad, fuerza, resistencia, destreza);
		
		assertEquals(caracteristica.getVelocidad(), velocidad);
		assertEquals(caracteristica.getFuerza(), fuerza);
		assertEquals(caracteristica.getResistencia(), resistencia);
		assertEquals(caracteristica.getDestreza(), destreza);
	}
	
	@Test
	public void tipoCaracteristicaGetNextPrincipio() throws CaracteristicaExcepcion {
		TipoCaracteristica tipoCaracteristica = TipoCaracteristica.VELOCIDAD;
		
		tipoCaracteristica = tipoCaracteristica.getNext();
		
		assertEquals(tipoCaracteristica, TipoCaracteristica.FUERZA);
	}
	
	@Test
	public void tipoCaracteristicaGetNextMedio() throws CaracteristicaExcepcion {
		TipoCaracteristica tipoCaracteristica = TipoCaracteristica.FUERZA;
		
		tipoCaracteristica = tipoCaracteristica.getNext();
		
		assertEquals(tipoCaracteristica, TipoCaracteristica.RESISTENCIA);
	}
	
	@Test
	public void tipoCaracteristicaGetNextFinal() throws CaracteristicaExcepcion {
		TipoCaracteristica tipoCaracteristica = TipoCaracteristica.DESTREZA;
		
		tipoCaracteristica = tipoCaracteristica.getNext();
		
		assertEquals(tipoCaracteristica, TipoCaracteristica.VELOCIDAD);
	}

}

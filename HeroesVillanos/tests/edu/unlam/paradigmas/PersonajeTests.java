package edu.unlam.paradigmas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.excepciones.CaracteristicaExcepcion;
import edu.unlam.paradigmas.sistema.Bandos;
import edu.unlam.paradigmas.sistema.Caracteristica;
import edu.unlam.paradigmas.sistema.Competidor;

public class PersonajeTests {

	private Competidor personajeUno;
	private Caracteristica caracteristicasPersonajeUno;
	private Competidor personajeDos;
	private Caracteristica caracteristicasPersonajeDos;
	private Competidor personajeTres;
	private Caracteristica caracteristicasPersonajeTres;
	@SuppressWarnings("unused")
	private Competidor personajeCuatro;
	private Caracteristica caracteristicasPersonajeCuatro;
	@SuppressWarnings("unused")
	private Competidor personajeCinco;
	private Caracteristica caracteristicasPersonajeCinco;
	@SuppressWarnings("unused")
	private Competidor personajeSeis;
	private Caracteristica caracteristicasPersonajeSeis;

	@Before
	public void setUp() throws Exception {
		caracteristicasPersonajeUno = new Caracteristica(10, 20, 30, 40);
		personajeUno = new Competidor("Nombre real test p1", "Nombre personaje test p1", Bandos.Heroe,
				caracteristicasPersonajeUno);
		caracteristicasPersonajeDos = new Caracteristica(20, 30, 40, 50);
		personajeDos = new Competidor("Nombre real test p2", "Nombre personaje test p2", Bandos.Villano,
				caracteristicasPersonajeDos);

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

	@Test
	public void queFormatoLigaToStringSeRespete() {
        String primerResultadoEsperado = "Heroe, Nombre real test p1, Nombre personaje test p1, 10, 20, 30, 40";
        assertEquals(primerResultadoEsperado, personajeUno.toString());
        String segundoResultadoEsperado = "Villano, Nombre real test p2, Nombre personaje test p2, 20, 30, 40, 50";
        assertEquals(segundoResultadoEsperado, personajeDos.toString());
	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAVelocidad() { 

	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAFuerza() { 

	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseAResistencia() { 

	}
	
	@Test
	public void quePersonajePierdaContraOtroPersonajeEnBaseADestreza() {

	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAVelocidad() {

	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAFuerza() {

	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseAResistencia() {

	}
	
	@Test
	public void quePersonajePierdaContraOtraLigaEnBaseADestreza() {

	}
	
	@Test
	public void quePersonajePierdaContraVariasLigasEnBaseAVelocidad() {

	}
	
	@Test
	public void quePersonajePierdaContraVariasLigasEnBaseAFuerza() {

	}
	
	@Test
	public void quePersonajePierdaContraVariasLigasEnBaseAResistencia() {

	}
	
	@Test
	public void quePersonajePierdaContraVariasLigasEnBaseADestreza() {

	}
	
	@Test
	public void quePersonajePierdaContraVariosPersonajeEnBaseAVelocidad() {

	}
	
	@Test
	public void quePersonajePierdaContraVariosPersonajeEnBaseAFuerza() {

	}
	
	@Test
	public void quePersonajePierdaContraVariosPersonajeEnBaseAResistencia() {

	}
	
	@Test
	public void quePersonajePierdaContraVariosPersonajeEnBaseADestreza() {

	}
	
	@Test
	public void quePersonajePierdaContraVariasPersonajeEnBaseADestreza() {

	}
	
	@Test
	public void quePersonajeSeDistingaEnBaseAOtraUnidad() {

	}
	
	@Test
	public void quePersonajeSeaIgualEnBaseAOtraUnidad() {

	}
	
	@Test
	public void quePersonajeSepaContarse() {

	}	
}

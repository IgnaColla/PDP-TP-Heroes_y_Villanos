package hyv;

import java.util.ArrayList;
import java.util.List;

public class Liga extends Unidad {

	private List<Personaje> miembros = new ArrayList<>();
	private int cantMiembros;

	// Constructores

	public Liga(String nombreReal, List<Personaje> miembros) {
		this.nombreReal = nombreReal;
		this.miembros = miembros;
		this.cantMiembros = miembros.size();
		
		for (Personaje personaje : miembros) {
			this.velocidad += personaje.velocidad;
			this.fuerza += personaje.fuerza;
			this.resistencia += personaje.resistencia;
			this.destreza += personaje.destreza;
		}
		
		this.velocidad /= cantMiembros;
		this.fuerza /= cantMiembros;
		this.resistencia /= cantMiembros;
		this.destreza /= cantMiembros;
	}
	
	// Metodos

	public String getNombreReal() {
		return this.nombreReal;
	}

	public int getCantidad() {
		return this.cantMiembros;
	}

	@Override
	public String toString() {
		return String.format(
				"\nLiga '%s'\n+ Cantidad de Miembros: %d\n+ Velocidad total: %d\n+ Fuerza total: %d\n+ Resistencia total: %d\n"
						+ "+ Destreza total: %d",
				getNombreReal(), getCantidad(), getVelocidad(), getFuerza(), getResistencia(), getDestreza());
	}
}

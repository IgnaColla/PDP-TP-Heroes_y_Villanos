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
		return String.format("\nLiga '%s'\n+ Cantidad de Miembros: %d", getNombreReal(), getCantidad());
	}
}

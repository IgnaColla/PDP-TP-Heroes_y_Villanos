package hyv;

public abstract class Unidad {
	protected String bando;
	protected String nombreReal;
	protected int velocidad;
	protected int fuerza;
	protected int resistencia;
	protected int destreza;
	
	/// Metodos
	
	public String getBando() {
		return this.bando;
	}
	
	public String getNombreReal() {
		return this.nombreReal;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}
	
	public int getResistencia() {
		return this.resistencia;
	}
	
	public int getDestreza() {
		return this.destreza;
	}
}

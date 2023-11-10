package hyv;

public class Personaje extends Unidad{
	
	// Atributos
	
	private String nombreFicticio;
	
	// Constructores
	
	public Personaje(String bando, String nombreFicticio, String nombreReal, int velocidad, int fuerza, int resistencia, int destreza) {
		this.bando = bando;
		this.nombreFicticio = nombreFicticio;
		this.nombreReal = nombreReal;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}
	
	// Metodos
	
	public String getNombreFicticio() {
		return this.nombreFicticio;
	}
	
	@Override
	public String toString(){
		return String.format("\nPersonaje '%s' \n+ Nombre: %s\n+ Bando: %s\n+ Velocidad: %d\n+ Fuerza: %d\n+ Resistencia: %d\n+ Destreza: %d",
				getNombreFicticio(), getNombreReal(), getBando(), getVelocidad(), getFuerza(), getResistencia(), getDestreza());
	}
}
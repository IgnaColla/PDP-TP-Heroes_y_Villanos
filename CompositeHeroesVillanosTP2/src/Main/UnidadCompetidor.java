package Main;

public abstract class UnidadCompetidor {
	private String bando;
	Caracteristica car;
	
	public UnidadCompetidor(String bando)
	{
		this.bando = bando;
		//this.car = car;
	}
	public abstract int contar();
	
}

package Main;

public class Competidor extends UnidadCompetidor{
	String nombreReal;
	String nombrePersonaje;
	//private Caracteristica car;
	
	public Competidor(String nombreReal, String nombrePersonaje, String bando)
	{
		super(bando);
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
	}
	public int contar()
	{
		return 1;
	}
	/*
	int enfrentarse(UnidadCompetidor u, Caracteristica c)
	{
		return 3;
	}*/
}

package Main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Liga extends UnidadCompetidor {
	// no puedo instanciar directamente desde un set
	// solamente de sus hijos como el hashset
	protected Set <UnidadCompetidor> children = new HashSet<>();
	
	// no puedo asignarle |
	public Liga(String bando, UnidadCompetidor ... componentes)
	{
		super(bando);
		agregarCompetidor(componentes);
	}
	public boolean agregarCompetidor(UnidadCompetidor c)
	{
		return children.add(c);
	}
	//agregar una liga
	public boolean agregarCompetidor(UnidadCompetidor ...componentes)
	{
		//encontrar un equivalente de esta funcion pero en SET
		return children.addAll(Arrays.asList(componentes));
	}
	//esta es acorde a una caracteristica
	public int contar()
	{
		int total = 0;
		for(UnidadCompetidor c : children)
		{
			total += c.contar();
		}
		return total;
	}
	
	
}

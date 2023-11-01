package hyv;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Personaje Adam = new Personaje("Villano", "Barbanegra", "Adam Johnson", 5, 4, 3, 21);
		Personaje Rocky = new Personaje("Heroe", "Superman", "Rocky Reynolds", 53, 42, 3, 2);
		Personaje Richard = new Personaje("Villano", "Frozono", "Richard Gene", 57, 46, 3, 23);
		
		List<Personaje> liga_heroes = new ArrayList<>();
		List<Personaje> liga_villanos = new ArrayList<>();
		
		liga_heroes.add(Rocky);
		liga_villanos.add(Adam);
		liga_villanos.add(Richard);
		
		Liga lh = new Liga("Justicia", liga_heroes);
		Liga lv = new Liga("Maldad", liga_villanos);
		
		System.out.println(Adam);
		System.out.println(Rocky);
		System.out.println(Richard);
		
		System.out.println(lh);
		System.out.println(lv);
	}

}

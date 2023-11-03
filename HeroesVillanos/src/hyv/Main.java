package hyv;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Personaje Adam = new Personaje("Villano", "Barbanegra", "Adam Johnson", 2, 4, 3, 2);
		Personaje Rocky = new Personaje("Heroe", "Superman", "Rocky Reynolds", 3, 2, 3, 4);
		Personaje Richard = new Personaje("Villano", "Frozono", "Richard Gene", 6, 3, 4, 5);

		List<Personaje> liga_heroes = new ArrayList<>();
		List<Personaje> liga_villanos = new ArrayList<>();

		liga_heroes.add(Rocky);
		liga_villanos.add(Adam);
		liga_villanos.add(Richard);
		
//		Liga lh = new Liga("Justicia", liga_heroes);
		Liga lv = new Liga("Maldad", liga_villanos);

//		System.out.println(Adam);
//		System.out.println(Rocky);
//		System.out.println(Richard);
//		
//		System.out.println(lh);
//		System.out.println(lv);

		enfrentar(lv, Rocky);
	}

	public static int comparar(Unidad u1, Unidad u2) {
		int cantAtributos = 4;
		int[] caract1 = new int[cantAtributos];
		int[] caract2 = new int[cantAtributos];

		caract1[0] = u1.getVelocidad();
		caract1[1] = u1.getFuerza();
		caract1[2] = u1.getResistencia();
		caract1[3] = u1.getDestreza();

		caract2[0] = u2.getVelocidad();
		caract2[1] = u2.getFuerza();
		caract2[2] = u2.getResistencia();
		caract2[3] = u2.getDestreza();

		for (int i = 0; i < cantAtributos; ++i) {
			if (caract1[i] > caract2[i]) {
				return 1;
			} else if (caract1[i] < caract2[i]) {
				return -1;
			}
		}

		return 0;
	}

	public static void enfrentar(Unidad u1, Unidad u2) {
		int res = comparar(u1, u2);
		
		switch(res) {
			case 1:
				System.out.printf("\nEnfrentamiento: '%s' vs '%s'"
						+ "\n+ Ganador: %s", u1.getNombreReal(), u2.getNombreReal(), u1.getNombreReal());
				break;
			case 0:
				System.out.printf("\nEnfrentamiento: '%s' vs '%s'"
						+ "\n+ Ganador: Empate", u1.getNombreReal(), u2.getNombreReal());
				break;
			case -1:
				System.out.printf("\nEnfrentamiento: '%s' vs '%s'"
						+ "\n+ Ganador: %s", u1.getNombreReal(), u2.getNombreReal(), u2.getNombreReal());
				break;
		}
	}
}

package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadCompetidor c1 = new Competidor("elpepe0","asdadsa","villano");
		UnidadCompetidor c2 = new Competidor("elpepe1","asdadsa","villano");
		UnidadCompetidor c3 = new Competidor("elpepe2","asdadsa","villano");
		UnidadCompetidor c4 = new Competidor("elpepe3","asdadsa","villano");
		UnidadCompetidor c5 = new Competidor("elpepe4","asdadsa","villano");
		
		Liga l1 = new Liga("villano", c2,c3,c4);
		Liga l2 = new Liga("villano", l1, c1);
		Liga l3 = new Liga("villano", l2, c1, l1);
		
		System.out.println("la cantidad de integrantes de l1 es: " + l1.contar());
		System.out.println("la cantidad de integrantes de l2 es: " + l2.contar());
		//esperado 4 + 1 +3 = 8
		System.out.println("la cantidad de integrantes de l3 es: " + l3.contar());
	}

}

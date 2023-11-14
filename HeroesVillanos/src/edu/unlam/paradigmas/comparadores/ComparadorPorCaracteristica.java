package edu.unlam.paradigmas.comparadores;
import java.util.Comparator;
import edu.unlam.paradigmas.sistema.Caracteristica.TipoCaracteristica;
import edu.unlam.paradigmas.sistema.Competidor;

public class ComparadorPorCaracteristica implements Comparator<Competidor> {
    private TipoCaracteristica caracteristica;

    public ComparadorPorCaracteristica(TipoCaracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public int compare(Competidor c1, Competidor c2) {
        int resultado = 0;

        switch (caracteristica) {
            case VELOCIDAD:
                resultado = Integer.compare(c1.getCaracteristica().getVelocidad(), c2.getCaracteristica().getVelocidad());
                break;
            case FUERZA:
                resultado = Integer.compare(c1.getCaracteristica().getFuerza(), c2.getCaracteristica().getFuerza());
                break;
            case RESISTENCIA:
                resultado = Integer.compare(c1.getCaracteristica().getResistencia(), c2.getCaracteristica().getResistencia());
                break;
            case DESTREZA:
                resultado = Integer.compare(c1.getCaracteristica().getDestreza(), c2.getCaracteristica().getDestreza());
                break;
            default:
                System.out.println(" asdasdasdas");
                break;
        }

        return resultado;
    }
}

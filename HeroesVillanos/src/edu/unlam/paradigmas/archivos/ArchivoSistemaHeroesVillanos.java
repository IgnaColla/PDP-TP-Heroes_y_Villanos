package edu.unlam.paradigmas.archivos;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import edu.unlam.paradigmas.sistema.Competidor;
import edu.unlam.paradigmas.sistema.Liga;
import edu.unlam.paradigmas.sistema.SistemaHeroesVillanos;

public class ArchivoSistemaHeroesVillanos {

	private String nombreArchivoLigas;
	private String nombreArchivoPersonajes;

	public ArchivoSistemaHeroesVillanos(String nombreArchivoPersonajes, String nombreArchivoLigas) { //ME PARECE QUE ESTO NO VA, ES PURO ARCHIVO
		this.nombreArchivoPersonajes = nombreArchivoPersonajes;
		this.nombreArchivoLigas = nombreArchivoLigas;
	}

//	public SistemaHeroesVillanos leer() {
//
//		ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes(nombreArchivoPersonajes);
//		ArchivoLigas archivoLigas = new ArchivoLigas(nombreArchivoLigas);
//
//		Set<Competidor> competidores = new HashSet<>();;
//		Set<Liga> ligas = new HashSet<>();
//
//		SistemaHeroesVillanos sistema = null;
//
//		try {
//
//			competidores = archivoPersonajes.leer();
//			ligas = archivoLigas.leer();
//			sistema = new SistemaHeroesVillanos(competidores,ligas); //no lo probé, revisar si está bien con el set o con un list
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//
//		return sistema;
//	}

}

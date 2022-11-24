package com.s1examen;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Canciones canciones = getCanciones();
		canciones.genero();
		canciones.artista();
		
	}
	
	/**
	 * Se manda a llamar a las canciones para que el usuario coloque en consola 
	 * el número que coincide con su playlist para saber la información de la 
	 * canción elegida.
	 * 
	 * El único cambio que hubo en comparación con la "Interfaz"
	 * es que, para buscar "Reproducciones" en el for el programa pide una ruta "sencilla".
	 * @return
	 * 
	 */
	
	public static Canciones getCanciones() {
		
		Scanner entrada = new Scanner (System.in);
		int numero;
		System.out.println("Número de su canción: ");
		numero=entrada.nextInt();
		
		Canciones[] canciones = new Canciones[3];
		canciones[0] = new Primadonna();
		canciones[1] = new Brutal();
		canciones[2] = new Nobody();
		
		
		Canciones cancionResult = canciones[numero];
		
		for(Canciones o:canciones) {
			
				System.out.println("Reproducciones: "+ o.Reproducciones()+1);
				
				return cancionResult;
		}
		
		return cancionResult;
	}

}

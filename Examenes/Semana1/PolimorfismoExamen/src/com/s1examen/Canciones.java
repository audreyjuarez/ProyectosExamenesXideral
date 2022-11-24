package com.s1examen;

//Se declaran en la clase abstracta las propiedades, como un molde para las clases hijas.
public abstract class Canciones {
	public abstract void genero();
	public abstract void artista();
	
	int x;
	int Reproducciones() {
				
		return x;
	}
}

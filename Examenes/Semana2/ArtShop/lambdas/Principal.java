package ArtShop.lambdas;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		CompradorArt user1 = new CompradorArt("Cinthya", 42);
		
		Inyector.inyectaMateriales(user1);
		
		user1.compraMateriales();
		
		CompradorArt user2 = new CompradorArt("Nancy", 57);
		
		Inyector.inyectaMateriales(user2);
		
		user2.compraMateriales();
		
		CompradorArt user3 = new CompradorArt("Maria", 77);
		
		Inyector.inyectaMateriales(user3);
		
		user3.compraMateriales();
		
		
		System.out.println("-----------COMPPRADORES----------");
		
		List<CompradorArt> listaCompradores = new ArrayList<>();
		listaCompradores.add(CompradorArt("Cinthya", 42));
		listaCompradores.add(CompradorArt("Nancy", 57));
		listaCompradores.add(CompradorArt("Maria", 77));
	
		System.out.println("COMPRADORES CUYO NOMBRE LONGITUD MAYOR A 5 Y COMPRÓ MÁS DE 40 PESOS EN MATERIALES");
		mostrarCompradores(listaCompradores, c -> c.getName().length()>5 
										&& c.getTotalCompra() > 40);
	
	

}
	
	static void mostrarCompradores(List<CompradorArt> lista, 
			Predicado<CompradorArt> p ) {

		for(CompradorArt c :lista) {
			if (p.mostrar(c)) //EJECUTA LA LAMBDA
			System.out.println(c);
			
		}
			
	
		}

	private static CompradorArt CompradorArt(String string, int i) {
		
		return null;
	}
}
	
	
	
	
package ArtShop;

public class Principal {

	public static void main(String[] args) {

		CompradorArt user1 = new CompradorArt("Cinthya");
		
		Inyector.inyectaMateriales(user1);
		
		user1.compraMateriales();
		
		CompradorArt user2 = new CompradorArt("Nancy");
		
		Inyector.inyectaMateriales(user2);
		
		user2.compraMateriales();
		
		CompradorArt user3 = new CompradorArt("Maria");
		
		Inyector.inyectaMateriales(user3);
		
		user3.compraMateriales();
	}
}

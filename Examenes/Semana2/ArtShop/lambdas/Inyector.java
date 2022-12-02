package ArtShop.lambdas;

public class Inyector {

	public static void inyectaMateriales(CompradorArt b) {
		
		b.setMaterial(getMateriales());
	}

	private static Materiales getMateriales() {
		
		Materiales[] arrayMateriales = {new Lienzos (20),
				new Pinceles (7),new Pinturas (15)
				};
		
		
		int numero = (int)(Math.random() * arrayMateriales.length);
		
		
		return arrayMateriales[numero];
	}

	

}

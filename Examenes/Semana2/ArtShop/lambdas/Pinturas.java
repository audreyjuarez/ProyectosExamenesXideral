package ArtShop.lambdas;

public class Pinturas extends Materiales{
	
	public Pinturas(int name) {
		super(name);
	}

	@Override
	void ticket() {
		System.out.println("Pinturas: "+name);
	}
}

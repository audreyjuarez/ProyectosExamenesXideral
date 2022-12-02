package ArtShop.lambdas;

public class Pinceles extends Materiales{
	
	public Pinceles(int name) {
		super(name);
	}
	
	
	@Override
	void ticket() {
		System.out.println("Pinceles: "+name);
	}
}

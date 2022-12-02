package ArtShop;

public class Lienzos extends Materiales{
	public Lienzos(int i) {
		super(i);
	}
	
	@Override
	void ticket() {
		System.out.println("Lienzos: "+name);
	}

	
	

	
}

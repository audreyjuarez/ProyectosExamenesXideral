package ArtShop;

public class CompradorArt {
	
	private String name;
	private Materiales material;
	int TotalCompra;
	
	public CompradorArt(String name) {
		this.name = name;
	}

	public void compraMateriales() {
		System.out.println(name);
		material.ticket();
	}
	
	public Materiales getMaterial(){
		return material;
		
	}

	public void setMaterial(Materiales material) {
		this.material = material;
		
	}
	
	
	
	
	
	
	
	
	
}

package ArtShop.lambdas;

public class CompradorArt {
	
	private String name;
	private Materiales material;
	private double compra;
	
	public CompradorArt(String name, double compra) {
		this.name = name;
		this.compra= compra;
	}
	
//Esto es lo que es parte de la LAMBDAS
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getTotalCompra() {
		return compra;
	}
	public void setTotalCompra(double compra) {
		this.compra = compra;
	}
//------
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
	
	public String toString() {
		return "Comprador [Precio x material=" + name + ", Total de su Compra=" + compra + "]";
	}
	
	
	
	
	
	
	
}

package ArtShop.lambdas;

@FunctionalInterface
public interface Predicado<T> {

	abstract boolean mostrar(T t);
		
}

package TryCatch;

public class Excepciones {
	public static void main(String argumentos[]) throws ArithmeticException{
		int a=10, b=9;
		if (a/b< 1)
		throw new ArithmeticException("No es mayor que 1");
		else if(a-b == 0)
			throw new ArithmeticException("No se permiten resultados con negativo");
		System.out.println(a/b);
		
	}
}

package TryCatch;

import java.util.*;

public class Multicatch {
	public static void main(String[] args) {
		
		String palabra= "Shakespeare";
		int num;
		 
		try {
		 num=Integer.parseInt(palabra, palabra.length());
		}catch(NumberFormatException a) {
			a.printStackTrace();
			System.out.println("No es un número "+ a);
		}catch (InputMismatchException a) {
			a.printStackTrace();
		System.out.println("No es un número entero" + a);
		}
		
	}
	
	
}

package Finally;

/*
 *"Finally" siempre asegura el cierre de los recursos y siempre se va a ejecutar,
 *no importando lo que ocurra en el programa
 */



public class ExplicacionFinally {

	
	 public static void main(String[] args) {
		 
		 int g =11;
	        int c=0;
	 
	        try {
	            int resultado=g/c;
//Aquí la excepción es lanzada con catch, pero los recursos no se cierran.	 
	            System.out.println(resultado);
	        } catch (Exception e) {
	        	
	            System.out.println("Falla"); //Continua la falla, sin embargo el finally sigue actuando.
	            throw new NullPointerException();
	        }finally {                       //Cierre de recursos.
	            System.out.println("Cierre");
	 
	        }
	 
	        System.out.println("Finalizado");
	 
	 }
}
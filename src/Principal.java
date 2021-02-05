/**
 * Clase Principal
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class Principal {
	public static void main(String[] args) {
		Calc calculadora = new Calc();
		System.out.println(calculadora.decode("datos.txt"));
	}
}

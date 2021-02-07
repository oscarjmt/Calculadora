import java.util.Scanner;

/**
 * Clase Principal
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class Principal {
	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Calc calculadora = new Calc();
		System.out.println("Ingrese el path del archivo 'datos.txt' (no incluya el nombre del archivo): ");
		String dir = input.nextLine() + "/datos.txt";
		System.out.println(calculadora.decode(dir));
	}
}

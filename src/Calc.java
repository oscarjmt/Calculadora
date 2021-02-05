import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase Calc
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class Calc implements Calculadora {
	
	public Calc() {
	}
	
	@Override
	public int suma(int x, int y) {
		return x + y;
	}

	@Override
	public int resta(int x, int y) {
		return x - y;
	}

	@Override
	public int multiplicacion(int x, int y) {
		return x * y;
	}

	@Override
	public int division(int x, int y) {
		return x / y;
	}

	@Override
	public int operar(Stack x) {
		return 0;
	}

	@Override
	public String decode(String a) {
		//Se lee cada linea del archivo y se guardan en un ArrayList.
		ArrayList<String> filas = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("datos.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;
			while((s = entrada.readLine()) != null)
				filas.add(s);
			entrada.close();
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);
			}
		catch(java.io.IOException ioex) {
		}
		
		String resultados = "";
		String[] elementos;
		StackArrayList<String> stack = new StackArrayList<String>();
		for(int i=0; i<filas.size(); i++) {
			elementos = filas.get(i).split(" ");
			for(int j=elementos.length; j>=0; j--) {
				stack = new StackArrayList<String>();
				stack.push(elementos[j]);
			}
			resultados += "\nResultado linea " + (i+1) + ": " + operar(stack);
		}
		
		return resultados;
	}
	
}

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
		return y + x;
	}

	@Override
	public int resta(int x, int y) {
		return y - x;
	}

	@Override
	public int multiplicacion(int x, int y) {
		return y * x;
	}

	@Override
	public int division(int x, int y) {
		return y / x;
	}

	@Override
	public int operar(Stack x) {
		StackArrayList<Integer> stack = new StackArrayList<Integer>();
		char elemento;
		for(int i=0; i<x.size(); i++) {
			elemento = (char) x.pop();
			try {
				stack.push(Character.getNumericValue(elemento));
			} catch(Exception e) {
				switch(elemento) {
					case '+': 
						stack.push(suma(stack.pop(), stack.pop())); 
						break;
					case '-':
						stack.push(resta(stack.pop(), stack.pop())); 
						break;
					case '*':
						stack.push(multiplicacion(stack.pop(), stack.pop())); 
						break;
					case '/':
						stack.push(division(stack.pop(), stack.pop())); 
						break;
					default:
						return 0;
				}
			}
		}
		
		return stack.pop();
	}

	@Override
	public String decode(String a) {
		//Se lee cada linea del archivo y se guardan en un ArrayList.
		ArrayList<String> filas = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(a);
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
			System.out.println("Error en lectura del archivo: " + ioex);
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

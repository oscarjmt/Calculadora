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
		int size = x.size();
		for(int i=0; i<size; i++) {
			elemento = ((String) x.pop()).charAt(0);
			int operando = Character.getNumericValue(elemento);
			if(operando > 0) {
				stack.push(operando);
			} else {
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
			System.out.println(stack.toString());
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
			stack = new StackArrayList<String>();
			for(int j=elementos.length-1; j>=0; j--) {
				stack.push(elementos[j]);
			}
			System.out.print(stack);
			resultados += "\nResultado linea " + (i+1) + ": " + operar(stack);
		}
		
		return resultados;
	}
	
}

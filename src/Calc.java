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
		StackVector<Integer> stack = new StackVector<Integer>();
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
		StackVector<String> stack = new StackVector<String>();
		boolean valid = true;
		for(int i=0; i<filas.size(); i++) {
			valid = true;
			elementos = filas.get(i).split(" ");
			stack = new StackVector<String>();
			for(int j=elementos.length-1; j>=0; j--) {
				try {  
				    Integer.parseInt(elementos[j]);  
				    stack.push(elementos[j]);
				  } catch(NumberFormatException e){  
					  if(elementos[j].equals("+") || elementos[j].equals("-") ||elementos[j].equals("*") ||elementos[j].equals("/")) {
						  stack.push(elementos[j]);
					  } else {
						  valid = false;
						  break;
					  }
				  }  
			}
			System.out.print(stack);
			if(valid) {
				resultados += "\nResultado linea " + (i+1) + ": " + operar(stack);
			} else {
				resultados += "\nResultado linea " + (i+1) + ": caracter incorrecto";
			}
		}
		
		return resultados;
	}
	
}

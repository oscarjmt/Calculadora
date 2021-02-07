import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase Calc
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class Calc implements calculadora {
	
	/**
	 * Constructor
	 */
	public Calc() {
	}
	
	/**
	 * Suma
	 * @param x: int
	 * @param y: int
	 * @return int
	 */
	@Override
	public int suma(int x, int y) {
		return y + x;
	}
	
	/**
	 * Resta
	 * @param x: int
	 * @param y: int
	 * @return int
	 */
	@Override
	public int resta(int x, int y) {
		return y - x;
	}
	
	/**
	 * Multiplicacion
	 * @param x: int
	 * @param y: int
	 * @return int
	 */
	@Override
	public int multiplicacion(int x, int y) {
		return y * x;
	}
	
	/**
	 * Division
	 * @param x: int
	 * @param y: int
	 * @return int
	 */
	@Override
	public int division(int x, int y) {
		return y / x;
	}
	
	/**
	 * Opera el stack
	 * @param x: Stack
	 * @return int
	 */
	@Override
	public int operar(Stack x) {
		// aqui se cambia la interfaz de ArrayList a StackVector
		StackVector<Integer> stack = new StackVector<Integer>();
		char elemento;
		int size = x.size();
		//Se opera de forma postfix
		for(int i=0; i<size; i++) {
			elemento = ((String) x.pop()).charAt(0);
			int operando = Character.getNumericValue(elemento);
			//Se verifica si es operando u operador.
			if(operando > 0) {
				stack.push(operando);
			} else {
				//Se reconoce el operador.
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
	
	/**
	 * Lee archivo y manda a operar cada linea
	 * @param a: String
	 * @return String
	 */
	@Override
	public String decode(String a) {
		//Se lee cada linea del archivo y se guardan en un ArrayList. Solo lee el archivo no ejecuta.
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
		//Se recorren los Strings generado por cada linea del archivo.
		for(int i=0; i<filas.size(); i++) {
			valid = true;
			elementos = filas.get(i).split(" ");
			stack = new StackVector<String>();
			for(int j=elementos.length-1; j>=0; j--) {
				//Se agregan los elementos a una pila.
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
			
			//Se retorna el resultado adecuado.
			if(valid) {
				try {
					resultados += "Resultado linea " + (i+1) + ": " + operar(stack)+ "\n";
				} catch (ArrayIndexOutOfBoundsException aioobe) {
					resultados += "Resultado linea " + (i+1) + ": operacion invalida\n";
				}
			} else {
				resultados += "Resultado linea " + (i+1) + ": caracter incorrecto\n";
			}
		}
		return resultados;
	}
	
}

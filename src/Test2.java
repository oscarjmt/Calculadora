import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test1
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
class Test2 {
	
	/**
	 * Test de operaciones de la calculadora
	 */
	@Test
	void test() {
		Calc test2 = new Calc();
		StackVector<Integer> stackPrueba = new StackVector<Integer>();
		stackPrueba.push(3);
		stackPrueba.push("/");
		assertEquals("Resultado linea 1: 15\nResultado linea 2: 14\nResultado linea 3: 23\n",stack);					
	}

}

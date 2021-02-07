import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test1
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
class Test2 {
	
	/**
	 * Test de la pila
	 */
	@Test
	void test() {
		Calc test2 = new Calc();
		StackVector<String> stackPrueba = new StackVector<String>();
		stackPrueba.push("/");
		stackPrueba.push("1");
		stackPrueba.push("+");
		stackPrueba.push("8");
		stackPrueba.push("*");
		stackPrueba.push("5");
		stackPrueba.push("3");
		assertEquals(23,test2.operar(stackPrueba));					
	}

}

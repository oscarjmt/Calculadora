import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test1
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
class Test1 {
	
	/**
	 * Test de operaciones de la calculadora
	 */
	@Test
	void test() {
		Calc test1 = new Calc();
		String mensaje = test1.decode("D:/Google Drive/UVG/III Semestre/Algoritmos y Estructura de Datos/HDT2/Calculadora/src/datos.txt");
		assertEquals("Resultado linea 1: 15\nResultado linea 2: 14\nResultado linea 3: 23\n",mensaje);					
	}

}

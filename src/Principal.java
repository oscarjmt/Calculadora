/**
 * Clase Principal
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class Principal {
	public static void main(String[] args) {
		// path Oscar C:/Users/osjom/OneDrive/Universidad/Semestre 3/Algoritmos y Estructuras de Datos/Hoja de Trabajo 2/Calculadora/src/datos.txt
		// path Jeyner D:/Google Drive/UVG/III Semestre/Algoritmos y Estructura de Datos/HDT2/Calculadora/src/datos.txt
		Calc calculadora = new Calc();
		System.out.println(calculadora.decode("D:/Google Drive/UVG/III Semestre/Algoritmos y Estructura de Datos/HDT2/Calculadora/src/datos.txt"));
	}
}

/**
 * Interface Calculadora
 */
public interface Calculadora {
    public int suma(int x, int y);
    public int resta(int x, int y);
    public int multiplicacion(int x, int y);
    public int division(int x, int y);

    public int operar(Stack x);
    
    public String decode(String a);
}
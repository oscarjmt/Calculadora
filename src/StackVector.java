import java.util.Vector;

/**
 * Clase StackVector<E>
 * @param <E>
 * @author Oscar Mendez
 * @author Jeyner Arango
 */
public class StackVector<E> implements Stack<E> {
	protected Vector<E> data;
	
	/**
	 * Constructor
	 */
	public StackVector()
	{
		data = new Vector<E>();
	}
	
	/**
	 * Push
	 * @param item: E
	 */
	public void push(E item)
	{
		data.add(item);
	}
	
	/**
	 * Pop
	 * @return E
	 */
	public E pop()
	{
		return data.remove(size()-1);
	}
	
	/**
	 * Peek
	 * @return E
	 */
	public E peek()
	{
		return data.get(size() - 1);
	}
	
	/**
	 * Size
	 * @return int
	 */
	public int size()
	{
		return data.size();
	}
	
	/**
	 * Empty
	 * @return boolean
	 */
	public boolean empty()
	{
		return size() == 0;
	}
	
	/**
	 * Metodo toString
	 * @return String
	 */
	@Override
	public String toString() {
		return "Pila: " + data;
	}
}
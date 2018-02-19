
package hw4;

public class MyStack<T> extends DoubleEndedLL<T> implements Stack_QueueInterface<T> {
	private DoubleEndedLL<T> s;

	/**
	 * constructor that creates a DoubleEndedLL for the stack
	 */
	public MyStack() {
		s = new DoubleEndedLL<>();
	}

	/**
	 * checks if the stack is empty
	 * 
	 * @return whether or not the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	/**
	 * adds an element to the top of the stack
	 * 
	 * @param newItem
	 *            the item to add
	 */
	@Override
	public void addElement(T newItem) {
		s.addFirst(newItem);
	}

	/**
	 * pops an item from the top of the stack
	 * 
	 * @return the last item added to the stack
	 */
	@Override
	public T removeElement() {
		return s.removeFirst();
	}

	/**
	 * returns the number of elements in the stack
	 * 
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return s.size();
	}

}



package hw4;

@SuppressWarnings("unchecked")
public class MyQueue<T> implements Stack_QueueInterface<T> {
	private T[] contents;
	private int head;
	private int tail;
	private int size;

	/**
	 * constructs a new Queue
	 */
	public MyQueue() {
		contents = (T[]) new Object[2];
		head = 0;
		tail = -1;
		size = 0;
	}

	/**
	 * Tests if the storage is empty.
	 * 
	 * @return true a storage contains no items; false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds an element to a storage
	 * 
	 * @param newItem
	 *            item to be added
	 */
	@Override
	public void addElement(T newItem) {
		size++;
		if (size > contents.length) //checks if resize is needed
			resize();
		tail++;
		if (tail >= contents.length) //checks if at end of square array
			tail = 0;
		contents[tail] = newItem;
	}
	
	/**
	 * doubles the size of the contents array when there isn't enough space in the array
	 * copies the original array to the doubled array
	 */
	private void resize() {
		T[] dubble = (T[]) new Object[contents.length * 2];

		int i = head, j = 0;
		while (i != tail) { //iterates through before tail of circular array
			dubble[j] = contents[i];
			if (i + 1 >= contents.length) //checks if at end of square array
				i = 0;
			else
				i++;
			j++;
		}
		dubble[j] = contents[tail]; //includes tail
		contents = dubble;
		head = 0;
		tail = j;
	}

	/**
	 * Removes the object from the storage and returns that object as the value
	 * of this function.
	 * 
	 * @return value of the removed object.
	 */
	@Override
	public T removeElement() {
		size--;
		T r = contents[head];
		head++;
		if (head >= contents.length) //checks if at end of square array
			head = 0;
		return r;
	}

	/**
	 * Returns the size of the storage
	 * 
	 * @return the size of the storage
	 */
	@Override
	public int size() {
		return size;
	}
}

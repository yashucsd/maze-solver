

package hw4;

public class DoubleEndedLL<T> implements DoubleEndedLLInterface<T> {
	private int nelems;
	private Node head;
	private Node tail;

	/**
	 * constructor that creates dummy head/tail nodes
	 */
	public DoubleEndedLL() {
		nelems = 0;

		head = new Node(null);
		tail = new Node(null, head, null);

		head.setNext(tail);
		head.setPrev(null);
	}

	/** Node class, sampled from my HW2 */
	protected class Node {

		T data;
		Node next;
		Node prev;

		/**
		 * Constructor to create singleton Node
		 * 
		 * @param element
		 *            the node's contents
		 */
		public Node(T element) {
			this.data = element;
		}

		/**
		 * Constructor to create singleton link it between previous and next
		 * 
		 * @param element
		 *            Element to add, can be null
		 * @param prevNode
		 *            predecessor Node, can be null
		 * @param nextNode
		 *            successor Node, can be null
		 */
		public Node(T element, Node prevNode, Node nextNode) {
			this.data = element;
			this.next = nextNode;
			this.prev = prevNode;

			if (prevNode != null)
				prevNode.setNext(this);
			if (nextNode != null)
				nextNode.setPrev(this);
		}

		/** Remove this node from the list. Update previous and next nodes */
		public void remove() {
			next.setPrev(prev);
			prev.setNext(next);
			nelems--;
		}

		/**
		 * Set the previous node in the list
		 *
		 * @param p
		 *            new previous node
		 */
		public void setPrev(Node p) {
			this.prev = p;
		}

		/**
		 * Set the next node in the list
		 * 
		 * @param n
		 *            new next node
		 */
		public void setNext(Node n) {
			this.next = n;
		}

		/**
		 * Set the element
		 * 
		 * @param e
		 *            new element
		 */
		public void setElement(T e) {
			this.data = e;
		}

		/** Accessor to get the next Node in the list */
		public Node getNext() {
			return this.next;
		}

		/** Accessor to get the prev Node in the list */
		public Node getPrev() {
			return this.prev;
		}

		/** Accessor to get the Nodes Element */
		public T getElement() {
			return this.data;
		}
	}

	/**
	 * returns whether or not the list is empty
	 * @return whether or not the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return nelems == 0;
	}

	/**
	 * returns the number of elements in the list
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return nelems;
	}

	/**
	 * adds a node to the front of the list
	 * 
	 * @param newItem
	 *            the contents of the added element
	 */
	@Override
	public void addFirst(T newItem) {
		new Node(newItem, head, head.getNext());
		nelems++;
	}

	/**
	 * adds a node to the rear of the list
	 * 
	 * @param newItem
	 *            the contents of the added element
	 */
	@Override
	public void addLast(T newItem) {
		new Node(newItem, tail.getPrev(), tail);
		nelems++;
	}

	/**
	 * removes a node from the beginning of the list
	 * 
	 * @return the removed element
	 */
	@Override
	public T removeFirst() {
		T r = head.getNext().getElement();
		head.getNext().remove();
		return r;
	}

	/**
	 * removes a node from the rear of the list
	 * 
	 * @return the removed element
	 */
	@Override
	public T removeLast() {
		T r = tail.getPrev().getElement();
		tail.getPrev().remove();
		return r;
	}

}

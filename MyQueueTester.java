
package hw4;

import org.junit.*;
import static org.junit.Assert.*;

public class MyQueueTester {
	MyQueue<Integer> integers = new MyQueue<>();
	MyQueue<String> strings = new MyQueue<>();

	@Before
	public void setUp() {

	}

	/** Test if the is empty method functions */
	@Test
	public void testIsEmpty() {
		strings.addElement("no");
		strings.addElement("no");
		strings.addElement("no");

		assertEquals("Check if integers is empty", true, integers.isEmpty());
		assertEquals("Check if strings is empty", false, strings.isEmpty());
	}

	/** Test if the size method functions */
	@Test
	public void testSize() {
		strings.addElement("hi");
		strings.addElement("no");
		strings.addElement("boop");

		assertEquals("Check if integers is empty", 0, integers.size());
		assertEquals("Check if strings has three elements", 3, strings.size());
	}

	/** Tests for removing all elements */
	@Test
	public void testRemoveAll() {
		integers.addElement(5);
		integers.addElement(6);
		integers.addElement(10);
		integers.removeElement();
		integers.removeElement();
		integers.removeElement();

		assertEquals("Check if all elements removed", 0, integers.size());
		assertEquals("Check if all elements removed", true, integers.isEmpty());

		integers.addElement(5);

		assertEquals("Check if can add element to emptied queue", new Integer(5), integers.removeElement());
	}

	/** Tests the add method */
	@Test
	public void testAdd() {
		strings.addElement("wow");
		strings.addElement("yes");
		strings.addElement("no");
		strings.addElement("wow");
		strings.addElement("yes");
		strings.addElement("no");

		assertEquals("Check add method", "wow", strings.removeElement());
	}

	/** tests the remove method */
	@Test
	public void testRemove() {
		integers.addElement(5);
		integers.removeElement();
		integers.addElement(4);
		integers.addElement(5);
		integers.addElement(2);
		integers.removeElement();

		assertEquals("Check remove method", 2, integers.size());
	}

	/** tests the adding and subsequent removal of an element */
	@Test
	public void testAddnRemove() {
		integers.addElement(4);
		integers.removeElement();
		integers.addElement(2);

		assertEquals("Check subsequent add and remove", new Integer(2), integers.removeElement());
	}
}

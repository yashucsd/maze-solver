

package hw4;

import org.junit.*;
import static org.junit.Assert.*;

public class DoubleEndedLLTester {
	DoubleEndedLL<Integer> integers = new DoubleEndedLL<>();
	DoubleEndedLL<String> strings = new DoubleEndedLL<>();

	@Before
	public void setUp() {
		strings.addLast("I'm last");
	}

	/** Test if the is empty method functions */
	@Test
	public void testIsEmpty() {
		assertEquals("Check if integers is empty", integers.isEmpty(), true);
		assertEquals("Check if strings is empty", strings.isEmpty(), false);
	}

	/** Test if the size method functions */
	@Test
	public void testSize() {
		assertEquals("Check if integers is empty", integers.size(), 0);
		assertEquals("Check if strings has an element", strings.size(), 1);
	}

	/** Tests the add and remove first method functions */
	@Test
	public void testFirst() {
		integers.addFirst(5);
		strings.addFirst("wow");

		assertEquals("Test remove first and check add first for ints", integers.removeFirst(), new Integer(5));
		assertEquals("Test remove first and check add first for strs", strings.removeFirst(), "wow");
	}

	/** Tests the add and remove last method functions */
	@Test
	public void testLast() {
		integers.addLast(5);
		strings.addLast("wow");

		assertEquals("Test remove last and check add last for ints", integers.removeLast(), new Integer(5));
		assertEquals("Test remove last and check add last for strs", strings.removeLast(), "wow");
	}
}

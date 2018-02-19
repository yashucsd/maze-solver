
package hw4;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MazeTester {
	Maze mz = new Maze();
	
	/**
	 * loads a maze for testing
	 */
	@Before
	public void setUp(){
		mz.loadMaze("Mazes/maze-3");
	}
	
	/** tests the get methods: get Start, get Finish, get Square */
	@Test
	public void testGet(){
		Square start = mz.getStart();
		Square control = mz.getSquare(1, 0);
		assertEquals("Checks access of start square", control, start);

		Square end = mz.getFinish();
		control = mz.getSquare(1, 4);
		assertEquals("Checks access of end square", control, end);

		Square exp = mz.getSquare(1, 2);
		control = new Square(1, 2, 1);
		assertEquals("Checks access of particular square", control.getClass(), exp.getClass());
		assertEquals("Checks access of particular square", control.getRow(), exp.getRow());
		assertEquals("Checks access of particular square", control.getCol(), exp.getCol());
	}
	
	/** tests set visit method */
	@Test
	public void testSetVisit(){
		mz.setVisit(0, 0);
		assertEquals("Checks if square is visited", true, mz.getSquare(0,0).isVisited());
	}
	/** tests the clearing method */
	@Test
	public void testClear(){
		mz.clearMaze();
		assertEquals("Checks if maze is cleared", false, mz.getSquare(0,0).isVisited());
	}
	
	/** tests the neighbors method */
	@Test
	public void testNeighbors(){
		ArrayList<Square> nbs = mz.getNeighbors(mz.getStart());
		ArrayList<Square> ctr = new ArrayList<>();
		ctr.add(mz.getSquare(0, 0));
		ctr.add(mz.getSquare(1, 1));
		ctr.add(mz.getSquare(2, 0));
		assertEquals("Checks start's neighbors are correct", ctr, nbs);

		nbs = mz.getNeighbors(mz.getFinish());
		ctr.clear();
		ctr.add(mz.getSquare(0, 4));
		ctr.add(mz.getSquare(2, 4));
		ctr.add(mz.getSquare(1, 3));
		assertEquals("Checks end's neighbors are correct", ctr, nbs);
	}
	
	/** prints the toPrint response, for user to check*/
	@Test
	public void testPrint(){
		String exp = mz.toString();
		System.out.print(exp);
	}
}

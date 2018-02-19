
package hw4;

public class MazeSolverQueue extends MazeSolver {

	MyQueue<Square> queue = new MyQueue<>();

	/**
	 * uses MazeSolver's constructor and adds the start Square to the worklist
	 * 
	 * @param maze
	 *            the maze that will be solved
	 */
	MazeSolverQueue(Maze maze) {
		super(maze);
		add(super.maze.getStart());
	}

	/**
	 * creates an empty worklist
	 */
	public void makeEmpty() {
		queue = new MyQueue<>();
	}
	
	/**
	 * returns true if the worklist is empty
	 * 
	 * @return if the worklist is empty
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	/**
	 * add the given Square to the worklist
	 * 
	 * @param sq
	 *            the given square
	 */
	public void add(Square sq) {
		queue.addElement(sq);
	}

	/**
	 * return the ”next” item from the worklist
	 * 
	 * @return the ”next” item from the worklist
	 */
	public Square next() {
		return queue.removeElement();
	}

	/**
	 * accessor for the worklist
	 * @return the queue worklist
	 */
	public MyQueue<Square> getQueue() {
		return queue;
	}

	public static void main(String[] args) {
		Maze myMaze = new Maze();
		//boolean load = myMaze.loadMaze(args[0]);
		boolean load = myMaze.loadMaze("tests/maze-7");
		if (!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverQueue queueSolver = new MazeSolverQueue(myMaze);
			queueSolver.solve();
			System.out.println(queueSolver.getPath() + "\n");
			System.out.println(queueSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = " + queueSolver.getQueue().size());
		}
	}

}

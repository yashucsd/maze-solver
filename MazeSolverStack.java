
package hw4;

public class MazeSolverStack extends MazeSolver {

	private MyStack<Square> stack = new MyStack<>();

	/**
	 * uses MazeSolver's constructor and adds the start Square to the worklist
	 * 
	 * @param maze
	 *            the maze that will be solved
	 */
	MazeSolverStack(Maze maze) {
		super(maze);
		add(super.maze.getStart());
	}

	/**
	 * creates an empty worklist
	 */
	public void makeEmpty() {
		stack = new MyStack<>();
	}

	/**
	 * returns true if the worklist is empty
	 * 
	 * @return if the worklist is empty
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * add the given Square to the worklist
	 * 
	 * @param sq
	 *            the given square
	 */
	public void add(Square sq) {
		stack.addElement(sq);
	}

	/**
	 * return the ”next” item from the worklist
	 * 
	 * @return the ”next” item from the worklist
	 */
	public Square next() {
		return stack.removeElement();
	}

	/**
	 * accessor for the worklist
	 * @return the stack worklist
	 */
	public MyStack<Square> getStack() {
		return stack;
	}

	public static void main(String[] args) {
		Maze myMaze = new Maze();
		//boolean load = myMaze.loadMaze(args[0]);
		boolean load = myMaze.loadMaze("tests/maze-7");
		if (!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverStack stackSolver = new MazeSolverStack(myMaze);
			stackSolver.solve();
			System.out.println(stackSolver.getPath() + "\n");
			System.out.println(stackSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = " + stackSolver.getStack().size());
		}
	}
}



package hw4;

public abstract class MazeSolver {

	protected Maze maze = new Maze();
	private String path = "Found the Escape!\n";
	boolean gameOver = false; // when stop our game
	boolean solved = false;

	/**
	 * creates an empty worklist
	 */
	abstract void makeEmpty();

	/**
	 * returns true if the worklist is empty
	 * 
	 * @return if the worklist is empty
	 */
	abstract boolean isEmpty();

	/**
	 * add the given Square to the worklist
	 * 
	 * @param sq
	 *            the given square
	 */
	abstract void add(Square sq);

	/**
	 * return the ”next” item from the worklist
	 * 
	 * @return the ”next” item from the worklist
	 */
	abstract Square next();

	/**
	 * constructs a new maze solver and stores the maze
	 * 
	 * @param maze2
	 *            the maze to store
	 */
	MazeSolver(Maze maze2) {
		maze = maze2;
	}

	/**
	 * accessor for the solver's maze
	 * 
	 * @return the maze
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * applies step algorithm to the maze until the game is over if the maze is
	 * solved, it generates a solution path to return when the path is requested
	 */
	public void solve() {
		Square finale = null;
		while (!gameOver) {
			finale = step();
		}
		if (finale != null) {
			genPath(finale);
		}
	}

	/**
	 * applies algorithm specified in hmw: basically works through list of
	 * squares until it finds the end, and adds squares that are neighbors of
	 * the current one being analysed to the list
	 * 
	 * @return the last square that was "stepped on"
	 */
	public Square step() {
		if (isEmpty()) {
			// the game is over if there are no more Squares to check
			gameOver = true;
			return null;
		}

		Square next = next();

		if (next.isFinish()) {
			// ends the game bc the end is reached
			gameOver = true;
			solved = true;
			return next;
		}

		for (Square n : maze.getNeighbors(next)) {
			// adds the valid neighbors to the worklist
			if (n.getPrev() == null && n.getType() != 1 && n.getType() != 2) {
				// makes sure that the neighbor hasn't been visited, is not a
				// wall, and is not the start
				add(n);
				next.setVisited();
				n.setPrev(next);
			}
		}

		return next;
	}

	/**
	 * returns whether or not the solver found a solution
	 * 
	 * @return the value of solved
	 */
	public boolean isSolved() {
		return solved;
	}

	/**
	 * Path from S to E as a list of coordinates [i,j] If not solvable, print
	 * failure message
	 * 
	 * @return the value of path
	 */
	public String getPath() {
		if (isSolved()) {
			return path;
		} else {
			path = "Uh oh; there's no escape!";
			return path;
		}
	}

	/**
	 * generates the path the solver took to arrive at the end square by finding
	 * the square it "stepped on"
	 * 
	 * @param sq the end square to find the path to
	 */
	private void genPath(Square sq) {
		MyStack<int[]> visited = new MyStack<>();
		while (sq.hasPrev()) {
			visited.addElement(new int[] { sq.getRow(), sq.getCol() });
			//adds the coordinates of the stepped on square in reverse
			sq.setValid(); //saves it as final path
			sq = sq.getPrev();
		}

		visited.addElement(maze.getStartLoc());
		//makes sure to add the start location too (it won't have a previous)

		while (!visited.isEmpty()) {
			int[] c = visited.removeElement();
			//adds the coordinates to the path string in forward order
			path += "[" + c[0] + ", " + c[1] + "] ";
		}
	}
}

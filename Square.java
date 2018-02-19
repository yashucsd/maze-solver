
package hw4;

public class Square {
	private int r; // row
	private int c; // column
	private int t; // type (see toString)
	private boolean visited;
	private boolean valid;
	private Square previous;

	/**
	 * constructs a new square
	 * 
	 * @param row
	 *            the row of the square
	 * @param col
	 *            the column of the square
	 * @param type
	 *            the code for the type of square it is
	 */
	public Square(int row, int col, int type) {
		r = row;
		c = col;
		t = type;
		visited = false;
	}

	/**
	 * constructs a new square
	 * 
	 * @param row
	 *            the row of the square
	 * @param col
	 *            the column of the square
	 * @param type
	 *            the character representation for the type of square it is
	 */
	Square(int row, int col, char type) {
		r = row;
		c = col;
		t = Character.getNumericValue(type);
		visited = false;
	}

	/**
	 * prints the type of square it is as a character
	 * for solver: it prints x if it's on the final path 
	 */
	public String toString() {
		String r;
		switch (t) {
		case 0:
			if(isValid()) r = "x";
			else if(isVisited() && hasPrev()) r = ".";
			else if(hasPrev()) r = "o";
			else r = "_";
			break;
		case 1:
			r = "#";
			break;
		case 2:
			r = "S";
			break;
		case 3:
			r = "E";
			break;
		default:
			r = null;
			break;
		}
		return r;
	}

	/**
	 * accessor for the row of the square
	 * 
	 * @return the row
	 */
	public int getRow() {
		return r;
	}

	/**
	 * accessor for the column of the square
	 * 
	 * @return the column
	 */
	public int getCol() {
		return c;
	}

	/**
	 * accessor for the type of square
	 * 
	 * @return the type
	 */
	public int getType() {
		return t;
	}

	/**
	 * accessor for the visited value of the square
	 * 
	 * @return the value of visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * determines whether or not the square is finish
	 * 
	 * @return whether or not the type is finish
	 */
	public boolean isFinish() {
		return t == 3;
	}

	/**
	 * determines whether or not the square is start
	 * 
	 * @return whether or not the type is start
	 */
	public boolean isStart() {
		return t == 2;
	}

	/**
	 * determines whether or not the square is valid
	 * 
	 * @return the value of valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * setter for valid, sets as true
	 */
	public void setValid() {
		valid = true;
	}

	/**
	 * setter for visited, sets as true
	 */
	public void setVisited() {
		visited = true;
	}

	/**
	 * clears visited, sets it to false
	 */
	public void clearVisited() {
		visited = false;
	}

	/**
	 * clears the visited and previous values of the square
	 */
	public void clear() {
		this.clearVisited();
		previous = null;
	}

	/**
	 * accessor for the previous Square
	 * 
	 * @return the value of previous
	 */
	public Square getPrev() {
		return previous;
	}

	/**
	 * mutator for previous
	 * 
	 * @param sq
	 *            the square to set as the previous
	 */
	public void setPrev(Square sq) {
		previous = sq;
	}

	public boolean hasPrev() {
		return previous != null;
	}
}


package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maze {
	public Square[][] maze;
	protected int numRows = 0;
	protected int numCols = 0;
	private int[] start = new int[2];
	private int[] finish = new int[2];

	/**
	 * this parses a text file's contents into array maze and notes start and
	 * end squares
	 * 
	 * @param fname
	 *            the name of the maze
	 * @return whether or not the file contains a valid maze
	 */
	@SuppressWarnings("resource")
	public boolean loadMaze(String fname) {

		String line;
		BufferedReader inputStrem;
		StringTokenizer st;

		try {
			inputStrem = new BufferedReader(new FileReader(fname));
			line = inputStrem.readLine();
			if (line != null) {
				st = new StringTokenizer(line);
				numRows = Integer.parseInt(st.nextToken());
				numCols = Integer.parseInt(st.nextToken());
				maze = new Square[numRows][numCols];
			} else {
				return false;
			}

			int currentRow = 0;
			while ((line = inputStrem.readLine()) != null) {
				if (numRows == 0) {
					// true if reading first line in file,
					// containing numRows, numColumns
					st = new StringTokenizer(line);
					numRows = Integer.parseInt(st.nextToken());
					numCols = Integer.parseInt(st.nextToken());
					maze = new Square[numRows][numCols];
				} else if (line.length() == 1)
					break;
				else {
					// reads line of maze
					int col = 0;
					for (int c = 0; c < line.length(); c++) {
						if (line.charAt(c) == ' ')
							continue;
						maze[currentRow][col] = new Square(currentRow, col, line.charAt(c));
						if (line.charAt(c) == '2') {
							// stores start location
							start[0] = currentRow;
							start[1] = col;
						} else if (line.charAt(c) == '3') {
							// stores finish location
							finish[0] = currentRow;
							finish[1] = col;
						}

						col++;
					}
					currentRow++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("Could not find file " + fname);
		}

		return true;
	}

	/**
	 * retrieves the Squares adjacent to sq, in the order of N, E, S, W
	 * 
	 * @param sq
	 *            the square who's neighbors are in search
	 * @return a list of the neighbors of sq
	 */
	public ArrayList<Square> getNeighbors(Square sq) {
		ArrayList<Square> r = new ArrayList<>();
		if (sq.getRow() - 1 > -1) // north
			r.add(maze[sq.getRow() - 1][sq.getCol()]);
		if (sq.getCol() + 1 < numCols) // east
			r.add(maze[sq.getRow()][sq.getCol() + 1]);
		if (sq.getRow() + 1 < numRows) // south
			r.add(maze[sq.getRow() + 1][sq.getCol()]);
		if (sq.getCol() - 1 > -1) // west
			r.add(maze[sq.getRow()][sq.getCol() - 1]);

		return r;

	}

	/**
	 * for ease of access to MazeSolver, returns the start square
	 * 
	 * @return the coordinates of the start square
	 */
	int[] getStartLoc() {
		return start;
	}

	/**
	 * accesses the start square of the maze
	 * 
	 * @return the start square
	 */
	public Square getStart() {
		return maze[start[0]][start[1]];
	}

	/**
	 * accesses the finish square of the maze
	 * 
	 * @return the finish square
	 */
	public Square getFinish() {
		return maze[finish[0]][finish[1]];
	}

	/**
	 * sets the Square at row,column as visited
	 * 
	 * @param row
	 *            the row of targeted square
	 * @param col
	 *            the col of targeted square
	 */
	public void setVisit(int row, int col) {
		maze[row][col].setVisited();
	}

	/**
	 * reset's the squares of the maze's checkers that inform MazeSolver
	 */
	public void clearMaze() {
		for (Square[] r : maze) {
			for (Square c : r) {
				c.clear();
			}
		}
	}
	
	/**
	 * returns the square at a given location
	 * @param row the row of the square
	 * @param col the column of the square
	 * @return the square at this location
	 */
	Square getSquare(int row, int col) {
		return maze[row][col];
	}
	
	/**
	 * returns the maze as a string
	 */
	public String toString() {

		String s = "";
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++)
				s = s + maze[r][c].toString() + " ";
			s = s + "\n";
		}
		return s;
	}

}

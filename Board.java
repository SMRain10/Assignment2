// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
/** The board class creates a board by iterating through a for loop that creates 3 by 3 matrix and puts a blank space
 *  in the element for all 9 elements.
 **/
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	/**
	 * Constructs the board with is a 2D array of 3 by 3.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/** This method gets the mark in the board matrix and returns the value
	 *
	 * @param row
	 * @param col
	 * @return value of the element
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * This method determines if the board is full by checking how many times the board has been marked with an "x" or
	 * "O"
	 * @return Count of the number of marks on the board.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * The method checks if X has three X's in a row on the board
	 * @return True if X wins
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	/**
	 * The method checks if X has three X's in a row on the board
	 * @return True if O wins
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * This method displays the tic tac toe board. It iterates through the rows and columns
	 * and prints the elements in the matrix. The current state of the board is shown in the terminal.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * This method adds a mark to the specified row and column integers.
	 * @param row
	 * @param col
	 * @param mark
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * This method clears the current board by setting all of the spaces back to a blank space ' '.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * This method checks if there is a winner of mark 'X' or 'O' by checking all of the rows and columns
	 * and diagonals and determing if there are three of either mark in a row.
	 * @param mark
	 * @return
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This method adds column headers to the top of the board.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * This method adds hyphens to give the image of a tic tac toe board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * This method adds lines and spaces between the rows of the tic tac toe board.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}

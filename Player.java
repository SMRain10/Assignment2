// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
import java.util.Scanner;

/**
 * This class creates the Player for a tic tac toe game. It is repsonsible for getting user input on where they
 * want to mark on the tic tac toe grid.
 */
public class Player {

    private String name;
    private Board board;
    private Player opponent;
    Scanner in = new Scanner(System.in);

    private char mark;

    /**
     * Constructor used to construct the Player.
     * @param name
     * @param mark
     */
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * The play method displays the board contains the logic for wins or ties. It calls the makeMove() method to ask
     * for the user input of where the next mark is to be placed. It also contains logic used to determine if the
     * player has won or the game is a tie.
     */
    public void play() {
        /**
         * A while loop that checks if any of the win or tie conditions have been met yet. If not it continues
         * to prompt the user for input.
         */
        while (board.xWins() == false && board.oWins() == false && board.isFull() == false){

            board.display();
            makeMove();

            if (board.xWins()){
                board.display();
                System.out.println("Game over.\n" + name + " Player X wins!");
                break;}
            else if (board.isFull()) {
                board.display();
                System.out.println("Game Over.\nTie Game!");
                break;}

            board.display();
            opponent.makeMove();

            if (board.oWins()){
                board.display();
                System.out.println("Game Over.\n" + opponent.name + " Player O wins!");
                break;}
            else if (board.isFull()) {
                board.display();
                System.out.println("Game Over.\nTie Game!");
                break;}
        }
    }

    /**
     * This method is responsible got for placing the mark on the board. It also checks to make sure that the
     * user input is in the correct format by using a while loop.
     */
    public void makeMove() {
        System.out.println(name + ", what row should your next " + mark + " be placed in?");
        int rowInput = in.nextInt();
        System.out.println(name + ", what column should your next " + mark + " be placed in?");
        int columnInput = in.nextInt();

        while (checkInput(rowInput,columnInput)) {
            System.out.println(name + ", what row should your next " + mark + " be placed in?");
            rowInput = in.nextInt();
            System.out.println(name + ", what column should your next " + mark + " be placed in?");
            columnInput = in.nextInt();
        }
        board.addMark(rowInput, columnInput, mark);
    }

    /**
     * This method checks if the input is outside of the index range and if there is already a mark on a spot.
     * It returns true and forces the user to input another row and column number until a valid input has been made.
     * @param row
     * @param col
     * @return
     */
    public boolean checkInput(int row,int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Row or column specified is outside of range. Please re enter.");
            return true;
        } else if (board.getMark(row, col) != ' ') {
            System.out.println("Place is already take please select again");
            return true;
        }
        return false;
    }

    /**
     * This is setter that sets the opponent.
     * @param p1
     */
    public void setOpponent(Player p1) {
        this.opponent = p1;
    }

    /**
     * This is a setter for the board.
     * @param theBoard
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

}

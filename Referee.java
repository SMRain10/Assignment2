// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
/**
 * This class is used to define the Referee of the tic tac toe game. The referee is responsible for running the
 * game and setting the board and setting the two player "X" and "O".
 */
public class Referee {
    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    /**
     * This is the constructor for the referee class.
     */
    public Referee() {
    }

    /**
     * This sets the opponents and X plays the game since X always goes first.
     */
    public void runTheGame() {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        xPlayer.play();
    }

    /**
     * Setter for the board.
     * @param board
     */
    public void setBoard(Board board) {
        this.board=board;
    }

    /**
     * Setter for the "O" player.
     * @param oPlayer
     */
    public void setoPlayer (Player oPlayer){
        this.oPlayer=oPlayer;
    }

    /**
     * Setter for the "X" player
     * @param xPlayer
     */
    public void setxPlayer (Player xPlayer){
        this.xPlayer=xPlayer;
    }
}


import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    // board
    private Board b;
    // doctor and daleks
    private Doctor doc;
    private Dalek d1;
    private Dalek d2;
    private Dalek d3;
    // booleans for the end of the game
    private boolean isthegameoverfam = false;
    private boolean docwon = false;
    private boolean dalekwon = false;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {

        // constructing the board and people/daleks
        this.b = new Board(12, 12);

        // creates the doctor and daleks on the board with random positions within the parameters of the board
        this.doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        this.d1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        this.d2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        this.d3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));



    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {


        // creating doctor/daleks
        b.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
        b.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        b.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        b.putPeg(Color.BLACK, d3.getRow(), d3.getCol());

        // while the game isn't over
        while (!isthegameoverfam) {

            // All the main components of the code were turned into methods to make troubleshooting 
            // for glitches easier by allowing faster and more efficient reorganization of the code


            // moving both the doctor and daleks
            moving();

            // crashing is detected before any reprinting is done
            crash();

            // printing the characters back with their new position and "states" (eg. crashed is red and stationary)
            rePrint();

            // detects whether or not the game meets the requirements for a win for either side
            endGame();


        }
// win messages depending on the victor
        if (docwon) {
            b.displayMessage("You won!");
        }

        if (dalekwon) {
            b.displayMessage("You lost!");
        }

    }

    public void moving() {
        // when the player clicks the doctor moves
        Coordinate click = b.getClick();
        b.removePeg(doc.getRow(), doc.getCol());
        doc.move(click.getRow(), click.getCol());

        //removes the daleks from the board temporarily
        b.removePeg(d1.getRow(), d1.getCol());
        b.removePeg(d2.getRow(), d2.getCol());
        b.removePeg(d3.getRow(), d3.getCol());

        // if the daleks haven't crashed yet, they move
        if (d1.hasCrashed() == false) {
            d1.advanceTowards(doc);
        }
        if (d2.hasCrashed() == false) {
            d2.advanceTowards(doc);
        }
        if (d3.hasCrashed() == false) {
            d3.advanceTowards(doc);
        }
    }

    public void crash() {
        // when 2 daleks crash with each other, they will be set to the "crash" state
        if (d1.getCol() == d2.getCol() && d1.getRow() == d2.getRow()) {
            d1.crash();
            d2.crash();
        }

        if (d3.getCol() == d2.getCol() && d3.getRow() == d2.getRow()) {
            d3.crash();
            d2.crash();
        }

        if (d3.getRow() == d1.getRow() && d3.getCol() == d1.getCol()) {
            d3.crash();
            d1.crash();
        }
    }

    public void rePrint() {

        // reprinting the doctor
        b.putPeg(Color.GREEN, doc.getRow(), doc.getCol());


        // reprinting all 3 daleks in either their regular form or "crashed" depending on their state
        if (d1.hasCrashed() == false) {
            b.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        } else {
            b.putPeg(Color.RED, d1.getRow(), d1.getCol());
        }

        if (d2.hasCrashed() == false) {
            b.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        } else {
            b.putPeg(Color.RED, d2.getRow(), d2.getCol());
        }

        if (d3.hasCrashed() == false) {
            b.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
        } else {
            b.putPeg(Color.RED, d3.getRow(), d3.getCol());
        }

    }

    public void endGame() {
        // if the doctor touches any of the daleks, the game end boolean is turned to true and the dalek are given the victory
        if (doc.getCol() == d1.getCol() && doc.getRow() == d1.getRow() || doc.getCol() == d2.getCol() && doc.getRow() == d2.getRow() || doc.getCol() == d3.getCol() && doc.getRow() == d3.getRow()) {
            isthegameoverfam = true;
            dalekwon = true;
        }

        // if all of the daleks are in a crashed state, then the game is ended and the doctor is given the win
        if (d1.hasCrashed() == true && d2.hasCrashed() == true && d3.hasCrashed() == true) {
            isthegameoverfam = true;
            docwon = true;
        }
    }
}

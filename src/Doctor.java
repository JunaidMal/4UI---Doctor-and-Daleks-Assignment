
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        // setting the inputted row and column as the current one
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        // restricts the movement if it's on the same spot or any right beside it both vertically, horizontally, and diagonally
        if ((newRow == this.row + 1 || newRow == this.row - 1 || newRow == this.row) && (newCol == this.col + 1 || newCol == this.col - 1 || newCol == this.col)) {
            this.row = newRow;
            this.col = newCol;
        } else {
            // if the person didn't click on a spot beside the doctor, they'll teleport to a random place
            this.col = (int) (Math.random() * 12);
            this.row = (int) (Math.random() * 12);
        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        // returns row
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        // returns column
        return this.col;
    }
}

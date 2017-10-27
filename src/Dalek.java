
/**
 * This class models a Delek in the game. A Delek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed = false;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        // initializing row and column variables for dalek
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {

        // If the doctor is above the dalek then advance in that direction
        if (this.row > doc.getRow()) {
            this.row--;
            // if doctor below the dalek then advance in that direction
        } else if (this.row < doc.getRow()) {
            this.row++;
        }
        // If the doctor to the left of the Dalek then advance in that direction
        if (this.col > doc.getCol()) {
            this.col--;
            // If doc is right of the Dalek then advance in that direction
        } else if (this.col < doc.getCol()) {
            this.col++;
        }

        // ^ If the doctor is in a position diagonal to the dalek then the dalek will move like a vector, 1 to the right or left, then 1 up or down


    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        // returns dalek's row
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        // returns dalek's column
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        // makes the crashed state true
        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        // returns whether or not the dalek is in a crashed state or not
        return this.hasCrashed;
    }
}

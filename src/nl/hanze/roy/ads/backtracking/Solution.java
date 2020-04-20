package nl.hanze.roy.ads.backtracking;

import java.util.Stack;

/**
 * the solution is a sequence of cards placed on the board according to the card positions
 * example without border
 */
public class Solution extends Stack<Candidate> {
    private int size = 4;

    // indices of adjacent cards in the solution.
    int[][] check = {{3}, {2}, {1, 3, 4}, {0, 2, 5}, {2, 5}, {3, 4, 6, 7}, {5}, {5}};

    // The board is an 2D array.
    // 0123
    // 0..-.
    // 1---.
    // 2.---
    // 3..-.
    private Candidate[][] board = new Candidate[size][size];

    // card positions on the board
    // the first card position on the board are
    // {0,2}, {1,0}. {1,1}
    private int[] row       = {0, 1, 1, 1, 2, 2, 2, 3};
    private int[] column    = {2, 0, 1, 2, 1, 2, 3, 2};

    /**
     * Checks whether candidate card of same kind.
     * Checks whether by placing candidate the solution sofar still complies with the rules
     *
     * @param candidate
     * @return boolean indicating whether this candidate can be put in the
     * next free position.
     */
    public boolean fits(Candidate candidate) {
        // Determine positions of new cells
        int index = this.size();
        int currRow = row[index];
        int currCol = column[index];

        // If there are no blank cells that border the current cell,
        // Check if the rule of the current card will be met.
        if (amountOfBlankCells(index) == 0) {
            char mustBeAdjacentTo = this.mustBeAdjacentTo(candidate.getCardChar());
            if (mustBeAdjacentTo != '?' && !bordersCard(currRow, currCol, mustBeAdjacentTo)) {
                return false;
            }
        }

        // Retrieve the coordinates of the adjacent cells
        int[] adjacent = this.check[index];

        // For each adjacent cell
        for (int j = 0; j < adjacent.length; j++) {
            // Try to retrieve adjacent card (Candidate)
            int adjRow = this.row[adjacent[j]];
            int adjCol = this.column[adjacent[j]];
            Candidate adjacentCard = board[adjRow][adjCol];

            // If adjacent cell has a card
            if (adjacentCard != null) {
                // Fail if adjacent card has the same sign as the candidate
                if (candidate.getCardChar() == adjacentCard.getCardChar()) {
                    return false;
                }

                // If this card will be the last card that can be placed adjacent to this neighbor.
                // Check if the rule of the adjacent card will be met when this card is placed here.
                if (amountOfBlankCells(adjacent[j]) <= 1) {
                    char mustBeAdjacentTo = this.mustBeAdjacentTo(adjacentCard.getCardChar());

                    // If the rule isn't already met by an other neighbor
                    if (mustBeAdjacentTo != '?' && !bordersCard(adjRow, adjCol, mustBeAdjacentTo)) {
                        // Check if placing this card will complete te rule of the neighbor.
                        if (mustBeAdjacentTo != candidate.getCardChar()) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public void record(Candidate candidate) {
        int i = this.size(); // i= index in this stack of next for the next candidate
        board[row[i]][column[i]] = candidate; //x=row, y=column
        this.push(candidate);
    }

    public boolean complete() {
        return this.size() == 8;
    }

    public void show() {
        System.out.println(this);
    }

    public Candidate eraseRecording() {
        int i = this.size() - 1;           // i= index of the candidate that is removed from this Stack;
        board[row[i]][column[i]] = null; // remove candidate from board
        return this.pop();
    }

    /**
     * Map the given card to the card it should be adjacent to
     *
     * @param card
     * @return
     */
    private char mustBeAdjacentTo(char card) {
        if (card == 'A') return 'H';
        if (card == 'H') return 'V';
        if (card == 'V') return 'B';

        return '?'; // No rule
    }

    /**
     * Amount of blank cells to border the card at the given index
     *
     * @param index
     * @return
     */
    private int amountOfBlankCells(int index) {
        int[] neighbors = this.check[index];
        int totalBlankSpots = 0;

        // Check all neighbors
        for (int j = 0; j < neighbors.length; j++) {
            int neighborRow = row[neighbors[j]];
            int neighborCol = column[neighbors[j]];

            if (board[neighborRow][neighborCol] == null) {
                totalBlankSpots++;
            }
        }

        return totalBlankSpots;
    }

    // Checks whether a candidate with card CardChar is in
    // an adjacent position of the board position (row, column)
    // @param row, column, candidate
    // @return Boolean indicating if cardChar is found.
    // can be used in the methods fits and isCorrect
    private boolean bordersCard(int row, int column, char cardChar) {
        if (row - 1 != -1 && board[row - 1][column] != null && board[row - 1][column].getCardChar() == cardChar) {
            return true;
        }

        if (row + 1 < size && board[row + 1][column] != null && board[row + 1][column].getCardChar() == cardChar) {
            return true;
        }

        if (column -1 != -1 && board[row][column - 1] != null && board[row][column - 1].getCardChar() == cardChar) {
            return true;
        }

        if (column + 1 < size && board[row][column + 1] != null && board[row][column + 1].getCardChar() == cardChar) {
            return true;
        }

        return false;
    }

    /**
     * @return a representation of the solution on the board
     */
    public String toString() {
        StringBuilder output = new StringBuilder();

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                output.append(' ');
                if(board[x][y] == null) {
                    output.append(' ');
                } else {
                    output.append(board[x][y].getCardChar());
                }
                output.append(' ');
            }

            output.append('\n');
        }

        return output.toString();
    }
}

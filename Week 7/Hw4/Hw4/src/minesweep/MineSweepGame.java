package minesweep;

import java.util.Random;

public class MineSweepGame
{
    private static class Cell
    {
        // The cell value is the number of adjacent mines if the cell
        // does not contain a mine, and MINE if it does contain a mine.
        public int value;

        public boolean isShowing;
        public boolean hasFlag; // Is a flag placed on the cell?

        public Cell(int val)
        {
            value = val;
            isShowing = false;
            hasFlag = false;
        }

        public Cell()
        {
            this(0);
        }
    }

    public static final int MINE = -1; // Integer value representing a mine.

    public final int NUM_ROWS;  // Number of rows.
    public final int NUM_COLS;  // Number of columns.
    public final int NUM_MINES; // Total number of mines.

    private final MineSweepUpdatableUI ui; // Reference to the user interface.
    private final Cell[][] cells;
    private int numMinesLeft; // The number of mines left to mark.

    // The number of cells left to show or add a flag to.
    private int numCellsLeft;

    private boolean hasHitMine; // Keep track if player has hit a mine.

    private final Random generator;  // Used for creating random numbers.

    public MineSweepGame(MineSweepUpdatableUI userInterface,
                         int numRows, int numCols, int numMines)
    {
        NUM_ROWS = numRows;
        NUM_COLS = numCols;
        NUM_MINES = numMines;
        ui = userInterface;
        cells = new Cell[numRows][numCols];
        numMinesLeft = numMines;
        numCellsLeft = numRows * numCols;
        hasHitMine = true;
        generator = new Random();
    }

    // number of total mines minus number of flas that have been placed
    public int numMinesRemaining()
    {
        return numMinesLeft;
    }

    public boolean isOver() // is the game over
    {
        return hasHitMine || numCellsLeft == 0;
    }

    public boolean hasWon()
    {
        return numCellsLeft == 0 && !hasHitMine;
    }

    public int cellValue(int row, int col)
    {
        return cells[row][col].value;
    }

    public boolean isCellShowing(int row, int col)
    {
        return cells[row][col].isShowing;
    }

    public boolean isCellFlagged(int row, int col)
    {
        return cells[row][col].hasFlag;
    }

    // seed the internal random number generator before creating a new game
    public void newGame(long seed)
    {
        generator.setSeed(seed);
        newGame();
    }

    public void newGame()
    {
        numMinesLeft = NUM_MINES;
        numCellsLeft = NUM_ROWS * NUM_COLS;
        hasHitMine = false;

        Cell[] newCells = new Cell[NUM_ROWS * NUM_COLS];

        int k = 0; // index in newCells

        // create the cells with the mines
        while (k < NUM_MINES && k < newCells.length)
        {
            newCells[k] = new Cell(MINE);
            k++;
        }

        // create the cells without the mines
        while (k < newCells.length)
        {
            newCells[k] = new Cell();
            k++;
        }

        // uniformly mix newCells
        for (k = newCells.length; k > 1; )
        {
            int r = generator.nextInt(k);
            k--;

            // interchange newCells[r] and newCells[k]
            Cell temp = newCells[k];
            newCells[k] = newCells[r];
            newCells[r] = temp;
        }

        k = 0;

        // place cells into the cells array
        for (int i = 0; i < NUM_ROWS; ++i)
        {
            for (int j = 0; j < NUM_COLS; ++j)
            {
                cells[i][j] = newCells[k];
                k++;
            }
        }

        // TODO: Set the value of all cells that do not contain mines.
        //   The value of a cell is the number of mines adjacent to the cell,
        //   or the value MINE if the cell has a mine on it.
        //   Mines have been randomly placed in the array cells.
        //   The value of all cells that do not have mines on them have been
        //   initialized with a value of 0.
        //   We can get access to the value of the cell at row i and column j
        //   with:
        //      cells[i][j].value
        //   To test if the cell has a mine on it, we test if its value is
        //   equal to MINE:
        //      cells[i][j].value == MINE
        //   What to do:
        //      for each cell that does not have a mine on it, set its
        //      value equal to the number of mines adjacent to the cell.
        //      A mine is adjacent to a cell c if
        //         it is on a cell that shares a side with c, or
        //         it is on a cell that touches a corner of c.
        //   Use NUM_ROWS and NUM_COLS for the number of rows and columns
        //   in the game respectively. Do NOT use magic numbers.


        for (int i = 0; i < NUM_ROWS; i++)
        {
            int c = 0;
            for (int j = 0; j < NUM_COLS; j++)
            {
                if (cells[i][j].value != MINE)
                {
                    // Verify cell above is a valid cell.
                    if (i >= 1)
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i - 1][j].value == MINE) c++;
                    }

                    // Check to see if cell below is a valid cell
                    if (i < (NUM_ROWS - 1))
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i + 1][j].value == MINE) c++;
                    }

                    // Verify cell to the left is a valid cell.
                    if (j >= 1)
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i][j - 1].value == MINE) c++;
                    }

                    // Verify cell to the right is a valid cell
                    if (j < (NUM_COLS - 1))
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i][j + 1].value == MINE) c++;
                    }

                    // Verify cell to the upper left is a valid cell
                    if (i >= 1 && j >= 1)
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i - 1][j - 1].value == MINE) c++;
                    }

                    // Verify cell to the upper right is a valid cell
                    if (i >= 1 && j < (NUM_COLS - 1))
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i - 1][j + 1].value == MINE) c++;
                    }

                    // Verify cell to the lower left is a valid cell
                    if (i < (NUM_ROWS - 1) && j >= 1)
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i + 1][j - 1].value == MINE) c++;
                    }

                    // Verify cell to the lower right is a valid cell
                    if (i < (NUM_ROWS - 1) && j < (NUM_COLS - 1))
                    {
                        // Check value of the cell and increment c if cell value is a mine.
                        if (cells[i + 1][j + 1].value == MINE) c++;
                    }

                    // Update value of cell with count c
                    cells[i][j].value = c;
                    c = 0; // reset c to zero for the next loop
                }
            }
        }


        // TODO: FOR TESTING PURPOSES ONLY!
        //   Uncomment the lines below to show all cells.
        //   When you are done testing, recomment the lines.
        /*
        for (int i = 0; i < NUM_ROWS; ++i)
        {
            for (int j = 0; j < NUM_COLS; ++j)
            {
                cells[i][j].isShowing = true;
                ui.updateCell(i, j);
            }
        }
        // END OF TESTING CODE
        */
    }


    public void toggleFlag(int row, int col)
    {
        if (isCellShowing(row, col) || isOver()) return;

        if (isCellFlagged(row, col))
        {
            // unflag cell
            cells[row][col].hasFlag = false;
            numMinesLeft++;
            numCellsLeft++;
        } else if (numMinesLeft > 0)
        {
            // flag cell
            cells[row][col].hasFlag = true;
            numMinesLeft--;
            numCellsLeft--;
        }

        ui.updateCell(row, col);
    }

    public void flagCell(int row, int col)
    {
        if (numMinesLeft <= 0 || isCellShowing(row, col) ||
                isOver() || isCellFlagged(row, col))
        {
            return;
        }

        cells[row][col].hasFlag = true;
        numMinesLeft--;
        numCellsLeft--;
        ui.updateCell(row, col);
    }

    public void unflagCell(int row, int col)
    {
        if (isCellShowing(row, col) || isOver() || !isCellFlagged(row, col))
        {
            return;
        }

        cells[row][col].hasFlag = false;
        numMinesLeft++;
        numCellsLeft++;
        ui.updateCell(row, col);
    }

    // Show the cell (i.e., user click on cell to show it).
    // If the value of the cell is 0 (i.e., it has no adjacent mines),
    // then recursively show each of its adjacent cells.
    public void showCell(int row, int col)
    {
        // TODO: If the cell at the given row and col has a flag or
        //   the game is over, then do nothing.
        //   Otherwise, show the cell.
        //   To test if the cell has a flag on it, call:
        //      isCellFlagged(row, col)
        //   To test if the game is over, call:
        //      isOver();
        //   To mark the cell as shown, write:
        //      cells[row][col].isShowing = true;
        //   This only marks the cell as shown. It does not update the user
        //   interface to show the cell on the screen. To notify the user
        //   interface of this update, write:
        //      ui.updateCell(row, col);
        //   The value of a cell is the number of mines adjacent to the cell,
        //   or the value MINE if the cell has a mine on it.
        //   These values are already computed for us when a new game begins.
        //   To get the value of the cell, write:
        //      cells[row][col].value
        //   To test if the cell has a mine on it, we can use the test:
        //      cells[row][col].value == MINE
        //   If the cell has a mine on it, then set the class variable
        //   hasHitMine to true:
        //      hasHitMine = true;
        //   Otherwise, if the cell does not have a mine on it, then
        //   decrement the class variable numCellsLeft by 1:
        //      numCellsLeft--;
        //   If the value of the cell is 0, then recursively
        //   show all of its adjacent cells so that the whole connected
        //   region of cells with value 0 is shown along with the non-zero
        //   numbered cells adjacent to this region.
        //   For example, if the cell at row i and column j is an
        //   adjacent cell, we can call:
        //      showCell(i, j);
        //   Use NUM_ROWS and NUM_COLS for the number of rows and columns
        //   in the game respectively. Do NOT use magic numbers.
        if (!isCellFlagged(row, col) && !isOver())
        {
            cells[row][col].isShowing = true;
            ui.updateCell(row, col);

            if (cells[row][col].value == MINE)
            {
                hasHitMine = true;
            } else
            {
                numCellsLeft--;
            }

            if (cells[row][col].value == 0)
            {
                if (row >= 1)
                {
                    if (!cells[row - 1][col].isShowing)
                    {
                        showCell(row - 1, col);
                    }
                }

                if (row < (NUM_ROWS - 1))
                {
                    if (!cells[row + 1][col].isShowing)
                    {
                        showCell(row + 1, col);
                    }
                }

                if (col >= 1)
                {
                    if (!cells[row][col - 1].isShowing)
                    {
                        showCell(row, col - 1);
                    }
                }

                if (col < (NUM_COLS - 1))
                {
                    if (!cells[row][col + 1].isShowing)
                    {
                        showCell(row, col + 1);
                    }
                }

                if (col >= 1 && row >= 1)
                {
                    if (!cells[row - 1][col - 1].isShowing)
                    {
                        showCell(row - 1, col - 1);
                    }
                }

            }
        }
    }
}
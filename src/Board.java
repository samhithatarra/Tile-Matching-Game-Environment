import java.util.ArrayList;

public class Board<T>
{
    private int height;
    private int width;
    private ArrayList<ArrayList<Tile<T>>> boardArray;
    private State<T> gameState;

    public Board(int height, int width, int totalPlayers)
    {
        this.height = height;
        this.width = width;
        
        // initialize a board the size of height x width nulls
        // replace null with Tile when making move
        boardArray = new ArrayList<>();
        for(int row = 0; row < height; row++)
        {
            ArrayList<Tile<T>> currentRow = new ArrayList<>(); // row of tiles
            for(int col = 0; col < width; col++)
            {
                currentRow.add(null); // add empty tile to row
            }
            boardArray.add(currentRow);
        }
        gameState = new State<>(totalPlayers);
    }

    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }

    public ArrayList<ArrayList<Tile<T>>> getBoard()
    {
        return boardArray;
    }

    public boolean isValidColumn(int col)
    {
        return (0 <= col && col < width);
    }

    public boolean isValidRow(int row)
    {
        return (0 <= row && row < height);
    }

    // Update the board if the given row and column are within 
    // bounds and if the given coordinates on the board are not occupied.
    public void updateBoard(T value, int row, int col)
    {
        if(isValidRow(row) && isValidColumn(col) &&
           boardArray.get(row).get(col) == null)
        {
            boardArray.get(row).set(col, new Tile<T>(value, row, col));
            gameState.nextTurn();
        }
    }

    public boolean checkWin()
    {
        return gameState.checkWin(this);
    }

    public void nextTurn()
    {
        gameState.nextTurn();
    }
    public int getTurn()
    {
        return gameState.getTurn();
    }

    // Prints the board to console
    // If a tile has a value, print the value in the appropriate row and column
    // If a tile has no value, print '.' in the appropriate row and column
    public void printBoard()
    {
        for(int row = 0; row < height; row++)
        {
            for(int col = 0; col < width; col++)
            {
                Tile<T> currentTile = boardArray.get(row).get(col);
                // if tile has no value, print '.'
                if(currentTile == null)
                {
                    System.out.print(" . ");
                }
                else
                {
                    System.out.print(" " + currentTile.getValue() + " ");
                }
            }
            System.out.println();
        }
        // print column numbers
        for(int i = 1; i <= width; i++)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
}
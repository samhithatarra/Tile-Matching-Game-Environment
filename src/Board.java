import java.util.ArrayList;

public class Board
{
    private int height;
    private int width;
    private ArrayList<ArrayList<Tile>> boardArray;
    private State gameState;

    public Board(int height, int width, int totalPlayers)
    {
        this.height = height;
        this.width = width;
        
        // initialize an empty board of size height x width
        boardArray = new ArrayList<>();
        for(int row = 0; row < height; row++)
        {
            ArrayList<Tile> currentRow = new ArrayList<>(); // row of tiles
            for(int col = 0; col < width; col++)
            {
                currentRow.add(new Tile(null, row, col)); // add empty tile to row
            }
            boardArray.add(currentRow);
        }
        gameState = new State(totalPlayers);
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

    public ArrayList<ArrayList<Tile>> getBoard()
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

    public void updateBoard()
    {
        //
    }

    // TODO: change return type so that it returns the winner, if any
    public boolean checkWin()
    {
        return gameState.checkWin(this);
    }

    public void printBoard()
    {
        // overridden by in child clas
    }
}
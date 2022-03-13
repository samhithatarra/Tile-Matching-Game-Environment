import java.util.ArrayList;

public class Connect4Board extends Board
{
    public Connect4Board()
    {
        // most commonly used board size is 6 rows x 7 columns with 2 players
        super(6, 7, 2);
    }
    public Connect4Board(int height, int width, int totalPlayers)
    {
        super(height, width, totalPlayers);
    }

    // Prints the board to console
    // If a tile has a value, print the value in the appropriate row and column
    // If a tile has no value, print '.' in the appropriate row and column
    @Override
    public void printBoard()
    {
        ArrayList<ArrayList<Tile>> boardArray = super.getBoard();
        for(int row = 0; row < super.getHeight(); row++)
        {
            for(int col = 0; col < super.getWidth(); col++)
            {
                Tile currentTile = boardArray.get(row).get(col);
                // if tile has no value, print '.'
                if(currentTile.getValue() == null)
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
        for(int i = 1; i <= super.getWidth(); i++)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
}
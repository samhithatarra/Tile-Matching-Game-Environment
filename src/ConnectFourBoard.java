import java.util.ArrayList;

public class ConnectFourBoard<T> extends Board<T>
{
    private ConnectFourState<T> connect4GameState;

    public ConnectFourBoard()
    {
        // most commonly used board size is 6 rows x 7 columns with 2 players
        super(6, 7, 2);
        connect4GameState = new ConnectFourState<>(2);
    }
    
    public ConnectFourBoard(int height, int width, int totalPlayers)
    {
        super(height, width, totalPlayers);
        connect4GameState = new ConnectFourState<>(totalPlayers);
    }

    public void drop(T value, int col)
    {
        super.updateBoard(value, getBottomEmptyRow(col - 1), col - 1);
    }

    @Override
    public boolean checkWin()
    {
        return connect4GameState.checkWin(this);
    }

    // Gets the bottommost row that is empty within a specified column, for
    // example this would be used if a user tries to drop a tile. 
    // If the column is already full this would return -1
    // otherwise if valid it would return the row index
    public int getBottomEmptyRow(int col)
    {
        int totalRows = super.getHeight();
        ArrayList<ArrayList<Tile<T>>> board = super.getBoard();
        for (int i = totalRows - 1; i >= 0; i--)
        {
            if (board.get(i).get(col) == null)
            {
                return i;
            }
        }
        return -1;
    }
}
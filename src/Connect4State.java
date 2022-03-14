import java.util.ArrayList;

public class Connect4State<T> extends State<T>
{
    public Connect4State(int totalPlayers)
    {
        super(totalPlayers);   
    }

    // Overrides parent function to also check diagonals.
    // Return true if a winning sequence of tiles appears on the 
    // board beginning at the given row and column and extending 
    // right, right-diagonal-down, down, left-diagonal-down, 
    // left, left-diagonal-up, up, right-diagonal-up.
    // Return false otherwise
    @Override
    public boolean isWinningSequence(Board<T> board, int row, int col)
    {
        return winningSequenceDirection(board, row, col, 0, 1) ||
               winningSequenceDirection(board, row, col, 1, 1) ||
               winningSequenceDirection(board, row, col, 1, 0) ||
               winningSequenceDirection(board, row, col, 1,-1) || 
               winningSequenceDirection(board, row, col, 0,-1) ||
               winningSequenceDirection(board, row, col,-1,-1) ||
               winningSequenceDirection(board, row, col,-1, 0) ||
               winningSequenceDirection(board, row, col,-1, 1);
    }

    
    // Overrides parent function to check the next 4 tiles
    // Return true if a winning sequence of tiles appears on the board beginning
    // at the given row and column and extending in the direction specified by rowDir and colDir.
    // Return false otherwise
    @Override
    public boolean winningSequenceDirection(Board<T> board, int row, int col, int rowDir, int colDir)
    {
        ArrayList<ArrayList<Tile<T>>> boardArray = board.getBoard();
        Tile<T> currentTile = boardArray.get(row).get(col);

        // return false if the tile at the given row and column has no value
        if (currentTile == null)
        {
            return false;
        }
        else
        {
            for (int i = 1; i < 4; i++)
            {
                if (!board.isValidRow(row + rowDir * i) || 
                    !board.isValidColumn(col + colDir * i) || 
                    boardArray.get(row + rowDir * i).get(col + colDir * i) == null)
                {
                    return false;
                }
                else if(boardArray.get(row + rowDir * i).get(col + colDir * i).getValue() != currentTile.getValue())
                {
                    return false;
                }
            }
            return true;
        }
    }
}

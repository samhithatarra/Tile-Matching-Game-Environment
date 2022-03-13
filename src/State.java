import java.util.ArrayList;

public class State
{
    private int turn;
    private int totalPlayers;
    
    public State(int totalPlayers)
    {
        this.totalPlayers = totalPlayers;
        turn = 1;
    }

    public int nextTurn()
    {
        turn++;
        if (turn > totalPlayers)
        {
            turn = 1;
        }
        return turn;
    }
    
    // Return true if there is a winner at the current state.
    // Return false otherwise
    // TODO: change return type so that it returns the winner, if any
    public boolean checkWin(Board board)
    {
        ArrayList<ArrayList<Tile>> boardArray = board.getBoard();
        for (int row = 0; row < boardArray.size(); row++)
        {
            for (int col = 0; col < boardArray.size(); col++)
            {
                if (isWinningSequence(board, row, col))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // Return true if a winning sequence of tiles appears on the board beginning 
    // at the given row and column and extending left, right, down, or up. 
    // Return false otherwise
    public boolean isWinningSequence(Board board, int row, int col)
    {
        return winningSequenceDirection(board, row, col, 0, 1) || 
               winningSequenceDirection(board, row, col, 0,-1) || 
               winningSequenceDirection(board, row, col, 1, 0) ||
               winningSequenceDirection(board, row, col,-1, 0);
    }

    // Return true if a winning sequence of tiles appears on the board beginning
    // at the given row and column and extending in the direction specified by rowDir and colDir.
    // Return false otherwise
    public boolean winningSequenceDirection(Board board, int row, int col, int rowDir, int colDir)
    {
        ArrayList<ArrayList<Tile>> boardArray = board.getBoard();
        Tile currentTile = boardArray.get(row).get(col);

        // return false if the tile at the given row and column has no value
        if (currentTile.getValue() == null)
        {
            return false;
        }
        else
        {
            // Connect 4:
            // - check the next 3 tiles in the given direction
            // - there is a winning sequence if the next 3 tiles are valid and has the same value as the currentTile
            // TODO: replace the hardcoded 4 with another value
            //       maybe have an attribute in State that stores the minimum number needed to have a winning sequence
            for (int i = 1; i < 4; i++)
            {
                if (!board.isValidRow(row + rowDir * i) ||
                    !board.isValidColumn(col + colDir * i) ||  
                    boardArray.get(row + rowDir * i).get(col + colDir * i).getValue() != currentTile.getValue())
                {
                    return false;
                }
            }
            return true;
        }
    }
}
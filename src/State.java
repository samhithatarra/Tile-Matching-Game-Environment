import java.util.ArrayList;

public class State<T>
{
    private int turn;
    private int totalPlayers;
    
    public State(int totalPlayers)
    {
        this.totalPlayers = totalPlayers;
        turn = 1;
    }

    public void nextTurn()
    {
        turn++;
        if (turn > totalPlayers)
        {
            turn = 1;
        }
    }

    public int getTurn()
    {
        return turn;
    }
    
    // Return true if there is a winner at the current state.
    // Return false otherwise
    public boolean checkWin(Board<T> board)
    {
        ArrayList<ArrayList<Tile<T>>> boardArray = board.getBoard();
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
    public boolean isWinningSequence(Board<T> board, int row, int col)
    {
        return winningSequenceDirection(board, row, col, 0, 1) || 
               winningSequenceDirection(board, row, col, 0,-1) || 
               winningSequenceDirection(board, row, col, 1, 0) ||
               winningSequenceDirection(board, row, col,-1, 0);
    }

    // Return true if a winning sequence of tiles appears on the board beginning
    // at the given row and column and extending in the direction specified by rowDir and colDir.
    // Return false otherwise
    public boolean winningSequenceDirection(Board<T> board, int row, int col, int rowDir, int colDir)
    {
        return false;
    }
}
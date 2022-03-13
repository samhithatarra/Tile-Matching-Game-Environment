public class Connect4State extends State
{
    public Connect4State(int totalPlayers)
    {
        super(totalPlayers);   
    }

    // Overrides parent function to also check diagonals.
    // 
    // Return true if a winning sequence of tiles appears on the 
    // board beginning at the given row and column and extending 
    // right, right-diagonal-down, down, left-diagonal-down, 
    // left, left-diagonal-up, up, right-diagonal-up.
    // Return false otherwise
    @Override
    public boolean isWinningSequence(Board board, int row, int col)
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
}

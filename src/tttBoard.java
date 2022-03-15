
import java.util.ArrayList;

public class tttBoard<T> extends Board<T>{
    private tttState<T> tttGameState;
    
    public tttBoard()
    {
        // most commonly used board size is 6 rows x 7 columns with 2 players
        super(3, 3, 2);
        tttGameState = new tttState<>(2);
    }

    public tttBoard(int height, int width, int totalPlayers)
    {
        super(height, width, totalPlayers);
        
        tttGameState = new tttState<>(totalPlayers);
    }

    @Override
    public boolean checkWin()
    {
        return tttGameState.checkWin(this);
    }

    @Override
    public void updateBoard(T value, int row, int col){
        super.updateBoard(value, row, col);
        
        super.getBoard().get(row).set(col, new Tile<T>(value, row, col));
        // super.getBoard().get(row).set(col, new Tile<String> (value,row,col));
        
        printBoard();

        if (tttGameState.isWinningSequence(this,row,col) == false){
            tttGameState.fullBoardTicTacToe(this);
        }
        

        //printPlayerCount();

       

        
    }

    public void printBoard()
    {
        ArrayList<ArrayList<Tile<T>>> boardArr = super.getBoard();

        String boardString = "";

        for (int row = 0; row < boardArr.size(); row++) {
    
            boardString += "\n";
    
            for (int col = 0; col < boardArr.get(0).size(); col++) {
                if (boardArr.get(row).get(col) == null){
                    boardString += "_";
                }
                else{
                    boardString += boardArr.get(row).get(col).getValue();
                }
                
                boardString += " ";
            }
        }
        System.out.println(boardString);
    } 
}
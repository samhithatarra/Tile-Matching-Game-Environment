import java.util.ArrayList;

public class tttState<T> extends State<T>{

    Controller ctrl;
    ArrayList<ArrayList<Tile<T>>> boardArr;

    public tttState(int totalPlayers)
    {
        super(totalPlayers); 
        ctrl = new Controller();  
    }

    @Override
    public boolean isWinningSequence(Board<T> board, int rowInp, int colInp)
    {
        boardArr = board.getBoard();

        boolean win = false;

        // check horizontals
        for (int row = 0; row < boardArr.size(); row++) {
            // System.out.print(obj);

            // check adjacents are same starting with 1st col (index 0)
            if (boardArr.get(row).get(1) != null && boardArr.get(row).get(0) != null && boardArr.get(row).get(2) != null) {
                
        
                if (boardArr.get(row).get(0).getValue() == boardArr.get(row).get(1).getValue()) {
                    if (boardArr.get(row).get(1).getValue() == boardArr.get(row).get(2).getValue()) {

                        if (boardArr.get(row).get(0).getValue() == "X") {
                            System.out.println("Player X wins!");
                            System.exit(0);
                        } else {
                            System.out.println("Player O wins!");
                            System.exit(0);
                        }
                        win = true;

                        boardArr.get(row).set(0, null);
                        boardArr.get(row).set(1, null);
                        boardArr.get(row).set(2, null);
                     
                        return win;
                    }
                }
            }
        }

        // check verticals (cols)
        for (int col = 0; col < boardArr.size(); col++) {
            // check adjacents are same starting with 1st row (index 0)
            if (boardArr.get(1).get(col) !=  null && boardArr.get(0).get(col) !=  null  && boardArr.get(2).get(col) !=  null) {

                if (boardArr.get(0).get(col).getValue() == boardArr.get(1).get(col).getValue()) {
                    if (boardArr.get(1).get(col).getValue() == boardArr.get(2).get(col).getValue()) {

                        if (boardArr.get(0).get(col).getValue() == "X") {
                            System.out.println("Player X wins!");
                            System.exit(0);
                        } else {
                            System.out.println("Player O wins!");
                            System.exit(0);

                        }
                        win = true;


                        boardArr.get(0).set(col, null);
                        boardArr.get(1).set(col, null);
                        boardArr.get(2).set(col, null);

                        return win;
                    }
                }
            }
        }

        // check diagonals
        // from top left to bottom right
        if (boardArr.get(1).get(1) !=  null && boardArr.get(0).get(0) !=  null && boardArr.get(2).get(2) !=  null) {
            if (boardArr.get(0).get(0).getValue() == boardArr.get(1).get(1).getValue()) {
                if (boardArr.get(1).get(1).getValue() == boardArr.get(2).get(2).getValue()) {

                    if (boardArr.get(0).get(0).getValue() == "X") {
                        System.out.println("Player X wins!");
                        System.exit(0);
                    } 
                    else {
                        System.out.println("Player O wins!");
                        System.exit(0);
                    }
                    win = true;

                    boardArr.get(0).set(0, null);
                    boardArr.get(1).set(1, null);
                    boardArr.get(2).set(2, null);

                    // boardArr.get(0).get(0).setValue("_");
                    // boardArr.get(1).get(1).setValue("_");
                    // boardArr.get(2).get(2).setValue("_");

                    return win;
                }
            }
        }

        // from bottom left to top right
        if (boardArr.get(2).get(0) != null && boardArr.get(1).get(1) != null && boardArr.get(0).get(2) != null) {
            if (boardArr.get(2).get(0).getValue() == boardArr.get(1).get(1).getValue()) {
                if (boardArr.get(1).get(1).getValue() == boardArr.get(0).get(2).getValue()) {

                    if (boardArr.get(2).get(0).getValue() == "X") {
                        System.out.println("Player X wins!");
                        System.exit(0);

                    } else {
                        System.out.println("Player O wins!");
                        System.exit(0);

                    }
                    win = true;

                    boardArr.get(2).set(0, null); 
                    boardArr.get(1).set(1, null);
                    boardArr.get(0).set(2, null);

                    return win;
                }
            }
        }
        return win;
    }

    // checks for tie game if board is full
    public boolean fullBoardTicTacToe(Board<T> board) {
        for (int row = 0; row < boardArr.size(); row++) {
            for (int col = 0; col < boardArr.get(0).size(); col++) {
                if (boardArr.get(row).get(col) == null) {
                    return false;
                }
            }
        }
        System.out.println("Tie game!");
        System.exit(0);  
        return true;
    }
}
public class Board{

    // row, col
    Tile[][] boardArr;
    static final int ROW = 3;
    static final int COL = 3;

    public Board(){
        boardArr = new Tile[ROW][COL];
    }

    // can also be used to reset board?
    public void createBoard(GameType gType){

        // BATTLESHIP        
        // if(gType ==  GameType.BATTLESHIP){
        //     for(int row = 0; row < boardArr.length; row++){
        //         for(int col = 0; col < boardArr[0].length; col++){
    
        //             // boardArr[row][col].column = col;
        //             // boardArr[row][col].row = row;
        //             // boardArr[row][col].value = "0";                    
        //         }
        //     }
        // }

        // TIC TAC TOE
        if (gType ==  GameType.TICTACTOE){
            for(int row = 0; row < boardArr.length; row++){
                for(int col = 0; col < boardArr[0].length; col++){
                    
                    boardArr[row][col] = new Tile();
                    Tile tile = boardArr[row][col];
                    tile.column = col;
                    tile.row = row;
                    tile.value = "_";
                }
            }
        }
    }

    // via terminal
    public void displayBoard(GameType gType){
        if(gType ==  GameType.TICTACTOE){
            String boardString = "";

            for(int row = 0; row < boardArr.length; row++){

                boardString += "\n";

                for(int col = 0; col < boardArr[0].length; col++){
                    boardString += boardArr[row][col].value;
                    boardString += " ";
                }
            }
            System.out.println(boardString);
        }
    }

    public boolean checkWin(Tile[][] boardArr){
        Tile tile = new Tile();
        boolean win = false;

        // check horizontals (row)
        for(int row = 0; row < boardArr.length-1; row++){

            // check adjacents are same starting with 1st col (index 0)
            if(boardArr[row][0] == boardArr[row][1]){
                if(boardArr[row][1] == boardArr[row][2]){
                    tile.value = boardArr[row][0].toString();

                    if(tile.value == "X"){
                        win = true;
                        System.out.println("Player 1 wins!");
                    }
                    else
                    {
                        win = true;
                        System.out.println("Player 2 wins!");
                    }
                }
            }
        }

        // check verticals (cols)
        for(int col = 0; col < boardArr.length-1; col++){
            // check adjacents are same starting with 1st row (index 0)
            if(boardArr[0][col] == boardArr[1][col]){
                if(boardArr[1][col] == boardArr[2][col]){
                    tile.value = boardArr[0][col].toString();

                    if(tile.value == "X"){
                        win = true;
                        System.out.println("Player 1 wins!");
                    }
                    else
                    {
                        win = true;
                        System.out.println("Player 2 wins!");
                    }
                }
            }
        }

        // check diagonals
        // from top left to bottom right
        if(boardArr[0][0] == boardArr[1][1]){
            if(boardArr[1][1] == boardArr[2][2]){
                tile.value = boardArr[0][0].toString();

                if(tile.value == "X"){
                    System.out.println("Player 1 wins!");
                }
                else
                {
                    System.out.println("Player 2 wins!");
                }
            }
        }

        // from bottom left to top right
        if(boardArr[2][0] == boardArr[1][1]){
            if(boardArr[1][1] == boardArr[0][2]){
                tile.value = boardArr[2][0].toString();

                if(tile.value == "X"){
                    System.out.println("Player 1 wins!");
                }
                else
                {
                    System.out.println("Player 2 wins!");
                }
            }
        }

        return win;
    }

    // check if tie game
    public boolean fullBoard(Tile[][] boardArr){

        for(int row = 0; row < boardArr.length; row++) {
			for(int col = 0; col < boardArr[0].length; col++) {
				if(boardArr[row][col].toString() == "_") {
					return false;
				}
			}
		}        
        return true;
    }
}
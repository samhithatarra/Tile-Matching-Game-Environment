public class Board {
    Tile[][] boardArr;
    static final int ROW = 3;
    static final int COL = 3;
    int playerXCounter = 0;
    int playerOCounter = 0;

    public Board() {
        boardArr = new Tile[ROW][COL];
    }

    public void createBoard(GameType gType) {

        // BATTLESHIP
        // if(gType == GameType.BATTLESHIP){
        // for(int row = 0; row < boardArr.length; row++){
        // for(int col = 0; col < boardArr[0].length; col++){

        // // boardArr[row][col].column = col;
        // // boardArr[row][col].row = row;
        // // boardArr[row][col].value = "0";
        // }
        // }
        // }

        // TIC TAC TOE
        if (gType == GameType.TICTACTOE) {
            for (int row = 0; row < boardArr.length; row++) {
                for (int col = 0; col < boardArr[0].length; col++) {

                    boardArr[row][col] = new Tile();
                    Tile tile = boardArr[row][col];
                    tile.column = col;
                    tile.row = row;
                    tile.value = "_";
                }
            }
        }
    }

    // prints updated board
    public void updateBoard(Tile move, GameType gType) {
        boardArr[move.row][move.column].value = move.value;
        displayBoard(GameType.TICTACTOE);

        // TICTACTOE GAMETYPE CHECKING WIN EACH TIME
        if (gType == GameType.TICTACTOE) {
            checkWinTicTacToe(boardArr);
            if (playerXCounter == 1) {
                System.out.println("Player X got a win try to get one more!!");
                displayBoard(gType);
            }
            if (playerOCounter == 1) {
                System.out.println("Player O got a win try to get one more!!");
                displayBoard(gType);
            }
            if (playerXCounter == 2) {
                System.out.println("Player X got two wins they win!!");
                System.exit(0);
            }
            if (playerOCounter == 2) {
                System.out.println("Player O got two wins they win!!");
                System.exit(0);
            }
        }

        // BATTELESHIP GAMETYPE CHECKING WIN EACH TIME TO BE COMPLETED

    }

    public void displayBoard(GameType gType) {

        // TICTACTOE GAMETYPE DISPLAY BOARD
        if (gType == GameType.TICTACTOE) {
            String boardString = "";

            for (int row = 0; row < boardArr.length; row++) {

                boardString += "\n";

                for (int col = 0; col < boardArr[0].length; col++) {
                    boardString += boardArr[row][col].value;
                    boardString += " ";
                }
            }
            System.out.println(boardString);
        }
    }


    // TICTACTOE GAMETYPE SPECIFIC FUNCTION TO CHECK WIN/LOGIC
    public boolean checkWinTicTacToe(Tile[][] boardArr) {
        boolean win = false;

        // check horizontals
        for (int row = 0; row < boardArr.length - 1; row++) {

            // check adjacents are same starting with 1st col (index 0)
            if (boardArr[row][1].value != "_") {
                if (boardArr[row][0].value == boardArr[row][1].value) {
                    if (boardArr[row][1].value == boardArr[row][2].value) {

                        if (boardArr[row][0].value == "X") {
                            System.out.println("Player 1 wins!");
                            playerXCounter++;
                        } else {
                            System.out.println("Player 2 wins!");
                            playerOCounter++;
                        }
                        win = true;

                        boardArr[row][0].value = "_";
                        boardArr[row][1].value = "_";
                        boardArr[row][2].value = "_";

                        return win;
                    }
                }
            }
        }

        // check verticals (cols)
        for (int col = 0; col < boardArr.length - 1; col++) {
            // check adjacents are same starting with 1st row (index 0)
            if (boardArr[1][col].value != "_") {
                if (boardArr[0][col].value == boardArr[1][col].value) {
                    if (boardArr[1][col].value == boardArr[2][col].value) {

                        if (boardArr[0][col].value == "X") {
                            System.out.println("Player 1 wins!");
                            playerXCounter++;
                        } else {
                            System.out.println("Player 2 wins!");
                            playerOCounter++;
                        }
                        win = true;

                        boardArr[0][col].value = "_";
                        boardArr[1][col].value = "_";
                        boardArr[2][col].value = "_";

                        return win;
                    }
                }
            }
        }

        // check diagonals
        // for(int col = 0; col < boardArr.length-1; col++){
        // from top left to bottom right
        if (boardArr[1][1].value != "_") {
            if (boardArr[0][0].value == boardArr[1][1].value) {
                if (boardArr[1][1].value == boardArr[2][2].value) {

                    if (boardArr[0][0].value == "X") {
                        System.out.println("Player 1 wins!");
                        playerXCounter++;
                    } else {
                        System.out.println("Player 2 wins!");
                        playerOCounter++;
                    }
                    win = true;

                    boardArr[0][0].value = "_";
                    boardArr[1][1].value = "_";
                    boardArr[2][2].value = "_";

                    return win;
                }
            }
        }

        // from bottom left to top right
        if (boardArr[1][1].value != "_") {
            if (boardArr[2][0].value == boardArr[1][1].value) {
                if (boardArr[1][1].value == boardArr[0][2].value) {

                    if (boardArr[2][0].value == "X") {
                        System.out.println("Player 1 wins!");
                        playerXCounter++;
                    } else {
                        System.out.println("Player 2 wins!");
                        playerOCounter++;
                    }
                    win = true;

                    boardArr[2][0].value = "_";
                    boardArr[1][1].value = "_";
                    boardArr[0][2].value = "_";

                    return win;
                }
            }
        }
        return win;

    }

    // TICTACTOE GAMETYPE SPECIFIC FUNCTION TO CHECK FOR TIE
    public boolean fullBoardTicTacToe(Tile[][] boardArr) {

        for (int row = 0; row < boardArr.length; row++) {
            for (int col = 0; col < boardArr[0].length; col++) {
                if (boardArr[row][col].value == "_") {

                    return false;
                }
            }
        }
        return true;
    }
}
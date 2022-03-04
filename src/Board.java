public class Board{

    // row, col
    Tile[][] boardArr;

    public Board(){
        boardArr = new Tile[8][8];
    }

    public void createBoard(GameType gType){
        if (gType ==  GameType.BATTLESHIP){
            for(int row = 0; row < boardArr.length; row++){
                for(int col = 0; col < boardArr[0].length; col++){
    
                    // boardArr[row][col].column = col;
                    // boardArr[row][col].row = row;
                    // boardArr[row][col].value = "0";
                    
                }
            }
        }
        if (gType ==  GameType.TICTACTOE){
            for(int row = 0; row < boardArr.length; row++){
                for(int col = 0; col < boardArr[0].length; col++){
                    
                    boardArr[row][col] = new Tile();
                    Tile tile = boardArr[row][col];
                    tile.column = col;
                    tile.row = row;
                    tile.value = "0";


                }
            }
        }
    }

    // via terminal
    public void displayBoard(GameType gType){
        if(gType ==  GameType.TICTACTOE){
            String boardString = "";

            for(int row = 0; row < boardArr.length; row++){
                boardString+="\n";
                for(int col = 0; col < boardArr[0].length; col++){
                    boardString+=boardArr[row][col].value;
                    boardString += " ";
    
                }
            }
            System.out.println(boardString);
        }
        

    }

    // Board updateBoard(){

        
      
        
    // }

    public void resetBoard(GameType gType){
        if(gType ==  GameType.TICTACTOE){
            for(int row = 0; row < boardArr.length; row++){
                for(int col = 0; col < boardArr[0].length; col++){
                    // TO DO: clear space on board
                }
            }
        }
    }

    



}
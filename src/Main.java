import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // To test board
        Board boardObj = new Board();
        boolean gameFin = false; // don't need this if we have a checkWinner function
        int turn = 0;   // 0 reps player 1's turn, 1 reps player 2's turn

        // User input
        Scanner input = new Scanner(System.in);


        // TIC TAC TOE LOGIC
        System.out.println("~ TIC TAC TOE ~");
        System.out.println();
        System.out.println("Player 1's game piece will be: X");
		System.out.println("Player 2's game piece will be: O");
        boardObj.createBoard(GameType.TICTACTOE);
        while(!gameFin){

            // player 1's turn
            if(turn == 0){
                System.out.println("Player 1's turn (X): ");
                System.out.println("Enter the row you want to make your move in (start at 0)");
                int rowInput = input.nextInt();
                
                System.out.println("Enter the column you want to make your move in (start at 0)");
                int colInput = input.nextInt();
                
                Tile<String> move1 = new Tile<String>("X", rowInput, colInput);
                boardObj.updateBoard(move1, GameType.TICTACTOE);
                turn = 1;
            }
            else{    // player 2's turn
                System.out.println("Player 2's turn (O): ");
                System.out.println("Enter the row you want to make your move in (start at 0)");

               // if(input.nextInt() ){
                    int rowInput = input.nextInt();
                //}
                
                System.out.println("Enter the column you want to make your move in (start at 0)");
                int colInput = input.nextInt();
                
                Tile<String> move2 = new Tile<String>("O", rowInput, colInput);
                boardObj.updateBoard(move2, GameType.TICTACTOE);
                turn = 0;
            } 
       }
    }
}

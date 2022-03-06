import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // To test board
        Board boardObj = new Board();
        boolean gameFin = false;
        int turn = 0;   // 0 reps player 1's turn, 1 reps palyer 2's turn

        // User input
        //Scanner input = new Scanner(System.in);


        // TIC TAC TOE LOGIC
        System.out.println("~ TIC TAC TOE ~");
        System.out.println();
        System.out.println("Player 1's game piece will be: X");
		System.out.println("Player 2's game piece will be: O");

        while(!gameFin){
            boardObj.createBoard(GameType.TICTACTOE);
            boardObj.displayBoard(GameType.TICTACTOE);

            // player 1's turn
            if(turn == 0){
                System.out.println("Player 1's turn (X): ");
            }
            else{    // player 2's turn
                System.out.println("Player 2's turn (O): ");
            }
        }

    }
}

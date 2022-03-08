import java.util.Scanner;


public class Main {
    public static GameType gameType;
    private static String[] game_titles = new String[]{"Tic Tac Toe", "Battleship"};


    public Main(){
        //filled in during selectGame
        gameType = null;
    }

    public static GameType selectGame(Scanner input){
        //printing dialog, getting scan from main.
        System.out.println("Select a Game!");
        for(int i = 0 ; i < game_titles.length; i++ )
        {
            System.out.println((i+1)+". "+game_titles[i]);
        }

        int user_choice = -1;

        //scales with game_titles, can be added.
        while(user_choice < 1 || user_choice > game_titles.length)
        {
            user_choice = input.nextInt();

            if(user_choice == -1 || user_choice > game_titles.length)
                System.out.println("Value out of choice length");


        }
            if(user_choice == 1)
            {
                return GameType.TICTACTOE;
            }

            else if (user_choice == 2)
            {
                return GameType.BATTLESHIP;
            }

            // Default game is ticTacToe
            else
            {
                return GameType.TICTACTOE;
            }


        }

    public static void main(String[] args) {

        // To test board
        Board boardObj = new Board();
        boolean gameFin = false; // don't need this if we have a checkWinner function
        int turn = 0;   // 0 reps player 1's turn, 1 reps palyer 2's turn

        // User input
        Scanner input = new Scanner(System.in);


        // GAME SELECT
        gameType = selectGame(input);



        // TIC TAC TOE LOGIC
        if(gameType == GameType.TICTACTOE) {
            System.out.println("~ TIC TAC TOE ~");
            System.out.println();
            System.out.println("Player 1's game piece will be: X");
            System.out.println("Player 2's game piece will be: O");
            boardObj.createBoard(gameType);
            while (!gameFin) {

                // player 1's turn
                if (turn == 0) {
                    System.out.println("Player 1's turn (X): ");
                    System.out.println("Enter the row you want to make your move in (start at 0)");
                    int rowInput = input.nextInt();

                    System.out.println("Enter the column you want to make your move in (start at 0)");
                    int colInput = input.nextInt();

                    Tile move1 = new Tile();
                    move1.value = "X";
                    move1.row = rowInput;
                    move1.column = colInput;

                    boardObj.updateBoard(move1, GameType.TICTACTOE);
                    turn = 1;
                } else {    // player 2's turn
                    System.out.println("Player 2's turn (O): ");
                    System.out.println("Enter the row you want to make your move in (start at 0)");

                    // if(input.nextInt() ){
                    int rowInput = input.nextInt();
                    //}

                    System.out.println("Enter the column you want to make your move in (start at 0)");
                    int colInput = input.nextInt();

                    Tile move2 = new Tile();
                    move2.value = "O";
                    move2.row = rowInput;
                    move2.column = colInput;

                    boardObj.updateBoard(move2, GameType.TICTACTOE);
                    turn = 0;
                }
            }
        }
    }
}

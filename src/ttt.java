
import java.util.Scanner;

public class ttt extends Game {

    boolean gameFin = false;

    @Override
    public void play() { 
        System.out.println(ctrl.getCurrPlayer() + " is X");     // player 1 is X
        System.out.println(ctrl.getPlayer2() + " is 0");

        tttBoard<String> ttt = new tttBoard<>();

        // User input
        Scanner input = new Scanner(System.in);

        // prints initial board (blank)
        ttt.printBoard();


        while(!gameFin)
        {
            // start with player 1
            // if(ttt.getTurn() % 2 == 0)
            // {
            //     System.out.println("\n" + ctrl.getCurrPlayer() + "'s turn (X)");
            // }
            // else
            // {
            //     System.out.println("\n" + ctrl.getPlayer2() + "'s turn (O)");
            // }

            // while(true)
            // {
                // System.out.println("Enter the row you want to make your move in (start at 0)");
                // int rowInput = input.nextInt();
                
                // System.out.println("Enter the column you want to make your move in (start at 0)");
                // int colInput = input.nextInt();

                // if player 1's turn
                if(ttt.getTurn() % 2 == 1){
                    System.out.println("\n" + ctrl.getCurrPlayer() + "'s turn (X)");
                    System.out.println("Enter the row you want to make your move in (start at 0)");
                    int rowInput = input.nextInt();
                    
                    System.out.println("Enter the column you want to make your move in (start at 0)");
                    int colInput = input.nextInt();
                    
                    ttt.updateBoard("X", rowInput, colInput);
                    // ttt.nextTurn();
                }
                else{
                    System.out.println("\n" + ctrl.getPlayer2() + "'s turn (O)");
                    System.out.println("Enter the row you want to make your move in (start at 0)");
                    int rowInput = input.nextInt();
                    
                    System.out.println("Enter the column you want to make your move in (start at 0)");
                    int colInput = input.nextInt();
                    
                    
                    ttt.updateBoard("O", rowInput, colInput);
                    // ttt.nextTurn();
                }
       
                //break;
            //}
        }

        //ttt.printBoard();
    }
}

public class ConnectFourGame extends Game {

    @Override
    public void play() {
        if(ctrl.getTotalPlayers() < 2)
        {
            System.out.println("\nNot enough users to play. Please add another user\n");
            return;
        }
        
        System.out.println(ctrl.getCurrPlayer() + " is RED");
        System.out.println(ctrl.getPlayer2() + " is YELLOW");
        ConnectFourBoard<String> c4 = new ConnectFourBoard<>();
        while(!c4.checkWin())
        {
            if(c4.getTurn() % 2 == 1)
            {
                System.out.println("\n" + ctrl.getCurrPlayer() + "'s turn");
            }
            else
            {
                System.out.println("\n" + ctrl.getPlayer2() + "'s turn");
            }
            c4.printBoard();
            while(true)
            {
                System.out.print("Enter the column to drop: ");
                int column = sc.nextInt();
                if(!c4.isValidColumn(column - 1) || c4.getBottomEmptyRow(column - 1) < 0)
                {
                    System.out.println("Invalid column, please try again\n");
                    continue;
                }
                if(c4.getTurn() % 2 == 1)
                {
                    c4.drop("R", column);
                }
                else
                {
                    c4.drop("Y", column);
                }
                break;
            }
        }
        c4.printBoard();
        if(c4.getTurn() % 2 == 0)
        {
            System.out.println("\n" + ctrl.getCurrPlayer() + " wins!");
            ctrl.incrPlayerScore(ctrl.getCurrPlayer());
        }
        else
        {
            System.out.println("\n" + ctrl.getPlayer2() + " wins!");
            ctrl.incrPlayerScore(ctrl.getPlayer2());
        }
    }
    
}

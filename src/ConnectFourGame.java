public class ConnectFourGame extends Game {

    @Override
    public void play() {
        if(ctrl.getTotalPlayers() < 2)
        {
            System.out.println("\nNot enough users to play. Please add another user\n");
            return;
        }
        // while(true)
        // {
        //     System.out.println("\n" + ctrl.getCurrPlayer() + " playing as Player 1");
        //     System.out.println("Select Player 2 from the list below");
        //     ctrl.printPlayersExcept(ctrl.getCurrPlayer());
        //     System.out.print("Select player: ");
        //     String name = sc.nextLine();
        //     if(name.equals(ctrl.getCurrPlayer()))
        //     {
        //         System.out.println("\n" + name + " is already Player 1");
        //         continue;
        //     }
        //     if(!ctrl.playerNameExists(name))
        //     {
        //         System.out.println("\n" + name + " does not exist");
        //         continue;
        //     }
        //     ctrl.loginPlayer2(name);
        //     System.out.println("\n" + name + " playing as Player 2\n");
        //     break;
        // }
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

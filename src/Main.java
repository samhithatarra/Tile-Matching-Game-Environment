import java.util.*;

public class Main 
{
    public static Controller ctrl = new Controller();
    public static Scanner sc = new Scanner(System.in);
    public static boolean runApp = true;

    public static void main(String[] args) 
    {
        while(runApp)
        {
            System.out.print("1.) Add new user\n" +
                             "2.) Login\n" +
                             "3.) Quit\n" +
                             "Enter Command Number: ");
            int command = sc.nextInt();
            sc.nextLine(); // flush scanner after int input

            switch(command)
            {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    runApp = false;
                    break;
                default:
<<<<<<< HEAD
                    System.out.println("\nInvalid command\n");
=======
                    System.out.println("\nNot an option!\n");
>>>>>>> 9b284bbf6e3a43f0785cbe47c1d4c9b5e6868621
            }

        }
    }

    public static void addNewUser()
    {
        while(true)
        {
            System.out.print("\nEnter new username: ");
            String name = sc.nextLine();
            if(ctrl.playerNameExists(name))
            {
                System.out.println(name + " already exists");
                continue;
            }
            ctrl.createProfile(name);
            break;
        }
        System.out.println();
    }

    public static void login()
    {
        while(true)
        {
            System.out.println("\nLogin as a user from the list below");
            ctrl.printPlayers();
            System.out.print("Login as: ");
            String name = sc.nextLine();
            if(!ctrl.playerNameExists(name))
            {
                System.out.println(name + " does not exist");
                continue;
            }
            ctrl.loginCurrPlayer(name);
            System.out.println("\nLogged in as " + name + "\n");
            break;
        }
        selectUserCommands();
    }

    public static void selectUserCommands()
    {
        boolean loopGameSelection = true;
        while (loopGameSelection)
        {
            System.out.println("1.) Tic-Tac-Toe");
            System.out.println("2.) Connect Four");
            System.out.println("3.) View user score");
            System.out.println("4.) Logout");
            System.out.print("Enter game: ");
            int game = sc.nextInt();
            sc.nextLine(); // flush scanner after int input

            switch(game)
            {
                case 1: 
                    selectTicTacToe();
                    loopGameSelection = false;
                    break;
                case 2:
                    selectConnectFour();
                    loopGameSelection = false;
                    break;
                case 3:
                    viewCurrUserScore();
                    break;
                case 4:
                    System.out.println();
                    loopGameSelection = false;
                    break;
                default:
<<<<<<< HEAD
                    System.out.println("\nInvalid command\n");
=======
                    System.out.println("\nNot an option!\n");
>>>>>>> 9b284bbf6e3a43f0785cbe47c1d4c9b5e6868621
            }
        }
    }

    public static void selectConnectFour()
    {
        if(ctrl.getTotalPlayers() < 2)
        {
            System.out.println("\nNot enough users to play. Please add another user\n");
            return;
        }
        while(true)
        {
            System.out.println("\n" + ctrl.getCurrPlayer() + " playing as Player 1");
            System.out.println("Select Player 2 from the list below");
            ctrl.printPlayersExcept(ctrl.getCurrPlayer());
            System.out.print("Select player: ");
            String name = sc.nextLine();
            if(name.equals(ctrl.getCurrPlayer()))
            {
                System.out.println("\n" + name + " is already Player 1");
                continue;
            }
            if(!ctrl.playerNameExists(name))
            {
                System.out.println("\n" + name + " does not exist");
                continue;
            }
            ctrl.loginPlayer2(name);
            System.out.println("\n" + name + " playing as Player 2\n");
            break;
        }
        playConnectFour();
    }

    public static void viewCurrUserScore()
    {
        System.out.println("\n" + ctrl.getCurrPlayer() + "'s total score: " + ctrl.getUserScore(ctrl.getCurrPlayer()) + "\n");
    }

    public static void playConnectFour()
    {
        System.out.println(ctrl.getCurrPlayer() + " is RED");
        System.out.println(ctrl.getPlayer2() + " is YELLOW");
        Connect4Board<String> c4 = new Connect4Board<>();
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
        System.out.println();
        c4.printBoard();
        if(c4.getTurn() % 2 == 0)
        {
            System.out.println("\n" + ctrl.getCurrPlayer() + " wins!\n");
            ctrl.incrPlayerScore(ctrl.getCurrPlayer());
        }
        else
        {
            System.out.println("\n" + ctrl.getPlayer2() + " wins!\n");
            ctrl.incrPlayerScore(ctrl.getPlayer2());
        }
    }

    public static void selectTicTacToe()
    {
        System.out.println("\nttt");
    }
}

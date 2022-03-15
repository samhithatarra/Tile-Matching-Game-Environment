import java.util.Scanner;

public class Game {

    public static Controller ctrl;
    public static Scanner sc;

    Game() { 
        ctrl = new Controller();
        sc = new Scanner(System.in);
    }

    public void start() { 

        boolean shouldExit = true;

        while(shouldExit)
        {
            System.out.print("1.) Add new user\n" +
                             "2.) Login\n" +
                             "3.) View user scores\n" + 
                             "4.) Quit\n" +
                             "Enter Command Number: ");
            int command = sc.nextInt();
            sc.nextLine(); // flush scanner after int input

            switch(command)
            {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    presentLogInDialog();
                    break;
                case 3:
                    viewCurrUserScore();
                    break;
                case 4:
                    shouldExit = false;
                    break;
                default:
                    System.out.println("\nNot an option!\n");
            }

        }
    }

    public void viewCurrUserScore()
    {
        System.out.println("\n" + ctrl.getCurrPlayer() + "'s total score: " + ctrl.getUserScore(ctrl.getCurrPlayer()) + "\n");
    }

    public void addNewUser() { 
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

    public void presentLogInDialog() { 
        if(ctrl.getTotalPlayers() < 2)
        {
            System.out.println("\nNot enough users to play. Please add another user\n");
            return;
        }
        while(true)
        {
            System.out.println("\nLogin as a user from the list below");
            ctrl.printPlayers();
            System.out.print("Login Player1 as: ");
            String name1 = sc.nextLine();
            System.out.print("Login Player2 as: ");
            String name2 = sc.nextLine();

            // Break out of this while loop if we succesfully are able to log in a user.
            if (logInUsers(name1, name2)) {  break; }
        }
        play();
    }

    /**
     * Logs in a user.
     * @param username The username belonging to the user that wishes to be logged in
     * @return true if 'username' exists in 'ctrl'
     */
    public boolean logInUsers(String username, String user2) { 
        if(!ctrl.playerNameExists(username))
        {
            System.out.println(username + " does not exist");
            return false;
        }
        else if(!ctrl.playerNameExists(user2)){
            System.out.println(user2 + " does not exist");
            return false; 
        }
        ctrl.loginCurrPlayer(username);
        ctrl.loginPlayer2(user2);
       
        System.out.println("\nLogged in player 1 as " + username + "\n");
        System.out.println("\nLogged in player 2 as " + user2 + "\n");
        return true;
    }

    // This needs to be overwritten by the subclass
    public void play() { }
    
}

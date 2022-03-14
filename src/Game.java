import java.util.Scanner;

public class Game {

    Controller ctrl;
    Scanner sc;

    Game() { 
        ctrl = new Controller();
        sc = new Scanner(System.in);
    }

    public void start() { 

        boolean shouldExit = false;
        while(shouldExit)
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
                    presentLogInDialog();
                    break;
                case 3:
                    shouldExit = true;
                    break;
                default:
                    System.out.println("\nNot an option!\n");
            }

        }
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
            System.out.print("Login as: ");
            String name = sc.nextLine();

            // Break out of this while loop if we succesfully are able to log in a user.
            if (logInUser(name)) {  break; }
        }
        play();
    }

    /**
     * Logs in a user.
     * @param username The username belonging to the user that wishes to be logged in
     * @return true if 'username' exists in 'ctrl'
     */
    public boolean logInUser(String username) { 
        if(!ctrl.playerNameExists(username))
        {
            System.out.println(username + " does not exist");
            return false;
        }
        ctrl.loginCurrPlayer(username);
        System.out.println("\nLogged in as " + username + "\n");
        return true;
    }

    // This needs to be overwritten by the subclass
    public void play() { }
    
}

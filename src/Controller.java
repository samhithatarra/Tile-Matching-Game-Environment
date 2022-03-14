import java.util.ArrayList;

public class Controller 
{
    private ArrayList<Player> players;
    private String currPlayer;
    private String player2;

    public Controller()
    {
        players = new ArrayList<>();
        currPlayer = "";
        player2 = "";
    }

    public void createProfile(String name)
    {
        if(!playerNameExists(name))
        {
            players.add(new Player(name));
        }
    }

    public void loginCurrPlayer(String name)
    {
        if(playerNameExists(name))
        {
            currPlayer = name;
        }
    }

    public String getCurrPlayer()
    {
        return currPlayer;
    }

    public void loginPlayer2(String name)
    {
        if(playerNameExists(name))
        {
            player2 = name;
        }
    }

    public String getPlayer2()
    {
        return player2;
    }

    public boolean playerNameExists(String name)
    {
        for(Player p : players)
        {
            if(p.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public void printPlayers()
    {
        for(Player p : players)
        {
            System.out.println(p.getName());
        }
    }

    public void printPlayersExcept(String name)
    {
        for(Player p : players)
        {
            if(!p.getName().equals(name))
            {
                System.out.println(p.getName());
            }
        }
    }

    public void incrCurrPlayerScore()
    {
        for(Player p : players)
        {
            if(p.getName().equals(currPlayer))
            {
                p.incScore();
                break;
            }
        }
    }

    public void incrPlayer2Score()
    {
        for(Player p : players)
        {
            if(p.getName().equals(player2))
            {
                p.incScore();
                break;
            }
        }
    }

    public int getTotalPlayers()
    {
        return players.size();
    }
}

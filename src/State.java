public class State 
{
    private int turn;
    private int totalPlayers;


    public State(int totalPlayers)
    {
        this.totalPlayers = totalPlayers;
        turn = 1;
    }

    public int nextTurn()
    {
        turn++;
        if (turn > totalPlayers)
        {
            turn = 1;
        }
        return turn;
    }

    public void updateBoard()
    {
        System.out.println("Base State's updateBoard(): this method should be overriden");
    }
    
    public boolean checkWin()
    {
        System.out.println("Base State's checkWin(): this method should be overriden");
        return false;
    }
}

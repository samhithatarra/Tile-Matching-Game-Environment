public class State 
{
    private int turn;
    private int totalPlayers;


    public State(int totalPlayers)
    {
        this.totalPlayers = totalPlayers;
    }

    public int nextTurn()
    {
        this.turn = this.turn + 1;
        if (this.turn > totalPlayers)
        {
            this.turn = 1;
        }
        return this.turn;
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
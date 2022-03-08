public class BattleshipState extends State
{
    public BattleshipState(int totalPlayers)
    {
        super(totalPlayers);
    }

    public void updateBoard(int x, int y)
    {
        //something here
    }
    
    public boolean checkWin()
    {
        System.out.println("Base State's checkWin(): this method should be overriden");
        return false;
    }
}
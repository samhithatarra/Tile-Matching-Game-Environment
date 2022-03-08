//Aliyah & Sam: Connect4, Board
//Becky & Lancy: Battleship, Player, State
//Jules & Mikey: Battleship, Main/Controller, Tile, GameType

public class Player 
{
    private int score;
    private String name;

    public Player(String name)
    {
        this.name = name;
        score = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    public void incScore()
    {
        score++;
    }
}

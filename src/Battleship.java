import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {

    ArrayList<String> players = new ArrayList<>();
    Board board = null;
    int playerTurn = 0;
    Scanner input = new Scanner(System.in);

    public Battleship() { }

    public boolean isValidInput() { return false; }

    public void promptUserForPlayerProfiles() {}

    public void updateBoard(int rowNumber, int colNumber, Tile tile) {
        this.board.boardArr[rowNumber][colNumber] = tile;
    }

    public void createBoard(int rowCount, int columnCount) {
        this.board = new Board(rowCount, columnCount);
    }

    public boolean checkWinner() { return false; }
}
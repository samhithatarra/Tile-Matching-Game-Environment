public class Main {
    public static void main(String[] args) {
        Board obj = new Board();
        obj.createBoard(GameType.TICTACTOE);
        obj.displayBoard(GameType.TICTACTOE);
    }
}

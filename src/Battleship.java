public class Battleship extends Game {

    public Battleship() {

    }

    @Override
    public boolean isValidInput() { return false; }

    @Override
    public void promptUserForPlayerProfiles() {}

    @Override
    public void updateBoard() {}

    @Override
    public void createBoard(int rowCount, int columnCount) {
        this.board = new Board(rowCount, columnCount);
    }

    @Override
    public boolean checkWinner() { return false; }
}

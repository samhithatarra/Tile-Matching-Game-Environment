public class Tile<T> {
    T value;
    int column;
    int row;

    Tile(T value, int row, int col) {
        this.value = value;
        this.row = row;
        this.column = col;
    }
}
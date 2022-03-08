import java.util.ArrayList;

public class Ship {

    // Example: [Tile(99, row, col], [Tile(99, row, col)]
    ArrayList<Tile<Integer>> points;
    public Ship(ArrayList<Tile<Integer>> points) {

        // Forcefully set the value for each Tile in 'points' to be 99
        for (Tile<Integer> tile : points) {
            tile.value = 99;
        }


    }

//    public static void main(String[] args) {
//
//        ArrayList<Tile<Integer>> points = new ArrayList<Tile<Integer>>();
//        points.add(new Tile<Integer>(12, 1, 2));
//        points.add(new Tile<Integer>(12, 1, 3));
//
//        Ship s = new Ship(points);
//    }



}

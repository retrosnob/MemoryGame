import java.util.Arrays;
import java.util.Random;

public class MemoryGameModel2 {

    private int[] tiles = new int[16];
    private boolean[] matched = new boolean[16];

    public MemoryGameModel2() {

        for (int i = 0; i < tiles.length / 2; i++) {
            tiles[i] = i + 1;
            tiles[i+8] = i + 1;
        }

        // Shuffle the array
        shuffle(tiles);

        // DEBUGGING CODE
        System.out.println("Order of tiles in model: ");
        for (int t : tiles) {
            System.out.print(t + " ");
        }
        System.out.println();

    }

    // When it's your turn, you have to say which tile you've clicked
    public boolean tryMatch(int firstTileNumber, int secondTileNumber) {
        if (firstTileNumber == secondTileNumber) {
            // Don't do anything because this input doesn't make sense.
            return false;
        }
        else if (tiles[firstTileNumber] == tiles[secondTileNumber]) {
            // Woohoo! A match!
            System.out.println("Match found");
            matched[firstTileNumber] = true;
            matched[secondTileNumber] = true;
            return true;
        }
        else {
            // Bummer. Don't display the clicked tile any more.
            System.out.println("No match");
            return false;
        }
    }

    int[] getAllTileNumbers() {
        return Arrays.copyOf(tiles, tiles.length);
    }

    boolean[] getMatchedTiles() {
        // Let the UI ask which tiles it should display
        // and which tiles should still be hidden.
        return Arrays.copyOf(matched, matched.length);

    }

    static void shuffle(int[] array) {
        int n = array.length;
        Random random = new Random();
        // Loop over array.
        for (int i = 0; i < array.length; i++) {
            // Get a random index of the array past the current index.
            // ... The argument is an exclusive bound.
            //     It will not go past the array's end.
            int randomValue = i + random.nextInt(n - i);
            // Swap the random element with the present element.
            int randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = randomElement;
        }
    }


}

public class MemoryGameModel {

    private int[] tiles = new int[16];
    private boolean[] displayed = new boolean[16];
    int firstTileNumber = -1;

    public MemoryGameModel() {

        // Temporary set up. We will have to change this later...
        for (int i = 0; i < tiles.length / 2; i++) {
            tiles[i] = i + 1;
            tiles[i+8] = i + 1;
        }
    }

    // When it's your turn, you have to say which tile you've clicked
    public void doClick(int index) {


        // Is this the first click or the second??
        if (firstTileNumber == -1) {
            System.out.println("Model received first click: " + index);

            // This must be the first click
            firstTileNumber = index;
            // Update the
            displayed[firstTileNumber] = true;
        }
        else {
            System.out.println("Model received second click: " + index);

            // This must be the second click
            int secondTileNumber = index;

            if (tiles[firstTileNumber] == tiles[secondTileNumber]) {
                // Woohoo! A match!
                System.out.println("Match found");
                displayed[firstTileNumber] = true;
                displayed[secondTileNumber] = true;
            }
            else {
                // Bummer. Don't display the clicked tile any more.
                System.out.println("No match");
                displayed[firstTileNumber] = false;
                // And reset the first tile number.
                firstTileNumber = -1;
            }
        }
    }

    int[] getTilesToDisplay() {
        // Let the UI ask which tiles it should display
        // and which tiles should still be hidden.

        int[] returnArray = new int[16];

        // Loop through the displayed array and when I find
        // a true value at index i, set the ith value of returnArray
        // to the ith value of tiles, or zero otherwise.

        for (int i = 0; i < displayed.length; i++) {
            if (displayed[i]) {
                returnArray[i] = tiles[i];
            }
        }
        return returnArray;
    }


}

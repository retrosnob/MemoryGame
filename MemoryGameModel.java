public class MemoryGameModel {

    private int[] tiles = new int[16];
    private boolean[] displayed = new boolean[16];
    int firstTileNumber = -1;

    public MemoryGameModel() {

        // Temporary set up. We will have to change this later...
        int count = 1;
        for (int i = 0; i < tiles.length / 2; i++) {
            tiles[i] = count;
            tiles[i+1] = count;
            count = count + 1;
        }
    }

    // When it's your turn, you have to say which tile you've clicked
    public void doClick(int index) {
        // Is this the first click or the second??
        if (firstTileNumber == -1) {
            // This must be the first click
            firstTileNumber = index;
            // Update the
            displayed[firstTileNumber] = true;
        }
        else {
            // This must be the second click
            int secondTileNumber = index;

            if (tiles[firstTileNumber] == tiles[secondTileNumber]) {
                // Woohoo! A match!
                displayed[firstTileNumber] = true;
                displayed[secondTileNumber] = true;
            }
            else {
                // Bummer. Don't display the clicked tile any more.
                displayed[firstTileNumber] = false;
                // And reset the first tile number.
                firstTileNumber = -1;
            }

        }
    }

    int[] getTilesToDisplay() {
        int[] returnArray = new int[16];

        // loop through the displayed array and when I find
        // a true value at index i, set the ith value of returnArray
        // to the ith value of tiles.

        return returnArray;
    }


}

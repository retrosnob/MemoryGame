import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MemoryGameView {

    MemoryGameModel2 model;
    Tile[] tiles;
    int[] tileNumbers = new int[16];
    boolean matchedTiles[] = new boolean[16];
    int firstTileClicked = -1;

    public MemoryGameView(MemoryGameModel2 model) {

        this.model = model;

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new GridLayout(4, 4));

                        // Create array of tile objects
                        tiles = new Tile[16];
                        tileNumbers = model.getAllTileNumbers();

                        // Instantiate tiles and add to main panel
                        for (int i = 0; i < tiles.length; i++) {
                            // Create my tile objects
                            tiles[i] = new Tile(MemoryGameView.this, i);

                            // Add this tile to the main panel
                            mainPanel.add(tiles[i].getLabel());

                        }

                        // updateDisplay();

                        JFrame mainFrame = new JFrame();
                        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        mainFrame.getContentPane().add(mainPanel);
                        mainFrame.pack();
                        mainFrame.setVisible(true);
                    }
                });
    }

    void tileClicked(int tileNumber) {

        if (matchedTiles[tileNumber]) {
            return; // Don't do anything if they've picked a tile that's already matched.
        }

        showClickedTile(tileNumber);

        int secondTileClicked;
        if (firstTileClicked == -1) {
            firstTileClicked = tileNumber;
        }
        else {
            secondTileClicked = tileNumber;

            if (firstTileClicked == secondTileClicked) {
                // Don't do anything because they clicked the same tile twice.
                // Later we can add code here to display an appropriate message.
            } else {
                boolean matchFound = model.tryMatch(firstTileClicked, secondTileClicked);

                if (matchFound) {
                    updateMatched();
                } else {
                    // WAIT for a second and then...
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Hello");
                        }
                    });
                    // hideTiles(firstTileClicked, secondTileClicked);
                }
                firstTileClicked = -1;
            }


        }



    }

    void showClickedTile(int tileNumber) {
        tiles[tileNumber].getLabel().setText(String.valueOf(tileNumbers[tileNumber]));
    }

    void hideTiles(int firstTile, int secondTile) {
        tiles[firstTile].getLabel().setText("");
        tiles[secondTile].getLabel().setText("");

    }

    void updateMatched() {
        // Ask the model for the tiles to Display. This is an array of ints
        // containing all pairs of matched tiles. All non-matched elements are
        // set to -1.
        matchedTiles = model.getMatchedTiles();
        for (int i = 0; i < matchedTiles.length; i++) {
            if (matchedTiles[i]) {
                tiles[i].getLabel().setText(String.valueOf(tileNumbers[i]));
            } else {
                tiles[i].getLabel().setText("");
            }
        }
    }
}

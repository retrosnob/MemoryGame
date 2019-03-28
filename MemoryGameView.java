import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MemoryGameView {

    MemoryGameModel model;

    public MemoryGameView(MemoryGameModel model) {

        this.model = model;

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        JPanel mainPanel = new JPanel();
                        mainPanel.setLayout(new GridLayout(4, 4));

                        // Create array of tile objects
                        Tile[] tiles = new Tile[16];

                        // Instantiate tiles and add to main panel
                        for (int i = 0; i < tiles.length; i++) {
                            // Create my tile objects
                            tiles[i] = new Tile(MemoryGameView.this, i + 1);

                            // Add this tile to the main panel
                            mainPanel.add(tiles[i].getLabel());

                        }

                        JFrame mainFrame = new JFrame();
                        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        mainFrame.getContentPane().add(mainPanel);
                        mainFrame.pack();
                        mainFrame.setVisible(true);
                    }
                }
        );
    }

    void tileClicked(int tileNumber) {
        model.doClick(tileNumber);
    }

}

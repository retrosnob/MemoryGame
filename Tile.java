import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile {

    private int id;
    private JLabel label;
    MemoryGameView parent;

    public Tile(MemoryGameView parent, int id) {
        this.parent = parent;
        this.id = id;
        label = new JLabel(String.valueOf(id));
        label.setPreferredSize(new Dimension(50, 50));
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.tileClicked(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }


    public int getId() {
        return id;
    }

    public JLabel getLabel() {
        return label;
    }
}

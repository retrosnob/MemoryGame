import javax.swing.*;
import java.awt.*;

public class Tile {

    private int id;
    private JLabel label;

    public Tile(int id) {
        this.id = id;
        label = new JLabel(String.valueOf(id));
        label.setPreferredSize(new Dimension(50, 50));
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }


    public int getId() {
        return id;
    }

    public JLabel getLabel() {
        return label;
    }
}

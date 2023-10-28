package frontend;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelBotones pbm;
    public PanelComprador() {
        pbm = new PanelBotones();
        this.setLayout(new GridLayout(2,1));
        this.add(pbm);

        this.setBackground(Color.LIGHT_GRAY);

    }
}

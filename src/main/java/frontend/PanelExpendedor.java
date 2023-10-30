package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelExpendedor extends JPanel {
    private GridLayout grid;
    public PanelExpendedor() {
        super();
        grid = new GridLayout(2,1);
        this.setLayout(grid);

        this.add(new Button("asd"), grid);
        this.add(new Button("asd"), grid);
    }
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.GRAY);
        this.setVisible(true);
    }
}

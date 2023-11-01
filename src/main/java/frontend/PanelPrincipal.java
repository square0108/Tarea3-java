package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private static PanelComprador com;
    private static PanelExpendedor exp;
    private GridLayout grid;
    public PanelPrincipal () {
        new Controller(this);
        grid = new GridLayout(1,2);
        this.setLayout(grid);

        com = new PanelComprador();
        exp = new PanelExpendedor(Controller.expendedor);
        this.add(com);
        this.add(exp);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        com.paint(g);
        exp.paint(g);
    }
}

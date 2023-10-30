package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private GridLayout grid;
    public PanelPrincipal () {;
        grid = new GridLayout(1,2);
        this.setLayout(grid);

        com = new PanelComprador();
        exp = new PanelExpendedor(Controller.expendedor);
        this.add(com);
        this.add(exp);
    }
}

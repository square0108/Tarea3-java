package frontend;
import java.awt.*;
import javax.swing.*;

/**
 * Es un panel que posee TODAS las vistas del programa (Vista de comprador y expendedor).
 */
public class PanelPrincipal extends JPanel {
    private static PanelComprador com;
    private static PanelExpendedor exp;
    private GridLayout grid;

    /**
     * Método constructor de PanelPrincipal. Los paneles Constructor y Expendedor son creados dentro de este.
     * Estas a su vez, son controladas por la Clase Controller.
     */
    public PanelPrincipal () {
        Controller.setPanelPrincipal(this);
        grid = new GridLayout(1,2);
        this.setLayout(grid);

        com = new PanelComprador();
        exp = new PanelExpendedor(Controller.expendedor);
        this.add(com);
        this.add(exp);
    }
}

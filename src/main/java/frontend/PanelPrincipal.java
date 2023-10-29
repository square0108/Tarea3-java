package frontend;

import backend.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    public PanelPrincipal() {
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1,2));

        this.add(com); // primero comprador dsp expendedor (izquierda:derecha)
        this.add(exp);
    }
}

package frontend;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelRetiros retiros;
    private PanelBotones panelBotones;
    private PanelCrearMonedas CreadorMonedas;
    private JPanel Upper;
    private JPanel Lower;

    public PanelComprador() {
        Upper = new JPanel();
        Lower = new JPanel();
        Upper.setLayout(new GridLayout(1,2));
        Lower.setLayout(new BorderLayout());
        GridLayout grid = new GridLayout(2,1);
        this.setLayout(grid);
        this.add(Upper);
        this.add(Lower);

        this.retiros = new PanelRetiros();
        this.panelBotones = new PanelBotones();
        this.CreadorMonedas = new PanelCrearMonedas();

        Upper.add(retiros);
        Upper.add(panelBotones);
        Lower.add(CreadorMonedas, BorderLayout.NORTH);

        this.setBackground(Color.LIGHT_GRAY);

    }
}

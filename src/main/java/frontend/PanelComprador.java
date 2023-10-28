package frontend;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelRetiros retiros;
    private PanelBotones panelBotones;
    private PanelCrearMonedas CreadorMonedas;
    private PanelMonedasComprador MonedasComprador;

    public PanelComprador() {
        this.setLayout(new GridLayout(2,2));
        this.retiros = new PanelRetiros();
        this.panelBotones = new PanelBotones();
        this.CreadorMonedas = new PanelCrearMonedas();
        this.MonedasComprador = new PanelMonedasComprador();
        this.add(retiros);
        this.add(panelBotones);
        this.add(CreadorMonedas);
        this.add(MonedasComprador);

        this.setBackground(Color.LIGHT_GRAY);

    }
}

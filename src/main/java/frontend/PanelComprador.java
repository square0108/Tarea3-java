package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelComprador extends JPanel {
    private PanelBotones panelBotones;
    private PanelCrearMonedas panelCrearMonedas;
    private PanelRetiros panelRetiros;
    private int ValMonedaSelect;
    public PanelComprador() {
        ValMonedaSelect = 0;
        this.panelBotones = new PanelBotones(this);
        this.panelCrearMonedas = new PanelCrearMonedas(this);
        this.panelRetiros = new PanelRetiros(this);
        JPanel Upper = new JPanel();
        JPanel Lower = new JPanel();

        this.setLayout(new GridLayout(2,1));
        this.add(Upper);
        this.add(Lower);
        Upper.setLayout(new GridLayout(1,2));
        Lower.setLayout(new GridLayout(2,1));
        Upper.add(panelRetiros);
        Upper.add(panelBotones);
        Lower.add(panelCrearMonedas);
        Lower.add(new JButton("Monedas de Comprador¿?"));
    }

    public int getValMonedaSelect() {
        return ValMonedaSelect;
    }

    public void setValMonedaSelect(int valMonedaSelect) {
        ValMonedaSelect = valMonedaSelect;
    }
}

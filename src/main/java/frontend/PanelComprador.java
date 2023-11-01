package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelComprador extends JPanel {
    private PanelBotones panelBotones;
    private PanelCrearMonedas panelCrearMonedas;
    private PanelRetiros panelRetiros;
    private PanelMonedasComprador panelMonedasComprador;
    private int ValMonedaSelect;
    public PanelComprador() {
        ValMonedaSelect = 0;
        this.panelMonedasComprador = new PanelMonedasComprador();
        this.panelBotones = new PanelBotones(this);
        this.panelCrearMonedas = new PanelCrearMonedas(this);
        this.panelRetiros = new PanelRetiros(this);

        /* estos dos paneles no hacen nada, son solo para layout, por ende no tienen su propio archivo */
        JPanel Upper = new JPanel();
        JPanel Lower = new JPanel();

        this.setLayout(new GridLayout(2,1));
        Upper.setLayout(new GridLayout(1,2));
        Lower.setLayout(new BorderLayout());

        this.add(Upper);
        this.add(Lower);

        Upper.add(panelRetiros);
        Upper.add(panelBotones);
        Lower.add(panelCrearMonedas, BorderLayout.NORTH);
        Lower.add(panelMonedasComprador, BorderLayout.CENTER);
    }

    public int getValMonedaSelect() {
        return ValMonedaSelect;
    }

    public void setValMonedaSelect(int valMonedaSelect) {
        ValMonedaSelect = valMonedaSelect;
    }
}

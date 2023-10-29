package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelRetiros retiros;
    private PanelBotones panelBotones;
    private PanelCrearMonedas CreadorMonedas;
    private JPanel Upper;
    private JPanel Lower;
    private Expendedor TestExpendedorPlsDelete;
    private int valorSelect;

    public PanelComprador() {
        TestExpendedorPlsDelete = new Expendedor(3);
        Upper = new JPanel();
        Lower = new JPanel();
        Upper.setLayout(new GridLayout(1,2));
        Lower.setLayout(new BorderLayout());
        this.valorSelect = 0;
        GridLayout grid = new GridLayout(2,1);
        this.setLayout(grid);
        this.add(Upper);
        this.add(Lower);

        this.retiros = new PanelRetiros();
        this.CreadorMonedas = new PanelCrearMonedas(this);
        this.panelBotones = new PanelBotones(this);

        Upper.add(retiros);
        Upper.add(panelBotones);
        Lower.add(CreadorMonedas, BorderLayout.NORTH);

        this.setBackground(Color.LIGHT_GRAY);

    }
    public int getValorSelect() {return valorSelect;}
    public void setValorSelect(int v) {valorSelect = v;}
}

package frontend;
import backend.Moneda;

import java.awt.*;
import javax.swing.*;

public class PanelComprador extends JPanel {
    private PanelBotones panelBotones;
    private PanelSelectMoneda panelSelectMoneda;
    private PanelRetiros panelRetiros;
    private PanelMonedasComprador panelMonedasComprador;
    private int ValMonedaSelect;
    private Moneda[] UltimoVueltoRecibido;

    /**
     * Posee como propiedades privadas: PanelBotones, PanelSelectMoneda, PanelRetiros, PanelMonedasComprador, estos son sus "subpaneles".
     * Todos los subpaneles con archivo propio poseen una referencia a PanelComprador, al cual pertenecen.
     * PanelComprador posee las propiedades privadas int ValMonedaSelect, Moneda[] UltimoVueltoRecibido. La primera es para conectar PanelSelectMoneda con PanelBotones, la segunda es para conectar PanelRetiros con PanelMonedasComprador.
     */
    public PanelComprador() {
        ValMonedaSelect = 0;
        this.panelMonedasComprador = new PanelMonedasComprador();
        this.panelBotones = new PanelBotones(this);
        this.panelSelectMoneda = new PanelSelectMoneda(this);
        this.panelRetiros = new PanelRetiros(this);

        /* estos dos paneles no hacen nada, son solo para layout, por ende no tienen su propio archivo */
        JPanel Upper = new JPanel();
        JPanel Lower = new JPanel();

        this.setLayout(new GridLayout(2,1)); /* aqui iran los Upper y Lower, las dos mitades de PanelComprador. */
        Upper.setLayout(new GridLayout(1,2)); /* una columna para PanelRetiros, otra para PanelBotones. */
        Lower.setLayout(new BorderLayout()); /* NORTH lo ocupa el panel de seleccion, CENTER lo ocupan las monedas que ha retirado comprador. */

        this.add(Upper);
        this.add(Lower);

        Upper.add(panelRetiros);
        Upper.add(panelBotones);
        Lower.add(panelSelectMoneda, BorderLayout.NORTH);
        Lower.add(panelMonedasComprador, BorderLayout.CENTER);
    }

    /* getters y setters de las propiedades que NO son JPanel. Utilizados por los subpaneles. */

    public int getValMonedaSelect() {
        return ValMonedaSelect;
    }

    public void setValMonedaSelect(int valMonedaSelect) {
        ValMonedaSelect = valMonedaSelect;
    }

    public Moneda[] getUltimoVueltoRecibido() {return UltimoVueltoRecibido;}

    public void setUltimoVueltoRecibido(Moneda[] arrayMonedas) {
        this.UltimoVueltoRecibido = arrayMonedas;
    }
 }

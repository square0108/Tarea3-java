package frontend;
import java.awt.*;
import javax.swing.*;
public class PanelBotones extends JPanel {
    private JPanel PanelRetiro;
    private JPanel PanelCompra;
    public PanelBotones(){
        this.PanelRetiro = new JPanel();
        this.PanelCompra = new JPanel();
        this.setLayout(new GridLayout(1,2));
        PanelRetiro.setLayout(new GridLayout(2,1));
        PanelCompra.setLayout(new GridLayout(5,1));

        this.add(PanelRetiro);
        this.add(PanelCompra);

        PanelRetiro.add(new Button("Retirar producto"));
        PanelRetiro.add(new Button("Retirar vuelto"));
        PanelCompra.add(new Button("Coca Cola"));
        PanelCompra.add(new Button("Sprite"));
        PanelCompra.add(new Button("Fanta"));
        PanelCompra.add(new Button("Snickers"));
        PanelCompra.add(new Button("Super 8"));
    }
}

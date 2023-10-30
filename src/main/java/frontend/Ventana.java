package frontend;
import backend.*;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("meow moew meoww mweo :3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(1,1));

        Expendedor expendedor = new Expendedor(5);
        PanelExpendedor expendedorpanel = new PanelExpendedor(expendedor);
        expendedorpanel.comprarProducto(0,new Moneda500());
        panel.add(expendedorpanel);

        this.add(panel,BorderLayout.CENTER);

        this.setVisible(true);
    }
}

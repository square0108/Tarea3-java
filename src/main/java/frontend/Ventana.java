package frontend;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        this.setLayout(new BorderLayout());
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel border1 = new JPanel();
        JPanel border2 = new JPanel();
        JPanel border3 = new JPanel();
        JPanel border4 = new JPanel();
        border1.setBackground(Color.RED);
        border2.setBackground(Color.RED);
        border3.setBackground(Color.RED);
        border4.setBackground(Color.RED);

        this.add(new PanelPrincipal(),BorderLayout.CENTER);
        this.add(border1, BorderLayout.NORTH);
        this.add(border2, BorderLayout.EAST);
        this.add(border3, BorderLayout.SOUTH);
        this.add(border4, BorderLayout.WEST);
        this.setVisible(true);
    }
}

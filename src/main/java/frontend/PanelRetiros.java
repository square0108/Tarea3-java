package frontend;
import backend.Producto;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelRetiros extends JPanel implements ActionListener{
    private JButton[] buttons;
    private PanelComprador panelComprador;
    public PanelRetiros(PanelComprador p) {
        this.panelComprador = p;
        this.setLayout(new GridLayout(2,1));
        buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto")};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].removeActionListener(this);
            this.remove(buttons[i]);
        }

        if (Controller.VerProducto() != null) buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto")};
        else buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto")};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
        validate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0] && Controller.VerProducto() != null) {
            Producto SADMAN = Controller.GetProducto();
            repaint();
            System.out.println("glu glu, " + SADMAN.consumir());
        }
    }
}

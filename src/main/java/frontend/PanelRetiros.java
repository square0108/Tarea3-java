package frontend;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelRetiros extends JPanel implements ActionListener{
    private JButton[] buttons;
    public PanelRetiros() {
        this.setLayout(new GridLayout(2,1));
        if (Controller.HayProductoComprado()) {
            buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto")};
        }
        else {
            buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto")};
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0] && Controller.HayProductoComprado()) {
            Controller.GetProducto();
            System.out.println("glu glu");
        }
    }
}

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

        if (Controller.VerProducto() != null && Controller.ValorVuelto() > 0) buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto (kaching)")};
        else if (Controller.VerProducto() == null && Controller.ValorVuelto() > 0) buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto (kaching)")};
        else if (Controller.VerProducto() != null && Controller.ValorVuelto() == 0) buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto")};
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
            Controller.RepaintAll();
            System.out.println("glu glu, " + SADMAN.consumir());
        }
        /* TODO: Supongo que no se hace nada con este vuelto una vez que esta fuera del expendedor?*/
        else if (e.getSource() == buttons[1] && Controller.ValorVuelto() > 0) {
            Controller.GetVueltoAll();
            Controller.RepaintAll();
            System.out.println("Saqueaste la maquina");
        }
    }
}

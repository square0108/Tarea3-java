package frontend;
import backend.Moneda;
import backend.Producto;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelRetiros extends JPanel implements ActionListener{
    private JButton[] buttons;
    private final PanelComprador panelComprador;

    /**
     * JPanel que posee dos botones: Retirar Producto, y Retirar Vuelto. Estos solo son utilizables una vez que se ha realizado una compra exitosa, o bien se intento comprar algo con dinero insuficiente.
     * @param p PanelComprador al que pertenece este panel
     */
    public PanelRetiros(PanelComprador p) {
        this.setLayout(new GridLayout(2,1));

        this.panelComprador = p;
        buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto")};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
    }

    /**
     * Actualiza el texto de los botones de acuerdo con el estado de la compra, es decir, si el producto se ha retirado o no, si el vuelto se ha retirado o no, si no hay nada que retirar (estado default)...
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* como se crean nuevos botones, se saca el ActionListener de los anteriores para no causar problemas. */
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].removeActionListener(this);
            this.remove(buttons[i]);
        }

        /*          Hay Producto?   Hay Vuelto?
        * Caso 1          NO            NO
        * Caso 2          SI            NO
        * Caso 3          NO            SI
        * Caso 4          SI            SI
        * */
        if (Controller.VerProducto() == null && Controller.VerVuelto(0) == null) buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto")};
        else if (Controller.VerProducto() != null && Controller.VerVuelto(0) == null) buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto")};
        else if (Controller.VerProducto() == null && Controller.VerVuelto(0) != null) buttons = new JButton[]{new JButton("Retirar Producto"), new JButton("Retirar Vuelto (kaching)")};
        else buttons = new JButton[]{new JButton("Retirar Producto (1 disponible)"), new JButton("Retirar Vuelto (kaching)")};

        /* agregar los nuevos botones como Listeners */
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
        validate();
    }

    /**
     * Boton RetirarProducto: Si es que hay un producto presente (verProducto() != null), este se retira mediante Controller y se consume inmediatamente.
     * Boton RetirarVuelto: Si es que hay vuelto, checkeando el primer indice del array MonVu, (verVuelto(0) != null), se retira el vuelto completo y se almacena en un array de size fijo.
     * Dicho array de size fijo se utiliza para dibujar las monedas de Comprador, y cambia con cada retiro de vuelto que se hace.
     * @param e the event to be processed (click en boton Retirar Producto, o boton Retirar Vuelto)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* source: Retirar Producto */
        if (e.getSource() == buttons[0] && Controller.VerProducto() != null) {
            Producto SADMAN = Controller.RetirarProducto();
            System.out.println("glu glu, " + SADMAN.consumir());

            Controller.RepaintAll();
        }
        /* source: Retirar Vuelto*/
        else if (e.getSource() == buttons[1] && Controller.VerVuelto(0) != null) {
            /* Se guardan las Monedas en un arreglo de size fijo. */
            Moneda[] vuelto = Controller.RetirarTodoVuelto();

            int sum = 0;
            for (int i = 0; i < vuelto.length; i++) {
                sum += vuelto[i].getValor();
                this.panelComprador.getMonedasComprador().add(vuelto[i]);
            }
            System.out.println("Retiraste vuelto, Total: $" + sum);

            Controller.RepaintAll();
        }
    }
}

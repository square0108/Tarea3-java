package frontend;
import backend.Catalogo;
import backend.NoHayProductoException;
import backend.PagoIncorrectoException;
import backend.PagoInsuficienteException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PanelBotones extends JPanel implements ActionListener {
    private final JButton[] botones;
    private final PanelComprador panelComprador;

    /**
     * Botones[] es un array fijo conteniendo los botones para comprar productos. Cada uno tiene un ActionListener que escucha si el boton ha sido presionado.
     * @param p Referencia al PanelComprador al cual pertenece este JPanel.
     */
    public PanelBotones(PanelComprador p){
        this.panelComprador = p;
        this.setLayout(new GridLayout(5,1));
        this.botones = new JButton[5];
        botones[0] = new JButton("Coca Cola " + "($" + Catalogo.COCA.precio + ")");
        botones[1] = new JButton("Sprite " + "($" + Catalogo.SPRITE.precio + ")");
        botones[2] = new JButton("Fanta " + "($" + Catalogo.FANTA.precio + ")");
        botones[3] = new JButton("Snickers " + "($" + Catalogo.SNICKERS.precio + ")");
        botones[4] = new JButton("Super 8 " + "($" + Catalogo.SUPER8.precio + ")");

        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
            this.add(botones[i]);
        }
    }

    /**
     * Notar que el boton no hace nada si hay un producto disponible para retirar.
     * Si el pago es insuficiente no se compra nada y se devuelve la misma moneda. (Esto es manejado por las excepciones del backend, que depositan la moneda en MonVu).
     * @param e the event to be processed (en este caso mouseclick, a traves de e.getSource() == botones[i]).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Se podria poner de forma más elegante, es solo para probar
        if (Controller.VerProducto() !=null){
            JOptionPane.showMessageDialog(null,"ERROR: Recoja el producto en bandeja");
        }
        //--------------
        for (int i = 0; i < botones.length; i++) {
            if (e.getSource() == botones[i] && Controller.VerProducto() == null) {
                System.out.println("yay");
                try {
                    Controller.ComprarProducto(i, Controller.CrearMoneda(panelComprador.getValMonedaSelect()));
                    Controller.RepaintAll();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}

package frontend;
import backend.Catalogo;
import backend.NoHayProductoException;
import backend.PagoIncorrectoException;
import backend.PagoInsuficienteException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * "Subpanel" de PanelComprador que contiene los botones utilizados por el usuario para comprar productos.
 */
public class PanelBotones extends JPanel implements ActionListener {
    /* Contiene los botones para comprar productos */
    private final JButton[] botones;
    /* Referencia al PanelComprador al que pertenece  */
    private final PanelComprador panelComprador;

    /**
     * Constructor de PanelBotones
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

        /* a cada boton de compra se le agrega un ActionListener */
        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
            this.add(botones[i]);
        }
    }

    /**
     * Override que maneja los eventos al presionar los botones de compra.
     * @param e the event to be processed (en este caso mouseclick, a traves de e.getSource() == botones[i]).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* En caso de tratar de comprar otro producto sin haber retirado el anterior, se desplega un error. */
        if (Controller.VerProducto() !=null){
            JOptionPane.showMessageDialog(null,"ERROR: Recoja el producto en bandeja");
        }
        //--------------
        /* Se intenta realizar una compra. La moneda se crea en este instante (mediante Controller), eligiendo un valor que corresponde con el valor seleccionado en panelSelectMoneda */
        /* Los casos de error (moneda Null o sin seleccionar ninguna, pago insuficiente, producto sin stock...) son manejados en backend. */
        for (int i = 0; i < botones.length; i++) {
            if (e.getSource() == botones[i] && Controller.VerProducto() == null) {
                System.out.println("Intentando compra...");
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

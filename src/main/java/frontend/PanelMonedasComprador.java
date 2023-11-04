package frontend;
import backend.Deposito;
import backend.Moneda;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/* Esta implementacion se la he copiado casi toda a Guillermo desde su clase PanelDepositoMonedas. Grande Guillermo. */

/**
 * Panel en el cual se ven graficamente las monedas que posee "Comprador" (el usuario).
 */
public class PanelMonedasComprador extends JPanel {
    /* Imagenes correspondientes a cada tipo de moneda */
    private Image image100;
    private Image image500;
    private Image image1000;
    private Image image1500;
    /* Dimensiones de las monedas */
    private int img_width;
    private int img_height;
    /* Referencia a PanelComprador al cual pertenece esta instancia */
    private PanelComprador panelComprador;

    public PanelMonedasComprador(PanelComprador p) {
        this.panelComprador = p;
        this.setLayout(new GridLayout());
        img_width = 50;
        img_height = 50;

        image100 = new ImageIcon("resources/moneda100.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image500 = new ImageIcon("resources/moneda500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1000 = new ImageIcon("resources/moneda1000.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1500 = new ImageIcon("resources/moneda1500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
    }

    /**
     * Metodo interno utilizado por el override a paintComponent. Asigna la imagen de la moneda correspondiente con el int ingresado (asigna monedas de 100 con int 100)
     * @param valor Valor $ de la moneda cuya imagen se desea obtener
     * @return Imagen de la moneda con el valor correspondiente
     */
    private Image getImage(int valor){
        return switch (valor) {
            case 100 -> image100;
            case 500 -> image500;
            case 1000 -> image1000;
            case 1500 -> image1500;
            default -> {
                System.out.println("Hubo un error, no se pudo cargar imagen");
                yield null;
            }
        };
    }

    /**
     * Override que pinta monedas en PanelMonedasComprador cada vez que se retiran monedas del vuelto. Poseen el mismo numero de serie y valor.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());

        /* Se aloja espacio para cada moneda dividiendo el width del espacio, por el size() del Deposito MonedasComprador. */
        /* MonedasComprador.size() crece dinamicamente mientras mas vuelto acumula el usuario. Idealmente hubiese ocupado varias filas de espacio para esto, pero no pude hacerlo... */
        for (int i=0; i<panelComprador.getMonedasComprador().size(); i++){
            g.drawImage(getImage(panelComprador.getMonedasComprador().getItem(i).getValor()),i * getWidth()/panelComprador.getMonedasComprador().size(), 20,this);
            g.drawString(Controller.TruncarSerie(panelComprador.getMonedasComprador().getItem(i).getSerie()), i * getWidth()/panelComprador.getMonedasComprador().size(),img_height+30);
        }
    }
}

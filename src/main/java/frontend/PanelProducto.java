package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase usada para representar de forma grafica el compartimento por donde sale un producto en expendedor
 *TODO: CAMBIAR DESCRIPCIÓN XD
 */
public class PanelProducto extends JPanel {
    private Producto producto;
    private Image imagecoca;
    private Image imagesprite;
    private Image imagefanta;
    private Image imagesnickers;
    private Image imagesuper8;
    private int img_width;
    private int img_height;

    public PanelProducto(){
        img_height = 70;
        img_width = 70;
        producto = null;
        imagecoca = new ImageIcon("resources/cocacola.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        imagesprite = new ImageIcon("resources/sprite.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        imagefanta = new ImageIcon("resources/fanta.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        imagesnickers = new ImageIcon("resources/snickers.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        imagesuper8 = new ImageIcon("resources/super8.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
    }
    /*public Producto getProducto(){
        if(this.producto == null){
            return null;
        } else{
            Producto aux = this.producto;
            this.producto = null;
            return aux;
        }
    }

    TODO: Creo que este metodo ya no se va a utilizar

    @Deprecated
    public void setProducto(Producto producto){
        if(this.producto == null){
            this.producto = producto;
        }else{
            System.out.println("Lanzar error sobre que esta lleno");
        }
        // cambiar despues¿?
        repaint();
    }*/
    private Image setImage(){
        if (this.producto instanceof CocaCola){
            return imagecoca;
        } else if (this.producto instanceof Sprite) {
            return imagesprite;
        } else if (this.producto instanceof Fanta) {
            return imagefanta;
        } else if (this.producto instanceof Snickers) {
            return imagesnickers;
        } else if (this.producto instanceof Super8) {
            return imagesuper8;
        }else{
            return null;
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.producto = Controller.VerProducto();
        g.drawRect(0, 0, getWidth(), getHeight());
        if (this.producto !=null){
            g.drawImage(setImage(),20, 20,this);
            g.drawString(String.valueOf(this.producto.getNumSerie()),40,20);
        }

    }
}

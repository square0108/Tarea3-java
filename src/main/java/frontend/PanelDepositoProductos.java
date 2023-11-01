package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa de forma grafica (JPanel) un Deposito con Productos dentro. Al hacer click sobre este,
 * se añade un nuevo producto al deposito.
 */
public class PanelDepositoProductos extends JPanel {
    private Deposito<Producto> deposito;
    private int id;
    private String img_path;
    private Image image;
    private int img_width;
    private int img_height;
    private int contador; // es utilizado para los numSerie de productos agregados

    /**
     * Metodo constructor de PanelDepositoProductos
     * @param deposito Deposito que se desea visualizar de forma grafica
     * @param type  ID del tipo de productos dentro del deposito.
     */
    public PanelDepositoProductos(Deposito<Producto> deposito, int type){
        // POr ahora iniciemos con un tamaño de la imagen determinado acá
        contador = deposito.size()+1;
        img_width = 70;
        img_height = 70;

        this.deposito = deposito;
        /*TODO: Cambiar los numeros por emun de Catalogo*/
        id = type;

        // Esto es para mas que nada configurar la dirección de la imagen
        switch (type){
            case 0:
                id = Catalogo.COCA.id;
                img_path = "resources/cocacola.png";
                break;
            case 1:
                id = Catalogo.SPRITE.id;
                img_path = "resources/sprite.png";
                break;
            case 2:
                id = Catalogo.FANTA.id;
                img_path = "resources/fanta.png";
                break;
            case 3:
                id = Catalogo.SNICKERS.id;
                img_path = "resources/snickers.png";
                break;
            case 4:
                id = Catalogo.SUPER8.id;
                img_path = "resources/super8.png";
                break;
            default:
                System.out.println("Hubo un error, no se pudo cargar imagen");
        }
        image = new ImageIcon(img_path).getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);

        // añadimos un Listener para cuando se hace click con el mouse en el JPanel
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    /**
     * Hace repaint de la vista del deposito
     * TODO: No entiendo muy bien que quiere el profe que hagamos con este metodo.
     */
    public void setXY(){
        repaint();
    }

    /**
     * Metodo usado de forma interna por el Depósito para añadir productos del mismo tipo a este.
     * Notar que es usado en el MouseListener del Panel
     */
    private void add() {
        switch (this.id) {
            case 0:
                deposito.add(new CocaCola(1000 + contador));
                break;
            case 1:
                deposito.add(new Sprite(2000 + contador));
                break;
            case 2:
                deposito.add(new Fanta(3000 + contador));
                break;
            case 3:
                deposito.add(new Snickers(4000 + contador));
                break;
            case 4:
                deposito.add(new Super8(5000 + contador));
                break;
            default:
                System.out.println("Hubo un error al tratar de añadir un item");
        }
        contador++;
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());

        for (int i=0; i<deposito.size(); i++){
            g.drawImage(image,i * getWidth()/deposito.size(), 20,this);
            g.drawString(Integer.toString(deposito.getItem(i).getNumSerie()),i * getWidth()/deposito.size()+20,15);
        }
    }
}
package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
/**
 * Clase que representa de forma grafica un Deposito con Monedas dentro.
 */
public class PanelDepositoMonedas extends JPanel {
    private Deposito<Moneda> deposito;
    private String img_path;
    private Image image100;
    private Image image500;
    private Image image1000;
    private Image image1500;
    private int img_width;
    private int img_height;

    /**
     * Metodo constructor de PanelDepositoMonedas.
     * @param deposito Deposito del tipo "Moneda" el cual se vera reflejado de forma grafica.
     */
    public PanelDepositoMonedas(Deposito<Moneda> deposito){

        // las monedas van a ser cuadradas
        img_width = 50;
        img_height = 50;

        this.deposito = deposito;
        image100 = new ImageIcon("resources/moneda100.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image500 = new ImageIcon("resources/moneda500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1000 = new ImageIcon("resources/moneda1000.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1500 = new ImageIcon("resources/moneda1500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
    }
    /**
     * Metodo interno de PanelDepositoMoneda, el cual selecciona que textura poner para cada tipo de moneda.
     * @param valor Valor de la moneda.
     * @return textura de la moneda correspondiente: Image
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
    // Hace un update de la vista, nose porque tiene que ser setXY ¿?
    public void setXY(){
        repaint();
    }

    /**
     *
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());

        for (int i=0; i<deposito.size(); i++){
            g.drawImage(getImage(deposito.getItem(i).getValor()),i * getWidth()/deposito.size(), 20,this);
            g.drawString(Controller.TruncarSerie(deposito.getItem(i).getSerie()), i * getWidth()/deposito.size(),img_height+30);
        }
    }
}

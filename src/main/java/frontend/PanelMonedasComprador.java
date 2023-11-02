package frontend;
import javax.swing.*;
import java.awt.*;

/* Esta parte se la he copiado casi toda a Guillermo. Grande Guillermo. */

public class PanelMonedasComprador extends JPanel {
    private Image image100;
    private Image image500;
    private Image image1000;
    private Image image1500;
    private int img_width;
    private int img_height;
    private int MonedasEnPosesion = 0;

    public PanelMonedasComprador() {
        img_width = 50;
        img_height = 50;

        image100 = new ImageIcon("resources/moneda100.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image500 = new ImageIcon("resources/moneda500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1000 = new ImageIcon("resources/moneda1000.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
        image1500 = new ImageIcon("resources/moneda1500.png").getImage().getScaledInstance(img_width, img_height,java.awt.Image.SCALE_SMOOTH);
    }

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
    /* TODO: pintar monedas que guarda Comprador como vuelto */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());

        validate();
    }
}

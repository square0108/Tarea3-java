package frontend;
import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private GridLayout grid;
    private Actualizador actualizador;
    public PanelPrincipal () {
        Controller.setPanel(this);
        grid = new GridLayout(1,2);
        this.setLayout(grid);
        actualizador = new Actualizador();

        com = new PanelComprador();
        exp = new PanelExpendedor();
        this.add(com);
        this.add(exp);
        actualizador.addComponent(com);
        actualizador.addComponent(exp);
        Timer actualizarTimer = new Timer(500, actualizador);
        actualizarTimer.setRepeats(true);
        actualizarTimer.start();
    }
}

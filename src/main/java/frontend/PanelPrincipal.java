package frontend;
import java.awt.*;
import javax.swing.*;

/**
 * Panel donde se contienen todos los demas de la aplicacion.
 */
public class PanelPrincipal extends JPanel {
    private static PanelComprador com;
    private static PanelExpendedor exp;

    public PanelPrincipal () {
        /* Se agrega esta instancia como el PanelPrincipal asociado a Controller, esto es necesario para utilizar Controller.RepaintAll() */
        Controller.setPanelPrincipal(this);
        this.setLayout(new GridLayout(1, 2));

        com = new PanelComprador();
        exp = new PanelExpendedor(Controller.expendedor);
        this.add(com);
        this.add(exp);
    }
}

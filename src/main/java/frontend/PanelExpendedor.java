package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que Representa de forma grafica el funcionamiento de un expendedor.
 */
public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private PanelDepositoProductos depositococa;
    private PanelDepositoProductos depositosprite;
    private PanelDepositoProductos depositofanta;
    private PanelDepositoProductos depositosnickers;
    private PanelDepositoProductos depositosuper8;
    private JPanel panelinferior;
    private PanelDepositoMonedas depositovuelto;
    private PanelProducto productoaretirar;

    /**
     * Método constructor de expendedor. Este inicializa la configuración de la vista del panel.
     * @param expendedor Expendedor a ser Reflejado de forma grafica.
     */
    public PanelExpendedor(Expendedor expendedor){

        this.setLayout(new GridLayout(6,1));
        this.expendedor = expendedor;

        depositococa = new PanelDepositoProductos(this.expendedor.getCoca(), Catalogo.COCA.id);
        depositosprite = new PanelDepositoProductos(this.expendedor.getSprite(), Catalogo.SPRITE.id);
        depositofanta = new PanelDepositoProductos(this.expendedor.getFanta(), Catalogo.FANTA.id);
        depositosnickers= new PanelDepositoProductos(this.expendedor.getSnickers(), Catalogo.SNICKERS.id);
        depositosuper8 = new PanelDepositoProductos(this.expendedor.getSuper8(), Catalogo.SUPER8.id);
        depositovuelto = new PanelDepositoMonedas(this.expendedor.getMonVu());

        productoaretirar = new PanelProducto();
        productoaretirar.setPreferredSize(new Dimension(100,100));

        this.add(depositococa);
        this.add(depositosprite);
        this.add(depositofanta);
        this.add(depositosnickers);
        this.add(depositosuper8);

        panelinferior = new JPanel(new BorderLayout());
        panelinferior.add(productoaretirar,BorderLayout.WEST);
        panelinferior.add(depositovuelto,BorderLayout.CENTER);

        this.add(panelinferior);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        depositovuelto.paint(g);
        depositosuper8.paint(g);
        depositosnickers.paint(g);
        depositofanta.paint(g);
        depositosprite.paint(g);
        depositococa.paint(g);
    }
}

package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public PanelExpendedor(Expendedor expendedor){
        // TODO: El expendedor se debe crear dentro de este constructor

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
    /* borrar esto >?

    // Tengo que ver como devolver esto
    public Producto getProducto(){
        // se debe heredar de Panel producto
        return null;
    }
    public void comprarProducto(int id,Moneda moneda){
        if (this.productocomprado != null){
            System.out.println("Ya se compro un producto");
        }
        else{
            try {
                this.productocomprado = this.expendedor.comprarProducto(id,moneda);
            }catch (NoHayProductoException e){
                System.out.println("No hay mas productos");

            }catch (PagoIncorrectoException e){
                System.out.println("No se puede pagar con una moneda null");

            }catch (PagoInsuficienteException e){
                System.out.println("No tienes la cantidad de dinero suficiente");
            }
        }
        repaint();
    }

    */

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

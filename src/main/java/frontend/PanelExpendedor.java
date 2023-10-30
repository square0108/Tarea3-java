package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private PanelDepositoProductos depositococa;
    private PanelDepositoProductos depositosprite;
    private PanelDepositoProductos depositofanta;
    private PanelDepositoProductos depositosnickers;
    private PanelDepositoProductos depositosuper8;
    private PanelDepositoMonedas depositovuelto;
    private Producto productocomprado;
    public PanelExpendedor(Expendedor expendedor){
        this.setLayout(new GridLayout(7,1));
        this.expendedor = expendedor;
        productocomprado = null;

        depositococa = new PanelDepositoProductos(expendedor.getCoca(), Catalogo.COCA.id);
        depositosprite = new PanelDepositoProductos(expendedor.getSprite(), Catalogo.SPRITE.id);
        depositofanta = new PanelDepositoProductos(expendedor.getFanta(), Catalogo.FANTA.id);
        depositosnickers= new PanelDepositoProductos(expendedor.getSnickers(), Catalogo.SNICKERS.id);
        depositosuper8 = new PanelDepositoProductos(expendedor.getSuper8(), Catalogo.SUPER8.id);
        depositovuelto = new PanelDepositoMonedas(expendedor.getMonVu());

        this.add(depositococa);
        this.add(depositosprite);
        this.add(depositofanta);
        this.add(depositosnickers);
        this.add(depositosuper8);
        this.add(depositovuelto);
    }
    // Tengo que ver como devolver esto
    public Producto getProducto(){
        Producto producto;
        producto = this.productocomprado;
        this.productocomprado = null;
        return producto;
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

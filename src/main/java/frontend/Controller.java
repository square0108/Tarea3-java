package frontend;
import backend.*;

import javax.swing.*;

public class Controller {
    public static Expendedor expendedor = new Expendedor(4);
    private static PanelPrincipal panelPrincipal;

    public Controller() {}

    public static void setPanelPrincipal(PanelPrincipal p) {
        panelPrincipal = p;
    }

    public static void ComprarProducto(int p, Moneda m) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        try {
            expendedor.comprarProducto(p, m);
        } catch (NoHayProductoException e){
            JOptionPane.showMessageDialog(null,"ERROR: No hay más productos");
            System.out.println("No hay mas productos de este tipo");

        }catch (PagoIncorrectoException e){
            JOptionPane.showMessageDialog(null,"ERROR: Seleccione un tipo de moneda");
            System.out.println("No se puede pagar con una moneda null");

        }catch (PagoInsuficienteException e){
            JOptionPane.showMessageDialog(null,"ERROR: No tienes la cantidad de dinero suficiente");
            System.out.println("No tienes la cantidad de dinero suficiente");
        }
        System.out.println("Producto a retirar: " + VerProducto());
    }

    public static Moneda CrearMoneda(int valor) {
        if (valor == 100) return new Moneda100();
        else if (valor == 500) return new Moneda500();
        else if (valor == 1000) return new Moneda1000();
        else if (valor == 1500) return new Moneda1500();
        else return null;
    }

    public static Producto VerProducto() {return expendedor.verProductoAlmacenado();}

    public static Producto RetirarProducto() {return expendedor.retirarProductoAlmacenado();}

    public static Moneda VerVuelto(int index) {
        if (index >= expendedor.getMonVu().size()) return null;
        else return expendedor.getMonVu().getItem(index);
    }

    public static Moneda[] RetirarTodoVuelto() {
        Moneda[] vuelto = new Moneda[expendedor.getMonVu().size()];
        for (int i = 0; i < vuelto.length; i++) {
            vuelto[i] = expendedor.getVuelto();
        }
        return vuelto;
    }

    public static String TruncarSerie(String numSerie) {
        int arroba = numSerie.lastIndexOf('@');
        return numSerie.substring(arroba + 1);
    }
    
    public static void RepaintAll() {
        panelPrincipal.repaint();
    }

}


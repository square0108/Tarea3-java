package frontend;
import backend.*;

import javax.swing.*;

/**
 * Utility class que usa principalmente PanelComprador y sus subpaneles para efectuar cambios sobre otras secciones del frontend.
 */
public class Controller {
    /* Expendedor "interno" desde donde todos los paneles obtienen informacion. */
    public static Expendedor expendedor = new Expendedor(4);
    /* PanelPrincipal asociado a Controller. */
    private static PanelPrincipal panelPrincipal;

    public Controller() {}

    /**
     * Actualiza la instancia de PanelPrincipal que se esta controlando.
     * @param p PanelPrincipal que utiliza Controller
     */
    public static void setPanelPrincipal(PanelPrincipal p) {
        panelPrincipal = p;
    }

    /**
     * Metodo utilizado para llamar comprarProducto() desde Expendedor, sin tener que llamarlo a traves de un Comprador (deprecated).
     * @param p int Índice del producto a comprar.
     * @param m Moneda Moneda con la que se intentara comprar
     * @throws NoHayProductoException Ocurre cuando no queda stock del producto deseado
     * @throws PagoInsuficienteException Ocurre cuando el valor de la Moneda es inferior al precio del producto deseado
     * @throws PagoIncorrectoException Ocurre si se intenta comprar desde la interfaz sin haber seleccionado una moneda
     */
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

    /**
     * Crea una moneda del valor especificado.
     * @param valor Valor $ que desea tener en la moneda
     * @return Moneda creada
     */
    public static Moneda CrearMoneda(int valor) {
        if (valor == 100) return new Moneda100();
        else if (valor == 500) return new Moneda500();
        else if (valor == 1000) return new Moneda1000();
        else if (valor == 1500) return new Moneda1500();
        else return null;
    }

    /**
     * Permite "ver" (sin retirar) el producto que se encuentra almacenado en el depósito de retiro de Expendedor.
     * @return Producto disponible para retirar. Si no hay ninguno, retorna null.
     */
    public static Producto VerProducto() {return expendedor.verProductoAlmacenado();}

    /**
     Retira el producto que se encuentra almacenado en el depósito de retiro de Expendedor.
     * @return Producto retirado. Si no hay ninguno, retorna null. Un retiro exitoso cambia el producto almacenado a null.
     */
    public static Producto RetirarProducto() {return expendedor.retirarProductoAlmacenado();}

    /**
     * Permite "ver" (sin retirar) alguna moneda del Deposito monVu en el indice especificado.
     * @param index Posicion del ArrayList de Moneda's vuelto que se desea "ver".
     * @return Moneda presente en el indice checkeado. Si ninguna posicion coincide con el indice, retorna null.
     */
    public static Moneda VerVuelto(int index) {
        if (index >= expendedor.getMonVu().size()) return null;
        else return expendedor.getMonVu().getItem(index);
    }

    /**
     * Retira todas las monedas de vuelto presentes en monVu.
     * @return Array Moneda[] de size fijo que contiene el vuelto de la última compra realizada, o bien de todas las compras realizadas desde la última vez que se retiró vuelto.
     */
    public static Moneda[] RetirarTodoVuelto() {
        Moneda[] vuelto = new Moneda[expendedor.getMonVu().size()];
        for (int i = 0; i < vuelto.length; i++) {
            vuelto[i] = expendedor.getVuelto();
        }
        return vuelto;
    }

    /**
     * Trunca una string de referencia de un objeto (es decir, los numeros de serie de las monedas) tal que solo se muestren los caracteres después de "@".
     * @param numSerie Número de serie de la moneda (Reference string)
     * @return Número de serie truncado desde "@".
     */
    public static String TruncarSerie(String numSerie) {
        int arroba = numSerie.lastIndexOf('@');
        return numSerie.substring(arroba + 1);
    }

    /**
     * Llama repaint() sobre el PanelPrincipal, efectivamente realizando repaint() sobre toda la interfaz.
     */
    public static void RepaintAll() {
        panelPrincipal.repaint();
    }

}


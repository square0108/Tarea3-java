package frontend;
import backend.*;

public class Controller {
    private static Expendedor expendedor = new Expendedor(3);
    private static boolean CompraExitosaFlag = false;
    private static PanelPrincipal panel;
    public static void setPanel(PanelPrincipal p) {
        panel = p;
    }
    public static void CompraExitosa(int p, Moneda m) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(p, m);
        CompraExitosaFlag = true;
        System.out.println("CompraExitosaFlag is now: " + CompraExitosaFlag);
    }
    public static Moneda CrearMoneda(int valor) {
        if (valor == 100) return new Moneda100();
        else if (valor == 500) return new Moneda500();
        else if (valor == 1000) return new Moneda1000();
        else if (valor == 1500) return new Moneda1500();
        else return null;
    }
    public static boolean HayProductoComprado() {
        return CompraExitosaFlag;
    }
    public static Producto GetProducto() {
        CompraExitosaFlag = false;
        System.out.println("CompraExitosaFlag is now: " + CompraExitosaFlag);
        return expendedor.getProducto();
    }
}


package frontend;
import backend.*;

public class Controller {
    private static Expendedor expendedor;
    public Controller() {
        expendedor = new Expendedor(3);
    }
    public static void CompraExitosa(int p, Moneda m) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        expendedor.comprarProducto(p, m);
    }
    public static Moneda crearMoneda(int valor) {
        if (valor == 100) return new Moneda100();
        else if (valor == 500) return new Moneda500();
        else if (valor == 1000) return new Moneda1000();
        else if (valor == 1500) return new Moneda1500();
        else return null;
    }
}

package frontend;
import backend.*;

/* todo: implementar panelcomprador de una forma que no tenga que usar esto? o bien utilizar este Expendedor static para todo */

public class Controller {
    public static Expendedor expendedor = new Expendedor(4);
    private static Producto ProductoARetirar = null;

    public static void CompraExitosa(int p, Moneda m) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        try {
            ProductoARetirar = expendedor.comprarProducto(p, m);
        } catch (NoHayProductoException e){
            System.out.println("No hay mas productos");

        }catch (PagoIncorrectoException e){
            System.out.println("No se puede pagar con una moneda null");

        }catch (PagoInsuficienteException e){
            System.out.println("No tienes la cantidad de dinero suficiente");
        }
        System.out.println("Producto a retirar: " + ProductoARetirar);
    }
    public static Moneda CrearMoneda(int valor) {
        if (valor == 100) return new Moneda100();
        else if (valor == 500) return new Moneda500();
        else if (valor == 1000) return new Moneda1000();
        else if (valor == 1500) return new Moneda1500();
        else return null;
    }
    public static Producto VerProducto() {return ProductoARetirar;}
    public static Producto GetProducto() {
        Producto swap = ProductoARetirar;
        ProductoARetirar = null;
        return swap;
    }

}

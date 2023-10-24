package backend;
/**
 * Clase abstracta que entrega las funcionalidades de un Dulce.
 * @see Super8
 * @see Snickers
 */
public abstract class Dulce extends Producto {
    public Dulce(int serie) {
        super(serie);
    }
    public abstract String consumir();
}

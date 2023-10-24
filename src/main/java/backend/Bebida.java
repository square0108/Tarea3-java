package backend;

/**
 * Clase abstracta que entrega las funcionalidades de una Bebida.
 * @see CocaCola
 * @see Fanta
 * @see Sprite
 */
public abstract class Bebida extends Producto {
    public Bebida(int serie){
        super(serie);
    }
    public abstract String consumir();
}

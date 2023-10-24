package backend;

/**
 * Clase que simula el comportamiento de una bebida Fanta.
 * @see Bebida
 * @see Sprite
 * @see CocaCola
 */
public class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    public String consumir() {return "fanta";}
}

package backend;
/**
 * Clase que simula el comportamiento de una bebida Sprite.
 * @see Bebida
 * @see CocaCola
 * @see Fanta
 */
public class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String consumir() {return "sprite";}
}

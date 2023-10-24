package backend;
/**
 * Clase que simula el comportamiento de una bebida Coca-Cola.
 * @see Bebida
 * @see Sprite
 * @see Fanta
 */
public class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String consumir() {return "coca cola";}
}

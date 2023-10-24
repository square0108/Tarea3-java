package backend;
/**
 * Clase que simula el comportamiento de un dulce Super 8.
 * @see Dulce
 * @see Snickers
 */
public class Super8 extends Dulce {
    public Super8(int serie) {
        super(serie);
    }
    public String consumir() {return "super8";}
}

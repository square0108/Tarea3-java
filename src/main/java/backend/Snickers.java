package backend;
/**
 * Clase que simula el comportamiento de un dulce Snickers.
 * @see Dulce
 * @see Super8
 */
public class Snickers extends Dulce{
    public Snickers(int serie) {
        super(serie);
    }
    public String consumir() {return "snickers";}
}

package backend;
/**
 * Representa una moneda con valor 100. Puede ser utilizada por <code>Comprador</code> para comprar en <code>Expendor</code>.
 * @see Moneda
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda1500
 */
public class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public int getValor() {return 100;}
}

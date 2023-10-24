package backend;
/**
 * Representa una moneda con valor 1500. Puede ser utilizada por <code>Comprador</code> para comprar en <code>Expendor</code>.
 * @see Moneda
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda100
 */
public class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }
    public int getValor() {return 1500;}
}

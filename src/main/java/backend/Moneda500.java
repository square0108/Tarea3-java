package backend;
/**
 * Representa una moneda con valor 500. Puede ser utilizada por <code>Comprador</code> para comprar en <code>Expendor</code>.
 * @see Moneda
 * @see Moneda100
 * @see Moneda1000
 * @see Moneda1500
 */
public class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }
    public int getValor() {return 500;}
}

package backend;
/**
 * Clase abstracta que entrega las funcionalidades de un Producto.
 * @see Bebida
 * @see Dulce
 */
public abstract class Producto {
    private final int numSerie;

    /**
     * Producto emula a los distintos productos que puede contener el Expendedor en sus Depositos. Posee subclases "genericas" (Bebida, Dulce) cuyas subclases representan productos unicos o especificos de la vida real (CocaCola, Snickers...)
     * @param serie Entero que representa el numero de serie del producto.
     */
    public Producto(int serie) {
        this.numSerie = serie;
    }

    /**
     * Emula el acto de consumir (comer, beber, etc...) el producto comprado. Es implementado individualmente por las subclases que representan productos unicos (CocaCola, Snickers, etc.)
     * @return String correspondiente al "sabor" del producto.
     */
    public abstract String consumir();
    public int getNumSerie() {return this.numSerie;}
}

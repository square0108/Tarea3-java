package backend;

/**
 * Enumerador que describe los productos que posee <code>Expendedor</code>
 * @see Expendedor
 */
public enum Catalogo {
    COCA(0, 100),
    SPRITE(1, 200),
    FANTA(2, 300),
    SNICKERS(3, 600),
    SUPER8(4, 700);
    public final int id;
    public final int precio;

    /**
     * Enumeration que contiene constantes representando los productos disponibles para seleccionar desde un Expendedor.
     * @param Identidad int, se utiliza para seleccionar el producto.
     * @param Precio int, minimo monto necesario para pagar el producto.
     */
    Catalogo(int Identidad, int Precio) {
        this.id = Identidad;
        this.precio = Precio;
    }
}

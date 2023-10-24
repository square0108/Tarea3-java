package backend;

/**
 * Ocurre cuando el valor de la moneda utilizada para la compra es menor al precio del producto deseado.
 * Se ingresa la moneda de Comprador al deposito de vueltos del expendedor.
 */
public class PagoInsuficienteException extends Exception {
    /**
     * Metodo constructor de PagoInsuficienteException
     * @param expendedorFail Expendedor donde la compra ha fallado
     * @param monedaFail Moneda cuyo valor fue insuficiente
     * @see PagoInsuficienteException
     */
    public PagoInsuficienteException(Expendedor expendedorFail, Moneda monedaFail) {
        expendedorFail.getMonVu().add(monedaFail);
    }
}

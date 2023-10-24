package testing;

import backend.*;
import backend.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Expendedor expFive = new Expendedor(5);
    private Expendedor expEmpty = new Expendedor(-5);

    @Test
    @DisplayName("Comprador recibe su vuelto y sabor, al realizar una compra exitosa.")
    void CompradorTieneVueltoYSabor() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Comprador Pepe = new Comprador(expFive, Catalogo.SPRITE.id, new Moneda500());
        assertEquals(300, Pepe.cuantoVuelto());
        assertEquals("sprite", Pepe.getSabor());

        Pepe = new Comprador(expFive, Catalogo.SNICKERS.id, new Moneda1000());
        assertEquals(400, Pepe.cuantoVuelto());
        assertEquals("snickers", Pepe.getSabor());
    }

    @Test
    @DisplayName("A comprador no le alcanza el dinero")
    void compradorNoAlcanza() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(10);
        assertThrows(PagoInsuficienteException.class, () -> {
            Comprador comprador = new Comprador(expendedor, Catalogo.SUPER8.id, new Moneda100());
        });
    }

    @Test
    @DisplayName("Comprador intenta comprar con null")
    void compradorCompraNull() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(10);
        assertThrows(PagoIncorrectoException.class, () -> {
            Comprador comprador = new Comprador(expendedor, Catalogo.SUPER8.id, null);
        });
    }

    @Test
    @DisplayName("Comprador intenta comprar sin existencias")
    void compradorCompraSinExistencias() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedorvacio = new Expendedor(0);
        assertThrows(NoHayProductoException.class, () -> {
            Comprador comprador = new Comprador(expendedorvacio, Catalogo.SUPER8.id, new Moneda1500());
        });

        Expendedor expendedorlleno = new Expendedor(100);
        assertThrows(NoHayProductoException.class, () -> {
            Comprador comprador1 = new Comprador(expendedorlleno, 999, new Moneda1500());
        });
    }
}
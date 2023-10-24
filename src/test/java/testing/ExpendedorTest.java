package testing;

import backend.*;
import backend.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {

    @Test
    @DisplayName("Creación de Expendedores")
    void creacionExpendedores(){
        assertNotNull(new Expendedor(2));
        assertNotNull(new Expendedor(0));
        assertNotNull(new Expendedor(-10));
        assertNull(new Expendedor(0).getCoca().get());
        assertNotNull(new Expendedor(1).getSnickers().get());
    }

    @Test
    @DisplayName("Compras Exitosas")
    void comprasExitosas() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(10);
        assertNotNull(expendedor.comprarProducto(Catalogo.COCA.id,new Moneda100()));
        assertNotNull(expendedor.comprarProducto(Catalogo.SPRITE.id,new Moneda500()));
        assertNotNull(expendedor.comprarProducto(Catalogo.FANTA.id,new Moneda1000()));
        assertNotNull(expendedor.comprarProducto(Catalogo.SNICKERS.id,new Moneda1500()));
        assertNotNull(expendedor.comprarProducto(Catalogo.SUPER8.id,new Moneda1500()));
    }

    @Test
    @DisplayName("Comprar: Caso No Hay Producto (stock agotado)")
    void noHayProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(1);
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(Catalogo.SPRITE.id,new Moneda1500());
            expendedor.comprarProducto(Catalogo.SPRITE.id,new Moneda1500());
        });
    }

    @Test
    @DisplayName("Comprar: Caso No Hay Producto (ID no existe)")
    void idNoExiste() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(1);
        assertThrows(NoHayProductoException.class, () -> {
            expendedor.comprarProducto(1337, new Moneda100());
        });
    }

    @Test
    @DisplayName("Comprar: Caso Pago Insuficiente")
    void pagoInsuficiente() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor expendedor = new Expendedor(10);
        assertThrows(PagoInsuficienteException.class, () -> {
            expendedor.comprarProducto(Catalogo.SNICKERS.id,new Moneda100());
        });
    }

    @Test
    @DisplayName("Comprar: Caso Pago Incorrecto")
    void pagoIncorrecto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum catalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(10);
        assertThrows(PagoIncorrectoException.class, () -> {
            expendedor.comprarProducto(1,null);
        });
    }

    @Test
    @DisplayName("Método getVuelto")
    void casoGetVuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*Nose como poder utilizar el enum cátalogo aquí dentro*/
        Expendedor expendedor = new Expendedor(10);
        expendedor.getMonVu().add(new Moneda100());
        expendedor.getMonVu().add(new Moneda100());
        assertNotNull(expendedor.getVuelto());
        assertNotNull(expendedor.getVuelto());
        assertNull(expendedor.getVuelto());
        assertNull(expendedor.getVuelto());
    }
}
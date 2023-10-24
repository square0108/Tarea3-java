package testing;

import backend.*;
import backend.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    private Deposito<Producto> productos;
    private Deposito<Moneda> monedas;

    @BeforeEach
    void start() {
        productos = new Deposito<>();
        monedas = new Deposito<>();
    }

    @Test
    @DisplayName("Extraccion desde un deposito vacio entrega null.")
    void GetFromDepositoVacio() {
        assertNull(productos.get());
        assertNull(monedas.get());
    }

    @Test
    @DisplayName("Adicion y Extraccion funcionan correctamente en Bebidas.")
    void GetFromBebidas() {
        CocaCola cokycola = new CocaCola(23);
        Sprite spirt = new Sprite(8);
        Fanta fanter = new Fanta(91);
        productos.add(cokycola);
        productos.add(spirt);
        productos.add(fanter);
        assertEquals(cokycola, productos.get());
        assertEquals(spirt, productos.get());
        assertEquals(fanter, productos.get());
    }

    @Test
    @DisplayName("Adicion y Extraccion funcionan correctamente en Dulces")
    void GetFromDulces() {
        Snickers NoMeGustanLosSnickers = new Snickers(314);
        Super8 MeGustaElSuper8 = new Super8(413);
        productos.add(NoMeGustanLosSnickers);
        productos.add(MeGustaElSuper8);
        assertEquals(productos.get(),NoMeGustanLosSnickers);
        assertEquals(productos.get(),MeGustaElSuper8);
    }

    @Test
    @DisplayName("Adicion y Extraccion funcionan correctamente en Monedas")
    void GetSomeMoney() {
        Moneda100 CienPeso = new Moneda100();
        Moneda QuinientosPeso = new Moneda500();
        Moneda MilPeso = new Moneda1000();
        Moneda MilquinientosPeso = new Moneda1500();
        monedas.add(CienPeso);
        monedas.add(QuinientosPeso);
        monedas.add(MilPeso);
        monedas.add(MilquinientosPeso);
        assertEquals(monedas.get(),CienPeso);
        assertEquals(monedas.get(),QuinientosPeso);
        assertEquals(monedas.get(),MilPeso);
        assertEquals(monedas.get(),MilquinientosPeso);
    }


}
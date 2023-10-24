package testing;

import backend.Moneda100;
import backend.Moneda1000;
import backend.Moneda1500;
import backend.Moneda500;
import backend.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {

    @Test
    @DisplayName("Monedas poseen valor esperado")
    void monedasValorEsperado() {
        assertEquals(100, new Moneda100().getValor());
        assertEquals(500, new Moneda500().getValor());
        assertEquals(1000, new Moneda1000().getValor());
        assertEquals(1500, new Moneda1500().getValor());
    }
    @Test
    @DisplayName("Monedas con el mismo valor")
    void monedasDelMismoValor() {
        assertEquals(0, new Moneda100().compareTo(new Moneda100()));
        assertEquals(0, new Moneda500().compareTo(new Moneda500()));
        assertEquals(0, new Moneda1000().compareTo(new Moneda1000()));
        assertEquals(0, new Moneda1500().compareTo(new Moneda1500()));
    }
    @Test
    @DisplayName("Monedas con distinto valor")
    void monedasDeDistintoValor() {
        assertEquals(-1, new Moneda100().compareTo(new Moneda500()));
        assertEquals(-1, new Moneda100().compareTo(new Moneda1000()));
        assertEquals(-1, new Moneda100().compareTo(new Moneda1500()));

        assertEquals(1, new Moneda500().compareTo(new Moneda100()));
        assertEquals(-1, new Moneda500().compareTo(new Moneda1000()));
        assertEquals(-1, new Moneda500().compareTo(new Moneda1500()));

        assertEquals(1, new Moneda1000().compareTo(new Moneda100()));
        assertEquals(1, new Moneda1000().compareTo(new Moneda500()));
        assertEquals(-1, new Moneda1000().compareTo(new Moneda1500()));

        assertEquals(1, new Moneda1500().compareTo(new Moneda100()));
        assertEquals(1, new Moneda1500().compareTo(new Moneda500()));
        assertEquals(1, new Moneda1500().compareTo(new Moneda1000()));
    }
    @Test
    @DisplayName("Metodo getSerie devuelve Referencia")
    void monedaGetSerie() {
        assertNotNull(new Moneda100().getSerie());
        assertNotNull(new Moneda500().getSerie());
        assertNotNull(new Moneda1000().getSerie());
        assertNotNull(new Moneda1500().getSerie());
    }
    @Test
    @DisplayName("Metodo toString funciona de forma correcta")
    void monedaToString() {
        Moneda100 A = new Moneda100();
        String SerieA = A.getSerie();
        assertEquals("Valor: 100, Serie: " + SerieA,A.toString());
        assertNotEquals(SerieA,new Moneda100().toString()); // entregan numeros de serie distintos
    }

}
package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import clases.Cliente;

/**
 * Esta clase contiene pruebas unitarias para la clase Cliente.
 * Se asegura de que el comportamiento de la clase Cliente sea correcto.
 */
public class ClienteTest {

    /**
     * Prueba que verifica el comportamiento del constructor vacío de la clase Cliente.
     * Se espera que la cantidad de compra inicial sea 0.
     */
    @Test
    public void testConstructorVacio() {
        Cliente cliente = new Cliente();
        assertEquals(0, cliente.getCantidadCompra());
    }

    /**
     * Prueba que verifica el comportamiento del constructor con parámetros de la clase Cliente.
     * Se espera que la cantidad de compra inicial sea 0, independientemente de los parámetros proporcionados.
     */
    @Test
    public void testConstructorConParametros() {
        Cliente cliente = new Cliente("12345678Y", "Juan", "Perez", 30, "Calle Falsa 123", "juan.perez@example.com", "contrasena123");
        assertEquals(0, cliente.getCantidadCompra());
    }

    /**
     * Prueba que verifica el comportamiento del método getCantidadCompra de la clase Cliente.
     * Se establece una cantidad de compra y se verifica que el valor retornado sea correcto.
     */
    @Test
    public void testGetCantidadCompra() {
        Cliente cliente = new Cliente();
        cliente.setCantidadCompra(5);
        assertEquals(5, cliente.getCantidadCompra());
    }

    /**
     * Prueba que verifica el comportamiento del método setCantidadCompra de la clase Cliente.
     * Se establece una nueva cantidad de compra y se verifica que el valor retornado sea correcto.
     */
    @Test
    public void testSetCantidadCompra() {
        Cliente cliente = new Cliente();
        cliente.setCantidadCompra(10);
        assertEquals(10, cliente.getCantidadCompra());
    }
}

package tests;

import org.junit.jupiter.api.Test;

import clases.Proveedor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Proveedor.
 * Contiene pruebas unitarias para verificar el correcto funcionamiento de la clase Proveedor.
 */
class ProveedorTest {

	/**
     * Prueba que verifica el comportamiento del constructor vacío de la clase Proveedor.
     * Se asegura de que las propiedades del objeto Proveedor sean null cuando se utiliza el constructor sin parámetros.
     */
	@Test
    public void testConstructorVacio() {
        Proveedor proveedor = new Proveedor();
        assertEquals(0, proveedor.getCodProveedor(), "El código del proveedor debe ser nulo si se usa el constructor vacío.");
        assertNull(proveedor.getNombreProveedor(), "El nombre del proveedor debe ser nulo si se usa el constructor vacío.");
        assertEquals(0, proveedor.getTelefono(), "El teléfono del proveedor debe ser nulo si se usa el constructor vacío.");
        assertNull(proveedor.getEmail(), "El correo electrónico del proveedor debe ser nulo si se usa el constructor vacío.");
    }

    /**
     * Prueba que verifica el comportamiento del constructor con parámetros de la clase Proveedor.
     * Se asegura de que las propiedades del objeto Proveedor sean correctamente inicializadas con los valores proporcionados.
     */
    @Test
    public void testConstructorConParametros() {
        int codProveedor = 12345;
        String nombreProveedor = "Proveedor X";
        int telefono = 987654321;
        String email = "proveedorx@ejemplo.com";

        Proveedor proveedor = new Proveedor(codProveedor, nombreProveedor, telefono, email);

        assertEquals(codProveedor, proveedor.getCodProveedor(), "El código del proveedor debe coincidir con el proporcionado.");
        assertEquals(nombreProveedor, proveedor.getNombreProveedor(), "El nombre del proveedor debe coincidir con el proporcionado.");
        assertEquals(telefono, proveedor.getTelefono(), "El teléfono del proveedor debe coincidir con el proporcionado.");
        assertEquals(email, proveedor.getEmail(), "El correo electrónico del proveedor debe coincidir con el proporcionado.");
    }

    /**
     * Prueba que verifica el correcto funcionamiento de los métodos getter y setter de la clase Proveedor.
     * Se asegura de que los valores establecidos a través de los setters sean accesibles a través de los getters.
     */
    @Test
    public void testGettersAndSetters() {
        int codProveedor = 67890;
        String nombreProveedor = "Proveedor Y";
        int telefono = 123456789;
        String email = "proveedy@ejemplo.com";

        Proveedor proveedor = new Proveedor();

        // Setters
        proveedor.setCodProveedor(codProveedor);
        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);

        // Getters
        assertEquals(codProveedor, proveedor.getCodProveedor(), "El código del proveedor debe coincidir con el establecido.");
        assertEquals(nombreProveedor, proveedor.getNombreProveedor(), "El nombre del proveedor debe coincidir con el establecido.");
        assertEquals(telefono, proveedor.getTelefono(), "El teléfono del proveedor debe coincidir con el establecido.");
        assertEquals(email, proveedor.getEmail(), "El correo electrónico del proveedor debe coincidir con el establecido.");
    }
}

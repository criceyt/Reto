package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import clases.Trabajador;

/**
 * Esta clase contiene pruebas unitarias para la clase Trabajador.
 * Se asegura de que el comportamiento de la clase Trabajador sea correcto.
 */
public class TrabajadorTest {

    /**
     * Prueba que verifica el comportamiento del constructor vacío de la clase Trabajador.
     * Se espera que todos los atributos sean nulos o cero por defecto, excepto el salario y el estado de administrador.
     */
    @Test
    public void testConstructorVacio() {
        Trabajador trabajador = new Trabajador();
        assertNull(trabajador.getDni());
        assertNull(trabajador.getNombre());
        assertNull(trabajador.getApellido());
        assertEquals(0, trabajador.getEdad());
        assertNull(trabajador.getDireccion());
        assertNull(trabajador.getEmail());
        assertNull(trabajador.getContrasena());
        assertEquals(0.0f, trabajador.getSalario());
        assertFalse(trabajador.isIs_admin());
    }

    /**
     * Prueba que verifica el comportamiento del constructor con parámetros de la clase Trabajador.
     * Se espera que todos los atributos sean inicializados con los valores proporcionados.
     */
    @Test
    public void testConstructorConParametros() {
        Trabajador trabajador = new Trabajador("12345678Y", "Juan", "Perez", 30, "Calle Falsa 123", "juan.perez@example.com", "contrasena123", 2000.0f, true);
        assertEquals("12345678Y", trabajador.getDni());
        assertEquals("Juan", trabajador.getNombre());
        assertEquals("Perez", trabajador.getApellido());
        assertEquals(30, trabajador.getEdad());
        assertEquals("Calle Falsa 123", trabajador.getDireccion());
        assertEquals("juan.perez@example.com", trabajador.getEmail());
        assertEquals("contrasena123", trabajador.getContrasena());
        assertEquals(2000.0f, trabajador.getSalario());
        assertTrue(trabajador.isIs_admin());
    }

    /**
     * Prueba que verifica el comportamiento de los métodos setters y getters de la clase Trabajador.
     * Se establecen nuevos valores para los atributos y se verifica que los métodos getters devuelvan los valores correctos.
     */
    @Test
    public void testSettersAndGetters() {
        Trabajador trabajador = new Trabajador();
        trabajador.setDni("87654321Z");
        trabajador.setNombre("Ana");
        trabajador.setApellido("Gomez");
        trabajador.setEdad(25);
        trabajador.setDireccion("Avenida Siempre Viva 42");
        trabajador.setEmail("ana.gomez@example.com");
        trabajador.setContrasena("ana123");
        trabajador.setSalario(1500.0f);
        trabajador.setIs_admin(false);

        assertEquals("87654321Z", trabajador.getDni());
        assertEquals("Ana", trabajador.getNombre());
        assertEquals("Gomez", trabajador.getApellido());
        assertEquals(25, trabajador.getEdad());
        assertEquals("Avenida Siempre Viva 42", trabajador.getDireccion());
        assertEquals("ana.gomez@example.com", trabajador.getEmail());
        assertEquals("ana123", trabajador.getContrasena());
        assertEquals(1500.0f, trabajador.getSalario());
        assertFalse(trabajador.isIs_admin());
    }

}


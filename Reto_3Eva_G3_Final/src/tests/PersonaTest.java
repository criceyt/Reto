package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import clases.Persona;

/**
 * Esta clase contiene pruebas unitarias para la clase Persona.
 * Se asegura de que el comportamiento de la clase Persona sea correcto.
 */
public class PersonaTest {

    /**
     * Prueba que verifica el comportamiento del constructor vacío de la clase Persona.
     * Se espera que todos los atributos sean nulos o cero por defecto.
     */
    @Test
    public void testConstructorVacio() {
        Persona persona = new Persona();
        assertNull(persona.getDni());
        assertNull(persona.getNombre());
        assertNull(persona.getApellido());
        assertEquals(0, persona.getEdad());
        assertNull(persona.getDireccion());
        assertNull(persona.getEmail());
        assertNull(persona.getContrasena());
    }

    /**
     * Prueba que verifica el comportamiento del constructor con parámetros de la clase Persona.
     * Se espera que todos los atributos sean inicializados con los valores proporcionados.
     */
    @Test
    public void testConstructorConParametros() {
        Persona persona = new Persona("12345678Y", "Juan", "Perez", 30, "Calle Falsa 123", "juan.perez@example.com", "contrasena123");
        assertEquals("12345678Y", persona.getDni());
        assertEquals("Juan", persona.getNombre());
        assertEquals("Perez", persona.getApellido());
        assertEquals(30, persona.getEdad());
        assertEquals("Calle Falsa 123", persona.getDireccion());
        assertEquals("juan.perez@example.com", persona.getEmail());
        assertEquals("contrasena123", persona.getContrasena());
    }

    /**
     * Prueba que verifica el comportamiento de los métodos setters y getters de la clase Persona.
     * Se establecen nuevos valores para los atributos y se verifica que los métodos getters devuelvan los valores correctos.
     */
    @Test
    public void testSettersAndGetters() {
        Persona persona = new Persona();
        persona.setDni("87654321Z");
        persona.setNombre("Ana");
        persona.setApellido("Gomez");
        persona.setEdad(25);
        persona.setDireccion("Avenida Siempre Viva 42");
        persona.setEmail("ana.gomez@example.com");
        persona.setContrasena("ana123");

        assertEquals("87654321Z", persona.getDni());
        assertEquals("Ana", persona.getNombre());
        assertEquals("Gomez", persona.getApellido());
        assertEquals(25, persona.getEdad());
        assertEquals("Avenida Siempre Viva 42", persona.getDireccion());
        assertEquals("ana.gomez@example.com", persona.getEmail());
        assertEquals("ana123", persona.getContrasena());
    }

}
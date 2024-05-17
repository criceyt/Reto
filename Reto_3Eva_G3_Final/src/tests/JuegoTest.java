package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import clases.Juego;

/**
 * Esta clase contiene pruebas unitarias para la clase Juego.
 * Se asegura de que el comportamiento de la clase Juego sea correcto.
 */
public class JuegoTest {

    /**
     * Prueba que verifica el comportamiento del constructor vacío de la clase Juego.
     * Se espera que todos los atributos sean nulos o cero por defecto.
     */
    @Test
    public void testConstructorVacio() {
        Juego juego = new Juego();
        assertEquals(0, juego.getCodJuego());
        assertNull(juego.getCaratula());
        assertNull(juego.getNombre());
        assertEquals(0, juego.getAnio());
        assertEquals(0.0f, juego.getPrecio());
        assertNull(juego.getGenero());
        assertNull(juego.getDescripcion());
        assertEquals(0, juego.getNumUnidades());
    }

    /**
     * Prueba que verifica el comportamiento del constructor con parámetros de la clase Juego.
     * Se espera que todos los atributos sean inicializados con los valores proporcionados.
     */
    @Test
    public void testConstructorConParametros() {
        Juego juego = new Juego(1, "caratula.jpg", "Juego de Aventura", 2024, 59.99f, "Aventura", "Un juego de aventura épico", 100);
        assertEquals(1, juego.getCodJuego());
        assertEquals("caratula.jpg", juego.getCaratula());
        assertEquals("Juego de Aventura", juego.getNombre());
        assertEquals(2024, juego.getAnio());
        assertEquals(59.99f, juego.getPrecio());
        assertEquals("Aventura", juego.getGenero());
        assertEquals("Un juego de aventura épico", juego.getDescripcion());
        assertEquals(100, juego.getNumUnidades());
    }

    /**
     * Prueba que verifica el comportamiento de los métodos setters y getters de la clase Juego.
     * Se establecen nuevos valores para los atributos y se verifica que los métodos getters devuelvan los valores correctos.
     */
    @Test
    public void testSettersAndGetters() {
        Juego juego = new Juego();
        juego.setCodJuego(2);
        juego.setCaratula("caratula2.jpg");
        juego.setNombre("Juego de Acción");
        juego.setAnio(2023);
        juego.setPrecio(49.99f);
        juego.setGenero("Acción");
        juego.setDescripcion("Un juego de acción emocionante");
        juego.setNumUnidades(50);

        assertEquals(2, juego.getCodJuego());
        assertEquals("caratula2.jpg", juego.getCaratula());
        assertEquals("Juego de Acción", juego.getNombre());
        assertEquals(2023, juego.getAnio());
        assertEquals(49.99f, juego.getPrecio());
        assertEquals("Acción", juego.getGenero());
        assertEquals("Un juego de acción emocionante", juego.getDescripcion());
        assertEquals(50, juego.getNumUnidades());
    }
}


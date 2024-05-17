package excepciones;

import javax.swing.JOptionPane;

/**
 * Esta clase representa una excepción general que puede ser lanzada en la aplicación.
 * Extiende de la clase Exception para permitir un manejo específico de errores inesperados.
 */
public class ErrorGeneral extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Muestra un cuadro de diálogo con un mensaje de error inesperado.
     * Este método utiliza JOptionPane para mostrar el mensaje en una ventana emergente.
     */
    public void mostrarExcepcion() {
        JOptionPane.showMessageDialog(null, "Error inesperado.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }       
}


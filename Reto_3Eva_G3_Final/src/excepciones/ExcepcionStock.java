package excepciones;

import javax.swing.JOptionPane;

/**
 * Esta clase representa una excepción específica relacionada con problemas en el reavastecimiento del stock.
 * Extiende de la clase Exception para permitir un manejo específico de errores relacionados con el stock.
 */
public class ExcepcionStock extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Muestra un cuadro de diálogo con un mensaje de error específico relacionado con el reavastecimiento del stock.
     * Este método utiliza JOptionPane para mostrar el mensaje en una ventana emergente.
     */
    public void mostrarExcepcion() {
        JOptionPane.showMessageDialog(null, "Error en el reavastecimiento del Stock.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}


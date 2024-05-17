package excepciones;

import javax.swing.JOptionPane;

/**
 * Esta clase representa una excepción específica relacionada con errores de inicio de sesión.
 * Extiende de la clase Exception para permitir un manejo específico de errores cuando el usuario o la contraseña son incorrectos.
 */
public class LogInException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Muestra un cuadro de diálogo con un mensaje de error específico relacionado con el inicio de sesión.
     * Este método utiliza JOptionPane para mostrar el mensaje en una ventana emergente, indicando que el usuario o la contraseña son incorrectos.
     */
    public void mostrarExcepcion() {
        JOptionPane.showMessageDialog(null, "Vaya, parece que el usuario o la contraseña \n que has introducido no son correctos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Método para mostrar un mensaje de error cuando se intenta registrar un nuevo usuario con un correo electrónico que ya está asociado a otra cuenta.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el problema.
     */
    public void errorCorreoDuplicado() {
        JOptionPane.showMessageDialog(null, "El correo que has introducido ya tiene una cuenta asociada", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}


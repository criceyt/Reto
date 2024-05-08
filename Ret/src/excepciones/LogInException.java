package excepciones;

import javax.swing.JOptionPane;

public class LogInException extends Exception {
	private static final long serialVersionUID = 1L;

	public void mostrarExcepcion() {
		JOptionPane.showMessageDialog(null, "Error en el inicio de sesion", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}

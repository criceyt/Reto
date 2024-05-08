package excepciones;

import java.awt.Color;

import javax.swing.JOptionPane;

public class ErrorGeneral extends Exception {
	private static final long serialVersionUID = 1L;

	public void mostrarExcepcion() {
		JOptionPane.showMessageDialog(null, "Error inesperado.");
	}		
}

package excepciones;

import javax.swing.JOptionPane;

public class ErrorContraseñaLogin {

	public static void errorContrasenia() {
		// Error que saltra cuando las contraseñas no son iguales

		JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public static void errorDeDatos() {
		// CONTROLAR LAS MOVIDAS

	}

	public static void ErrorDeTrabajadorDatos() {
		// ERROR POR SI LOS DATOS DE ALTA TRABAJADOR ESTUVIERAN MAL
		JOptionPane.showMessageDialog(null, "Los campos de Rojo no son validos", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public static void MensajeAltaTrabajador() {
		// MENSAJE DE ALTA DEL TRABAJADOR
		
		JOptionPane.showMessageDialog(null, "Trabajador introducido con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
		
	}
		
	
}
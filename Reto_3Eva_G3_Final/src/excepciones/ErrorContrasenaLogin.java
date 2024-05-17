package excepciones;

import javax.swing.JOptionPane;

/**
 * Clase ErrorContrasenaLogin que contiene métodos estáticos para mostrar mensajes de error o éxito a través de cuadros de diálogo.
 * Estos mensajes son utilizados para informar al usuario sobre el estado de ciertos procesos, como la validación de contraseñas,
 * el registro de trabajadores, el registro de usuarios en el sistema, y la gestión de clientes.
 */
public class ErrorContrasenaLogin {

    /**
     * Método estático para mostrar un mensaje de error cuando las contraseñas ingresadas no coinciden.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el problema.
     */
    public static void errorContrasenia() {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método estático para mostrar un mensaje de error cuando los datos ingresados para el alta de un trabajador son inválidos.
     * Utiliza un cuadro de diálogo para informar al usuario sobre los campos inválidos.
     */
    public static void ErrorDeTrabajadorDatos() {
        JOptionPane.showMessageDialog(null, "Los campos de Rojo no son validos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método estático para mostrar un mensaje de éxito cuando un trabajador es introducido con éxito en el sistema.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el éxito del proceso.
     */
    public static void MensajeAltaTrabajador() {
        JOptionPane.showMessageDialog(null, "Trabajador introducido con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método estático para mostrar un mensaje de éxito cuando el registro de un usuario en el sistema se ha completado de forma exitosa.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el éxito del registro.
     */
    public static void bienvenidoAlSistema() {
        JOptionPane.showMessageDialog(null, "El registro se ha completado de forma exitosa", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método estático para mostrar un mensaje de error cuando no se encuentra el correo electrónico proporcionado.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el problema y sugerirle verificar la entrada.
     */
    public static void errorGmailNoEncontrado() {
        JOptionPane.showMessageDialog(null, "Vaya, parece que no ha sido encontrado el email \n fijese si esta bien introducido", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método estático para mostrar un mensaje de éxito cuando un cliente es guardado con éxito en el sistema.
     * Utiliza un cuadro de diálogo para informar al usuario sobre el éxito del proceso.
     */
    public static void ClienteNuevoGuardado() {
        JOptionPane.showMessageDialog(null, "Cliente guardado con exito", "ATENTO", JOptionPane.INFORMATION_MESSAGE);
    }
}

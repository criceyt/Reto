package controlador;

/**
 * Esta clase contiene el método principal (main) que es el punto de entrada de la aplicación.
 * Se encarga de iniciar el controlador y mostrar la pantalla de inicio de la aplicación.
 */
public class Main {

	/**
	 * Método principal que se ejecuta al iniciar la aplicación.
	 * Crea una instancia del controlador y muestra la pantalla de inicio.
	 * @param args Argumentos de línea de comandos que pueden ser pasados al método main.
	 */
	public static void main(String[] args) {
		
		// Creación de una instancia del controlador
		Controlador cont = new Controlador();
		
		// Llamada al método para mostrar la pantalla de inicio
		cont.mostrarPantallaInicio();
		
	}
}


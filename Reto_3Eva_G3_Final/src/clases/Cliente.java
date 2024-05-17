package clases;

/**
 * Esta clase representa a un cliente que extiende de la clase Persona.
 * Un cliente tiene atributos adicionales específicos para su gestión en el sistema.
 */
public class Cliente extends Persona {
	
	// Atributos
	
	/**
	 * Variable privada que representa la cantidad de elementos comprados.
	 * Esta variable se utiliza para almacenar la cantidad de productos o servicios adquiridos en una transacción específica.
	 */
	private int cantidadCompra;
	
	// Constructores
	
	/**
	 * Constructor que inicializa un cliente con todos sus atributos.
	 * @param dni El DNI del cliente.
	 * @param nombre El nombre del cliente.
	 * @param apellido El apellido del cliente.
	 * @param edad La edad del cliente.
	 * @param direccion La dirección del cliente.
	 * @param email El correo electrónico del cliente.
	 * @param contrasena La contraseña del cliente.
	 */
	public Cliente(String dni, String nombre, String apellido, int edad, String direccion, String email,
			String contrasena) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
	}
	
	/**
	 * Constructor vacío que inicializa un cliente sin atributos específicos.
	 * Utiliza el constructor vacío de la clase padre Persona.
	 */
	public Cliente() {
		super();
	}
	
	// getters and setters

	/**
	 * Obtiene la cantidad de compra realizada por el cliente.
	 * @return La cantidad de compra.
	 */
	public int getCantidadCompra() {
		return cantidadCompra;
	}

	/**
	 * Establece la cantidad de compra realizada por el cliente.
	 * @param cantidadCompra La nueva cantidad de compra.
	 */
	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
	
}


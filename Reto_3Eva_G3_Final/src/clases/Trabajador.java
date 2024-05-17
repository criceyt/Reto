package clases;

/**
 * Esta clase representa a un trabajador que extiende de la clase Persona.
 * Un trabajador tiene atributos adicionales específicos para su gestión en el sistema.
 */
public class Trabajador extends Persona {
	
	// Atributos
	
	/**
	 * Representa el salario del empleado.
	 * Este valor representa la cantidad monetaria que recibe el empleado por sus servicios prestados.
	 */
	private float salario;
	/**
	 * Indica si el usuario tiene privilegios de administrador.
	 * Un valor true indica que el usuario tiene acceso a funciones de administración,
	 * mientras que un valor false indica que el usuario es un empleado regular sin acceso a estas funciones.
	 */
	private boolean is_admin;
	
	// Constructores
	
	/**
	 * Constructor vacío que inicializa un trabajador sin atributos específicos.
	 */
	public Trabajador() {
		
	}
	
	/**
	 * Constructor que inicializa un trabajador con todos sus atributos, incluyendo los de la clase Persona.
	 * @param dni Documento Nacional de Identidad del trabajador.
	 * @param nombre Nombre del trabajador.
	 * @param apellido Apellido del trabajador.
	 * @param edad Edad del trabajador.
	 * @param direccion Dirección del trabajador.
	 * @param email Correo electrónico del trabajador.
	 * @param contrasena Contraseña del trabajador para autenticación.
	 * @param salario Salario del trabajador.
	 * @param is_admin Indica si el trabajador tiene privilegios de administrador.
	 */
	public Trabajador(String dni, String nombre, String apellido, int edad, String direccion, String email,
			String contrasena, float salario, boolean is_admin) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
		this.salario = salario;
		this.is_admin = is_admin;
	}

	/**
	 * Constructor que inicializa un trabajador con los atributos de la clase Persona, sin especificar salario ni privilegios de administrador.
	 * @param dni Documento Nacional de Identidad del trabajador.
	 * @param nombre Nombre del trabajador.
	 * @param apellido Apellido del trabajador.
	 * @param edad Edad del trabajador.
	 * @param direccion Dirección del trabajador.
	 * @param email Correo electrónico del trabajador.
	 * @param contrasena Contraseña del trabajador para autenticación.
	 */
	public Trabajador(String dni, String nombre, String apellido, int edad, String direccion, String email,
		String contrasena) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
	}

	// Getters y Setters
	
	/**
	 * Obtiene el salario del trabajador.
	 * @return El salario del trabajador.
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * Establece el salario del trabajador.
	 * @param salario El nuevo salario del trabajador.
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}

	/**
	 * Verifica si el trabajador tiene privilegios de administrador.
	 * @return true si el trabajador es administrador, false en caso contrario.
	 */
	public boolean isIs_admin() {
		return is_admin;
	}

	/**
	 * Establece si el trabajador tiene privilegios de administrador.
	 * @param is_admin true para asignar privilegios de administrador, false para quitarlos.
	 */
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
}


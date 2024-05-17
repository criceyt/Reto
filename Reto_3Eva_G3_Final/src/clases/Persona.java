package clases;

/**
 * Esta clase representa a una persona con sus atributos y métodos para gestionar la información personal.
 */
public class Persona {
	
	// Atributos

	/**
	 * Atributo privado para almacenar el DNI (Documento Nacional de Identidad) del usuario.
	 */
	private String dni;
	/**
	 * Atributo privado para almacenar el nombre completo del usuario.
	 */
	private String nombre;
	/**
	 * Atributo privado para almacenar el apellido del usuario.
	 */
	private String apellido;
	/**
	 * Atributo privado para almacenar la edad del usuario.
	 */
	private int edad;
	/**
	 * Atributo privado para almacenar la dirección física del usuario.
	 */
	private String direccion;
	/**
	 * Atributo privado para almacenar el correo electrónico del usuario.
	 */
	private String email;
	/**
	 * Atributo privado para almacenar la contraseña del usuario, generalmente cifrada.
	 */
	private String contrasena;

	
	// Constructores
	
	/**
	 * Constructor que inicializa una persona con todos sus atributos.
	 * @param dni Documento Nacional de Identidad de la persona.
	 * @param nombre Nombre de la persona.
	 * @param apellido Apellido de la persona.
	 * @param edad Edad de la persona.
	 * @param direccion Dirección de la persona.
	 * @param email Correo electrónico de la persona.
	 * @param contrasena Contraseña de la persona para autenticación.
	 */
	public Persona(String dni, String nombre, String apellido, int edad, String direccion, String email,
			String contrasena) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	/**
	 * Constructor vacío que inicializa una persona sin atributos específicos.
	 */
	public Persona() {
	}

	// Getters y setters
	
	/**
	 * Obtiene el Documento Nacional de Identidad de la persona.
	 * @return El DNI de la persona.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el Documento Nacional de Identidad de la persona.
	 * @param dni El nuevo DNI de la persona.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * @return El nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona.
	 * @param nombre El nuevo nombre de la persona.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido de la persona.
	 * @return El apellido de la persona.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido de la persona.
	 * @param apellido El nuevo apellido de la persona.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene la edad de la persona.
	 * @return La edad de la persona.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad de la persona.
	 * @param edad La nueva edad de la persona.
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene la dirección de la persona.
	 * @return La dirección de la persona.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección de la persona.
	 * @param direccion La nueva dirección de la persona.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el correo electrónico de la persona.
	 * @return El correo electrónico de la persona.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico de la persona.
	 * @param email El nuevo correo electrónico de la persona.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la contraseña de la persona para autenticación.
	 * @return La contraseña de la persona.
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Establece la contraseña de la persona para autenticación.
	 * @param contrasena La nueva contraseña de la persona.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}


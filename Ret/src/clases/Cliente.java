package clases;

public class Cliente extends Persona {
	
	// Atributos
	
	private boolean is_premium;
	
	// Constructores
	
	public Cliente(String dni, String nombre, String apellido, int edad, String direccion, String email,
			String contrasena) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
	}
	
	public Cliente() {
		super();
	}

	// getters and setters

	public boolean isIs_premium() {
		return is_premium;
	}

	public void setIs_premium(boolean is_premium) {
		this.is_premium = is_premium;
	}
}

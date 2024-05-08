package clases;

public class Trabajador extends Persona {
	
	// Atributos
	
	private float salario;
	private boolean is_admin;
	
//	Constructores
	
	public Trabajador() {
		
	}
	
	public Trabajador(String dni, String nombre, String apellido, int edad, String direccion, String email,
			String contrasena, float salario, boolean is_admin) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
		this.salario = salario;
		this.is_admin = is_admin;
	}

	public Trabajador(String dni, String nombre, String apellido, int edad, String direccion, String email,
		String contrasena) {
		super(dni, nombre, apellido, edad, direccion, email, contrasena);
	}

//	Getters y Setters
	
	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
}

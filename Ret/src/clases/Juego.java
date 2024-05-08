package clases;

public class Juego {
	
	// Atributos
	
	private int codJuego;
	private String caratula;
	private String nombre;
	private int anio;
	private float precio;
	private String genero;
	private String descripcion;
	private int numUnidades;
	
//	Constructores
	
	public Juego(int codJuego, String caratula, String nombre, int anio, float precio, String genero,
			String descripcion, int numUnidades) {
		
		this.codJuego = codJuego;
		this.caratula = caratula;
		this.nombre = nombre;
		this.anio = anio;
		this.precio = precio;
		this.genero = genero;
		this.descripcion = descripcion;
		this.numUnidades = numUnidades;
	}

	public Juego() {
		
	}

//	Getters y Setters
	
	public int getCodJuego() {
		return codJuego;
	}

	public void setCodJuego(int codJuego) {
		this.codJuego = codJuego;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}
}

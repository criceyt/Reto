package clases;

/**
 * Esta clase representa un juego con sus atributos y métodos para gestionar la información del juego.
 */
public class Juego {
	
	// Atributos
	
	/**
     * Código único asignado al juego dentro del sistema.
     */
    private int codJuego;
    /**
     * Ruta o URL de la imagen de la portada del juego.
     */
    private String caratula;
    /**
     * Nombre oficial del juego.
     */
    private String nombre;
    /**
     * Año de lanzamiento del juego.
     */
    private int anio;
    /**
     * Precio del juego en la moneda local.
     */
    private float precio;
    /**
     * Género principal del juego (por ejemplo, acción, aventura, deportes).
     */
    private String genero;
    /**
     * Descripción detallada del juego, incluyendo características y trama.
     */
    private String descripcion;
    /**
     * Número de unidades disponibles del juego en stock.
     */
    private int numUnidades;
	
	// Constructores
	
	/**
	 * Constructor que inicializa un juego con todos sus atributos.
	 * @param codJuego Código único del juego.
	 * @param caratula URL de la carátula del juego.
	 * @param nombre Nombre del juego.
	 * @param anio Año de lanzamiento del juego.
	 * @param precio Precio del juego.
	 * @param genero Género del juego.
	 * @param descripcion Descripción detallada del juego.
	 * @param numUnidades Número de unidades disponibles del juego.
	 */
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

	/**
	 * Constructor vacío que inicializa un juego sin atributos específicos.
	 */
	public Juego() {
		
	}

	// Getters y Setters
	
	/**
	 * Obtiene el código único del juego.
	 * @return El código del juego.
	 */
	public int getCodJuego() {
		return codJuego;
	}

	/**
	 * Establece el código único del juego.
	 * @param codJuego El nuevo código del juego.
	 */
	public void setCodJuego(int codJuego) {
		this.codJuego = codJuego;
	}

	/**
	 * Obtiene la URL de la carátula del juego.
	 * @return La URL de la carátula.
	 */
	public String getCaratula() {
		return caratula;
	}

	/**
	 * Establece la URL de la carátula del juego.
	 * @param caratula La nueva URL de la carátula.
	 */
	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	/**
	 * Obtiene el nombre del juego.
	 * @return El nombre del juego.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del juego.
	 * @param nombre El nuevo nombre del juego.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el año de lanzamiento del juego.
	 * @return El año de lanzamiento.
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Establece el año de lanzamiento del juego.
	 * @param anio El nuevo año de lanzamiento.
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Obtiene el precio del juego.
	 * @return El precio del juego.
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del juego.
	 * @param precio El nuevo precio del juego.
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el género del juego.
	 * @return El género del juego.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género del juego.
	 * @param genero El nuevo género del juego.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene la descripción detallada del juego.
	 * @return La descripción del juego.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción detallada del juego.
	 * @param descripcion La nueva descripción del juego.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el número de unidades disponibles del juego.
	 * @return El número de unidades disponibles.
	 */
	public int getNumUnidades() {
		return numUnidades;
	}

	/**
	 * Establece el número de unidades disponibles del juego.
	 * @param numUnidades El nuevo número de unidades disponibles.
	 */
	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}
}


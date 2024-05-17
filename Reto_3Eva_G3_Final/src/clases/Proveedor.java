package clases;

/**
 * Representa un proveedor en el sistema.
 */
public class Proveedor {

    /**
     * Código único del proveedor.
     */
    private int codProveedor;

    /**
     * Nombre del proveedor.
     */
    private String nombreProveedor;

    /**
     * Teléfono del proveedor.
     */
    private int telefono;

    /**
     * Correo electrónico del proveedor.
     */
    private String email;

    /**
     * Constructor vacío.
     */
    public Proveedor() {
    }

	/**
     * Constructor que inicializa un objeto Proveedor con los detalles proporcionados.
     *
     * @param codProveedor Código único del proveedor.
     * @param nombreProveedor Nombre del proveedor.
     * @param telefono Teléfono del proveedor.
     * @param email Correo electrónico del proveedor.
     */
    public Proveedor(int codProveedor, String nombreProveedor, int telefono, String email) {
        this.codProveedor = codProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene el código único del proveedor.
     *
     * @return Código único del proveedor.
     */
    public int getCodProveedor() {
        return codProveedor;
    }

    /**
     * Establece el código único del proveedor.
     *
     * @param codProveedor Nuevo código único del proveedor.
     */
    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return Nombre del proveedor.
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombreProveedor Nuevo nombre del proveedor.
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Obtiene el teléfono del proveedor.
     *
     * @return Teléfono del proveedor.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del proveedor.
     *
     * @param telefono Nuevo teléfono del proveedor.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del proveedor.
     *
     * @return Correo electrónico del proveedor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del proveedor.
     *
     * @param email Nuevo correo electrónico del proveedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

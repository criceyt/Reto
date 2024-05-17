package controlador;

import java.util.List;

import javax.swing.JTextField;

import clases.Cliente;
import clases.Juego;
import clases.Persona;
import excepciones.ErrorGeneral;
import excepciones.ExcepcionStock;
import excepciones.LogInException;

/**
 * Interfaz DAO para gestionar operaciones CRUD y otras funcionalidades relacionadas con la gestión de usuarios, clientes, juegos y stock.
 * Esta interfaz define los métodos necesarios para interactuar con la base de datos.
 */
public interface DAO {

	/**
     * Inicia sesión de un usuario mediante su correo electrónico y contraseña.
     *
     * @param email Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return Un objeto Persona representando al usuario autenticado.
     * @throws ErrorGeneral En caso de errores generales durante la operación.
     * @throws LogInException Si falla el proceso de inicio de sesión.
     */
	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException;

	/**
     * Registra un nuevo usuario en el sistema.
     *
     * @param persona Objeto Persona representando al usuario a registrar.
     * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws LogInException En caso de que el email este duplicado.
     */
	public void registroUsuario(Persona persona) throws ErrorGeneral, LogInException;

	/**
     * Alta de un nuevo trabajador en el sistema.
     *
     * @param trabajador Objeto Trabajador representando al trabajador a agregar.
     * @param txtSueldo Campo de texto donde se ingresa el sueldo del trabajador.
     * @throws ErrorGeneral En caso de errores generales durante la operación.
     * @throws LogInException Si falla el proceso de registro.
     */
	public void altaTrabajador(Persona trabajador, JTextField txtSueldo)throws ErrorGeneral, LogInException ;

	/**
	 * Obtiene un cliente por su dirección de correo electrónico.
	 *
	 * @param email Dirección de correo electrónico del cliente.
	 * @return Un objeto Cliente que coincide con el correo electrónico proporcionado.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws LogInException Si falla el proceso de obtención del cliente.
	 */
	public Cliente obtenerClientePorEmail(String email) throws ErrorGeneral, LogInException;

	/**
	 * Obtiene una persona por su dirección de correo electrónico.
	 *
	 * @param email Dirección de correo electrónico de la persona.
	 * @return Un objeto Persona que coincide con el correo electrónico proporcionado.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws LogInException Si falla el proceso de obtención de la persona.
	 */
	public Persona obtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException;

	/**
	 * Da de baja a una persona por su DNI.
	 *
	 * @param dni DNI de la persona.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws LogInException Si falla el proceso de dar de baja.
	 */
	public void darBaja(String dni) throws ErrorGeneral, LogInException;

	/**
	 * Guarda un cliente en el sistema.
	 *
	 * @param cliente Objeto Cliente a guardar.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws LogInException Si falla el proceso de guardado.
	 */
	public void guardar(Cliente cliente) throws ErrorGeneral, LogInException;

	/**
	 * Rellena un ComboBox con los nombres de los juegos disponibles en stock.
	 *
	 * @param buscaJuego Texto a buscar en los nombres de los juegos.
	 * @return Una lista de cadenas con los nombres de los juegos que coinciden con el texto buscado.
	 */
	public List<String> rellenarComboBoxJuegosStock(String buscaJuego);

	/**
	 * Rellena un ComboBox con los nombres de los proveedores de stock.
	 *
	 * @return Una lista de cadenas con los nombres de los proveedores.
	 */
	public List<String> rellenarComboBoxStockProveedores();

	/**
	 * Envía un stock de un juego a un proveedor.
	 *
	 * @param nombre Nombre del juego.
	 * @param cantidad Cantidad del stock a enviar.
	 * @param proveedor Nombre del proveedor.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 * @throws ExcepcionStock Si hay un problema con la disponibilidad del stock.
	 */
	public void enviarStock(String nombre, int cantidad, String proveedor) throws ErrorGeneral, ExcepcionStock;

	/**
	 * Rellena un ComboBox con los nombres de los juegos que pueden modificarse.
	 *
	 * @param buscaJuego Texto a buscar en los nombres de los juegos.
	 * @return Una lista de cadenas con los nombres de los juegos que coinciden con el texto buscado.
	 */
	public List<String> rellenarComboBoxModificar(String buscaJuego);

	/**
	 * Modifica un juego existente.
	 *
	 * @param juego Objeto Juego a modificar.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public void modificarJuego (Juego juego) throws ErrorGeneral;

	/**
	 * Selecciona un juego para modificar basándose en su nombre.
	 *
	 * @param juego Nombre del juego a seleccionar.
	 * @return Un objeto Juego que coincide con el nombre proporcionado.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public Juego elegirJuegoModificar(String juego) throws ErrorGeneral;

	/**
	 * Inserta un nuevo juego en el sistema.
	 *
	 * @param juego Objeto Juego a insertar.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public void insertarJuego(Juego juego) throws ErrorGeneral;

	/**
	 * Obtiene una lista de todos los juegos disponibles.
	 *
	 * @return Una lista de objetos Juego.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public List<Juego> obtenerJuegos() throws ErrorGeneral;

	/**
	 * Busca juegos por texto.
	 *
	 * @param searchText Texto a buscar en los nombres de los juegos.
	 * @return Una lista de objetos Juego que coinciden con el texto buscado.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public List<Juego> buscarJuegosPorTextoNormal(String searchText) throws ErrorGeneral;

	/**
	 * Obtiene una lista de juegos comprados por un cliente específico identificado por su DNI.
	 *
	 * @param dni DNI del cliente.
	 * @return Una lista de objetos Juego asociados al cliente.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public List<Juego> obtenerJuegosPorCliente(String dni) throws ErrorGeneral;

	/**
	 * Obtiene una lista de juegos comprados por un cliente específico identificado por su DNI que coincidan con el texto introducido.
	 *
	 * @param dni DNI del cliente.
	 * @param searchText Texto a buscar en los nombres de los juegos.
	 * @return Una lista de objetos Juego que coinciden con el texto buscado y están asociados al cliente.
	 * @throws ErrorGeneral En caso de errores generales durante la operación.
	 */
	public List<Juego> buscarJuegosPorTexto(String dni, String searchText) throws ErrorGeneral;

	/**
     * Compra un juego específico para una persona dada.
     *
     * @param persona Objeto Persona representando al comprador.
     * @param juego Objeto Juego representando el juego a comprar.
     * @throws ExcepcionStock Si el juego seleccionado no está disponible en stock o hay un problema con la disponibilidad del mismo.
     */
	public void comprarJuego(Persona persona, Juego juego) throws ExcepcionStock;

	/**
	 * Obtiene el número de unidades disponibles de un juego específico.
	 * Este método recibe un objeto Juego como parámetro y devuelve el número de unidades
	 * disponibles de ese juego. La información sobre las unidades puede ser utilizada para controlar
	 * la disponibilidad de un juego en el inventario o para realizar operaciones relacionadas con
	 * la gestión de stock.
	 *
	 * @param juego El objeto Juego cuyo número de unidades se desea obtener.
	 * @return Un entero representando el número de unidades disponibles del juego especificado.
	 */
	public int ConseguirUnidades(Juego juego);
}

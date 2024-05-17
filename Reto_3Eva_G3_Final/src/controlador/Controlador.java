package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import clases.Cliente;
import clases.Juego;
import clases.Persona;
import excepciones.ErrorGeneral;
import excepciones.ExcepcionStock;
import excepciones.LogInException;
import modelo.ImplementacionBD;
import vista.InicioSesion;

/**
 * Controlador centraliza la lógica de negocio y gestiona la interacción entre la vista y el modelo.
 * Proporciona métodos para manejar operaciones de inicio de sesión, registro de usuarios, gestión de trabajadores,
 * manipulación de clientes y juegos, y más.
 * <p>
 * Utiliza DAO para interactuar con el modelo y realizar operaciones CRUD en la base de datos.
 * </p>
 */
public class Controlador {
	private DAO imp = new ImplementacionBD();
	
	/**
	 * Intenta iniciar sesión de un usuario en el sistema utilizando su email y contraseña.
	 * Si el inicio de sesión es exitoso, retorna la Persona autenticada.
	 * En caso contrario, si ocurre algún error durante el proceso, se lanzará una excepción adecuada.
	 * 
	 * @param email Email del usuario intentando iniciar sesión.
	 * @param contrasena Contraseña del usuario intentando iniciar sesión.
	 * @return Una instancia de Persona si el inicio de sesión es exitoso, o un valor nulo si no se encuentra ninguna persona con esas credenciales.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de inicio de sesión.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException {
		Persona persona = null;

		persona = imp.inicioSesion(email, contrasena);

		return persona;
	}

	/**
	 * Registra un nuevo usuario en el sistema utilizando los datos proporcionados en el objeto {@link Persona}.
	 * Este método llama a la implementación definida en el DAO.
	 * 
	 * @param persona Objeto Persona que contiene los datos del nuevo usuario a registrar.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de registro.
	 * @throws LogInException Si el email esta duplicado
	 */
	public void registroUsuario(Persona persona) throws ErrorGeneral, LogInException {

		imp.registroUsuario(persona);
	}
	
	/**
	 * Realiza la alta de un nuevo trabajador en el sistema utilizando los datos proporcionados
	 * y el campo de texto para especificar el sueldo del trabajador.
	 * Este método llama a la implementación definida en el DAO.
	 * 
	 * @param trabajador Objeto Persona que contiene los datos del nuevo trabajador a registrar.
	 * @param txtSueldo Campo de texto donde se especifica el sueldo del trabajador.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de alta de trabajador.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public void altaTrabajador(Persona trabajador, JTextField txtSueldo) throws ErrorGeneral, LogInException {

		imp.altaTrabajador(trabajador, txtSueldo);

	}
	
	/**
	 * Muestra la ventana principal de inicio de sesión del sistema.
	 * Esta ventana permite a los usuarios ingresar sus credenciales para acceder al sistema.
	 */
	public void mostrarPantallaInicio() {
		// VENTANA PRINCIPAL DE INICIO DE SESION

		InicioSesion ventanaNueva = new InicioSesion(this);
		ventanaNueva.setVisible(true);

	}
	
	/**
	 * Intenta obtener un cliente del sistema utilizando su dirección de correo electrónico.
	 * Si el cliente existe, retorna una instancia de Cliente; de lo contrario, retorna un valor nulo.
	 * 
	 * @param email Dirección de correo electrónico del cliente.
	 * @return Un objeto Cliente si se encuentra un cliente con el email proporcionado, o un valor nulo si no se encuentra ningún cliente con ese email.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de búsqueda.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public  Cliente ObtenerClientePorEmail(String email) throws ErrorGeneral, LogInException {
		Cliente cliente;		
		cliente = imp.obtenerClientePorEmail(email);	
		return cliente;
	}

	/**
	 * Intenta obtener una persona del sistema utilizando su dirección de correo electrónico.
	 * Si la persona existe, retorna una instancia de Persona; de lo contrario, retorna un valor nulo.
	 * <p>
	 * Este método realiza una búsqueda en el sistema utilizando el DAO para encontrar la persona correspondiente.
	 * </p>
	 * 
	 * @param email Dirección de correo electrónico de la persona cuyos datos se desean recuperar.
	 * @return Un objeto Persona si se encuentra una persona con el email proporcionado, o un valor nulo si no se encuentra ninguna persona con ese email.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de búsqueda.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public  Persona ObtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException {
		Persona per;
		per = imp.obtenerPersonaPorEmail(email);
		return per;
	}

	/**
	 * Procesa la solicitud de dar de baja a un usuario en el sistema mediante su DNI.
	 * Este método llama a la implementación específica de dar de baja definida en el DAO.
	 * 
	 * @param dni DNI del usuario cuya baja se solicita.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de dar de baja.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public void darBaja(String dni) throws ErrorGeneral, LogInException{
		imp.darBaja(dni);
	}

	/**
	 * Procesa la solicitud de guardar un cliente en el sistema.
	 * Este método llama a la implementación específica de guardar definida en el DAO.
	 * 
	 * @param cliente Objeto Cliente que representa los datos del cliente a guardar en el sistema.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de guardar.
	 * @throws LogInException Si falla el inicio de sesión debido a credenciales incorrectas o problemas de conexión.
	 */
	public void guardar(Cliente cliente) throws ErrorGeneral, LogInException{

		imp.guardar(cliente);
	}
	
	/**
	 * Rellena una lista con los nombres de los juegos disponibles en stock, filtrados según el texto de búsqueda proporcionado.
	 * Este método llama a la implementación específica de relleno de combobox definida en el DAO.
	 * <p>
	 * La lista resultante es utilizada para actualizar dinámicamente un JComboBox, mostrando solo aquellos juegos que coinciden con el criterio de búsqueda.
	 * </p>
	 * 
	 * @param buscaJuego Texto de búsqueda utilizado para filtrar los juegos disponibles en stock.
	 * @return Una lista de cadenas de texto representando los nombres de los juegos que coinciden con el criterio de búsqueda.
	 */
	public List<String> rellenarComboBoxJuegosStock(String buscaJuego) {
		List<String> nombreJuegos = new ArrayList<>();
		
		nombreJuegos = imp.rellenarComboBoxJuegosStock(buscaJuego);
		
		return nombreJuegos;
	}
	
	/**
	 * Rellena una lista con los nombres de los proveedores que tienen stock del juego especificado.
	 * Este método llama a la implementación específica de relleno de combobox definida en el DAO.
	 * <p>
	 * La lista resultante es utilizada para actualizar dinámicamente un JComboBox, mostrando solo aquellos proveedores que tienen stock del juego seleccionado.
	 * </p>
	 * 
	 * @param nombreJuego El textp que va a ser utilizado para rellenar el JComboBox
	 * @return Una lista de cadenas de texto representando los nombres de los proveedores que tienen stock del juego especificado.
	 */
	public List<String> rellenarComboBoxStockProveedores(String nombreJuego) {
		List<String> nombreProveedores = new ArrayList<>();
		
		nombreProveedores = imp.rellenarComboBoxStockProveedores();
		
		return nombreProveedores;
	}

	/**
	 * Procesa la solicitud de enviar stock de un juego desde un proveedor al sistema.
	 * Este método llama a la implementación específica de envío de stock definida en el DAO.
	 * 
	 * @param nombre Nombre del juego cuyo stock se va a enviar.
	 * @param cantidad Cantidad de unidades del juego que se van a enviar.
	 * @param proveedor Nombre del proveedor desde el cual se va a enviar el stock.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de envío de stock.
	 * @throws ExcepcionStock Si hay una excepción específica relacionada con el stock, como falta de stock disponible o problemas de inventario.
	 */
	public void enviarStock(String nombre, int cantidad, String proveedor) throws ErrorGeneral, ExcepcionStock {
		imp.enviarStock(nombre, cantidad, proveedor);
		
	}
	
	/**
	 * Rellena una lista con los nombres de los juegos disponibles para modificar, filtrados según el texto de búsqueda proporcionado.
	 * Este método llama a la implementación específica de relleno de combobox definida en el DAO.
	 * <p>
	 * La lista resultante puede ser utilizada para actualizar dinámicamente un JComboBox, 
	 * mostrando solo aquellos juegos que coinciden con el criterio de búsqueda y que están disponibles para modificación.
	 * </p>
	 * 
	 * @param buscaJuego Texto de búsqueda utilizado para filtrar los juegos disponibles para modificar.
	 * @return Una lista de cadenas de texto representando los nombres de los juegos que coinciden con el criterio de búsqueda y que están disponibles para modificación.
	 */
	public List<String> rellenarComboBoxJuegosModificar(String buscaJuego) {
		List<String> nombreJuegos = new ArrayList<>();
		
		nombreJuegos = imp.rellenarComboBoxJuegosStock(buscaJuego);
		
		return nombreJuegos;
	}

	/**
	 * Procesa la solicitud de modificar un juego en el sistema.
	 * Este método llama a la implementación específica de modificación de juego definida en el DAO.
	 * 
	 * @param juego Objeto Juego que representa los nuevos datos del juego a modificar en el sistema.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de modificación.
	 */
	public void modificarJuego(Juego juego) throws ErrorGeneral {
		imp.modificarJuego(juego);
	}
	
	/**
	 * Busca y retorna un juego específico en el sistema basado en su nombre.
	 * Este método llama a la implementación específica de selección de juego definida en el DAO.
	 * <p>
	 * Si el juego existe, retorna una instancia de Juego; de lo contrario, retorna un valor nulo.
	 * </p>
	 * 
	 * @param nombreJuego Nombre del juego cuyo objeto se desea recuperar.
	 * @return Un objeto Juego si se encuentra un juego con el nombre proporcionado, o un valor nulo si no se encuentra ningún juego con ese nombre.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de búsqueda.
	 */
	public Juego elegirJuegoModificar(String nombreJuego) throws ErrorGeneral {
		Juego juego = imp.elegirJuegoModificar(nombreJuego);
		return juego;
	}
	
	/**
	 * Procesa la inserción de un nuevo juego en el sistema.
	 * Este método llama a la implementación específica de inserción de juego definida en el DAO.
	 * 
	 * @param juego Objeto Juego que representa los datos del nuevo juego a insertar en el sistema.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de inserción.
	 */
	public void insertarJuego(Juego juego) throws ErrorGeneral {
		imp.insertarJuego(juego);
	}

	/**
	 * Recupera todos los juegos almacenados en el sistema.
	 * Este método llama a la implementación específica de obtención de juegos definida en el DAO.
	 * <p>
	 * Retorna una lista de objetos Juego, cada uno representando un juego almacenado en el sistema.
	 * </p>
	 * 
	 * @return Una lista de objetos Juego que representan todos los juegos almacenados en el sistema.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de recuperación de juegos.
	 */
	public List<Juego> obtenerJuegos() throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		
		juegos = imp.obtenerJuegos();
		
		return juegos;
	}

	/**
	 * Busca juegos en el sistema basándose en un texto normalizado.
	 * Este método llama a la implementación específica de búsqueda de juegos por texto normalizado definida en el DAO.
	 * <p>
	 * Retorna una lista de objetos Juego que coinciden con el texto normalizado.
	 * </p>
	 * 
	 * @param searchText Texto normalizado utilizado para filtrar los juegos.
	 * @return Una lista de objetos Juego que coinciden con el texto normalizado.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de búsqueda.
	 */
	public List<Juego> buscarJuegosPorTextoNormal(String searchText) throws ErrorGeneral {
		List<Juego> resultados = new ArrayList<>();
		
		resultados = imp.buscarJuegosPorTextoNormal(searchText);
		
		return resultados;
	}

	/**
	 * Recupera todos los juegos que a comprado un cliente específico, identificado por su DNI.
	 * Este método llama a la implementación específica de obtención de juegos por cliente definida en el DAO.
	 * <p>
	 * Retorna una lista de objetos Juego que están asociados al cliente con el DNI proporcionado.
	 * </p>
	 * 
	 * @param dni El DNI del cliente.
	 * @return Una lista de objetos Juego que están asociados al cliente con el DNI proporcionado.
	 * @throws ErrorGeneral Si ocurre un error general durante el proceso de recuperación de juegos.
	 */
	public List<Juego> obtenerJuegosPorCliente(String dni) throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		
		juegos = imp.obtenerJuegosPorCliente(dni);
		
		return juegos;
	}

	/**
	 * Busca juegos por texto proporcionado, filtrando los resultados por el DNI especificado.
	 *
	 * Este método busca en la base de datos aquellos juegos cuyo nombre o descripción. Los resultados se filtran además por el DNI del usuario, 
	 * permitiendo así personalizar aún más la búsqueda según las preferencias individuales.
	 *
	 * @param dni El DNI, utilizado para filtrar los resultados.
	 * @param searchText El texto por el cual se buscarán los juegos.
	 * @return Una lista de juegos que coinciden con el criterio de búsqueda y cumplen con el filtro de DNI, si aplica.
	 * @throws ErrorGeneral Si ocurre algún error durante la ejecución del método, como problemas de conexión a la base de datos o errores lógicos en la consulta de búsqueda.
	 */
	public List<Juego> buscarJuegosPorTexto(String dni, String searchText) throws ErrorGeneral {
		List<Juego> resultados = new ArrayList<>();
		
		resultados = imp.buscarJuegosPorTexto(dni, searchText);
		
		return resultados;
	}

	/**
	 * Compra un juego específico para una persona.
	 *
	 * Este método permite a una persona comprar un juego específico disponible en stock.
	 * 
	 * @param juego El juego que se desea comprar. Debe ser un objeto válido y estar disponible en stock.
	 * @param persona La persona que realizará la compra.
	 * @throws ExcepcionStock Si el juego seleccionado no está disponible en stock o hay un problema con la disponibilidad del mismo.
	 */
	public void comprarJuego(Juego juego, Persona persona) throws ExcepcionStock {
		imp.comprarJuego(persona, juego);
		
	}

	/**
	 * Método para obtener el número de unidades disponibles de un juego específico.
	 *
	 * @param juego El objeto Juego cuyo número de unidades se desea conocer.
	 * @return Un entero representando el número de unidades disponibles del juego especificado.
	 */
	public int conseguirUnidades(Juego juego) {
		int num = 1;
		
		num = imp.ConseguirUnidades(juego);
		
		return num;
	}
}

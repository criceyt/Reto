package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Juego;
import clases.Persona;
import clases.Proveedor;
import clases.Trabajador;
import controlador.DAO;
import excepciones.ErrorGeneral;
import excepciones.ExcepcionStock;
import excepciones.LogInException;

/**
 * Clase ImplementacionBD implementa la interfaz DAO para gestionar operaciones CRUD y otras funcionalidades relacionadas con la gestión de usuarios, clientes, juegos y stock.
 * Esta clase establece la conexión con la base de datos, maneja consultas SQL y transacciones, y proporciona métodos para interactuar con la base de datos.
 */
public class ImplementacionBD implements DAO {

	// HERRAMIENTAS

	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle fichConf;
	private String url;
	private String usuario;
	private String pass;

	// Consulta MySQL para introducir los datos
	private final String altaPersona = "INSERT INTO PERSONA(dni, nombre_persona, apellido, edad, direccion, email, contrasena) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private final String altaCliente = "INSERT INTO CLIENTE(dni) VALUES(?)";
	private final String comprobarEmailDuplicado = "SELECT EMAIL FROM PERSONA WHERE EMAIL = ?";
	// Select que recoge los datos de un cliente en específico
	// Select de el loin
	private final String inicioSesion = "SELECT * FROM PERSONA WHERE EMAIL = ? AND CONTRASENA = ?";
	private final String CONSULTA_TRABAJADOR = "SELECT * FROM TRABAJADOR WHERE DNI = ?";
	private final String CONSULTA_CLIENTE = "SELECT * FROM CLIENTE WHERE DNI = ?";
	private final String altaTrabajador = "INSERT INTO TRABAJADOR(dni, salario, es_admin) VALUES (?, ?, ?)";
	// Parte de la gestion de clientes
	private final String COMPROBAR_EMAIL_CLIENTE = "SELECT c.DNI FROM CLIENTE c ,PERSONA p WHERE p.EMAIL = ? AND p.DNI=c.DNI";
	private final String COMPROBAR_EMAIL_PERSONA = "SELECT * FROM PERSONA WHERE EMAIL = ?";
	private final String DAR_DE_BAJA = "DELETE FROM PERSONA WHERE DNI = ?";
	private final String GUARDAR_PERSONA = "UPDATE PERSONA SET NOMBRE_PERSONA = ?, APELLIDO=?, EDAD=?, DIRECCION=?, CONTRASENA=? where DNI=?";
	// Select que recoge los nombres de los juegos del buscador de stock
	private final String cogerNombreJuegos = "SELECT NOMBRE_JUEGO FROM JUEGO WHERE NOMBRE_JUEGO LIKE ?";
	private final String cogerNombreProveedores = "SELECT NOMBRE_PROVEEDOR FROM PROVEEDOR";
	// Select que añade cantidades a los juegos en stock
	private final String anadirCantidadJuegos = "CALL SumarUnidadEnProvee(?, ?)";
	// Selects que recogen datos del juego a partir de los nombres
	private final String conseguirCodigoDeNombre = "SELECT COD_JUEGO FROM JUEGO WHERE NOMBRE_JUEGO = ?";
	private final String conseguirDatosDeNombre = "SELECT * FROM JUEGO WHERE NOMBRE_JUEGO = ?";
	private static final String OBTENER_JUEGOS_POR_CLIENTE = "SELECT J.COD_JUEGO, J.CARATULA, J.NOMBRE_JUEGO, J.ANIO, J.PRECIO, J.GENERO, J.DESCRIPCION, J.NUM_UNIDADES "
			+ "FROM JUEGO J INNER JOIN VENTA V ON J.COD_JUEGO = V.COD_JUEGO " + "WHERE V.DNI = ?";
	private static final String OBTENER_JUEGOS = "SELECT * FROM JUEGO ";
	private static final String BUSCAR_JUEGOS_POR_TEXTO = "SELECT * FROM JUEGO INNER JOIN VENTA ON JUEGO.COD_JUEGO = VENTA.COD_JUEGO WHERE VENTA.DNI = ? AND (JUEGO.NOMBRE_JUEGO LIKE ? OR JUEGO.DESCRIPCION LIKE ?)";
	private static final String BUSCAR_JUEGOS_POR_TEXTO_NORMAL = "SELECT * FROM JUEGO WHERE NOMBRE_JUEGO LIKE ? OR DESCRIPCION LIKE ?";
	// Select que modifica los juegos
	private final String modificarJuego = "call tienda.ModificarJuego(?, ?, ?, ?, ?, ?)";
	private final String insertarJuego = "INSERT INTO JUEGO (CARATULA, NOMBRE_JUEGO, ANIO, PRECIO, GENERO, DESCRIPCION) VALUES(?, ?, ?, ?, ?, ?);";
	// Sentencias para la compra de juegos
	private final String llamarProcCompraJuego = "call TIENDA.RestarUnidadEnVenta(?)";
	private final String comprobacionInsertTablaVenta = "SELECT * FROM VENTA WHERE COD_JUEGO = ? AND DNI = ?";
	private final String sumaTablaVenta = "UPDATE VENTA SET NUM_UNIDADES = NUM_UNIDADES + 1, FECHA_VENTA = ? WHERE COD_JUEGO = ? AND DNI = ?";
	private final String insertTablaVenta = "INSERT INTO VENTA VALUES (?, ?, ?, ?)";
	// Sentencias para conseguir los datos de proveedor
	private final String conseguirDatosDeNombreProveedor = "SELECT COD_PROVEEDOR, TELEFONO, EMAIL FROM PROVEEDOR WHERE NOMBRE_PROVEEDOR = ?";
	private final String comprobacionInsertTablaProvee = "SELECT * FROM PROVEE WHERE COD_JUEGO = ? AND COD_PROVEEDOR = ?";
	private final String insertTablaProvee = "INSERT INTO PROVEE VALUES (?, ?, ?, ?)";
	private final String updateTablaProvee = "UPDATE PROVEE SET NUM_UNIDADES = ?, FECHA_PROVEE = ? WHERE COD_JUEGO = ? AND COD_PROVEEDOR = ?";
	// Sentencia para conseguir las unidades a partir del codigo del juego
	private final String conseguirUnds = "SELECT NUM_UNIDADES FROM JUEGO WHERE COD_JUEGO = ?";
	
	
	/**
     * Constructor de la clase que inicializa las variables de configuración para la conexión a la base de datos.
     */
	public ImplementacionBD() {
		fichConf = ResourceBundle.getBundle("modelo.config");
		url = fichConf.getString("url");
		usuario = fichConf.getString("usuario");
		pass = fichConf.getString("pass");
	}

	/**
     * Abre una conexión a la base de datos utilizando las credenciales y URL proporcionadas.
     */
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	/**
     * Cierra la conexión a la base de datos y libera los recursos utilizados.
     */
	public void closeConnection() {

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

		}
	}

	/**
	 * Obtiene una lista de juegos asociados a un cliente específico por su DNI.
	 *
	 * Este método realiza una consulta a la base de datos para encontrar todos los juegos vendidos a un cliente específico,
	 * identificado por su DNI. Luego, crea objetos Juego para cada juego encontrado y los agrega a una lista,
	 * la cual se retorna al finalizar la operación.
	 *
	 * @param dni El DNI del cliente cuyos juegos se desean obtener.
	 * @return Una lista de objetos Juego que representa los juegos vendidos al cliente especificado.
	 * @throws ErrorGeneral Si ocurre un error genérico durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	public List<Juego> obtenerJuegosPorCliente(String dni) throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		ResultSet rs = null;

		try {
			openConnection();
			stmt = con.prepareStatement(OBTENER_JUEGOS_POR_CLIENTE);
			stmt.setString(1, dni);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Juego juego = new Juego();
				juego.setCodJuego(rs.getInt("COD_JUEGO"));
				juego.setCaratula(rs.getString("CARATULA"));
				juego.setNombre(rs.getString("NOMBRE_JUEGO"));
				juego.setAnio(rs.getInt("ANIO"));
				juego.setPrecio(rs.getFloat("PRECIO"));
				juego.setGenero(rs.getString("GENERO"));
				juego.setDescripcion(rs.getString("DESCRIPCION"));
				juego.setNumUnidades(rs.getInt("NUM_UNIDADES"));

				juegos.add(juego);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();
		} finally {
			closeConnection();
		}

		return juegos;
	}

	/**
	 * Obtiene una lista de todos los juegos disponibles en la base de datos.
	 *
	 * Este método realiza una consulta a la base de datos para recuperar información sobre todos los juegos presentes en el sistema.
	 * Crea objetos Juego para cada juego encontrado y los agrega a una lista, la cual se retorna al finalizar la operación.
	 *
	 * @return Una lista de objetos Juego que representa todos los juegos disponibles en el sistema.
	 * @throws ErrorGeneral Si ocurre un error genérico durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	public List<Juego> obtenerJuegos() throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		ResultSet rs = null;

		try {
			openConnection();
			stmt = con.prepareStatement(OBTENER_JUEGOS);


			rs = stmt.executeQuery();

			while (rs.next()) {
				Juego juego = new Juego();
				juego.setCodJuego(rs.getInt("COD_JUEGO"));
				juego.setCaratula(rs.getString("CARATULA"));
				juego.setNombre(rs.getString("NOMBRE_JUEGO"));
				juego.setAnio(rs.getInt("ANIO"));
				juego.setPrecio(rs.getFloat("PRECIO"));
				juego.setGenero(rs.getString("GENERO"));
				juego.setDescripcion(rs.getString("DESCRIPCION"));
				juego.setNumUnidades(rs.getInt("NUM_UNIDADES"));

				juegos.add(juego);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();
		} finally {
			closeConnection();
		}

		return juegos;
	}

	/**
	 * Busca juegos en la base de datos por texto, considerando tanto el nombre del juego como su descripción.
	 *
	 * Este método realiza una consulta a la base de datos para encontrar juegos cuyo nombre o descripción contenga el texto proporcionado.
	 * Los resultados son filtrados por el DNI del cliente, permitiendo así personalizar la búsqueda según el cliente.
	 * Crea objetos Juego para cada juego encontrado y los agrega a una lista, la cual se retorna al finalizar la operación.
	 *
	 * @param dni El DNI del cliente cuya búsqueda se desea realizar.
	 * @param texto El texto a buscar en los nombres y descripciones de los juegos.
	 * @return Una lista de objetos Juego que representan los juegos encontrados que coinciden con el texto proporcionado.
	 * @throws ErrorGeneral Si ocurre un error genérico durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	public List<Juego> buscarJuegosPorTexto(String dni, String texto) throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		ResultSet rs = null;

		try {
			openConnection();
			stmt = con.prepareStatement(BUSCAR_JUEGOS_POR_TEXTO);
			stmt.setString(1, dni);
			stmt.setString(2, "%" + texto + "%");
			stmt.setString(3, "%" + texto + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Juego juego = new Juego();
				juego.setCodJuego(rs.getInt("COD_JUEGO"));
				juego.setCaratula(rs.getString("CARATULA"));
				juego.setNombre(rs.getString("NOMBRE_JUEGO"));
				juego.setAnio(rs.getInt("ANIO"));
				juego.setPrecio(rs.getFloat("PRECIO"));
				juego.setGenero(rs.getString("GENERO"));
				juego.setDescripcion(rs.getString("DESCRIPCION"));
				juego.setNumUnidades(rs.getInt("NUM_UNIDADES"));

				juegos.add(juego);
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
			throw new ErrorGeneral();
		} finally {
			closeConnection();
		}

		return juegos;
	}

	/**
	 * Busca juegos en la base de datos por texto, sin considerar el DNI del cliente.
	 *
	 * Este método realiza una consulta a la base de datos para encontrar juegos cuyo nombre o descripción contenga el texto proporcionado.
	 * A diferencia de otros métodos de búsqueda, este no filtra los resultados por el DNI del cliente, lo que permite una búsqueda más amplia.
	 * Crea objetos Juego para cada juego encontrado y los agrega a una lista, la cual se retorna al finalizar la operación.
	 *
	 * @param texto El texto a buscar en los nombres y descripciones de los juegos.
	 * @return Una lista de objetos Juego que representan los juegos encontrados que coinciden con el texto proporcionado.
	 * @throws ErrorGeneral Si ocurre un error genérico durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	public List<Juego> buscarJuegosPorTextoNormal(String texto) throws ErrorGeneral {
		List<Juego> juegos = new ArrayList<>();
		ResultSet rs = null;

		try {
			openConnection();
			stmt = con.prepareStatement(BUSCAR_JUEGOS_POR_TEXTO_NORMAL);
			stmt.setString(1, "%" + texto + "%");
			stmt.setString(2, "%" + texto + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Juego juego = new Juego();
				juego.setCodJuego(rs.getInt("COD_JUEGO"));
				juego.setCaratula(rs.getString("CARATULA"));
				juego.setNombre(rs.getString("NOMBRE_JUEGO"));
				juego.setAnio(rs.getInt("ANIO"));
				juego.setPrecio(rs.getFloat("PRECIO"));
				juego.setGenero(rs.getString("GENERO"));
				juego.setDescripcion(rs.getString("DESCRIPCION"));
				juego.setNumUnidades(rs.getInt("NUM_UNIDADES"));
				
				juegos.add(juego);
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
			throw new ErrorGeneral();
		} finally {
			closeConnection();
		}

		return juegos;
	}

	/**
	 * Inserta una nueva persona en la base de datos.
	 *
	 * Este método prepara una declaración SQL para insertar una nueva persona en la tabla de personas,
	 * utilizando los detalles proporcionados en el objeto Persona. Después de preparar la declaración,
	 * se ejecuta la actualización en la base de datos.
	 *
	 * @param persona Objeto Persona que contiene los detalles de la persona a insertar.
	 * @throws SQLException Si ocurre un error al preparar o ejecutar la declaración SQL.
	 */
	public void insertarPersona(Persona persona) throws SQLException {
		stmt = con.prepareStatement(altaPersona);
		stmt.setString(1, persona.getDni());
		stmt.setString(2, persona.getNombre());
		stmt.setString(3, persona.getApellido());
		stmt.setInt(4, persona.getEdad());
		stmt.setString(5, persona.getDireccion());
		stmt.setString(6, persona.getEmail());
		stmt.setString(7, persona.getContrasena());
		stmt.executeUpdate();
	}

	/**
	 * Inserta un nuevo cliente en la base de datos.
	 *
	 * Este método prepara una declaración SQL para insertar un nuevo cliente en la tabla de clientes,
	 * utilizando el DNI proporcionado. Después de preparar la declaración, se ejecuta la actualización en la base de datos.
	 *
	 * @param dni El DNI del cliente a insertar.
	 * @throws SQLException Si ocurre un error al preparar o ejecutar la declaración SQL.
	 */
	public void insertarCliente(String dni) throws SQLException {
		stmt = con.prepareStatement(altaCliente);
		stmt.setString(1, dni);
		stmt.executeUpdate();
	}

	/**
	 * Determina si una persona es un trabajador o un cliente basándose en su DNI.
	 *
	 * Intenta primero obtener un trabajador con el DNI dado. Si no existe, intenta obtener un cliente.
	 * Si ninguna de estas condiciones se cumple, devuelve la persona original.
	 *
	 * @param persona Objeto Persona cuyo DNI se utilizará para determinar si es un trabajador o un cliente.
	 * @return Un objeto Trabajador o Cliente, dependiendo de si la persona es un trabajador o un cliente.
	 *         Si no se encuentra ni trabajador ni cliente, se devuelve la persona original.
	 * @throws SQLException Si ocurre un error al consultar la base de datos.
	 */
	public Persona getTrabajadorOCliente(Persona persona) throws SQLException {
		Trabajador trabajador = getTrabajador(persona.getDni());
		if (trabajador != null) {
			return trabajador;
		}

		Cliente cliente = getCliente(persona.getDni());
		if (cliente != null) {
			return cliente;
		}

		return persona;
	}

	/**
	 * Obtiene un trabajador de la base de datos por su DNI.
	 *
	 * Este método prepara una declaración SQL para buscar un trabajador en la base de datos utilizando su DNI.
	 * Si se encuentra un trabajador, se crea un nuevo objeto Trabajador con los detalles obtenidos y se devuelve.
	 * Si no se encuentra ningún trabajador, se devuelve null.
	 *
	 * @param dni El DNI del trabajador a buscar.
	 * @return Un objeto Trabajador si se encuentra uno con el DNI proporcionado; null si no se encuentra ninguno.
	 * @throws SQLException Si ocurre un error al preparar o ejecutar la declaración SQL.
	 */
	private Trabajador getTrabajador(String dni) throws SQLException {
		stmt = con.prepareStatement(CONSULTA_TRABAJADOR);
		stmt.setString(1, dni);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Trabajador trabajador = new Trabajador();
			trabajador.setDni(rs.getString("DNI"));
			trabajador.setSalario(rs.getFloat("SALARIO"));
			trabajador.setIs_admin(rs.getBoolean("ES_ADMIN"));
			return trabajador;
		}

		return null;
	}

	/**
	 * Obtiene un cliente de la base de datos por su DNI.
	 *
	 * Este método prepara una declaración SQL para buscar un cliente en la base de datos utilizando su DNI.
	 * Si se encuentra un cliente, se crea un nuevo objeto Cliente con el DNI obtenido y se devuelve.
	 * Si no se encuentra ningún cliente, se devuelve null.
	 *
	 * @param dni El DNI del cliente a buscar.
	 * @return Un objeto Cliente si se encuentra uno con el DNI proporcionado; null si no se encuentra ninguno.
	 * @throws SQLException Si ocurre un error al preparar o ejecutar la declaración SQL.
	 */
	public Cliente getCliente(String dni) throws SQLException {
		stmt = con.prepareStatement(CONSULTA_CLIENTE);
		stmt.setString(1, dni);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setDni(rs.getString("DNI"));
			return cliente;
		}

		return null;
	}

	/**
	 * Obtiene el código de un juego por su nombre.
	 *
	 * Este método prepara una declaración SQL para buscar el código de un juego en la base de datos utilizando su nombre.
	 * Si se encuentra el juego, se devuelve su código. Si no se encuentra ningún juego, se devuelve 0.
	 *
	 * @param nombre El nombre del juego a buscar.
	 * @return El código del juego si se encuentra uno con el nombre proporcionado; 0 si no se encuentra ninguno.
	 * @throws SQLException Si ocurre un error al preparar o ejecutar la declaración SQL.
	 */
	public int obtenerCodigoDeJuegoPorNombre(String nombre) throws SQLException {
		stmt = con.prepareStatement(conseguirCodigoDeNombre);
		stmt.setString(1, nombre);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			return rs.getInt("COD_JUEGO");
		}

		return 0;
	}

	/**
	 * Inicia sesión de un usuario en el sistema.
	 *
	 * Este método intenta autenticar a un usuario mediante su correo electrónico y contraseña.
	 * Si la autenticación es exitosa, se obtiene el perfil del usuario de la base de datos y se verifica si es un trabajador o un cliente.
	 * Dependiendo del tipo de usuario, se crea un objeto Trabajador o Cliente con los detalles obtenidos.
	 * En caso de éxito, se devuelve el objeto correspondiente; en caso contrario, se lanza una excepción.
	 *
	 * @param email El correo electrónico del usuario que intenta iniciar sesión.
	 * @param contrasena La contraseña del usuario que intenta iniciar sesión.
	 * @return Un objeto Persona que representa al usuario autenticado, ya sea un Trabajador o un Cliente.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el usuario no se encuentra en la base de datos o si la contraseña no coincide.
	 */
	@Override
	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException {
		ResultSet rs = null;
		Persona per = null, persona = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(inicioSesion);
			stmt.setString(1, email);
			stmt.setString(2, contrasena);

			rs = stmt.executeQuery();

			if (rs.next()) {
				persona = new Persona();
				persona.setDni(rs.getString("DNI"));
				persona.setNombre(rs.getString("NOMBRE_PERSONA"));
				persona.setApellido(rs.getString("APELLIDO"));
				persona.setEdad(rs.getInt("EDAD"));
				persona.setDireccion(rs.getString("DIRECCION"));
				persona.setEmail(rs.getString("EMAIL"));
				persona.setContrasena(rs.getString("CONTRASENA"));

				// Combrobar si es Trabajador o Cliente
				stmt = con.prepareStatement(CONSULTA_TRABAJADOR);
				stmt.setString(1, persona.getDni());

				rs = stmt.executeQuery();

				if (rs.next()) {
					per = new Trabajador();
					per.setDni(persona.getDni());
					per.setNombre(persona.getNombre());
					per.setApellido(persona.getApellido());
					per.setEdad(persona.getEdad());
					per.setDireccion(persona.getDireccion());
					per.setEmail(persona.getEmail());
					per.setContrasena(persona.getContrasena());

					((Trabajador) per).setSalario(rs.getFloat("SALARIO"));
					((Trabajador) per).setIs_admin(rs.getBoolean("ES_ADMIN"));
				} else {
					// Combrobar si es Trabajador o Cliente
					stmt = con.prepareStatement(CONSULTA_CLIENTE);
					stmt.setString(1, persona.getDni());

					rs = stmt.executeQuery();

					if (rs.next()) {
						per = new Cliente();

						per.setDni(persona.getDni());
						per.setNombre(persona.getNombre());
						per.setApellido(persona.getApellido());
						per.setEdad(persona.getEdad());
						per.setDireccion(persona.getDireccion());
						per.setEmail(persona.getEmail());
						per.setContrasena(persona.getContrasena());

					}
				}

			} else {
				throw new LogInException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();
		}

		return per;
	}

	/**
	 * Registra un nuevo usuario en el sistema.
	 *
	 * Este método registra un nuevo usuario en la base de datos, almacenando sus detalles personales y marcándolo como cliente.
	 * Primero, se abre una conexión a la base de datos. Luego, se prepara una declaración SQL para insertar los detalles del usuario
	 * en la tabla de personas. Después de insertar los detalles personales, se prepara otra declaración SQL para marcar al usuario
	 * como cliente en la tabla de clientes. Finalmente, se cierra la conexión a la base de datos.
	 *
	 * @param persona Objeto Persona que contiene los detalles del usuario a registrar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el email esta duplicado.
	 */
	@Override
	public void registroUsuario(Persona persona) throws ErrorGeneral, LogInException {
		ResultSet rs = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(comprobarEmailDuplicado);
			stmt.setString(1, persona.getEmail());
			
			rs = stmt.executeQuery();
			if (!rs.next()) {
				stmt = con.prepareStatement(altaPersona);
	
				stmt.setString(1, persona.getDni());
				stmt.setString(2, persona.getNombre());
				stmt.setString(3, persona.getApellido());
				stmt.setInt(4, persona.getEdad());
				stmt.setString(5, persona.getDireccion());
				stmt.setString(6, persona.getEmail());
				stmt.setString(7, persona.getContrasena());
	
				stmt.executeUpdate();
	
				stmt = con.prepareStatement(altaCliente);
	
				stmt.setString(1, persona.getDni());
				stmt.executeUpdate();
			} else {
				throw new LogInException();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();
		}

		this.closeConnection();
	}

	/**
	 * Almacena un nuevo trabajador en el sistema.
	 *
	 * Este método registra un nuevo trabajador en la base de datos, almacenando sus detalles personales y especificando su salario.
	 * Primero, se abre una conexión a la base de datos. Luego, se prepara una declaración SQL para insertar los detalles del trabajador
	 * en la tabla de personas. Después de insertar los detalles personales, se prepara otra declaración SQL para almacenar el salario
	 * y los privilegios de administrador del trabajador en la tabla de trabajadores. Finalmente, se cierra la conexión a la base de datos.
	 *
	 * @param trabajador Este objeto contiene los detalles personales del trabajador a registrar.
	 * @param txtSueldo JTextField que contiene el valor del salario del trabajador a ingresar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el proceso de registro falla debido a una condición de error específica.
	 */
	@Override
	public void altaTrabajador(Persona trabajador, JTextField txtSueldo) throws ErrorGeneral, LogInException {
		// METODO PARA AÑADIR UN TRABAJADOR

		openConnection();

		try {
			stmt = con.prepareStatement(altaPersona);

			stmt.setString(1, trabajador.getDni());
			stmt.setString(2, trabajador.getNombre());
			stmt.setString(3, trabajador.getApellido());
			stmt.setInt(4, trabajador.getEdad());
			stmt.setString(5, trabajador.getDireccion());
			stmt.setString(6, trabajador.getEmail());
			stmt.setString(7, trabajador.getContrasena());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stmt = con.prepareStatement(altaTrabajador);

			stmt.setString(1, trabajador.getDni());
			stmt.setFloat(2, ((Trabajador) trabajador).getSalario());
			stmt.setBoolean(3, ((Trabajador) trabajador).isIs_admin());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();

	}
	
	/**
	 * Busca un cliente en la base de datos por su dirección de correo electrónico.
	 *
	 * Este método prepara una declaración SQL para buscar un cliente en la base de datos utilizando su dirección de correo electrónico.
	 * Si se encuentra un cliente, se crea un nuevo objeto Cliente con el DNI obtenido y se devuelve.
	 * Si no se encuentra ningún cliente, se devuelve null.
	 *
	 * @param email La dirección de correo electrónico del cliente a buscar.
	 * @return Un objeto Cliente si se encuentra uno con el correo electrónico proporcionado; null si no se encuentra ninguno.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el proceso de búsqueda falla debido a una condición de error específica.
	 */
	@Override
	public Cliente obtenerClientePorEmail(String email) throws ErrorGeneral, LogInException {
		Cliente cliente = null;
		ResultSet rs;

		openConnection();
		try {
			stmt = con.prepareStatement(COMPROBAR_EMAIL_CLIENTE);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setDni(rs.getString("DNI"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return cliente;

	}

	/**
	 * Busca una persona en la base de datos por su dirección de correo electrónico.
	 *
	 * Este método prepara una declaración SQL para buscar una persona en la base de datos utilizando su dirección de correo electrónico.
	 * Si se encuentra una persona, se crea un nuevo objeto Persona con todos los detalles obtenidos y se devuelve.
	 * Si no se encuentra ninguna persona, se devuelve null.
	 *
	 * @param email La dirección de correo electrónico de la persona a buscar.
	 * @return Un objeto Persona si se encuentra uno con el correo electrónico proporcionado; null si no se encuentra ninguno.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el proceso de búsqueda falla debido a una condición de error específica.
	 */
	@Override
	public Persona obtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException {
		Persona per = null;
		ResultSet rs;
		openConnection();
		try {
			stmt = con.prepareStatement(COMPROBAR_EMAIL_PERSONA);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next()) {
				per = new Persona();
				per.setDni(rs.getString("DNI"));
				per.setNombre(rs.getString("NOMBRE_PERSONA"));
				per.setApellido(rs.getString("APELLIDO"));
				per.setEdad(rs.getInt("EDAD"));
				per.setEmail(rs.getString("EMAIL"));
				per.setDireccion(rs.getString("DIRECCION"));
				per.setContrasena(rs.getString("CONTRASENA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return per;

	}

	/**
	 * Elimina un usuario de la base de datos por su DNI.
	 *
	 * Este método prepara una declaración SQL para eliminar un usuario de la base de datos utilizando su DNI.
	 * No devuelve ningún valor.
	 *
	 * @param dni El DNI del usuario a eliminar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el proceso de eliminación falla debido a una condición de error específica.
	 */
	@Override
	public void darBaja(String dni) throws ErrorGeneral, LogInException {
		openConnection();
		try {
			stmt = con.prepareStatement(DAR_DE_BAJA);
			stmt.setString(1, dni);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
	}

	/**
	 * Guarda los detalles de un cliente en la base de datos.
	 *
	 * Este método actualiza los detalles de un cliente existente en la base de datos con los nuevos valores proporcionados.
	 * Se abre una conexión a la base de datos, luego se prepara una declaración SQL para actualizar los detalles del cliente.
	 * Los detalles incluyen el nombre, apellido, edad, dirección, contraseña y DNI del cliente. Finalmente, se cierra la conexión a la base de datos.
	 *
	 * @param cliente Objeto Cliente que contiene los nuevos detalles del cliente a guardar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws LogInException Si el proceso de guardado falla debido a una condición de error específica.
	 */
	@Override
	public void guardar(Cliente cliente) throws ErrorGeneral, LogInException {
		openConnection();
		try {
			stmt = con.prepareStatement(GUARDAR_PERSONA);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setInt(3, cliente.getEdad());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getContrasena());
			stmt.setString(6, cliente.getDni());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * Rellena una lista con nombres de juegos disponibles en stock.
	 *
	 * Este método consulta la base de datos para encontrar juegos que coincidan con una cadena de búsqueda,
	 * y agrega los nombres de los juegos encontrados a una lista. Esta lista puede ser utilizada para rellenar un ComboBox
	 * en una interfaz gráfica de usuario, permitiendo al usuario seleccionar entre los juegos disponibles.
	 *
	 * @param buscaJuego Un texto que representa el término de búsqueda para filtrar los juegos.
	 * @return Una lista, donde cada cadena es el nombre de un juego disponible
	 *         que coincide con el término de búsqueda.
	 */
	@Override
	public List<String> rellenarComboBoxJuegosStock(String buscaJuego) {
		List<String> nombreJuegos = new ArrayList<>();
		ResultSet rs = null;
		String nombreJuego, buscarJuego;
		buscarJuego = buscaJuego;

		this.openConnection();

		try {
			stmt = con.prepareStatement(cogerNombreJuegos);

			stmt.setString(1, "%" + buscarJuego + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				nombreJuego = rs.getString("NOMBRE_JUEGO");
				nombreJuegos.add(nombreJuego);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConnection();
		return nombreJuegos;
	}

	/**
	 * Rellena una lista con nombres de proveedores disponibles.
	 *
	 * Este método consulta la base de datos para encontrar todos los proveedores registrados,
	 * y agrega los nombres de los proveedores encontrados a una lista. Esta lista puede ser utilizada para rellenar un ComboBox
	 * en una interfaz gráfica de usuario, permitiendo al usuario seleccionar entre los proveedores disponibles.
	 *
	 * @return Una lista, donde cada cadena es el nombre de un proveedor registrado.
	 */
	@Override
	public List<String> rellenarComboBoxStockProveedores() {
		List<String> nombreProveedores = new ArrayList<>();
		String nombreProveedor;
		ResultSet rs = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(cogerNombreProveedores);

			rs = stmt.executeQuery();

			while (rs.next()) {
				nombreProveedor = rs.getString("NOMBRE_PROVEEDOR");
				nombreProveedores.add(nombreProveedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConnection();
		return nombreProveedores;
	}

	/**
	 * Actualiza o inserta información de stock para un juego específico en la base de datos.
	 *
	 * Este método intenta actualizar la cantidad de stock de un juego específico en la base de datos. Si el juego ya existe
	 * en la tabla de proveedores, se actualiza la cantidad de stock. Si no existe, se inserta un nuevo registro con la
	 * información del proveedor y la cantidad de stock. Además, se actualiza la cantidad de juegos disponibles en la tabla
	 * de juegos. Finalmente, muestra un mensaje de confirmación al usuario.
	 *
	 * @param nombre El nombre del juego para el cual se va a actualizar o insertar el stock.
	 * @param cantidad La cantidad de unidades del juego que se van a agregar o restar del stock.
	 * @param nombreProveedor El nombre del proveedor del juego.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 * @throws ExcepcionStock Si hay una excepción relacionada con el manejo del stock de juegos.
	 */
	@Override
	public void enviarStock(String nombre, int cantidad, String nombreProveedor) throws ErrorGeneral, ExcepcionStock {
		ResultSet rs = null;
		int codJuego = 0;
		Proveedor proveedor = null;

		this.openConnection();
		try {
			stmt = con.prepareStatement(conseguirDatosDeNombreProveedor);
			stmt.setString(1, nombreProveedor);
			rs = stmt.executeQuery();
			if (rs.next()) {
				proveedor = new Proveedor();
				proveedor.setCodProveedor(rs.getInt("COD_PROVEEDOR"));
				proveedor.setNombreProveedor(nombreProveedor);
				proveedor.setTelefono(rs.getInt("TELEFONO"));
				proveedor.setEmail(rs.getString("EMAIL"));
			}
			stmt = con.prepareStatement(conseguirCodigoDeNombre);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			if (rs.next()) {
				codJuego = rs.getInt("COD_JUEGO");
			}
			stmt = con.prepareStatement(comprobacionInsertTablaProvee);
			stmt.setInt(1, codJuego);
			stmt.setInt(2, proveedor.getCodProveedor());
			rs = stmt.executeQuery();
			if (rs.next()) {
				stmt = con.prepareStatement(updateTablaProvee);
				stmt.setInt(1, cantidad);
				stmt.setDate(2, Date.valueOf(LocalDate.now()));
				stmt.setInt(3, codJuego);
				stmt.setInt(4, proveedor.getCodProveedor());
				stmt.executeUpdate();
			} else {
				stmt = con.prepareStatement(insertTablaProvee);
				stmt.setDate(1, Date.valueOf(LocalDate.now()));
				stmt.setInt(2, cantidad);
				stmt.setInt(3, codJuego);
				stmt.setInt(4, proveedor.getCodProveedor());
				stmt.executeUpdate();
				
			}
			
			stmt = con.prepareStatement(anadirCantidadJuegos);
			stmt.setInt(1, codJuego);
			stmt.setInt(2, cantidad);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Stock reabastecido con éxito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();
		}
		this.closeConnection();
		
	}

	/**
	 * Rellena una lista con nombres de juegos disponibles para modificar.
	 *
	 * Este método consulta la base de datos para encontrar juegos que coincidan con una cadena de búsqueda,
	 * y agrega los nombres de los juegos encontrados a una lista. Esta lista puede ser utilizada para rellenar un ComboBox
	 * en una interfaz gráfica de usuario, permitiendo al usuario seleccionar entre los juegos disponibles para modificar.
	 *
	 * @param buscaJuego Un texto que representa el término de búsqueda para filtrar los juegos.
	 * @return Una lista, donde cada cadena es el nombre de un juego disponible
	 *         que coincide con el término de búsqueda.
	 */
	@Override
	public List<String> rellenarComboBoxModificar(String buscaJuego) {
		List<String> nombreJuegos = new ArrayList<>();
		ResultSet rs = null;
		String nombreJuego, buscarJuego;
		buscarJuego = buscaJuego;

		this.openConnection();

		try {
			stmt = con.prepareStatement(cogerNombreJuegos);

			stmt.setString(1, "%" + buscarJuego + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				nombreJuego = rs.getString("NOMBRE_JUEGO");
				nombreJuegos.add(nombreJuego);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.closeConnection();
		return nombreJuegos;
	}

	/**
	 * Modifica los detalles de un juego en la base de datos.
	 *
	 * Este método actualiza los detalles de un juego existente en la base de datos con los nuevos valores proporcionados.
	 * Primero, se busca el código del juego por su nombre para asegurar que se modifique el juego correcto.
	 * Luego, se prepara una declaración SQL para actualizar los detalles del juego, incluyendo el nombre, año, precio,
	 * género y descripción. Finalmente, se ejecuta la actualización en la base de datos.
	 *
	 * @param juego Objeto Juego que contiene los nuevos detalles del juego a modificar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	@Override
	public void modificarJuego(Juego juego) throws ErrorGeneral {
		int codJuego = 0;
		ResultSet rs = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(conseguirCodigoDeNombre);
			stmt.setString(1, juego.getNombre());
			rs = stmt.executeQuery();
			if (rs.next()) {
				codJuego = rs.getInt("COD_JUEGO");
			}
			stmt = con.prepareStatement(modificarJuego);
			stmt.setInt(1, codJuego);
			stmt.setString(2, juego.getNombre());
			stmt.setInt(3, juego.getAnio());
			stmt.setFloat(4, juego.getPrecio());
			stmt.setString(5, juego.getGenero());
			stmt.setString(6, juego.getDescripcion());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();

		}
		this.closeConnection();
	}

	/**
	 * Encuentra y devuelve un juego específico basado en su nombre para su posterior modificación.
	 *
	 * Este método busca en la base de datos un juego cuyo nombre coincida con el proporcionado. Si se encuentra un juego,
	 * se crea un nuevo objeto Juego con los detalles del juego encontrado y se devuelve. Esto permite seleccionar
	 * un juego específico para realizar modificaciones sobre sus detalles.
	 *
	 * @param nombreJuego El nombre del juego que se desea encontrar y modificar.
	 * @return Un objeto Juego que contiene los detalles del juego encontrado, o null si no se encuentra ningún juego con ese nombre.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	@Override
	public Juego elegirJuegoModificar(String nombreJuego) throws ErrorGeneral {
		Juego juego = new Juego();
		ResultSet rs = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(conseguirDatosDeNombre);
			stmt.setString(1, nombreJuego);
			rs = stmt.executeQuery();
			if (rs.next()) {
				juego.setCodJuego(rs.getInt("COD_JUEGO"));
				juego.setCaratula(rs.getString("CARATULA"));
				juego.setNombre(rs.getString("NOMBRE_JUEGO"));
				juego.setAnio(rs.getInt("ANIO"));
				juego.setPrecio(rs.getFloat("PRECIO"));
				juego.setGenero(rs.getString("GENERO"));
				juego.setDescripcion(rs.getString("DESCRIPCION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();

		}
		this.closeConnection();

		return juego;
	}

	/**
	 * Inserta un nuevo juego en la base de datos.
	 *
	 * Este método inserta un nuevo juego en la base de datos con los detalles proporcionados en el objeto Juego.
	 * Antes de insertar, construye la ruta completa de la carátula del juego y la guarda junto con otros detalles del juego.
	 *
	 * @param juego Objeto Juego que contiene los detalles del juego a insertar.
	 * @throws ErrorGeneral Si ocurre un error general durante la ejecución del método, como problemas de conexión a la base de datos.
	 */
	@Override
	public void insertarJuego(Juego juego) throws ErrorGeneral {
		String rutaCaratula = ".\\.\\img\\" + juego.getCaratula();
		this.openConnection();

		try {
			stmt = con.prepareStatement(insertarJuego);
			stmt.setString(1, rutaCaratula);
			stmt.setString(2, juego.getNombre());
			stmt.setInt(3, juego.getAnio());
			stmt.setFloat(4, juego.getPrecio());
			stmt.setString(5, juego.getGenero());
			stmt.setString(6, juego.getDescripcion());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGeneral();

		}
		this.closeConnection();
	}

	/**
	 * Realiza la compra de un juego por parte de una persona.
	 *
	 * Este método registra la compra de un juego por parte de una persona en la base de datos. Verifica primero si la venta
	 * ya existe para evitar duplicados. Si la venta no existe, la inserta; si existe, simplemente suma la cantidad vendida.
	 * Después de registrar la venta, llama a un procedimiento almacenado para procesar la compra del juego.
	 *
	 * @param persona Objeto Persona que representa a la persona realizando la compra.
	 * @param juego Objeto Juego que representa el juego comprado.
	 * @throws ExcepcionStock Si ocurre una excepción relacionada con el manejo del stock de juegos.
	 */
	@Override
	public void comprarJuego(Persona persona, Juego juego) throws ExcepcionStock {
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(comprobacionInsertTablaVenta);
			stmt.setInt(1, juego.getCodJuego());
			stmt.setString(2, persona.getDni());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				stmt = con.prepareStatement(sumaTablaVenta);
				stmt.setDate(1, Date.valueOf(LocalDate.now()));
				stmt.setInt(2, juego.getCodJuego());
				stmt.setString(3, persona.getDni());
				stmt.executeUpdate();
			}else {
				stmt = con.prepareStatement(insertTablaVenta);
				stmt.setInt(1, juego.getCodJuego());
				stmt.setString(2, persona.getDni());
				stmt.setDate(3, Date.valueOf(LocalDate.now()));
				stmt.setInt(4, 1);
				stmt.executeUpdate();
				
			}
			
			stmt = con.prepareStatement(llamarProcCompraJuego);
			stmt.setInt(1, juego.getCodJuego());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionStock();
		}
		
		this.closeConnection();
		
	}

	/**
	 * Método sobrescrito para obtener el número de unidades disponibles de un juego específico.
	 * Este método realiza una consulta SQL para buscar el número de unidades en stock del juego dado.
	 *
	 * @param juego El objeto Juego cuyo número de unidades se desea consultar.
	 * @return Un entero representando el número de unidades disponibles del juego especificado.
	 */
	@Override
	public int ConseguirUnidades(Juego juego) {
		int num = 0;
		ResultSet rs = null;
		
		this.openConnection();
		
		try {
			stmt = con.prepareStatement(conseguirUnds);
			stmt.setInt(1, juego.getCodJuego());

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt("NUM_UNIDADES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.closeConnection();
		
		return num;
	}

}

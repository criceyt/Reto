package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Juego;
import clases.Persona;
import controlador.Controlador;
import excepciones.ErrorContrasenaLogin;
import excepciones.ErrorGeneral;
import excepciones.ExcepcionStock;
import excepciones.LogInException;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * Esta clase representa la ventana de administrador de la aplicación.
 * Proporciona acceso a diversas funcionalidades administrativas a través de cuatro pestañas principales:
 * <ul>
 *     <li><b>Gestión de clientes:</b> Permite a los administradores gestionar la información de los clientes.</li>
 *     <li><b>Inserción/modificación de juegos:</b> Ofrece herramientas para agregar o modificar detalles de los juegos disponibles.</li>
 *     <li><b>Inserción de trabajadores:</b> Facilita la adición de nuevos trabajadores al sistema, incluyendo sus detalles laborales.</li>
 *     <li><b>Gestión de stock:</b> Permite a los administradores supervisar y gestionar el inventario de productos o servicios.</li>
 * </ul>
 */
public class VentanaTrabajador extends JDialog implements ActionListener {
	/**
	 * Identificador único serializado para la clase, necesario para la serialización de objetos.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel principal que contiene todos los componentes de la interfaz gráfica.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Campo de texto para la dirección del trabajador.
	 */
	private JTextField tFEmailComp;
	/**
	 * Campo de texto para el DNI del trabajador.
	 */
	private JTextField tFDni;
	/**
	 * Campo de texto para el nombre del trabajador.
	 */
	private JTextField tFNombre;
	/**
	 * Campo de texto para el apellido del trabajador.
	 */
	private JTextField tFApellido;
	/**
	 * Campo de texto para la edad del trabajador.
	 */
	private JTextField tFEdad;
	/**
	 * Campo de texto para el correo electrónico del trabajador.
	 */
	private JTextField tFEmail;
	/**
	 * Campo de texto para la dirección del trabajador.
	 */
	private JTextField tFDireccion;
	/**
	 * Campo de texto para la contraseña del trabajador.
	 */
	private JTextField tFConfContrasena;
	/**
	 * Campo de texto para la contraseña del trabajador.
	 */
	private JTextField tFContrasena;
	/**
	 * Referencia al controlador principal de la aplicación, encargado de gestionar las operaciones de negocio.
	 * Esta instancia permite acceder a funciones y métodos relacionados con la lógica de negocio y la interacción
	 * con la base de datos o servicios externos.
	 */
	private Controlador cont;
	/**
	 * Etiqueta para el campo de texto del nombre.
	 */
	private JLabel lblNombre;
	/**
	 * Etiqueta para el campo de texto del apellido.
	 */
	private JLabel lblApellido;
	/**
	 * Etiqueta para el campo de texto de la edad.
	 */
	private JLabel lblEdad;
	/**
	 * Etiqueta para el campo de texto de la dirección.
	 */
	private JLabel lblDireccion1;
	/**
	 * Campo de texto para buscar un juego.
	 */
	private JTextField txtFieldBuscarJuego;
	/**
	 * Botón para buscar un juego.
	 */
	private JButton btnBuscarJuego;
	/**
	 * Combobox para seleccionar el nombre de un juego.
	 */
	private JComboBox<String> comboBoxNombreJuego;
	/**
	 * Botón para elegir un juego.
	 */
	private JButton btnElegirJuego;
	/**
	 * Area de texto para describir un juego.
	 */
	private JTextArea textAreaDescripcion;
	/**
	 * Botón para insertar un juego.
	 */
	private JButton btnInsertarJuego;
	/**
	 * Botón para limpiar los datos de un juego.
	 */
	private JButton btnLimpiarJuego;
	/**
	 * Botón para modificar un juego.
	 */
	private JButton btnModificarJuego;
	/**
	 * Botón para buscar.
	 */
	private JButton btnBuscar;
	/**
	 * Combobox para seleccionar un juego.
	 */
	private JComboBox<String> comboBoxJuego;
	/**
	 * Espin para seleccionar la cantidad de un juego.
	 */
	private JSpinner spinnerCantidad;
	/**
	 * Combobox para seleccionar un proveedor.
	 */
	private JComboBox<String> comboBoxProveedor;
	/**
	 * Botón para limpiar.
	 */
	private JButton btnLimpiar;
	/**
	 * Botón para enviar.
	 */
	private JButton btnEnviar;
	/**
	 * Variable booleana para comprobar si el DNI ha sido validado.
	 */
	private boolean boolComprobarDNI = true;
	/**
	 * Variable booleana para comprobar si el nombre ha sido validado.
	 */
	private boolean boolComprobarNombre = true;
	/**
	 * Variable booleana para comprobar si el apellido ha sido validado.
	 */
	private boolean boolComprobarApellido = true;
	/**
	 * Variable booleana para comprobar si la edad ha sido validada.
	 */
	private boolean boolComprobarEdad = true;
	/**
	 * Campo de texto para buscar un juego por su nombre.
	 */
	private JTextField txtFieldNombreJuegoBuscar;
	/**
	 * Campo de texto para insertar el nombre de un juego.
	 */
	private JTextField txtFieldNombreJuegoInsertar;
	/**
	 * Campo de texto para insertar el año de un juego.
	 */
	private JTextField txtFieldAnoJuego;
	/**
	 * Campo de texto para insertar el precio de un juego.
	 */
	private JTextField txtFieldPrecioJuego;
	/**
	 * Campo de texto para insertar el nombre de la imagen de un juego.
	 */
	private JTextField txtFieldNombreImagen;
	/**
	 * Etiqueta para el campo de texto de la imagen del juego.
	 */
	private JLabel lblNombreImagen;
	/**
	 * Campo de texto para insertar el género de un juego.
	 */
	private JTextField txtFieldGenero;
	/**
	 * Etiqueta (JLabel) utilizada para mostrar el nombre del juego al usuario.
	 * Se utiliza principalmente para dar retroalimentación visual sobre la validez del nombre ingresado.
	 */
	private JLabel lblNombreJuego2;
	/**
	 * Etiqueta (JLabel) utilizada para mostrar el año del juego al usuario.
	 * Ayuda a asegurar que el usuario haya ingresado un valor válido para el año del juego.
	 */
	private JLabel lblAnoInsertar;
	/**
	 * Etiqueta (JLabel) utilizada para mostrar la descripción del juego al usuario.
	 * Proporciona retroalimentación visual sobre la validez de la descripción ingresada.
	 */
	private JLabel lblDescripcionInsertar;
	/**
	 * Etiqueta (JLabel) utilizada para mostrar el precio del juego al usuario.
	 * Permite al usuario verificar si ha ingresado un precio válido.
	 */
	private JLabel lblPrecioInsertar;
	/**
	 * Etiqueta (JLabel) utilizada para mostrar el género del juego al usuario.
	 * Ayuda a asegurar que el usuario haya seleccionado un género válido para el juego.
	 */
	private JLabel lblGenero;


	
	/**
	 * Constructor de la ventana de administración.
	 *
	 * @param cont El controlador que maneja las operaciones de la aplicación.
	 * @param padre La ventana padre de esta ventana.
	 * @param modal Si la ventana debe ser modal o no.
	 */
	public VentanaTrabajador(Controlador cont, InicioSesion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		this.cont = cont;

		// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ventana de Administrador");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
		setBounds(100, 100, 807, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 791, 373);
		contentPanel.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("GESTIÓN DE CLIENTES  ", null, panel, null);
		panel.setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(UIManager.getColor("Button.background"));
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(45, 10, 60, 35);
		panel.add(lblEmail);

		tFEmailComp = new JTextField();
		tFEmailComp.setBounds(115, 17, 297, 25);
		panel.add(tFEmailComp);
		tFEmailComp.setColumns(10);

		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}

			/**
			 * Método privado para verificar si un cliente existe en el sistema mediante su correo electrónico.
			 * Este método intenta obtener el cliente asociado al correo electrónico proporcionado.
			 * Si encuentra coincidencias, actualiza los campos de texto correspondientes con la información del cliente.
			 * En caso contrario, muestra un mensaje de error indicando que el correo electrónico no fue encontrado.
			 */
			private void comprobar() {
				String email = tFEmailComp.getText();
				Cliente cliente = null;
				Persona per = null;
				try {
					cliente = cont.ObtenerClientePorEmail(email);
					per = cont.ObtenerPersonaPorEmail(email);
				} catch (ErrorGeneral e) {
					e.printStackTrace();
				} catch (LogInException e) {
					e.printStackTrace();
				}
				if (cliente != null) {
					tFDni.setText(cliente.getDni());
					tFNombre.setText(per.getNombre());
					tFApellido.setText(per.getApellido());
					tFEdad.setText(String.valueOf(per.getEdad()));
					tFEmail.setText(per.getEmail());
					tFDireccion.setText(per.getDireccion());
					tFContrasena.setText(per.getContrasena());
					tFConfContrasena.setText(per.getContrasena());
				} else {
					ErrorContrasenaLogin.errorGmailNoEncontrado();
				}

			}
		});
		btnComprobar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnComprobar.setBackground(new Color(255, 102, 102));
		btnComprobar.setBounds(433, 17, 133, 28);
		panel.add(btnComprobar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			/**
			 * Método que se ejecuta cuando se activa un evento de acción, como un clic de botón.
			 * Este método realiza varias validaciones sobre los campos de entrada para asegurar que los datos ingresados son válidos.
			 * Las validaciones incluyen verificar que los nombres y apellidos contengan solo letras, que la edad sea un número válido,
			 * que la dirección contenga solo letras, y que las contraseñas sean iguales y tengan al menos 8 caracteres.
			 * Si alguna de las validaciones falla, se muestran mensajes de error y se impide el registro del trabajador.
			 * Si todas las validaciones pasan, se procede a guardar los datos del trabajador.
			 */
			public void actionPerformed(ActionEvent e) {
				
				// Validador de si el nombre contiene solo letras
				if (tFNombre.getText().isEmpty() || !validarLetras(tFNombre.getText().trim())) {
					lblNombre.setForeground(Color.RED);
					boolComprobarDNI = false;
				} else {
					lblNombre.setForeground(Color.WHITE);
					boolComprobarDNI = true;
				}
				
				// Validador de si el apellido contiene solo letras
				if (tFApellido.getText().isEmpty() || !validarLetras(tFApellido.getText().trim())) {
					lblApellido.setForeground(Color.RED);
					boolComprobarNombre = false;
				} else {
					lblApellido.setForeground(Color.WHITE);
					boolComprobarNombre = true;
				}
				
				// Verificar si el campo de año de nacimiento está vacío o no contiene 4 números
				if (tFEdad.getText().isEmpty() || !validarEdad(tFEdad.getText().trim())) {
					lblEdad.setForeground(Color.RED);
					boolComprobarApellido = false;
				} else {
					// Parsear el año de nacimiento solo si la validación previa pasa
					int edadTrabajador = Integer.parseInt(tFEdad.getText());
					int anioActual = LocalDate.now().getYear();

					// Verificar si el año de nacimiento es menor que el año actual
					if (anioActual < edadTrabajador) {
						lblEdad.setForeground(Color.RED);
						boolComprobarApellido = false;
					} else {
						lblEdad.setForeground(Color.WHITE);
						boolComprobarApellido = true;
					}
				}
				
				// Validador de si la direccion contiene solo letras
				if (tFDireccion.getText().isEmpty() || !validarLetrasYNumeros(tFDireccion.getText().trim())) {
					lblDireccion1.setForeground(Color.RED);
					boolComprobarEdad = false;
				} else {
					lblDireccion1.setForeground(Color.WHITE);
					boolComprobarEdad = true;
				}
				
				if (!boolComprobarDNI | !boolComprobarNombre | !boolComprobarApellido | !boolComprobarEdad) {
					ErrorContrasenaLogin.ErrorDeTrabajadorDatos();
				} else {
					// Controlador de que las contraseñas sean mayores a 8 digitos y sean iguales
					String contrasenia1 = tFContrasena.getText();
					String contrasenia2 = tFConfContrasena.getText();

					if (contrasenia1.equals(contrasenia2)) {
						if (contrasenia1.length() < 8) {
							int option = JOptionPane.showOptionDialog(null,
									"La contraseña tiene menos de 8 caracteres\n¿Deseas seguir?", "Alerta",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,

									null, new String[] { "Cambiar contraseña", "Seguir adelante" }, "Cambiar contraseña");

							if (option == JOptionPane.YES_OPTION) {

							} else {
								// Mensaje de Registro con exito
								guardar();
							}
						} else {
							// Mensaje de Registro con exito
							guardar();
						}

					} else {
						// Llamamos a la clase errorContraseñaLogin
						ErrorContrasenaLogin.errorContrasenia();
					}

				}
				
				
			}

			/**
			 * Método privado para guardar los datos de un nuevo cliente en el sistema.
			 * Este método crea una nueva instancia de Cliente, establece sus atributos con los valores ingresados por el usuario
			 * a través de los campos de texto correspondientes, y luego intenta guardar estos datos en el sistema.
			 * Si la operación de guardado es exitosa, se muestra un mensaje de éxito y se borran los campos de texto.
			 * En caso de error, se capturan las excepciones, imprimiendo el stack trace para depuración.
			 */
			private void guardar() {
				Cliente cliente = new Cliente();
				cliente.setDni(tFDni.getText());
				cliente.setNombre(tFNombre.getText());
				cliente.setApellido(tFApellido.getText());
				cliente.setEdad(Integer.parseInt(tFEdad.getText()));
				cliente.setEmail(tFEmail.getText());
				cliente.setDireccion(tFDireccion.getText());
				cliente.setContrasena(tFContrasena.getText());
				cliente.setContrasena(tFConfContrasena.getText());
				try {
					cont.guardar(cliente);
				} catch (ErrorGeneral e) {
					e.printStackTrace();
				} catch (LogInException e) {
					e.printStackTrace();
				}
				ErrorContrasenaLogin.ClienteNuevoGuardado();
				borrarDatos();

			}
		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGuardar.setBackground(new Color(255, 102, 102));
		btnGuardar.setBounds(622, 301, 154, 35);
		panel.add(btnGuardar);

		JButton btnBorrarDatos = new JButton("Borrar datos");
		btnBorrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarDatos();
			}

		});
		btnBorrarDatos.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBorrarDatos.setBackground(new Color(255, 102, 102));
		btnBorrarDatos.setBounds(447, 301, 154, 35);
		panel.add(btnBorrarDatos);

		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				darBaja();
			}
			
			/**
			 * Método privado para dar de baja un cliente en el sistema.
			 * Este método muestra un cuadro de diálogo de confirmación al usuario para verificar si realmente desea dar de baja al cliente.
			 * Si el usuario confirma la acción, se intenta dar de baja al cliente.
			 * Si la operación es exitosa, se borran los campos de texto. En caso de error, se capturan las excepciones imprimiendo el stack trace para depuración.
			 */
			private void darBaja() {

				int opc = JOptionPane.showOptionDialog(null, "Estas seguro que desear dar de baja el cliente?", "Alert",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Dar de baja", "Cancelar" }, "Dar de baja");
				if (opc == JOptionPane.YES_OPTION) {
					try {
						cont.darBaja(tFDni.getText());
					} catch (ErrorGeneral e) {
						e.printStackTrace();
					} catch (LogInException e) {
						e.printStackTrace();
					}
					borrarDatos();
				} else {
				}
			}
		});
		btnDarDeBaja.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDarDeBaja.setBackground(new Color(255, 102, 102));
		btnDarDeBaja.setBounds(272, 301, 154, 35);
		panel.add(btnDarDeBaja);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(UIManager.getColor("Button.background"));
		lblDni.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDni.setBounds(45, 73, 115, 35);
		panel.add(lblDni);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(UIManager.getColor("Button.background"));
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombre.setBounds(45, 123, 97, 35);
		panel.add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(UIManager.getColor("Button.background"));
		lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido.setBounds(45, 168, 97, 35);
		panel.add(lblApellido);

		lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(UIManager.getColor("Button.background"));
		lblEdad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEdad.setBounds(45, 213, 97, 35);
		panel.add(lblEdad);

		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setForeground(UIManager.getColor("Button.background"));
		lblEmail_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1.setBounds(373, 73, 97, 35);
		panel.add(lblEmail_1);

		lblDireccion1 = new JLabel("Dirección:");
		lblDireccion1.setForeground(UIManager.getColor("Button.background"));
		lblDireccion1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDireccion1.setBounds(373, 123, 97, 35);
		panel.add(lblDireccion1);

		tFDni = new JTextField();
		tFDni.setEditable(false);
		tFDni.setColumns(10);
		tFDni.setBounds(125, 80, 224, 25);
		panel.add(tFDni);

		tFNombre = new JTextField();
		tFNombre.setColumns(10);
		tFNombre.setBounds(125, 130, 224, 25);
		panel.add(tFNombre);

		tFApellido = new JTextField();
		tFApellido.setColumns(10);
		tFApellido.setBounds(125, 175, 224, 25);
		panel.add(tFApellido);

		tFEdad = new JTextField();
		tFEdad.setColumns(10);
		tFEdad.setBounds(125, 220, 224, 25);
		panel.add(tFEdad);

		tFEmail = new JTextField();
		tFEmail.setEditable(false);
		tFEmail.setColumns(10);
		tFEmail.setBounds(480, 83, 224, 25);
		panel.add(tFEmail);

		tFDireccion = new JTextField();
		tFDireccion.setColumns(10);
		tFDireccion.setBounds(480, 133, 224, 25);
		panel.add(tFDireccion);

		tFConfContrasena = new JTextField();
		tFConfContrasena.setColumns(10);
		tFConfContrasena.setBounds(480, 220, 224, 25);
		panel.add(tFConfContrasena);

		JLabel lblConfirmaContrasena = new JLabel("Confirma");
		lblConfirmaContrasena.setForeground(UIManager.getColor("Button.background"));
		lblConfirmaContrasena.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblConfirmaContrasena.setBounds(373, 201, 97, 35);
		panel.add(lblConfirmaContrasena);

		JLabel lblContrasenaCliente = new JLabel("Contraseña:");
		lblContrasenaCliente.setForeground(UIManager.getColor("Button.background"));
		lblContrasenaCliente.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblContrasenaCliente.setBounds(373, 168, 97, 35);
		panel.add(lblContrasenaCliente);

		tFContrasena = new JTextField();
		tFContrasena.setColumns(10);
		tFContrasena.setBounds(480, 178, 224, 25);
		panel.add(tFContrasena);

		JLabel lblConfirmaContrasea2 = new JLabel("contraseña:");
		lblConfirmaContrasea2.setForeground(UIManager.getColor("Button.background"));
		lblConfirmaContrasea2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblConfirmaContrasea2.setBounds(373, 216, 97, 35);
		panel.add(lblConfirmaContrasea2);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR JUEGO", null, panel_2, null);
		
		JLabel lblNombreJuego = new JLabel("Nombre del juego: ");
		lblNombreJuego.setForeground(Color.WHITE);
		lblNombreJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreJuego.setBounds(29, 55, 152, 28);
		panel_2.add(lblNombreJuego);
		
		txtFieldNombreJuegoBuscar = new JTextField();
		txtFieldNombreJuegoBuscar.setColumns(10);
		txtFieldNombreJuegoBuscar.setBounds(29, 93, 302, 20);
		panel_2.add(txtFieldNombreJuegoBuscar);
		
		btnBuscarJuego = new JButton("Buscar");
		btnBuscarJuego.setBackground(new Color(255, 102, 102));
		btnBuscarJuego.setBounds(112, 123, 108, 35);
		btnBuscarJuego.addActionListener(this);
		panel_2.add(btnBuscarJuego);
		
		comboBoxNombreJuego = new JComboBox<String>();
		comboBoxNombreJuego.setBounds(29, 187, 302, 28);
		panel_2.add(comboBoxNombreJuego);
		
		btnElegirJuego = new JButton("Elegir");
		btnElegirJuego.setBackground(new Color(255, 102, 102));
		btnElegirJuego.setBounds(94, 225, 163, 35);
		btnElegirJuego.addActionListener(this);
		panel_2.add(btnElegirJuego);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(366, 226, 216, 92);
		textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);
		panel_2.add(textAreaDescripcion);
		
		lblDescripcionInsertar = new JLabel("Descripcion:");
		lblDescripcionInsertar.setForeground(Color.WHITE);
		lblDescripcionInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcionInsertar.setBounds(356, 185, 108, 28);
		panel_2.add(lblDescripcionInsertar);
		
		lblPrecioInsertar = new JLabel("Precio:");
		lblPrecioInsertar.setForeground(Color.WHITE);
		lblPrecioInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioInsertar.setBounds(356, 105, 89, 28);
		panel_2.add(lblPrecioInsertar);
		
		lblAnoInsertar = new JLabel("Año:");
		lblAnoInsertar.setForeground(Color.WHITE);
		lblAnoInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnoInsertar.setBounds(356, 66, 63, 28);
		panel_2.add(lblAnoInsertar);
		
		lblNombreJuego2 = new JLabel("Nombre: ");
		lblNombreJuego2.setForeground(Color.WHITE);
		lblNombreJuego2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreJuego2.setBounds(356, 27, 89, 28);
		panel_2.add(lblNombreJuego2);
		
		txtFieldNombreJuegoInsertar = new JTextField();
		txtFieldNombreJuegoInsertar.setColumns(10);
		txtFieldNombreJuegoInsertar.setBounds(430, 33, 152, 20);
		panel_2.add(txtFieldNombreJuegoInsertar);
		
		txtFieldAnoJuego = new JTextField();
		txtFieldAnoJuego.setColumns(10);
		txtFieldAnoJuego.setBounds(430, 72, 152, 20);
		panel_2.add(txtFieldAnoJuego);
		
		txtFieldPrecioJuego = new JTextField();
		txtFieldPrecioJuego.setColumns(10);
		txtFieldPrecioJuego.setBounds(430, 111, 152, 20);
		panel_2.add(txtFieldPrecioJuego);
		
		btnInsertarJuego = new JButton("Insertar Juego");
		btnInsertarJuego.setBackground(new Color(255, 102, 102));
		btnInsertarJuego.setBounds(606, 283, 154, 35);
		btnInsertarJuego.addActionListener(this);
		panel_2.add(btnInsertarJuego);
		
		btnLimpiarJuego = new JButton("Limpiar");
		btnLimpiarJuego.setBackground(new Color(255, 102, 102));
		btnLimpiarJuego.setBounds(606, 222, 154, 35);
		btnLimpiarJuego.addActionListener(this);
		panel_2.add(btnLimpiarJuego);
		
		btnModificarJuego = new JButton("Modificar");
		btnModificarJuego.setBackground(new Color(255, 102, 102));
		btnModificarJuego.setBounds(606, 165, 154, 35);
		btnModificarJuego.addActionListener(this);
		panel_2.add(btnModificarJuego);
		
		txtFieldNombreImagen = new JTextField();
		txtFieldNombreImagen.setColumns(10);
		txtFieldNombreImagen.setBounds(597, 73, 163, 20);
		panel_2.add(txtFieldNombreImagen);
		
		lblNombreImagen = new JLabel("Nombre de la imagen: ");
		lblNombreImagen.setForeground(Color.WHITE);
		lblNombreImagen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreImagen.setBounds(597, 24, 163, 28);
		panel_2.add(lblNombreImagen);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(341, 27, 1, 292);
		panel_2.add(separator);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(356, 140, 89, 28);
		panel_2.add(lblGenero);
		
		txtFieldGenero = new JTextField();
		txtFieldGenero.setColumns(10);
		txtFieldGenero.setBounds(430, 146, 152, 20);
		panel_2.add(txtFieldGenero);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 160));

		tabbedPane.addTab("STOCK", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNombreJuegoStock = new JLabel("Nombre del juego:");
		lblNombreJuegoStock.setForeground(UIManager.getColor("Button.background"));
		lblNombreJuegoStock.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombreJuegoStock.setBounds(253, 11, 319, 35);
		panel_1.add(lblNombreJuegoStock);
		
		txtFieldBuscarJuego = new JTextField();
		txtFieldBuscarJuego.setColumns(10);
		txtFieldBuscarJuego.setBounds(253, 45, 186, 35);
		panel_1.add(txtFieldBuscarJuego);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setBackground(new Color(255, 102, 102));
		btnBuscar.setBounds(449, 45, 122, 35);
		btnBuscar.addActionListener(this);
		panel_1.add(btnBuscar);
		
		comboBoxJuego = new JComboBox<>();
		comboBoxJuego.setBounds(253, 113, 319, 27);
		panel_1.add(comboBoxJuego);
		
		JLabel lblNombreJuegoStock2 = new JLabel("Nombre del juego:");
		lblNombreJuegoStock2.setForeground(UIManager.getColor("Button.background"));
		lblNombreJuegoStock2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombreJuegoStock2.setBounds(253, 79, 319, 35);
		panel_1.add(lblNombreJuegoStock2);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(UIManager.getColor("Button.background"));
		lblCantidad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCantidad.setBounds(253, 150, 319, 35);
		panel_1.add(lblCantidad);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerCantidad.setBounds(350, 181, 122, 27);
		panel_1.add(spinnerCantidad);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(UIManager.getColor("Button.background"));
		lblProveedor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblProveedor.setBounds(253, 208, 319, 35);
		panel_1.add(lblProveedor);
		
		comboBoxProveedor = new JComboBox<>();
		comboBoxProveedor.setBounds(253, 242, 319, 27);
		panel_1.add(comboBoxProveedor);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLimpiar.setBackground(new Color(255, 102, 102));
		btnLimpiar.setBounds(253, 279, 154, 35);
		btnLimpiar.addActionListener(this);
		panel_1.add(btnLimpiar);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEnviar.setBackground(new Color(255, 102, 102));
		btnEnviar.setBounds(418, 279, 154, 35);
		btnEnviar.addActionListener(this);
		panel_1.add(btnEnviar);
		
		rellenarComboBoxStockProveedores();

	}

	/**
	 * Método privado para rellenar un JComboBox con los nombres de los proveedores disponibles para un juego específico.
	 * Este método primero recupera el nombre del juego ingresado por el usuario a través de un campo de texto.
	 * Luego, obtiene una lista de nombres de proveedores que están disponibles para ese juego. 
	 * Finalmente, itera sobre la lista de nombres de proveedores y los agrega al JComboBox.
	 * Este proceso permite al usuario seleccionar un proveedor específico para el juego que está buscando.
	 */
	private void rellenarComboBoxStockProveedores() {
		String nombreJuego = txtFieldNombreJuegoBuscar.getText();
		List<String> nombreProveedores = new ArrayList<>();
		
		nombreProveedores = cont.rellenarComboBoxStockProveedores(nombreJuego);
		
		for (String nombreProveedor : nombreProveedores) {
			comboBoxProveedor.addItem(nombreProveedor);
		}
	}
		
	/**
	 * Método privado para limpiar los campos de texto relacionados con la información del cliente.
	 * Este método establece el texto de todos los campos de texto a una cadena vacía, efectivamente borrando cualquier dato ingresado anteriormente.
	 * Es útil para preparar la interfaz de usuario para nuevas entradas o para limpiar los datos después de realizar operaciones como guardar o dar de baja.
	 */
	private void borrarDatos() {
		tFEmailComp.setText("");
		tFDni.setText("");
		tFNombre.setText("");
		tFApellido.setText("");
		tFEdad.setText("");
		tFEmail.setText("");
		tFDireccion.setText("");
		tFContrasena.setText("");
		tFConfContrasena.setText("");

	}
	
	/**
	 * Método que se sobrescribe de la interfaz ActionListener para manejar eventos de acción.
	 * Este método verifica el origen del evento y ejecuta diferentes acciones basadas en el botón que disparó el evento.
	 * Las acciones incluyen buscar juegos en stock, elegir un juego para modificar, modificar un juego, buscar juegos para modificar,
	 * enviar stock, limpiar campos de búsqueda y selección, borrar datos de un trabajador, insertar un juego, insertar un trabajador,
	 * y limpiar la pestaña de inserción de juegos.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnBuscar)) {
			buscarJuegosStock();
		}
		if (e.getSource().equals(btnElegirJuego)) {
			elegirJuegoModificar();
		}
		if (e.getSource().equals(btnModificarJuego)) {
			if(validarDatosModificarInsertarJuego()) {
				modificarJuego();
			}
		}
		if (e.getSource().equals(btnBuscarJuego)) {
			buscarJuegosModificar();
		}
		if (e.getSource().equals(btnEnviar)) {
			EnviarStock();
		}
		if (e.getSource().equals(btnLimpiar)) {
			txtFieldBuscarJuego.setText("");
			comboBoxJuego.removeAllItems();
			comboBoxProveedor.setSelectedIndex(-1);
			spinnerCantidad.setValue(1);
		}
		if (e.getSource().equals(btnInsertarJuego)) {
			if(validarDatosModificarInsertarJuego()) {
				insertarJuego();
			}
		}
		if (e.getSource().equals(btnLimpiarJuego)) {
			limpiarPestanaInsertJuego();
		}
		
	}

	/**
	 * Método para validar los datos antes de modificar o insertar un juego en la base de datos.
	 * Este método verifica si todos los campos requeridos están completos y cumplen con las reglas de formato.
	 *
	 * @return true si todos los campos son válidos, false en caso contrario.
	 */
	private boolean validarDatosModificarInsertarJuego() {
		boolean valido = true, boolComprobarNombreJuego, boolComprobarAno, boolComprobarPrecio, boolComprobarGenero, boolComprobarDescripcion, boolComprobarNombreImagen;
		if(txtFieldNombreJuegoInsertar.getText().isEmpty() || !validarLetrasYNumeros(txtFieldNombreJuegoInsertar.getText().replace(" ", "").trim())) {
			lblNombreJuego2 .setForeground(Color.RED);
			boolComprobarNombreJuego = false;
		} else {
			lblNombreJuego2.setForeground(Color.WHITE);
			boolComprobarNombreJuego = true;
		}
		if(txtFieldAnoJuego.getText().isEmpty() || !validarLetrasYNumeros(txtFieldAnoJuego.getText().replace(" ", "").trim())) {
			lblAnoInsertar .setForeground(Color.RED);
			boolComprobarAno = false;
		} else {
			lblAnoInsertar.setForeground(Color.WHITE);
			boolComprobarAno = true;
		}
		if(txtFieldPrecioJuego.getText().isEmpty() || !validarLetrasYNumeros(txtFieldPrecioJuego.getText().replace(" ", "").trim())) {
			lblPrecioInsertar .setForeground(Color.RED);
			boolComprobarPrecio = false;
		} else {
			lblPrecioInsertar.setForeground(Color.WHITE);
			boolComprobarPrecio = true;
		}
		if(txtFieldGenero.getText().isEmpty() || !validarLetrasYNumeros(txtFieldGenero.getText().replace(" ", "").trim())) {
			lblGenero .setForeground(Color.RED);
			boolComprobarGenero = false;
		} else {
			lblGenero.setForeground(Color.WHITE);
			boolComprobarGenero = true;
		}
		if(textAreaDescripcion.getText().isEmpty() || !validarLetrasYNumeros(textAreaDescripcion.getText().replace(" ", "").trim())) {
			lblDescripcionInsertar .setForeground(Color.RED);
			boolComprobarDescripcion = false;
		} else {
			lblDescripcionInsertar.setForeground(Color.WHITE);
			boolComprobarDescripcion = true;
		}
		if(txtFieldNombreImagen.getText().isEmpty() || !validarLetrasYNumeros(txtFieldNombreImagen.getText().replace(" ", "").trim())) {
			lblNombreImagen .setForeground(Color.RED);
			boolComprobarNombreImagen = false;
		} else {
			lblNombreImagen.setForeground(Color.WHITE);
			boolComprobarNombreImagen = true;
		}
		if(!boolComprobarNombreJuego | !boolComprobarAno | !boolComprobarPrecio | !boolComprobarGenero | !boolComprobarDescripcion | !boolComprobarNombreImagen) {
			valido = false;
			ErrorContrasenaLogin.ErrorDeTrabajadorDatos();
		} else {
			valido = true;
		}
		
		return valido;
	}

	/**
	 * Método privado para limpiar y preparar la interfaz de usuario en la pestaña de inserción de juegos.
	 * Este método habilita los campos de texto y el botón de inserción de juegos, establece el texto de los campos de texto a cadenas vacías,
	 * y limpia el JComboBox de nombres de juegos. Esto permite al usuario ingresar nuevos datos para un juego sin interferencias de datos anteriores.
	 */
	private void limpiarPestanaInsertJuego() {
		txtFieldNombreImagen.setEnabled(true);
		txtFieldNombreJuegoInsertar.setEnabled(true);
		btnInsertarJuego.setEnabled(true);
		txtFieldNombreJuegoInsertar.setText("");
		txtFieldAnoJuego.setText("");
		txtFieldPrecioJuego.setText("");
		textAreaDescripcion.setText("");
		txtFieldNombreImagen.setText("");
		txtFieldGenero.setText("");
		txtFieldNombreJuegoBuscar.setText("");
		comboBoxNombreJuego.removeAllItems();
		txtFieldNombreImagen.setText("");
		
	}

	/**
	 * Método privado para insertar un nuevo juego en el sistema.
	 * Este método crea una nueva instancia de Juego, establece sus atributos con los valores ingresados por el usuario
	 * a través de los campos de texto correspondientes, y luego intenta insertar este juego en el sistema
	 * Después de la inserción, se llama al método para limpiar la interfaz de usuario y prepararla para nuevas entradas.
	 * En caso de error, se captura la excepción genérica y se muestra el mensaje de error correspondiente.
	 */
	private void insertarJuego() {
		Juego juego = new Juego();
		juego.setNombre(txtFieldNombreJuegoInsertar.getText());
		juego.setAnio(Integer.valueOf(txtFieldAnoJuego.getText()));
		juego.setPrecio(Float.valueOf(txtFieldPrecioJuego.getText()));
		juego.setDescripcion(textAreaDescripcion.getText());
		juego.setGenero(txtFieldGenero.getText());
		limpiarPestanaInsertJuego();
		
		try {
			cont.insertarJuego(juego);
		} catch (ErrorGeneral e) {
			e.printStackTrace();
			
			e.mostrarExcepcion();
		}
	}

	/**
	 * Método privado para seleccionar un juego existente en el sistema para su modificación.
	 * Este método recupera el nombre del juego seleccionado en el JComboBox, intenta encontrar el juego correspondiente en el sistema
	 * y si la operación es exitosa, habilita ciertos campos de texto y deshabilita el botón de inserción de juegos para permitir la
	 * edición de los detalles del juego seleccionado. En caso de error, se captura la excepción genérica, se imprime el stack trace y se
	 *  muestra el mensaje de error correspondiente.
	 */
	private void elegirJuegoModificar() {
		String nombreJuego = (String) comboBoxNombreJuego.getSelectedItem();
		Juego juego = null;
		Boolean valido = true;
		try {
			juego = cont.elegirJuegoModificar(nombreJuego);
		} catch (ErrorGeneral e) {
			e.printStackTrace();
			valido = false;
			e.mostrarExcepcion();
		}
		if (valido) {
			txtFieldNombreImagen.setEnabled(false);
			txtFieldNombreJuegoInsertar.setText(juego.getNombre());
			txtFieldNombreJuegoInsertar.setEnabled(false);
			btnInsertarJuego.setEnabled(false);
			txtFieldAnoJuego.setText(String.valueOf(juego.getAnio()));
			txtFieldPrecioJuego.setText(String.valueOf(juego.getPrecio()));
			textAreaDescripcion.setText(juego.getDescripcion());
			txtFieldGenero.setText(juego.getGenero());
		}
	}

	/**
	 * Método privado para modificar un juego existente en el sistema.
	 * Este método crea una nueva instancia de Juego, establece sus atributos con los valores ingresados por el usuario
	 * a través de los campos de texto correspondientes, y luego intenta modificar el juego existente en el sistema
	 * Después de la modificación, se limpia la interfaz de usuario y se prepara para nuevas entradas.
	 * En caso de error, se muestra el mensaje de error correspondiente.
	 */
	private void modificarJuego() {
		
		Juego juego = new Juego();
		juego.setNombre(txtFieldNombreJuegoInsertar.getText());
		juego.setAnio(Integer.valueOf(txtFieldAnoJuego.getText()));
		juego.setPrecio(Float.valueOf(txtFieldPrecioJuego.getText()));
		juego.setDescripcion(textAreaDescripcion.getText());
		juego.setGenero(txtFieldGenero.getText());
		limpiarPestanaInsertJuego();
		
		try {
			cont.modificarJuego(juego);
		} catch (ErrorGeneral e) {
			e.mostrarExcepcion();
		}
	}

	/**
	 * Método privado para buscar juegos que coincidan con un criterio de búsqueda y llenar un JComboBox con los resultados.
	 * Este método recupera el nombre del juego ingresado por el usuario a través de un campo de texto, luego obtiene
	 * una lista de nombres de juegos que coinciden con el criterio de búsqueda. Si no hay coincidencias, se muestra un mensaje informando al usuario.
	 * Si hay coincidencias, se agregan los nombres de los juegos al JComboBox para que el usuario pueda seleccionar uno de ellos para modificar.
	 */
	private void buscarJuegosModificar() {
		String nombreJuego = txtFieldNombreJuegoBuscar.getText();
		List<String> nombreJuegos = new ArrayList<>();
		
		comboBoxNombreJuego.removeAllItems();
		nombreJuegos = cont.rellenarComboBoxJuegosModificar(nombreJuego);
		if (nombreJuegos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ninguna coincidencia.");
		} else {
			for (String juego : nombreJuegos) {
				comboBoxNombreJuego.addItem(juego);
			}
		}
		
	}

	/**
	 * Método privado para enviar la cantidad de stock de un juego específico.
	 * Este método recupera el nombre del juego seleccionado en el JComboBox y la cantidad de stock a enviar desde un spinner.
	 * Luego, intenta enviar la cantidad de stock. En caso de error, se capturan las excepciones específicas y se muestran 
	 * los mensajes de error correspondientes. Después de la operación, se limpian los campos de texto y los componentes de la 
	 * interfaz de usuario para prepararlos para nuevas entradas.
	 */
	private void EnviarStock() {
		String nombre = (String) comboBoxJuego.getSelectedItem();
		try {
			cont.enviarStock(nombre, (int) spinnerCantidad.getValue(), (String) comboBoxProveedor.getSelectedItem());
		} catch (ErrorGeneral e) {
			e.mostrarExcepcion();
			e.printStackTrace();
		} catch (ExcepcionStock e) {
			e.mostrarExcepcion();
			e.printStackTrace();
		}
		
		txtFieldBuscarJuego.setText("");
		comboBoxJuego.removeAllItems();
		spinnerCantidad.setValue(1);
		
	}

	/**
	 * Método privado para buscar juegos disponibles en stock y llenar un JComboBox con los resultados.
	 * Este método recupera el término de búsqueda ingresado por el usuario a través de un campo de texto, luego obtiene una lista de 
	 * nombres de juegos que están disponibles en stock. Si no hay coincidencias, se muestra un mensaje informando al usuario. 
	 * Si hay coincidencias, se agregan los nombres de los juegos al JComboBox para que el usuario pueda seleccionar uno de ellos.
	 */
	private void buscarJuegosStock() {
		String buscaJuego = txtFieldBuscarJuego.getText();
		List<String> nombreJuegos = new ArrayList<>();
		
		comboBoxJuego.removeAllItems();
		nombreJuegos = cont.rellenarComboBoxJuegosStock(buscaJuego);
		
		if (nombreJuegos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ninguna coincidencia.");
		} else {
			for (String nombreJuego : nombreJuegos) {
				comboBoxJuego.addItem(nombreJuego);
			}
		}
	}
	
	/**
	 * Método estático para validar si una cadena de texto contiene solo letras o grupos de letras.
	 * Utiliza una expresión regular para comprobar que la cadena solo contiene caracteres alfabéticos.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena solo contiene letras o grupos de letras, falso en caso contrario.
	 */
	public static boolean validarLetras(String letras) {
	    return letras.matches("[A-Za-z]*");
	}

	/**
	 * Método estático para validar si una cadena de texto representa un DNI válido.
	 * Un DNI válido debe tener 8 dígitos seguidos de una letra mayúscula o minúscula.
	 * Utiliza una expresión regular para comprobar este formato.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena representa un DNI válido, falso en caso contrario.
	 */
	public static boolean validarDni(String letras) {
	    return letras.matches("[0-9]{8}[A-Za-z]");
	}

	/**
	 * Método estático para validar si una cadena de texto representa una edad válida.
	 * Una edad válida debe ser un número de 4 dígitos.
	 * Utiliza una expresión regular para comprobar este formato.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena representa una edad válida, falso en caso contrario.
	 */
	public static boolean validarEdad(String letras) {
	    return letras.matches("[0-9]{4}");
	}

	/**
	 * Método estático para validar si una cadena de texto representa una dirección válida.
	 * Una dirección válida debe contener solo letras, números y guiones.
	 * Utiliza una expresión regular para comprobar este formato.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena representa una dirección válida, falso en caso contrario.
	 */
	public static boolean validarLetrasYNumeros(String letras) {
	    return letras.matches("[A-Za-z0-9]+");
	}

	/**
	 * Método estático para validar si una cadena de texto representa un número válido.
	 * Un número válido puede ser un número entero o un número decimal.
	 * Utiliza una expresión regular para comprobar este formato.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena representa un número válido, falso en caso contrario.
	 */
	public static boolean validarNumeros(String letras) {
	    return letras.matches("[0-9]+(\\.[0-9]+)?");
	}

	/**
	 * Método estático para validar si una cadena de texto representa un correo electrónico válido.
	 * Un correo electrónico válido debe seguir un patrón específico que incluye caracteres alfanuméricos, guiones, puntos y el dominio.
	 * Utiliza una expresión regular para comprobar este formato.
	 * @param letras La cadena de texto a validar.
	 * @return Verdadero si la cadena representa un correo electrónico válido, falso en caso contrario.
	 */
	public static boolean validarEmail(String letras) {
	    return letras.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	/**
	 * Valida si el nombre del archivo proporcionado cumple con ciertos criterios.
	 *
	 * Este método verifica si el nombre del archivo ingresado contiene solo letras,
	 * números y guiones bajos, y si termina con una extensión de archivo válida (por ejemplo,.txt,.docx).
	 * La validación se realiza mediante una expresión regular que permite caracteres alfanuméricos
	 * y guiones bajos en el nombre principal del archivo, seguido por un punto y una extensión.
	 *
	 * @param letras El nombre del archivo a validar como una cadena de texto.
	 * @return true si el nombre del archivo es válido según los criterios establecidos,
	 *         false en caso contrario.
	 */
	public static boolean validarNombreArchivo(String letras) {
	    return letras.matches("\\\\w+,\\\\.,\\\\w+");
	}

}
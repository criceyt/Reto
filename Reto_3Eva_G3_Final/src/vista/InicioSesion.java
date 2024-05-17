package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import controlador.Controlador;
import excepciones.ErrorContrasenaLogin;
import excepciones.ErrorGeneral;
import excepciones.LogInException;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

/**
 * Esta clase representa la ventana de inicio de sesión de la aplicación.
 * Permite a los usuarios iniciar sesión en la aplicación o registrarse si aún no tienen una cuenta.
 * La ventana contiene dos pestañas principales:
 * <ul>
 *     <li><b>Inicio de sesión:</b> Permite a los usuarios existentes ingresar a la aplicación utilizando sus credenciales.</li>
 *     <li><b>Registro de usuarios:</b> Permite a los nuevos usuarios registrarse en la aplicación proporcionando la información necesaria.</li>
 * </ul>
 */
public class InicioSesion extends JFrame implements ActionListener {
	/**
	 * Serial Version UID para serializar y deserializar objetos de esta clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel principal que contiene todos los componentes de la interfaz gráfica.
	 */
	private JPanel contentPane;
	/**
	 * Campo de texto para ingresar el nombre de usuario.
	 */
	private JTextField txtUsername;
	/**
	 * Campo de contraseña para ingresar el nombre de usuario.
	 */
	private JPasswordField jpassword;
	/**
	 * Campo de texto para ingresar el nombre del usuario.
	 */
	private JTextField txtNombre;
	/**
	 * Campo de contraseña para el proceso de registro.
	 */
	private JPasswordField jPasswordRegistro;
	/**
	 * Segundo campo de contraseña para verificar la consistencia de la contraseña ingresada.
	 */
	private JPasswordField jPasswordRegistro2;
	/**
	 * Campo de texto para ingresar el apellido del usuario.
	 */
	private JTextField txtApellido;
	/**
	 * Campo de texto para ingresar el DNI del usuario.
	 */
	private JTextField txtDni;
	/**
	 * Campo de texto para ingresar la dirección del usuario.
	 */
	private JTextField txtDireccion;
	/**
	 * Campo de texto para ingresar el correo electrónico del usuario.
	 */
	private JTextField txtEmail;
	/**
	 * Botón para iniciar el proceso de registro.
	 */
	private JButton btnRegistrarse;
	/**
	 * Botón para iniciar sesión.
	 */
	private JButton btnLogIn;
	/**
	 * Campo de texto para ingresar el año de nacimiento del usuario.
	 */
	private JTextField txtAnioNacimiento;
	/**
	 * Controlador asociado a esta vista para manejar eventos y lógica de negocio.
	 */
	private Controlador cont;
	/**
	 * Booleano para indicar si el DNI ingresado ha sido validado correctamente.
	 */
	boolean comprobarDNIBool = false;
	/**
	 * Booleano para indicar si el nombre ingresado ha sido validado correctamente.
	 */
	boolean comprobarNombreBool = false;
	/**
	 * Booleano para indicar si el apellido ingresado ha sido validado correctamente.
	 */
	boolean comprobarApellidoBool = false;
	/**
	 * Booleano para indicar si el año de nacimiento ingresado ha sido validado correctamente.
	 */
	boolean comprobarAnioNacimientoBool = false;
	/**
	 * Booleano para indicar si la dirección ingresada ha sido validada correctamente.
	 */
	boolean comprobarDireccionBool = false;
	/**
	 * Booleano para indicar si el correo electrónico ingresado ha sido validado correctamente.
	 */
	boolean comprobarEmailBool = false;
	/**
	 * Booleano para indicar si las contraseñas ingresadas coinciden.
	 */
	boolean contraseniaCorrecta = false;


	/**
	 * Constructor de la clase que inicializa la ventana de inicio de sesión y registro.
	 * Configura la ventana con un título, icono, y establece su comportamiento al cerrar.
	 * Crea y configura los componentes necesarios para la interfaz gráfica de usuario (GUI), incluyendo
	 * campos de texto para el nombre de usuario y contraseña, botones para iniciar sesión y registrarse,
	 * y paneles para organizar estos elementos.
	 *
	 * @param controlador objeto de la clase controlador para manejar la conexión con la base de datos
	 */
	public InicioSesion(Controlador controlador) {
		this.cont = controlador;

		setTitle("Inicio de Sesión");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 610);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(5, 5, 712, 555);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Iniciar Sesion", null, panel, null);
		panel.setLayout(null);

		JPanel panelRight_1 = new JPanel((LayoutManager) null);
		panelRight_1.setBackground(new Color(7, 41, 120));
		panelRight_1.setBounds(353, 0, 354, 528);
		panel.add(panelRight_1);

		txtUsername = new JTextField();
		txtUsername.setToolTipText("Email");
		txtUsername.setText("Email");
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(7, 41, 120));
		txtUsername.setBounds(85, 156, 218, 27);
		panelRight_1.add(txtUsername);
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUsername.getText().equals("Email")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.WHITE);
				}
			}
		});

		jpassword = new JPasswordField();
		jpassword.setToolTipText("Contraseña");
		jpassword.setText("Password");
		jpassword.setForeground(Color.LIGHT_GRAY);
		jpassword.setBorder(null);
		jpassword.setBackground(new Color(7, 41, 120));
		jpassword.setBounds(85, 216, 218, 27);
		panelRight_1.add(jpassword);
		jpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String passwordText = new String(jpassword.getPassword());
				if (passwordText.equals("Password")) {
					jpassword.setText("");
					jpassword.setForeground(Color.WHITE);
				}
			}
		});

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(85, 185, 224, 2);
		panelRight_1.add(separator_2);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(85, 248, 218, 2);
		panelRight_1.add(separator_1_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\.\\img\\candado4.png"));
		lblNewLabel_2.setBounds(41, 202, 51, 48);
		panelRight_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(".\\.\\img\\user.png"));
		lblNewLabel_1_1.setBounds(41, 149, 60, 48);
		panelRight_1.add(lblNewLabel_1_1);

		btnLogIn = new JButton("LOG IN");
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnLogIn.setBackground(new Color(7, 41, 120));
		btnLogIn.setBounds(123, 291, 146, 27);
		btnLogIn.addActionListener(this);
		panelRight_1.add(btnLogIn);

		JPanel panelLeft_1 = new JPanel();
		panelLeft_1.setBounds(0, 0, 391, 528);
		panel.add(panelLeft_1);
		panelLeft_1.setLayout(null);
		panelLeft_1.setPreferredSize(new Dimension(381, 0));
		panelLeft_1.setBackground(new Color(64, 130, 253));

		JLabel lblNewLabel_3_1 = new JLabel("", SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
		lblNewLabel_3_1.setBounds(66, 151, 244, 220);
		panelLeft_1.add(lblNewLabel_3_1);

		// --------------------------------- Aqui Empieza El Panel de Registro
		// -----------------------------------------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		tabbedPane.addTab("Registrarse", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, -16, 336, 557);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(64, 130, 253));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
		lblLogo.setBounds(12, 127, 300, 250);
		panel_2.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(317, -16, 437, 557);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(7, 41, 120));

		txtNombre = new JTextField();
		txtNombre.setToolTipText("Nombre");
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.LIGHT_GRAY);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setBorder(null);
		txtNombre.setBackground(new Color(7, 41, 120));
		txtNombre.setBounds(63, 43, 300, 27);
		panel_1_1.add(txtNombre);
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtNombre.getText().equals("Nombre")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.WHITE);
				}
			}
		});

		jPasswordRegistro = new JPasswordField();
		jPasswordRegistro.setToolTipText("Contraseña");
		jPasswordRegistro.setText("Password");
		jPasswordRegistro.setForeground(Color.LIGHT_GRAY);
		jPasswordRegistro.setBorder(null);
		jPasswordRegistro.setBackground(new Color(7, 41, 120));
		jPasswordRegistro.setBounds(63, 331, 300, 27);
		panel_1_1.add(jPasswordRegistro);
		jPasswordRegistro.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				String passwordText1 = new String(jPasswordRegistro.getPassword());
				if (passwordText1.equals("Password")) {
					jPasswordRegistro.setText("");
					jPasswordRegistro.setForeground(Color.WHITE);
				}
			}
		});

		jPasswordRegistro2 = new JPasswordField();
		jPasswordRegistro2.setToolTipText("Confirmar contraseña");
		jPasswordRegistro2.setText("PasswordField");
		jPasswordRegistro2.setForeground(Color.LIGHT_GRAY);
		jPasswordRegistro2.setBorder(null);
		jPasswordRegistro2.setBackground(new Color(7, 41, 120));
		jPasswordRegistro2.setBounds(63, 369, 300, 27);
		panel_1_1.add(jPasswordRegistro2);
		jPasswordRegistro2.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				String passwordText2 = new String(jPasswordRegistro2.getPassword());
				if (passwordText2.equals("PasswordField")) {
					jPasswordRegistro2.setText("");
					jPasswordRegistro2.setForeground(Color.WHITE);
				}
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(63, 70, 300, 2);
		panel_1_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(63, 113, 300, 2);
		panel_1_1.add(separator_1);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(63, 157, 300, 2);
		panel_1_1.add(separator_2_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(63, 258, 300, 2);
		panel_1_1.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(63, 308, 300, 2);
		panel_1_1.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(63, 358, 300, 2);
		panel_1_1.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(63, 408, 300, 2);
		panel_1_1.add(separator_6);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnRegistrarse.setBackground(new Color(7, 41, 120));
		btnRegistrarse.setBounds(142, 497, 150, 27);
		btnRegistrarse.addActionListener(this);
		panel_1_1.add(btnRegistrarse);

		txtApellido = new JTextField();
		txtApellido.setToolTipText("Apellido");
		txtApellido.setText("Apellido");
		txtApellido.setForeground(Color.LIGHT_GRAY);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtApellido.setBorder(null);
		txtApellido.setBackground(new Color(7, 41, 120));
		txtApellido.setBounds(63, 93, 300, 19);
		panel_1_1.add(txtApellido);
		txtApellido.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los letras
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtApellido.getText().equals("Apellido")) {
					txtApellido.setText("");
					txtApellido.setForeground(Color.WHITE);
				}
			}
		});

		txtDni = new JTextField();
		txtDni.setToolTipText("DNI");
		txtDni.setText("DNI");
		txtDni.setForeground(Color.LIGHT_GRAY);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDni.setBorder(null);
		txtDni.setBackground(new Color(7, 41, 120));
		txtDni.setBounds(63, 132, 300, 19);
		panel_1_1.add(txtDni);
		txtDni.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtDni.getText().equals("DNI")) {
					txtDni.setText("");
					txtDni.setForeground(Color.WHITE);
				}
			}
		});

		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("Direccion");
		txtDireccion.setText("Direccion");
		txtDireccion.setForeground(Color.LIGHT_GRAY);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDireccion.setBorder(null);
		txtDireccion.setBackground(new Color(7, 41, 120));
		txtDireccion.setBounds(63, 233, 300, 19);
		panel_1_1.add(txtDireccion);
		txtDireccion.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtDireccion.getText().equals("Direccion")) {
					txtDireccion.setText("");
					txtDireccion.setForeground(Color.WHITE);
				}
			}
		});

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.LIGHT_GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(7, 41, 120));
		txtEmail.setBounds(63, 282, 300, 19);
		txtEmail.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtEmail.getText().equals("Email")) {
					txtEmail.setText("");
					txtEmail.setForeground(Color.WHITE);
				}
			}
		});
		panel_1_1.add(txtEmail);

		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(63, 207, 300, 2);
		panel_1_1.add(separator_2_1_1);

		txtAnioNacimiento = new JTextField();
		txtAnioNacimiento.setToolTipText("Año de nacimiento");
		txtAnioNacimiento.setText("Año de nacimiento");
		txtAnioNacimiento.setForeground(Color.LIGHT_GRAY);
		txtAnioNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAnioNacimiento.setBorder(null);
		txtAnioNacimiento.setBackground(new Color(7, 41, 120));
		txtAnioNacimiento.setBounds(63, 182, 300, 19);
		txtAnioNacimiento.addMouseListener(new MouseAdapter() {

			// Metodo para que cuendo clickas el campo desaparece los puntos
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtAnioNacimiento.getText().equals("Año de nacimiento")) {
					txtAnioNacimiento.setText("");
					txtAnioNacimiento.setForeground(Color.WHITE);
				}
			}
		});
		panel_1_1.add(txtAnioNacimiento);

	}

	/**
	 * Maneja el evento de acción (como un clic de botón) en la interfaz gráfica de usuario.
	 * Dependiendo del origen del evento, ejecuta diferentes acciones:
	 * - Si el origen es btnLogIn, llama al método logInUsuario() para procesar el inicio de sesión del usuario.
	 * - Si el origen es btnRegistrarse, llama al método comprobarRegistroUsuario() para validar el registro del usuario.
	 * Este método es crucial para la interacción entre el usuario y la aplicación, permitiendo la autenticación y el registro de usuarios.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogIn)) {
			if (txtUsername.getText().isEmpty() || !validarEmail(txtUsername.getText().trim())
					|| txtUsername.getText().equalsIgnoreCase("Email")) {
				txtUsername.setForeground(Color.RED);
				ErrorContrasenaLogin.ErrorDeTrabajadorDatos();
			}else {
				txtUsername.setForeground(Color.WHITE);
				logInUsuario();
			}
		}
		if (e.getSource().equals(btnRegistrarse)) {
			comprobarRegistroUsuario();

		}
	}

	/**
	 * Método privado que valida los datos ingresados por el usuario durante el proceso de registro.
	 * Realiza una serie de comprobaciones para asegurar que los datos ingresados son válidos y cumplen con los requisitos de la aplicación.
	 * Las comprobaciones incluyen la validez del DNI, el nombre, apellido, dirección, correo electrónico y el año de nacimiento.
	 * Además, verifica que las contraseñas ingresadas sean iguales y tengan al menos 8 caracteres.
	 * Si todos los datos son válidos, procede con el registro del usuario; de lo contrario, muestra mensajes de error correspondientes.
	 */
	private void comprobarRegistroUsuario() {
		// LO QUE VIENE A CONTINUACION ES UNA CADENA DE CONDICIENES QUE VALIDAN SI LO
		// QUE
		// ESTA DENTRO DE LOS TEXTFIELD TIENE SENTIDO

		// Mirar si el DNI esta bien introducido
		if (txtDni.getText().isEmpty() || !validarDni(txtDni.getText().trim())) {
			txtDni.setForeground(Color.RED);
			comprobarDNIBool = false;
		} else {
			txtDni.setForeground(Color.WHITE);
			comprobarDNIBool = true;
		}

		// Mirar si el Nombre esta bien introducido
		if (txtNombre.getText().isEmpty() || !validarLetras(txtNombre.getText().replace(" ", "").trim())
				|| txtNombre.getText().equalsIgnoreCase("Nombre")) {
			txtNombre.setForeground(Color.RED);
			comprobarNombreBool = false;
		} else {
			txtNombre.setForeground(Color.WHITE);
			comprobarNombreBool = true;
		}

		// Mirar si el Apellido esta bien introducido
		if (txtApellido.getText().isEmpty() || !validarLetras(txtApellido.getText().trim())
				|| txtApellido.getText().equalsIgnoreCase("Apellido")) {
			txtApellido.setForeground(Color.RED);
			comprobarApellidoBool = false;
		} else {
			txtApellido.setForeground(Color.WHITE);
			comprobarApellidoBool = true;
		}

		// Mirar que en direccion solo se ahyan introducido letras y numeros
		if (txtDireccion.getText().isEmpty() || !validarDireccion(txtDireccion.getText().replace(" ", "").trim())
				|| txtDireccion.getText().equalsIgnoreCase("Direccion")) {
			txtDireccion.setForeground(Color.RED);
			comprobarDireccionBool = false;
		} else {
			txtDireccion.setForeground(Color.WHITE);
			comprobarDireccionBool = true;
		}

		if (txtEmail.getText().isEmpty() || !validarEmail(txtEmail.getText().trim())) {
			txtEmail.setForeground(Color.RED);
			comprobarEmailBool = false;
		} else {
			txtEmail.setForeground(Color.WHITE);
			comprobarEmailBool = true;
		}

		// Verificar si el campo de año de nacimiento está vacío o no contiene 4 números
		if (txtAnioNacimiento.getText().isEmpty() || !validarEdad(txtAnioNacimiento.getText().trim())) {
		    txtAnioNacimiento.setForeground(Color.RED);
		    comprobarAnioNacimientoBool = false;
		} else {
		    // Parsear el año de nacimiento solo si la validación previa pasa
		    int edadTrabajador = Integer.parseInt(txtAnioNacimiento.getText());
		    int anioActual = LocalDate.now().getYear();
		    
		    // Verificar si el año de nacimiento es menor que el año actual
		    if (anioActual < edadTrabajador) {
		        txtAnioNacimiento.setForeground(Color.RED);
		        comprobarAnioNacimientoBool = false;
		    } else {
		        txtAnioNacimiento.setForeground(Color.WHITE);
		        comprobarAnioNacimientoBool = true;
		    }
		}

		if (!comprobarDNIBool | !comprobarNombreBool | !comprobarApellidoBool | !comprobarAnioNacimientoBool | !comprobarDireccionBool | !comprobarEmailBool) {
			ErrorContrasenaLogin.ErrorDeTrabajadorDatos();
		} else {
			// Controlador de que las contraseñas sean mayores a 8 digitos y sean iguales
			char[] pass1 = jPasswordRegistro.getPassword();
			char[] pass2 = jPasswordRegistro2.getPassword();

			String passString1 = new String(pass1);
			String passString2 = new String(pass2);

			if (passString1.equals(passString2)) {
				if (passString1.length() < 8) {
					int option = JOptionPane.showOptionDialog(null,
							"La contraseña tiene menos de 8 caracteres\n¿Deseas seguir?", "Alerta",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,

							null, new String[] { "Cambiar contraseña", "Seguir adelante" }, "Cambiar contraseña");

					if (option == JOptionPane.YES_OPTION) {

					} else {
						// Mensaje de Registro con exito
						registroUsuario();
					}
				} else {
					// Mensaje de Registro con exito
					registroUsuario();
				}

			} else {
				// Llamamos a la clase errorContraseñaLogin
				ErrorContrasenaLogin.errorContrasenia();
			}

		}
		
	}

	/**
	 * Método privado que registra un nuevo usuario en el sistema.
	 * Crea una nueva instancia de la clase Persona y la inicializa con los datos ingresados por el usuario.
	 * Estos datos incluyen nombre, apellido, DNI, edad, dirección, correo electrónico y contraseña.
	 * Intenta registrar la nueva persona. Si el registro es exitoso, muestra un mensaje de bienvenida al sistema.
	 * Si ocurre un error, muestra el mensaje de excepción correspondiente.
	 * Finalmente, limpia los campos de texto para prepararlos para el próximo registro.
	 */
	private void registroUsuario() {
		boolean valido = true;
		Persona persona;

		persona = new Cliente();
		persona.setNombre(txtNombre.getText());
		persona.setApellido(txtApellido.getText());
		persona.setDni(txtDni.getText());
		persona.setEdad(Integer.parseInt(txtAnioNacimiento.getText()));
		persona.setDireccion(txtDireccion.getText());
		persona.setEmail(txtEmail.getText());
		persona.setContrasena(String.valueOf(jPasswordRegistro2.getPassword()));
		try {
			cont.registroUsuario(persona);
		} catch (ErrorGeneral e) {
			e.mostrarExcepcion();
			valido = false;
		} catch (LogInException e) {
			e.errorCorreoDuplicado();
			valido = false;
		}
		if (valido) {
			ErrorContrasenaLogin.bienvenidoAlSistema();
		}
		txtNombre.setText("Nombre");
		txtApellido.setText("Apellido");
		txtDni.setText("DNI");
		txtAnioNacimiento.setText("Año de nacimiento");
		txtDireccion.setText("Direccion");
		txtEmail.setText("Email");
		jPasswordRegistro.setText("Password");
		jPasswordRegistro2.setText("PasswordField");
	}

	/**
	 * Método privado que intenta iniciar sesión de un usuario en el sistema.
	 * Recupera el correo electrónico y la contraseña ingresados por el usuario desde los campos de texto correspondientes.
	 * Intenta autenticar al usuario. Si la autenticación es exitosa, redirige al usuario a la interfaz correspondiente basada en su tipo de usuario (Trabajador o Cliente).
	 * Si ocurre un error durante la autenticación, muestra el mensaje de excepción correspondiente.
	 * Este método es crucial para la seguridad y la navegación dentro de la aplicación, asegurando que solo los usuarios autorizados puedan acceder a sus áreas específicas.
	 */
	private void logInUsuario() {

		String email;
		String contrasena;
		boolean valido = true;
		Persona persona = null;

		email = txtUsername.getText();
		contrasena = String.valueOf(jpassword.getPassword());

		try {
			persona = cont.inicioSesion(email, contrasena);
		} catch (ErrorGeneral e) {
			valido = false;
			e.mostrarExcepcion();
		} catch (LogInException e) {
			valido = false;
			e.mostrarExcepcion();
		}
		if(valido) {
			txtUsername.setText("Email");
			jpassword.setText("");
			// Si es valido que te lleve a la tienda
			if (persona instanceof Trabajador) {
				if (((Trabajador) persona).isIs_admin()) {
					this.setVisible(false);
					VentanaAdmin ventanaNueva = new VentanaAdmin(cont, this, true);
					ventanaNueva.setVisible(true);
					this.setVisible(true);
				} else {
					dispose();
					VentanaTrabajador ventanaNueva2 = new VentanaTrabajador(cont, this, true);
					ventanaNueva2.setVisible(true);
				}
			} else if (persona instanceof Cliente) {
				VBiblioteca ventana = new VBiblioteca(persona);
				
				ventana.setVisible(true);
			
			}
		}
	}

	/**
	 * Comprueba que la cadena de entrada esté compuesta únicamente por letras (mayúsculas o minúsculas).
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si todas las letras son válidas, falso en caso contrario.
	 */
	public static boolean validarLetras(String letras) {
	    return letras.matches("[A-Za-z]*");
	}

	/**
	 * Verifica que la cadena de entrada tenga exactamente 8 dígitos seguidos de una letra (mayúscula o minúscula),
	 * típicamente utilizado para validar DNIs.
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si el formato es válido, falso en caso contrario.
	 */
	public static boolean validarDni(String letras) {
	    return letras.matches("[0-9]{8}[A-Za-z]");
	}

	/**
	 * Comprueba que la cadena de entrada sea un número de cuatro dígitos, comúnmente usado para validar edades.
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si el formato es válido, falso en caso contrario.
	 */
	public static boolean validarEdad(String letras) {
	    return letras.matches("[0-9]{4}");
	}

	/**
	 * Verifica que la cadena de entrada contenga solo números y letras, excluyendo espacios y otros caracteres especiales.
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si el formato es válido, falso en caso contrario.
	 */
	public static boolean validarDireccion(String letras) {
	    return letras.matches("[A-Za-z0-9]+");
	}

	/**
	 * Comprueba que la cadena de entrada sea un número entero opcionalmente precedido por un signo negativo, y opcionalmente
	 * seguido de un punto decimal y más dígitos decimales.
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si el formato es válido, falso en caso contrario.
	 */
	public static boolean validarNumeros(String letras) {
	    return letras.matches("-?\\d+(\\.\\d+)?");
	}

	/**
	 * Verifica que la cadena de entrada siga el patrón de un correo electrónico, incluyendo dominios y extensiones.
	 * 
	 * @param letras Cadena de caracteres a validar.
	 * @return Verdadero si el formato es válido, falso en caso contrario.
	 */
	public static boolean validarEmail(String letras) {
	    return letras.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
	            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

}

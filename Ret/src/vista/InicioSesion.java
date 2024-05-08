package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import controlador.Controlador;
import excepciones.ErrorContraseñaLogin;
import excepciones.ErrorGeneral;
import excepciones.LogInException;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class InicioSesion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField jpassword;
	private JTextField txtNombre;
	private JPasswordField jPasswordRegistro;
	private JPasswordField jPasswordRegistro2;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JButton btnRegistrarse;
	private JCheckBox hacersePremium;
	private JButton btnLogIn;
	private JTextField txtAnioNacimiento;
	private Controlador cont;

	public InicioSesion(Controlador controlador) {
		this.cont=controlador;

		setTitle("Ventana Inicio");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\1dam\\Downloads\\RetoJuntado\\img\\logo_G3_Sin_Texto.PNG"));
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
		panelRight_1.setBounds(353, 0, 354, 492);
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
		panelLeft_1.setBounds(0, 0, 391, 492);
		panel.add(panelLeft_1);
		panelLeft_1.setLayout(null);
		panelLeft_1.setPreferredSize(new Dimension(381, 0));
		panelLeft_1.setBackground(new Color(64, 130, 253));

		JLabel lblNewLabel_3_1 = new JLabel("", SwingConstants.CENTER);
		lblNewLabel_3_1.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
		lblNewLabel_3_1.setBounds(46, 111, 244, 220);
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

		hacersePremium = new JCheckBox("");
		hacersePremium.setOpaque(false);
		hacersePremium.setForeground(Color.BLUE);
		hacersePremium.setBounds(263, 443, 29, 27);
		panel_1_1.add(hacersePremium);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnRegistrarse.setBackground(new Color(7, 41, 120));
		btnRegistrarse.setBounds(142, 497, 150, 27);
		btnRegistrarse.addActionListener(this);
		panel_1_1.add(btnRegistrarse);

		JLabel lblNewLabel = new JLabel("Hacerse Premium (19,99$)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(74, 443, 150, 27);
		panel_1_1.add(lblNewLabel);

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

	// Este Boton Es el Boton Para Poder Iniciar Sesion (Registrandote o No)
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogIn)) {
			logInUsuario();
		}
		if (e.getSource().equals(btnRegistrarse)) {
			registroUsuario();
		}
	}

	private void registroUsuario() {

		Persona persona;

		String contrasena;
		contrasena = String.valueOf(jPasswordRegistro.getPassword());
		String contrasena2;
		contrasena2 = String.valueOf(jPasswordRegistro2.getPassword());

		if (contrasena.equals(contrasena2)) {
			persona = new Cliente();
			persona.setNombre(txtNombre.getText());
			persona.setApellido(txtApellido.getText());
			persona.setDni(txtDni.getText());
			persona.setEdad(Integer.parseInt(txtAnioNacimiento.getText()));
			persona.setDireccion(txtDireccion.getText());
			persona.setEmail(txtEmail.getText());
			persona.setContrasena(String.valueOf(jPasswordRegistro2.getPassword()));
			((Cliente) persona).setIs_premium(hacersePremium.isSelected());

			ErrorContraseñaLogin.errorDeDatos();

			try {
				cont.registroUsuario(persona, hacersePremium);
			} catch (ErrorGeneral e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LogInException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Esta condicion analiza si esta chekeado premium o no
			if (!hacersePremium.isSelected()) {
				JOptionPane.showMessageDialog(null, "Tu Registro ha sido completado con exito", "BIENVENIDO",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				VentanaDatosBancarios ventanaNueva = new VentanaDatosBancarios();
				ventanaNueva.setVisible(true);
			}

		} else {
			// Llamamos a la clase errorContraseñaLogin
			ErrorContraseñaLogin.errorContrasenia();

		}

	}

	// Llamada a la Base de datos para verificar que el correo y la contraseña
	// existen y coinciden
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

		// Si es valido que te lleve a la tienda
		if (persona instanceof Trabajador) {
			if (((Trabajador) persona).isIs_admin()) {
				this.setVisible(false);
				VentanaAdmin ventanaNueva = new VentanaAdmin(cont, this, true);
				ventanaNueva.setVisible(true);
				this.setVisible(true);
			} else {
				dispose();
//				VentanaAdmin ventanaNueva = new VentanaAdmin();
//				setVisible(true);
			}
		} else if (persona instanceof Cliente) {
		//	VBiblioteca ventana = new VBiblioteca();
		//	ventana.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "Usuario o Pass Incorrecta");
		}
	}
}

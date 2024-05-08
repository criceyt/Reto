package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import controlador.Controlador;
import excepciones.ErrorContraseñaLogin;
import excepciones.ErrorGeneral;
import excepciones.LogInException;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class VentanaAdmin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tFEmailComp;
	private JTextField tFDni;
	private JTextField tFNombre;
	private JTextField tFApellido;
	private JTextField tFEdad;
	private JTextField tFEmail;
	private JTextField tFDireccion;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtSueldo;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField tFConfContrasena;
	private JTextField tFContrasena;
	private JPasswordField passwordField;
	private Controlador cont;
	private JLabel lblDni3;
	private JLabel lblNombre_1;
	private JLabel lblApellido_2;
	private JLabel lblEdad_1;
	private JLabel lblDireccion3;
	private JLabel lblSueldo3;
	private JLabel lblEmail_1_1;
	private JLabel lblContrasenia;
	private JCheckBox chckbxUserPremium;

	private boolean bienEsta = true;
	private boolean bienEsta2 = true;
	private boolean bienEsta3 = true;
	private boolean bienEsta4 = true;
	private boolean bienEsta5 = true;
	private boolean bienEsta6 = true;
	private boolean bienEsta7 = true;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VentanaAdmin dialog = new VentanaAdmin();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * 
	 * @param cont
	 * @param b
	 * @param inicioSesion
	 */
	public VentanaAdmin(Controlador cont, InicioSesion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		this.cont = cont;

		// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ventana Admin");
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

			private void comprobar() {
				// TODO Auto-generated method stub
				String email = tFEmailComp.getText();
				Cliente cliente = null;
				Persona per = null;
				try {
					cliente = cont.ObtenerClientePorEmail(email);
					per = cont.ObtenerPersonaPorEmail(email);
				} catch (ErrorGeneral e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LogInException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(cliente != null) {
				tFDni.setText(cliente.getDni());
				tFNombre.setText(per.getNombre());
				tFApellido.setText(per.getApellido());
				tFEdad.setText(String.valueOf(per.getEdad()));
				tFEmail.setText(per.getEmail());
				tFDireccion.setText(per.getDireccion());
				tFContrasena.setText(per.getContrasena());
				tFConfContrasena.setText(per.getContrasena());
				chckbxUserPremium.setSelected(cliente.isIs_premium());
				}else {
					JOptionPane.showMessageDialog(lblEmail, "El email introducido no se ha encontrado");
				}

			}
		});
		btnComprobar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnComprobar.setBackground(new Color(255, 102, 102));
		btnComprobar.setBounds(433, 17, 133, 28);
		panel.add(btnComprobar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}

			private void guardar() {
				// TODO Auto-generated method stub
				Cliente cliente = new Cliente();
				cliente.setDni(tFDni.getText());
				cliente.setNombre(tFNombre.getText());
				cliente.setApellido(tFApellido.getText());
				cliente.setEdad(Integer.parseInt(tFEdad.getText()));
				cliente.setEmail(tFEmail.getText());
				cliente.setDireccion(tFDireccion.getText());
				cliente.setContrasena(tFContrasena.getText());
				cliente.setContrasena(tFConfContrasena.getText()); 
				cliente.setIs_premium(chckbxUserPremium.isSelected());
				try {
					cont.guardar(cliente, chckbxUserPremium);
				} catch (ErrorGeneral e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LogInException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnGuardar, "Cliente guardado con exito");
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

			private void darBaja() {
				// TODO Auto-generated method stub
				
				int opc = JOptionPane.showOptionDialog(null, "Estas seguro que desear dar de baja el cliente?", "Alert", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] {"Dar de baja", "Cancelar"}, "Dar de baja" );
				if(opc == JOptionPane.YES_OPTION) {
					try {
						cont.darBaja(tFDni.getText());
					} catch (ErrorGeneral e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LogInException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					borrarDatos();
				}else {					
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

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(UIManager.getColor("Button.background"));
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombre.setBounds(45, 123, 97, 35);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(UIManager.getColor("Button.background"));
		lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido.setBounds(45, 168, 97, 35);
		panel.add(lblApellido);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(UIManager.getColor("Button.background"));
		lblEdad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEdad.setBounds(45, 213, 97, 35);
		panel.add(lblEdad);

		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setForeground(UIManager.getColor("Button.background"));
		lblEmail_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1.setBounds(373, 73, 97, 35);
		panel.add(lblEmail_1);

		JLabel lblApellido_1 = new JLabel("Dirección:");
		lblApellido_1.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1.setBounds(373, 123, 97, 35);
		panel.add(lblApellido_1);

		chckbxUserPremium = new JCheckBox("Usuario premium");
		chckbxUserPremium.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chckbxUserPremium.setForeground(new Color(240, 240, 240));
		chckbxUserPremium.setBackground(new Color(0, 0, 160));
		chckbxUserPremium.setBounds(539, 259, 165, 21);
		panel.add(chckbxUserPremium);

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

		JLabel lblApellido_1_2 = new JLabel("Confirma");
		lblApellido_1_2.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1_2.setBounds(373, 201, 97, 35);
		panel.add(lblApellido_1_2);

		JLabel lblEmail_1_2 = new JLabel("Contraseña:");
		lblEmail_1_2.setForeground(UIManager.getColor("Button.background"));
		lblEmail_1_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1_2.setBounds(373, 168, 97, 35);
		panel.add(lblEmail_1_2);

		tFContrasena = new JTextField();
		tFContrasena.setColumns(10);
		tFContrasena.setBounds(480, 178, 224, 25);
		panel.add(tFContrasena);

		JLabel lblApellido_1_2_1 = new JLabel("contraseña:");
		lblApellido_1_2_1.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1_2_1.setBounds(373, 216, 97, 35);
		panel.add(lblApellido_1_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR JUEGO", null, panel_2, null);

		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(242, 194, 89, 28);
		panel_2.add(lblNewLabel_2);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(242, 222, 318, 99);
		panel_2.add(textArea);

		JLabel lblNewLabel_2_1 = new JLabel("Nombre: ");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(351, 61, 89, 28);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Año:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(351, 100, 89, 28);
		panel_2.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Precio:");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(351, 139, 89, 28);
		panel_2.add(lblNewLabel_2_3);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(425, 67, 152, 20);
		panel_2.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(425, 106, 152, 20);
		panel_2.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(425, 145, 152, 20);
		panel_2.add(textField_16);

		JButton enviarButton_1_1 = new JButton("Limpiar");
		enviarButton_1_1.setBackground(new Color(255, 102, 102));
		enviarButton_1_1.setBounds(603, 223, 154, 35);
		panel_2.add(enviarButton_1_1);

		JButton enviarButton_2 = new JButton("Insertar Juego");
		enviarButton_2.setBackground(new Color(255, 102, 102));
		enviarButton_2.setBounds(603, 284, 154, 35);
		panel_2.add(enviarButton_2);

		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(85, 70, 118, 97);
		panel_2.add(lblImagen);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 160));

		tabbedPane.addTab("STOCK", null, panel_1, null);
		panel_1.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setBounds(331, 142, 122, 27);
		panel_1.add(spinner);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(234, 63, 319, 27);
		panel_1.add(comboBox_1);

		JLabel lblNewLabel = new JLabel("Nombre del juego:");
		lblNewLabel.setForeground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(234, 29, 319, 35);
		panel_1.add(lblNewLabel);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(new Color(240, 240, 240));
		lblCantidad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCantidad.setBounds(234, 111, 319, 35);
		panel_1.add(lblCantidad);

		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setForeground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(234, 180, 319, 35);
		panel_1.add(lblNewLabel_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(234, 214, 319, 27);
		panel_1.add(comboBox_1_1);

		JButton enviarButton = new JButton("Enviar");
		enviarButton.setFont(new Font("Arial", Font.PLAIN, 20));
		enviarButton.setBackground(new Color(255, 102, 102));
		enviarButton.setBounds(399, 278, 154, 35);
		panel_1.add(enviarButton);

		JButton enviarButton_1 = new JButton("Limpiar");
		enviarButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		enviarButton_1.setBackground(new Color(255, 102, 102));
		enviarButton_1.setBounds(234, 278, 154, 35);
		panel_1.add(enviarButton_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR TRABAJADORES", null, panel_3, null);
		panel_3.setLayout(null);

		lblDni3 = new JLabel("DNI:");
		lblDni3.setForeground(UIManager.getColor("Button.background"));
		lblDni3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDni3.setBounds(60, 72, 115, 35);
		panel_3.add(lblDni3);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(128, 79, 224, 25);
		panel_3.add(txtDni);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(128, 129, 224, 25);
		panel_3.add(txtNombre);

		lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setForeground(UIManager.getColor("Button.background"));
		lblNombre_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombre_1.setBounds(48, 122, 97, 35);
		panel_3.add(lblNombre_1);

		lblApellido_2 = new JLabel("Apellido:");
		lblApellido_2.setForeground(UIManager.getColor("Button.background"));
		lblApellido_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_2.setBounds(48, 167, 97, 35);
		panel_3.add(lblApellido_2);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(128, 174, 224, 25);
		panel_3.add(txtApellido);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(128, 219, 224, 25);
		panel_3.add(txtEdad);

		lblEdad_1 = new JLabel("F.Nacimiento:");
		lblEdad_1.setForeground(UIManager.getColor("Button.background"));
		lblEdad_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEdad_1.setBounds(10, 212, 117, 35);
		panel_3.add(lblEdad_1);

		lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setForeground(UIManager.getColor("Button.background"));
		lblEmail_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1_1.setBounds(376, 72, 97, 35);
		panel_3.add(lblEmail_1_1);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(483, 82, 224, 25);
		panel_3.add(txtEmail);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(483, 132, 224, 25);
		panel_3.add(txtDireccion);

		lblDireccion3 = new JLabel("Dirección:");
		lblDireccion3.setForeground(UIManager.getColor("Button.background"));
		lblDireccion3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDireccion3.setBounds(376, 122, 97, 35);
		panel_3.add(lblDireccion3);

		lblSueldo3 = new JLabel("Sueldo:");
		lblSueldo3.setForeground(UIManager.getColor("Button.background"));
		lblSueldo3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblSueldo3.setBounds(376, 167, 97, 35);
		panel_3.add(lblSueldo3);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(483, 177, 224, 25);
		panel_3.add(txtSueldo);

		JButton btnInsertarTrabajador = new JButton("Insertar trabajador");
		btnInsertarTrabajador.addActionListener(this);
		btnInsertarTrabajador.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertarTrabajador.setBackground(new Color(255, 102, 102));
		btnInsertarTrabajador.setBounds(565, 301, 211, 35);
		panel_3.add(btnInsertarTrabajador);

		JButton btnBorrarDatos_1 = new JButton("Borrar datos");
		btnBorrarDatos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();
			}

			private void borrarCampos() {
				// METODOS PARA BORRAR LOS CAMPOS

				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtEdad.setText("");
				txtEmail.setText("");
				txtDireccion.setText("");
				txtSueldo.setText("");

			}
		});
		btnBorrarDatos_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBorrarDatos_1.setBackground(new Color(255, 102, 102));
		btnBorrarDatos_1.setBounds(401, 301, 154, 35);
		panel_3.add(btnBorrarDatos_1);

		lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setForeground(UIManager.getColor("Button.background"));
		lblContrasenia.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblContrasenia.setBounds(376, 212, 107, 35);
		panel_3.add(lblContrasenia);

		passwordField = new JPasswordField();
		passwordField.setBounds(483, 219, 224, 25);
		panel_3.add(passwordField);
	}
	private void borrarDatos() {
		// TODO Auto-generated method stub
		tFEmailComp.setText("");
		tFDni.setText("");
		tFNombre.setText("");
		tFApellido.setText("");
		tFEdad.setText("");
		tFEmail.setText("");
		tFDireccion.setText("");
		tFContrasena.setText("");
		tFConfContrasena.setText("");
		chckbxUserPremium.setSelected(false);

	}			
	@Override
	public void actionPerformed(ActionEvent e) {

		// LO QUE VIENE ACONTINUACION ES UNA CADENA DE CONDICIENES QUE VALIDAN SI LO QUE
		// ESTA DENTRO DE LOS TEXTFIELD TIENE SENTIDO

		// Mirar si el DNI esta bien introducido
		if (txtDni.getText().isEmpty() || !validarDni(txtDni.getText().trim())) {
			lblDni3.setForeground(Color.RED);
			bienEsta = false;
		} else {
			lblDni3.setForeground(Color.WHITE);
			bienEsta = true;
		}

		// Mirar si el Nombre esta bien introducido
		if (txtNombre.getText().isEmpty() || !validarLetras(txtNombre.getText().replace(" ", "").trim())) {
			lblNombre_1.setForeground(Color.RED);
			bienEsta2 = false;
		} else {
			lblNombre_1.setForeground(Color.WHITE);
			bienEsta2 = true;
		}

		// Mirar si el Apellido esta bien introducido
		if (txtApellido.getText().isEmpty() || !validarLetras(txtApellido.getText().trim())) {
			lblApellido_2.setForeground(Color.RED);
			bienEsta3 = false;
		} else {
			lblApellido_2.setForeground(Color.WHITE);
			bienEsta3 = true;
		}

		// Mirar si el año de nacimiento es menor al de este año y ademas tiene 4
		// numeros
		if (txtEdad.getText().isEmpty()) {
			lblEdad_1.setForeground(Color.RED);
			bienEsta4 = false;
		} else {
			lblEdad_1.setForeground(Color.WHITE);
			bienEsta4 = true;
		}
//		int anioActual = LocalDate.now().getYear();
//		int edadTrabajador = Integer.parseInt(txtEdad.getText());
//		if (txtEdad.getText().isEmpty() || !validarEdad(txtEdad.getText().trim()) || anioActual < edadTrabajador) {
//			lblEdad_1.setForeground(Color.RED);
//			bienEsta4 = false;
//		} else {
//			lblEdad_1.setForeground(Color.WHITE);
//			bienEsta4 = true;
//		}
		// Mirar que en direccion solo se ahyan introducido letras y numeros
		if (txtDireccion.getText().isEmpty() || !validarDireccion(txtDireccion.getText().replace(" ", "").trim())) {
			lblDireccion3.setForeground(Color.RED);
			bienEsta5 = false;
		} else {
			lblDireccion3.setForeground(Color.WHITE);
			bienEsta5 = true;
		}

		// Mirar que en direccion solo se ahyan introducido letras y numeros
		if (txtSueldo.getText().isEmpty() || !validarNumeros(txtSueldo.getText().trim())) {
			lblSueldo3.setForeground(Color.RED);
			bienEsta6 = false;
		} else {
			lblSueldo3.setForeground(Color.WHITE);
			bienEsta6 = true;
		}
		// Miarar que el campo passwd no sea null
		char[] contraseniaChar = passwordField.getPassword();
		String contrasenia = new String(contraseniaChar);
		if (contrasenia.isEmpty()) {
			lblContrasenia.setForeground(Color.RED);
			bienEsta7 = false;
		} else {
			lblContrasenia.setForeground(Color.WHITE);
			bienEsta7 = true;
		}

		// Resultado Final De la inspeccion de datos
		if (!bienEsta | !bienEsta2 | !bienEsta3 | !bienEsta4 | !bienEsta5 | !bienEsta6 | !bienEsta7) {
			ErrorContraseñaLogin.ErrorDeTrabajadorDatos();
		} else {
			// Validar si la contraseña es meno a 8 digitos
			char[] password = passwordField.getPassword();
			if (passwordField.getPassword().length < 8) {

				int option = JOptionPane.showOptionDialog(null,
						"La contraseña tiene menos de 8 caracteres\n¿Deseas cambiarla?", "Alerta",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,

						null, new String[] { "Cambiar contraseña", "Seguir adelante" }, "Cambiar contraseña");

				if (option == JOptionPane.YES_OPTION) {

				} else {
					ErrorContraseñaLogin.MensajeAltaTrabajador();
					// Metodo de alta
					introducirTrabajador();
				}
			} else {
				ErrorContraseñaLogin.MensajeAltaTrabajador();
				// Metodo de alta
				introducirTrabajador();
			}

		}
	}

	// Alta de Trabajador
	private void introducirTrabajador() {
		// METODO PARA INTRODUCIR UN TRABAJADOR
		Persona trabajador;
		trabajador = new Trabajador();

		trabajador.setNombre(txtNombre.getText());
		trabajador.setApellido(txtApellido.getText());
		trabajador.setDni(txtDni.getText());
		trabajador.setEdad(Integer.parseInt(txtEdad.getText()));
		trabajador.setDireccion(txtDireccion.getText());
		trabajador.setEmail(txtEmail.getText());
		trabajador.setContrasena(String.valueOf(passwordField.getPassword()));
		((Trabajador) trabajador).setSalario(Float.valueOf(txtSueldo.getText()));
		((Trabajador) trabajador).setIs_admin(false);

		try {
			cont.altaTrabajador(trabajador, txtSueldo);
		} catch (ErrorGeneral e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogInException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Este pattron comprueba que el apellido y el nombre esta compuesto solo por
	// letras o grupos de letars
	public static boolean validarLetras(String letras) {
		return letras.matches("[A-Za-z]*");
	}

	// Este patron mira que se introduzcan un numero de 8 digitos y una letra
	// mayuscula o minuscula
	public static boolean validarDni(String letras) {
		return letras.matches("[0-9]{8}[A-Za-z]");
	}

	// Este patron verifica que los numeros introducidos sean 4 ni mas ni menos
	public static boolean validarEdad(String letras) {
		return letras.matches("[0-9]{4}");
	}

	// Este patron verifica que solo se puedan intoducir numeros y letras
	public static boolean validarDireccion(String letras) {
		return letras.matches("[A-Za-z0-9]+");
	}

	// Este patron verifica que solo se puedan intoducir numeros
	public static boolean validarNumeros(String letras) {
		return letras.matches("[0-9]+(\\.[0-9]+)?");
	}

}

package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class VentanaAdmin extends JDialog  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldEmailComprobar;
	private JTextField txtFieldDNI;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellido;
	private JTextField txtFieldEdad;
	private JTextField txtFieldEmail;
	private JTextField txtFieldDireccion;
	private JTextField txtFieldDNITrabajadores;
	private JTextField txtFieldNombreTrabajadores;
	private JTextField txtFieldApellidoTrabajadores;
	private JTextField txtFieldEdadTrabajadores;
	private JTextField txtFieldEmailTrabajadores;
	private JTextField txtFieldDireccionTrabajadores;
	private JTextField txtFieldSueldo;
	private JTextField txtFieldNombreInsertar;
	private JTextField txtFieldAnio;
	private JTextField txtFieldPrecio;
	private JTextField txtFieldContrasena2;
	private JTextField txtFieldContrasena;
	private JTextField txtFieldBuscarJuego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		try {
			VentanaAdmin dialog = new VentanaAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAdmin() {
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
		
		JLabel lblEmailComprobar = new JLabel("Email:");
		lblEmailComprobar.setForeground(UIManager.getColor("Button.background"));
		lblEmailComprobar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmailComprobar.setBounds(45, 10, 60, 35);
		panel.add(lblEmailComprobar);
		
		txtFieldEmailComprobar = new JTextField();
		txtFieldEmailComprobar.setBounds(115, 17, 297, 25);
		panel.add(txtFieldEmailComprobar);
		txtFieldEmailComprobar.setColumns(10);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnComprobar.setBackground(new Color(255, 102, 102));
		btnComprobar.setBounds(433, 17, 133, 28);
		panel.add(btnComprobar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGuardar.setBackground(new Color(255, 102, 102));
		btnGuardar.setBounds(622, 301, 154, 35);
		panel.add(btnGuardar);
		
		JButton btnBorrarDatos = new JButton("Borrar datos");
		btnBorrarDatos.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBorrarDatos.setBackground(new Color(255, 102, 102));
		btnBorrarDatos.setBounds(447, 301, 154, 35);
		panel.add(btnBorrarDatos);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
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
		
		JLabel lblEdad = new JLabel("Fecha Nacimiento:");
		lblEdad.setForeground(UIManager.getColor("Button.background"));
		lblEdad.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEdad.setBounds(45, 213, 133, 35);
		panel.add(lblEdad);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(UIManager.getColor("Button.background"));
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(373, 73, 97, 35);
		panel.add(lblEmail);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground(UIManager.getColor("Button.background"));
		lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDireccion.setBounds(373, 123, 97, 35);
		panel.add(lblDireccion);
		
		JCheckBox chckbxPremium = new JCheckBox("Usuario premium");
		chckbxPremium.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chckbxPremium.setForeground(new Color(240, 240, 240));
		chckbxPremium.setBackground(new Color(0, 0, 160));
		chckbxPremium.setBounds(539, 259, 165, 21);
		panel.add(chckbxPremium);
		
		txtFieldDNI = new JTextField();
		txtFieldDNI.setColumns(10);
		txtFieldDNI.setBounds(175, 80, 174, 25);
		panel.add(txtFieldDNI);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setColumns(10);
		txtFieldNombre.setBounds(175, 130, 174, 25);
		panel.add(txtFieldNombre);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setColumns(10);
		txtFieldApellido.setBounds(175, 175, 174, 25);
		panel.add(txtFieldApellido);
		
		txtFieldEdad = new JTextField();
		txtFieldEdad.setColumns(10);
		txtFieldEdad.setBounds(175, 220, 174, 25);
		panel.add(txtFieldEdad);
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setColumns(10);
		txtFieldEmail.setBounds(480, 83, 224, 25);
		panel.add(txtFieldEmail);
		
		txtFieldDireccion = new JTextField();
		txtFieldDireccion.setColumns(10);
		txtFieldDireccion.setBounds(480, 133, 224, 25);
		panel.add(txtFieldDireccion);
		
		txtFieldContrasena2 = new JTextField();
		txtFieldContrasena2.setColumns(10);
		txtFieldContrasena2.setBounds(480, 220, 224, 25);
		panel.add(txtFieldContrasena2);
		
		JLabel lblContrasena2 = new JLabel("Confirma");
		lblContrasena2.setForeground(UIManager.getColor("Button.background"));
		lblContrasena2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblContrasena2.setBounds(373, 201, 97, 35);
		panel.add(lblContrasena2);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setForeground(UIManager.getColor("Button.background"));
		lblContrasena.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblContrasena.setBounds(373, 168, 97, 35);
		panel.add(lblContrasena);
		
		txtFieldContrasena = new JTextField();
		txtFieldContrasena.setColumns(10);
		txtFieldContrasena.setBounds(480, 178, 224, 25);
		panel.add(txtFieldContrasena);
		
		
		JLabel lblApellido_1_2_1 = new JLabel("contraseña:");
		lblApellido_1_2_1.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1_2_1.setBounds(373, 216, 97, 35);
		panel.add(lblApellido_1_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR JUEGO", null, panel_2, null);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(242, 194, 102, 28);
		panel_2.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setBounds(242, 222, 318, 99);
		panel_2.add(textAreaDescripcion);
		
		JLabel lblNombreInsertar = new JLabel("Nombre: ");
		lblNombreInsertar.setForeground(Color.WHITE);
		lblNombreInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreInsertar.setBounds(351, 61, 89, 28);
		panel_2.add(lblNombreInsertar);
		
		JLabel lblAnio = new JLabel("Año:");
		lblAnio.setForeground(Color.WHITE);
		lblAnio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnio.setBounds(351, 100, 89, 28);
		panel_2.add(lblAnio);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(351, 139, 89, 28);
		panel_2.add(lblPrecio);
		
		txtFieldNombreInsertar = new JTextField();
		txtFieldNombreInsertar.setColumns(10);
		txtFieldNombreInsertar.setBounds(425, 67, 152, 20);
		panel_2.add(txtFieldNombreInsertar);
		
		txtFieldAnio = new JTextField();
		txtFieldAnio.setColumns(10);
		txtFieldAnio.setBounds(425, 106, 152, 20);
		panel_2.add(txtFieldAnio);
		
		txtFieldPrecio = new JTextField();
		txtFieldPrecio.setColumns(10);
		txtFieldPrecio.setBounds(425, 145, 152, 20);
		panel_2.add(txtFieldPrecio);
		
		JButton btnLimpiarInsertar = new JButton("Limpiar");
		btnLimpiarInsertar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLimpiarInsertar.setBackground(new Color(255, 102, 102));
		btnLimpiarInsertar.setBounds(603, 223, 154, 35);
		panel_2.add(btnLimpiarInsertar);
		
		JButton btnInsertarJuego = new JButton("Insertar Juego");
		btnInsertarJuego.setFont(new Font("Arial", Font.PLAIN, 17));
		btnInsertarJuego.setBackground(new Color(255, 102, 102));
		btnInsertarJuego.setBounds(603, 284, 154, 35);
		panel_2.add(btnInsertarJuego);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(85, 70, 118, 97);
		panel_2.add(lblImagen);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 160));
		
		tabbedPane.addTab("STOCK", null, panel_1, null);
		panel_1.setLayout(null);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerCantidad.setBounds(331, 180, 122, 27);
		panel_1.add(spinnerCantidad);
		
		JComboBox comboBoxJuego = new JComboBox();
		comboBoxJuego.setBounds(234, 112, 319, 27);
		panel_1.add(comboBoxJuego);
		
		JLabel lblNewLabel = new JLabel("Nombre del juego:");
		lblNewLabel.setForeground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(234, 78, 319, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(new Color(240, 240, 240));
		lblCantidad.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCantidad.setBounds(234, 149, 319, 35);
		panel_1.add(lblCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setForeground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(234, 207, 319, 35);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setBounds(234, 241, 319, 27);
		panel_1.add(comboBoxProveedor);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEnviar.setBackground(new Color(255, 102, 102));
		btnEnviar.setBounds(399, 278, 154, 35);
		panel_1.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLimpiar.setBackground(new Color(255, 102, 102));
		btnLimpiar.setBounds(234, 278, 154, 35);
		panel_1.add(btnLimpiar);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del juego:");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(234, 10, 319, 35);
		panel_1.add(lblNewLabel_3);
		
		txtFieldBuscarJuego = new JTextField();
		txtFieldBuscarJuego.setBounds(234, 44, 186, 35);
		panel_1.add(txtFieldBuscarJuego);
		txtFieldBuscarJuego.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setBackground(new Color(255, 102, 102));
		btnBuscar.setBounds(430, 44, 122, 35);
		panel_1.add(btnBuscar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR TRABAJADORES", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblDniTrabajadores = new JLabel("DNI:");
		lblDniTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblDniTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDniTrabajadores.setBounds(48, 72, 115, 35);
		panel_3.add(lblDniTrabajadores);
		
		txtFieldDNITrabajadores = new JTextField();
		txtFieldDNITrabajadores.setColumns(10);
		txtFieldDNITrabajadores.setBounds(181, 79, 171, 25);
		panel_3.add(txtFieldDNITrabajadores);
		
		txtFieldNombreTrabajadores = new JTextField();
		txtFieldNombreTrabajadores.setColumns(10);
		txtFieldNombreTrabajadores.setBounds(181, 129, 171, 25);
		panel_3.add(txtFieldNombreTrabajadores);
		
		JLabel lblNombreTrabajadores = new JLabel("Nombre:");
		lblNombreTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblNombreTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombreTrabajadores.setBounds(48, 122, 97, 35);
		panel_3.add(lblNombreTrabajadores);
		
		JLabel lblApellidoTrabajadores = new JLabel("Apellido:");
		lblApellidoTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblApellidoTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellidoTrabajadores.setBounds(48, 167, 97, 35);
		panel_3.add(lblApellidoTrabajadores);
		
		txtFieldApellidoTrabajadores = new JTextField();
		txtFieldApellidoTrabajadores.setColumns(10);
		txtFieldApellidoTrabajadores.setBounds(181, 174, 171, 25);
		panel_3.add(txtFieldApellidoTrabajadores);
		
		txtFieldEdadTrabajadores = new JTextField();
		txtFieldEdadTrabajadores.setColumns(10);
		txtFieldEdadTrabajadores.setBounds(181, 219, 171, 25);
		panel_3.add(txtFieldEdadTrabajadores);
		
		JLabel lblEdadTrabajadores = new JLabel("Fecha Nacimiento:");
		lblEdadTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblEdadTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEdadTrabajadores.setBounds(48, 212, 136, 35);
		panel_3.add(lblEdadTrabajadores);
		
		JLabel lblEmailTrabajadores = new JLabel("Email:");
		lblEmailTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblEmailTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmailTrabajadores.setBounds(376, 72, 97, 35);
		panel_3.add(lblEmailTrabajadores);
		
		txtFieldEmailTrabajadores = new JTextField();
		txtFieldEmailTrabajadores.setColumns(10);
		txtFieldEmailTrabajadores.setBounds(483, 82, 224, 25);
		panel_3.add(txtFieldEmailTrabajadores);
		
		txtFieldDireccionTrabajadores = new JTextField();
		txtFieldDireccionTrabajadores.setColumns(10);
		txtFieldDireccionTrabajadores.setBounds(483, 132, 224, 25);
		panel_3.add(txtFieldDireccionTrabajadores);
		
		JLabel lblDireccionTrabajadores = new JLabel("Dirección:");
		lblDireccionTrabajadores.setForeground(UIManager.getColor("Button.background"));
		lblDireccionTrabajadores.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDireccionTrabajadores.setBounds(376, 122, 97, 35);
		panel_3.add(lblDireccionTrabajadores);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(UIManager.getColor("Button.background"));
		lblSueldo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblSueldo.setBounds(376, 167, 97, 35);
		panel_3.add(lblSueldo);
		
		txtFieldSueldo = new JTextField();
		txtFieldSueldo.setColumns(10);
		txtFieldSueldo.setBounds(483, 177, 224, 25);
		panel_3.add(txtFieldSueldo);
		
		JButton btnInsertarTrabajador = new JButton("Insertar trabajador");
		btnInsertarTrabajador.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertarTrabajador.setBackground(new Color(255, 102, 102));
		btnInsertarTrabajador.setBounds(565, 301, 211, 35);
		panel_3.add(btnInsertarTrabajador);
		
		JButton btnBorrarDatosTrabajadores = new JButton("Borrar datos");
		btnBorrarDatosTrabajadores.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBorrarDatosTrabajadores.setBackground(new Color(255, 102, 102));
		btnBorrarDatosTrabajadores.setBounds(401, 301, 154, 35);
		panel_3.add(btnBorrarDatosTrabajadores);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

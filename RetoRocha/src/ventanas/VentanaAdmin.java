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
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class VentanaAdmin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(UIManager.getColor("Button.background"));
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(45, 10, 60, 35);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(115, 17, 297, 25);
		panel.add(textField);
		textField.setColumns(10);
		
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Usuario premium");
		chckbxNewCheckBox.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chckbxNewCheckBox.setForeground(new Color(240, 240, 240));
		chckbxNewCheckBox.setBackground(new Color(0, 0, 160));
		chckbxNewCheckBox.setBounds(373, 177, 165, 21);
		panel.add(chckbxNewCheckBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 80, 224, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 130, 224, 25);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 175, 224, 25);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(125, 220, 224, 25);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(480, 83, 224, 25);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(480, 133, 224, 25);
		panel.add(textField_6);
		
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
		
		JLabel lblDni_1 = new JLabel("DNI:");
		lblDni_1.setForeground(UIManager.getColor("Button.background"));
		lblDni_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDni_1.setBounds(48, 72, 115, 35);
		panel_3.add(lblDni_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 79, 224, 25);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(128, 129, 224, 25);
		panel_3.add(textField_8);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setForeground(UIManager.getColor("Button.background"));
		lblNombre_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombre_1.setBounds(48, 122, 97, 35);
		panel_3.add(lblNombre_1);
		
		JLabel lblApellido_2 = new JLabel("Apellido:");
		lblApellido_2.setForeground(UIManager.getColor("Button.background"));
		lblApellido_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_2.setBounds(48, 167, 97, 35);
		panel_3.add(lblApellido_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(128, 174, 224, 25);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(128, 219, 224, 25);
		panel_3.add(textField_10);
		
		JLabel lblEdad_1 = new JLabel("Edad:");
		lblEdad_1.setForeground(UIManager.getColor("Button.background"));
		lblEdad_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEdad_1.setBounds(48, 212, 97, 35);
		panel_3.add(lblEdad_1);
		
		JLabel lblEmail_1_1 = new JLabel("Email:");
		lblEmail_1_1.setForeground(UIManager.getColor("Button.background"));
		lblEmail_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1_1.setBounds(376, 72, 97, 35);
		panel_3.add(lblEmail_1_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(483, 82, 224, 25);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(483, 132, 224, 25);
		panel_3.add(textField_12);
		
		JLabel lblApellido_1_1 = new JLabel("Dirección:");
		lblApellido_1_1.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1_1.setBounds(376, 122, 97, 35);
		panel_3.add(lblApellido_1_1);
		
		JLabel lblApellido_1_1_1 = new JLabel("Sueldo:");
		lblApellido_1_1_1.setForeground(UIManager.getColor("Button.background"));
		lblApellido_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido_1_1_1.setBounds(376, 167, 97, 35);
		panel_3.add(lblApellido_1_1_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(483, 177, 224, 25);
		panel_3.add(textField_13);
		
		JButton btnInsertarTrabajador = new JButton("Insertar trabajador");
		btnInsertarTrabajador.setFont(new Font("Arial", Font.PLAIN, 20));
		btnInsertarTrabajador.setBackground(new Color(255, 102, 102));
		btnInsertarTrabajador.setBounds(565, 301, 211, 35);
		panel_3.add(btnInsertarTrabajador);
		
		JButton btnBorrarDatos_1 = new JButton("Borrar datos");
		btnBorrarDatos_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBorrarDatos_1.setBackground(new Color(255, 102, 102));
		btnBorrarDatos_1.setBounds(401, 301, 154, 35);
		panel_3.add(btnBorrarDatos_1);
	}
}

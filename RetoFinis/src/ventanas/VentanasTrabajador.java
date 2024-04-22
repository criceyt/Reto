package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import java.awt.Image;
import java.io.File;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class VentanasTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblImagen;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanasTrabajador dialog = new VentanasTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanasTrabajador() {
		setBounds(100, 100, 807, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 160));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 791, 373);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("GESTION DE CLIENTES", null, panel, null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(UIManager.getColor("Button.background"));
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(45, 10, 60, 35);
		panel.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 17, 297, 25);
		panel.add(textField_3);
		
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
		chckbxNewCheckBox.setForeground(UIManager.getColor("Button.background"));
		chckbxNewCheckBox.setFont(new Font("Arial Black", Font.PLAIN, 14));
		chckbxNewCheckBox.setBackground(new Color(0, 0, 160));
		chckbxNewCheckBox.setBounds(373, 177, 165, 21);
		panel.add(chckbxNewCheckBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(125, 80, 224, 25);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(125, 130, 224, 25);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(125, 175, 224, 25);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(125, 220, 224, 25);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(480, 83, 224, 25);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(480, 133, 224, 25);
		panel.add(textField_9);
		
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
		enviarButton.setBackground(new Color(255, 102, 102));
		enviarButton.setBounds(399, 278, 154, 35);
		panel_1.add(enviarButton);
		
		JButton enviarButton_1 = new JButton("Limpiar");
		enviarButton_1.setBackground(new Color(255, 102, 102));
		enviarButton_1.setBounds(234, 278, 154, 35);
		panel_1.add(enviarButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 160));
		tabbedPane.addTab("INSERTAR JUEGOS ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(242, 194, 89, 28);
		panel_2.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 222, 318, 99);
		panel_2.add(textArea);
		textArea.setLineWrap(true);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre: ");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(351, 61, 89, 28);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Año:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(351, 100, 89, 28);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Precio:");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(351, 139, 89, 28);
		panel_2.add(lblNewLabel_2_3);
		
		textField = new JTextField();
		textField.setBounds(425, 67, 152, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(425, 106, 152, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(425, 145, 152, 20);
		panel_2.add(textField_2);
		
		JButton enviarButton_1_1 = new JButton("Limpiar");
		enviarButton_1_1.setBackground(new Color(255, 102, 102));
		enviarButton_1_1.setBounds(603, 223, 154, 35);
		panel_2.add(enviarButton_1_1);
		
		JButton enviarButton_2 = new JButton("Insertar Juego");
		enviarButton_2.setBackground(new Color(255, 102, 102));
		enviarButton_2.setBounds(603, 284, 154, 35);
		panel_2.add(enviarButton_2);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(85, 70, 118, 97);
		panel_2.add(lblImagen);
		
		
	}
	private void cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            lblImagen.setIcon(scaledIcon);
        }
    }
}

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

public class VentanaAdmin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		
		JPanel panel_1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(128, 0, 128)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 791, 373);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("GESTIÓN DE CLIENTES", null, panel, null);
		
		tabbedPane.addTab("STOCK", null, panel_1, null);
		panel_1.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
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
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del juego:");
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
		tabbedPane.addTab("INSERTAR JUEGO", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("INSERTAR TRABAJADORES", null, panel_3, null);
	}
}

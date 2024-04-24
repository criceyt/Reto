package ventanas;

import javax.swing.*;

import utilidades.Utilidades;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

public class VentanaDatosBancarios extends JFrame {
	private JTextField numeroTarjeta;
	private JTextField nombreTarjeta;
	private JTextField CodigoTrajeta;
	private JTextField fechaEnvegecimiento;

	boolean bienEsta = false;
	boolean bienEsta2 = false;
	boolean bienEsta3 = false;
	boolean bienEsta4 = false;

	public VentanaDatosBancarios() {
		setTitle("Introducir Datos Bancarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(588, 445);
		setLocationRelativeTo(null);

		// Panel principal con diseño degradado
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(128, 0, 128)));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		ImageIcon logoIcon = new ImageIcon(".\\.\\img\\logo_G3_2.PNG");
		JLabel logoLabel = new JLabel(logoIcon);

		// Panel para los campos de entrada
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		JPanel inputPanel = new JPanel(gbl_inputPanel);
		inputPanel.setOpaque(false);

		panel.add(logoLabel, BorderLayout.NORTH);
		panel.add(inputPanel, BorderLayout.CENTER);

		JLabel LabelTarjetaNum = new JLabel("Titular: ");
		LabelTarjetaNum.setForeground(Color.GRAY);
		GridBagConstraints gbc_LabelTarjetaNum = new GridBagConstraints();
		gbc_LabelTarjetaNum.anchor = GridBagConstraints.EAST;
		gbc_LabelTarjetaNum.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTarjetaNum.gridx = 1;
		gbc_LabelTarjetaNum.gridy = 4;
		inputPanel.add(LabelTarjetaNum, gbc_LabelTarjetaNum);

		nombreTarjeta = new JTextField();
		nombreTarjeta.setCaretColor(Color.BLACK);
		nombreTarjeta.setForeground(new Color(212, 212, 212));
		nombreTarjeta.setOpaque(false); // Hacer transparente el JTextField
		nombreTarjeta.setColumns(10);
		GridBagConstraints gbc_nombreTarjeta = new GridBagConstraints();
		gbc_nombreTarjeta.insets = new Insets(0, 0, 5, 0);
		gbc_nombreTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreTarjeta.gridx = 2;
		gbc_nombreTarjeta.gridy = 4;
		inputPanel.add(nombreTarjeta, gbc_nombreTarjeta);

		JLabel LabelTrajetaNum2 = new JLabel("Número de tarjeta:");
		LabelTrajetaNum2.setForeground(Color.GRAY);
		GridBagConstraints gbc_LabelTrajetaNum2 = new GridBagConstraints();
		gbc_LabelTrajetaNum2.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTrajetaNum2.gridx = 1;
		gbc_LabelTrajetaNum2.gridy = 5;
		inputPanel.add(LabelTrajetaNum2, gbc_LabelTrajetaNum2);

		numeroTarjeta = new JTextField();
		numeroTarjeta.setForeground(new Color(212, 212, 212));
		numeroTarjeta.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
		numeroTarjeta.setOpaque(false); // Hacer transparente el JTextField
		GridBagConstraints gbc_numeroTarjeta = new GridBagConstraints();
		gbc_numeroTarjeta.insets = new Insets(0, 0, 5, 0);
		gbc_numeroTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroTarjeta.gridx = 2;
		gbc_numeroTarjeta.gridy = 5;
		inputPanel.add(numeroTarjeta, gbc_numeroTarjeta);
		numeroTarjeta.setColumns(10);

		JLabel LabelTarjetaNum3 = new JLabel("Código de seguridad:");
		LabelTarjetaNum3.setForeground(Color.GRAY);
		GridBagConstraints gbc_LabelTarjetaNum3 = new GridBagConstraints();
		gbc_LabelTarjetaNum3.anchor = GridBagConstraints.EAST;
		gbc_LabelTarjetaNum3.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTarjetaNum3.gridx = 1;
		gbc_LabelTarjetaNum3.gridy = 6;
		inputPanel.add(LabelTarjetaNum3, gbc_LabelTarjetaNum3);

		CodigoTrajeta = new JTextField();
		CodigoTrajeta.setForeground(new Color(212, 212, 212));
		CodigoTrajeta.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
		CodigoTrajeta.setOpaque(false); // Hacer transparente el JTextField
		CodigoTrajeta.setColumns(10);
		GridBagConstraints gbc_CodigoTrajeta = new GridBagConstraints();
		gbc_CodigoTrajeta.insets = new Insets(0, 0, 5, 0);
		gbc_CodigoTrajeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_CodigoTrajeta.gridx = 2;
		gbc_CodigoTrajeta.gridy = 6;
		inputPanel.add(CodigoTrajeta, gbc_CodigoTrajeta);

		JLabel LabelTarjetaNum4 = new JLabel("Fecha de vencimiento:");
		LabelTarjetaNum4.setForeground(Color.GRAY);
		GridBagConstraints gbc_LabelTarjetaNum4 = new GridBagConstraints();
		gbc_LabelTarjetaNum4.anchor = GridBagConstraints.EAST;
		gbc_LabelTarjetaNum4.insets = new Insets(0, 0, 0, 5);
		gbc_LabelTarjetaNum4.gridx = 1;
		gbc_LabelTarjetaNum4.gridy = 7;
		inputPanel.add(LabelTarjetaNum4, gbc_LabelTarjetaNum4);

		fechaEnvegecimiento = new JTextField();
		fechaEnvegecimiento.setForeground(new Color(212, 212, 212));
		fechaEnvegecimiento.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
		fechaEnvegecimiento.setOpaque(false); // Hacer transparente el JTextField
		fechaEnvegecimiento.setColumns(10);
		GridBagConstraints gbc_fechaEnvegecimiento = new GridBagConstraints();
		gbc_fechaEnvegecimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaEnvegecimiento.gridx = 2;
		gbc_fechaEnvegecimiento.gridy = 7;
		inputPanel.add(fechaEnvegecimiento, gbc_fechaEnvegecimiento);

		// Botón de enviar
		JButton enviarButton = new JButton("Enviar");
		enviarButton.setBackground(new Color(255, 102, 102));
		enviarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nombreTarjeta.getText().isEmpty()) {
					LabelTarjetaNum.setForeground(Color.RED);
					bienEsta = true;
				} else {
					LabelTarjetaNum.setForeground(Color.WHITE);
				}
				if (numeroTarjeta.getText().isEmpty()) {
					LabelTrajetaNum2.setForeground(Color.RED);
					bienEsta2 = true;
				} else {
					LabelTrajetaNum2.setForeground(Color.WHITE);
				}
				if (CodigoTrajeta.getText().isEmpty()) {
					LabelTarjetaNum3.setForeground(Color.RED);
					bienEsta3 = true;
				} else {
					LabelTarjetaNum3.setForeground(Color.WHITE);
				}
				if (fechaEnvegecimiento.getText().isEmpty()) {
					LabelTarjetaNum4.setForeground(Color.RED);
					bienEsta4 = true;
				} else {
					LabelTarjetaNum4.setForeground(Color.WHITE);
				}

				if (!bienEsta || !bienEsta2 || !bienEsta3 || !bienEsta4) {
					JOptionPane.showMessageDialog(null, "El color de texto en rojo no es valido", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Tus Datos Han sido Guardados con exito",
							"BIENVENIDO AL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		panel.add(enviarButton, BorderLayout.SOUTH);

		getContentPane().add(panel);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaDatosBancarios();
			}
		});
	}
}

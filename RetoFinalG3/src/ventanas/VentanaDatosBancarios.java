package ventanas;

import javax.swing.*;

import utilidades.Utilidades;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

public class VentanaDatosBancarios extends JFrame {
    private JTextField numeroTarjeta;
    private JTextField nombreTrajeta;
    private JTextField CodigoTrajeta;
    private JTextField fechaEnvegecimiento;

    boolean bienEsta=true;
    
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
        gbl_inputPanel.columnWeights = new double[]{0.0, 0.0, 1.0};
        JPanel inputPanel = new JPanel(gbl_inputPanel);
        inputPanel.setOpaque(false);

       

        panel.add(logoLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);

        JLabel lblNewLabel_3 = new JLabel("Nombre en la tarjeta:");
        lblNewLabel_3.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);    
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 4;
        inputPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);

        nombreTrajeta = new JTextField();
        nombreTrajeta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        nombreTrajeta.setCaretColor(Color.BLACK);
        nombreTrajeta.setForeground(new Color(212, 212, 212));
        nombreTrajeta.setOpaque(false); // Hacer transparente el JTextField
        nombreTrajeta.setColumns(10);
        GridBagConstraints gbc_nombreTrajeta = new GridBagConstraints();
        gbc_nombreTrajeta.insets = new Insets(0, 0, 5, 0);
        gbc_nombreTrajeta.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreTrajeta.gridx = 2;
        gbc_nombreTrajeta.gridy = 4;
        inputPanel.add(nombreTrajeta, gbc_nombreTrajeta);

        JLabel lblNewLabel = new JLabel("Número de tarjeta:");
        lblNewLabel.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 5;
        inputPanel.add(lblNewLabel, gbc_lblNewLabel);

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

        JLabel lblNewLabel_1 = new JLabel("Código de seguridad:");
        lblNewLabel_1.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 6;
        inputPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

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

        JLabel lblNewLabel_2 = new JLabel("Fecha de vencimiento:");
        lblNewLabel_2.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 7;
        inputPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

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
            	if(nombreTrajeta != null && nombreTrajeta.getText().isEmpty())  {
            		bienEsta=true;
            	}else{
            		bienEsta=false;
            		nombreTrajeta.setBackground(Color.RED);
            	}
            		
            		if (numeroTarjeta != null && numeroTarjeta.getText().matches("\\d+")) {
            			bienEsta=true;
            		}else{
            			bienEsta=false;
            		}
						if (CodigoTrajeta != null && CodigoTrajeta.getText().matches("\\d+") ) {
							bienEsta=true;
							
							
						} else {
							bienEsta=false;
						}
						
						
					
            	
            		
            	
            	if(bienEsta==true) {
            		JOptionPane.showMessageDialog(null, "Tu Registro ha sido completado con exito","BIENVENIDO" , JOptionPane.INFORMATION_MESSAGE);
            	}
            	if (bienEsta==false) {
					JOptionPane.showMessageDialog(null, "Error el Campo de color rojo no es Valido", "DATOS ERRONEOS", JOptionPane.ERROR_MESSAGE);
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

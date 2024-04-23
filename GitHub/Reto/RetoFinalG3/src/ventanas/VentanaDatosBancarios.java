package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaDatosBancarios extends JFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public VentanaDatosBancarios() {
        setTitle("Introducir Datos Bancarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
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

        // Botón de enviar
        JButton enviarButton = new JButton("Enviar");
        enviarButton.setBackground(new Color(255, 102, 102));
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón
            }
        });

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

        textField_1 = new JTextField();
        textField_1.setCaretColor(Color.BLACK);
        textField_1.setForeground(new Color(212, 212, 212));
        textField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
        textField_1.setOpaque(false); // Hacer transparente el JTextField
        textField_1.setColumns(10);
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 4;
        inputPanel.add(textField_1, gbc_textField_1);

        JLabel lblNewLabel = new JLabel("Número de tarjeta:");
        lblNewLabel.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 5;
        inputPanel.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        textField.setForeground(new Color(212, 212, 212));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
        textField.setOpaque(false); // Hacer transparente el JTextField
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 5;
        inputPanel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Código de seguridad:");
        lblNewLabel_1.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 6;
        inputPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField_2 = new JTextField();
        textField_2.setForeground(new Color(212, 212, 212));
        textField_2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
        textField_2.setOpaque(false); // Hacer transparente el JTextField
        textField_2.setColumns(10);
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 6;
        inputPanel.add(textField_2, gbc_textField_2);

        JLabel lblNewLabel_2 = new JLabel("Fecha de vencimiento:");
        lblNewLabel_2.setForeground(Color.GRAY);
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 7;
        inputPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

        textField_3 = new JTextField();
        textField_3.setForeground(new Color(212, 212, 212));
        textField_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Borde inferior
        textField_3.setOpaque(false); // Hacer transparente el JTextField
        textField_3.setColumns(10);
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 7;
        inputPanel.add(textField_3, gbc_textField_3);

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

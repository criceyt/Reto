package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

public class Singup extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDNI;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldConfirmar;
    private JButton btnRegistrarse;
    private JButton btnLogin;
    private boolean esPremiun;
    private JCheckBox chckbxNewCheckBox; 

    public Singup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 537);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 130, 253));
        panel.setBounds(0, 0, 400, 500);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
        lblLogo.setBounds(50, 125, 300, 250); 
        panel.add(lblLogo);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(7, 41, 120));
        panel_1.setBounds(400, 0, 400, 500);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        txtNombre = createTextField("Nombre", 50, 30, 300, 27);
        panel_1.add(txtNombre);

        txtApellido = createTextField("Apellido", 50, 80, 300, 27);
        panel_1.add(txtApellido);

        txtDNI = createTextField("DNI", 50, 130, 300, 27);
        panel_1.add(txtDNI);

        txtDireccion = createTextField("Dirección", 50, 180, 300, 27);
        panel_1.add(txtDireccion);

        txtEmail = createTextField("Email", 50, 230, 300, 27);
        panel_1.add(txtEmail);

        passwordField = createPasswordField("Password", 50, 280, 300, 27);
        panel_1.add(passwordField);

        passwordFieldConfirmar = createPasswordField("Confirmar Password", 50, 330, 300, 27);
        panel_1.add(passwordFieldConfirmar);
        
        chckbxNewCheckBox = new JCheckBox("Es Premium");
        chckbxNewCheckBox.setBackground(new Color(7, 41, 120));
        chckbxNewCheckBox.setForeground(Color.WHITE);
        chckbxNewCheckBox.setBounds(50, 380, 150, 27);
        panel_1.add(chckbxNewCheckBox);

        JSeparator separator_1 = new JSeparator();
       
        // ... (Otros separadores para mantener la estética)

        btnRegistrarse = new JButton("REGISTRARSE");
        btnRegistrarse.setForeground(new Color(255, 255, 255));
        btnRegistrarse.setBackground(new Color(7, 41, 120));
        btnRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnRegistrarse.setBounds(50, 447, 150, 27);
        panel_1.add(btnRegistrarse);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Recolectar datos de campos de texto
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDNI.getText();
                String direccion = txtDireccion.getText();
                String email = txtEmail.getText();
                String password = new String(passwordField.getPassword());
                String confirmarPassword = new String(passwordFieldConfirmar.getPassword());
                boolean esPremiun = chckbxNewCheckBox.isSelected();
                // Verificar campos vacíos
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || 
                    direccion.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                    return;
                }

                // Verificar el formato del correo electrónico
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                    JOptionPane.showMessageDialog(null, "Formato de correo electrónico inválido.");
                    return;
                }

                // Verificar si las contraseñas coinciden
                if (!password.equals(confirmarPassword)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
                    return;
                }

                // Comprobar si el DNI o el correo electrónico ya están registrados
                try (Connection conn = ConexionBD.getConnection()) {
                    // Verificar si el DNI ya está registrado
                    try (PreparedStatement checkDNI = conn.prepareStatement(
                            "SELECT * FROM PERSONA WHERE DNI = ?")) {
                        checkDNI.setString(1, dni);
                        try (ResultSet rsDNI = checkDNI.executeQuery()) {
                            if (rsDNI.next()) {
                                JOptionPane.showMessageDialog(null, "El DNI ya está registrado.");
                                return;
                            }
                        }
                    }

                    // Verificar si el correo electrónico ya está registrado
                    try (PreparedStatement checkEmail = conn.prepareStatement(
                            "SELECT * FROM PERSONA WHERE EMAIL = ?")) {
                        checkEmail.setString(1, email);
                        try (ResultSet rsEmail = checkEmail.executeQuery()) {
                            if (rsEmail.next()) {
                                JOptionPane.showMessageDialog(null, "El correo electrónico ya está registrado.");
                                return;
                            }
                        }
                    }

                    // Insertar datos en la tabla PERSONA y CLIENTE
                    try (PreparedStatement pstmtPersona = conn.prepareStatement(
                         "INSERT INTO PERSONA (NOMBRE_PERSONA, APELLIDO, DNI, DIRECCION, EMAIL, CONTRASEÑA) VALUES (?, ?, ?, ?, ?, ?)");
                         PreparedStatement pstmtCliente = conn.prepareStatement(
                         "INSERT INTO CLIENTE (DNI, ES_PREMIUN) VALUES (?, ?)")) {

                        // Establecer valores para la tabla PERSONA
                        pstmtPersona.setString(1, nombre);
                        pstmtPersona.setString(2, apellido);
                        pstmtPersona.setString(3, dni);
                        pstmtPersona.setString(4, direccion);
                        pstmtPersona.setString(5, email);
                        pstmtPersona.setString(6, password);

                        // Establecer valores para la tabla CLIENTE
                        pstmtCliente.setString(1, dni);
                        pstmtCliente.setBoolean(2, esPremiun);

                        // Ejecutar las consultas
                        pstmtPersona.executeUpdate();
                        pstmtCliente.executeUpdate();

                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + ex.getMessage());
                }
            }
        });

        btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(7, 41, 120));
        btnLogin.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnLogin.setBounds(250, 447, 100, 27);
        panel_1.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login volver = new Login();
                volver.setVisible(true);
            }
        });
    }

    private JTextField createTextField(String defaultText, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField.setForeground(new Color(192, 192, 192));
        textField.setText(defaultText);
        textField.setBackground(new Color(7, 41, 120)); 
        textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
        textField.setBounds(x, y, width, height);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textField.getText().equals(defaultText)) {
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }
        });
        return textField;
    }

    private JPasswordField createPasswordField(String defaultText, int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setForeground(new Color(192, 192, 192));
        passwordField.setToolTipText("");
        passwordField.setBackground(new Color(7, 41, 120)); 
        passwordField.setText(defaultText);
        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
        passwordField.setBounds(x, y, width, height);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText = new String(passwordField.getPassword());
                if (passwordText.equals("passwordField") ){
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }
        });
        return passwordField;
    }
}

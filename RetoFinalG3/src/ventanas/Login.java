package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private String usuarioDNI;  // Variable para almacenar el DNI del usuario

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 723, 448);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 707, 418);
        contentPane.add(panel);

        JPanel panelRight = new JPanel(null);
        panelRight.setBackground(new Color(7, 41, 120));
        panelRight.setBounds(353, 0, 354, 418);
        panel.add(panelRight);

        textField = new JTextField("Email");
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField.setBorder(null);
        textField.setBackground(new Color(7, 41, 120));
        textField.setBounds(69, 122, 218, 27);
        panelRight.add(textField);

        passwordField = new JPasswordField("Password");
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setBorder(null);
        passwordField.setBackground(new Color(7, 41, 120));
        passwordField.setBounds(69, 184, 218, 27);
        panelRight.add(passwordField);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(69, 151, 224, 2);
        panelRight.add(separator_1);

        JSeparator separator_2 = new JSeparator();
      

        JButton btnLogIn = new JButton("LOG IN");
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setBorder(new LineBorder(Color.WHITE));
        btnLogIn.setBackground(new Color(7, 41, 120));
        btnLogIn.setBounds(28, 293, 146, 27);
        panelRight.add(btnLogIn);

        JButton btnSignUp = new JButton("SIGN UP");
     
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorder(new LineBorder(Color.WHITE));
        btnSignUp.setBackground(new Color(7, 41, 120));
        btnSignUp.setBounds(198, 293, 146, 27);
        panelRight.add(btnSignUp);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(69, 214, 224, 27);
        panelRight.add(separator);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\user.png"));
        lblNewLabel.setBounds(28, 112, 46, 57);
        panelRight.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(".\\.\\img\\candado4.png"));
        lblNewLabel_1.setBounds(28, 170, 46, 57);
        panelRight.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(64, 130, 253));
        panel_1.setBounds(0, 0, 354, 407);
        panel.add(panel_1);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(27, 74, 300, 250);
        panel_1.add(lblLogo);

        // Listener para el inicio de sesión
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(email, password)) {  // Autenticar el usuario
                    System.out.println("Inicio de sesión exitoso. DNI: " + usuarioDNI);  // Mensaje de depuración
                    new Juego(usuarioDNI).setVisible(true);  // Mostrar la ventana de Juego
                    dispose();  // Cerrar la ventana de inicio de sesión
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Configuración adicional del JFrame
    

        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new singup().setVisible(true);
                dispose();
            }
        });
    }

    // Método para autenticar usuario
private boolean authenticate(String email, String password) {
    boolean isValid = false;
    try {
        Connection conn = ConexionBD.getConnection();  // Usar la clase de conexión
        String query = "SELECT DNI FROM PERSONA WHERE EMAIL = ? AND CONTRASEÑA = ?";
        PreparedStatement ps = conn.prepareCall(query);
        ps.setString(1, email);  
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
            isValid = true;  
            usuarioDNI = rs.getString("DNI");  // Capturar el DNI del usuario autenticado
        }

        rs.close();
        ps.close();
        conn.close();

    } catch (SQLException ex) {
        ex.fillInStackTrace();
    }

    return isValid;
}
}

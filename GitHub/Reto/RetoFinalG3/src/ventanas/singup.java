package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;

public class singup extends JFrame {

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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    singup frame = new singup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public singup() {
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
        lblLogo.setBounds(50, 125, 300, 250); // Centrado en la parte izquierda
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

        JSeparator separator = new JSeparator();
        separator.setBounds(50, 57, 300, 2);
        panel_1.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(50, 107, 300, 2);
        panel_1.add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(50, 157, 300, 2);
        panel_1.add(separator_2);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(50, 207, 300, 2);
        panel_1.add(separator_3);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(50, 257, 300, 2);
        panel_1.add(separator_4);

        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(50, 307, 300, 2);
        panel_1.add(separator_5);

        JSeparator separator_6 = new JSeparator();
        separator_6.setBounds(50, 357, 300, 2);
        panel_1.add(separator_6);

        btnRegistrarse = new JButton("REGISTRARSE");
        btnRegistrarse.setForeground(new Color(255, 255, 255));
        btnRegistrarse.setBackground(new Color(7, 41, 120)); 
        btnRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnRegistrarse.setBounds(50, 447, 150, 27);
        panel_1.add(btnRegistrarse);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDNI.getText();
                String direccion = txtDireccion.getText();
                String email = txtEmail.getText();
                String password = new String(passwordField.getPassword());
                String confirmarPassword = new String(passwordFieldConfirmar.getPassword());
                
             
            }
        });

        btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(7, 41, 120)); 
        btnLogin.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnLogin.setBounds(250, 447, 100, 27);
        panel_1.add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("Hacerse Premium (19,99$)");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(61, 392, 150, 27);
        panel_1.add(lblNewLabel);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setForeground(new Color(0, 0, 255));
        chckbxNewCheckBox.setBounds(250, 392, 29, 27);
        chckbxNewCheckBox.setOpaque(false);
        panel_1.add(chckbxNewCheckBox);
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
        textField.setBackground(new Color(7, 41, 120)); // Color ajustado
        textField.setBorder(null);
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
        passwordField.setBackground(new Color(7, 41, 120)); // Color ajustado
        passwordField.setText(defaultText);
        passwordField.setBorder(null);
        passwordField.setBounds(x, y, width, height);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText = new String(passwordField.getPassword());
                if (passwordText.equals(defaultText)) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }
        });
        return passwordField;
    }
}

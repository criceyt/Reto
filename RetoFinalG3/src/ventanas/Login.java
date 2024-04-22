package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField jpassword;
    private JTextField txtNombre;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtDireccion;
    private JTextField txtEmail;

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
        setBounds(100, 100, 738, 564);

     
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(5, 5, 712, 510);
        contentPane.add(tabbedPane);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("New tab", null, panel, null);
        panel.setLayout(null);
        
        JPanel panelRight_1 = new JPanel((LayoutManager) null);
        panelRight_1.setBackground(new Color(7, 41, 120));
        panelRight_1.setBounds(353, 0, 354, 492);
        panel.add(panelRight_1);
        
        txtUsername = new JTextField();
        txtUsername.setText("Email");
        txtUsername.setForeground(Color.LIGHT_GRAY);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtUsername.setBorder(null);
        txtUsername.setBackground(new Color(7, 41, 120));
        txtUsername.setBounds(85, 156, 218, 27);
        panelRight_1.add(txtUsername);
        txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtUsername.getText().equals("Email")) {
                	txtUsername.setText("");
                	txtUsername.setForeground(Color.WHITE);
                }
            }
        });
        
        jpassword = new JPasswordField();
        jpassword.setToolTipText("");
        jpassword.setText("Password");
        jpassword.setForeground(Color.LIGHT_GRAY);
        jpassword.setBorder(null);
        jpassword.setBackground(new Color(7, 41, 120));
        jpassword.setBounds(85, 216, 218, 27);
        panelRight_1.add(jpassword);
        jpassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText = new String(jpassword.getPassword());
                if (passwordText.equals("Password")) {
                	jpassword.setText("");
                	jpassword.setForeground(Color.WHITE);
                }
            }
        });
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(85, 185, 224, 2);
        panelRight_1.add(separator_2);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(85, 248, 218, 2);
        panelRight_1.add(separator_1_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\WS\\RetoFinalG3\\img\\candado4.png"));
        lblNewLabel_2.setBounds(41, 202, 51, 48);
        panelRight_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\WS\\RetoFinalG3\\img\\user.png"));
        lblNewLabel_1_1.setBounds(41, 149, 60, 48);
        panelRight_1.add(lblNewLabel_1_1);
        
        JButton btnLogIn_1 = new JButton("LOG IN");
        btnLogIn_1.setForeground(Color.WHITE);
        btnLogIn_1.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnLogIn_1.setBackground(new Color(7, 41, 120));
        btnLogIn_1.setBounds(123, 291, 146, 27);
        panelRight_1.add(btnLogIn_1);
        
        JPanel panelLeft_1 = new JPanel();
        panelLeft_1.setBounds(0, 0, 391, 492);
        panel.add(panelLeft_1);
        panelLeft_1.setLayout(null);
        panelLeft_1.setPreferredSize(new Dimension(381, 0));
        panelLeft_1.setBackground(new Color(64, 130, 253));
        
        JLabel lblNewLabel_3_1 = new JLabel("", SwingConstants.CENTER);
        lblNewLabel_3_1.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
        lblNewLabel_3_1.setBounds(46, 111, 244, 220);
        panelLeft_1.add(lblNewLabel_3_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(null);
        tabbedPane.addTab("New tab", null, panel_1, null);
        panel_1.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, -16, 336, 500);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(64, 130, 253));
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\WS\\RetoFinalG3\\img\\logo_G3_2.PNG"));
        lblLogo.setBounds(12, 127, 300, 250);
        panel_2.add(lblLogo);
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(317, -16, 437, 500);
        panel_1.add(panel_1_1);
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(7, 41, 120));
        
        txtNombre = new JTextField();
        txtNombre.setText("Nombre");
        txtNombre.setForeground(Color.LIGHT_GRAY);
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtNombre.setBorder(null);
        txtNombre.setBackground(new Color(7, 41, 120));
        txtNombre.setBounds(63, 43, 300, 27);
        panel_1_1.add(txtNombre);
        txtNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNombre.getText().equals("Nombre")) {
                	txtNombre.setText("");
                	txtNombre.setForeground(Color.WHITE);
                }
            }
        });
        
        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setText("Password");
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setBorder(null);
        passwordField.setBackground(new Color(7, 41, 120));
        passwordField.setBounds(63, 280, 300, 27);
        panel_1_1.add(passwordField);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText1 = new String(passwordField.getPassword());
                if (passwordText1.equals("Password")) {
                	passwordField.setText("");
                	passwordField.setForeground(Color.WHITE);
                }
            }
        });
        
        passwordField2 = new JPasswordField();
        passwordField2.setToolTipText("");
        passwordField2.setText("PasswordField");
        passwordField2.setForeground(Color.LIGHT_GRAY);
        passwordField2.setBorder(null);
        passwordField2.setBackground(new Color(7, 41, 120));
        passwordField2.setBounds(63, 318, 300, 27);
        panel_1_1.add(passwordField2);
        passwordField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText2 = new String(passwordField2.getPassword());
                if (passwordText2.equals("PasswordField")) {
                	passwordField2.setText("");
                	passwordField2.setForeground(Color.WHITE);
                }
            }
        });
        
        JSeparator separator = new JSeparator();
        separator.setBounds(63, 70, 300, 2);
        panel_1_1.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(63, 113, 300, 2);
        panel_1_1.add(separator_1);
        
        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(63, 157, 300, 2);
        panel_1_1.add(separator_2_1);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(63, 207, 300, 2);
        panel_1_1.add(separator_3);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(63, 257, 300, 2);
        panel_1_1.add(separator_4);
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(63, 307, 300, 2);
        panel_1_1.add(separator_5);
        
        JSeparator separator_6 = new JSeparator();
        separator_6.setBounds(63, 357, 300, 2);
        panel_1_1.add(separator_6);
        
        JCheckBox hacersePremium = new JCheckBox("");
        hacersePremium.setOpaque(false);
        hacersePremium.setForeground(Color.BLUE);
        hacersePremium.setBounds(263, 392, 29, 27);
        panel_1_1.add(hacersePremium);
        
        JButton btnRegistrarse = new JButton("REGISTRARSE");
        btnRegistrarse.setForeground(Color.WHITE);
        btnRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnRegistrarse.setBackground(new Color(7, 41, 120));
        btnRegistrarse.setBounds(63, 447, 150, 27);
        panel_1_1.add(btnRegistrarse);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!hacersePremium.isSelected()) {
            		JOptionPane.showMessageDialog(null, "Tu Registro ha sido completado con exito","BIENVENIDO" , JOptionPane.INFORMATION_MESSAGE);
            	}else {
            		VentanaDatosBancarios ventanaNueva=new VentanaDatosBancarios();
            		ventanaNueva.setVisible(true);
            	}
            	
				
			}
            }	
        );
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnLogin.setBackground(new Color(7, 41, 120));
        btnLogin.setBounds(263, 447, 100, 27);
        panel_1_1.add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("Hacerse Premium (19,99$)");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(74, 392, 150, 27);
        panel_1_1.add(lblNewLabel);
        
        
        txtApellido = new JTextField();
        txtApellido.setText("Apellido");
        txtApellido.setForeground(Color.LIGHT_GRAY);
        txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtApellido.setBorder(null);
        txtApellido.setBackground(new Color(7, 41, 120));
        txtApellido.setBounds(63, 93, 300, 19);
        panel_1_1.add(txtApellido);
        txtApellido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtApellido.getText().equals("Apellido")) {
                	txtApellido.setText("");
                	txtApellido.setForeground(Color.WHITE);
                }
            }
        });
        
        txtDni = new JTextField();
        txtDni.setText("DNI");
        txtDni.setForeground(Color.LIGHT_GRAY);
        txtDni.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtDni.setBorder(null);
        txtDni.setBackground(new Color(7, 41, 120));
        txtDni.setBounds(63, 132, 300, 19);
        panel_1_1.add(txtDni);
        txtDni.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtDni.getText().equals("DNI")) {
                	txtDni.setText("");
                	txtDni.setForeground(Color.WHITE);
                }
            }
        });
        
        txtDireccion = new JTextField();
        txtDireccion.setText("Direccion");
        txtDireccion.setForeground(Color.LIGHT_GRAY);
        txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtDireccion.setBorder(null);
        txtDireccion.setBackground(new Color(7, 41, 120));
        txtDireccion.setBounds(63, 182, 300, 19);
        panel_1_1.add(txtDireccion);
        txtDireccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtDireccion.getText().equals("Direccion")) {
                	txtDireccion.setText("");
                	txtDireccion.setForeground(Color.WHITE);
                }
            }
        });
        
        txtEmail = new JTextField();
        txtEmail.setText("Email");
        txtEmail.setForeground(Color.LIGHT_GRAY);
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEmail.setBorder(null);
        txtEmail.setBackground(new Color(7, 41, 120));
        txtEmail.setBounds(63, 231, 300, 19);
        panel_1_1.add(txtEmail);
        txtEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtEmail.getText().equals("Email")) {
                	txtEmail.setText("");
                	txtEmail.setForeground(Color.WHITE);
                }
            }
        });
        
        
    }
}

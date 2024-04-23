package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JButton btnSingUp;
    private JButton btnLogIn;

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
        setBounds(100, 100, 738, 376);

     
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

      
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(64, 130, 253));
        panelLeft.setPreferredSize(new Dimension(381, 0)); 
        contentPane.add(panelLeft, BorderLayout.WEST);
        panelLeft.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("", SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 49, 381, 278);
        lblNewLabel_3.setIcon(new ImageIcon(".\\.\\img\\logo_G3_2.PNG"));
        panelLeft.add(lblNewLabel_3);

       
        JPanel panelRight = new JPanel(null);
        panelRight.setBackground(new Color(7, 41, 120)); 
        contentPane.add(panelRight, BorderLayout.CENTER);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtUsername.setForeground(new Color(192, 192, 192));
        txtUsername.setText("Email");
        txtUsername.setBackground(new Color(7, 41, 120));
        txtUsername.setBorder(null);
        txtUsername.setBounds(91, 77, 218, 27);
        panelRight.add(txtUsername);
        txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtUsername.getText().equals("Email")) {
                	txtUsername.setText("");
                	txtUsername.setForeground(Color.WHITE);
                }
            }
        });

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(192, 192, 192));
        passwordField.setToolTipText("");
        passwordField.setBackground(new Color(7, 41, 120));
        passwordField.setText("Password");
        passwordField.setBorder(null);
        passwordField.setBounds(91, 137, 218, 27);
        panelRight.add(passwordField);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String passwordText = new String(passwordField.getPassword());
                if (passwordText.equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                }
            }
        });

        JSeparator separator = new JSeparator();
        separator.setBounds(91, 106, 224, 2);
        panelRight.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(91, 169, 218, 2);
        panelRight.add(separator_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\candado4.png"));
        lblNewLabel.setBounds(50, 133, 51, 48);
        panelRight.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(".\\.\\img\\user.png"));
        lblNewLabel_1.setBounds(50, 66, 60, 48);
        panelRight.add(lblNewLabel_1);

        btnSingUp = new JButton("SING UP");
        btnSingUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
				singup entrarRegistrarse = new singup();
				entrarRegistrarse.setVisible(true);
        		
        	}
        });
        btnSingUp.setForeground(Color.WHITE);
        btnSingUp.setBackground(new Color(7, 41, 120));
        btnSingUp.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnSingUp.setBounds(186, 214, 111, 27);
        panelRight.add(btnSingUp);

        btnLogIn = new JButton("LOG IN");
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setBackground(new Color(7, 41, 120)); 
        btnLogIn.setBorder(new LineBorder(new Color(255, 255, 255)));
        btnLogIn.setBounds(50, 214, 111, 27);
        panelRight.add(btnLogIn);
        	

        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	char[] clave = passwordField.getPassword();
				String claveFinal = new String(clave);
				
				if(txtUsername.getText().equals("urkizu.oier@gmail.com") && claveFinal.equals("1234")) {
					dispose();
					MenuAdmin entrarAdmin = new MenuAdmin();
					entrarAdmin.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto" , "ERROR" , 
							JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				}
				
			}
            }
        );

        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acciones al presionar SIGN UP
            }
        });
    }
}

package ventanas;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class MenuAdmin extends JFrame {
	private JTextField txtBuscar;
    public MenuAdmin() {
      
        setTitle("Menu Trabajador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(711, 434); 
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
        panel.setBounds(0, 0, 686, 437);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
   
        ImageIcon logoIcon = new ImageIcon(".\\.\\img\\logo_G3_2.PNG");

    
        Color lineColor = new Color(255, 255, 255, 150); 
    

        // Botón de enviar
        JButton enviarButton = new JButton("Insertar Juego");
        enviarButton.setBounds(40, 135, 190, 38);
        enviarButton.setBackground(new Color(255, 102, 102)); 
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        getContentPane().setLayout(null);
        panel.setLayout(null);
        panel.add(enviarButton);

        
        getContentPane().add(panel);
        
        JButton btnStock = new JButton("Stock");
        btnStock.setBounds(40, 184, 190, 38);
        btnStock.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnStock.setBackground(new Color(255, 102, 102));
        panel.add(btnStock);
        
        JButton enviarButton_2_1 = new JButton("Gestionar Clientes");
        enviarButton_2_1.setBounds(40, 232, 190, 38);
        enviarButton_2_1.setBackground(new Color(255, 102, 102));
        panel.add(enviarButton_2_1);
        
        JLabel lblNewLabel_1 = new JLabel("Bienvenido Trabajador ");
        lblNewLabel_1.setBounds(40, 94, 217, 30);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("alguien.trabajador@gmail.com");
        lblNewLabel_2.setBounds(354, 284, 297, 30);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        panel.add(lblNewLabel_2);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 696, 59);
        panel_1.setBackground(new Color(30, 30, 90));
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        txtBuscar = new JTextField();
        txtBuscar.setFont(new Font("Times New Roman", Font.BOLD, 11));
        txtBuscar.setForeground(new Color(255, 255, 255));
        txtBuscar.setText("Buscar");
        txtBuscar.setBorder(null);
        txtBuscar.setBounds(10, 15, 175, 27);
        panel_1.add(txtBuscar);
        txtBuscar.setOpaque(false);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscar.setColumns(10);
        
        JButton enviarButton_1 = new JButton("Buscar");
        enviarButton_1.setBounds(195, 15, 95, 27);
        panel_1.add(enviarButton_1);
        enviarButton_1.setBackground(new Color(255, 102, 102));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(50, 50, 150));
        panel_2.setBounds(310, -5, 95, 65);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(8, 0, 80, 82);
        lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
        panel_2.add(lblNewLabel_3);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(255, 128, 128));
        separator_1.setBounds(10, 43, 179, 17);
        panel_1.add(separator_1);
        
        JButton enviarButton_1_1 = new JButton("Inicio");
        enviarButton_1_1.setDefaultCapable(false);
        enviarButton_1_1.setActionCommand("Inicio");
        enviarButton_1_1.setBackground(new Color(255, 102, 102));
        enviarButton_1_1.setBounds(555, 15, 95, 27);
        panel_1.add(enviarButton_1_1);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 255, 255));
        separator.setBounds(0, 60, 686, 8);
        panel.add(separator);
        
        JButton enviarButton_2_1_1 = new JButton("Insertar Trabajadores");
        enviarButton_2_1_1.setBackground(new Color(255, 102, 102));
        enviarButton_2_1_1.setBounds(40, 281, 190, 38);
        panel.add(enviarButton_2_1_1);
        
        JButton enviarButton_2_1_1_1 = new JButton("Insertar Proovedores");
        enviarButton_2_1_1_1.setBackground(new Color(255, 102, 102));
        enviarButton_2_1_1_1.setBounds(40, 330, 190, 38);
        panel.add(enviarButton_2_1_1_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\CU-6.png"));
        lblNewLabel.setBounds(412, 94, 190, 179);
        panel.add(lblNewLabel);

        setVisible(true); 
        
        
    }

    


    public static void main(String[] args) {
    	
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin();
            }
        });
    }
}


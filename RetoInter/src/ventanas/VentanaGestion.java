package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class VentanaGestion extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JLabel lblNewLabel_2_6;
    private JLabel lblNewLabel_2_7;
    private JLabel lblNewLabel_2_8;
    private JLabel lblNewLabel_2_10;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_11;
    private JLayeredPane layeredPane_2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaGestion frame = new VentanaGestion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaGestion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 823, 396);

     
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

      
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(64, 130, 253));
        panelLeft.setPreferredSize(new Dimension(381, 0)); 
        contentPane.add(panelLeft, BorderLayout.WEST);
        panelLeft.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Dni :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(72, 57, 46, 23);
        panelLeft.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField.setSelectedTextColor(new Color(255, 255, 255));
        textField.setDisabledTextColor(new Color(0, 0, 0));
        textField.setForeground(new Color(0, 0, 0));
        textField.setEditable(false);
        textField.setBackground(new Color(64, 130, 253));
        textField.setBounds(172, 60, 144, 20);
        panelLeft.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel("Nombre :");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_1.setBounds(72, 91, 68, 23);
        panelLeft.add(lblNewLabel_2_1);
        
        textField_1 = new JTextField();
        textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_1.setSelectedTextColor(new Color(0, 0, 0));
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBackground(new Color(64, 130, 253));
        textField_1.setBounds(172, 94, 144, 20);
        panelLeft.add(textField_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Direccion :");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_2.setBounds(72, 159, 80, 23);
        panelLeft.add(lblNewLabel_2_2);
        
        textField_2 = new JTextField();
        textField_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBackground(new Color(64, 130, 253));
        textField_2.setBounds(172, 159, 144, 20);
        panelLeft.add(textField_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Apellido :");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_3.setBounds(72, 125, 80, 23);
        panelLeft.add(lblNewLabel_2_3);
        
        textField_3 = new JTextField();
        textField_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBackground(new Color(64, 130, 253));
        textField_3.setBounds(172, 125, 144, 20);
        panelLeft.add(textField_3);
        
        JLabel lblNewLabel_2_4 = new JLabel("Fecha Nac :");
        lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_4.setBounds(72, 193, 99, 23);
        panelLeft.add(lblNewLabel_2_4);
        
        textField_4 = new JTextField();
        textField_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBackground(new Color(64, 130, 253));
        textField_4.setBounds(172, 190, 144, 20);
        panelLeft.add(textField_4);
        
        JLabel lblNewLabel_2_5 = new JLabel("Email :");
        lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_5.setBounds(72, 227, 58, 23);
        panelLeft.add(lblNewLabel_2_5);
        
        textField_5 = new JTextField();
        textField_5.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBackground(new Color(64, 130, 253));
        textField_5.setBounds(172, 221, 144, 20);
        panelLeft.add(textField_5);
        
        JLabel lblNewLabel = new JLabel("Datos Cliente");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblNewLabel.setBounds(72, 11, 128, 35);
        panelLeft.add(lblNewLabel);
        
        layeredPane_2 = new JLayeredPane();
        layeredPane_2.setBounds(333, 147, 1, 1);
        panelLeft.add(layeredPane_2);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(10, 261, 117, 102);
        panelLeft.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon(VentanaGestion.class.getResource("/imagenes/logo_G3_3.PNG")));

       
        JPanel panelRight = new JPanel(null);
        panelRight.setBackground(new Color(7, 41, 120)); 
        contentPane.add(panelRight, BorderLayout.CENTER);
        
        JLabel lblModificacionDatos = new JLabel("Modificacion Datos");
        lblModificacionDatos.setForeground(new Color(255, 255, 255));
        lblModificacionDatos.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblModificacionDatos.setBounds(79, 11, 204, 35);
        panelRight.add(lblModificacionDatos);
        
        lblNewLabel_2_6 = new JLabel("Nombre :");
        lblNewLabel_2_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_6.setBounds(92, 99, 68, 23);
        panelRight.add(lblNewLabel_2_6);
        
        lblNewLabel_2_7 = new JLabel("Direccion :");
        lblNewLabel_2_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_7.setBounds(92, 161, 84, 23);
        panelRight.add(lblNewLabel_2_7);
        
        lblNewLabel_2_8 = new JLabel("Apellido :");
        lblNewLabel_2_8.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_8.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_8.setBounds(92, 130, 80, 23);
        panelRight.add(lblNewLabel_2_8);
        
        lblNewLabel_2_10 = new JLabel("Email :");
        lblNewLabel_2_10.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_10.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_10.setBounds(92, 195, 58, 23);
        panelRight.add(lblNewLabel_2_10);
        
        textField_7 = new JTextField();
        textField_7.setForeground(new Color(255, 255, 255));
        textField_7.setColumns(10);
        textField_7.setBackground(new Color(7, 41, 120));
        textField_7.setBounds(210, 102, 144, 20);
        panelRight.add(textField_7);
        
        textField_8 = new JTextField();
        textField_8.setForeground(new Color(255, 255, 255));
        textField_8.setColumns(10);
        textField_8.setBackground(new Color(7, 41, 120));
        textField_8.setBounds(210, 167, 144, 20);
        panelRight.add(textField_8);
        
        textField_9 = new JTextField();
        textField_9.setForeground(new Color(255, 255, 255));
        textField_9.setColumns(10);
        textField_9.setBackground(new Color(7, 41, 120));
        textField_9.setBounds(210, 133, 144, 20);
        panelRight.add(textField_9);
        
        textField_11 = new JTextField();
        textField_11.setForeground(new Color(255, 255, 255));
        textField_11.setColumns(10);
        textField_11.setBackground(new Color(7, 41, 120));
        textField_11.setBounds(210, 198, 144, 20);
        panelRight.add(textField_11);
        
        JButton btnNewButton = new JButton("Guardar y Salir");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(64, 130, 253));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton.setBounds(163, 274, 110, 42);
        panelRight.add(btnNewButton);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(new Color(255, 255, 255));
        btnLimpiar.setBackground(new Color(64, 130, 253));
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnLimpiar.setBounds(25, 274, 110, 42);
        panelRight.add(btnLimpiar);
        
        JButton btnNewButton_1 = new JButton("Salir ");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(64, 130, 253));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton_1.setBounds(296, 274, 110, 42);
        panelRight.add(btnNewButton_1);
    }
}

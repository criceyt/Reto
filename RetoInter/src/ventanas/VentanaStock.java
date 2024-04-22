package ventanas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VentanaStock extends JFrame {

    public VentanaStock() {
        setTitle("Introducir juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
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
        panel.setLayout(null);

        getContentPane().add(panel);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(466, 102, 226, 36);
        panel.add(comboBox);
        
        JLabel lblUnidades = new JLabel("Unidades");
        lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUnidades.setForeground(new Color(255, 255, 255));
        lblUnidades.setBounds(322, 97, 71, 41);
        panel.add(lblUnidades);
        
        JLabel lblBuscarJuego = new JLabel("Buscar Juego");
        lblBuscarJuego.setForeground(Color.WHITE);
        lblBuscarJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBuscarJuego.setBounds(135, 98, 98, 41);
        panel.add(lblBuscarJuego);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaStock();
            }
        });
    }
}

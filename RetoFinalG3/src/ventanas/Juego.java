package ventanas;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Juego extends JFrame {
    private JTextField txtBuscar;
    private JPanel panelTabla;

    public Juego() {
        setTitle("Menu Trabajador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Panel principal con diseño degradado
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(128, 0, 128)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(crearPanelSuperior(), gbc);

        GridBagConstraints gbcTabla = new GridBagConstraints(); // Nuevo GridBagConstraints para la tabla
        gbcTabla.fill = GridBagConstraints.BOTH;
        gbcTabla.gridx = 0;
        gbcTabla.gridy = 1;
        gbcTabla.weightx = 1.0;
        gbcTabla.weighty = 1.0;
        gbcTabla.anchor = GridBagConstraints.CENTER;
        panel.add(crearPanelTabla(), gbcTabla);

        setVisible(true);
    }

    private JPanel crearPanelSuperior() {
        JPanel panel_1 = new JPanel(new BorderLayout());
        panel_1.setBackground(new Color(30, 30, 90));

        txtBuscar = new JTextField("Buscar", 20);
        txtBuscar.setForeground(Color.WHITE);
        txtBuscar.setFont(new Font("Times New Roman", Font.BOLD, 11));
        txtBuscar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 0), // Ajuste de espacio a la izquierda del JTextField
                BorderFactory.createLineBorder(Color.WHITE))); // Borde blanco
        txtBuscar.setOpaque(false);
        txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(txtBuscar, BorderLayout.WEST);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(255, 128, 128));
        separator.setForeground(new Color(255, 128, 128));
        panel_1.add(separator, BorderLayout.SOUTH);

        JButton btnBuscar = new JButton("Inicio");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBuscar.setBackground(new Color(255, 102, 102));
        panel_1.add(btnBuscar, BorderLayout.EAST);

        JPanel panelLogo = new JPanel(new GridBagLayout());
        panelLogo.setOpaque(false);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alineación a la izquierda
        panelLogo.add(lblNewLabel_3, gbc);

        // Ajuste de espacio a la izquierda del panel de la imagen
        panelLogo.setBorder(BorderFactory.createEmptyBorder(0, -100, 0, 0)); // Se resta el espacio del JTextField

        panel_1.add(panelLogo, BorderLayout.CENTER);

        return panel_1;
    }




    private JScrollPane crearPanelTabla() {
        panelTabla = new JPanel(new GridLayout(0, 5, 10, 10)); // GridLayout con 5 columnas y sin límite de filas
        panelTabla.setOpaque(false); // Establecer el panel como transparente

        // Llenar la tabla con los datos de la base de datos
        try {
            Connection conn = ConexionBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT CARATULA, NOMBRE_JUEGO, PRECIO FROM JUEGO");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String rutaCaratula = rs.getString("CARATULA");
                String nombreJuego = rs.getString("NOMBRE_JUEGO");
                Float precio = rs.getFloat("PRECIO");
                agregarJuego(rutaCaratula, nombreJuego, precio);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(panelTabla);
        scrollPane.getViewport().setOpaque(false); // Establecer el viewport como transparente
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Hacer que el scrollPane sea transparente
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        return scrollPane;
    }

    private void agregarJuego(String rutaCaratula, String nombreJuego, double precio) {
        // Crear panel para la carátula, el nombre del juego y el precio
        JPanel panelJuego = new JPanel(new BorderLayout());
        panelJuego.setOpaque(false);

        // Cargar la carátula desde la ruta
        ImageIcon caratulaIcon = new ImageIcon(rutaCaratula);
        JLabel lblCaratula = new JLabel(caratulaIcon);
        lblCaratula.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaratula.setVerticalAlignment(SwingConstants.CENTER);
        panelJuego.add(lblCaratula, BorderLayout.CENTER);

        // Panel para el nombre del juego y el precio con un FlowLayout
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); // Ajustar el espacio horizontal a 5 y vertical a 0
        panelInfo.setOpaque(false);

        // Agregar el nombre del juego debajo de la carátula
        JLabel lblNombreJuego = new JLabel(nombreJuego);
        lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreJuego.setForeground(Color.WHITE); // Establecer el color de la fuente como blanco
        lblNombreJuego.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Cambiar la fuente y el tamaño
        panelInfo.add(lblNombreJuego);

        // Agregar el precio a la derecha del nombre del juego
        JLabel lblPrecio = new JLabel("     €" + String.format("%.2f", precio));
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrecio.setForeground(Color.WHITE); // Establecer el color de la fuente como blanco
        lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Cambiar la fuente y el tamaño
        panelInfo.add(lblPrecio);

        panelJuego.add(panelInfo, BorderLayout.SOUTH);

        // Agregar el panel del juego a la tabla
        panelTabla.add(panelJuego);

        // Actualizar la ventana para que se muestren los cambios
        revalidate();
        repaint();
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(Juego::new);
    }
}

package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoJuego extends JFrame {
	private JPanel panelTabla;
	private JLabel lblCaratula;
	private JLabel lblTitulo;
	private JTextArea txtDescripcion;
	private JButton btnPrecio;
	   private Juego ventanaJuego; // Referencia a la ventana Juego

	    // Constructor de InfoJuego
	    public InfoJuego(Juego ventanaJuego) {
	        this.ventanaJuego = ventanaJuego;
	        // Resto del código del constructor...
	    }

	    // Método setter para establecer la referencia a la ventana Juego
	    public void setVentanaJuego(Juego ventanaJuego) {
	        this.ventanaJuego = ventanaJuego;
	    }

	public InfoJuego() {
		setTitle("Información del Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700); // Ajustar la altura predeterminada a 700 píxeles
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout()); // Utilizar BorderLayout en el contenedor principal

		// Etiqueta para el fondo degradado
		JLabel fondo = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(128, 0, 128)));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		getContentPane().add(fondo, BorderLayout.CENTER);

		// Panel principal con disposición en capas para superponer componentes
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false); // Hacer el panel transparente
		fondo.setLayout(new OverlayLayout(fondo));
		fondo.add(panel);

		// Crear el panel superior y agregarlo al panel principal
		JPanel panelSuperior = crearPanelSuperior();
		panel.add(panelSuperior, BorderLayout.NORTH);

		panelTabla = new JPanel();
		panelTabla.setOpaque(false); // Establecer el panel como transparente
		panelTabla.setLayout(new BorderLayout());
		panel.add(panelTabla, BorderLayout.CENTER);

		setVisible(true);
	}

	private JPanel crearPanelSuperior() {
		JPanel panel_1 = new JPanel(new BorderLayout()); // Utilizando BorderLayout
		panel_1.setBackground(new Color(30, 30, 90));
		panel_1.setBorder(new EmptyBorder(0, 40, 0, 40)); // Margen vertical de 10px arriba y abajo, y margen lateral de
															// 40px

		// Utilizando un panel adicional para el logo con GridBagLayout para centrarlo
		JPanel panelLogo = new JPanel(new GridBagLayout());
		panelLogo.setOpaque(false);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\img\\logo_G3_Sin_Texto.PNG"));

		// Añadir el logo al centro del panel usando GridBagConstraints
		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.gridx = 0;
		gbcLogo.gridy = 0;
		gbcLogo.insets = new Insets(0, 220, 0, 0);
		gbcLogo.anchor = GridBagConstraints.CENTER;
		panelLogo.add(lblNewLabel, gbcLogo);

		panel_1.add(panelLogo, BorderLayout.CENTER);

		// Panel para los botones
		JPanel panelBotones = new JPanel(); // Utilizando el layout por defecto (FlowLayout)
		panelBotones.setOpaque(false);

		// Agregar "glue" vertical al principio del panel para centrar los botones
		// verticalmente
		panelBotones.add(Box.createVerticalGlue());

		JButton btnBuscar = new JButton("Inicio");
		btnBuscar.setMargin(new Insets(0, 26, 0, 26));
		btnBuscar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBuscar.setBackground(new Color(255, 102, 102));
		btnBuscar.setPreferredSize(new Dimension(100, 46)); // Establecer el tamaño del botón
		btnBuscar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        // Acción del botón "Inicio"
			        Juego juego = new Juego();
			        juego.setVisible(true);
			        dispose(); 
		    }
		});


		JButton btnBuscar_1 = new JButton("Biblioteca");
		btnBuscar_1.setMargin(new Insets(2, 13, 2, 13));
		btnBuscar_1.setBackground(new Color(255, 102, 102));
		btnBuscar_1.setPreferredSize(new Dimension(100, 46)); // Establecer el tamaño del botón
		panelBotones.add(btnBuscar_1);
		panelBotones.add(btnBuscar);

		panel_1.add(panelBotones, BorderLayout.EAST);

		return panel_1;
	}

	// Método para actualizar la información del juego
	public void actualizarInfoJuego(String rutaCaratula, String titulo, String descripcion, double precio) {
		// Limpiar el panel de información del juego
		panelTabla.removeAll();

		// Panel para la información del juego con layout absoluto
		JPanel panelInfoJuego = new JPanel(null); // Utilizando AbsoluteLayout
		panelInfoJuego.setOpaque(false); // Hacer el panel transparente

		// Carátula del juego
		ImageIcon iconoCaratula = new ImageIcon(rutaCaratula);
		lblCaratula = new JLabel(iconoCaratula);
		lblCaratula.setBounds(20, 20, 300, 400); // Establecer posición y tamaño absolutos
		panelInfoJuego.add(lblCaratula);

		// Título del juego
		lblTitulo = new JLabel(titulo);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(350, 20, 400, 30); // Establecer posición y tamaño absolutos
		panelInfoJuego.add(lblTitulo);

		// Botón de precio
		btnPrecio = new JButton("€" + String.format("%.2f", precio));
		btnPrecio.setBackground(new Color(255, 102, 102));
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setFont(new Font("Arial", Font.BOLD, 18));
		btnPrecio.setBounds(100, 450, 150, 40); // Establecer posición y tamaño absolutos
		panelInfoJuego.add(btnPrecio);

		// Descripción del juego
		txtDescripcion = new JTextArea(descripcion);
		txtDescripcion.setOpaque(false); // Hacer el área de texto transparente
		txtDescripcion.setForeground(Color.WHITE);
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(340, 100, 500, 250); // Establecer posición y tamaño absolutos
		panelInfoJuego.add(txtDescripcion);

		// Agregar el panel de información del juego al panel de tabla
		panelTabla.add(panelInfoJuego, BorderLayout.CENTER);

		// Actualizar la ventana para que se muestren los cambios
		revalidate();
		repaint();
	}
}

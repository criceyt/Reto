package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Juego extends JFrame {
	private JTextField txtBuscar;
	private JPanel panelTabla;
	private JScrollPane scrollPane;
	private JPanel panelBotones;
	private JPanel panelLogo;
	private InfoJuego infoJuego;
	private String usuarioDNI; // Almacena el DNI del usuario

	public Juego(String usuarioDNI) {
		this.usuarioDNI = usuarioDNI; // Guardar el usuarioDNI para uso posterior
		// Configurar la ventana
		setTitle("Catálogo de Juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setVisible(true);

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

	public Juego() {
		// TODO Auto-generated constructor stub
	}

	private JPanel crearPanelSuperior() {
		JPanel panel_1 = new JPanel(new BorderLayout()); // Utilizando BorderLayout
		panel_1.setBackground(new Color(30, 30, 90));
		panel_1.setBorder(new EmptyBorder(0, 40, 0, 40)); // Margen vertical de 10px arriba y abajo, y margen lateral de
															// 40px

		txtBuscar = new JTextField("Buscar", 15);
		txtBuscar.setMinimumSize(new Dimension(7, 0));
		txtBuscar.setForeground(Color.WHITE);
		txtBuscar.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		txtBuscar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192))); // Borde blanco
		txtBuscar.setBackground(new Color(30, 30, 90)); // Fondo no transparente
		txtBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el texto ingresado en el JTextField
				String textoBusqueda = txtBuscar.getText().trim();

				// Realizar la búsqueda en la base de datos
				buscarJuego(textoBusqueda);
			}
		});

		// Establecer tamaño específico para el JTextField
		Dimension textFieldSize = txtBuscar.getPreferredSize();
		textFieldSize.height = -10; // Modificar la altura a un valor más pequeño
		txtBuscar.setPreferredSize(new Dimension(120, 0)); // Aplicar el nuevo tamaño

		// Agregar un borde inferior al campo de texto
		txtBuscar.setBorder(BorderFactory.createCompoundBorder(txtBuscar.getBorder(),
				BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE)));

		// Crear un panel para agregar un margen entre el panel superior y el JTextField
		JPanel panelTextField = new JPanel(new BorderLayout());
		panelTextField.setOpaque(false);
		panelTextField.setBorder(new EmptyBorder(0, 0, 5, 0)); // Margen de 5px en la parte inferior del JTextField

		panelTextField.add(txtBuscar, BorderLayout.CENTER); // Agregar el JTextField al panel con un margen inferior

		panel_1.add(panelTextField, BorderLayout.WEST); // Agregar el panel con el JTextField al panel superior

		// Utilizando un panel adicional para el logo con GridBagLayout para centrarlo
		panelLogo = new JPanel(new GridBagLayout());
		panelLogo.setOpaque(false);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));

		// Añadir el logo al centro del panel usando GridBagConstraints
		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.gridx = 0;
		gbcLogo.gridy = 0;
		gbcLogo.insets = new Insets(0, -100, 0, 0); // Ajuste de margen derecho
		gbcLogo.anchor = GridBagConstraints.CENTER;
		panelLogo.add(lblNewLabel, gbcLogo);

		panel_1.add(panelLogo, BorderLayout.CENTER);

		panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(120, 10));
		panelBotones.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Layout vertical

		// Agregar "glue" vertical al principio del panel para centrar los botones
		// verticalmente
		panelBotones.add(Box.createVerticalGlue());

		JButton btnBuscar = new JButton("Inicio");
		btnBuscar.setMargin(new Insets(0, 34, 0, 34));
		btnBuscar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBuscar.setBackground(new Color(255, 102, 102));
		btnBuscar.setPreferredSize(new Dimension(100, 35)); // Establecer el tamaño del botón
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción del botón "Inicio"
				restablecerVistaOriginal();
			}
		});
		panelBotones.add(btnBuscar);

		JButton btnBuscar_2 = new JButton("Cerrar sesion");
		btnBuscar_2.setPreferredSize(new Dimension(100, 36));
		btnBuscar_2.setMargin(new Insets(0, 10, 0, 10));
		btnBuscar_2.setBackground(new Color(255, 102, 102));
		btnBuscar_2.setAlignmentY(0.0f);
		panelBotones.add(btnBuscar_2);

		JButton btnBuscar_1 = new JButton("Biblioteca");
		btnBuscar_1.setMargin(new Insets(0, 21, 0, 21));
		btnBuscar_1.setBackground(new Color(255, 102, 102));
		btnBuscar_1.setPreferredSize(new Dimension(100, 35)); // Establecer el tamaño del botón
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Biblioteca biblioteca = new Biblioteca(usuarioDNI); // Pasar el usuarioDNI a la ventana Biblioteca
				biblioteca.setVisible(true); // Mostrar la ventana de biblioteca
				dispose(); // Cerrar la ventana actual
			}
		});

		panelBotones.add(btnBuscar_1);

		panel_1.add(panelBotones, BorderLayout.EAST);

		return panel_1;
	}

	private JScrollPane crearPanelTabla() {
		panelTabla = new JPanel(new GridLayout(0, 5, 10, 10)); // GridLayout con 5 columnas y sin límite de filas
		panelTabla.setOpaque(false); // Establecer el panel como transparente

		// Llenar la tabla con los datos de la base de datos
		try {
			Connection conn = ConexionBD.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT CARATULA, NOMBRE_JUEGO, PRECIO, DESCRIPCION FROM JUEGO");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String rutaCaratula = rs.getString("CARATULA");
				String nombreJuego = rs.getString("NOMBRE_JUEGO");
				String descripcion = rs.getString("DESCRIPCION");
				double precio = rs.getFloat("PRECIO");
				agregarJuego(panelBotones, rutaCaratula, nombreJuego, precio, descripcion);
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

	private void agregarJuego(JPanel nuevoPanelTabla, String rutaCaratula, String nombreJuego, double precio,
			String descripcion) {
		// Crear panel para la carátula, el nombre del juego y el precio
		JPanel panelJuego = new JPanel(new BorderLayout());
		panelJuego.setOpaque(false);

		// Crear botón para la carátula
		JButton btnCaratula = new JButton();
		btnCaratula.setBorderPainted(false); // Quitar el borde del botón
		btnCaratula.setContentAreaFilled(false); // Hacer que el área de contenido del botón sea transparente
		btnCaratula.setFocusPainted(false); // Quitar el efecto de foco del botón
		btnCaratula.setIcon(new ImageIcon(rutaCaratula)); // Establecer la carátula como icono del botón
		btnCaratula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción al hacer clic en la carátula del juego
				abrirVentanaJuego(rutaCaratula, nombreJuego, precio, descripcion); // Abre la ventana correspondiente al
																					// juego seleccionado
			}
		});
		panelJuego.add(btnCaratula, BorderLayout.CENTER);

		// Panel para el nombre del juego y el precio con un FlowLayout
		JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); // Ajustar el espacio horizontal a 5 y
																				// vertical a 0
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

	// Evitar cerrar la ventana actual
	private void abrirVentanaJuego(String rutaCaratula, String nombreJuego, double precio, String descripcion) {
		if (infoJuego == null) {
			infoJuego = new InfoJuego(); // Crear o reutilizar la ventana de información
		}
		infoJuego.actualizarInfoJuego(rutaCaratula, nombreJuego, descripcion, precio, usuarioDNI);
		infoJuego.setVisible(true); // Mostrar la nueva ventana
	}

	void restablecerVistaOriginal() {
		// Limpiar el panel de la tabla antes de agregar los juegos originales
		panelTabla.removeAll();

		try {
			Connection conn = ConexionBD.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT CARATULA, NOMBRE_JUEGO, PRECIO, DESCRIPCION FROM JUEGO");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String rutaCaratula = rs.getString("CARATULA");
				String nombreJuego = rs.getString("NOMBRE_JUEGO");
				String descripcion = rs.getString("DESCRIPCION");
				double precio = rs.getDouble("PRECIO");
				agregarJuego(panelTabla, rutaCaratula, nombreJuego, precio, descripcion);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Actualizar la ventana para que se muestren los cambios
		revalidate();
		repaint();
	}

	private void buscarJuego(String textoBusqueda) {
		panelTabla.removeAll(); // Limpiar el panel antes de agregar nuevos resultados

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT CARATULA, NOMBRE_JUEGO, PRECIO, DESCRIPCION FROM JUEGO WHERE NOMBRE_JUEGO LIKE ?")) {

			stmt.setString(1, "%" + textoBusqueda + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String rutaCaratula = rs.getString("CARATULA");
				String nombreJuego = rs.getString("NOMBRE_JUEGO");
				String descripcion = rs.getString("DESCRIPCION");
				double precio = rs.getDouble("PRECIO");
				agregarJuego(panelTabla, rutaCaratula, nombreJuego, precio, descripcion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		revalidate();
		repaint(); // Actualizar la interfaz después de cambios
	}

}

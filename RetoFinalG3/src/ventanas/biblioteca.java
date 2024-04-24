package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class Biblioteca extends JFrame {
	private JTextField txtBuscar;
	private JPanel panelTabla;
	private JScrollPane scrollPane;
	private JPanel panelBotones;
	private JPanel panelLogo;
	private InfoJuego infoJuego;
	private String usuarioDNI; // Almacena el DNI del usuario
	private JFrame ventanaPrincipal;
	private JLabel focoInvisible;

	public Biblioteca(String usuarioDNI) {

		this.usuarioDNI = usuarioDNI; // Guarda el DNI del usuario

		setTitle("Catálogo de Juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Hacer que la ventana se abra en pantalla completa
		setLocationRelativeTo(null); // Centrar la ventana en la pantalla

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

		GridBagConstraints gbcTabla = new GridBagConstraints();
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
		JPanel panel_1 = new JPanel(new BorderLayout()); // Utilizando BorderLayout
		panel_1.setBackground(new Color(30, 30, 90));
		panel_1.setBorder(new EmptyBorder(0, 40, 0, 40)); // Márgenes

		// Campo de búsqueda
		txtBuscar = new JTextField("Buscar", 15);
		txtBuscar.setMinimumSize(new Dimension(7, 0));
		txtBuscar.setForeground(Color.WHITE);
		txtBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtBuscar.setToolTipText("Buscar");
		txtBuscar.setBackground(new Color(30, 30, 90));
		txtBuscar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE), // Borde
																															// inferior
				BorderFactory.createEmptyBorder(5, 5, -30, 5) // Márgenes interno más pequeños
		));
		focoInvisible = new JLabel(); // No tiene texto ni apariencia visible
		panel_1.add(focoInvisible);
		// Añadir Listeners para el campo de búsqueda
		txtBuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Si se presiona Enter
					buscarJuego(txtBuscar.getText()); // Realiza la búsqueda
				}
			}
		});

		txtBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) { // Cuando obtiene el foco
				if (txtBuscar.getText().equals("Buscar")) { // Si está en su estado inicial
					txtBuscar.setText(""); // Limpia el texto
				}
			}

			@Override
			public void focusLost(FocusEvent e) { // Cuando pierde el foco
				if (txtBuscar.getText().isEmpty()) { // Si está vacío
					txtBuscar.setText("Buscar"); // Restablece el texto por defecto
				}
			}
		});
		// Establecer el foco en el panel principal para que el campo de búsqueda no
		// tenga foco al inicio
		SwingUtilities.invokeLater(() -> {
			focoInvisible.requestFocusInWindow(); // Establece el foco en el componente invisible
		});

		// Panel adicional para el campo de búsqueda
		JPanel panelTextField = new JPanel(new BorderLayout());
		panelTextField.setOpaque(false);
		panelTextField.add(txtBuscar, BorderLayout.CENTER);

		// Logo
		// Utilizando un panel adicional para el logo con GridBagLayout para centrarlo
		panelLogo = new JPanel(new GridBagLayout());
		panelLogo.setOpaque(false);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));

		// Añadir el logo al centro del panel usando GridBagConstraints
		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.gridx = 0;
		gbcLogo.gridy = 0;
		gbcLogo.insets = new Insets(0, 470, 0, 0);
		gbcLogo.anchor = GridBagConstraints.CENTER;
		panelLogo.add(lblNewLabel, gbcLogo);

		panel_1.add(panelLogo, BorderLayout.CENTER);

		// Mensaje de bienvenida
		JLabel lblBienvenida = new JLabel(
				"Bienvenido a su Biblioteca: " + Login.getUsuarioNOM() + " " + Login.getUsuarioAPE());
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBienvenida.setBorder(new EmptyBorder(0, 0, 0, 230));
		// Panel central para colocar el mensaje entre el campo de búsqueda y el logo
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setOpaque(false);

		panelCentral.add(panelTextField, BorderLayout.WEST); // Campo de búsqueda a la izquierda
		panelCentral.add(lblBienvenida, BorderLayout.EAST); // Mensaje de bienvenida en el centro
		panelCentral.add(panelLogo); // Logo a la derecha

		panel_1.add(panelCentral, BorderLayout.CENTER); // Añadir el panel central

		// Panel para los botones
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setPreferredSize(new Dimension(120, 10));
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Layout vertical

		panelBotones.add(Box.createVerticalGlue());

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setMargin(new Insets(0, 38, 0, 38));
		btnInicio.setPreferredSize(new Dimension(150, 50));
		btnInicio.setBackground(new Color(255, 102, 102));
		panelBotones.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Juego(usuarioDNI);
				dispose();
			}
		});

		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setMargin(new Insets(0, 14, 0, 14));
		btnCerrarSesion.setPreferredSize(new Dimension(100, 50));
		btnCerrarSesion.setBackground(new Color(255, 102, 102));
		panelBotones.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Crear una nueva ventana de "Login"
		        Login login = new Login(); 
		        login.setVisible(true);

		        // Cerrar la ventana actual
		        dispose(); 
		    }
		});


		panel_1.add(panelBotones, BorderLayout.EAST); // Añadir los botones

		return panel_1;
	}

	private JScrollPane crearPanelTabla() {
		panelTabla = new JPanel(new GridLayout(0, 5, 10, 10)); // GridLayout con 5 columnas y sin límite de filas
		panelTabla.setOpaque(false); // Establecer el panel como transparente

		// Llenar la tabla con los datos de la base de datos
		try {
			Connection conn = ConexionBD.getConnection();

			// Consulta para buscar juegos por nombre y por el DNI del cliente en la tabla
			// VENTA.
			String query = "SELECT J.CARATULA, J.NOMBRE_JUEGO, J.PRECIO, J.DESCRIPCION " + "FROM JUEGO J "
					+ "INNER JOIN VENTA V ON J.COD_JUEGO = V.COD_JUEGO " + "WHERE V.DNI = ? ";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, usuarioDNI); // Filtra por el DNI del usuario.

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String rutaCaratula = rs.getString("CARATULA");
				String nombreJuego = rs.getString("NOMBRE_JUEGO");
				String descripcion = rs.getString("DESCRIPCION");
				double precio = rs.getDouble("PRECIO");

				agregarJuego(panelTabla, rutaCaratula, nombreJuego, precio, descripcion, usuarioDNI, descripcion,
						descripcion);
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
			String descripcion, String usuarioDNI, String ANIO, String GENERO) {
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
				abrirVentanaJuego(rutaCaratula, nombreJuego, descripcion, precio, usuarioDNI, ANIO, GENERO); // Abre la
																												// ventana
				// correspondiente al
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

	private void abrirVentanaJuego(String rutaCaratula, String nombreJuego, String descripcion, double precio,
			String usuarioDNI, String ANIO, String GENERO) {
		if (infoJuego == null) {
			infoJuego = new InfoJuego();
			infoJuego.setventanaBiblio(this);
		}
		infoJuego.actualizarInfoJuego(rutaCaratula, nombreJuego, precio, descripcion, usuarioDNI, ANIO, GENERO);
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
				agregarJuego(panelTabla, rutaCaratula, nombreJuego, precio, descripcion, usuarioDNI, descripcion,
						descripcion);
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
		panelTabla.removeAll(); // Limpia la tabla para evitar superposiciones

		String consultaSQL = "SELECT J.CARATULA, J.NOMBRE_JUEGO, J.PRECIO, J.DESCRIPCION " + "FROM JUEGO J "
				+ "INNER JOIN VENTA V ON J.COD_JUEGO = V.COD_JUEGO " + "WHERE V.DNI = ?"; // Consulta base

		if (!textoBusqueda.isEmpty()) {
			consultaSQL += " AND (J.NOMBRE_JUEGO LIKE ? OR J.DESCRIPCION LIKE ?)";
		}

		try {
			Connection conn = ConexionBD.getConnection(); // Obtener conexión
			PreparedStatement ps = conn.prepareStatement(consultaSQL); // Preparar la consulta
			ps.setString(1, usuarioDNI); // Primer parámetro como el DNI del usuario

			if (!textoBusqueda.isEmpty()) {
				String busquedaLike = "%" + textoBusqueda + "%";
				ps.setString(2, busquedaLike); // Para el nombre del juego
				ps.setString(3, busquedaLike); // Para la descripción del juego
			}

			ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

			boolean resultadosEncontrados = false; // Bandera para verificar si hay resultados

			while (rs.next()) {
				resultadosEncontrados = true; // Si entramos en el bucle, hay resultados

				// Obtener datos del juego y agregar a la interfaz
				String caratula = rs.getString("CARATULA");
				String nombreJuego = rs.getString("NOMBRE_JUEGO");
				double precio = rs.getDouble("PRECIO");
				String descripcion = rs.getString("DESCRIPCION");

				agregarJuego(panelTabla, caratula, nombreJuego, precio, descripcion, usuarioDNI, descripcion,
						descripcion);
			}

			if (!resultadosEncontrados) {

				JLabel lblSinResultados = new JLabel("No se encontraron resultados.");
				panelTabla.add(lblSinResultados);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		panelTabla.revalidate(); // Asegúrate de que la tabla se revalide después de la operación
		panelTabla.repaint(); // Re-pintar para reflejar cambios
	}

}

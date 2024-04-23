package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class InfoJuego extends JFrame {
	private JPanel panelTabla;
	private JLabel lblCaratula;
	private JLabel lblTitulo;
	private JTextArea txtDescripcion;
	private JButton btnPrecio;
	private Juego ventanaJuego; // Referencia a la ventana Juego
	private String usuarioDNI;
	private int codJuego = 0;

	// Constructor de InfoJuego
	public InfoJuego(Juego ventanaJuego, String usuarioDNI) {
		this.ventanaJuego = ventanaJuego;
		this.usuarioDNI = usuarioDNI; //
		// Resto del código del constructor...
	}

	// Método setter para establecer la referencia a la ventana Juego
	public void Juego(Juego ventanaJuego) {
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
		panelTabla.setOpaque(false);
		panelTabla.setLayout(new BorderLayout());
		panel.add(panelTabla, BorderLayout.CENTER);

		setVisible(true);
	}
	

	
	private JPanel crearPanelSuperior() {
		JPanel panel_1 = new JPanel(new BorderLayout());
		panel_1.setBackground(new Color(30, 30, 90));
		panel_1.setBorder(new EmptyBorder(0, 40, 0, 40));
		// 40px

		JPanel panelLogo = new JPanel(new GridBagLayout());
		panelLogo.setOpaque(false);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\img\\logo_G3_Sin_Texto.PNG"));

		// Añadir el logo al centro del panel usando GridBagConstraints
		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.gridx = 0;
		gbcLogo.gridy = 0;
		gbcLogo.insets = new Insets(0, 340, 0, 0);
		gbcLogo.anchor = GridBagConstraints.CENTER;
		panelLogo.add(lblNewLabel, gbcLogo);

		panel_1.add(panelLogo, BorderLayout.CENTER);

		// Panel para los botones
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		panelBotones.setOpaque(false);

		panelBotones.add(Box.createVerticalGlue());

		JButton btnBuscar = new JButton("Inicio");
		btnBuscar.setMargin(new Insets(0, 26, 0, 26));
		btnBuscar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBuscar.setBackground(new Color(255, 102, 102));
		btnBuscar.setPreferredSize(new Dimension(100, 46));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		JButton btnBuscar_1_1 = new JButton("Cerrar sesion");
		btnBuscar_1_1.setPreferredSize(new Dimension(120, 46));
		btnBuscar_1_1.setMargin(new Insets(2, 10, 2, 10));
		btnBuscar_1_1.setBackground(new Color(255, 102, 102));
		panelBotones.add(btnBuscar_1_1);
		btnBuscar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login cerrar_sesion = new Login();
				cerrar_sesion.setVisible(true);
				dispose();
				
			}
		});

		JButton btnBuscar_1 = new JButton("Biblioteca");
		btnBuscar_1.setMargin(new Insets(2, 13, 2, 13));
		btnBuscar_1.setBackground(new Color(255, 102, 102));
		btnBuscar_1.setPreferredSize(new Dimension(100, 46));
		panelBotones.add(btnBuscar_1);
		panelBotones.add(btnBuscar);

		panel_1.add(panelBotones, BorderLayout.EAST);

		return panel_1;
	}

	// Método para actualizar la información del juego
	public void actualizarInfoJuego(String rutaCaratula, String nombreJuego, String descripcion, double precio,
			String usuarioDNI) {
		// Limpiar el panel de información del juego
		panelTabla.removeAll();

		// Panel para la información del juego con layout absoluto
		JPanel panelInfoJuego = new JPanel(null);
		panelInfoJuego.setOpaque(false);

		// Carátula del juego
		ImageIcon iconoCaratula = new ImageIcon(rutaCaratula);
		lblCaratula = new JLabel(iconoCaratula);
		lblCaratula.setBounds(20, 20, 300, 400);
		panelInfoJuego.add(lblCaratula);

		// Título del juego
		lblTitulo = new JLabel(nombreJuego);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(350, 20, 400, 30);
		panelInfoJuego.add(lblTitulo);

		// Botón de precio
		btnPrecio = new JButton("€" + String.format("%.2f", precio));
		btnPrecio.setBackground(new Color(255, 102, 102));
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setFont(new Font("Arial", Font.BOLD, 18));
		btnPrecio.setBounds(100, 450, 150, 40);
		panelInfoJuego.add(btnPrecio);

		panelTabla.add(panelInfoJuego, BorderLayout.CENTER);

		// Actualizar la ventana para que se muestren los cambios
		revalidate();
		repaint();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Obtener conexión
			conn = ConexionBD.getConnection();

			// Consulta para obtener el COD_JUEGO a partir del título
			String query = "SELECT COD_JUEGO FROM JUEGO WHERE NOMBRE_JUEGO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nombreJuego);

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			if (rs.next()) {
				codJuego = rs.getInt("COD_JUEGO");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.fillInStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.fillInStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.fillInStackTrace();
				}
			}
		}

		// Botón de precio con funcionalidad para insertar en la base de datos al ser
		// pulsado
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement pstmt = null;

				try {
					// Obtener la conexión con la base de datos
					conn = ConexionBD.getConnection();

					// Consulta para insertar un nuevo registro en la tabla VENTA
					String query = "INSERT INTO VENTA (COD_JUEGO, DNI, FECHA_VENTA, NUM_UNIDADES) VALUES (?, ?, ?, ?)";
					pstmt = conn.prepareStatement(query);

					// Asignar valores para el insert
					pstmt.setInt(1, codJuego); // Código del juego
					pstmt.setString(2, usuarioDNI); // DNI del usuario
					Date sqlDate = Date.valueOf(LocalDate.now()); // Fecha actual en formato "año-mes-día"
					pstmt.setDate(3, sqlDate); // Fecha actual
					pstmt.setInt(4, 1); // Número de unidades (1 por defecto)

					// Ejecutar la consulta de inserción
					pstmt.executeUpdate();

					// Mensaje de confirmación para el usuario
					JOptionPane.showMessageDialog(null, "Juego añadido a la venta con éxito!");

				} catch (SQLException ex) {
					// Manejo de errores SQL
					ex.printStackTrace(); // Para depuración

					// Mostrar mensaje detallado para depuración
					System.err.println("Error SQL: " + ex.getMessage());

					// Mensaje amigable para el usuario
					JOptionPane.showMessageDialog(null,
							"Error al insertar en la base de datos. Por favor, intenta nuevamente.");

				} finally {
					// Cerrar recursos para evitar fugas de memoria
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

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

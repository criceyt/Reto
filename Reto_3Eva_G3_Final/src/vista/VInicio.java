package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import controlador.Controlador;
import clases.Juego;

/**
 * Representa la interfaz gráfica para la ventana de inicio. Proporciona
 * funcionalidad para visualizar y gestionar la lista de juegos disponibles,
 * incluyendo la capacidad de buscar juegos por nombre, navegar entre juegos y
 * acceder a información detallada de cada juego.
 */
public class VInicio extends JDialog {
	/**
	 * Identificador serial único utilizado para la serialización de objetos de esta
	 * clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo de texto para realizar búsquedas dentro de la aplicación.
	 */
	private JTextField txtBuscar;
	/**
	 * Panel que contiene la tabla de juegos.
	 */
	private JPanel panelTabla;
	/**
	 * Componente de desplazamiento que envuelve la tabla de juegos, permitiendo su
	 * desplazamiento.
	 */
	private JScrollPane scrollPane;
	/**
	 * Objeto Persona que representa al usuario actualmente autenticado.
	 */
	private Persona persona;
	/**
	 * Instancia del controlador que gestiona las operaciones relacionadas con los
	 * juegos.
	 */
	private Controlador cont;

	/**
	 * Constructor para inicializar el marco y sus componentes.
	 * 
	 * @param persona La Persona asociada con el usuario actual.
	 */
	public VInicio(Persona persona) {
		this.persona = persona;
		this.cont = new Controlador();
		configureMainFrame();
		initComponents();
		setVisible(true);
	}

	/**
	 * Configura las propiedades generales del marco, como título, icono, ubicación
	 * y tamaño.
	 */
	private void configureMainFrame() {
		setTitle("Catálogo de Juegos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1200, 650);
	}

	/**
	 * Inicializa y organiza los componentes en la ventana, incluyendo el panel
	 * principal, el panel de búsqueda y la tabla de juegos. Este método configura
	 * la disposición de los componentes utilizando un layout manager y añade los
	 * paneles creados a la ventana principal.
	 */
	private void initComponents() {
		JPanel mainPanel = createMainPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;

		mainPanel.add(createTopPanel(), gbc);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		mainPanel.add(createScrollPaneForTable(), gbc);

		loadDataIntoTable();
	}

	/**
	 * Crea el panel principal con un fondo degradado. Organiza los componentes
	 * internos y personaliza el aspecto del panel para aplicar un gradiente.
	 * 
	 * @return Un nuevo JPanel con un fondo degradado.
	 */
	private JPanel createMainPanel() {
		return new JPanel(new GridBagLayout()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new GradientPaint(0, 0, new Color(0, 0, 255), 0, getHeight(), new Color(128, 0, 128))); // Degradado
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
	}

	/**
	 * Crea el panel superior con un campo de búsqueda, botones y otros elementos.
	 * Este panel incluye un campo de texto para buscar juegos, un panel para el
	 * logo de la aplicación, y botones para navegar entre diferentes vistas de la
	 * aplicación.
	 * 
	 * @return Un nuevo JPanel que contiene el campo de búsqueda, el logo y los
	 *         botones.
	 */
	private JPanel createTopPanel() {
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(30, 30, 90));
		topPanel.setBorder(new EmptyBorder(0, 40, 0, 40));

		txtBuscar = createSearchField(); // Crea el campo de búsqueda
		JPanel searchPanel = new JPanel(new BorderLayout());
		searchPanel.setOpaque(false);
		searchPanel.add(txtBuscar, BorderLayout.CENTER);

		JPanel logoPanel = createLogoPanel();
		JPanel centralPanel = new JPanel(new BorderLayout());
		centralPanel.setOpaque(false);
		centralPanel.add(searchPanel, BorderLayout.WEST);
		centralPanel.add(createWelcomeLabel(), BorderLayout.EAST);
		centralPanel.add(logoPanel);

		topPanel.add(centralPanel, BorderLayout.CENTER);
		topPanel.add(createButtonPanel(), BorderLayout.EAST);

		return topPanel;
	}

	/**
	 * Crea un campo de texto para realizar búsquedas dentro de la aplicación. Este
	 * campo permite al usuario ingresar términos de búsqueda para encontrar juegos
	 * específicos. Se configuran eventos de teclado y foco para mejorar la
	 * interacción del usuario, como limpiar el campo cuando se enfoca y realizar la
	 * búsqueda cuando se presiona Enter.
	 *
	 * @return Un nuevo JTextField configurado para uso de búsqueda.
	 */
	private JTextField createSearchField() {
		JTextField searchField = new JTextField("Buscar", 15);
		searchField.setForeground(Color.WHITE);
		searchField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		searchField.setToolTipText("Buscar");
		searchField.setBackground(new Color(30, 30, 90));
		searchField
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE),

						BorderFactory.createEmptyBorder(5, 5, -30, 5)));

		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarJuego(searchField.getText());
				}
			}
		});

		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("Buscar")) {
					searchField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("Buscar");
				}
			}
		});

		return searchField;
	}

	/**
	 * Crea un mensaje de bienvenida basado en el nombre del usuario. Este método
	 * construye un JLabel que muestra un saludo personalizado al usuario,
	 * utilizando el nombre completo obtenido de la Persona.
	 *
	 * @return Un nuevo JLabel con el mensaje de bienvenida.
	 */
	private JLabel createWelcomeLabel() {
		String nombreCompleto = obtenerNombreUsuario();
		JLabel lblBienvenida = new JLabel("Bienvenido al Inicio: " + nombreCompleto);
		lblBienvenida.setForeground(Color.WHITE); // Color del texto
		lblBienvenida.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBienvenida.setBorder(new EmptyBorder(0, 0, 0, 230));
		return lblBienvenida;
	}

	/**
	 * Obtiene el nombre completo del usuario actual. Este método devuelve el nombre
	 * y apellido del usuario si está autenticado, o "Usuario Desconocido" si no hay
	 * ninguna persona autenticada.
	 *
	 * @return Un texto representando el nombre completo del usuario.
	 */
	private String obtenerNombreUsuario() {
		if (persona != null) {
			return persona.getNombre() + " " + persona.getApellido();
		} else {
			return "Usuario Desconocido";
		}
	}

	/**
	 * Crea el panel para el logo de la aplicación. Este panel posiciona el logo
	 * centrado en la parte superior de la ventana. El logo se carga desde un
	 * archivo de imagen local.
	 *
	 * @return Un nuevo JPanel que contiene el logo de la aplicación.
	 */
	private JPanel createLogoPanel() {
		JPanel logoPanel = new JPanel(new GridBagLayout());
		logoPanel.setOpaque(false);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));

		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.gridx = 0;
		gbcLogo.gridy = 0;
		gbcLogo.insets = new Insets(0, 470, 0, 0);
		gbcLogo.anchor = GridBagConstraints.CENTER;

		logoPanel.add(lblNewLabel, gbcLogo);
		return logoPanel;
	}

	/**
	 * Crea el panel para botones como "Inicio" y "Cerrar sesión". Este panel
	 * organiza los botones de manera ascendente. Los botones están diseñados para
	 * abrir nuevas ventanas o cerrar la ventana actual según la acción
	 * seleccionada.
	 *
	 * @return Un nuevo JPanel que contiene los botones de navegación.
	 */
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(120, 10));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		Dimension buttonSize = new Dimension(150, 50);

		JButton btnInicio = createButton("Biblioteca", buttonSize);
		JButton btnCerrarSesion = createButton("Cerrar sesión", buttonSize);
		btnInicio.setMargin(new Insets(10, 21, 10, 21));
		btnInicio.addActionListener(e -> {
			VBiblioteca vB = new VBiblioteca(persona);
			vB.setVisible(true);
			this.dispose();
		});

		btnCerrarSesion.addActionListener(e -> {

			dispose();
		});

		buttonPanel.add(btnInicio);
		buttonPanel.add(btnCerrarSesion);

		return buttonPanel;
	}

	/**
	 * Crea un botón con el texto especificado y el tamaño deseado. Este método
	 * configura el botón con un margen, tamaño preferido y color de fondo antes de
	 * retornarlo.
	 *
	 * @param text El texto que aparecerá en el botón.
	 * @param size La dimensión preferida del botón.
	 * @return Un nuevo JButton configurado con el texto y tamaño especificados.
	 */
	private JButton createButton(String text, Dimension size) {
		JButton button = new JButton(text);
		button.setMargin(new Insets(5, 10, 5, 10));
		button.setPreferredSize(size);
		button.setBackground(new Color(255, 102, 102));
		return button;
	}

	/**
	 * Crea un panel de desplazamiento para la tabla de juegos. Este método
	 * configura un {@link JScrollPane} para mostrar una tabla de juegos,
	 * permitiendo al usuario desplazarse a través de los elementos de la tabla. El
	 * panel interno de la tabla organiza los elementos de manera tabular.
	 *
	 * @return Un nuevo JScrollPane configurado para mostrar la tabla de juegos.
	 */
	private JScrollPane createScrollPaneForTable() {
		panelTabla = new JPanel(new GridLayout(0, 5, 10, 10));
		panelTabla.setOpaque(false);

		scrollPane = new JScrollPane(panelTabla);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

		return scrollPane;
	}

	/**
	 * Carga datos iniciales en la tabla de juegos. Este método obtiene una lista de
	 * juegos desde el controlador, agrega cada juego a la tabla y luego actualiza
	 * la tabla para reflejar los cambios.
	 */
	private void loadDataIntoTable() {
		try {
			List<Juego> juegos = cont.obtenerJuegos();
			panelTabla.removeAll();
			for (Juego juego : juegos) {
				agregarJuego(juego);
			}

			panelTabla.revalidate();
			panelTabla.repaint();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar juegos: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Busca juegos en la base de datos según el texto de búsqueda. Este método
	 * realiza una búsqueda de juegos basada en el texto ingresado por el usuario y
	 * actualiza la tabla de juegos para mostrar los resultados. Si no se encuentran
	 * juegos, se muestra un mensaje de error.
	 *
	 * @param searchText El texto de búsqueda ingresado por el usuario.
	 */
	private void buscarJuego(String searchText) {
		try {
			List<Juego> resultados = cont.buscarJuegosPorTextoNormal(searchText);

			if (resultados.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No se ha encontrado ningún juego con ese criterio", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				panelTabla.removeAll();
				for (Juego juego : resultados) {
					agregarJuego(juego);
				}
			}

			panelTabla.revalidate();
			panelTabla.repaint();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al buscar juegos: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Agrega un juego al panel de la tabla. Este método crea un panel para cada
	 * juego, mostrando la carátula del juego en un botón y la información relevante
	 * (nombre y precio) debajo de él. Al hacer clic en la carátula, se abre una
	 * nueva ventana con detalles adicionales sobre el juego.
	 *
	 * @param juego El Juego que es agregado a la tabla.
	 */
	private void agregarJuego(Juego juego) {
		JPanel gamePanel = new JPanel(new BorderLayout());
		gamePanel.setOpaque(false);

		JButton btnCaratula = new JButton();
		btnCaratula.setBorderPainted(false);
		btnCaratula.setContentAreaFilled(false);
		btnCaratula.setFocusPainted(false);
		btnCaratula.setIcon(new ImageIcon(juego.getCaratula()));
		btnCaratula.addActionListener(e -> {
			VinfoJuego ventanaJuego = new VinfoJuego(persona, juego);
			ventanaJuego.setVisible(true);
		});

		gamePanel.add(btnCaratula, BorderLayout.CENTER);

		JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		infoPanel.setOpaque(false);

		JLabel lblNombreJuego = new JLabel(juego.getNombre());
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setForeground(Color.WHITE);
		lblNombreJuego.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblPrecio = new JLabel("     €" + String.format("%.2f", juego.getPrecio()));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		infoPanel.add(lblNombreJuego);
		infoPanel.add(lblPrecio);

		gamePanel.add(infoPanel, BorderLayout.SOUTH);
		panelTabla.add(gamePanel);
	}
}

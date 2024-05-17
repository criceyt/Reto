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
 * Clase que representa la interfaz gráfica para la biblioteca de juegos.
 * Esta clase extiende JDialog y permite a los usuarios interactuar con la biblioteca,
 * mostrando una lista de juegos disponibles y permitiendo realizar búsquedas.
 * También incluye opciones para cerrar sesión y volver al inicio.
 */
public class VBiblioteca extends JDialog {
	/**
	 * Identificador único serializado para la clase, necesario para la serialización de objetos.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo de texto donde el usuario puede ingresar texto para buscar juegos.
	 */
	private JTextField txtBuscar;
	/**
	 * Panel que actúa como contenedor para la tabla de juegos.
	 */
	private JPanel panelTabla;
	/**
	 * Componente JScrollPane que permite el desplazamiento de la tabla de juegos.
	 */
	private JScrollPane scrollPane;
	/**
	 * Objeto de tipo Persona que representa al usuario actualmente autenticado.
	 */
	private Persona persona;
	/**
	 * Instancia del controlador principal que maneja las operaciones de negocio.
	 */
	private Controlador cont;



	/**
     * Constructor para inicializar el marco y sus componentes.
     * 
     * @param persona Objeto Persona que representa al usuario actual.
     */
	public VBiblioteca(Persona persona) {
		this.persona = persona;
		this.cont = new Controlador();
		configureMainFrame();
		initComponents();
		setVisible(true);
	}
	

	/**
     * Configura las propiedades generales del marco, como título, icono, ubicación y tamaño.
     */
	private void configureMainFrame() {
		setTitle("Biblioteca de Juegos");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1200, 650);
	

		 // Establece el tamaño de la ventana al tamaño de la pantalla
	}

	/**
     * Inicializa y organiza los componentes en la ventana, incluyendo el panel principal, el panel de búsqueda y la tabla de juegos.
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
	 * Crea el panel principal de la interfaz gráfica con un fondo degradado.
	 * Este panel utiliza un diseño de cuadrícula flexible (GridBagLayout) para posicionar
	 * sus componentes de manera dinámica.
	 * 
	 * @return Un nuevo JPanel con un fondo degradado, listo para ser agregado a la interfaz gráfica.
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
	 * Crea el panel superior de la interfaz gráfica, que incluye un campo de búsqueda,
	 * un panel para mostrar el logotipo de la aplicación, un mensaje de bienvenida basado
	 * en el nombre del usuario, y un panel con botones para acciones como "Inicio" y "Cerrar sesión".
	 * Este panel utiliza un diseño de borde (BorderLayout) para organizar sus componentes.
	 * 
	 * @return Un nuevo JPanel que representa el panel superior de la interfaz gráfica.
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
	 * Crea un campo de búsqueda (JTextField) con configuraciones específicas para su apariencia y comportamiento.
	 * Este campo permite a los usuarios ingresar texto para buscar elementos en la interfaz gráfica.
	 * Se configuran eventos para manejar el cambio de texto y el enfoque del campo, incluyendo la acción de buscar
	 * un juego cuando se presiona Enter y la limpieza del campo cuando pierde el foco.
	 * 
	 * @return Un JTextField configurado y listo para ser añadido a la interfaz gráfica.
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
	 * Crea un mensaje de bienvenida personalizado basado en el nombre del usuario actual.
	 * Este método construye un JLabel que muestra un saludo amigable junto con el nombre completo
	 * del usuario, si está registrado, o simplemente indica que el usuario es desconocido.
	 * 
	 * @return Un JLabel con el mensaje de bienvenida, listo para ser añadido a la interfaz gráfica.
	 */
	private JLabel createWelcomeLabel() {
		String nombreCompleto = obtenerNombreUsuario();
		JLabel lblBienvenida = new JLabel("Bienvenido a su Biblioteca: " + nombreCompleto);
		lblBienvenida.setForeground(Color.WHITE); // Color del texto
		lblBienvenida.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBienvenida.setBorder(new EmptyBorder(0, 0, 0, 230));
		return lblBienvenida;
	}

	/**
	 * Obtiene el nombre completo del usuario actual, si está registrado, o devuelve "Usuario Desconocido".
	 * Este método es utilizado por otros métodos para personalizar mensajes y interfaces basadas en el estado
	 * del usuario.
	 * 
	 * @return Una cadena representando el nombre completo del usuario, o "Usuario Desconocido" si no hay usuario.
	 */
	private String obtenerNombreUsuario() {
		if (persona != null) {
			return persona.getNombre() + " " + persona.getApellido();
		} else {
			return "Usuario Desconocido";
		}
	}

	/**
	 * Crea un panel para mostrar el logotipo de la aplicación, utilizando un diseño de cuadrícula flexible
	 * (GridBagLayout). Este panel es transparente y coloca el logotipo en el centro, ajustándolo a la posición
	 * especificada.
	 * 
	 * @return Un JPanel con el logotipo de la aplicación, listo para ser añadido a la interfaz gráfica.
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
	 * Crea el panel que contiene los botones "Inicio" y "Cerrar sesión".
	 * Este método configura el panel para ser transparente, establece su tamaño,
	 * organiza sus componentes en una disposición vertical (BoxLayout), y crea dos botones
	 * con acciones específicas asociadas a cada uno.
	 *
	 * @return Un objeto JPanel que representa el panel de botones.
	 */
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(120, 10));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		Dimension buttonSize = new Dimension(150, 50);

		JButton btnInicio = createButton("Inicio", buttonSize);
		JButton btnCerrarSesion = createButton("Cerrar sesión", buttonSize);
		btnInicio.setMargin(new Insets(10, 34, 10, 34));
		btnInicio.addActionListener(e -> {
			VInicio vInicio = new VInicio(persona); // Crear una instancia de VInicio
			vInicio.setVisible(true);
			
			dispose();
		});

		btnCerrarSesion.addActionListener(e -> {		

			dispose();
		});

		buttonPanel.add(btnInicio);
		buttonPanel.add(btnCerrarSesion);

		return buttonPanel;
	}

	/**
	 * Crea un botón con el texto especificado y el tamaño deseado.
	 * Configura el margen del botón, su tamaño preferido y su color de fondo.
	 *
	 * @param text El texto que se mostrará en el botón.
	 * @param size La dimensión preferida del botón.
	 * @return Un objeto JButton configurado según los parámetros proporcionados.
	 */
	private JButton createButton(String text, Dimension size) {
		JButton button = new JButton(text);
		button.setMargin(new Insets(5, 10, 5, 10));
		button.setPreferredSize(size);
		button.setBackground(new Color(255, 102, 102));
		return button;
	}

	/**
	 * Crea un panel de desplazamiento para la tabla de juegos.
	 * Este método inicializa un JScrollPane que envuelve un JPanel con una disposición de cuadrícula.
	 * Configura el JScrollPane para ser transparente, elimina el borde predeterminado y ajusta el incremento unitario
	 * del scrollbar vertical para mejorar la experiencia de usuario al navegar por la tabla.
	 *
	 * @return Un objeto JScrollPane configurado para mostrar la tabla de juegos.
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
	 * Carga datos iniciales en la tabla de juegos.
	 * Este método intenta obtener una lista de juegos asociados a un cliente específico mediante su DNI.
	 * Luego, limpia el contenido actual del panel de la tabla y agrega cada juego obtenido a través de la función
	 * agregarJuego. Finalmente, recalcula y repinta el panel para reflejar los cambios.
	 *
	 * @throws Exception Si ocurre algún error durante la obtención de los juegos o su procesamiento.
	 */
	private void loadDataIntoTable() {
		try {
			List<Juego> juegos = cont.obtenerJuegosPorCliente(persona.getDni());
			panelTabla.removeAll();
			for (Juego juego : juegos) { 
				agregarJuego(juego); 
			}

			panelTabla.revalidate(); 
			panelTabla.repaint(); 
		} catch (Exception ex) {
		}
	}

	/**
	 * Busca juegos en la base de datos según el texto de búsqueda proporcionado.
	 * Este método intenta encontrar juegos que coincidan con el texto de búsqueda, considerando
	 * la biblioteca de juegos del usuario identificado por su DNI. Si no se encuentran juegos,
	 * muestra un mensaje de error. De lo contrario, agrega los juegos encontrados al panel de la tabla.
	 *
	 * @param searchText El texto de búsqueda utilizado para filtrar juegos.
	 */
	private void buscarJuego(String searchText) {
		try {
			List<Juego> resultados = cont.buscarJuegosPorTexto(persona.getDni(), searchText); 

			if (resultados.isEmpty()) { 
				JOptionPane.showMessageDialog(this, "No se ha encontrado ningún juego con ese criterio en tu biblioteca de juegos", "Error",
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
			JOptionPane.showMessageDialog(this, "No se ha encontrado ningún juego con ese criterio en tu biblioteca de juegos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Agrega un juego al panel de la tabla, mostrando información relevante sobre el juego.
	 * Este método crea un panel para cada juego, incluyendo una imagen de la carátula del juego
	 * como botón, y muestra detalles como el nombre y precio del juego. Al hacer clic en la carátula,
	 * abre una nueva ventana con información adicional sobre el juego.
	 *
	 * @param juego El objeto Juego a agregar al panel de la tabla.
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

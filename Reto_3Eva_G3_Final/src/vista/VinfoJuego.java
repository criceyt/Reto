package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Juego;
import clases.Persona;
import controlador.Controlador;
import excepciones.ExcepcionStock;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 * Esta clase crea una ventana modal que muestra información detallada sobre un juego específico. Esta ventana incluye detalles como el nombre, precio,
 * género, año de salida y descripción del juego, así como opciones para cerrar la ventana o comprar el juego.
 * La clase también gestiona eventos de acción, permitiendo realizar acciones específicas cuando se hacen clic en los botones.
 * 
 */
public class VinfoJuego extends JDialog implements ActionListener{
	/**
	 * Identificador único serializado para la clase, necesario para la serialización de objetos.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel principal que contiene todos los componentes de la interfaz gráfica.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Objeto de tipo {@link Juego} que representa el juego actualmente seleccionado para mostrar en la ventana.
	 */
	private Juego juego;
	/**
	 * Objeto de tipo {@link Persona} que representa al usuario actualmente autenticado.
	 */
	private Persona persona;
	/**
	 * Botón para cerrar la ventana de información del juego.
	 */
	private JButton btnCerrar;
	/**
	 * Botón para comprar el juego actualmente seleccionado.
	 */
	private JButton btnComprar;
	/**
	 * Instancia del controlador principal que maneja las operaciones de negocio.
	 */
	private Controlador cont;
	/**
	 * Etiqueta para mostrar el precio del juego actualmente seleccionado.
	 */
	private JLabel lblPrecio;


	/**
     * Constructor de la clase. Recibe una Persona y un Juego, inicializando la ventana con la información del juego y configurando los componentes de la UI.
     * 
     * @param persona La Persona asociada con el usuario actual.
     * @param juego El Juego cuya información se mostrará en la ventana.
     */
	public VinfoJuego(Persona persona, Juego juego) {
		this.setModal(true);
		cont = new Controlador();
        this.juego = juego;
        this.juego = new Juego();
        this.juego = juego;
        this.persona = persona;
        setTitle(this.juego.getNombre());
        setIconImage(Toolkit.getDefaultToolkit().getImage(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
        setBounds(100, 100, 920, 595);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 90));
        panel.setBounds(0, 0, 904, 101);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel lblNombreJuego = new JLabel(this.juego.getNombre());
        lblNombreJuego.setFont(new Font("Arial Black", Font.PLAIN, 19));
        lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreJuego.setForeground(new Color(255, 255, 255));
        lblNombreJuego.setBounds(173, 11, 493, 57);
        panel.add(lblNombreJuego);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(".\\.\\img\\logo_G3_Sin_Texto.PNG"));
        lblNewLabel.setBounds(51, 11, 75, 76);
        panel.add(lblNewLabel);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.PLAIN, 15));
        btnCerrar.setBackground(new Color(255, 102, 102));
        btnCerrar.setBounds(722, 32, 133, 40);
        btnCerrar.addActionListener(this);
        panel.add(btnCerrar);

        JPanel panel_1 = new JPanel() {
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
        panel_1.setBounds(0, 100, 904, 456);
        contentPanel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setIcon(new ImageIcon(this.juego.getCaratula()));
        lblNewLabel_1.setBounds(21, 21, 325, 403);
        panel_1.add(lblNewLabel_1);
        
        btnComprar = new JButton("Comprar");
        btnComprar.setFont(new Font("Arial", Font.PLAIN, 15));
        btnComprar.setBackground(new Color(255, 102, 102));
        btnComprar.setBounds(745, 384, 133, 40);
        btnComprar.addActionListener(this);
        panel_1.add(btnComprar);
        
        lblPrecio = new JLabel(String.valueOf(this.juego.getPrecio()) + " €");
        lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblPrecio.setForeground(new Color(255, 255, 255));
        lblPrecio.setBounds(745, 357, 133, 25);
        panel_1.add(lblPrecio);
        
        JLabel lblGenero = new JLabel("Género");
        lblGenero.setForeground(new Color(255, 255, 255));
        lblGenero.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblGenero.setBounds(421, 41, 133, 30);
        panel_1.add(lblGenero);
        
        JLabel lblAnoSalida = new JLabel("Año de salida");
        lblAnoSalida.setForeground(new Color(255, 255, 255));
        lblAnoSalida.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblAnoSalida.setBounds(421, 88, 133, 30);
        panel_1.add(lblAnoSalida);
        
        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setForeground(new Color(255, 255, 255));
        lblDescripcion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblDescripcion.setBounds(421, 129, 133, 30);
        panel_1.add(lblDescripcion);
        
        JLabel lblGenero2 = new JLabel(juego.getGenero());
        lblGenero2.setFont(new Font("Arial", Font.PLAIN, 15));
        lblGenero2.setForeground(new Color(255, 255, 255));
        lblGenero2.setBounds(575, 41, 254, 30);
        panel_1.add(lblGenero2);
        
        JLabel lblAnoSalida2 = new JLabel(String.valueOf(juego.getAnio()));
        lblAnoSalida2.setForeground(new Color(255, 255, 255));
        lblAnoSalida2.setFont(new Font("Arial", Font.PLAIN, 15));
        lblAnoSalida2.setBounds(575, 88, 254, 30);
        panel_1.add(lblAnoSalida2);
        
        JTextArea textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setEditable(false);
        textAreaDescripcion.setText(this.juego.getDescripcion());
        textAreaDescripcion.setBounds(421, 170, 408, 136);
        textAreaDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
        textAreaDescripcion.setBackground(new Color(0, 0, 0, 0));
        textAreaDescripcion.setForeground(Color.WHITE);
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);
        panel_1.add(textAreaDescripcion);
        
        if (juego.getNumUnidades() == 0 || juego.getNumUnidades() < 0) {
        	lblPrecio.setText("Sin stock");
        	btnComprar.setEnabled(false);
		}
        
    }

	/**
	 * Maneja eventos de acción generados por los componentes de la interfaz gráfica. Este método verifica el origen del evento y ejecuta acciones específicas
	 * dependiendo de si el evento proviene del botón para cerrar la ventana o del botón para comprar el juego.
	 * 
	 * - Si el evento proviene del boton de cerrar, la ventana se cierra utilizando el método pertinente.
	 * - Si el evento proviene de comprar, se llama al método necesario para procesar la compra
	 *   del juego actualmente seleccionado.
	 * 
	 * @param e El objeto que indica qué componente ha generado el evento.
	 */
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource().equals(btnCerrar)) {
			this.dispose();
		}
    	if (e.getSource().equals(btnComprar)) {
			comprarJuego();
		}
    }

    /**
     * Intenta comprar el juego actualmente seleccionado. Este método llama al controlador pasando el juego y la persona actual como argumentos.
     * En caso de que ocurra una excepción de stock insuficiente, se captura y se muestra la excepción correspondiente.
     * Después de intentar la compra, verifica si hay unidades disponibles del juego. Si no hay unidades disponibles,
     * actualiza la etiqueta de precio para reflejar "Sin stock" y deshabilita el botón de compra para evitar compras
     * innecesarias.
     * 
     * @throws ExcepcionStock Si ocurre una excepción de stock insuficiente durante el proceso de compra.
     */
	private void comprarJuego() {
		int num;
		
		num = cont.conseguirUnidades(juego);
		
		if (num == 0 || num < 0) {
        	lblPrecio.setText("Sin stock");
        	btnComprar.setEnabled(false);
		}
		try {
			cont.comprarJuego(juego, persona);
		} catch (ExcepcionStock e) {
			e.mostrarExcepcion();
			
		}
	}
}
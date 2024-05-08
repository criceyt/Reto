package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import excepciones.ErrorGeneral;
import excepciones.LogInException;

public class ImplementacionBD implements DAO {

	// HERRAMIENTAS

	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle fichConf;
	private String url;
	private String usuario;
	private String pass;

	// Consulta MySQL para introducir los datos
	private final String altaPersona = "INSERT INTO PERSONA(dni, nombre_persona, apellido, edad, direccion, email, contrasena) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private final String altaCliente = "INSERT INTO CLIENTE(dni, es_premiun) VALUES(?, ?)";
	// Select que recoge los datos de un cliente en específico
	private final String datosInicioDeSesion = "SELECT PERSONA.*, CLIENTE.ES_PREMIUN FROM PERSONA INNER JOIN CLIENTE ON PERSONA.DNI = CLIENTE.DNI WHERE PERSONA.EMAIL = ? AND PERSONA.CONTRASENA = ?";
	// Select de el loin
	private final String inicioSesion = "SELECT * FROM PERSONA WHERE EMAIL = ? AND CONTRASENA = ?";
	private final String CONSULTA_TRABAJADOR = "SELECT * FROM TRABAJADOR WHERE DNI = ?";
	private final String CONSULTA_CLIENTE = "SELECT * FROM CLIENTE WHERE DNI = ?";
	private final String altaTrabajador = "INSERT INTO TRABAJADOR(dni, salario, es_admin) VALUES (?, ?, ?)";
	
	private final String COMPROBAR_EMAIL_CLIENTE = "SELECT c.* FROM CLIENTE c ,PERSONA p WHERE p.EMAIL = ? AND p.DNI=c.DNI";	
	private final String COMPROBAR_EMAIL_PERSONA = "SELECT * FROM PERSONA WHERE EMAIL = ?";
	private final String DAR_DE_BAJA = "DELETE FROM PERSONA WHERE DNI = ?";
	private final String GUARDAR_PERSONA = "UPDATE PERSONA SET NOMBRE_PERSONA = ?, APELLIDO=?, EDAD=?, DIRECCION=?, CONTRASENA=? where DNI=?";
	private final String GUARDAR_CLIENTE = "UPDATE CLIENTE SET ES_PREMIUN = ? where DNI =?";
	
	public ImplementacionBD() {
		fichConf = ResourceBundle.getBundle("modelo.config");
		url = fichConf.getString("url");
		usuario = fichConf.getString("usuario");
		pass = fichConf.getString("pass");
	}

	// Para Abrir la Conexion
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	// Para Cerrar la Conexion
	public void closeConnection() {

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

		}
	}

	@Override
	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException {
		ResultSet rs = null;
		Persona per= null, persona = null;
		int is_premium;
		
		this.openConnection();		

			try {
				stmt = con.prepareStatement(inicioSesion);
				stmt.setString(1, email);
				stmt.setString(2, contrasena);
				
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					persona = new Persona();
					persona.setDni(rs.getString("DNI"));
					persona.setNombre(rs.getString("NOMBRE_PERSONA"));
					persona.setApellido(rs.getString("APELLIDO"));
					persona.setEdad(rs.getInt("EDAD"));
					persona.setDireccion(rs.getString("DIRECCION"));
					persona.setEmail(rs.getString("EMAIL"));
					persona.setContrasena(rs.getString("CONTRASENA"));
					
					//Combrobar si es Trabajador o Cliente
					stmt = con.prepareStatement(CONSULTA_TRABAJADOR);
					stmt.setString(1, persona.getDni() );
					
					rs = stmt.executeQuery();
					
					if (rs.next()) {
						per = new Trabajador();
						per.setDni(persona.getDni());
						per.setNombre(persona.getNombre());
						per.setApellido(persona.getApellido());
						per.setEdad(persona.getEdad());
						per.setDireccion(persona.getDireccion());
						per.setEmail(persona.getEmail());
						per.setContrasena(persona.getContrasena());
						
						((Trabajador) per).setSalario(rs.getFloat("SALARIO"));
						((Trabajador) per).setIs_admin(rs.getBoolean("ES_ADMIN"));
					}else {
						//Combrobar si es Trabajador o Cliente
						stmt = con.prepareStatement(CONSULTA_CLIENTE);
						stmt.setString(1, persona.getDni() );
						
						rs = stmt.executeQuery();
						
						if (rs.next()) {
							per = new Cliente();
							
							per.setDni(persona.getDni());
							per.setNombre(persona.getNombre());
							per.setApellido(persona.getApellido());
							per.setEdad(persona.getEdad());
							per.setDireccion(persona.getDireccion());
							per.setEmail(persona.getEmail());
							per.setContrasena(persona.getContrasena());
							
							((Cliente) per).setIs_premium(rs.getBoolean("ES_PREMIUN"));
						}
					}
				
				}else {
					throw new LogInException();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorGeneral();
			}
			
		return per;
	}

	@Override
	public void registroUsuario(Persona persona, JCheckBox hacersePremium) throws ErrorGeneral, LogInException {
		// ALTA DE USUARIOS

		openConnection();

		try {
			stmt = con.prepareStatement(altaPersona);

			stmt.setString(1, persona.getDni());
			stmt.setString(2, persona.getNombre());
			stmt.setString(3, persona.getApellido());
			stmt.setInt(4, persona.getEdad());
			stmt.setString(5, persona.getDireccion());
			stmt.setString(6, persona.getEmail());
			stmt.setString(7, persona.getContrasena());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt = con.prepareStatement(altaCliente);

			stmt.setString(1, persona.getDni());
			stmt.setBoolean(2, hacersePremium.isSelected());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	@Override
	public void altaTrabajador(Persona trabajador, JTextField txtSueldo) throws ErrorGeneral, LogInException {
		// METODO PARA AÑADIR UN TRABAJADOR
		
		openConnection();

		try {
			stmt = con.prepareStatement(altaPersona);

			stmt.setString(1, trabajador.getDni());
			stmt.setString(2, trabajador.getNombre());
			stmt.setString(3, trabajador.getApellido());
			stmt.setInt(4, trabajador.getEdad());
			stmt.setString(5, trabajador.getDireccion());
			stmt.setString(6, trabajador.getEmail());
			stmt.setString(7, trabajador.getContrasena());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt = con.prepareStatement(altaTrabajador);

			stmt.setString(1, trabajador.getDni());
			stmt.setFloat(2, ((Trabajador) trabajador).getSalario());
			stmt.setBoolean(3, ((Trabajador) trabajador).isIs_admin());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public Cliente obtenerClientePorEmail(String email) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		ResultSet rs;
		try {
			stmt = con.prepareStatement(COMPROBAR_EMAIL_CLIENTE);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next()) {
	            cliente = new Cliente();
	            cliente.setDni(rs.getString("DNI"));
	            cliente.setIs_premium(rs.getBoolean("ES_PREMIUN"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cliente;
	}
	
	@Override
	public Persona obtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		Persona per = null;
		ResultSet rs;
		try {
			stmt = con.prepareStatement(COMPROBAR_EMAIL_PERSONA);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next()) {
				per = new Persona();
				per.setDni(rs.getString("DNI"));
				per.setNombre(rs.getString("NOMBRE_PERSONA"));
				per.setApellido(rs.getString("APELLIDO"));
				per.setEdad(rs.getInt("EDAD"));
				per.setEmail(rs.getString("EMAIL"));
				per.setDireccion(rs.getString("DIRECCION"));
				per.setContrasena(rs.getString("CONTRASENA"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return per;
	}

	@Override
	public void darBaja(String dni) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt = con.prepareStatement(DAR_DE_BAJA);
			stmt.setString(1, dni);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void guardar(Cliente cliente, JCheckBox chckbxUserPremium) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		openConnection();
		try {
			stmt = con.prepareStatement(GUARDAR_PERSONA);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setInt(3, cliente.getEdad());
			stmt.setString(4, cliente.getDireccion());
			stmt.setString(5, cliente.getContrasena());
			stmt.setString(6, cliente.getDni());			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt = con.prepareStatement(GUARDAR_CLIENTE);
			stmt.setBoolean(1, cliente.isIs_premium());
			stmt.setString(2, cliente.getDni());			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}
	


}

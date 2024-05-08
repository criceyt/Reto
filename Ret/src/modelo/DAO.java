package modelo;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import excepciones.ErrorGeneral;
import excepciones.LogInException;

public interface DAO {

	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException;

	public void registroUsuario(Persona persona, JCheckBox hacersePremium) throws ErrorGeneral, LogInException;

	public void altaTrabajador(Persona trabajador, JTextField txtSueldo)throws ErrorGeneral, LogInException ;

	public Cliente obtenerClientePorEmail(String email) throws ErrorGeneral, LogInException;

	Persona obtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException;

	public void darBaja(String dni) throws ErrorGeneral, LogInException;

	public void guardar(Cliente cliente, JCheckBox chckbxUserPremium) throws ErrorGeneral, LogInException;



	
}

package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Persona;
import clases.Trabajador;
import excepciones.ErrorGeneral;
import excepciones.LogInException;
import vista.InicioSesion;
import modelo.*;

public class Controlador {
	private DAO imp = new ImplementacionBD();

	public Persona inicioSesion(String email, String contrasena) throws ErrorGeneral, LogInException{
		Persona persona = null;
		
	
		persona = imp.inicioSesion(email, contrasena);
		
		return persona;
	}

	public  void registroUsuario(Persona persona, JCheckBox hacersePremium) throws ErrorGeneral, LogInException {
		
		imp.registroUsuario(persona, hacersePremium);
	}

	public void altaTrabajador(Persona trabajador, JTextField txtSueldo) throws ErrorGeneral, LogInException {
		
		imp.altaTrabajador(trabajador, txtSueldo);
		
	}

	public void mostrarPantallaInicio() {
		// VENTANA PRINCIPAL DE INICIO DE SESION
		
		InicioSesion ventanaNueva = new InicioSesion(this);
		ventanaNueva.setVisible(true);
		
	}
	public  Cliente ObtenerClientePorEmail(String email) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		Cliente cliente;		
		cliente = imp.obtenerClientePorEmail(email);	
		return cliente;
	}

	public  Persona ObtenerPersonaPorEmail(String email) throws ErrorGeneral, LogInException {
		// TODO Auto-generated method stub
		Persona per;
		per = imp.obtenerPersonaPorEmail(email);
		return per;
	}

	public void darBaja(String dni) throws ErrorGeneral, LogInException{
		// TODO Auto-generated method stub
		imp.darBaja(dni);
	}

	public void guardar(Cliente cliente, JCheckBox chckbxUserPremium) throws ErrorGeneral, LogInException{

		imp.guardar(cliente, chckbxUserPremium);
	}

}

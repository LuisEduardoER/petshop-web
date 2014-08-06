package com.veterinaria.services;

import java.util.ArrayList;

import com.veterinaria.beans.Usuario;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IUsuario;
import com.veterinaria.utils.Constantes;

public class UsuarioService implements IUsuario {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IUsuario dao= factory.getUsuario();
	
	@Override
	public ArrayList<Usuario> listarUsuario() throws Exception {
		return dao.listarUsuario();
	}

	@Override
	public Usuario obtenerUsuario(Usuario obj) throws Exception {
		return dao.obtenerUsuario(obj);
	}

	@Override
	public String obtenerMaxUsuario() throws Exception {
		return dao.obtenerMaxUsuario();
	}

	@Override
	public String GrabarUsuario(Usuario obj) throws Exception {
		return dao.GrabarUsuario(obj);
	}

	@Override
	public String ModificarUsuario(Usuario obj) throws Exception {
		return dao.GrabarUsuario(obj);
	}

	@Override
	public String EliminarUsuario(Usuario obj) throws Exception {
		return dao.EliminarUsuario(obj);
	}

	@Override
	public int validarUsuario(Usuario obj) throws Exception {
		return dao.validarUsuario(obj);
	}

}

package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.UsuarioDAO;
import edu.everest.entity.Usuario;

public class UsuarioDAOService implements UsuarioService {
	
	private UsuarioDAO dao;
	private DAOFactory fabrica = null;

	public UsuarioDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getUsuarioDAO();
	}
	
	@Override
	public int validarUsuario(Usuario usuario) throws Exception {
		return dao.validarUsuario(usuario);
	}

	@Override
	public List<Usuario> obtenerTodosUsuario() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarUsuario(Usuario usuario) throws Exception {
		dao.insertar(usuario);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws Exception {
		dao.actualizar(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws Exception {
		dao.eliminar(usuario);
	}

	@Override
	public Usuario obtenerUsuario(Usuario usuario) throws Exception {
		return dao.obtenerUsuario(usuario);
	}

}

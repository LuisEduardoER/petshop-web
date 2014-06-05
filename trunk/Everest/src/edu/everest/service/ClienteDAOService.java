package edu.everest.service;

import java.util.List;

import edu.everest.dao.ClienteDAO;
import edu.everest.dao.DAOFactory;
import edu.everest.entity.Cliente;
import edu.everest.entity.Usuario;

public class ClienteDAOService implements ClienteService {
	
	private ClienteDAO dao;
	private DAOFactory fabrica = null;

	public ClienteDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getClienteDAO();
	}
	
	@Override
	public Cliente obtenerClienteByUsuario(Usuario usuario) throws Exception {
		return dao.obtenerClienteByUsuario(usuario);
	}

	@Override
	public List<Cliente> obtenerTodosCliente() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarCliente(Cliente cliente) throws Exception {
		dao.insertar(cliente);
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws Exception {
		dao.actualizar(cliente);
	}

	@Override
	public void eliminarCliente(Cliente cliente) throws Exception {
		dao.eliminar(cliente);
	}

	@Override
	public Cliente obtenerCliente(Cliente cliente) throws Exception {
		return dao.obtenerCliente(cliente);
	}
	
}

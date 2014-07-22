package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.LocalDAO;
import edu.everest.entity.Local;

public class LocalDAOService implements LocalService {

	private LocalDAO dao;
	private DAOFactory fabrica = null;

	public LocalDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getLocalDAO();
	}
	
	@Override
	public List<Local> obtenerTodosLocal() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarLocal(Local local) throws Exception {
		dao.insertar(local);

	}

	@Override
	public void actualizarLocal(Local local) throws Exception {
		dao.actualizar(local);

	}

	@Override
	public void eliminarLocal(Local local) throws Exception {
		dao.eliminar(local);

	}

	@Override
	public Local obtenerLocal(Local local) throws Exception {
		return dao.obtenerLocal(local);
	}

}

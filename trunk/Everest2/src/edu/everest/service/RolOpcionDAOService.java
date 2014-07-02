package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.RolOpcionDAO;
import edu.everest.entity.RolOpcion;

public class RolOpcionDAOService implements RolOpcionService {
	
	private RolOpcionDAO dao;
	private DAOFactory fabrica = null;

	public RolOpcionDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getRolOpcionDAO();
	}
	
	@Override
	public List<RolOpcion> obtenerTodosRolOpcion() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarRolOpcion(RolOpcion rolOpcion) throws Exception {
		dao.insertar(rolOpcion);
	}

	@Override
	public void actualizarRolOpcion(RolOpcion rolOpcion) throws Exception {
		dao.actualizar(rolOpcion);
	}

	@Override
	public void eliminarRolOpcion(RolOpcion rolOpcion) throws Exception {
		dao.eliminar(rolOpcion);
	}

	@Override
	public RolOpcion obtenerRolOpcion(RolOpcion rolOpcion) throws Exception {
		return dao.obtenerRolOpcion(rolOpcion);
	}

}

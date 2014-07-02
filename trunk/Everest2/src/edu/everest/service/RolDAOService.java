package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.RolDAO;
import edu.everest.entity.Rol;

public class RolDAOService implements RolService {
	
	private RolDAO dao;
	private DAOFactory fabrica = null;

	public RolDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getRolDAO();
	}
	
	@Override
	public List<Rol> obtenerTodosRol() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarRol(Rol rol) throws Exception {
		dao.insertar(rol);
	}

	@Override
	public void actualizarRol(Rol rol) throws Exception {
		dao.actualizar(rol);
	}

	@Override
	public void eliminarRol(Rol rol) throws Exception {
		dao.eliminar(rol);
	}

	@Override
	public Rol obtenerRol(Rol rol) throws Exception {
		return dao.obtenerRol(rol);
	}

}

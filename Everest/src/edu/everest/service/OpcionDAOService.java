package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.OpcionDAO;
import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;

public class OpcionDAOService implements OpcionService {
	
	private OpcionDAO dao;
	private DAOFactory fabrica = null;

	public OpcionDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getOpcionDAO();
	}
	
	@Override
	public List<Opcion> obtenerTodosOpcion() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public List<Opcion> obtenerOpcionParentByRol(Rol rol) throws Exception {
		return dao.obtenerOpcionParentByRol(rol);
	}

	@Override
	public List<Opcion> obtenerOpcionByParent(Opcion opcion) throws Exception {
		return dao.obtenerOpcionByParent(opcion);
	}

	@Override
	public void insertarOpcion(Opcion opcion) throws Exception {
		dao.insertar(opcion);
	}

	@Override
	public void actualizarOpcion(Opcion opcion) throws Exception {
		dao.actualizar(opcion);
	}

	@Override
	public void eliminarOpcion(Opcion opcion) throws Exception {
		dao.eliminar(opcion);
	}

	@Override
	public Opcion obtenerOpcion(Opcion opcion) throws Exception {
		return dao.obtenerOpcion(opcion);
	}

}

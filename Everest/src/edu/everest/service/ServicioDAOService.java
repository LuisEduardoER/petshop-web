package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.ServicioDAO;
import edu.everest.entity.Servicio;

public class ServicioDAOService implements ServicioService {
	
	private ServicioDAO dao;
	private DAOFactory fabrica = null;

	public ServicioDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getServicioDAO();
	}
	
	@Override
	public Servicio obtenerServicio(Servicio servicio) throws Exception {
		return dao.obtenerServicio(servicio);
	}

	@Override
	public List<Servicio> obtenerTodos()
			throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarCliente(Servicio servicio) throws Exception {
		dao.insertar(servicio);
	}

	@Override
	public void actualizarCliente(Servicio servicio) throws Exception {
		dao.actualizar(servicio);
	}

	@Override
	public void eliminarCliente(Servicio servicio) throws Exception {
		dao.eliminar(servicio);
	}

}

package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.DetalleCitaDAO;
import edu.everest.entity.Cita;
import edu.everest.entity.DetalleCita;

public class DetalleCitaDAOService implements DetalleCitaService {
	
	private DetalleCitaDAO dao;
	private DAOFactory fabrica = null;

	public DetalleCitaDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getDetalleCitaDAO();
	}
	
	@Override
	public List<DetalleCita> obtenerTodos(Cita cita) throws Exception {
		return dao.obtenerTodos(cita);
	}

	@Override
	public void insertarDetalleCita(DetalleCita detalleCita) throws Exception {
		dao.insertar(detalleCita);
	}

	@Override
	public void actualizarDetalleCita(DetalleCita detalleCita) throws Exception {
		dao.actualizar(detalleCita);
	}

	@Override
	public void eliminarDetalleCita(DetalleCita detalleCita) throws Exception {
		dao.actualizar(detalleCita);
	}

	@Override
	public DetalleCita obtenerDetalleCita(DetalleCita detalleCita)
			throws Exception {
		return dao.obtenerDetalleCita(detalleCita);
	}

}

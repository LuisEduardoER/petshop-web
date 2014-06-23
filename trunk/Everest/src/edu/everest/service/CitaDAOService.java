package edu.everest.service;

import java.util.Calendar;
import java.util.List;

import edu.everest.dao.CitaDAO;
import edu.everest.dao.DAOFactory;
import edu.everest.entity.Cita;

public class CitaDAOService implements CitaService{
	
	private CitaDAO dao;
	private DAOFactory fabrica = null;

	public CitaDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getCitaDAO();
	}
	
	@Override
	public Cita obtenerCita(Cita cita) throws Exception {
		return dao.obtenerCita(cita);
	}

	@Override
	public List<Cita> obtenerTodosCliente(Calendar objIni, Calendar objFin) throws Exception {
		return dao.obtenerTodos(objIni, objFin);
	}

	@Override
	public void insertarCliente(Cita cita) throws Exception {
		dao.insertar(cita);
	}

	@Override
	public void actualizarCliente(Cita cita) throws Exception {
		dao.actualizar(cita);
	}

	@Override
	public void eliminarCliente(Cita cita) throws Exception {
		dao.actualizar(cita);
	}

}

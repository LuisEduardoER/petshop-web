package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.MedicoDAO;
import edu.everest.entity.Medico;

public class MedicoDAOService implements MedicoService {
	
	private MedicoDAO dao;
	private DAOFactory fabrica = null;
	
	public MedicoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getMedicoDAO();
	}
	
	@Override
	public List<Medico> obtenerTodosMedico() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarMedico(Medico medico) throws Exception {
		dao.insertar(medico);
	}

	@Override
	public void actualizarMedico(Medico medico) throws Exception {
		dao.actualizar(medico);
	}

	@Override
	public void eliminarMedico(Medico medico) throws Exception {
		dao.eliminar(medico);
	}

	@Override
	public Medico obtenerMedico(Medico medico) throws Exception {
		return dao.obtenerMedico(medico);
	}

}

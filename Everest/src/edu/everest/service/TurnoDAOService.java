package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.RolDAO;
import edu.everest.dao.TurnoDAO;
import edu.everest.entity.Turno;

public class TurnoDAOService implements TurnoService {

	private TurnoDAO dao;
	private DAOFactory fabrica = null;

	public TurnoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getTurnoDAO();
	}
	
	@Override
	public List<Turno> obtenerTodosTurno() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarTurno(Turno turno) throws Exception {
		dao.insertar(turno);

	}

	@Override
	public void actualizarTurno(Turno turno) throws Exception {
		dao.actualizar(turno);

	}

	@Override
	public void eliminarTurno(Turno turno) throws Exception {
		dao.eliminar(turno);
	}

	@Override
	public Turno obtenerTurno(Turno turno) throws Exception {
		return dao.obtenerTurno(turno);
	}

}

package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.MascotaDAO;
import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;

public class MascotaDAOService implements MascotaService {
	
	private MascotaDAO dao;
	private DAOFactory fabrica = null;

	public MascotaDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getMascotaDAO();
	}
	
	@Override
	public List<Mascota> obtenerTodosMascota(Cliente cliente) throws Exception {
		return dao.obtenerTodos(cliente);
	}

	@Override
	public void insertarMascota(Mascota mascota) throws Exception {
		dao.insertar(mascota);
	}

	@Override
	public void actualizarMascota(Mascota mascota) throws Exception {
		dao.actualizar(mascota);
	}

	@Override
	public void eliminarMascota(Mascota mascota) throws Exception {
		dao.eliminar(mascota);
	}

	@Override
	public Mascota obtenerMascota(Mascota mascota) throws Exception {
		return dao.obtenerMascota(mascota);
	}

}

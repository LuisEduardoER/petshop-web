package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.TipoAnimalDAO;
import edu.everest.entity.TipoAnimal;

public class TipoAnimalDAOService implements TipoAnimalService {
	
	private TipoAnimalDAO dao;
	private DAOFactory fabrica = null;
	
	public TipoAnimalDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getTipoAnimalDAO();
	}
	
	@Override
	public List<TipoAnimal> obtenerTodosTipoAnimal() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarTipoAnimal(TipoAnimal tipoAnimal) throws Exception {
		dao.insertar(tipoAnimal);
	}

	@Override
	public void actualizarTipoAnimal(TipoAnimal tipoAnimal) throws Exception {
		dao.actualizar(tipoAnimal);
	}

	@Override
	public void eliminarTipoAnimal(TipoAnimal tipoAnimal) throws Exception {
		dao.eliminar(tipoAnimal);
	}

	@Override
	public TipoAnimal obtenerTipoAnimal(TipoAnimal tipoAnimal) throws Exception {
		return dao.obtenerTipoAnimal(tipoAnimal);
	}

}

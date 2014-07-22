package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.CorrelativoDAO;
import edu.everest.entity.Correlativo;

public class CorrelativoDAOService implements CorrelativoService {

	private CorrelativoDAO dao;
	private DAOFactory fabrica = null;
	
	public CorrelativoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getCorrelativoDAO();
	}
	
	@Override
	public List<Correlativo> obtenerTodosCorrelativo() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarCorrelativo(Correlativo correl) throws Exception {
		dao.insertar(correl);

	}

	@Override
	public void actualizarCorrelativo(Correlativo correl) throws Exception {
		dao.actualizar(correl);

	}

	@Override
	public void eliminarCorrelativo(Correlativo correl) throws Exception {
		dao.eliminar(correl);

	}

	@Override
	public Correlativo obtenerCorrelativo(Correlativo correl) throws Exception {
		return dao.obtenerCorrelativo(correl);
	}

}

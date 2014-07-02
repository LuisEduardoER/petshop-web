package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.TipoDocumentoDAO;
import edu.everest.entity.Cliente;
import edu.everest.entity.TipoDocumento;

public class TipoDocumentoDAOService implements TipoDocumentoService {
	
	private TipoDocumentoDAO dao;
	private DAOFactory fabrica = null;

	public TipoDocumentoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getTipoDocumentoDAO();
	}
	
	@Override
	public List<TipoDocumento> obtenerTodosTipoDocumento(Cliente cliente)
			throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public TipoDocumento obtenerTipoDocumento(TipoDocumento tipoDocumento)
			throws Exception {
		return dao.obtenerTipoDocumento(tipoDocumento);
	}

	@Override
	public void insertarTipoDocumento(TipoDocumento tipoDocumento)
			throws Exception {
		dao.insertar(tipoDocumento);
	}

	@Override
	public void actualizarTipoDocumento(TipoDocumento tipoDocumento)
			throws Exception {
		dao.actualizar(tipoDocumento);
	}

	@Override
	public void eliminarTipoDocumento(TipoDocumento tipoDocumento)
			throws Exception {
		dao.eliminar(tipoDocumento);
	}

}

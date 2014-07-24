package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.TipoProductoDAO;
import edu.everest.entity.TipoProducto;

public class TipoProductoDAOService implements TipoProductoService {

	private TipoProductoDAO dao;
	private DAOFactory fabrica = null;
	
	public TipoProductoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getTipoProductoDAO();
	}
	
	
	@Override
	public List<TipoProducto> obtenerTodosTipoProducto() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarTipoProducto(TipoProducto tipoProducto) throws Exception {
	dao.insertar(tipoProducto);

	}

	@Override
	public void actualizarTipoProducto(TipoProducto tipoProducto) throws Exception {
	dao.actualizar(tipoProducto);

	}

	@Override
	public void eliminarTipoProducto(TipoProducto tipoProducto)	throws Exception {
		dao.eliminar(tipoProducto);

	}

	@Override
	public TipoProducto obtenerTipoProducto(TipoProducto tipoProducto)
			throws Exception {
		return dao.obtenerTipoProducto(tipoProducto);
	}

}

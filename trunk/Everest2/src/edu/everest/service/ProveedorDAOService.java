package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.ProveedorDAO;
import edu.everest.entity.Proveedor;

public class ProveedorDAOService implements ProveedorService {
	
	private ProveedorDAO dao;
	private DAOFactory fabrica = null;

	public ProveedorDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getProveedorDAO();
	}

	
	@Override
	public List<Proveedor> obtenerTodosProveedores() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarProveedor(Proveedor proveedor) throws Exception {
		dao.insertar(proveedor);
	}

	@Override
	public void actualizarProveedor(Proveedor proveedor) throws Exception {
		dao.actualizar(proveedor);
	}

	@Override
	public void eliminarProveedor(Proveedor proveedor) throws Exception {
		dao.eliminar(proveedor);
	}

	@Override
	public Proveedor obtenerProveedor(Proveedor proveedor) throws Exception {
		return dao.obtenerProveedor(proveedor);
	}

}

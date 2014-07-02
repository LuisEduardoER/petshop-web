package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Proveedor;

public interface ProveedorDAO {
	
	public Proveedor obtenerProveedor(Proveedor proveedor) throws Exception;
	public List<Proveedor> obtenerTodos() throws Exception;
	public void insertar(Proveedor proveedor) throws Exception;
	public void actualizar(Proveedor proveedor) throws Exception;
	public void eliminar(Proveedor proveedor) throws Exception;
	
}

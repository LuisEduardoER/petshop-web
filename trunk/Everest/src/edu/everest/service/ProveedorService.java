package edu.everest.service;

import java.util.List;

import edu.everest.entity.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> obtenerTodosProveedores() throws Exception;
	public void insertarProveedor(Proveedor proveedor) throws Exception;
	public void actualizarProveedor(Proveedor proveedor) throws Exception;
	public void eliminarProveedor(Proveedor proveedor) throws Exception;
	public Proveedor obtenerProveedor(Proveedor proveedor) throws Exception;

}

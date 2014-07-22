package edu.everest.dao;

import java.util.List;

import edu.everest.entity.TipoProducto;

public interface TipoProductoDAO {
	public TipoProducto obtenerTipoProducto(TipoProducto tipoProducto) throws Exception;
	public List<TipoProducto> obtenerTodos() throws Exception;
	public void insertar(TipoProducto tipoProducto) throws Exception;
	public void actualizar(TipoProducto tipoProducto) throws Exception;
	public void eliminar(TipoProducto tipoProducto) throws Exception;
	
	

}

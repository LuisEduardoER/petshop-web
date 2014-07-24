package edu.everest.dao;

import java.util.List;

import edu.everest.entity.TipoProducto;

public interface TipoProductoDAO {
	public TipoProducto obtenerTipoProducto(TipoProducto TipoProducto) throws Exception;
	public List<TipoProducto> obtenerTodos() throws Exception;
	public void insertar(TipoProducto TipoProducto) throws Exception;
	public void actualizar(TipoProducto TipoProducto) throws Exception;
	public void eliminar(TipoProducto TipoProducto) throws Exception;
}

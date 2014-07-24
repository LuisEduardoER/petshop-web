package edu.everest.service;

import java.util.List;

import edu.everest.entity.TipoProducto;

public interface TipoProductoService {

	
	public List<TipoProducto> obtenerTodosTipoProducto() throws Exception;
	public void insertarTipoProducto(TipoProducto tipoProducto) throws Exception;
	public void actualizarTipoProducto(TipoProducto tipoProducto) throws Exception;
	public void eliminarTipoProducto(TipoProducto tipoProducto) throws Exception;
	public TipoProducto obtenerTipoProducto(TipoProducto tipoProducto) throws Exception;
}

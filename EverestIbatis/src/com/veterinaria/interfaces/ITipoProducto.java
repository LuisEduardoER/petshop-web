package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.TipoProducto;

public interface ITipoProducto {
	public abstract ArrayList<TipoProducto> listarTipoProducto() throws Exception;
	public abstract TipoProducto obtenerTipoProducto(TipoProducto obj) throws Exception;
	public abstract String GrabarTipoProducto(TipoProducto obj) throws Exception;
	public abstract String ModificarTipoProducto(TipoProducto obj) throws Exception;
	public abstract String EliminarTipoProducto(TipoProducto obj) throws Exception;
	
}

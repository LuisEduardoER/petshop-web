package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Proveedor;

public interface IProveedor {

	public abstract ArrayList<Proveedor> listarProveedor() throws Exception;
	public abstract Proveedor obtenerProveedor(Proveedor obj) throws Exception;
	public abstract String GrabarProveedor(Proveedor obj) throws Exception;
	public abstract String ModificarProveedor(Proveedor obj) throws Exception;
	public abstract String EliminarProveedor(Proveedor obj) throws Exception;
	
}

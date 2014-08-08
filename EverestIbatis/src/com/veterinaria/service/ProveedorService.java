package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Proveedor;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IProveedor;
import com.veterinaria.utils.Constantes;

public class ProveedorService implements IProveedor{

	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IProveedor dao= factory.getProveedor();
	@Override
	public ArrayList<Proveedor> listarProveedor() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarProveedor();
	}

	@Override
	public Proveedor obtenerProveedor(Proveedor obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.obtenerProveedor(obj);
	}

	@Override
	public String GrabarProveedor(Proveedor obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.GrabarProveedor(obj);
	}

	@Override
	public String ModificarProveedor(Proveedor obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.ModificarProveedor(obj);
	}

	@Override
	public String EliminarProveedor(Proveedor obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.EliminarProveedor(obj);
	}

}

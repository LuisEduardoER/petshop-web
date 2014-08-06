package com.veterinaria.services;

import java.util.ArrayList;

import com.veterinaria.Interfaces.ICliente;
import com.veterinaria.beans.Cliente;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.utils.Constantes;

public class ClienteService implements ICliente {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ICliente dao= factory.getCliente();
	
	@Override
	public ArrayList<Cliente> listarCliente(Cliente obj) throws Exception {
		return dao.listarCliente(obj);
	}

	@Override
	public Cliente obtenerCliente(Cliente obj) throws Exception {
		return dao.obtenerCliente(obj);
	}

	@Override
	public String obtenerMaxCliente() throws Exception {
		return dao.obtenerMaxCliente();
	}

	@Override
	public String GrabarCliente(Cliente obj) throws Exception {
		return dao.GrabarCliente(obj);
	}

	@Override
	public String ModificarCliente(Cliente obj) throws Exception {
		return dao.ModificarCliente(obj);
	}

	@Override
	public String EliminarCliente(Cliente obj) throws Exception {
		return dao.EliminarCliente(obj);
	}

}

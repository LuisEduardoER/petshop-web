package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Rol;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IRol;
import com.veterinaria.utils.Constantes;

public class RolService implements IRol {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IRol dao= factory.getRol();
	
	@Override
	public ArrayList<Rol> listarRol() throws Exception {
		return dao.listarRol();
	}

	@Override
	public Rol obtenerRol(Rol obj) throws Exception {
		return dao.obtenerRol(obj);
	}

	@Override
	public String GrabarRol(Rol obj) throws Exception {
		return dao.GrabarRol(obj);
	}

	@Override
	public String ModificarRol(Rol obj) throws Exception {
		return dao.ModificarRol(obj);
	}

	@Override
	public String EliminarRol(Rol obj) throws Exception {
		return dao.EliminarRol(obj);
	}

}

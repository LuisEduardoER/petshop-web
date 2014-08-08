package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.RolOpcion;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IRolOpcion;
import com.veterinaria.utils.Constantes;

public class RolOpcionService implements IRolOpcion {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IRolOpcion dao= factory.getRolOpcion();
	
	@Override
	public ArrayList<RolOpcion> listarRolOpcion() throws Exception {
		return dao.listarRolOpcion();
	}

	@Override
	public RolOpcion obtenerRolOpcion(RolOpcion obj) throws Exception {
		return dao.obtenerRolOpcion(obj);
	}

	@Override
	public String GrabarRolOpcion(RolOpcion obj) throws Exception {
		return dao.GrabarRolOpcion(obj);
	}

	@Override
	public String ModificarRolOpcion(RolOpcion obj) throws Exception {
		return dao.ModificarRolOpcion(obj);
	}

	@Override
	public String EliminarRolOpcion(RolOpcion obj) throws Exception {
		return dao.EliminarRolOpcion(obj);
	}

}

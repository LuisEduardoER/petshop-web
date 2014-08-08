package com.veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Rol;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IOpcion;
import com.veterinaria.utils.Constantes;

public class OpcionService implements IOpcion {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IOpcion dao= factory.getOpcion();
	
	@Override
	public ArrayList<Opcion> listarOpcion() throws Exception {
		return dao.listarOpcion();
	}

	@Override
	public Opcion obtenerOpcion(Opcion obj) throws Exception {
		return dao.obtenerOpcion(obj);
	}

	@Override
	public String GrabarOpcion(Opcion obj) throws Exception {
		return dao.GrabarOpcion(obj);
	}

	@Override
	public String ModificarOpcion(Opcion obj) throws Exception {
		return dao.ModificarOpcion(obj);
	}

	@Override
	public String EliminarOpcion(Opcion obj) throws Exception {
		return dao.EliminarOpcion(obj);
	}

	@Override
	public List<Opcion> obtenerOpcionParentByRol(Rol obj) throws Exception {
		return dao.obtenerOpcionParentByRol(obj);
	}

	@Override
	public List<Opcion> obtenerOpcionByParent(Opcion obj) throws Exception {
		return dao.obtenerOpcionByParent(obj);
	}

}

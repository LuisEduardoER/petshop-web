package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Local;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.ILocal;
import com.veterinaria.utils.Constantes;

public class LocalService implements ILocal{
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ILocal dao= factory.getLocal();

	@Override
	public ArrayList<Local> listarLocal() throws Exception {
		
		return dao.listarLocal();
	}

	@Override
	public Local obtenerLocal(Local obj) throws Exception {
		
		return dao.obtenerLocal(obj);
	}

	@Override
	public String GrabarLocal(Local obj) throws Exception {
	
		return dao.GrabarLocal(obj);
	}

	@Override
	public String ModificarLocal(Local obj) throws Exception {
		
		return dao.ModificarLocal(obj);
	}

	@Override
	public String EliminarLocal(Local obj) throws Exception {
	
		return dao.EliminarLocal(obj);
	}

}

package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Servicio;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IServicio;
import com.veterinaria.utils.Constantes;

public class ServicioService implements IServicio {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IServicio dao= factory.getServicio();
	
	@Override
	public ArrayList<Servicio> listarServicio() throws Exception {
		return dao.listarServicio();
	}

	@Override
	public Servicio obtenerServicio(Servicio obj) throws Exception {
		return dao.obtenerServicio(obj);
	}

	@Override
	public String GrabarServicio(Servicio obj) throws Exception {
		return dao.GrabarServicio(obj);
	}

	@Override
	public String ModificarServicio(Servicio obj) throws Exception {
		return dao.ModificarServicio(obj);
	}

	@Override
	public String EliminarServicio(Servicio obj) throws Exception {
		return dao.EliminarServicio(obj);
	}

}

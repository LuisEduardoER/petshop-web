package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Cita;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.ICita;
import com.veterinaria.utils.Constantes;

public class CitaService implements ICita {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ICita dao= factory.getCita();
	
	@Override
	public ArrayList<Cita> listarCita() throws Exception {
		return dao.listarCita();
	}

	@Override
	public Cita obtenerCita(Cita obj) throws Exception {
		return dao.obtenerCita(obj);
	}

	@Override
	public String GrabarCita(Cita obj) throws Exception {
		return dao.GrabarCita(obj);
	}

	@Override
	public String ModificarCita(Cita obj) throws Exception {
		return dao.ModificarCita(obj);
	}

	@Override
	public String EliminarCita(Cita obj) throws Exception {
		return dao.EliminarCita(obj);
	}

}

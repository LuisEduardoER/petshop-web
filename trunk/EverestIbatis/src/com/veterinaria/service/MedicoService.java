package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Medico;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IMedico;
import com.veterinaria.utils.Constantes;

public class MedicoService implements IMedico {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IMedico dao= factory.getMedico();
	
	@Override
	public ArrayList<Medico> listarMedico() throws Exception {
		return dao.listarMedico();
	}

	@Override
	public Medico obtenerMedico(Medico obj) throws Exception {
		return dao.obtenerMedico(obj);
	}

	@Override
	public String GrabarMedico(Medico obj) throws Exception {
		return dao.GrabarMedico(obj);
	}

	@Override
	public String ModificarMedico(Medico obj) throws Exception {
		return dao.ModificarMedico(obj);
	}

	@Override
	public String EliminarMedico(Medico obj) throws Exception {
		return dao.EliminarMedico(obj);
	}

}

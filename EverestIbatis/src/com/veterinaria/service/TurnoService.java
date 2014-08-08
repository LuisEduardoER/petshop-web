package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Turno;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.ITurno;
import com.veterinaria.utils.Constantes;

public class TurnoService implements ITurno{

	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ITurno dao= factory.getTurno();
	@Override
	public ArrayList<Turno> listarTurno() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTurno();
	}

	@Override
	public Turno obtenerTurno(Turno obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.obtenerTurno(obj);
	}

	@Override
	public String GrabarTurno(Turno obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.GrabarTurno(obj);
	}

	@Override
	public String ModificarTurno(Turno obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.ModificarTurno(obj);
	}

	@Override
	public String EliminarTurno(Turno obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.EliminarTurno(obj);
	}

}

package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Cita;
import com.veterinaria.beans.DetalleCita;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IDetalleCita;
import com.veterinaria.utils.Constantes;

public class DetalleCitaService implements IDetalleCita {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IDetalleCita dao= factory.getDetalleCita();
	
	@Override
	public ArrayList<DetalleCita> listarDetalleCita() throws Exception {
		return dao.listarDetalleCita();
	}

	@Override
	public DetalleCita obtenerDetalleCita(DetalleCita obj) throws Exception {
		return dao.obtenerDetalleCita(obj);
	}

	@Override
	public String GrabarDetalleCita(DetalleCita obj) throws Exception {
		return dao.GrabarDetalleCita(obj);
	}

	@Override
	public String ModificarDetalleCita(DetalleCita obj) throws Exception {
		return dao.ModificarDetalleCita(obj);
	}

	@Override
	public String EliminarDetalleCita(DetalleCita obj) throws Exception {
		return dao.EliminarDetalleCita(obj);
	}

	@Override
	public ArrayList<DetalleCita> obtenerDetalleCita(Cita obj) throws Exception {
		return dao.obtenerDetalleCita(obj);
	}

}

package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.HistoriaClinica;
import com.veterinaria.beans.Mascota;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IHistoriaClinica;
import com.veterinaria.utils.Constantes;

public class HistoriaClinicaService implements IHistoriaClinica {

	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IHistoriaClinica dao= factory.getHistoriaClinica();
	
	@Override
	public ArrayList<HistoriaClinica> listarHistoriaClinica(Mascota obj) throws Exception {
		return dao.listarHistoriaClinica(obj);
	}

	@Override
	public HistoriaClinica obtenerHistoriaClinica(HistoriaClinica obj) throws Exception {
		return dao.obtenerHistoriaClinica(obj);
	}

	@Override
	public String GrabarHistoriaClinica(HistoriaClinica obj) throws Exception {
		return dao.GrabarHistoriaClinica(obj);
	}

	@Override
	public String ModificarHistoriaClinica(HistoriaClinica obj) throws Exception {
		return dao.ModificarHistoriaClinica(obj);
	}

	@Override
	public String EliminarHistoriaClinica(HistoriaClinica obj) throws Exception {
		return dao.EliminarHistoriaClinica(obj);
	}

}

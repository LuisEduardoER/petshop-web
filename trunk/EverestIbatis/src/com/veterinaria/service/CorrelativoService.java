package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Correlativo;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.ICorrelativo;
import com.veterinaria.utils.Constantes;

public class CorrelativoService implements ICorrelativo {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ICorrelativo dao= factory.getCorrelativo();
	
	@Override
	public ArrayList<Correlativo> listarCorrelativo() throws Exception {
		return dao.listarCorrelativo();
	}

	@Override
	public Correlativo obtenerCorrelativo(Correlativo obj) throws Exception {
		return dao.obtenerCorrelativo(obj);
	}

	@Override
	public String GrabarCorrelativo(Correlativo obj) throws Exception {
		return dao.GrabarCorrelativo(obj);
	}

	@Override
	public String ModificarCorrelativo(Correlativo obj) throws Exception {
		return dao.ModificarCorrelativo(obj);
	}

	@Override
	public String EliminarCorrelativo(Correlativo obj) throws Exception {
		return dao.EliminarCorrelativo(obj);
	}

	@Override
	public Correlativo obtenerSigCorrelativo(Correlativo obj) throws Exception {
		return dao.obtenerSigCorrelativo(obj);
	}

}

package com.veterinaria.services;

import java.util.ArrayList;

import com.veterinaria.Interfaces.ITipoAnimal;
import com.veterinaria.beans.TipoAnimal;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.utils.Constantes;

public class TipoAnimalService implements ITipoAnimal {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ITipoAnimal dao= factory.getTipoAnimal();
	
	@Override
	public ArrayList<TipoAnimal> listarTipoAnimal() throws Exception {
		return dao.listarTipoAnimal();
	}

	@Override
	public TipoAnimal obtenerTipoAnimal(TipoAnimal obj) throws Exception {
		return dao.obtenerTipoAnimal(obj);
	}

	@Override
	public String GrabarTipoAnimal(TipoAnimal obj) throws Exception {
		return dao.GrabarTipoAnimal(obj);
	}

	@Override
	public String ModificarTipoAnimal(TipoAnimal obj) throws Exception {
		return dao.ModificarTipoAnimal(obj);
	}

	@Override
	public String EliminarTipoAnimal(TipoAnimal obj) throws Exception {
		return dao.EliminarTipoAnimal(obj);
	}

}

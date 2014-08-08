package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.TipoProducto;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.ITipoProducto;
import com.veterinaria.utils.Constantes;

public class TipoProductoService implements ITipoProducto {

	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ITipoProducto dao= factory.getTipoProducto();
	@Override
	public ArrayList<TipoProducto> listarTipoProducto() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTipoProducto();
	}

	@Override
	public TipoProducto obtenerTipoProducto(TipoProducto obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.obtenerTipoProducto(obj);
	}

	@Override
	public String GrabarTipoProducto(TipoProducto obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.GrabarTipoProducto(obj);
	}

	@Override
	public String ModificarTipoProducto(TipoProducto obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.ModificarTipoProducto(obj);
	}

	@Override
	public String EliminarTipoProducto(TipoProducto obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.EliminarTipoProducto(obj);
	}

}

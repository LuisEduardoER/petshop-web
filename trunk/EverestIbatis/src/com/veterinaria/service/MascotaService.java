package com.veterinaria.service;

import java.util.ArrayList;

import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Mascota;
import com.veterinaria.factory.DAOFactory;
import com.veterinaria.interfaces.IMascota;
import com.veterinaria.utils.Constantes;

public class MascotaService implements IMascota {
	
	DAOFactory factory= DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	IMascota dao= factory.getIMascota();
	@Override
	public ArrayList<Mascota> listarMascota() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarMascota();
	}
	@Override
	public int GrabarMascota(Mascota obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.GrabarMascota(obj);
	}
	@Override
	public int ModificarMascota(Mascota obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.ModificarMascota(obj);
	}
	@Override
	public int EliminarMascota(Mascota obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.EliminarMascota(obj);
	}
	@Override
	public Mascota obtenerMascota(Mascota obj) throws Exception {
		return dao.obtenerMascota(obj);
	}
	@Override
	public ArrayList<Mascota> obtenerMascotaXCliente(Cliente obj)
			throws Exception {
		return dao.obtenerMascotaXCliente(obj);
	}
	@Override
	public Mascota obtenerImgMascota(Mascota obj) throws Exception {
		return dao.obtenerImgMascota(obj);
	}	
}

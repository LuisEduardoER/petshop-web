package com.veterinaria.factory;

import com.veterinaria.Interfaces.ICliente;
import com.veterinaria.Interfaces.IMascota;
import com.veterinaria.Interfaces.ITipoAnimal;
import com.veterinaria.Interfaces.IUsuario;
import com.veterinaria.dao.ClienteDAO;
import com.veterinaria.dao.MascotaDAO;
import com.veterinaria.dao.TipoAnimalDAO;
import com.veterinaria.dao.UsuarioDAO;



public class MysqlDaoFactory extends DAOFactory {

	@Override
	public IMascota getIMascota() {
		return new MascotaDAO();
	}
	
	@Override
	public ICliente getCliente() {
		return new ClienteDAO();
	}

	@Override
	public IUsuario getUsuario() {
		return new UsuarioDAO();
	}

	@Override
	public ITipoAnimal getTipoAnimal() {
		return new TipoAnimalDAO();
	}

}

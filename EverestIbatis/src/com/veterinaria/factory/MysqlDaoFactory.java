package com.veterinaria.factory;

import com.veterinaria.dao.ClienteDAO;
import com.veterinaria.dao.MascotaDAO;
import com.veterinaria.dao.OpcionDAO;
import com.veterinaria.dao.RolDAO;
import com.veterinaria.dao.TipoAnimalDAO;
import com.veterinaria.dao.UsuarioDAO;
import com.veterinaria.interfaces.ICliente;
import com.veterinaria.interfaces.IMascota;
import com.veterinaria.interfaces.IOpcion;
import com.veterinaria.interfaces.IRol;
import com.veterinaria.interfaces.ITipoAnimal;
import com.veterinaria.interfaces.IUsuario;



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

	@Override
	public IRol getRol() {
		return new RolDAO();
	}

	@Override
	public IOpcion getOpcion() {
		return new OpcionDAO();
	}

}

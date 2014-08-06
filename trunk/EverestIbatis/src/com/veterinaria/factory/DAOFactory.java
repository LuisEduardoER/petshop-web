package com.veterinaria.factory;

import com.veterinaria.interfaces.ICliente;
import com.veterinaria.interfaces.IMascota;
import com.veterinaria.interfaces.IOpcion;
import com.veterinaria.interfaces.IRol;
import com.veterinaria.interfaces.ITipoAnimal;
import com.veterinaria.interfaces.IUsuario;

public abstract class DAOFactory {

	public static final int MYSQL=1;
	public static final int SQL=2;
	public static final int ORACLE=3;
	public static final int DB2=4;
	
	public abstract IMascota getIMascota();	
	public abstract ICliente getCliente();
	public abstract IUsuario getUsuario();
	public abstract ITipoAnimal getTipoAnimal();
	public abstract IRol getRol();
	public abstract IOpcion getOpcion();
	
	public static DAOFactory getDAOFactory(int factory){
		switch(factory){
		case MYSQL:
			return new MysqlDaoFactory();
		case SQL:
			return null;
		case ORACLE:
			return null;
		default:
			return null;
		}
		
	}
	
}


package com.veterinaria.factory;

import com.veterinaria.interfaces.ICita;
import com.veterinaria.interfaces.ICliente;
import com.veterinaria.interfaces.ICorrelativo;
import com.veterinaria.interfaces.IDetalleCita;
import com.veterinaria.interfaces.IHistoriaClinica;
import com.veterinaria.interfaces.ILocal;
import com.veterinaria.interfaces.IMascota;
import com.veterinaria.interfaces.IMedico;
import com.veterinaria.interfaces.IOpcion;
import com.veterinaria.interfaces.IProveedor;
import com.veterinaria.interfaces.IRol;
import com.veterinaria.interfaces.IRolOpcion;
import com.veterinaria.interfaces.IServicio;
import com.veterinaria.interfaces.ITipoAnimal;
import com.veterinaria.interfaces.ITipoProducto;
import com.veterinaria.interfaces.ITurno;
import com.veterinaria.interfaces.IUsuario;

public abstract class DAOFactory {

	public static final int MYSQL=1;
	public static final int SQL=2;
	public static final int ORACLE=3;
	public static final int DB2=4;
	
	public abstract IMascota 			getIMascota();	
	public abstract ICliente 			getCliente();
	public abstract IUsuario 			getUsuario();
	public abstract ITipoAnimal 		getTipoAnimal();
	public abstract IRol 				getRol();
	public abstract IOpcion 			getOpcion();
	public abstract ICorrelativo 		getCorrelativo();
	public abstract ICita 				getCita();
	public abstract ILocal 				getLocal();
	public abstract IProveedor 			getProveedor();
	public abstract ITipoProducto 		getTipoProducto();
	public abstract ITurno 				getTurno();
	public abstract IRolOpcion 			getRolOpcion();
	public abstract IMedico 			getMedico();
	public abstract IDetalleCita 		getDetalleCita();
	public abstract IServicio			getServicio();
	public abstract IHistoriaClinica	getHistoriaClinica();
	
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


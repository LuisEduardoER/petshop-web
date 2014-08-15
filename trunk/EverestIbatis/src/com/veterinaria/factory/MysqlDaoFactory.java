package com.veterinaria.factory;

import com.veterinaria.dao.CitaDAO;
import com.veterinaria.dao.ClienteDAO;
import com.veterinaria.dao.CorrelativoDAO;
import com.veterinaria.dao.DetalleCitaDAO;
import com.veterinaria.dao.HistoriaClinicaDAO;
import com.veterinaria.dao.LocalDAO;
import com.veterinaria.dao.MascotaDAO;
import com.veterinaria.dao.MedicoDAO;
import com.veterinaria.dao.OpcionDAO;
import com.veterinaria.dao.ProveedorDAO;
import com.veterinaria.dao.RolDAO;
import com.veterinaria.dao.RolOpcionDAO;
import com.veterinaria.dao.ServicioDAO;
import com.veterinaria.dao.TipoAnimalDAO;
import com.veterinaria.dao.TipoProductoDAO;
import com.veterinaria.dao.TurnoDAO;
import com.veterinaria.dao.UsuarioDAO;
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

	@Override
	public ICorrelativo getCorrelativo() {
		return new CorrelativoDAO();
	}

	@Override
	public ICita getCita() {
		return new CitaDAO();
	}

	@Override
	public ILocal getLocal() {
		return new LocalDAO();
	}

	@Override
	public IProveedor getProveedor() {
		return new ProveedorDAO();
	}

	@Override
	public ITipoProducto getTipoProducto() {
		return new TipoProductoDAO();
	}

	@Override
	public ITurno getTurno() {
		return new TurnoDAO();
	}

	@Override
	public IRolOpcion getRolOpcion() {
		return new RolOpcionDAO();
	}

	@Override
	public IMedico getMedico() {
		return new MedicoDAO();
	}

	@Override
	public IDetalleCita getDetalleCita() {
		return new DetalleCitaDAO();
	}

	@Override
	public IServicio getServicio() {
		return new ServicioDAO();
	}

	@Override
	public IHistoriaClinica getHistoriaClinica() {
		return new HistoriaClinicaDAO();
	}

}

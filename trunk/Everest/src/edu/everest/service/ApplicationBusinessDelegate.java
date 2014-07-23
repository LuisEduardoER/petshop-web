package edu.everest.service;

import edu.everest.dao.DAOFactory;

public class ApplicationBusinessDelegate {

	// Se especifica la factoria con la cual trabajamos
	// Se hace aqui para no ejecutarlo en cada Service.
	
	public ProveedorService getProveedorService() {
		return new ProveedorDAOService( DAOFactory.JPA );
	}
	
	public UsuarioService getUsuarioService() {
		return new UsuarioDAOService( DAOFactory.JPA );
	}
	
	public ClienteService getClienteService() {
		return new ClienteDAOService( DAOFactory.JPA );
	}
	
	public RolService getRolService() {
		return new RolDAOService( DAOFactory.JPA );
	}
	
	public OpcionService getOpcionService() {
		return new OpcionDAOService( DAOFactory.JPA );
	}
	
	public MascotaService getMascotaService() {
		return new MascotaDAOService( DAOFactory.JPA );
	}
	
	public CitaService getCitaService() {
		return new CitaDAOService( DAOFactory.JPA );
	}
	
	public RolOpcionService getRolOpcionService() {
		return new RolOpcionDAOService( DAOFactory.JPA );
	}
	
	public ServicioService getServicioService() {
		return new ServicioDAOService( DAOFactory.JPA );
	}
	
	public DetalleCitaService getDetalleCitaDAOService() {
		return new DetalleCitaDAOService( DAOFactory.JPA );
	}
	
	public LocalService getLocalService() {
		return new LocalDAOService( DAOFactory.JPA );
	}
	
	public TurnoService getTurnoService() {
		return new TurnoDAOService( DAOFactory.JPA );
	}

	public TipoProductoService getTipoProductoDAOService() {
		return new TipoProductoDAOService( DAOFactory.JPA );
	}
	
	public TipoAnimalService getTipoAnimalDAOService() {
		return new TipoAnimalDAOService( DAOFactory.JPA );
	}
	
	public CorrelativoService getCorrelativoService() {
		return new CorrelativoDAOService( DAOFactory.JPA );
	}
	
	public MedicoService getMedicoService() {
		return new MedicoDAOService( DAOFactory.JPA );
	}
	
}

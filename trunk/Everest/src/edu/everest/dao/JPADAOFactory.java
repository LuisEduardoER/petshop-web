package edu.everest.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPADAOFactory extends DAOFactory {
	private EntityManagerFactory emf;
	
	public JPADAOFactory (){
		/*
		 * 	Referenciamos a nuestra unidad de persistencia
		 *	JPA-Web para gestionar nuestras entidades
		 */
		emf=Persistence.createEntityManagerFactory("JPA-Web");
	}
	
	@Override
	public ProveedorDAO getProveedorDAO() {
		ProveedorJPADAO ed =  new ProveedorJPADAO();
		ed.setEntityManagerFactory(emf);
		return (ProveedorDAO)ed;
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		UsuarioJPADAO ed =  new UsuarioJPADAO();
		ed.setEntityManagerFactory(emf);
		return (UsuarioDAO)ed;
	}

	@Override
	public ClienteDAO getClienteDAO() {
		ClienteJPADAO ed =  new ClienteJPADAO();
		ed.setEntityManagerFactory(emf);
		return (ClienteDAO)ed;
	}

	@Override
	public RolDAO getRolDAO() {
		RolJPADAO ed =  new RolJPADAO();
		ed.setEntityManagerFactory(emf);
		return (RolDAO)ed;
	}

	@Override
	public OpcionDAO getOpcionDAO() {
		OpcionJPADAO ed =  new OpcionJPADAO();
		ed.setEntityManagerFactory(emf);
		return (OpcionDAO)ed;
	}

	@Override
	public MascotaDAO getMascotaDAO() {
		MascotaJPADAO ed =  new MascotaJPADAO();
		ed.setEntityManagerFactory(emf);
		return (MascotaDAO)ed;
	}

	@Override
	public CitaDAO getCitaDAO() {
		CitaJPADAO ed =  new CitaJPADAO();
		ed.setEntityManagerFactory(emf);
		return (CitaDAO)ed;
	}

	@Override
	public RolOpcionDAO getRolOpcionDAO() {
		RolOpcionJPADAO ed =  new RolOpcionJPADAO();
		ed.setEntityManagerFactory(emf);
		return (RolOpcionDAO)ed;
	}

	@Override
	public ServicioDAO getServicioDAO() {
		ServicioJPADAO ed =  new ServicioJPADAO();
		ed.setEntityManagerFactory(emf);
		return (ServicioDAO)ed;
	}

	@Override
	public DetalleCitaDAO getDetalleCitaDAO() {
		DetalleCitaJPADAO ed =  new DetalleCitaJPADAO();
		ed.setEntityManagerFactory(emf);
		return (DetalleCitaDAO)ed;
	}

	@Override
	public TipoProductoDAO getTipoProductoDAO() {
		TipoProductoJPADAO ed =  new TipoProductoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (TipoProductoDAO)ed;
	}

	@Override
	public TurnoDAO getTurnoDAO() {
		TurnoJPADAO ed =  new TurnoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (TurnoDAO)ed;
	}

	@Override
	public LocalDAO getLocalDAO() {
		LocalJPADAO ed =  new LocalJPADAO();
		ed.setEntityManagerFactory(emf);
		return (LocalDAO)ed;
	}
	
	@Override

	public TipoAnimalDAO getTipoAnimalDAO() {
		TipoAnimalJPADAO ed =  new TipoAnimalJPADAO();
		ed.setEntityManagerFactory(emf);
		return (TipoAnimalDAO)ed;
	}

	@Override
	public CorrelativoDAO getCorrelativoDAO() {
		CorrelativoJPADAO ed =  new CorrelativoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (CorrelativoDAO)ed;
	}

	@Override
	public MedicoDAO getMedicoDAO() {
		MedicoJPADAO ed =  new MedicoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (MedicoDAO)ed;
	}

	@Override
	public FormaPagoDAO getFormaPagoDAO() {
		FormaPagoJPADAO ed =  new FormaPagoJPADAO();
		ed.setEntityManagerFactory(emf);
		return (FormaPagoDAO)ed;
	}

}

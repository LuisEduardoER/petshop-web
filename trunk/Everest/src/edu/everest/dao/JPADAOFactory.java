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
}

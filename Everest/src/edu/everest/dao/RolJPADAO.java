package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Rol;
import edu.everest.util.Constants;

public class RolJPADAO implements RolDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public Rol obtenerRol(Rol rol) throws Exception {
		em=emf.createEntityManager();
		Rol obj=(Rol)em.find(Rol.class,rol.getIdRol());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Rol> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Rol> listaRol = new ArrayList<Rol>();
		List l =  em.createQuery( "SELECT c FROM Rol c ORDER BY c.idRol" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Rol entidad = (Rol)l.get(i);
			listaRol.add(entidad);
		}
		em.close();
		return listaRol;
	}

	@Override
	public void insertar(Rol rol) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Rol entidadRol=new Rol();
		
		entidadRol.setDescripcion(rol.getDescripcion());
		
		if(rol.getEstado() == null)
			entidadRol.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadRol);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Rol rol) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(rol.getEstado() == null)
			rol.setEstado("1");
		
		if(rol.getEstado().equals(Constants.KV_STATE_INACTIVE))
			rol.setEstado( Constants.KV_STATE_COD_INACTIVE );
		
		else if(rol.getEstado().equals(Constants.KV_STATE_ACTIVE))
			rol.setEstado( Constants.KV_STATE_COD_ACTIVE );
		
		em.merge(rol);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Rol rol) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Rol obj=(Rol)em.find(Rol.class,rol.getIdRol());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

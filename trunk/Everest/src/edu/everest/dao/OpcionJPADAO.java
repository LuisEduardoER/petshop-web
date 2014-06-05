package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;

public class OpcionJPADAO implements OpcionDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Opcion obtenerOpcion(Opcion opcion) throws Exception {
		em=emf.createEntityManager();
		Opcion obj=(Opcion)em.find(Opcion.class,opcion.getIdOpcion());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Opcion> obtenerOpcionParentByRol(Rol rol) throws Exception {
		em=emf.createEntityManager();
		
		List<Opcion> listaOpcion = new ArrayList<Opcion>();
		Query query = em.createQuery( "SELECT o FROM RolOpcion ro "
									+ "INNER JOIN ro.opcion o "
									+ "INNER JOIN ro.rol r "
									+ "where r.idRol = :idRol "
									+ "AND o.opcion IS NULL ORDER BY o.orden " );
		query.setParameter("idRol", rol.getIdRol());
		List l =  query.getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Opcion entidad = (Opcion)l.get(i);
			listaOpcion.add(entidad);
		}
		em.close();
		return listaOpcion;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Opcion> obtenerOpcionByParent(Opcion opcion) throws Exception {
		em=emf.createEntityManager();
		
		List<Opcion> listaOpcion = new ArrayList<Opcion>();
		Query query = em.createQuery( "SELECT o FROM Opcion o "
									+ "where o.opcion = :opcion "
									+ "ORDER BY o.orden " );
		query.setParameter("opcion", opcion);
		
		List l =  query.getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Opcion entidad = (Opcion)l.get(i);
			listaOpcion.add(entidad);
		}
		em.close();
		return listaOpcion;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Opcion> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Opcion> listaOpcion = new ArrayList<Opcion>();
		List l =  em.createQuery( "SELECT c FROM Opcion c ORDER BY c.idOpcion" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Opcion entidad = (Opcion)l.get(i);
			listaOpcion.add(entidad);
		}
		em.close();
		return listaOpcion;
	}

	@Override
	public void insertar(Opcion opcion) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Opcion entidadOpcion=new Opcion();
			
		//FALTA IMPLEMENTAR ************************************
		//entidadOpcion.setUser(opcion.getUser());
		//entidadOpcion.setPass(opcion.getPass());
		
		if(opcion.getEstado() == null)
			entidadOpcion.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadOpcion);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Opcion opcion) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(opcion.getEstado() == null)
			opcion.setEstado("1");
		
		em.merge(opcion);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Opcion opcion) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Opcion obj=(Opcion)em.find(Opcion.class,opcion.getIdOpcion());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	
}

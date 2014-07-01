package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.RolOpcion;

public class RolOpcionJPADAO implements RolOpcionDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public RolOpcion obtenerRolOpcion(RolOpcion rolOpcion) throws Exception {
		em=emf.createEntityManager();
		RolOpcion obj=(RolOpcion)em.find(RolOpcion.class,rolOpcion.getId() );
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<RolOpcion> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<RolOpcion> listaRolOpcion = new ArrayList<RolOpcion>();
		List l =  em.createQuery( "SELECT o FROM RolOpcion o ORDER BY o.idRol, o.idOpcion" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			RolOpcion entidad = (RolOpcion)l.get(i);
			listaRolOpcion.add(entidad);
		}
		em.close();
		return listaRolOpcion;
	}

	@Override
	public void insertar(RolOpcion rolOpcion) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
				
		//2.ejecuta las operaciones
//		em.persist( rolOpcion );
		Query query = em.createQuery( "INSERT INTO RolOpcion o ( o.idRol, o.idOpcion ) "
				+ "VALUES( :idRol, :idOpcion ) " );
		
		query.setParameter("idRol", 	rolOpcion.getId().getIdRol() );
		query.setParameter("idOpcion", 	rolOpcion.getId().getIdOpcion() );
		query.executeUpdate();
		
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(RolOpcion rolOpcion) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
//		em.merge(rolOpcion);
		Query query = em.createQuery( "UPDATE RolOpcion o "
				+ "SET o.idOpcion = :idOpcion "
				+ "WHERE o.idOpcion = :idOpcionPK "
				+ "AND o.idRol = :idRolPK " );
		
		query.setParameter("idOpcion", 	rolOpcion.getOpcion().getIdOpcion() );
		query.setParameter("idOpcionPK",rolOpcion.getId().getIdOpcion() );
		query.setParameter("idRolPK", 	rolOpcion.getId().getIdRol() );
		query.executeUpdate();
		
		em.flush();
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(RolOpcion rolOpcion) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		RolOpcion obj=(RolOpcion)em.find( RolOpcion.class,rolOpcion.getId() );
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

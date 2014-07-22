package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Local;


public class LocalJPADAO implements LocalDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Local obtenerLocal(Local local) throws Exception {
		em=emf.createEntityManager();
		Local obj=(Local)em.find(Local.class,local.getIdLocal());
		return obj;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List<Local> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Local> listaLocal = new ArrayList<Local>();
		List l =  em.createQuery( "SELECT c FROM Local c ORDER BY c.idLocal" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Local entidad = (Local)l.get(i);
			listaLocal.add(entidad);
		}
		em.close();
		return listaLocal;
	}

	@Override
	public void insertar(Local local) throws Exception {
		em=emf.createEntityManager();

		
		//1.inicia la transacción
		em.getTransaction().begin();
		
		Local entidadLocal=new Local();
		
		entidadLocal.setNomLocal(local.getNomLocal());
		
	
				
		//2.ejecuta las operaciones
		em.persist(entidadLocal);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void actualizar(Local local) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		
		em.merge(local);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(Local local) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Local obj=(Local)em.find(Local.class,local.getIdLocal());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

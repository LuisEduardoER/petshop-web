package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.Servicio;

public class ServicioJPADAO implements ServicioDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public Servicio obtenerServicio(Servicio servicio) throws Exception {
		em=emf.createEntityManager();
		Servicio obj=(Servicio)em.find(Servicio.class,servicio.getIdServicio());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Servicio> obtenerTodos()
			throws Exception {
		em=emf.createEntityManager();
		
		List<Servicio> listaServicio = new ArrayList<Servicio>();		
		Query query = em.createQuery( "SELECT c FROM Servicio c " );
		
		List l =  query.getResultList();
		
		for ( int i=0; i < l.size(); i++ ) {
			Servicio entidad = (Servicio)l.get(i);
			listaServicio.add(entidad);
		}
		em.close();
		return listaServicio;
	}

	@Override
	public void insertar(Servicio servicio) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		if(servicio.getEstado() == null)
			servicio.setEstado("1");
		
		//2.ejecuta las operaciones
		em.persist(servicio);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Servicio servicio) throws Exception {
		
		try{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			
			if(servicio.getEstado() == null)
				servicio.setEstado("1");
			
			em.merge(servicio);
			em.flush();
			em.getTransaction().commit();
			em.close();
		}catch(Exception ex){
			System.out.println("ex: "+ex);
		}
	}

	@Override
	public void eliminar(Servicio servicio) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Servicio obj=(Servicio)em.find(Servicio.class,servicio.getIdServicio());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

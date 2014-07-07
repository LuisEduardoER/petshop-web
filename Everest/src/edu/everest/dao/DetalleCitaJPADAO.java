package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.Cita;
import edu.everest.entity.DetalleCita;

public class DetalleCitaJPADAO implements DetalleCitaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public DetalleCita obtenerDetalleCita(DetalleCita detalleCita)
			throws Exception {
		em=emf.createEntityManager();
		DetalleCita obj=(DetalleCita)em.find(DetalleCita.class,detalleCita.getId() );
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<DetalleCita> obtenerTodos(Cita cita) throws Exception {
		em=emf.createEntityManager();

		List<DetalleCita> listaDetalleCita = new ArrayList<DetalleCita>();
		Query query = em.createQuery( "SELECT o FROM DetalleCita o, Cita c "
									+ "WHERE o.cita.idCita = c.idCita "
									+ "AND c.idCita = :idCita " );
		query.setParameter("idCita", cita.getIdCita());
		
		List l =  query.getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			DetalleCita entidad = (DetalleCita)l.get(i);
			listaDetalleCita.add(entidad);
		}
		em.close();
		return listaDetalleCita;
	}

	@Override
	public void insertar(DetalleCita detalleCita) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
				
		//2.ejecuta las operaciones
		em.persist( detalleCita );
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(DetalleCita detalleCita) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(detalleCita);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(DetalleCita detalleCita) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		DetalleCita obj=(DetalleCita)em.find( DetalleCita.class,detalleCita.getId() );
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

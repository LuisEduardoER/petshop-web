package edu.everest.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.Cita;

public class CitaJPADAO implements CitaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Cita obtenerCita(Cita cita) throws Exception {
		em=emf.createEntityManager();
		Cita obj=(Cita)em.find(Cita.class,cita.getIdCita());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Cita> obtenerTodos(Calendar objIni, Calendar objFin) throws Exception {
		em=emf.createEntityManager();
		
		List<Cita> listaCita = new ArrayList<Cita>();		
		Query query = em.createQuery( "SELECT c FROM Cita c "
				+ "WHERE c.fecProg BETWEEN :fecProgIni AND :fecProgFin "
				+ "AND c.hourProg BETWEEN :hourProgIni AND :hourProgFin "
				+ "ORDER BY c.fecProg, c.hourProg " );
		
		query.setParameter("fecProgIni", objIni);
		query.setParameter("fecProgFin", objFin);
		
		query.setParameter("hourProgIni", objIni);
		query.setParameter("hourProgFin", objFin);
		
		List l =  query.getResultList();
		
		for ( int i=0; i < l.size(); i++ ) {
			Cita entidad = (Cita)l.get(i);
			listaCita.add(entidad);
		}
		em.close();
		return listaCita;
	}

	@Override
	public void insertar(Cita cita) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Cita entidadCita=new Cita();
		
//		entidadCita.setTipoDocumento(cita.getTipoDocumento());
//		entidadCita.setUsuario(cita.getUsuario());
		
		if(cita.getEstado() == null)
			entidadCita.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadCita);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Cita cita) throws Exception {
		try{
			
			em=emf.createEntityManager();
			em.getTransaction().begin();
			
			if(cita.getEstado() == null)
				cita.setEstado("1");
			
			em.merge(cita);
			em.flush();
			em.getTransaction().commit();
			em.close();
			}catch(Exception ex){
				System.out.println("ex: "+ex);
			}
	}

	@Override
	public void eliminar(Cita cita) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Cita obj=(Cita)em.find(Cita.class,cita.getIdCita());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	
}

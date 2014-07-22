package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Turno;
import edu.everest.entity.Turno;

public class TurnoJPADAO implements TurnoDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Turno obtenerTurno(Turno turno) throws Exception {
		em=emf.createEntityManager();
		Turno obj=(Turno)em.find(Turno.class,turno.getIdTurno());
		return obj;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List<Turno> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Turno> listaTurno = new ArrayList<Turno>();
		List l =  em.createQuery( "SELECT c FROM Turno c ORDER BY c.idTurno" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Turno entidad = (Turno)l.get(i);
			listaTurno.add(entidad);
		}
		em.close();
		return listaTurno;
	}

	@Override
	public void insertar(Turno turno) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Turno entidadTurno=new Turno();
		
		entidadTurno.setNomTurno(turno.getNomTurno());
		
				
		//2.ejecuta las operaciones
		em.persist(entidadTurno);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void actualizar(Turno turno) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		
		
		em.merge(turno);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(Turno turno) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Turno obj=(Turno)em.find(Turno.class,turno.getIdTurno());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

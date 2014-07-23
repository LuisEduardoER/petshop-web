package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Medico;
import edu.everest.entity.Medico;

public class MedicoJPADAO implements MedicoDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public Medico obtenerMedico(Medico medico) throws Exception {
		em=emf.createEntityManager();
		Medico obj=(Medico)em.find(Medico.class,medico.getIdMedico());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Medico> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Medico> listaMedico = new ArrayList<Medico>();
		List l =  em.createQuery( "SELECT c FROM Medico c ORDER BY c.idMedico" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Medico entidad = (Medico)l.get(i);
			listaMedico.add(entidad);
		}
		em.close();
		return listaMedico;
	}

	@Override
	public void insertar(Medico medico) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		//2.ejecuta las operaciones
		em.persist(medico);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void actualizar(Medico medico) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(medico);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(Medico medico) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Medico obj=(Medico)em.find(Medico.class,medico.getIdMedico());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

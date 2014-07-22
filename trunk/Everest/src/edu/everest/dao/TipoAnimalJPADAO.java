package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.TipoAnimal;

public class TipoAnimalJPADAO implements TipoAnimalDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public TipoAnimal obtenerTipoAnimal(TipoAnimal tipoAnimal) throws Exception {
		em=emf.createEntityManager();
		TipoAnimal obj=(TipoAnimal)em.find(TipoAnimal.class,tipoAnimal.getIdTipoAnimal());
		return obj;
	}

	@Override
	public List<TipoAnimal> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<TipoAnimal> listaTipoAnimal = new ArrayList<TipoAnimal>();
		List l =  em.createQuery( "SELECT c FROM TipoAnimal c ORDER BY c.idTipoAnimal" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			TipoAnimal entidad = (TipoAnimal)l.get(i);
			listaTipoAnimal.add(entidad);
		}
		em.close();
		return listaTipoAnimal;
	}

	@Override
	public void insertar(TipoAnimal tipoAnimal) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
				
		//2.ejecuta las operaciones
		em.persist(tipoAnimal);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(TipoAnimal tipoAnimal) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(tipoAnimal.getEstado() == null)
			tipoAnimal.setEstado("1");
		
		em.merge(tipoAnimal);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(TipoAnimal tipoAnimal) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		TipoAnimal obj=(TipoAnimal)em.find(TipoAnimal.class,tipoAnimal.getIdTipoAnimal());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

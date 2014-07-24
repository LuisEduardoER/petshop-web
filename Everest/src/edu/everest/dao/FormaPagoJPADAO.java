package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.FormaPago;
import edu.everest.entity.FormaPago;

public class FormaPagoJPADAO implements FormaPagoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	
	@Override
	public FormaPago obtenerFormaPago(FormaPago formaPago) throws Exception {
		em=emf.createEntityManager();
		FormaPago obj=(FormaPago)em.find(FormaPago.class,formaPago.getIdFormaPago());
		return obj;
	}

	@Override
	public List<FormaPago> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<FormaPago> listaFormaPago = new ArrayList<FormaPago>();
		List l =  em.createQuery( "SELECT c FROM FormaPago c ORDER BY c.idFormaPago" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			FormaPago entidad = (FormaPago)l.get(i);
			listaFormaPago.add(entidad);
		}
		em.close();
		return listaFormaPago;
	}

	@Override
	public void insertar(FormaPago formaPago) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
						
		//2.ejecuta las operaciones
		em.persist(formaPago);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void actualizar(FormaPago formaPago) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
			
		em.merge(formaPago);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(FormaPago formaPago) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		FormaPago obj=(FormaPago)em.find(FormaPago.class,formaPago.getIdFormaPago());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

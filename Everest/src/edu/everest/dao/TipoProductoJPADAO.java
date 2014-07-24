package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.TipoProducto;

public class TipoProductoJPADAO implements TipoProductoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	@Override
	public TipoProducto obtenerTipoProducto(TipoProducto tipoProducto) throws Exception {
	em=emf.createEntityManager();
	TipoProducto obj=(TipoProducto)em.find(TipoProducto.class,tipoProducto.getIdTipoProducto());
	return obj;
	}

	@Override
	public List<TipoProducto> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<TipoProducto> listaTipoProducto = new ArrayList<TipoProducto>();
		List l =  em.createQuery( "SELECT c FROM TipoProducto c ORDER BY c.idTipoProducto" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			TipoProducto entidad = (TipoProducto)l.get(i);
			listaTipoProducto.add(entidad);
		}
		em.close();
		return listaTipoProducto;
	}

	@Override
	public void insertar(TipoProducto tipoProducto) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		//2.ejecuta las operaciones
		em.persist(tipoProducto);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	

	@Override
	public void actualizar(TipoProducto tipoProducto) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(tipoProducto);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(TipoProducto tipoProducto) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		TipoProducto obj=(TipoProducto)em.find(TipoProducto.class,tipoProducto.getIdTipoProducto());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

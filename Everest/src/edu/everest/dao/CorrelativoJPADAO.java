package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Correlativo;
import edu.everest.entity.Correlativo;

public class CorrelativoJPADAO implements CorrelativoDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Correlativo obtenerCorrelativo(Correlativo correl) throws Exception {
		em=emf.createEntityManager();
		Correlativo obj=(Correlativo)em.find(Correlativo.class,correl.getIdCorrelativo());
		return obj;
	}

	@Override
	public List<Correlativo> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Correlativo> listaCorrelativo = new ArrayList<Correlativo>();
		List l =  em.createQuery( "SELECT c FROM Correlativo c ORDER BY c.idCorrelativo" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Correlativo entidad = (Correlativo)l.get(i);
			listaCorrelativo.add(entidad);
		}
		em.close();
		return listaCorrelativo;
	}

	@Override
	public void insertar(Correlativo correl) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Correlativo entidadCorrelativo=new Correlativo();
		
		entidadCorrelativo.setTabla(correl.getTabla());
		entidadCorrelativo.setValor(correl.getValor());
		
		if(correl.getIdCorrelativo() == 0)
			correl.setIdCorrelativo(1);
				
		//2.ejecuta las operaciones
		em.persist(entidadCorrelativo);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void actualizar(Correlativo correl) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(correl.getIdCorrelativo() == 0)
			correl.setIdCorrelativo(1);
		
		em.merge(correl);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void eliminar(Correlativo correl) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Correlativo obj=(Correlativo)em.find(Correlativo.class,correl.getIdCorrelativo());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

}

package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.TipoDocumento;

public class TipoDocumentoJPADAO implements TipoDocumentoDAO{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public TipoDocumento obtenerTipoDocumento(TipoDocumento tipoDocumento)
			throws Exception {
		em=emf.createEntityManager();
		TipoDocumento obj=(TipoDocumento)em.find(TipoDocumento.class,tipoDocumento.getIdTipoDocumento());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<TipoDocumento> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<TipoDocumento> listaTipoDocumento = new ArrayList<TipoDocumento>();
		List l =  em.createQuery( "SELECT t FROM TipoDocumento t ORDER BY t.idTipoDocumento" ).getResultList();		
		for ( int i=0; i < l.size(); i++ ) {
			TipoDocumento entidad = (TipoDocumento)l.get(i);
			listaTipoDocumento.add(entidad);
		}
		em.close();
		return listaTipoDocumento;
	}

	@Override
	public void insertar(TipoDocumento tipoDocumento) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		TipoDocumento entidadTipoDocumento=new TipoDocumento();
		
		entidadTipoDocumento.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
		entidadTipoDocumento.setDescripcion(tipoDocumento.getDescripcion());
		entidadTipoDocumento.setEstado(tipoDocumento.getEstado());
				
		if(tipoDocumento.getEstado() == null)
			entidadTipoDocumento.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadTipoDocumento);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(TipoDocumento tipoDocumento) throws Exception {
		try{
			
			em=emf.createEntityManager();
			em.getTransaction().begin();
			
			if(tipoDocumento.getEstado() == null)
				tipoDocumento.setEstado("1");
			
			em.merge(tipoDocumento);
			em.flush();
			em.getTransaction().commit();
			em.close();
			}catch(Exception ex){
				System.out.println("ex: "+ex);
			}
	}

	@Override
	public void eliminar(TipoDocumento tipoDocumento) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		TipoDocumento obj=(TipoDocumento)em.find(TipoDocumento.class,tipoDocumento.getIdTipoDocumento());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

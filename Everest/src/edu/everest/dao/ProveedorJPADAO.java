package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Proveedor;

public class ProveedorJPADAO implements ProveedorDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	

	@Override
	public Proveedor obtenerProveedor(Proveedor proveedor) throws Exception {
		em=emf.createEntityManager();
		Proveedor obj=(Proveedor)em.find(Proveedor.class,proveedor.getIdProveedor());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Proveedor> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		List l =  em.createQuery( "SELECT c FROM Proveedor c ORDER BY c.idProveedor" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Proveedor entidad = (Proveedor)l.get(i);
			proveedores.add(entidad);
		}
		em.close();
		return proveedores;
	}

	@Override
	public void insertar(Proveedor proveedor) throws Exception {
		System.out.println("insertarProveedor");
		
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Proveedor entidadProveedor=new Proveedor();
		
		entidadProveedor.setRuc(proveedor.getRuc());
		entidadProveedor.setRazonSocial(proveedor.getRazonSocial());
		entidadProveedor.setDireccion(proveedor.getDireccion());
		
		if(proveedor.getEstado() == null)
			entidadProveedor.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadProveedor);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Proveedor proveedor) throws Exception {
		System.out.println("actualizarProveedor");
		
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(proveedor.getEstado() == null)
			proveedor.setEstado("1");
		
		em.merge(proveedor);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Proveedor proveedor) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Proveedor obj=(Proveedor)em.find(Proveedor.class,proveedor.getIdProveedor());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

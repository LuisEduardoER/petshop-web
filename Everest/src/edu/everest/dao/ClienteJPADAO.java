package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import edu.everest.entity.Cliente;
import edu.everest.entity.Usuario;

public class ClienteJPADAO implements ClienteDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public Cliente obtenerCliente(Cliente cliente) throws Exception {
		em=emf.createEntityManager();
		Cliente obj = null;
		
		if(cliente.getIdCliente() != 0)
			obj=(Cliente)em.find(Cliente.class,cliente.getIdCliente());
		else if(cliente.getDni() != null){
			
			Query query = em.createQuery( "SELECT c FROM Cliente c WHERE c.documento = :documento" );
			
			query.setParameter("documento", cliente.getDni());
			
			obj=(Cliente) query.getSingleResult();
			
		}	
		
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Cliente> obtenerTodos() throws Exception {
		em=emf.createEntityManager();
		String strQuery;
		
		List<Cliente> listaCliente = new ArrayList<Cliente>();
//		strQuery= "SELECT "+
//				"c.idCliente, "+
////				"u.idUsuario, " +
//				"c.idDIstrito, c.documento, c.nombres, c.apePat, "+
//				"c.apeMat, c.sexo, c.fecNac, c.email, c.telefono, c.celular, "+
//				"c.direccion, c.estado "+
//				"FROM Cliente c " +
////				"INNER JOIN c.tipoDocumento td "+
////				"INNER JOIN c.usuario u "+
//				"WHERE c.estado = :estado ORDER BY c.idCliente ";
		
		strQuery = "SELECT c FROM Cliente c "+ 
				"WHERE c.estado = :estado ORDER BY c.idCliente ";
		
		Query query = em.createQuery( strQuery );
		query.setParameter("estado", "1");
		List l =  query.getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Cliente entidad = (Cliente)l.get(i);
			listaCliente.add(entidad);
		}
		em.close();
		return listaCliente;
	}

	@Override
	public void insertar(Cliente cliente) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Cliente entidadCliente=new Cliente();
		
		entidadCliente.setUsuario(cliente.getUsuario());
		
		entidadCliente.setIdDIstrito(cliente.getIdDIstrito());
		entidadCliente.setDni(cliente.getDni());
		entidadCliente.setNombres(cliente.getNombres());
		entidadCliente.setApePat(cliente.getApePat());
		entidadCliente.setApeMat(cliente.getApeMat());
		entidadCliente.setSexo(cliente.getSexo());
		entidadCliente.setFecNac(cliente.getFecNac());
		entidadCliente.setEmail(cliente.getEmail());
		entidadCliente.setTelefono(cliente.getTelefono());
		entidadCliente.setCelular(cliente.getCelular());
		entidadCliente.setDireccion(cliente.getDireccion());
		
		if(cliente.getEstado() == null)
			entidadCliente.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadCliente);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Cliente cliente) throws Exception {
		try{
		
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(cliente.getEstado() == null)
			cliente.setEstado("1");
		
		em.merge(cliente);
		em.flush();
		em.getTransaction().commit();
		em.close();
		}catch(Exception ex){
			System.out.println("ex: "+ex);
		}
	}

	@Override
	public void eliminar(Cliente cliente) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente obj=(Cliente)em.find(Cliente.class,cliente.getIdCliente());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Cliente obtenerClienteByUsuario(Usuario usuario) throws Exception {
		em=emf.createEntityManager();
		Cliente obj=(Cliente)em.find(Cliente.class,usuario.getIdUsuario());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Cliente> obtenerFamliares(Cliente cliente) throws Exception {
		em=emf.createEntityManager();

		List<Cliente> listaCliente = new ArrayList<Cliente>();
		Query query = em.createQuery( "SELECT c FROM Cliente o "
									+ "where c.cliente = :cliente ");
		query.setParameter("cliente", cliente);
		
		List l =  query.getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Cliente entidad = (Cliente)l.get(i);
			listaCliente.add(entidad);
		}
		em.close();
		return listaCliente;
	}

}

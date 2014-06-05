package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
		Cliente obj=(Cliente)em.find(Cliente.class,cliente.getIdCliente());
		return obj;
	}

	@Override
	public List<Cliente> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Cliente> listaCliente = new ArrayList<Cliente>();
		List l =  em.createQuery( "SELECT c FROM Cliente c ORDER BY c.idCliente" ).getResultList();
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
		
		entidadCliente.setTipoDocumento(cliente.getTipoDocumento());
		entidadCliente.setUsuario(cliente.getUsuario());
		
		entidadCliente.setIdDIstrito(cliente.getIdDIstrito());
		entidadCliente.setDocumento(cliente.getDocumento());
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
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(cliente.getEstado() == null)
			cliente.setEstado("1");
		
		em.merge(cliente);
		em.flush();
		em.getTransaction().commit();
		em.close();
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

}

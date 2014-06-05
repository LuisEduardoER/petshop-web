package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Usuario;

public class UsuarioJPADAO implements UsuarioDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}
	
	@Override
	public int validarUsuario(Usuario usuario) throws Exception {
		em=emf.createEntityManager();

		int nCount = 0;		
		Query query = em.createQuery("SELECT FUNC('IFNULL', c.idUsuario, 0) FROM Usuario c where c.user = :user and c.pass = :pass");
		query.setParameter("user", usuario.getUser());
		query.setParameter("pass", usuario.getPass());
		nCount = (int)query.getSingleResult();
		
		em.close();
		return nCount;
	}

	@Override
	public Usuario obtenerUsuario(Usuario usuario) throws Exception {
		em=emf.createEntityManager();
		Usuario obj=(Usuario)em.find(Usuario.class,usuario.getIdUsuario());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Usuario> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		List l =  em.createQuery( "SELECT c FROM Usuario c ORDER BY c.idUsuario" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Usuario entidad = (Usuario)l.get(i);
			listaUsuario.add(entidad);
		}
		em.close();
		return listaUsuario;
	}

	@Override
	public void insertar(Usuario usuario) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Usuario entidadUsuario=new Usuario();
		
		entidadUsuario.setRol(usuario.getRol());
		
		entidadUsuario.setUser(usuario.getUser());
		entidadUsuario.setPass(usuario.getPass());
		
		if(usuario.getEstado() == null)
			entidadUsuario.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadUsuario);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Usuario usuario) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		if(usuario.getEstado() == null)
			usuario.setEstado("1");
		
		em.merge(usuario);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Usuario usuario) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario obj=(Usuario)em.find(Usuario.class,usuario.getIdUsuario());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}

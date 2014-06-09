package edu.everest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import edu.everest.entity.Mascota;

public class MascotaJPADAO implements MascotaDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void setEntityManagerFactory(EntityManagerFactory emf ) {
		this.emf = emf;
	}

	@Override
	public Mascota obtenerMascota(Mascota mascota) throws Exception {
		em=emf.createEntityManager();
		Mascota obj=(Mascota)em.find(Mascota.class,mascota.getIdMascota());
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Mascota> obtenerTodos() throws Exception {
		em=emf.createEntityManager();

		List<Mascota> listaMascota = new ArrayList<Mascota>();
		List l =  em.createQuery( "SELECT c FROM Mascota c ORDER BY c.idMascota" ).getResultList();
		for ( int i=0; i < l.size(); i++ ) {
			Mascota entidad = (Mascota)l.get(i);
			listaMascota.add(entidad);
		}
		em.close();
		return listaMascota;
	}

	@Override
	public void insertar(Mascota mascota) throws Exception {
		em=emf.createEntityManager();

		//1.inicia la transacción
		em.getTransaction().begin();
		
		Mascota entidadMascota=new Mascota();
		entidadMascota.setCliente(mascota.getCliente());
		
		entidadMascota.setNombre(mascota.getNombre());
		entidadMascota.setEdad(mascota.getEdad());
		entidadMascota.setIdAnimal(mascota.getIdAnimal());
		entidadMascota.setRaza(mascota.getRaza());
		entidadMascota.setFecNac(mascota.getFecNac());
		entidadMascota.setSexo(mascota.getSexo());
		entidadMascota.setPedigree(mascota.getPedigree());
		entidadMascota.setEsterilizacion(mascota.getEsterilizacion());
		entidadMascota.setObservaciones(mascota.getObservaciones());
		
		//if(mascota.getEstado() == null)
		//	entidadMascota.setEstado("1");
				
		//2.ejecuta las operaciones
		em.persist(entidadMascota);
		em.flush();
		
		//3.ejecuta commit a la transacción
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void actualizar(Mascota mascota) throws Exception {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Mascota obj=(Mascota)em.find(Mascota.class,mascota.getIdMascota());
		em.remove(obj);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Mascota mascota) throws Exception {
		// TODO Auto-generated method stub

	}

}

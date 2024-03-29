package edu.everest.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.struts2.ServletActionContext;

import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;
import edu.everest.util.Constants;

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
	public List<Mascota> obtenerTodos(Cliente cliente) throws Exception {
		em=emf.createEntityManager();

		List<Mascota> listaMascota = new ArrayList<Mascota>();
//		em.createQuery( "SELECT c FROM Mascota c ORDER BY c.idMascota" ).getResultList();
		Query query = em.createQuery("SELECT m FROM Mascota m "
								   + "INNER JOIN m.cliente c "
								   + "WHERE c.idCliente = :idCliente "
								   + "ORDER BY m.idMascota");
		query.setParameter("idCliente", cliente.getIdCliente() );
		List l = query.getResultList();
		
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
		entidadMascota.setTipoAnimal(mascota.getTipoAnimal());
		entidadMascota.setRaza(mascota.getRaza());
		entidadMascota.setFecNac(mascota.getFecNac());
		entidadMascota.setSexo(mascota.getSexo());
		entidadMascota.setPedigree(mascota.getPedigree());
		entidadMascota.setEsterilizacion(mascota.getEsterilizacion());
		entidadMascota.setObservaciones(mascota.getObservaciones());
		
		//Validamos que se haya seleccionado una foto
		if(mascota.getFoto() != null){
			
			//lectura del objeto binario
			InputStream temp = new FileInputStream(mascota.getFoto());
			byte[] fotoBinary = new byte[temp.available()];
			
			temp.read(fotoBinary);
			temp.close();
							
			//Asignamos los bytes al objeto cliente
			mascota.setFotobin(fotoBinary);
			
			entidadMascota.setFotobin(mascota.getFotobin());
			
		}else{
			String ruta = ServletActionContext.getServletContext().getRealPath(Constants.KV_IMG_PET_DEFAULT);
			
			File archivo = new File (ruta);
			
			System.out.println("-- Archivo:	"+archivo.getPath()+" --");			
			InputStream temp = new FileInputStream(archivo);
			
//			InputStream temp = new FileInputStream();
			byte[] fotoBinary = new byte[temp.available()];
			
			temp.read(fotoBinary);
			temp.close();
							
			//Asignamos los bytes al objeto cliente
			mascota.setFotobin(fotoBinary);
			
			entidadMascota.setFotobin(mascota.getFotobin());
		}
		
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
						
		//Validamos que se haya seleccionado una foto
		if(mascota.getFoto() != null){
			
			//lectura del objeto binario
			InputStream temp = new FileInputStream(mascota.getFoto());
			byte[] fotoBinary = new byte[temp.available()];
			
			temp.read(fotoBinary);
			temp.close();
							
			//Asignamos los bytes al objeto cliente
			mascota.setFotobin(fotoBinary);
			
		}		
		
		Mascota obj=(Mascota)em.find(Mascota.class,mascota.getIdMascota());
		
		//Para evitar que la imagen actualize en nulo
		if(mascota.getFoto() == null)
			mascota.setFotobin(obj.getFotobin());
		
		em.merge(mascota);
		
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(Mascota mascota) throws Exception {
		// TODO Auto-generated method stub

	}

}

package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;

public interface MascotaDAO {
	
	public Mascota obtenerMascota(Mascota mascota) throws Exception;
	public List<Mascota> obtenerTodos(Cliente cliente) throws Exception;
	public void insertar(Mascota mascota) throws Exception;
	public void actualizar(Mascota mascota) throws Exception;
	public void eliminar(Mascota mascota) throws Exception;
	
}

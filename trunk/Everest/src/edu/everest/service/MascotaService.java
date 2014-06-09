package edu.everest.service;

import java.util.List;

import edu.everest.entity.Mascota;

public interface MascotaService {
	
	public List<Mascota> obtenerTodosMascota() throws Exception;
	public void insertarMascota(Mascota mascota) throws Exception;
	public void actualizarMascota(Mascota mascota) throws Exception;
	public void eliminarMascota(Mascota mascota) throws Exception;
	public Mascota obtenerMascota(Mascota mascota) throws Exception;

}

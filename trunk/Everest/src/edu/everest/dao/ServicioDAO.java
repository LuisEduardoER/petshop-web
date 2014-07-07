package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Servicio;

public interface ServicioDAO {

	public Servicio obtenerServicio(Servicio servicio) throws Exception;
	
	public List<Servicio> obtenerTodos() throws Exception;
	public void insertar(Servicio servicio) throws Exception;
	public void actualizar(Servicio servicio) throws Exception;
	public void eliminar(Servicio servicio) throws Exception;
	
}

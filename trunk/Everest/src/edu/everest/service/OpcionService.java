package edu.everest.service;

import java.util.List;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;

public interface OpcionService {
	
	public List<Opcion> obtenerTodosOpcion() throws Exception;
	public List<Opcion> obtenerOpcionParentByRol(Rol rol) throws Exception;
	public List<Opcion> obtenerOpcionByParent(Opcion opcion) throws Exception;
	
	public void insertarOpcion(Opcion opcion) throws Exception;
	public void actualizarOpcion(Opcion opcion) throws Exception;
	public void eliminarOpcion(Opcion opcion) throws Exception;
	public Opcion obtenerOpcion(Opcion opcion) throws Exception;
	
}

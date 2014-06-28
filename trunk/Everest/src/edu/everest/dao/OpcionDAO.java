package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;

public interface OpcionDAO {
	
	public Opcion obtenerOpcion(Opcion opcion) throws Exception;
	public List<Opcion> obtenerOpcionParentByRol(Rol rol) throws Exception;
	public List<Opcion> obtenerOpcionParents() throws Exception;
	public List<Opcion> obtenerOpcionByParent(Opcion opcion) throws Exception;
	
	public List<Opcion> obtenerTodos() throws Exception;
	public void insertar(Opcion opcion) throws Exception;
	public void actualizar(Opcion opcion) throws Exception;
	public void eliminar(Opcion opcion) throws Exception;
	
}

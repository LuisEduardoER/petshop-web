package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Rol;

public interface RolDAO {
	
	public Rol obtenerRol(Rol rol) throws Exception;
	public List<Rol> obtenerTodos() throws Exception;
	public void insertar(Rol rol) throws Exception;
	public void actualizar(Rol rol) throws Exception;
	public void eliminar(Rol rol) throws Exception;
	
}

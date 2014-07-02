package edu.everest.dao;

import java.util.List;

import edu.everest.entity.RolOpcion;

public interface RolOpcionDAO {
	
	public RolOpcion obtenerRolOpcion(RolOpcion rolOpcion) throws Exception;
	public List<RolOpcion> obtenerTodos() throws Exception;
	public void insertar(RolOpcion rolOpcion) throws Exception;
	public void actualizar(RolOpcion rolOpcion) throws Exception;
	public void eliminar(RolOpcion rolOpcion) throws Exception;
	
}

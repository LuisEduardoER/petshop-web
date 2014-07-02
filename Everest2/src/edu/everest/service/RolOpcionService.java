package edu.everest.service;

import java.util.List;

import edu.everest.entity.RolOpcion;

public interface RolOpcionService {
	
	public List<RolOpcion> obtenerTodosRolOpcion() throws Exception;
	public void insertarRolOpcion(RolOpcion rolOpcion) throws Exception;
	public void actualizarRolOpcion(RolOpcion rolOpcion) throws Exception;
	public void eliminarRolOpcion(RolOpcion rolOpcion) throws Exception;
	public RolOpcion obtenerRolOpcion(RolOpcion rolOpcion) throws Exception;

}

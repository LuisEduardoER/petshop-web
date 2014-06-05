package edu.everest.service;

import java.util.List;

import edu.everest.entity.Rol;

public interface RolService {
	
	public List<Rol> obtenerTodosRol() throws Exception;
	public void insertarRol(Rol rol) throws Exception;
	public void actualizarRol(Rol rol) throws Exception;
	public void eliminarRol(Rol rol) throws Exception;
	public Rol obtenerRol(Rol rol) throws Exception;
	
}

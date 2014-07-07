package edu.everest.service;

import java.util.List;

import edu.everest.entity.Servicio;

public interface ServicioService {
	
public Servicio obtenerServicio(Servicio servicio) throws Exception;
	
	public List<Servicio> obtenerTodos() throws Exception;
	public void insertarCliente(Servicio servicio) throws Exception;
	public void actualizarCliente(Servicio servicio) throws Exception;
	public void eliminarCliente(Servicio servicio) throws Exception;
	
}

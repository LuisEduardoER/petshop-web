package edu.everest.service;

import java.util.List;

import edu.everest.entity.Cita;

public interface CitaService {
	
	public Cita obtenerCita(Cita cita) throws Exception;
	
	public List<Cita> obtenerTodosCliente() throws Exception;
	public void insertarCliente(Cita cita) throws Exception;
	public void actualizarCliente(Cita cita) throws Exception;
	public void eliminarCliente(Cita cita) throws Exception;
	
}

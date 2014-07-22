package edu.everest.service;

import java.util.List;

import edu.everest.entity.Local;

public interface LocalService {

	public List<Local> obtenerTodosLocal() throws Exception;
	public void insertarLocal(Local local) throws Exception;
	public void actualizarLocal(Local local) throws Exception;
	public void eliminarLocal(Local local) throws Exception;
	public Local obtenerLocal(Local local) throws Exception;
}

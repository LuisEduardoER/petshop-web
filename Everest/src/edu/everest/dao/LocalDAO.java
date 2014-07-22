package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Local;

public interface LocalDAO {
	public Local obtenerLocal(Local local) throws Exception;
	public List<Local> obtenerTodos() throws Exception;
	public void insertar(Local local) throws Exception;
	public void actualizar(Local local) throws Exception;
	public void eliminar(Local local) throws Exception;
}

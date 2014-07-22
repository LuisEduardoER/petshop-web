package edu.everest.dao;

import java.util.List;

import edu.everest.entity.TipoAnimal;

public interface TipoAnimalDAO {

	public TipoAnimal obtenerTipoAnimal(TipoAnimal tipoAnimal) throws Exception;
	public List<TipoAnimal> obtenerTodos() throws Exception;
	public void insertar(TipoAnimal tipoAnimal) throws Exception;
	public void actualizar(TipoAnimal tipoAnimal) throws Exception;
	public void eliminar(TipoAnimal tipoAnimal) throws Exception;
	
}

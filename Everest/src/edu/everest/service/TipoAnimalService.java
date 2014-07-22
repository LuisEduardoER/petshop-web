package edu.everest.service;

import java.util.List;

import edu.everest.entity.TipoAnimal;

public interface TipoAnimalService {
	
	public List<TipoAnimal> obtenerTodosTipoAnimal() throws Exception;
	public void insertarTipoAnimal(TipoAnimal tipoAnimal) throws Exception;
	public void actualizarTipoAnimal(TipoAnimal tipoAnimal) throws Exception;
	public void eliminarTipoAnimal(TipoAnimal tipoAnimal) throws Exception;
	public TipoAnimal obtenerTipoAnimal(TipoAnimal tipoAnimal) throws Exception;
	
}

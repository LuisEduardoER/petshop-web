package com.veterinaria.Interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.TipoAnimal;

public interface ITipoAnimal {
	
	public abstract ArrayList<TipoAnimal> listarTipoAnimal() throws Exception;
	public abstract TipoAnimal obtenerTipoAnimal(TipoAnimal obj) throws Exception;
	public abstract String GrabarTipoAnimal(TipoAnimal obj) throws Exception;
	public abstract String ModificarTipoAnimal(TipoAnimal obj) throws Exception;
	public abstract String EliminarTipoAnimal(TipoAnimal obj) throws Exception;
	
}

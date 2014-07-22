package edu.everest.service;

import java.util.List;

import edu.everest.entity.Correlativo;

public interface CorrelativoService {
	
	public List<Correlativo> obtenerTodosCorrelativo() throws Exception;
	public void insertarCorrelativo(Correlativo correl) throws Exception;
	public void actualizarCorrelativo(Correlativo correl) throws Exception;
	public void eliminarCorrelativo(Correlativo correl) throws Exception;
	public Correlativo obtenerCorrelativo(Correlativo correl) throws Exception;

}

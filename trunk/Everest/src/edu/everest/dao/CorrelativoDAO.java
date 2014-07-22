package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Correlativo;

public interface CorrelativoDAO {
	
	public Correlativo obtenerCorrelativo(Correlativo correl) throws Exception;
	public List<Correlativo> obtenerTodos() throws Exception;
	public void insertar(Correlativo correl) throws Exception;
	public void actualizar(Correlativo correl) throws Exception;
	public void eliminar(Correlativo correl) throws Exception;

}

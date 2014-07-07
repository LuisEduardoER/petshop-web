package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Cita;
import edu.everest.entity.DetalleCita;

public interface DetalleCitaDAO {
	
	public DetalleCita obtenerDetalleCita(DetalleCita detalleCita) throws Exception;
	
	public List<DetalleCita> obtenerTodos(Cita cita) throws Exception;
	public void insertar(DetalleCita detalleCita) throws Exception;
	public void actualizar(DetalleCita detalleCita) throws Exception;
	public void eliminar(DetalleCita detalleCita) throws Exception;
	
}

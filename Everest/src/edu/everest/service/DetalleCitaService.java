package edu.everest.service;

import java.util.List;

import edu.everest.entity.Cita;
import edu.everest.entity.DetalleCita;

public interface DetalleCitaService {
	
	public List<DetalleCita> obtenerTodos(Cita cita) throws Exception;
	
	public void insertarDetalleCita(DetalleCita detalleCita) throws Exception;
	public void actualizarDetalleCita(DetalleCita detalleCita) throws Exception;
	public void eliminarDetalleCita(DetalleCita detalleCita) throws Exception;
	public DetalleCita obtenerDetalleCita(DetalleCita detalleCita) throws Exception;
	
}

package edu.everest.dao;

import java.util.Calendar;
import java.util.List;

import edu.everest.entity.Cita;

public interface CitaDAO {
	
	public Cita obtenerCita(Cita cita) throws Exception;
	
	public List<Cita> obtenerTodos(Calendar objIni, Calendar objFin) throws Exception;
	public void insertar(Cita cita) throws Exception;
	public void actualizar(Cita cita) throws Exception;
	public void eliminar(Cita cita) throws Exception;
	
}

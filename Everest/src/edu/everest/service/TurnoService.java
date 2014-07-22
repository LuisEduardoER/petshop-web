package edu.everest.service;

import java.util.List;

import edu.everest.entity.Turno;

public interface TurnoService {

	public List<Turno> obtenerTodosTurno() throws Exception;
	public void insertarTurno(Turno turno) throws Exception;
	public void actualizarTurno(Turno turno) throws Exception;
	public void eliminarTurno(Turno turno) throws Exception;
	public Turno obtenerTurno(Turno turno) throws Exception;
}

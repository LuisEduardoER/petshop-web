package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Turno;

public interface TurnoDAO {
	public Turno obtenerTurno(Turno turno) throws Exception;
	public List<Turno> obtenerTodos() throws Exception;
	public void insertar(Turno turno) throws Exception;
	public void actualizar(Turno turno) throws Exception;
	public void eliminar(Turno turno) throws Exception;
}

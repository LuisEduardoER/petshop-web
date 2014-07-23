package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Medico;

public interface MedicoDAO {
	public Medico obtenerMedico(Medico medico) throws Exception;
	public List<Medico> obtenerTodos() throws Exception;
	public void insertar(Medico medico) throws Exception;
	public void actualizar(Medico medico) throws Exception;
	public void eliminar(Medico medico) throws Exception;
	

}

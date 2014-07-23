package edu.everest.service;

import java.util.List;

import edu.everest.entity.Medico;

public interface MedicoService {
	
	public List<Medico> obtenerTodosMedico() throws Exception;
	public void insertarMedico(Medico medico) throws Exception;
	public void actualizarMedico(Medico medico) throws Exception;
	public void eliminarMedico(Medico medico) throws Exception;
	public Medico obtenerMedico(Medico medico) throws Exception;
	
}

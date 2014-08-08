package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Medico;

public interface IMedico {
	
	public abstract ArrayList<Medico> listarMedico() throws Exception;
	public abstract Medico obtenerMedico(Medico obj) throws Exception;
	public abstract String GrabarMedico(Medico obj) throws Exception;
	public abstract String ModificarMedico(Medico obj) throws Exception;
	public abstract String EliminarMedico(Medico obj) throws Exception;
	
}

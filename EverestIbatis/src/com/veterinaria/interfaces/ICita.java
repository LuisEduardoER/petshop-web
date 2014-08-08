package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Cita;

public interface ICita {
	
	public abstract ArrayList<Cita> listarCita() throws Exception;
	public abstract Cita obtenerCita(Cita obj) throws Exception;
	public abstract String GrabarCita(Cita obj) throws Exception;
	public abstract String ModificarCita(Cita obj) throws Exception;
	public abstract String EliminarCita(Cita obj) throws Exception;
	
}

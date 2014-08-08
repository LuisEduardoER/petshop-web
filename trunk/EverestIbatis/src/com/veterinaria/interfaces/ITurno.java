package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Turno;

public interface ITurno {
	public abstract ArrayList<Turno> listarTurno() throws Exception;
	public abstract Turno obtenerTurno(Turno obj) throws Exception;
	public abstract String GrabarTurno(Turno obj) throws Exception;
	public abstract String ModificarTurno(Turno obj) throws Exception;
	public abstract String EliminarTurno(Turno obj) throws Exception;
	
}

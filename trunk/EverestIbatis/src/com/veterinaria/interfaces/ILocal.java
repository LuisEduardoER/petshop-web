package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Local;

public interface ILocal {

	public abstract ArrayList<Local> listarLocal() throws Exception;
	public abstract Local obtenerLocal(Local obj) throws Exception;
	public abstract String GrabarLocal(Local obj) throws Exception;
	public abstract String ModificarLocal(Local obj) throws Exception;
	public abstract String EliminarLocal(Local obj) throws Exception;
	
}

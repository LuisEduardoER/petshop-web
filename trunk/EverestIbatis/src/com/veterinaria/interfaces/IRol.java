package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Rol;

public interface IRol {
	
	public abstract ArrayList<Rol> listarRol() throws Exception;
	public abstract Rol obtenerRol(Rol obj) throws Exception;
	public abstract String GrabarRol(Rol obj) throws Exception;
	public abstract String ModificarRol(Rol obj) throws Exception;
	public abstract String EliminarRol(Rol obj) throws Exception;
	
}

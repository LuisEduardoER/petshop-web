package com.veterinaria.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Rol;

public interface IOpcion {
	
	public abstract ArrayList<Opcion> listarOpcion() throws Exception;
	public abstract Opcion obtenerOpcion(Opcion obj) throws Exception;
	public abstract String GrabarOpcion(Opcion obj) throws Exception;
	public abstract String ModificarOpcion(Opcion obj) throws Exception;
	public abstract String EliminarOpcion(Opcion obj) throws Exception;
	
	public abstract List<Opcion> obtenerOpcionParentByRol(Rol obj) throws Exception;
	public abstract List<Opcion> obtenerOpcionByParent(Opcion obj) throws Exception;
	public abstract ArrayList<Opcion> listarParentOpcion() throws Exception;
	
}
